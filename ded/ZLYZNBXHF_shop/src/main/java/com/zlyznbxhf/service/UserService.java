package com.zlyznbxhf.service;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.User;

import java.util.HashMap;

public interface UserService {

    public int addUser(User user);

    public HashMap<String,Object> getUserByName(User user);

    public HashMap<String,Object> getUser(String username);

    public int updateUser(String username);

    JSONObject updateUserImg(Integer id, String img);
}
