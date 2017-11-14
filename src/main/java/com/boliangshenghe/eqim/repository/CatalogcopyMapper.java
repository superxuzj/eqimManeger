package com.boliangshenghe.eqim.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.boliangshenghe.eqim.entity.Catalogcopy;
@Mapper
public interface CatalogcopyMapper {
    int deleteByPrimaryKey(String cataId);

    int insert(Catalogcopy record);

    int insertSelective(Catalogcopy record);

    Catalogcopy selectByPrimaryKey(String cataId);

    int updateByPrimaryKeySelective(Catalogcopy record);

    int updateByPrimaryKey(Catalogcopy record);
    
    List<Catalogcopy> selectCatalogcopyList(Catalogcopy record);
}