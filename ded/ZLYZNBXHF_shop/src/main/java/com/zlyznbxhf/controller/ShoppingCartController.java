package com.zlyznbxhf.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 获取用户购物车
     * @param
     * @return
     */
    @RequestMapping(value = "/shoppingcart/getUserShoppingCar.action")
    @ResponseBody
    public JSONObject getCustomerShoppingCar(HttpSession session){
//        Integer id = (Integer) session.getAttribute("id");
        Integer id = 8;
        JSONObject cartList = shoppingCartService.getCartList(id);
        return cartList;
    }

    //删除
    @RequestMapping(value = "/shoppingcart/deleteShoppingCar.action")
    @ResponseBody
    public JSONObject deleteShoppingCar(Integer[] shoppingcartid){
        System.out.println(shoppingcartid);
        JSONObject result = shoppingCartService.deleteCart(shoppingcartid);
        return result;
    }

    //更新购物车
    @RequestMapping(value = "/shoppingcart/updateShoppingCar.action")
    @ResponseBody
    public JSONObject updateShoppingCar(Integer shoppingcartid,Integer productnum){
        JSONObject result = shoppingCartService.updateCart(shoppingcartid,productnum);
        return result;
    }
}
