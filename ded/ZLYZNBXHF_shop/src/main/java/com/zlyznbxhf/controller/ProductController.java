package com.zlyznbxhf.controller;

import com.zlyznbxhf.po.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Product")
public class ProductController {


    //根据关键字模糊查询
    @RequestMapping(value = "/ExploreKeyword.action")
    public @ResponseBody
    List<Product> exploreKeyword(Integer productid,String productname){

    }
}
