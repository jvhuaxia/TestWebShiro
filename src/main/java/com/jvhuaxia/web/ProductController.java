package com.jvhuaxia.web;


import com.jvhuaxia.dto.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
public class ProductController {

  @RequestMapping("/view/{id}")
  public @ResponseBody
  Result<String> view(@PathVariable Integer id) {
    return new Result<>(true, "假装访问了" + id + "的Product");
  }
}
