package com.jvhuaxia.dao;


import com.jvhuaxia.pojo.StaticUserRole;

public interface StaticUserRoleDao {
    int deleteByPrimaryKey(Integer userRoleId);

    int insert(StaticUserRole record);

    int insertSelective(StaticUserRole record);

    StaticUserRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(StaticUserRole record);

    int updateByPrimaryKey(StaticUserRole record);
}