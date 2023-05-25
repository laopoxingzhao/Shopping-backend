package com.example.demo.service.impl;

import com.example.demo.mapper.GoodsMapper;
import com.example.demo.model.GoodsInfo;
import com.example.demo.model.GoodsResultInfo;
import com.example.demo.model.ShoppingcarInfo;
import com.example.demo.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsInfo> getGoodsList() {
        return null;
    }

    @Override
    public GoodsResultInfo select(GoodsInfo goodsInfo){
        GoodsResultInfo result=new GoodsResultInfo();
        result.setSuccess(true);
        result.setMsg("成功");
        result.setGoods(goodsMapper.findGoodsById(goodsInfo.getGoodsid()));
        result.getGoods().setUsername(goodsInfo.getUsername());

        List<ShoppingcarInfo>  shoppingInfoList = new ArrayList<>();
        shoppingInfoList = goodsMapper.findshopping(goodsInfo.getUsername());

        int flag = 0;
        if(shoppingInfoList.size()==0){
            goodsMapper.insertcar(result.getGoods());
        }else{
            for (int i=0;i<shoppingInfoList.size();i++){
                //System.out.println((goodsInfo.getGoodsid()==shoppingInfoList.get(i).getGoodsid()) && (goodsInfo.getUsername().equals(String.valueOf(shoppingInfoList.get(i).getUsername()))));
                if((goodsInfo.getGoodsid()==shoppingInfoList.get(i).getGoodsid()) && (goodsInfo.getUsername().equals(String.valueOf(shoppingInfoList.get(i).getUsername())))) {
                    flag++;
                }
            }
            System.out.println(flag);
            if(flag==0){
                goodsMapper.insertcar(result.getGoods());
            }else{
                goodsMapper.addGoodNUm(goodsInfo.getUsername(),goodsInfo.getGoodsid());
                System.out.println("已有该商品");
            }
        }
        return result;
    }

    @Override
    public void insertorder(String username){
        List<ShoppingcarInfo>  shoppingInfoList = new ArrayList<>();
        shoppingInfoList = goodsMapper.findshopping(username);
        System.out.println(shoppingInfoList.size());
        for (int i=0;i<shoppingInfoList.size();i++){

            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String str = formatter.format(date);
            System.out.println("日期是"+str);

            ShoppingcarInfo shoppingcarInfo = new ShoppingcarInfo();
            shoppingcarInfo.setUsername(username);
            shoppingcarInfo.setGoodsid(shoppingInfoList.get(i).getGoodsid());
            shoppingcarInfo.setGoodsname(shoppingInfoList.get(i).getGoodsname());
            shoppingcarInfo.setGoodspicture(shoppingInfoList.get(i).getGoodspicture());
            shoppingcarInfo.setGoodsprice(shoppingInfoList.get(i).getGoodsprice());
            shoppingcarInfo.setGoodsunit(shoppingInfoList.get(i).getGoodsunit());
            shoppingcarInfo.setNum(shoppingInfoList.get(i).getNum());
            shoppingcarInfo.setTakeaway("0");
            shoppingcarInfo.setOrdertime(str);

            goodsMapper.insertOrder(shoppingcarInfo);
        }
    }
    public void insertorder1(String username,String takeaway){
        List<ShoppingcarInfo>  shoppingInfoList = new ArrayList<>();
        shoppingInfoList = goodsMapper.findshopping(username);
        System.out.println(shoppingInfoList.size());
        for (int i=0;i<shoppingInfoList.size();i++){
            Boolean take;
            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String str = formatter.format(date);
            System.out.println("日期是"+str);

            ShoppingcarInfo shoppingcarInfo = new ShoppingcarInfo();
            shoppingcarInfo.setUsername(username);
            shoppingcarInfo.setGoodsid(shoppingInfoList.get(i).getGoodsid());
            shoppingcarInfo.setGoodsname(shoppingInfoList.get(i).getGoodsname());
            shoppingcarInfo.setGoodspicture(shoppingInfoList.get(i).getGoodspicture());
            shoppingcarInfo.setGoodsprice(shoppingInfoList.get(i).getGoodsprice());
            shoppingcarInfo.setGoodsunit(shoppingInfoList.get(i).getGoodsunit());
            shoppingcarInfo.setNum(shoppingInfoList.get(i).getNum());
            shoppingcarInfo.setTakeaway(takeaway);

            shoppingcarInfo.setOrdertime(str);

            goodsMapper.insertOrder(shoppingcarInfo);
        }
    }
    @Override
    public GoodsResultInfo selectbyname(GoodsInfo goodsInfo){
        GoodsResultInfo result=new GoodsResultInfo();
        result.setSuccess(true);
        result.setMsg("成功");
        result.setGoods(goodsMapper.selectbyname(goodsInfo.getGoodsname()));
        result.setGoods(goodsMapper.selectbyname(goodsInfo.getGoodsname())).setUsername(goodsInfo.getUsername());

        List<ShoppingcarInfo>  shoppingInfoList = new ArrayList<>();
        shoppingInfoList = goodsMapper.findshopping(goodsInfo.getUsername());

        int flag = 0;
        if(shoppingInfoList.size()==0){
            goodsMapper.insertcar(result.getGoods());
        }else{
            for (int i=0;i<shoppingInfoList.size();i++){
                if((goodsInfo.getGoodsname().equals(String.valueOf(shoppingInfoList.get(i).getGoodsname()))) && (goodsInfo.getUsername().equals(String.valueOf(shoppingInfoList.get(i).getUsername())))){
                    flag++;
                }
            }
            System.out.println(flag);
            if(flag==0){
                goodsMapper.insertcar(result.getGoods());
            }else{
                goodsMapper.addGoodNUm(goodsInfo.getUsername(),goodsMapper.getgoodsid(goodsInfo.getGoodsname()));
                System.out.println("已有该商品");
            }
        }
        return result;
    }

    @Override
    public List<ShoppingcarInfo> getshoppingcar(String name) {
        List<ShoppingcarInfo>  shoppingInfoList = new ArrayList<>();
        shoppingInfoList = goodsMapper.findshopping(name);
        return shoppingInfoList;
    }

    @Override
    public GoodsInfo findGoodsById(Integer goodsid) {
        return goodsMapper.findGoodsById(goodsid);
    }

    @Override
    public List<GoodsInfo> getAllGoods() {
        List<GoodsInfo>  goodsInfos = new ArrayList<>();
        goodsInfos = goodsMapper.getAllGoods();
        return goodsInfos;
    }


    @Override
    public List<ShoppingcarInfo> getAllOrder() {
        List<ShoppingcarInfo> shoppingcarInfos = goodsMapper.getAllOrder();
        return shoppingcarInfos;
    }

    @Override
    public void deleteOrderById(Integer id){
        goodsMapper.deleteOrderById(id);
    }


    @Override
    public void updateGoods(String goodsname, String goodsprice, String goodsunit,int count, String goodspicture, Integer goodsid){
        goodsMapper.updateGoods(goodsname,goodsprice,goodsunit,count,goodspicture,goodsid);
    }

    @Override
    public void addgoods(String goodsname, String goodsprice, String goodsunit,Integer count, String goodspicture){
        goodsMapper.addgoods(goodsname,goodsprice,goodsunit,count,goodspicture);
    }

    @Override
    public List<ShoppingcarInfo> findorder(String username) {
        List<ShoppingcarInfo>  shoppingInfoList = new ArrayList<>();
        shoppingInfoList = goodsMapper.
                findorder(username);
        return shoppingInfoList;
    }

    @Override
    public List<GoodsInfo> searchgoods(String args) {
        log.info(args);//"%"+args+"%"
        List<GoodsInfo>  goodsInfoList = goodsMapper.searchgoods("%"+args+"%");
        log.info(goodsInfoList.toString());
        return goodsInfoList;
    }

    @Override
    public boolean reduceGoodNum(String username,int goodsid){
        return goodsMapper.reduceGoodNum(username,goodsid);
    }

    @Override
    public boolean addGoodNum(String username,int goodsid){
        return goodsMapper.addGoodNUm(username,goodsid);
    }

    @Override
    public void deletecar(String name){
        goodsMapper.deletecar(name);
    }


    @Override
    public void deletezero(String name){
        goodsMapper.deletezero(name);
    }

    @Override
    public Double sumprice(String name){
        return goodsMapper.sumprice(name);
    }

    @Override
    public void updateGoods(GoodsInfo goodsInfo) {
    }

    @Override
    public boolean isRightPassword(GoodsInfo goodsInfo) {
        return false;
    }

    @Override
    public boolean isExitGoods(GoodsInfo goodsInfo) {
        if(goodsInfo.getGoodsid() == null){
            return  false;
        }
        return true;
    }
}
