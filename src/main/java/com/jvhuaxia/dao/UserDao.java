package com.jvhuaxia.dao;

import com.jvhuaxia.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserDao {

  User selectOne(String id);

  User selectByName(String name);

  void insertOne(@Param("user") User user);
}
