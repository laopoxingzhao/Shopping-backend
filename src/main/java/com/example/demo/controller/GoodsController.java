package com.example.demo.controller;

import com.example.demo.model.GoodsInfo;
import com.example.demo.model.GoodsResultInfo;
import com.example.demo.model.ShoppingcarInfo;
import com.example.demo.service.impl.GoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/goodsinfo")

public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @PostMapping("/select")
    public GoodsResultInfo select(@RequestBody GoodsInfo goods){
        log.info(goods.toString());
        return goodsService.select(goods);
    }

    @PostMapping("/selectbyname")
    public GoodsResultInfo selectbyname(@RequestBody GoodsInfo goods){
        log.info(goods.toString());
        return goodsService.selectbyname(goods);
    }

    @PostMapping("/getshoppingcar")
    public List<ShoppingcarInfo> getshoppingcar(String username){
        List<ShoppingcarInfo> infos = goodsService.getshoppingcar(username);
        return infos;
    }

    @PostMapping("/findorder")
    public List<ShoppingcarInfo> findorder(String username){
        List<ShoppingcarInfo> infos = goodsService.findorder(username);
        return infos;
    }

    @PostMapping("/searchgoods")
    public List<GoodsInfo> searchgoods(String args){
        return goodsService.searchgoods(args);
    }

    @PostMapping("/deletecar")
    public void deletecar(String username){
        goodsService.deletecar(username);
    }

    @RequestMapping("/deleteorder")
    public String deleteorder(int id) {
        System.out.println("deleteorder"+id);
        goodsService.deleteOrderById(id);
        return "true";
    }

    @PostMapping("/updateGoods")
    public String updateGoods(String goodsname, String goodsprice, String goodsunit, Integer count, String goodspicture, Integer goodsid){
        System.out.println(goodsname);
        goodsService.updateGoods(goodsname,goodsprice,goodsunit,count,goodspicture,goodsid);
        return goodsname;
    }

    @PostMapping("/deletezero")
    public void deletezero(String username){
        goodsService.deletezero(username);
    }

    @PostMapping("/insertorder")
    public void insertorder(String username){
        goodsService.insertorder(username);
    }

    @PostMapping("/insertorder1")
    public void insertorder1(String username,String takeaway){
        goodsService.insertorder1(username,takeaway);
    }


    @PostMapping("/reduceGoodNum")
    public boolean reduceGoodNum(String username,String goodsid){
        return goodsService.reduceGoodNum(username, Integer.parseInt(goodsid));
    }

    @PostMapping("/addGoodNum")
    public boolean addGoodNum(String username,String goodsid){
        return goodsService.addGoodNum(username, Integer.parseInt(goodsid));
    }

    @PostMapping("/sumprice")
    public Double sumprice(String username){
        return goodsService.sumprice(username);
    }

    @RequestMapping("/allInfo")
    public Map index( ) {
        List<ShoppingcarInfo> shoppingcarInfos= goodsService.getAllOrder();
        double sumsale = 0.0;
        for (int i=0;i<shoppingcarInfos.size();i++){
            sumsale += shoppingcarInfos.get(i).getGoodsprice()*shoppingcarInfos.get(i).getNum();
        }
        DecimalFormat df = new DecimalFormat("######0.00");
        String sale = df.format(sumsale);
        System.out.println("总销售额:"+sale);
        Map m = new HashMap<>();
        m.put("list",shoppingcarInfos);
        m.put("sale",sale);
        return m;
    }

    @PostMapping("/all")
    public  List<GoodsInfo> all() {
        List<GoodsInfo> goods= goodsService.getAllGoods();
        return goods;
    }

    @RequestMapping("/addgoods")
    public String addgoods(String goodsname, String goodsprice, String goodsunit, Integer count, String goodspicture) {
        if(goodsname.equals("")||goodsprice.equals("")||goodsunit.equals("")||count.equals("")||goodspicture.equals("")){
          return "不能为空";
        }else {
            goodsService.addgoods(goodsname,goodsprice,goodsunit,count,goodspicture);
        }
        return  "true";
    }
}
