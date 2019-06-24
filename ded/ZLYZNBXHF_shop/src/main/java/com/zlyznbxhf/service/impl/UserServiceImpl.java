package com.zlyznbxhf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.mapper.UserMapper;
import com.zlyznbxhf.po.User;
import com.zlyznbxhf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        int insert =0;
        User user1 = userMapper.selectByName(user.getUsername());
        if (user1!=null){
            System.out.println("用户已经存在");
        }
        else {
            insert = userMapper.insertSelective(user);
        }
        return insert;
    }

    @Override
    public HashMap<String, Object> getUserByName(User user) {

        HashMap<String, Object> result = new HashMap<>();

        User user1 = userMapper.selectByName(user.getUsername());
        if (user1==null){
            result.put("code",2);
            result.put("msg","用户不存在");
        }else if(user1.getPassword().equals(user.getPassword())){
            result.put("code",0);
            result.put("msg","登陆成功");
            result.put("data",user1);
        }
        else {
            result.put("code",1);
            result.put("msg","密码错误");
        }
        return result;
    }

    @Override
    public HashMap<String, Object> getUser(String username) {
        HashMap<String, Object> hashMap = new HashMap<>();
        User user = userMapper.selectByName(username);
        hashMap.put("code",0);
        hashMap.put("msg","显示成功");
        hashMap.put("data",user);
        return hashMap;
    }

    @Override
    public int updateUser(String username) {
        int i = userMapper.updateByusername(username);
        return i;
    }

    @Override
    public JSONObject updateUserImg(Integer id, String img) {
        User user = new User();
        JSONObject jsonObject = new JSONObject();
        user.setUserimg(img);
        user.setUserid(id);
        int i = userMapper.updateByPrimaryKeySelective(user);
        if (i==1){
            jsonObject.put("code",0);
            jsonObject.put("msg","上传成功");
        }
        else {
            jsonObject.put("code",1);
            jsonObject.put("msg","上传失败");
        }
        return jsonObject;
    }
}
