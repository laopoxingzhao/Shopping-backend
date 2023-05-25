package com.example.demo.model;

public class ShoppingcarInfo {

    private String username;
    private int goodsid;
    private String goodsname;
    private double goodsprice;
    private String goodsunit;
    private String goodspicture;
    private int num;
    private int id;
    private String ordertime;

    private String takeaway;

    public String getTakeaway() {
        return takeaway;
    }

    public void setTakeaway(String takeaway) {
        this.takeaway = takeaway;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsunit() {
        return goodsunit;
    }

    public void setGoodsunit(String goodsunit) {
        this.goodsunit = goodsunit;
    }

    public String getGoodspicture() {
        return goodspicture;
    }

    public void setGoodspicture(String goodspicture) {
        this.goodspicture = goodspicture;
    }

    @Override
    public String toString() {
        return "ShoppingcarInfo{" +
                "goodsname='" + goodsname + '\'' +
                ", goodsprice='" + goodsprice + '\'' +
                ", goodsunit='" + goodsunit + '\'' +
                ", goodspicture='" + goodspicture + '\'' +
                '}';
    }
}
