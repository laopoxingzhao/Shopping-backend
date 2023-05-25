package com.example.demo.mapper;

import com.example.demo.model.GoodsInfo;
import com.example.demo.model.ShoppingcarInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    @Select("select * from goods where goodsname = #{goodsname}")
    GoodsInfo findGoods(@Param("goodsname")String goodsname);

    @Select("select * from goods where goodsid = #{goodsid}")
    GoodsInfo findGoodsById(@Param("goodsid")Integer goodsid);

    @Select("select * from goods")
    List<GoodsInfo> getAllGoods();

    @Select("select * from goodsorder")
    List<ShoppingcarInfo> getAllOrder();

    @Select("select * from shoppingcar where username = #{username}")
    List<ShoppingcarInfo> findshopping(String username);

    @Select("select * from goodsorder where username = #{username}")
    List<ShoppingcarInfo> findorder(String username);

    @Select("select * from goods where goodsname = #{goodsname}")
    GoodsInfo selectbyname(@Param("goodsname")String goodsname);

    @Select("select goodsname,goodsprice,goodsunit,goodspicture from goods where goodsname like #{args}")
    List<GoodsInfo> searchgoods(String args);

    @Insert("insert into shoppingcar (username,goodsid,goodsname,goodsprice,goodsunit,goodspicture)  values(#{username},#{goodsid},#{goodsname},#{goodsprice},#{goodsunit},#{goodspicture})")
    void insertcar(GoodsInfo goodsInfo);

    @Insert("insert into goodsorder (username,goodsid,goodsname,goodsprice,goodsunit,goodspicture,num,ordertime,takeaway)  values(#{username},#{goodsid},#{goodsname},#{goodsprice},#{goodsunit},#{goodspicture},#{num},#{ordertime},#{takeaway}) ")
    void insertOrder(ShoppingcarInfo shoppingcarInfo);

    @Delete("delete from shoppingcar where username = #{username}")
    void deletecar(String username);

    @Select("select sum(goodsprice) from shoppingcar where username = #{username}")
    Double sumprice(String username);

    @Select("select goodsid from shoppingcar where goodsname = #{goodname}")
    Integer getgoodsid(String goodsname);

    @Update("update shoppingcar set num=num-1 where goodsid=#{goodsid} and username=#{username}")
    boolean reduceGoodNum(String username,int goodsid);

    @Update("update shoppingcar set num=num+1 where goodsid=#{goodsid} and username=#{username}")
    boolean addGoodNUm(String username,int goodsid);

    @Delete("delete from shoppingcar where username=#{username} and num = 0")
    void deletezero(String username);

    @Delete("delete from goodsorder where id = #{id}")
    void deleteOrderById(@Param("id")Integer id);

    @Update("update goods set goodsname=#{goodsname},goodsprice=#{goodsprice},goodsunit=#{goodsunit},count=#{count},goodspicture=#{goodspicture} where goodsid=#{goodsid}")
    void updateGoods(@Param("goodsname")String goodsname,@Param("goodsprice") String goodsprice, @Param("goodsunit") String goodsunit,@Param("count") Integer count,@Param("goodspicture") String goodspicture,@Param("goodsid") Integer goodsid);

    @Insert("insert into goods (goodsname,goodsprice,goodsunit,count,goodspicture)  values(#{goodsname},#{goodsprice},#{goodsunit},#{count},#{goodspicture})")
    void addgoods(@Param("goodsname")String goodsname,@Param("goodsprice") String goodsprice, @Param("goodsunit") String goodsunit,@Param("count") Integer count,@Param("goodspicture") String goodspicture);

//    @Select("select sum(goodsprice) from shoppingcar where username = #{username}")
//    Double sumsale(String username);
}
