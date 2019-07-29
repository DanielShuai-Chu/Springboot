package com.example.demo.service;

import com.example.demo.DemoApplication;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    @Autowired
    private UserDao userDao;

    @Cacheable(value = "user")
    public List<User> list() {
        System.out.println("打印本句说明未走缓存！");
        return userDao.list();
    }

    @CacheEvict(value = "user", allEntries = true)
    public int insert(User user) {
        logger.info("插入！" + user);
        return userDao.insert(user);
    }

    @CacheEvict(value = "user", allEntries = true)
    public int delete(String id) {
        logger.info("删除" + id);
        return userDao.delete(id);
    }

    @CacheEvict(value = "user", allEntries = true)
    public int update(User user) {
        logger.info("修改" + user);
        return userDao.update(user);
    }
}

