package com.zwb.controller;

import com.zwb.dao.UserDao;
import com.zwb.model.User;
import com.zwb.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EsController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/addUser")
    @ResponseBody
    public UserEntity addUser(UserEntity user){
        return userDao.save(user);
    }

    @GetMapping("/findById")
    public Optional<UserEntity> findById(String id){
        return userDao.findById(id);
    }
}
