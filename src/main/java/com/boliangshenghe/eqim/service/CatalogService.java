package com.boliangshenghe.eqim.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Catalog;
import com.boliangshenghe.eqim.repository.CatalogMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.boliangshenghe.eqim.util.HttpClientUtil;
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
    	List<Catalog> list = catalogMapper.selectCatalogList(record);
    	for (Catalog catalog : list) {
			try {
				/*Map<String,String> map = new HashMap<String,String>();
				map.put("key", CommonUtils.GAODEKEY);
				map.put("location",catalog.getLon()+","+catalog.getLat());
				map.put("radius","1000");
				map.put("extensions","all");
				map.put("batch","false");
				map.put("roadlevel","0");
				String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/regeo",map);
				
				String provice = retu.substring(retu.indexOf("province")+11, retu.indexOf("city")-3);
				
				if(!provice.trim().equals("")){
					String company  = provice.substring(0, 2);
					System.out.println(company);
				}
				System.out.println(provice+"  provice");*/
				
				catalog.setLocationCname(new String(catalog.getLocationCname().getBytes("ISO-8859-1"), "gbk"));
			} catch (UnsupportedEncodingException c) {
				// TODO Auto-generated catch block
				c.printStackTrace();
			}
		}
    	return list;
    }
    
    public PageBean<Catalog> getCatalogByPage(Catalog record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Catalog> list = this.selectCatalogList(record);
        return new PageBean<Catalog>(list);
    }
}
