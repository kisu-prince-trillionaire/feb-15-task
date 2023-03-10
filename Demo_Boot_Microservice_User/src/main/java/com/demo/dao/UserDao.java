package com.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.bean.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}
