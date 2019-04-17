package com.zwb.mapper;

import com.zwb.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserMapper{

    List<User> findAllUser();
}
