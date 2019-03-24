package com.uerax.learning.service.impl;

import com.uerax.learning.domain.Cource;
import com.uerax.learning.domain.CourceExample;
import com.uerax.learning.mapper.CourceMapper;
import com.uerax.learning.service.CourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uerax
 * @date 2019/3/19 21:11
 */
@Service
public class CourceServiceImpl implements CourceService {

    @Autowired
    private CourceMapper courceMapper;

    @Override
    public List<Cource> getCource(Cource cource) {
        CourceExample ce = new CourceExample();
        CourceExample.Criteria cc = ce.createCriteria();
        cc.andCreaterEqualTo(cource.getCreater());
        return courceMapper.selectByExample(ce);
    }

    @Override
    public void updateCourceSection(Cource cource) {

    }

    @Override
    public void deleteCource(Cource cource) {
         courceMapper.deleteByPrimaryKey(cource.getId());
    }

    @Override
    public void addCource(Cource cource) {
        courceMapper.insertSelective(cource);
    }

    @Override
    public List<Cource> getAllCource() {
        return courceMapper.selectByExample(null);
    }

    @Override
    public Cource getCourceById(Cource cource) {
        return courceMapper.selectByPrimaryKey(cource.getId());
    }

    @Override
    public List<Cource> getCourceByClassify(Cource cource) {

        CourceExample ce = new CourceExample();
        CourceExample.Criteria cc = ce.createCriteria();
        cc.andClassifyEqualTo(cource.getClassify());
        return courceMapper.selectByExample(ce);
    }
}
