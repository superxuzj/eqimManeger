package com.boliangshenghe.eqim.repository;

import com.boliangshenghe.eqim.entity.MessageRecord;

public interface MessageRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageRecord record);

    int insertSelective(MessageRecord record);

    MessageRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageRecord record);

    int updateByPrimaryKey(MessageRecord record);
}