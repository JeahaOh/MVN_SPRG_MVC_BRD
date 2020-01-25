package com.study.brd.common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
  protected final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
  
  @SuppressWarnings("rawtypes")
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
    logger.debug( "============================ LoggerInterceptor START ============================");
    logger.debug( "URI [{}].", req.getRequestURI());
    
    Enumeration paramNames = req.getParameterNames();
    while( paramNames.hasMoreElements()) {
      String key = (String) paramNames.nextElement();
      String value = req.getParameter(key);
      logger.debug("RequestParameter DATA --> {} : {}", key, value);
    }
    return super.preHandle(req, res, handler);
  }
  
  @Override
  public void postHandle(HttpServletRequest req, HttpServletResponse res, Object Handler, ModelAndView mNv) throws Exception {
    logger.debug( "============================ LoggerInterceptor E N D ============================\n\n");
  }

}
