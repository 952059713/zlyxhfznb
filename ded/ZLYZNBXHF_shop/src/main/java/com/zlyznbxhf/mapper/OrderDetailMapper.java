package com.zlyznbxhf.mapper;

import com.zlyznbxhf.po.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(Integer orderdetailid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer orderdetailid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}