package com.example.demo.model;

public class ShoppingResultInfo {
    private String msg;
    private boolean success;
    private ShoppingcarInfo shoppingcarInfo;

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

    public ShoppingcarInfo getShoppingcarInfo() {
        return shoppingcarInfo;
    }

    public void setShoppingcarInfo(ShoppingcarInfo shoppingcarInfo) {
        this.shoppingcarInfo = shoppingcarInfo;
    }
}
