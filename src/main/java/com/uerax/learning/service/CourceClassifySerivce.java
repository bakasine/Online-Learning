package com.uerax.learning.service;

import com.uerax.learning.domain.CourceClassify;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/20 20:29
 */
public interface CourceClassifySerivce {
    public List<CourceClassify> getSubClassify(String parentCode);
}
