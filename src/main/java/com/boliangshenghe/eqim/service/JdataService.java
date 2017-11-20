package com.boliangshenghe.eqim.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.entity.Jdata;
import com.boliangshenghe.eqim.repository.JdataMapper;
import com.github.pagehelper.PageHelper;

@Service
public class JdataService {

	@Autowired
	JdataMapper jdataMapper;
	public int insertSelective(Jdata jdata) {
        return jdataMapper.insertSelective(jdata);
    }
    
    public Jdata selectByPrimaryKey(Integer id){
    	return jdataMapper.selectByPrimaryKey(id);
    }
    
    public  int updateByPrimaryKeySelective(Jdata record){
    	return jdataMapper.updateByPrimaryKeySelective(record);
    }
    
    public List<Jdata> selectJdataList(Jdata record){
    	return jdataMapper.selectJdataList(record);
    }
    
    public PageBean<Jdata> getJdataByPage(Jdata record,Integer pageNo,Integer size) {
        PageHelper.startPage(pageNo,size);
        List<Jdata> list = this.jdataMapper.selectJdataList(record);
        return new PageBean<Jdata>(list);
    }
    
    //根据Eventid去重
    public Set<String> selectEventidSet(Jdata record){
    	List<Jdata> jlist = jdataMapper.selectJdataEventIDList(record);
    	Set<String> jset = new HashSet<String>();
    	for (Jdata jdata : jlist) {
    		jset.add(jdata.getEventid());
		}
    	return jset;
    }
}
