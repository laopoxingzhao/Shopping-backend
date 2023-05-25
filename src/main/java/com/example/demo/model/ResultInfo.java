package com.example.demo.model;

public class ResultInfo {
    private String msg;
    private Boolean success;
    private UserInfo user;
    private AdminInfo admin;

    public AdminInfo getAdminInfo() {
        return admin;
    }

    public void setAdmin(AdminInfo adminInfo) {
        this.admin= adminInfo;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
