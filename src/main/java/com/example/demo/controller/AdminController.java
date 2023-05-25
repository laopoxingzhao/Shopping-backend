package com.example.demo.controller;

import com.example.demo.model.AdminInfo;
import com.example.demo.model.ResultInfo;
import com.example.demo.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/admininfo")
public class AdminController {
    @Autowired
    private AccountServiceImpl accountService;
    @PostMapping("/adminlogin")
    public ResultInfo login(String username, String password){
        log.info("123");
        System.out.println(123);
        return accountService.login1(new AdminInfo(username, password));
    }
}
