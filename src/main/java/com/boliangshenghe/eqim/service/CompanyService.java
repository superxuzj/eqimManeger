package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Company;
import com.boliangshenghe.eqim.repository.CompanyMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class CompanyService {
	
	@Autowired
	CompanyMapper companyMapper;
		
	public int deleteByPrimaryKey(Integer id){
		 return companyMapper.deleteByPrimaryKey(id);
	}
	
	public int insertSelective(Company Company) {
        return companyMapper.insertSelective(Company);
    }
	
    public Company selectByPrimaryKey(Integer id){
    	return companyMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Company record){
    	return companyMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Company> selectCompanyList(Company record){
    	List<Company> list = companyMapper.selectCompanyList(record);
    	return list;
    }
    
    public PageBean<Company> getCompanyByPage(Company record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Company> list = this.selectCompanyList(record);
        return new PageBean<Company>(list);
    }
}
