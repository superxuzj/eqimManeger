package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Catalogcopy;
import com.boliangshenghe.eqim.repository.CatalogcopyMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class CatalogcopyService {
	
	@Autowired
	CatalogcopyMapper catalogcopyMapper;
		
	
	public int insertSelective(Catalogcopy catalogcopy) {
        return catalogcopyMapper.insertSelective(catalogcopy);
    }
	
    public Catalogcopy selectByPrimaryKey(String id){
    	return catalogcopyMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Catalogcopy record){
    	return catalogcopyMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Catalogcopy> selectCatalogcopyList(Catalogcopy record){
    	List<Catalogcopy> list = catalogcopyMapper.selectCatalogcopyList(record);
    	return list;
    }
    
    public PageBean<Catalogcopy> getCatalogcopyByPage(Catalogcopy record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Catalogcopy> list = this.selectCatalogcopyList(record);
        return new PageBean<Catalogcopy>(list);
    }
}
