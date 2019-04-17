package com.jvhuaxia.dao;


import com.jvhuaxia.pojo.StaticRolePermission;

public interface StaticRolePermissionDao {
    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(StaticRolePermission record);

    int insertSelective(StaticRolePermission record);

    StaticRolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByPrimaryKeySelective(StaticRolePermission record);

    int updateByPrimaryKey(StaticRolePermission record);
}