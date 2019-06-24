package com.zlyznbxhf.service;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.Address;

public interface AddressService {
    public JSONObject getAddress(Integer id);

    public JSONObject updateAddress(Address address);

    public JSONObject deleteAddress(Integer id);
}
