package com.zlyznbxhf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.mapper.AddressMapper;
import com.zlyznbxhf.po.Address;
import com.zlyznbxhf.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;


    @Override
    public JSONObject getAddress(Integer id) {
        JSONObject result = new JSONObject();
        if(id !=null){
            List<Address> addresses = addressMapper.selectById(id);
            result.put("code",0);
            result.put("msg","请求成功");
            result.put("data",addresses);
        }else {
            result.put("code",1);
            result.put("msg","请登录");
        }
        return result;
    }

    @Override
    public JSONObject updateAddress(Address address) {
        int i=0;
        JSONObject jsonObject = new JSONObject();
        if(address.getAddressid()!=null){
            i = addressMapper.updateByPrimaryKeySelective(address);
        }else {
            i = addressMapper.insertSelective(address);
        }
        if(i!=0){
            jsonObject.put("code",0);
            jsonObject.put("msg","添加地址成功");
        }else {
            jsonObject.put("code",1);
            jsonObject.put("msg","添加地址失败");
        }
        return jsonObject;
    }

    @Override
    public JSONObject deleteAddress(Integer id) {
        JSONObject jsonObject = new JSONObject();
        int i = addressMapper.deleteByPrimaryKey(id);
        if(i!=0){
            jsonObject.put("code",0);
            jsonObject.put("msg","删除地址成功");
        }
        return jsonObject;
    }
}
