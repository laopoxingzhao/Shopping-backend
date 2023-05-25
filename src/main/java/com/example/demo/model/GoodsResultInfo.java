package com.example.demo.model;

public class GoodsResultInfo {
    private String msg;
    private boolean success;
    private GoodsInfo goods;

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

    public GoodsInfo getGoods() {
        return goods;
    }

    public GoodsInfo setGoods(GoodsInfo goods) {
        this.goods = goods;
        return goods;
    }
}
