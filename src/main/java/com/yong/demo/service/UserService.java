package com.yong.demo.service;



import com.yong.demo.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectAllUsers();
    public User selectOneById(Integer id);
    public Integer deleteUserById(Integer id);
    public Integer insertUser(User user);
    public User updateUser(User user);
}
