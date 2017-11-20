package com.boliangshenghe.eqim.repository;

import java.util.List;

import com.boliangshenghe.eqim.entity.Messagecode;
import com.boliangshenghe.eqim.entity.Smscode;

public interface MessagecodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Messagecode record);

    int insertSelective(Messagecode record);

    Messagecode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Messagecode record);

    int updateByPrimaryKey(Messagecode record);
    
    List<Messagecode> selectMessagecodeList(Messagecode record);
}