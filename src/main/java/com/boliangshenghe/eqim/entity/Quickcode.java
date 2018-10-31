package com.boliangshenghe.eqim.entity;

/**
 * 速报CODE管理
 * 1 发震时刻、震中、震级和震源深度
 * @author xuzj
 *
 */
public class Quickcode {
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