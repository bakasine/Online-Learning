package com.uerax.learning.service;

import com.uerax.learning.domain.User;

import java.util.List;

/**
 * @author uerax
 * @date 2018/12/20 19:44
 */
public interface UserService {
    public void addUser(User user);
    public User getUser(User user);
    public List<User> getUserByUsername(User user);
    public boolean checkUser(User user);
    public void updateUser(User user);

}
