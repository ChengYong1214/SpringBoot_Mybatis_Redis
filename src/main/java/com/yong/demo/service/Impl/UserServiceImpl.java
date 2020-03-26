package com.yong.demo.service.Impl;

import ch.qos.logback.core.boolex.EvaluationException;
import com.yong.demo.dao.UserDao;
import com.yong.demo.pojo.User;
import com.yong.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(value="users")声明该类中缓存块，类中注解不用在指定value
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(value = "userAll")
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    @Cacheable(value = "users",key = "#id")
    /*
    * @Cacheable将返回结果放入users缓存块，后面再使用改方法不需要查数据库（针对查询）
    * 先去缓存中根据key查找数据，如果有直接读取，不会访问该方法；
    * 如果无，调用改方法去数据库读取
    */
    public User selectOneById(Integer id) {
        return userDao.selectOneById(id);
    }

    @Override
    @CacheEvict(value = "users",key = "#id")
    /*
    * @CacheEvict删除users缓存块中key为id的缓存数据（针对删除）
    */
    public Integer deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @CachePut(value = "users",key = "#user.id")
    /*
    * @CachePut即调用方法，又更新缓存(针对更新)
    * 修改数据库中的数据，同时更新缓存数据
    */
    public User updateUser(User user) {
        userDao.updateUser(user);
        return user;
    }

    /*
    * @Caching上述三个组合注解，用来处理复杂缓存
    */

}
