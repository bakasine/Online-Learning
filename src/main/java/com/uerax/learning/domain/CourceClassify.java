package com.uerax.learning.domain;

public class CourceClassify {
    private Integer id;

    private String courceName;

    private String courceCode;

    private String parentCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourceName() {
        return courceName;
    }

    public void setCourceName(String courceName) {
        this.courceName = courceName == null ? null : courceName.trim();
    }

    public String getCourceCode() {
        return courceCode;
    }

    public void setCourceCode(String courceCode) {
        this.courceCode = courceCode == null ? null : courceCode.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }
}