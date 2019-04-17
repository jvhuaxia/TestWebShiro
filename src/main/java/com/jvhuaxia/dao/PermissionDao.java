package com.jvhuaxia.dao;

import com.jvhuaxia.pojo.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {
    Permission selectOne(int id);

    List<Permission> selectByRole(int roleId);

    void insertOne(Permission permission);
}
