package com.zlyznbxhf.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.Product;
import com.zlyznbxhf.po.ShoppingCart;
import com.zlyznbxhf.service.ProductService;
import com.zlyznbxhf.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    //显示产品列表
    @RequestMapping(value = "/product/productListAjax.action",produces = {"text/html;charset=utf-8;"})
    @ResponseBody
    public String itemList(){
        System.out.println("itemList........");
        List<Product> list = productService.getProductList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        //jsonObject.put("msg","获取列表成功");
        jsonObject.put("data",list);
        String s = jsonObject.toJSONString();
        //String s = JSONObject.toJSONStringWithDateFormat(jsonObject, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
        return  s;
    }

    //通过id获取产品
    @RequestMapping(value = "/product/getProductById.action")
    @ResponseBody
    public Product getProductById(Integer productid) {
        Product product = productService.getProductById(productid);
        return product;
    }

    //通过搜索关键字获取商品名称
    @RequestMapping(value = "/product/exploreKeyword.action")
    @ResponseBody
    public String exploreKeyword(String productname){
        List<Product> list = productService.exploreKeyword(productname);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        //jsonObject.put("msg","获取列表成功");
        jsonObject.put("data",list);
        String s = jsonObject.toJSONString();
        return s;
    }

    //通过id获取产品
    @RequestMapping(value = "/user/addshopcar.action")
    @ResponseBody
    public JSONObject addShopcar(ShoppingCart shoppingCart, HttpSession session) {
        Integer userid = (Integer) session.getAttribute("userid");
        shoppingCart.setUserid(userid);
        JSONObject jsonObject = shoppingCartService.addToCart(shoppingCart);
        return jsonObject;
    }
}
