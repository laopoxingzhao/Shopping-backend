package com.example.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;


    public UserInfo(String userName, String password) {
        this.username = userName;
        this.password = password;
    }
}
