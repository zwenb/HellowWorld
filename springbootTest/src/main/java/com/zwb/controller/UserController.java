package com.zwb.controller;

import com.zwb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
@RestController
public class UserController {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/all")
    public Object findAllUser(){
        logger.info("hello worlddcvdzxc zxzccxz -------------!");
        return userService.findAllUser(1,5);
    }

}
