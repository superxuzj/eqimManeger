package com.boliangshenghe.eqim.entity;

public class Company {
    private Integer id;

    private String name;

    private String code;

    private String smscode;

    private String quickcode;

    private String messagecode;

    private String ismessage;

    private String state;

    private String liaisonname;

    private String liaisonphone;

    private Integer liaisonid;

    private String contactname;

    private String contactphone;

    private Integer contactid;
    
    private Integer start;
    
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode == null ? null : smscode.trim();
    }

    public String getQuickcode() {
        return quickcode;
    }

    public void setQuickcode(String quickcode) {
        this.quickcode = quickcode == null ? null : quickcode.trim();
    }

    public String getMessagecode() {
        return messagecode;
    }

    public void setMessagecode(String messagecode) {
        this.messagecode = messagecode == null ? null : messagecode.trim();
    }

    public String getIsmessage() {
        return ismessage;
    }

    public void setIsmessage(String ismessage) {
        this.ismessage = ismessage == null ? null : ismessage.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getLiaisonname() {
        return liaisonname;
    }

    public void setLiaisonname(String liaisonname) {
        this.liaisonname = liaisonname == null ? null : liaisonname.trim();
    }

    public String getLiaisonphone() {
        return liaisonphone;
    }

    public void setLiaisonphone(String liaisonphone) {
        this.liaisonphone = liaisonphone == null ? null : liaisonphone.trim();
    }

    public Integer getLiaisonid() {
        return liaisonid;
    }

    public void setLiaisonid(Integer liaisonid) {
        this.liaisonid = liaisonid;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone == null ? null : contactphone.trim();
    }

    public Integer getContactid() {
        return contactid;
    }

    public void setContactid(Integer contactid) {
        this.contactid = contactid;
    }

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}