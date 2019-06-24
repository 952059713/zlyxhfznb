package com.zlyznbxhf.service.impl;

import com.zlyznbxhf.mapper.ProductMapper;
import com.zlyznbxhf.po.Product;
import com.zlyznbxhf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product selectByPrimaryKey(Integer productid) {
        Product product = productMapper.selectByPrimaryKey(productid);
        return product;
    }

    @Override
    public List<Product> showProductList() {
        List<Product> products = productMapper.showProductList();
        return products;
    }

    @Override
    public List<Product> exploreKeyword(String productname) {
        List<Product> list= productMapper.exploreKeyword(productname);
        return list;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> productList = productMapper.findProductList();
        return productList;
    }

    @Override
    public Product getProductById(Integer productid) {
        Product product = productMapper.getProductById(productid);
        return product;
    }
}
