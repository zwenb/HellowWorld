package com.zwb.mapper;

import com.zwb.model.User;
import java.util.List;


public interface UserMapper{

    List<User> findAllUser();

    int addUser(User user);
}
