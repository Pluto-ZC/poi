package com.example.demo.servcice;

import com.example.demo.pojo.Product;

import java.util.List;

public interface ProductService {
    void save(List<Product> productList);
    List<Product> findAll();
}
