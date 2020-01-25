package com.study.brd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/test")
public class TestController {
  @RequestMapping(value = "/getTest")
  public void getTest(HttpServletRequest req, HttpServletResponse res) throws Exception {
    System.out.println("getTest");
  }

}
