package com.zlyznbxhf.mapper;

import com.zlyznbxhf.po.ShoppingCart;
import com.zlyznbxhf.vo.ShopCartProduct;

import java.util.List;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Integer shoppingcartid);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Integer shoppingcartid);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
    List<ShopCartProduct> selectCartByUser(Integer userid);
}