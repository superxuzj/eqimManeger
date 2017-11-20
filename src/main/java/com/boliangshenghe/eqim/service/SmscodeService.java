package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.entity.Smscode;
import com.boliangshenghe.eqim.repository.SmscodeMapper;
/**
 * 短信震级规则
 * @author xuzj
 *
 */
@Service
public class SmscodeService {
	
	@Autowired
	SmscodeMapper smscodeMapper;
		
	
	public int insertSelective(Smscode smscode) {
        return smscodeMapper.insertSelective(smscode);
    }
	
    public Smscode selectByPrimaryKey(Integer id){
    	return smscodeMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Smscode record){
    	return smscodeMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Smscode> selectSmscodeList(Smscode record){
    	List<Smscode> list = smscodeMapper.selectSmscodeList(record);
    	return list;
    }
    
}
