package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.entity.Quickcode;
import com.boliangshenghe.eqim.repository.QuickcodeMapper;
/**
 * 快报规则
 * @author xuzj
 *
 */
@Service
public class QuickcodeService {
	
	@Autowired
	QuickcodeMapper quickcodeMapper;
		
	
	public int insertSelective(Quickcode quickcode) {
        return quickcodeMapper.insertSelective(quickcode);
    }
	
    public Quickcode selectByPrimaryKey(Integer id){
    	return quickcodeMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Quickcode record){
    	return quickcodeMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Quickcode> selectQuickcodeList(Quickcode record){
    	List<Quickcode> list = quickcodeMapper.selectQuickcodeList(record);
    	
    	return list;
    }
    
}
