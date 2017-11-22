package com.boliangshenghe.eqim.repository;

import java.util.List;

import com.boliangshenghe.eqim.entity.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
    
    List<UserLogin> selectUserLoginList(UserLogin record);
}