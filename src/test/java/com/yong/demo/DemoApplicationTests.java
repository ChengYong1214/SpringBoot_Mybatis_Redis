package com.yong.demo;

import com.yong.demo.dao.UserDao;
import com.yong.demo.pojo.User;
import com.yong.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        User user=new User();
        user.setId(9);
        user.setPassword("11221");
        user.setUsername("11q1");
        System.out.println(userDao.updateUser(user).toString());
    }

}
