package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from user")
    List<User> list();

    @Insert("insert into user values(uuid(),#{name},#{address})")
    int insert(User user);

    @Update("update user set address=#{address} ,name=#{name} where id=#{id}")
    int update(User user);

    @Delete("delete from user where id =#{id}")
    int delete(String id);
}
