package com.uerax.learning.service.impl;

import com.uerax.learning.domain.CourseSection;
import com.uerax.learning.domain.CourseSectionExample;
import com.uerax.learning.mapper.CourseSectionMapper;
import com.uerax.learning.service.CourceSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/20 23:07
 */
@Service
public class CourceSectionServiceImpl implements CourceSectionService {

    @Autowired
    private CourseSectionMapper courseSectionMapper;

    @Override
    public List<CourseSection> getCourceSectionByCourceId(Integer courceId) {
        CourseSectionExample ce = new CourseSectionExample();
        CourseSectionExample.Criteria cc = ce.createCriteria();
        cc.andCourseIdEqualTo(courceId);
        return courseSectionMapper.selectByExample(ce);
    }

    @Override
    public void addCourceSection(CourseSection cs) {
        courseSectionMapper.insertSelective(cs);
    }

    @Override
    public List<CourseSection> getCourceSectionByCourceIdWithoutSub(CourseSection cs) {
        return courseSectionMapper.selectWithoutSub(cs.getCourseId());
    }

    @Override
    public List<CourseSection> getWithoutMain(CourseSection cs) {
        CourseSectionExample ce = new CourseSectionExample();
        CourseSectionExample.Criteria cc = ce.createCriteria();
        cc.andParentIdNotEqualTo(0);
        cc.andCourseIdEqualTo(cs.getCourseId());
        ce.setOrderByClause("parent_id, sort");
        return courseSectionMapper.selectByExample(ce);
    }
}
