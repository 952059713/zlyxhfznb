package com.zlyznbxhf.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.Orders;
import com.zlyznbxhf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/order/orderaction.action")
    @ResponseBody
    public JSONObject orderGeneration(Integer[] shoppingcartid, Integer addressid, HttpSession session){
        Integer id = (Integer) session.getAttribute("userid");
        JSONObject result = ordersService.handlerGenerationOrder(shoppingcartid,addressid,id);;
        return result;
    }


}
