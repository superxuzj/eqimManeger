package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Catalog;
import com.boliangshenghe.eqim.repository.CatalogMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class CatalogService {
	
	@Autowired
	CatalogMapper catalogMapper;
		
	
	public int insertSelective(Catalog Catalog) {
        return catalogMapper.insertSelective(Catalog);
    }
	
    public Catalog selectByPrimaryKey(String id){
    	return catalogMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Catalog record){
    	return catalogMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Catalog> selectCatalogList(Catalog record){
    	return catalogMapper.selectCatalogList(record);
    }
    
    public PageBean<Catalog> getCatalogByPage(Catalog record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Catalog> list = this.catalogMapper.selectCatalogList(record);
        return new PageBean<Catalog>(list);
    }
    
}
