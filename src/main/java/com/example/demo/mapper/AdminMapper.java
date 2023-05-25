package com.example.demo.mapper;

import com.example.demo.model.AdminInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from admin")
    List<AdminInfo> getAllAdmin();

    @Select("select * from admin where adminName = #{adminName}")
    AdminInfo findAdmin(@Param("adminName") String adminName);

    @Select("select * from admin where id = #{id}")
    AdminInfo findAdminById(@Param("id")Integer id);

    @Select("select password from admin where adminName = #{adminName}")
    String getAdminPassword(String adminName);

    @Insert("insert into admin (adminName,password) values(#{adminName},#{password})")
    void register1(AdminInfo adminInfo);

    @Update("update admin set password=#{password} where adminName=#{adminName}")
    void updateAdminPassword(AdminInfo adminInfo);

    @Delete("delete from admin where adminName = #{adminName}")
    void delete(@Param("adminName") String adminName);

    @Update("update admin set name = #{adminName},password = #{password} where id = #{id}")
    void updateAdminInfo(AdminInfo adminInfo);

    @Select("select count(*) from admin where adminName = #{adminName}")
    int countAdminByAdminName(@Param("adminName") String adminName);
}
