package com.zwb.controller;

import com.zwb.model.User;
import com.zwb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/all")
    public Object findAllUser(){
        return userService.findAllUser(1,5);
    }

}
