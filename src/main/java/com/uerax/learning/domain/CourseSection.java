package com.uerax.learning.domain;

import java.util.Date;

public class CourseSection {
    private Integer id;

    private Integer courseId;

    private Integer parentId;

    private String name;

    private Integer sort;

    private String url;

    private Date createDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateDay() {
        return createDay;
    }

    public void setCreateDay(Date createDay) {
        this.createDay = createDay;
    }

    @Override
    public String toString() {
        return "CourseSection{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", url='" + url + '\'' +
                ", createDay=" + createDay +
                '}';
    }
}