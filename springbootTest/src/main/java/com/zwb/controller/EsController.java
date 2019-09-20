package com.zwb.controller;

import com.zwb.dao.UserDao;
import com.zwb.model.User;
import com.zwb.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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

    @GetMapping("/batchAddUser")
    @ResponseBody
    public Object batchAddUser() {
        long startTime = System.currentTimeMillis();
        int n = 0;
        for (int i = 0; i < 1; i++) {
            UserEntity user = new UserEntity();
            user.setId(String.valueOf(new Random().nextInt()));
            user.setAge(new Random().nextInt(99));
            user.setSex("女");
            user.setUserName("小明" + new Random().nextInt(99));
            UserEntity result = userDao.save(user);

            if (result != null) {
                n++;
            }
        }
        long endTime = System.currentTimeMillis();
        long t = endTime - startTime;
        Map resultMap = new HashMap();
        resultMap.put("t", t);
        resultMap.put("n", n);
        return resultMap;
    }
}
