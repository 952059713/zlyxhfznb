package com.zlyznbxhf.service;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.ShoppingCart;

public interface ShoppingCartService {
    public JSONObject addToCart(ShoppingCart shoppingCart);

    public JSONObject getCartList(Integer id);

    public  JSONObject deleteCart(Integer[] id);

    public  JSONObject updateCart(Integer id,Integer commodityNumber);

    public JSONObject getOrderCartList(Integer[] ids);
}
