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
    @RequestMapping(value = "/user/getUserShoppingCar.action")
    @ResponseBody
    public JSONObject getCustomerShoppingCar(HttpSession session){
        Integer userid = (Integer) session.getAttribute("userid");
//        Integer id = 8;
        JSONObject cartList = shoppingCartService.getCartList(userid);
        return cartList;
    }

    //删除
    @RequestMapping(value = "/user/deleteShoppingCar.action")
    @ResponseBody
    public JSONObject deleteShoppingCar(Integer[] shoppingcartid){
        System.out.println(shoppingcartid);
        JSONObject result = shoppingCartService.deleteCart(shoppingcartid);
        return result;
    }

    //更新购物车
    @RequestMapping(value = "/user/updateShoppingCar.action")
    @ResponseBody
    public JSONObject updateShoppingCar(Integer shoppingcartid,Integer productnum){
        JSONObject result = shoppingCartService.updateCart(shoppingcartid,productnum);
        return result;
    }

    @RequestMapping(value = "/cart/getorderscart.action")
    @ResponseBody
    public JSONObject getOrderCartList(Integer[] ids){
        JSONObject list = shoppingCartService.getOrderCartList(ids);
        return list;
    }
}
