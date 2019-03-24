package com.uerax.learning.service;

import com.uerax.learning.domain.UserCource;

import java.util.List;

/**
 * @author uerax
 * @date 2019/3/20 23:01
 */
public interface UserCourceService {
    public List<UserCource> getCourceByUser(UserCource uc);
    public void deleteCource(Integer id);
    public void addCource(UserCource uc);
}
