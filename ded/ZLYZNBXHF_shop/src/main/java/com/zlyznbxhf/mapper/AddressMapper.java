package com.zlyznbxhf.mapper;

import com.zlyznbxhf.po.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    List<Address> selectById(Integer userid);
}