package com.example.demo.servcice;

import com.example.demo.dao.ProductDao;
import com.example.demo.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void save(List<Product> productList) {
        for (Product product : productList) {
            productDao.save(product);
        }
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
