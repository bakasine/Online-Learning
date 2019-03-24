package com.uerax.learning.service;

import com.uerax.learning.domain.CourseSection;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/20 23:07
 */
public interface CourceSectionService {
    public List<CourseSection> getCourceSectionByCourceId(Integer courceId);
    public void addCourceSection(CourseSection cs);
    public List<CourseSection> getCourceSectionByCourceIdWithoutSub(CourseSection cs);
    public List<CourseSection> getWithoutMain(CourseSection cs);
}
