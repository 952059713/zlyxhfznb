package com.zlyznbxhf.service;

import com.alibaba.fastjson.JSONObject;
import com.zlyznbxhf.po.Orders;


public interface OrdersService {
    public JSONObject handlerGenerationOrder(Integer[] ids,Integer address_id,Integer customer_id);
}
