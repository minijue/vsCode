package com.wangjue.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wangjue.entity.Dog;

public class MyServletContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext sc = sce.getServletContext();
    String dogBreed = sc.getInitParameter("breed");
    Dog d = new Dog(dogBreed);
    sc.setAttribute("dog", d);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'contextDestroyed'");
  }

}
