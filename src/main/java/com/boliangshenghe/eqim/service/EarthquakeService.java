package com.boliangshenghe.eqim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Earthquake;
import com.boliangshenghe.eqim.repository.EarthquakeMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.github.pagehelper.PageHelper;

/**
 * 模拟地震事件
 * @author xuzj
 *
 */
@Service
public class EarthquakeService {
	
	@Autowired
	EarthquakeMapper earthquakeMapper;
	
	public int insertSelective(Earthquake Earthquake) {
        return earthquakeMapper.insertSelective(Earthquake);
    }
	
	public int deleteByPrimaryKey(Integer id){
		return earthquakeMapper.deleteByPrimaryKey(id);
	}
	
    public Earthquake selectByPrimaryKey(Integer id){
    	return earthquakeMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Earthquake record){
    	return earthquakeMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Earthquake> selectEarthquakeList(Earthquake record){
    	List<Earthquake> list = earthquakeMapper.selectEarthquakeList(record);
    	return list;
    }
    
    public PageBean<Earthquake> getEarthquakeByPage(Earthquake record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Earthquake> list = this.selectEarthquakeList(record);
        return new PageBean<Earthquake>(list);
    }
}
