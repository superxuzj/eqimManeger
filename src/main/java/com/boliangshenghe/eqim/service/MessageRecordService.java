package com.boliangshenghe.eqim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.entity.MessageRecord;
import com.boliangshenghe.eqim.repository.MessageRecordMapper;
/**
 *短信记录
 * @author xuzj
 *
 */
@Service
public class MessageRecordService {
	
	@Autowired
	MessageRecordMapper messageRecordMapper;
		
	
	public int insertSelective(MessageRecord MessageRecord) {
        return messageRecordMapper.insertSelective(MessageRecord);
    }
	
    public MessageRecord selectByPrimaryKey(Integer id){
    	return messageRecordMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(MessageRecord record){
    	return messageRecordMapper.updateByPrimaryKeySelective(record);
    }
    
    /*public List<MessageRecord> selectMessageRecordList(MessageRecord record){
    	List<MessageRecord> list = messageRecordMapper.selectMessageRecordList(record);
    	return list;
    }*/
    
}
