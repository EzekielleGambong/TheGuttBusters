package com.appdet.theguttbusters;


public class UserHelperClass {
    String phoneNo, username, fullname,gender, password, cal;

    public UserHelperClass() {

    }

    public UserHelperClass(String phoneNo, String username, String fullname, String gender, String password, String cal) {
        this.phoneNo = phoneNo;
        this.username = username;
        this.fullname = fullname;
        this.gender = gender;
        this.password = password;
        this.cal = cal;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCal() {
        return cal;
    }

    public void setPCal(String cal) {
        this.cal = cal;
    }
}

