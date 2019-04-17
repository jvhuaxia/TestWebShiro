package com.jvhuaxia.service.impl;

import com.jvhuaxia.dao.RoleDao;
import com.jvhuaxia.dao.StaticRolePermissionDao;
import com.jvhuaxia.pojo.Permission;
import com.jvhuaxia.pojo.Role;
import com.jvhuaxia.pojo.StaticRolePermission;
import com.jvhuaxia.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleDao roleDao;

  @Autowired
  StaticRolePermissionDao staticRolePermissionDao;

  @Override
  public void insertRole(Role role) {
    roleDao.insertOne(role);
    List<Permission> permissions = role.getPermissions();
    for (Permission permission : permissions) {
      staticRolePermissionDao
          .insert(new StaticRolePermission(role.getId(), permission.getId(), permission.getNote()));
    }
  }
}
