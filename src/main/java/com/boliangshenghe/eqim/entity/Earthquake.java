package com.boliangshenghe.eqim.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Earthquake {
    private Integer id;

    private String eqname;

    private String eventid;

    private String location;

    private String magnitude;

    private String longitude;

    private String latitude;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date eqtime;

    private String depth;

    private Date createtime;

    private String creator;

    private String weather;

    private String towncount;

    private String peoplesum;

    private String hazardcount;

    private String demaver;
    
    private Integer limit;
    
    private Integer start;
    
    private Integer cid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname == null ? null : eqname.trim();
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid == null ? null : eventid.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude == null ? null : magnitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Date getEqtime() {
        return eqtime;
    }

    public void setEqtime(Date eqtime) {
        this.eqtime = eqtime;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth == null ? null : depth.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public String getTowncount() {
        return towncount;
    }

    public void setTowncount(String towncount) {
        this.towncount = towncount == null ? null : towncount.trim();
    }

    public String getPeoplesum() {
        return peoplesum;
    }

    public void setPeoplesum(String peoplesum) {
        this.peoplesum = peoplesum == null ? null : peoplesum.trim();
    }

    public String getHazardcount() {
        return hazardcount;
    }

    public void setHazardcount(String hazardcount) {
        this.hazardcount = hazardcount == null ? null : hazardcount.trim();
    }

    public String getDemaver() {
        return demaver;
    }

    public void setDemaver(String demaver) {
        this.demaver = demaver == null ? null : demaver.trim();
    }

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
}