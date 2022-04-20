package com.example.helloworld;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.databinding.UserInfoBinding;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Session;

public class ModifyInfo extends AppCompatActivity {
    private Session session;
    private EditText car;
    private EditText telephone;
    private UserInfoBinding binding;
    private Button changeInfo;
    private EditText passwordA;
    private EditText passwordB;
    private Button changePwd;
    private ActivityCollectUtil activityCollectUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.user_info);//效果和使用binding一样
        binding = UserInfoBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();
        setContentView(root);

        activityCollectUtil = new ActivityCollectUtil();
        activityCollectUtil.addActivity(this);//汇集栈中所有的activity，便于logout时全部destroy

        car = binding.userInfoCar;//获取页面组件
        telephone = binding.userInfoTel;
        session = new Session();
        car.setText(session.getCar());
        telephone.setText(session.getTel());

        changeInfo = binding.userInfoConfirm;//更改用户信息的确认按钮
        changeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputTel = telephone.getText().toString();
                String inputCar = car.getText().toString();

                if(checkTel(inputTel) && checkCar(inputCar)){//如果telephone和car的格式正确
                    Customer customer = new Customer();//用于修改用户信息
                    customer.setTelephone(inputTel);
                    customer.setCar(inputCar);
                    customer.updateAll("userID = ?",session.getUserID());//更新userID为目前登录用户的tel和car

                    session.setCar(inputCar);//设置更改后的session
                    session.setTel(inputTel);
                    Toast.makeText(ModifyInfo.this, "Modification succeed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        changePwd = binding.userPwdConfirm;
        changePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordA = binding.userInfoChangePwd1;
                passwordB = binding.userInfoChangePwd2;
                String pwd1 = passwordA.getText().toString();
                String pwd2 = passwordB.getText().toString();

                if(pwd1.length() != 0 && pwd2.length() != 0){//两个均不为空
                    if(pwd1.equals(pwd2)){//两个一致
                        if(CheckPsw(pwd1)){//是否符合格式要求

                            Customer customer = new Customer();//用于修改用户密码
                            customer.setPwd(pwd1);
                            customer.updateAll("userID = ?",session.getUserID());//更新数据库

                            session.setPwd(pwd1);//设置更改后的session
                            Toast.makeText(ModifyInfo.this, "Password change successful", Toast.LENGTH_SHORT).show();
                            //这里似乎还需要
                            // 修改sharedPreference文件


                        }

                    }else{
                        Toast.makeText(ModifyInfo.this,"Your two passwords are inconsistent!",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ModifyInfo.this,"Your new passwords can't be null!",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


    protected boolean checkTel(String tel){
        boolean flag =false;//to identify whether the Telephone Conform to format
        if(tel.length() != 0){

            if(tel.length() == 11){
                for(int i=0; i<11; i++){
                    if(!Character.isDigit(tel.charAt(i))){
                        Toast.makeText(ModifyInfo.this, "Your Telephone is not all numbers!", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }
                flag =true;
            }else{
                Toast.makeText(ModifyInfo.this, "Your Telephone is not 11 digits!", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(ModifyInfo.this, "Your Telephone can not be null!", Toast.LENGTH_SHORT).show();
        }
        return flag;
    }

    protected Boolean checkCar(String car){
        if(car == null || car.length() == 0){//为了避免对空字符串使用length()导致抛出exception
            Toast.makeText(ModifyInfo.this,"Your plate number can not be null!",Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }
    }

    protected boolean CheckPsw(String pswA){//用于检测密码格式是否符合8到20位且含有字母

        boolean isDigit = false;//Boolean is used to determine whether the password contains numbers
        boolean isLetter = false;//Boolean is used to determine whether the password contains letters
        boolean isPswRight = true;//Used to record whether the password format is correct

        for(int i =0; i < pswA.length(); i++) {
            if(Character.isDigit(pswA.charAt(i))) {
                isDigit = true;
            } else if(Character.isLetter(pswA.charAt(i))) {
                isLetter = true;
            }
        }
        String regex = "^[a-zA-Z0-9]{8,20}$";
        isPswRight = isDigit && isLetter && pswA.matches(regex);//isPswRight is boolean, Represents whether the password is in the correct format

        if(isPswRight){
            return true;
        }else{
            Toast.makeText(ModifyInfo.this,"Your Password length must be between 8 and 20 digits and must contain both letters and numbers", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}