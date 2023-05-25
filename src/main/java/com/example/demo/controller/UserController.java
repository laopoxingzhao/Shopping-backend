package com.example.demo.controller;

import com.example.demo.model.AdminInfo;
import com.example.demo.model.ResultInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/userinfo")

public class UserController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/change")
    public ResultInfo change(@RequestBody UserInfo user){
        System.out.println("change"+user);
        return accountService.change(user);
    }

    @PostMapping("/register")
    public ResultInfo register(@RequestBody UserInfo user){
        return accountService.register(user);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/login")
    public ResultInfo login(String username, String password){
        log.info("123");
        System.out.println(123);
        return accountService.login(new UserInfo(username, password));
    }

    @PostMapping("/adminlogin")
    public ResultInfo login1(String username, String password){
        log.info("123");
        System.out.println(123);
        return accountService.login1(new AdminInfo(username, password));
    }
    @RequestMapping("/alluser")
    public  List<UserInfo> alluser() {
        System.out.println(11111);
        List<UserInfo> userInfos= accountService.findUserList();
        return  userInfos;
    }
    @RequestMapping("/delete")
    public String delete(int id) {
        accountService.deleteUserById(id);
        return "true";
    }
}
