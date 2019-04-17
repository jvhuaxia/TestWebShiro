package com.jvhuaxia.service.impl;


import com.jvhuaxia.dao.StaticRolePermissionDao;
import com.jvhuaxia.dao.StaticUserRoleDao;
import com.jvhuaxia.dao.UserDao;
import com.jvhuaxia.pojo.Role;
import com.jvhuaxia.pojo.StaticUserRole;
import com.jvhuaxia.pojo.User;
import com.jvhuaxia.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private StaticRolePermissionDao staticRolePermissionDao;

  @Autowired
  private StaticUserRoleDao staticUserRoleDao;

  @Override
  public void saveUser(User user) {
    userDao.insertOne(user);

    List<Role> roles = user.getRoles();
    for (Role role : roles) {
      staticUserRoleDao.insert(new StaticUserRole(user.getId(), role.getId(), role.getNote()));
    }
  }

  @Override
  public User getUser(String userName) {
    return userDao.selectByName(userName);
  }
}
