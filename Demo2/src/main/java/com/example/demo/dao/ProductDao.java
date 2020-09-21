package com.example.demo.dao;

import com.example.demo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface ProductDao {

    void save(@Param("product") Product product);

    @Select("select * from product")
    List<Product> findAll();
}
