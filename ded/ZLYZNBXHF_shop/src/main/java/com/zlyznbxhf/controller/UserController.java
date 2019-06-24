package com.zlyznbxhf.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.User;
import com.zlyznbxhf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user1/register.action")
    @ResponseBody
    public HashMap userRegister(User user){
        int i = userService.addUser(user);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (i==1){
            hashMap.put("code",0);
            hashMap.put("msg","注册成功");
        }
        return hashMap;
    }

    @RequestMapping(value = "/md5/m5d.action")
    @ResponseBody
    public HashMap userLogin(User user, HttpSession session){

        HashMap<String, Object> userByName = userService.getUserByName(user);
        Integer code = (Integer) userByName.get("code");
        if(code== 0){
            User user1 = (User) userByName.get("data");
            session.setAttribute("userid",user1.getUserid());
        }
        return userByName;
    }

    @RequestMapping(value = "/user/getUser.action")
    @ResponseBody
    public HashMap getUser(String username){
        HashMap<String, Object> user = userService.getUser(username);
        return user;
    }

    @RequestMapping(value = "/user/updateUser.action")
    @ResponseBody
    public HashMap updateUser(String username){
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = userService.updateUser(username);
        if (i ==1){
            hashMap.put("code",0);
            hashMap.put("msg","修改成功");
        }
        return hashMap;
    }
}
