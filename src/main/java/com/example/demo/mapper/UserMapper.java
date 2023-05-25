package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    UserInfo findUser(@Param("username")String username);

    @Select("select * from user where id = #{id}")
    UserInfo findUserById(@Param("id")Integer id);

    @Delete("delete from user where id = #{id}")
    void deleteUserById(@Param("id")Integer id);

    @Select("select * from user")
    List<UserInfo> getAllUser();

    @Insert("insert into user (username,password,phone,email,address) values(#{username},#{password},#{phone},#{email},#{address})")
    void register(UserInfo userInfo);

    @Update("update user set phone=#{phone},email=#{email},password =#{password},address =#{address} where id=#{id}")
    void updateUserInfo(UserInfo userInfo);

    @Update("update user set password=#{username} where id=#{id}")
    void resetUserInfo(@Param("id")Integer id,@Param("username")String username);
}
