package com.boliangshenghe.eqim.entity;

import java.util.Date;

public class Catalog {
    private String cataId;

    private String eventId;

    private String operator;

    private Date saveTime;

    private String eqType;

    private Date oTime;

    private Integer oTimeNs;

    private Double lat;

    private Double lon;

    private Double depth;

    private Double ml;

    private Double ms;

    private Double md;

    private Double mb;

    private Double mmb;

    private Double mw;

    private Double m;

    private Double dmin;

    private Double gapAzi;

    private Double rms;

    private Double erh;

    private Double erz;

    private String qloc;

    private String qnet;

    private String qcom;

    private Integer sumStn;

    private Integer usedStn;

    private Integer sumPha;

    private Integer usedPha;

    private String explosionFlag;

    private String epicId;

    private String sourceId;

    private String locationCname;

    public String getCataId() {
        return cataId;
    }

    public void setCataId(String cataId) {
        this.cataId = cataId == null ? null : cataId.trim();
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(Date saveTime) {
        this.saveTime = saveTime;
    }

    public String getEqType() {
        return eqType;
    }

    public void setEqType(String eqType) {
        this.eqType = eqType == null ? null : eqType.trim();
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public Integer getoTimeNs() {
        return oTimeNs;
    }

    public void setoTimeNs(Integer oTimeNs) {
        this.oTimeNs = oTimeNs;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getMl() {
        return ml;
    }

    public void setMl(Double ml) {
        this.ml = ml;
    }

    public Double getMs() {
        return ms;
    }

    public void setMs(Double ms) {
        this.ms = ms;
    }

    public Double getMd() {
        return md;
    }

    public void setMd(Double md) {
        this.md = md;
    }

    public Double getMb() {
        return mb;
    }

    public void setMb(Double mb) {
        this.mb = mb;
    }

    public Double getMmb() {
        return mmb;
    }

    public void setMmb(Double mmb) {
        this.mmb = mmb;
    }

    public Double getMw() {
        return mw;
    }

    public void setMw(Double mw) {
        this.mw = mw;
    }

    public Double getM() {
        return m;
    }

    public void setM(Double m) {
        this.m = m;
    }

    public Double getDmin() {
        return dmin;
    }

    public void setDmin(Double dmin) {
        this.dmin = dmin;
    }

    public Double getGapAzi() {
        return gapAzi;
    }

    public void setGapAzi(Double gapAzi) {
        this.gapAzi = gapAzi;
    }

    public Double getRms() {
        return rms;
    }

    public void setRms(Double rms) {
        this.rms = rms;
    }

    public Double getErh() {
        return erh;
    }

    public void setErh(Double erh) {
        this.erh = erh;
    }

    public Double getErz() {
        return erz;
    }

    public void setErz(Double erz) {
        this.erz = erz;
    }

    public String getQloc() {
        return qloc;
    }

    public void setQloc(String qloc) {
        this.qloc = qloc == null ? null : qloc.trim();
    }

    public String getQnet() {
        return qnet;
    }

    public void setQnet(String qnet) {
        this.qnet = qnet == null ? null : qnet.trim();
    }

    public String getQcom() {
        return qcom;
    }

    public void setQcom(String qcom) {
        this.qcom = qcom == null ? null : qcom.trim();
    }

    public Integer getSumStn() {
        return sumStn;
    }

    public void setSumStn(Integer sumStn) {
        this.sumStn = sumStn;
    }

    public Integer getUsedStn() {
        return usedStn;
    }

    public void setUsedStn(Integer usedStn) {
        this.usedStn = usedStn;
    }

    public Integer getSumPha() {
        return sumPha;
    }

    public void setSumPha(Integer sumPha) {
        this.sumPha = sumPha;
    }

    public Integer getUsedPha() {
        return usedPha;
    }

    public void setUsedPha(Integer usedPha) {
        this.usedPha = usedPha;
    }

    public String getExplosionFlag() {
        return explosionFlag;
    }

    public void setExplosionFlag(String explosionFlag) {
        this.explosionFlag = explosionFlag == null ? null : explosionFlag.trim();
    }

    public String getEpicId() {
        return epicId;
    }

    public void setEpicId(String epicId) {
        this.epicId = epicId == null ? null : epicId.trim();
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public String getLocationCname() {
        return locationCname;
    }

    public void setLocationCname(String locationCname) {
        this.locationCname = locationCname == null ? null : locationCname.trim();
    }
}