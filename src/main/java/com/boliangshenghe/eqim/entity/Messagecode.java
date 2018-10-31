package com.boliangshenghe.eqim.entity;
/**
 * 灾情信息CODE管理
 * 1,2,3,4 有灾情
 * 6没有灾情
 * @author xuzj
 *
 */
public class Messagecode {
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