package com.uerax.learning.domain;

public class UserCource {
    private Integer id;

    private Integer userId;

    private String classify;

    private Integer courceId;

    private String courceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public Integer getCourceId() {
        return courceId;
    }

    public void setCourceId(Integer courceId) {
        this.courceId = courceId;
    }

    public String getCourceName() {
        return courceName;
    }

    public void setCourceName(String courceName) {
        this.courceName = courceName == null ? null : courceName.trim();
    }

    @Override
    public String toString() {
        return "UserCource{" +
                "id=" + id +
                ", userId=" + userId +
                ", classify='" + classify + '\'' +
                ", courceId=" + courceId +
                ", courceName='" + courceName + '\'' +
                '}';
    }
}