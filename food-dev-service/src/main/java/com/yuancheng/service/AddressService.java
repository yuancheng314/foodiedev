package com.yuancheng.service;

import com.yuancheng.pojo.Carousel;
import com.yuancheng.pojo.UserAddress;
import com.yuancheng.pojo.bo.AddressBO;

import java.util.List;

public interface AddressService {

    /**
     * 根据用户id查询用户收货地址列表
     * @param userId
     * @return
     */
    public List<UserAddress> queryAll(String userId);

    /**
     * 用户新增地址
     * @param addressBO
     */
    public void addNewUserAddress(AddressBO addressBO);

    /**
     * 用户修改地址
     * @param addressBO
     */
    public void updateUserAddress(AddressBO addressBO);

}
