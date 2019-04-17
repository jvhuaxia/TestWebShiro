package com.jvhuaxia.web;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

  @RequestMapping("/loginView")
  public String loginView() {
    return "login";
  }

  @RequestMapping("/loginCheck")
  public String loginCheck(String userName, String password,
      HttpServletRequest httpServletRequest) {
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
    try {
      subject.login(token);
      return "redirect:/index";
    } catch (Exception e) {
      httpServletRequest.getSession().setAttribute("errorException", e.toString());
      return "redirect:/error";
    }
  }

}
