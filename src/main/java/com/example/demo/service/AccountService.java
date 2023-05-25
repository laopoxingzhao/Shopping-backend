package com.example.demo.service;

import com.example.demo.model.AdminInfo;
import com.example.demo.model.GoodsInfo;
import com.example.demo.model.UserInfo;

import java.util.List;

public interface AccountService {


    List<UserInfo> findUserList();
    List<AdminInfo> findAdminList();

    void updateUser(UserInfo userInfo);
    void updateAdmin(AdminInfo adminInfo);

    boolean isRightPassword(UserInfo userInfo);
    boolean isRightPassword1(AdminInfo adminInfo);

    boolean isExitUser(UserInfo userInfo);
    boolean isExitAdmin(AdminInfo adminInfo);

    List<GoodsInfo> findGoodsList();

    boolean isExitGoods(GoodsInfo goodsInfo);

    void deleteUserById(Integer userid);

    void reset(Integer id, String username);
}
