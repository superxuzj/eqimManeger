package com.boliangshenghe.eqim.repository;

import java.util.List;

import com.boliangshenghe.eqim.entity.Catalog;

public interface CatalogMapper {
    int deleteByPrimaryKey(String cataId);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(String cataId);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);
    
    List<Catalog> selectCatalogList(Catalog record);
}