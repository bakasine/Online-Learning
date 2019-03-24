package com.uerax.learning.service.impl;

import com.uerax.learning.domain.User;
import com.uerax.learning.domain.UserExample;
import com.uerax.learning.mapper.UserMapper;
import com.uerax.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author uerax
 * @date 2018/12/20 19:47
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User getUser(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public List<User> getUserByUsername(User user) {

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());


        return userMapper.selectByExample(example);
    }

    @Override
    public boolean checkUser(User user) {
        if (getUserByUsername(user).isEmpty()) {
            return false;
        }
        if (!(getUserByUsername(user).get(0).getPassword().equals(user.getPassword()))) {
            return false;
        }

        return true;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
