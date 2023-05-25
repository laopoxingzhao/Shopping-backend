package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminInfo {
    private Integer id;
    private String adminName;
    private String password;

    public AdminInfo(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }
}
