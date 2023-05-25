package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.impl.AccountServiceImpl;
import com.example.demo.service.impl.GoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;
import java.util.List;
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private AccountServiceImpl accountService;
    @Autowired
    private GoodsServiceImpl goodsService;



    @RequestMapping("/weblogin")
    public String weblogin(){
        System.out.println("0000000");
        return "login";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        List<GoodsInfo> goods= goodsService.getAllGoods();
        //System.out.println("商品列表："+goods);
        model.addAttribute("goods",goods);
        return "index";
    }

    @RequestMapping("/order")
    public String ordered(Model model) {
        List<ShoppingcarInfo> shoppingcarInfos= goodsService.getAllOrder();
        model.addAttribute("shoppingcarInfos",shoppingcarInfos);
        double sumsale = 0.0;
        for (int i=0;i<shoppingcarInfos.size();i++){
            sumsale += shoppingcarInfos.get(i).getGoodsprice()*shoppingcarInfos.get(i).getNum();
        }
        DecimalFormat df = new DecimalFormat("######0.00");
        String sale = df.format(sumsale);
        System.out.println("总销售额:"+sale);
        model.addAttribute("sumsale", sale);

        return "order";
    }

    @RequestMapping("/alluser")
    public String alluser(Model model) {
        List<UserInfo> userInfos= accountService.findUserList();
        model.addAttribute("userInfos",userInfos);
        return "alluser";
    }

    @RequestMapping("/checkUser")
    public String checkUser(@RequestParam String username, @RequestParam String password) {
        AdminInfo user = new AdminInfo(username, password);
        log.info(user.toString());
        System.out.println(user);
        ResultInfo resultInfo = accountService.login1(user);
        log.info(resultInfo.toString());
        System.out.println(resultInfo);
        System.out.println(resultInfo.getMsg()); 
        if (resultInfo.getMsg().equals("登录成功"))
            return "forward:/index";
        else
            return "redirect:/weblogin";
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        accountService.deleteUserById(id);
        return "redirect:/alluser";
    }

    @RequestMapping("/reset")
    public String reset(int id,String username) {
        accountService.reset(id,username);
        return "redirect:/alluser";
    }

    @RequestMapping("/deleteorder")
    public String deleteorder(int id) {
        goodsService.deleteOrderById(id);
        return "redirect:/order";
    }

    @RequestMapping("/update")
    public String update(Integer id, Model model) {
        GoodsInfo goodsInfo = goodsService.findGoodsById(id);
        model.addAttribute("goodsid", id);
        model.addAttribute("goodsInfo", goodsInfo);
        return "update";
    }

    @RequestMapping("/updateGood")
    public String update(String goodsname, String goodsprice, String goodsunit, int count, String goodspicture, Integer goodsid) {
        goodsService.updateGoods(goodsname,goodsprice,goodsunit,count,goodspicture,goodsid);
        return "redirect:/index";
    }

    @RequestMapping("/showadd")
    public String showadd() {
        return "addgoods";
    }

    @RequestMapping("/addgoods")
    public String addgoods(String goodsname, String goodsprice, String goodsunit, Integer count, String goodspicture) {
        if(goodsname.equals("")||goodsprice.equals("")||goodsunit.equals("")||count.equals("")||goodspicture.equals("")){
            return "redirect:/showadd";
        }else {
            goodsService.addgoods(goodsname,goodsprice,goodsunit,count,goodspicture);
        }
        return "redirect:/index";
    }

}
