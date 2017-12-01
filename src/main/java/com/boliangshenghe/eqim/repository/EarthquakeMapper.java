package com.boliangshenghe.eqim.repository;

import java.util.List;

import com.boliangshenghe.eqim.entity.Earthquake;

public interface EarthquakeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Earthquake record);

    int insertSelective(Earthquake record);

    Earthquake selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Earthquake record);

    int updateByPrimaryKey(Earthquake record);
    
    List<Earthquake> selectEarthquakeList(Earthquake record);
}