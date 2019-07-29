package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> Find() {
        List<User> users = userService.list();
        return users;
    }

    @GetMapping("insert")
    public String insert() {
        User user = new User();
        user.setName("wangdong");
        user.setAddress("李刚");
        int s = userService.insert(user);
        if (s == 1) {
            return "插入成功";
        } else {

            return "插入失败";
        }
    }

    @GetMapping("delete")
    public String delete() {
        String id = "f4330846-af51-11e9-b327-448a5b88b607";
        int s = userService.delete(id);
        if (s == 1) {
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
    @GetMapping("update")
    public String update(){
        User user = new User();
        user.setId("2d6f3d70-af70-11e9-b327-448a5b88b607");
        user.setAddress("森林狼");
        user.setName("王府井");
        userService.update(user);
        return "修改成功";
    }
}