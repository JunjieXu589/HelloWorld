package com.example.helloworld.entity;

public class Session {//Using static variables to transfer values between different pages
    private static Customer  customer = new Customer();//Static保证了它在整个程序运行期间只会有一个值

    public String getTel(){
        return customer.getTelephone();
    }
    public String getUserID(){
        return customer.getUserID();
    }
    public String getPwd(){
        return customer.getPwd();
    }
    public String getPayment(){
        return  customer.getPayment();
    }
    public String getCar(){
        return  customer.getCar();
    }
    public Float getBalance(){
        return customer.getBalance();
    }

    public void  setTel(String tel){
        customer.setTelephone(tel);
    }
    public void setUserID(String userID){
        customer.setUserID(userID);
    }
    public void setPwd(String pwd){
        customer.setPwd(pwd);
    }
    public void setPayment(String payment){
        customer.setPayment(payment);
    }
    public void setCar(String car){
        customer.setCar(car);
    }
    public void setBalance(Float balance){
        customer.setBalance(balance);
    }
}
