package com.boliangshenghe.eqim.repository;

import java.util.List;

import com.boliangshenghe.eqim.entity.Quickcode;
import com.boliangshenghe.eqim.entity.Smscode;

public interface SmscodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Smscode record);

    int insertSelective(Smscode record);

    Smscode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Smscode record);

    int updateByPrimaryKey(Smscode record);
    
    List<Smscode> selectSmscodeList(Smscode record);
}