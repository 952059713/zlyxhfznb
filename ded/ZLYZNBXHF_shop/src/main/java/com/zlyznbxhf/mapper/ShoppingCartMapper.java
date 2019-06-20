package com.zlyznbxhf.mapper;

import com.zlyznbxhf.po.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer shoppingcartid);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer shoppingcartid);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}