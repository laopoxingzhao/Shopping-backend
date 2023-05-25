package com.example.demo.controller;

import com.example.demo.model.GoodsInfo;
import com.example.demo.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class WebController {

    @Autowired
    private GoodsServiceImpl goodsService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<GoodsInfo> goods= goodsService.getAllGoods();
        System.out.println("商品列表："+goods);
        model.addAttribute("goods",goods);
        return "index";
    }
}
