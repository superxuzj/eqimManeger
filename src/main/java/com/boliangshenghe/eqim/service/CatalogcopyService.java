package com.boliangshenghe.eqim.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boliangshenghe.eqim.common.PageBean;
import com.boliangshenghe.eqim.controller.activemq.TopicSender;
import com.boliangshenghe.eqim.entity.Catalog;
import com.boliangshenghe.eqim.entity.Catalogcopy;
import com.boliangshenghe.eqim.entity.Jdata;
import com.boliangshenghe.eqim.repository.CatalogcopyMapper;
import com.boliangshenghe.eqim.repository.JdataMapper;
import com.boliangshenghe.eqim.util.CommonUtils;
import com.boliangshenghe.eqim.util.JsonUtils;
import com.github.pagehelper.PageHelper;

@Service
public class CatalogcopyService {
	
	@Autowired
	CatalogcopyMapper catalogcopyMapper;
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	JdataMapper jdataMapper;
	
	@Resource
	TopicSender topicSender;
	
	private String eventid_temp = CommonUtils.SEARCH_TIME;
	
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
    
    public Catalogcopy selectCatalogcopyByEventId(String eventId){
    	Catalogcopy record = new Catalogcopy();
    	record.setEventId(eventId);
    	List<Catalogcopy> list = catalogcopyMapper.selectCatalogcopyList(record);
    	if(null!=list && list.size()>0){
    		return list.get(0);
    	}
    	return null;
    }
    
    
    //根据Eventid去重
    public Set<String> selectCatalogcopyEventIDList(Catalogcopy record){
    	List<Catalogcopy> jlist = catalogcopyMapper.selectCatalogcopyEventIDList(record);
    	Set<String> jset = new HashSet<String>();
    	for (Catalogcopy jdata : jlist) {
    		jset.add(jdata.getEventId());
		}
    	return jset;
    }
    
    public PageBean<Catalogcopy> getCatalogcopyByPage(Catalogcopy record,Integer pageNo) {
        PageHelper.startPage(pageNo,CommonUtils.PAGESIZE);
        List<Catalogcopy> list = this.selectCatalogcopyList(record);
        return new PageBean<Catalogcopy>(list);
    }
    
    /**
     * 定时任务代码
     */
    public void insertrecordByTask(){
    	Catalog record = new Catalog();
    	System.out.println(eventid_temp+" eventid_temp");
    	record.setEventId(eventid_temp);//获取源数据
    	List<Catalog> listsource = catalogService.selectCatalogList(record);
    	
    	//Set<String> eventids = this.selectCatalogcopyEventIDList(new Catalogcopy());
    	if(null!= listsource&& listsource.size()>0){
    		for (Catalog catalog : listsource) {
    			Catalogcopy cl = this.selectCatalogcopyByEventId(catalog.getEventId());
    			if(null!=cl && cl.getJsonstate().equals("1")){//复制表里面已经有了数据，也有了json数据,说明该记录处理完了
    				eventid_temp = catalog.getEventId();//重置查询条件，减少查询次数
    				continue;
    			}else if(null!=cl && cl.getJsonstate().equals("2")){//复制表里面已经有了数据，没有json数据
    				Jdata jdata = new Jdata();
    				jdata.setEventid(catalog.getEventId());
					List<Jdata> jlist = jdataMapper.selectJdataList(jdata);
    				if(null!=jlist && jlist.size()>0){
    					cl.setJsonstate("1");//有json数据
    					eventid_temp = catalog.getEventId();//重置查询条件，减少查询次数
        				this.updateByPrimaryKeySelective(cl);
    				}
    				
    			}else{
    				Catalogcopy catalogcopy = new Catalogcopy();
    				catalogcopy.setCataId(catalog.getCataId());
    				catalogcopy.setDepth(catalog.getDepth());
    				catalogcopy.setDmin(catalog.getDmin());
    				catalogcopy.setEventId(catalog.getEventId());
    				catalogcopy.setLat(catalog.getLat());
    				catalogcopy.setLon(catalog.getLon());
    				catalogcopy.setM(catalog.getM());
    				catalogcopy.setMl(catalog.getMl());
    				catalogcopy.setoTime(catalog.getoTime());
    				catalogcopy.setoTimeNs(catalog.getoTimeNs());
    				catalogcopy.setSaveTime(catalog.getSaveTime());
    				catalogcopy.setCataId(catalog.getCataId());
    				catalogcopy.setOperator(catalog.getOperator());
    				catalogcopy.setLocationCname(catalog.getLocationCname());
    				Jdata jdata = new Jdata();
    				jdata.setEventid(catalog.getEventId());
					List<Jdata> jlist = jdataMapper.selectJdataList(jdata);
    				if(null!=jlist && jlist.size()>0){
    					catalogcopy.setJsonstate("1");//有json数据
    					eventid_temp = catalog.getEventId();//重置查询条件，减少查询次数
    				}else{
    					catalogcopy.setJsonstate("2");//mei有json数据
    				}
    				this.insertSelective(catalogcopy); //插入到复制表中
    				
    				//发短信
    				
    				//消息队列发布
    				String message = JsonUtils.objtoJSONString(catalogcopy);
    				topicSender.send("eqimearthquake.topic", message);
    				
    			}
    		}
    	}
    }
}
