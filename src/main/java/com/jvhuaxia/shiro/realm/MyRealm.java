package com.jvhuaxia.shiro.realm;

import com.jvhuaxia.pojo.Permission;
import com.jvhuaxia.pojo.Role;
import com.jvhuaxia.pojo.User;
import com.jvhuaxia.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

  @Autowired
  UserService userService;

  // 为当前登陆成功的用户授予权限和角色，已经登陆成功了
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    String username = (String) principalCollection.getPrimaryPrincipal();
    User user = userService.getUser(username);
    Set<String> roleSet = new HashSet<>();
    Set<String> permissionSet = new HashSet<>();
    for (Role role : user.getRoles()) {
      roleSet.add(role.getName());
      for (Permission permission : role.getPermissions()) {
        permissionSet.add(permission.getName());
      }
    }

    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    authorizationInfo.addRoles(roleSet);
    authorizationInfo.addStringPermissions(permissionSet);
    System.out.println(
        "\r\n\r\n\r\nJvHuaXia 已经登录成功 授权doGetAuthorizationInfo:" + user.toString() + "\r\n\r\n\r\n");

    return authorizationInfo;
  }

  // 验证当前登录的用户，获取认证信息
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {
    String username = (String) authenticationToken.getPrincipal();

    User user = userService.getUser(username);
    if (user != null) {
      System.out.println(
          "\r\n\r\n\r\nJvHuaXia 登录doGetAuthenticationInfo:" + user.toString() + "\r\n\r\n\r\n");
      return new SimpleAuthenticationInfo(user.getName(),
          user.getPassword(), "TestRealm");
    }
    return null;
  }
}
