package com.boliangshenghe.eqim.repository;

import java.util.List;

import com.boliangshenghe.eqim.entity.Quickcode;

public interface QuickcodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quickcode record);

    int insertSelective(Quickcode record);

    Quickcode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quickcode record);

    int updateByPrimaryKey(Quickcode record);
    
    List<Quickcode> selectQuickcodeList(Quickcode record);
}