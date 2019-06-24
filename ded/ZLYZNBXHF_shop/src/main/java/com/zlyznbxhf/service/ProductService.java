package com.zlyznbxhf.service;

import com.zlyznbxhf.po.Product;

import java.util.List;

public interface ProductService {
    Product selectByPrimaryKey(Integer productid);

    List<Product> showProductList();

    List<Product> exploreKeyword(String productname);

    List<Product> getProductList();

    Product getProductById(Integer productid);
}
