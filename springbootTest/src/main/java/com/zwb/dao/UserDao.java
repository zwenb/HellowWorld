package com.zwb.dao;

import com.zwb.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, String> {


}
