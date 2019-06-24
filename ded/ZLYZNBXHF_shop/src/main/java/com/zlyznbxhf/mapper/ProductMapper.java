package com.zlyznbxhf.mapper;

import com.zlyznbxhf.po.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> showProductList();

    List<Product> exploreKeyword(String productname);

    List<Product> findProductList();

    Product getProductById(Integer productid);


}