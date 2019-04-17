package com.jvhuaxia.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping("/index")
  public String indexView() {
    return "index";
  }


  @RequestMapping("/unauthorized")
  public String unauthorized() {
    return "unauthorized";
  }

  @RequestMapping("/error")
  public String error() {
    return "error";
  }
}
