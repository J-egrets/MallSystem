package cn.egret.entity;

public class User {
    private String userName;
    private String password;
    private String gender;
    private String phone;
    private String address;
    private int status;
    private int role;

    public User() {
    }

    public User(String userName, String password, String gender, String phone, String address, int status, int role) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.role = role;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", lock=" + status +
                ", role=" + role +
                '}';
    }
}
