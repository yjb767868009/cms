package com.xmu.cms.entity;

/**
 * @author JuboYu on 2018/11/23.
 * @version 1.0
 */
public class Teacher {
    private Integer teacherId;
    private String account;
    private String password;
    private String email;
    private String name;
    private Boolean activation;

    public Teacher(Integer teacherId, String account, String password, String email, String name, Boolean activation) {
        this.teacherId = teacherId;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        this.activation = activation;
    }

    public Teacher() {
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActivation() {
        return activation;
    }

    public void setActivation(Boolean activation) {
        this.activation = activation;
    }
}
