package com.zlyznbxhf.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.Address;
import com.zlyznbxhf.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    //获取用户地址
    @RequestMapping(value = "/getaddress.action")
    @ResponseBody
    public JSONObject getAddress(HttpSession session){
        Integer id = (Integer) session.getAttribute("userid");
        JSONObject result = addressService.getAddress(id);
        return result;
    }
    //添加地址
    @RequestMapping(value = "/updateaddress.action")
    @ResponseBody
    public JSONObject updateaddress(Address address, HttpSession session){
        Integer id = (Integer) session.getAttribute("userid");
        address.setUserid(id);
        JSONObject result = addressService.updateAddress(address);
        return result;
    }
    //删除地址
    @RequestMapping(value = "/deleteaddress.action")
    @ResponseBody
    public JSONObject deleteAddress(Integer addressid){
        JSONObject jsonObject = addressService.deleteAddress(addressid);
        return jsonObject;
    }
}
