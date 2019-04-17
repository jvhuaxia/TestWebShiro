package com.jvhuaxia.dao;

import com.jvhuaxia.pojo.Role;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

  Role selectOne(int id);

  List<Role> selectByUser(String userId);

  void insertOne(@Param("role") Role role);

}
