package com.boliangshenghe.eqim.repository;

import java.util.List;

import com.boliangshenghe.eqim.entity.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
    
    List<Company> selectCompanyList(Company record);
}