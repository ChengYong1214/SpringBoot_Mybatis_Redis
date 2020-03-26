package com.yong.demo.dao;


import com.yong.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    //@Select("select id,username,password from user")
    public List<User> selectAllUsers();
    public User selectOneById(Integer id);
    public Integer deleteUserById(Integer id);
    public Integer insertUser(User user);
    public Integer updateUser(User user);
}
