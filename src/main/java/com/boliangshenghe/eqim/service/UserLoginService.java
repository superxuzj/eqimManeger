package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.entity.UserLogin;
import com.boliangshenghe.eqim.repository.UserLoginMapper;

@Service
public class UserLoginService {
	
	@Autowired
	UserLoginMapper userLoginMapper;
		
	
	public int insertSelective(UserLogin UserLogin) {
        return userLoginMapper.insertSelective(UserLogin);
    }
	
    public UserLogin selectByPrimaryKey(Integer id){
    	return userLoginMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(UserLogin record){
    	return userLoginMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<UserLogin> selectUserLoginList(UserLogin record){
    	List<UserLogin> list = userLoginMapper.selectUserLoginList(record);
    	return list;
    }
}
