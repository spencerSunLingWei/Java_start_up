package com.stage1.part4.task2;

public class User implements java.io.Serializable{

    private static final long serialVersionUID = -6415446560832288253L;
    private String userName;
    private String password;
    private transient String phoneNum; //表示手机号不会被写入文件中

    public User() {
    }

    public User(String userName, String password, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
