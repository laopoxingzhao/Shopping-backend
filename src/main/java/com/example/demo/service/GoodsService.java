package com.example.demo.service;

import com.example.demo.model.GoodsInfo;
import com.example.demo.model.GoodsResultInfo;
import com.example.demo.model.ShoppingcarInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import java.util.List;

public interface  GoodsService {


    List<GoodsInfo> getGoodsList();

    GoodsResultInfo select(GoodsInfo goodsInfo);

    void insertorder(String username);

    GoodsResultInfo selectbyname(GoodsInfo goodsInfo);

    List<ShoppingcarInfo> getshoppingcar(String goodsInfo);


    GoodsInfo findGoodsById(Integer goodsid);

    List<GoodsInfo> getAllGoods();

    List<ShoppingcarInfo> getAllOrder();

    void deleteOrderById(Integer id);

    void updateGoods(String goodsname, String goodsprice, String goodsunit, int count, String goodspicture, Integer goodsid);

    void addgoods(String goodsname, String goodsprice, String goodsunit, Integer count, String goodspicture);

    List<ShoppingcarInfo> findorder(String name);

    List<GoodsInfo> searchgoods(String args);

    boolean reduceGoodNum(String username, int goodsid);

    boolean addGoodNum(String username, int goodsid);

    void deletecar(String name);

    void deletezero(String name);

    Double sumprice(String name);

    void updateGoods(GoodsInfo goodsInfo);

    boolean isRightPassword(GoodsInfo goodsInfo);

    boolean isExitGoods(GoodsInfo goodsInfo);
}
