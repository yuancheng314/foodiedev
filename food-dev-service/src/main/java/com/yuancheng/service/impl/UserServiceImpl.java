package com.yuancheng.service.impl;

import com.yuancheng.enums.Sex;
import com.yuancheng.mapper.UsersMapper;
import com.yuancheng.pojo.Users;
import com.yuancheng.pojo.bo.UserBO;
import com.yuancheng.service.UserService;
import com.yuancheng.utils.DateUtil;
import com.yuancheng.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UsersMapper userMapper;
    @Autowired
    private Sid sid;

    private static final String USER_FACE = "https://avatar.csdnimg.cn/F/2/C/1_yuancheng224.jpg";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        Users result = userMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
//        try {
//            Thread.sleep(3500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String userId = sid.nextShort();
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认用户昵称同用户名
        user.setNickname(userBO.getUsername());
        //默认头像
        user.setFace(USER_FACE);
        //默认生日
        user.setBirthday(DateUtil.stringToDate("1970-01-01"));
        //默认性别为保密
        user.setSex(Sex.secret.type);

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        userMapper.insert(user);

        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
//        try {
//            Thread.sleep(2500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);
        Users result = userMapper.selectOneByExample(userExample);
        return result;
    }
}
