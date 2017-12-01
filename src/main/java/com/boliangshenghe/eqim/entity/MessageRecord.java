package com.boliangshenghe.eqim.entity;

import java.util.Date;

public class MessageRecord {
    private Integer id;

    private Integer uid;

    private Integer cid;

    private String conten;

    private Date createtime;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getConten() {
        return conten;
    }

    public void setConten(String conten) {
        this.conten = conten == null ? null : conten.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}