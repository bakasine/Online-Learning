package com.uerax.learning.service.impl;

import com.uerax.learning.domain.CourceClassify;
import com.uerax.learning.domain.CourceClassifyExample;
import com.uerax.learning.mapper.CourceClassifyMapper;
import com.uerax.learning.service.CourceClassifySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/20 20:30
 */
@Service
public class CourceClassifyServiceImpl implements CourceClassifySerivce {

    @Autowired
    private CourceClassifyMapper courceClassifyMapper;

    @Override
    public List<CourceClassify> getSubClassify(String parentCode) {
        return courceClassifyMapper.getByParentCode(parentCode);
    }
}
