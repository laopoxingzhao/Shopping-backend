package com.example.demo.service.impl;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.AdminInfo;
import com.example.demo.model.GoodsInfo;
import com.example.demo.model.ResultInfo;
import com.example.demo.model.UserInfo;
import com.example.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
//@Service
//public class AccountServiceImpl implements AccountService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private AdminMapper adminMapper;
//
//    public ResultInfo change(UserInfo userInfo){
//        ResultInfo result=new ResultInfo();
//        result.setSuccess(false);
//        result.setUser(null);
//
//        userMapper.updateUserInfo(userInfo);
//
//        result.setMsg("修改成功");
//        result.setUser(userMapper.findUserById(userInfo.getId()));
//        result.setSuccess(true);
//        return result;
//    }
//
//    public ResultInfo login(UserInfo userInfo){
//        ResultInfo result=new ResultInfo();
//        result.setSuccess(false);
//        result.setUser(null);
//
//        System.out.println(userInfo);
//        if(!isExitAccount(userInfo.getUsername())){
//            result.setMsg("用户名不存在");
//        }else if(!isRightPassword(userInfo)){
//            result.setMsg("密码错误");
//        }else{
//            result.setSuccess(true);
//            result.setMsg("登录成功");
//            result.setUser(userMapper.findUser(userInfo.getUsername()));
//        }
//        return result;
//    }
//
//    public ResultInfo login1(AdminInfo adminInfo) {
//        ResultInfo result = new ResultInfo();
//        result.setSuccess(false);
//        result.setAdmin(null);
//
//        System.out.println(adminInfo);
//        if(!isExitAccount1(adminInfo.getAdminName())){
//            result.setMsg("用户名不存在");
//        }else if(!isRightPassword1(adminInfo)){
//            result.setMsg("密码错误");
//        }else{
//            result.setSuccess(true);
//            result.setMsg("登录成功");
//            result.setAdmin(adminMapper.findAdmin(adminInfo.getAdminName()));
//        }
//        return result;
//    }
//
//
//
//    public ResultInfo register(UserInfo userInfo){
//        ResultInfo result=new ResultInfo();
//        result.setSuccess(false);
//        result.setUser(null);
//        if(isExitAccount(userInfo.getUsername())){
//            result.setMsg("用户名已存在");
//        }else{
//            userMapper.register(userInfo);
//            result.setUser(userMapper.findUser(userInfo.getUsername()));
//            result.setSuccess(true);
//            result.setMsg("注册成功！");
//        }
//        return result;
//    }
//
//    public ResultInfo register1(AdminInfo adminInfo) {
//        ResultInfo result = new ResultInfo();
//        result.setSuccess(false);
//        result.setAdmin(null);
//
//        // 检查该管理员账号是否已存在
//        if (isAdminAccountExist(adminInfo.getAdminName())) {
//            result.setMsg("该管理员账号已存在");
//        } else {
//            // 进行管理员注册
//            adminMapper.register1(adminInfo);
//            result.setAdmin(adminMapper.findAdmin(adminInfo.getAdminName()));
//            result.setSuccess(true);
//            result.setMsg("管理员注册成功！");
//        }
//
//        return result;
//    }
//
//    // 判断该管理员账号是否已存在
//    private boolean isAdminAccountExist(String username) {
//        // TODO: 查询数据库，判断该管理员账号是否已存在
//        return false;
//    }
//
//
//    boolean isExitAccount(String username){
//        List<UserInfo>  userInfoList = findUserList();
//        for(UserInfo user:userInfoList){
//            if(username.equals(user.getUsername())){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    boolean isExitAccount1(String adminName){
//        List<AdminInfo>  adminInfoList = findAdminList();
//        for(AdminInfo admin:adminInfoList){
//            if(adminName.equals(admin.getAdminName())){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public List<UserInfo> findUserList() {
//        List<UserInfo>  userInfoList = new ArrayList<>();
//        userInfoList = userMapper.getAllUser();
//        return userInfoList;
//    }
//
//    @Override
//    public List<AdminInfo> findAdminList() {
//        List<AdminInfo> adminInfoList = new ArrayList<>();
//        adminInfoList = adminMapper.getAllAdmin();
//        return adminInfoList;
//    }
//
//    @Override
//    public void updateUser(UserInfo userInfo) {
//        if(userInfo.getUsername()==null){
//            userMapper.register(userInfo);
//        }else{
//            userMapper.updateUserInfo(userInfo);
//        }
//    }
//
//    @Override
//    public void updateAdmin(AdminInfo adminInfo) {
//        if(adminInfo.getAdminName()==null){
//            AdminMapper.register1(adminInfo);
//        }else{
//            AdminMapper.updateAdminInfo(adminInfo);
//        }
//    }
//
//    @Override
//    public boolean isRightPassword(UserInfo userInfo) {
//        UserInfo user = userMapper.findUser(userInfo.getUsername());
//        if(user.getPassword().equals(userInfo.getPassword())){
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean isRightPassWord1(AdminInfo adminInfo) {
//        return false;
//    }
//
//    private boolean isRightPassword1(AdminInfo adminInfo) {
//        AdminInfo admin = adminMapper.findAdmin(adminInfo.getAdminName());
//        if(admin.getPassword().equals(adminInfo.getPassword())){
//            return true;
//        }
//        return false;
//    }
//
//
//
//    @Override
//    public boolean isExitUser(UserInfo userInfo) {
//        if(userInfo.getId() == null){
//            return  false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean isExitAdmin(AdminInfo adminInfo) {
//        return false;
//    }
//
//    @Override
//    public List<GoodsInfo> findGoodsList() {
//        return null;
//    }
//
//    @Override
//    public boolean isExitGoods(GoodsInfo goodsInfo) {
//        return false;
//    }
//
//    @Override
//    public void deleteUserById(Integer id){
//        userMapper.deleteUserById(id);
//    }
//
//    @Override
//    public void reset(Integer id,String username){
//        userMapper.resetUserInfo(id,username);
//    }
//
//
//}
@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminMapper adminMapper;

    public ResultInfo change(UserInfo userInfo){
        ResultInfo result=new ResultInfo();
        result.setSuccess(false);
        result.setUser(null);

        userMapper.updateUserInfo(userInfo);

        result.setMsg("修改成功");
        result.setUser(userMapper.findUserById(userInfo.getId()));
        result.setSuccess(true);
        return result;
    }

    public ResultInfo login(UserInfo userInfo){
        ResultInfo result=new ResultInfo();
        result.setSuccess(false);
        result.setUser(null);

        System.out.println(userInfo);
        if(!isAccountExist(userInfo.getUsername())){
            result.setMsg("用户名不存在");
        }else if(!isRightPassword(userInfo)){
            result.setMsg("密码错误");
        }else{
            result.setSuccess(true);
            result.setMsg("登录成功");
            result.setUser(userMapper.findUser(userInfo.getUsername()));
        }
        return result;
    }

    public ResultInfo login1(AdminInfo adminInfo) {
        ResultInfo result = new ResultInfo();
        result.setSuccess(false);
        result.setAdmin(null);

        System.out.println(adminInfo);
        if(!isAdminExist(adminInfo.getAdminName())){
            result.setMsg("用户名不存在");
        }else if(!isRightPassword1(adminInfo)){
            result.setMsg("密码错误");
        }else{
            result.setSuccess(true);
            result.setMsg("登录成功");
            result.setAdmin(adminMapper.findAdmin(adminInfo.getAdminName()));
        }
        return result;
    }

    public ResultInfo register(UserInfo userInfo){
        ResultInfo result=new ResultInfo();
        result.setSuccess(false);
        result.setUser(null);
        if(isAccountExist(userInfo.getUsername())){
            result.setMsg("用户名已存在");
        }else{
            userMapper.register(userInfo);
            result.setUser(userMapper.findUser(userInfo.getUsername()));
            result.setSuccess(true);
            result.setMsg("注册成功！");
        }
        return result;
    }

    public ResultInfo register1(AdminInfo adminInfo) {
        ResultInfo result = new ResultInfo();
        result.setSuccess(false);
        result.setAdmin(null);

        // 检查该管理员账号是否已存在
        if (isAdminExist(adminInfo.getAdminName())) {
            result.setMsg("该管理员账号已存在");
        } else {
            // 进行管理员注册
            adminMapper.register1(adminInfo);
            result.setAdmin(adminMapper.findAdmin(adminInfo.getAdminName()));
            result.setSuccess(true);
            result.setMsg("管理员注册成功！");
        }

        return result;
    }

    private boolean isAdminExist(String adminName) {
        AdminInfo admin = adminMapper.findAdmin(adminName);
        return admin != null;
    }

    private boolean isAccountExist(String username){
        UserInfo user = userMapper.findUser(username);
        return user != null;
    }

    @Override
    public List<UserInfo> findUserList() {
        return userMapper.getAllUser();
    }

    @Override
    public List<AdminInfo> findAdminList() {
        return adminMapper.getAllAdmin();
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        if(userInfo.getUsername()==null){
            userMapper.register(userInfo);
        }else{
            userMapper.updateUserInfo(userInfo);
        }
    }

    @Override
    public void updateAdmin(AdminInfo adminInfo) {
        if(adminInfo.getAdminName()==null){
            adminMapper.register1(adminInfo);
        }else{
            adminMapper.updateAdminInfo(adminInfo);
        }
    }

    @Override
    public boolean isRightPassword(UserInfo userInfo) {
        UserInfo user = userMapper.findUser(userInfo.getUsername());
        if(user.getPassword().equals(userInfo.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean isRightPassword1(AdminInfo adminInfo) {
        AdminInfo admin = adminMapper.findAdmin(adminInfo.getAdminName());
        if(admin.getPassword().equals(adminInfo.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean isExitUser(UserInfo userInfo) {
        if(userInfo.getId() == null){
            return  false;
        }
        return true;
    }

    @Override
    public boolean isExitAdmin(AdminInfo adminInfo) {
        if(adminInfo.getAdminName() == null){
            return  false;
        }
        return true;
    }

    @Override
    public List<GoodsInfo> findGoodsList() {
        return null;
    }

    public String getAdminPassword(String adminNname) {
        return adminMapper.getAdminPassword(adminNname);
    }

    @Override
    public boolean isExitGoods(GoodsInfo goodsInfo) {
        return false;
    }

    @Override
    public void deleteUserById(Integer id){
        userMapper.deleteUserById(id);
    }

    @Override
    public void reset(Integer id,String username){
        userMapper.resetUserInfo(id,username);
    }
}
