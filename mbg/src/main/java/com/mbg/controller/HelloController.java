package com.mbg.controller;

import com.mbg.entity.User;
import com.mbg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    UserMapper userMapper;


    @RequestMapping("/list")
    public  List<User> showHelloWorld(){
        List<User> list = userMapper.selectAll();
        return list;
    }

    @RequestMapping("/add")
    public int addUser(String name,String password){
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        int rst = userMapper.insert(user);
        return rst;
    }
}
