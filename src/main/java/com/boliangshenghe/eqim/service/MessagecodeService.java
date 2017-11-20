package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.entity.Messagecode;
import com.boliangshenghe.eqim.repository.MessagecodeMapper;
/**
 * 灾情信息规则
 * @author xuzj
 *
 */
@Service
public class MessagecodeService {
	
	@Autowired
	MessagecodeMapper messagecodeMapper;
		
	
	public int insertSelective(Messagecode messagecode) {
        return messagecodeMapper.insertSelective(messagecode);
    }
	
    public Messagecode selectByPrimaryKey(Integer id){
    	return messagecodeMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Messagecode record){
    	return messagecodeMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Messagecode> selectMessagecodeList(Messagecode record){
    	List<Messagecode> list = messagecodeMapper.selectMessagecodeList(record);
    	return list;
    }
    
}
