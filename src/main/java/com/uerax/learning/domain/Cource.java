package com.uerax.learning.domain;

import java.util.Date;

/**
 * 课程表
 */
public class Cource {
    private Integer id;

    private String name;

    private String classify;

    private String subClassify;

    private String creater;

    private Boolean free;

    private Integer price;

    private String introduce;

    private Date createDay;

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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getSubClassify() {
        return subClassify;
    }

    public void setSubClassify(String subClassify) {
        this.subClassify = subClassify == null ? null : subClassify.trim();
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    @Override
    public String toString() {
        return "Cource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classify='" + classify + '\'' +
                ", subClassify='" + subClassify + '\'' +
                ", creater='" + creater + '\'' +
                ", free=" + free +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", createDay=" + createDay +
                '}';
    }
}