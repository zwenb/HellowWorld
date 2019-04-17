package com.zwb.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwb.mapper.UserMapper;
import com.zwb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService {

    @Autowired
    private UserMapper dao;

    //这个方法中用到了我们开头配置依赖的分页插件pagehelper
    //很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    //pageNum 开始页数
    //pageSize 每页显示的数据条数
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> user = dao.findAllUser();
        PageInfo result = new PageInfo(user);
        return result;
    }

}
