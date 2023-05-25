package com.example.demo;

import com.example.demo.mapper.GoodsMapper;
import com.example.demo.model.ShoppingcarInfo;
import com.example.demo.service.impl.GoodsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private GoodsServiceImpl goodsService;

    @Autowired
    private GoodsMapper goodsMapper;
    @Test
    void contextLoads() {

        List<ShoppingcarInfo> shoppingcarInfos=goodsService.getshoppingcar("arui");
        System.out.println(shoppingcarInfos.get(0));
    }


    @Test
    void insert(){
        ShoppingcarInfo shoppingcarInfo = new ShoppingcarInfo();

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(formatter.format(date));




    }
}
