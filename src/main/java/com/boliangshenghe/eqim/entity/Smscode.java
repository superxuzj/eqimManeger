package com.boliangshenghe.eqim.entity;

/**
 * 短信震级CODE管理
 * 1 国内3.0级以上
 * 2 国内东部地区4.0级以上、西部地区4.5级以上
 * 3 国际陆地6.0级以上、海域7.0级以上
 * @author xuzj
 *
 */
public class Smscode {
    private Integer id;

    private String name;

    private String code;

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
}