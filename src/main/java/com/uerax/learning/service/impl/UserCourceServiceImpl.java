package com.uerax.learning.service.impl;

import com.uerax.learning.domain.UserCource;
import com.uerax.learning.domain.UserCourceExample;
import com.uerax.learning.mapper.UserCourceMapper;
import com.uerax.learning.service.UserCourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/20 23:08
 */
@Service
public class UserCourceServiceImpl implements UserCourceService {

    @Autowired
    private UserCourceMapper userCourceMapper;

    @Override
    public List<UserCource> getCourceByUser(UserCource uc) {
        UserCourceExample example = new UserCourceExample();
        UserCourceExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(uc.getUserId());
        return userCourceMapper.selectByExample(example);
    }

    @Override
    public void deleteCource(Integer id) {
        userCourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addCource(UserCource uc) {
        userCourceMapper.insertSelective(uc);
    }
}
