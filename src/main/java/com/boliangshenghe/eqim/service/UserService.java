package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.User;
import com.boliangshenghe.eqim.repository.UserMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
		
	public int deleteByPrimaryKey(Integer id){
		 return userMapper.deleteByPrimaryKey(id);
	}
	public int insertSelective(User User) {
        return userMapper.insertSelective(User);
    }
	
    public User selectByPrimaryKey(Integer id){
    	return userMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(User record){
    	return userMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<User> selectUserList(User record){
    	List<User> list = userMapper.selectUserList(record);
    	/*for (User user : list) {
    		user.setPhone(getEncryptValue(user.getPhone()));
			user.setCompany(getEncryptValue(user.getCompany()));
			user.setJob(getEncryptValue(user.getJob()));
			this.updateByPrimaryKeySelective(user);
		}*/
    	return list;
    }
    
    public PageBean<User> getUserByPage(User record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<User> list = this.selectUserList(record);
        
        return new PageBean<User>(list);
    }
    
 /*// 加密数据
 	private String getEncryptValue(String value) {
 		String returnString = "";
 		try {
 			DesUtils des = new DesUtils();
 			returnString = des.encrypt(value);
 		} catch (Exception c) {
 			// TODO Auto-generated catch block
 			c.printStackTrace();
 		}
 		return returnString;
 	}*/
}
