package com.wangjue.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangjue.entity.Dog;

public class ListenerTester extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Dog dog = (Dog) getServletContext().getAttribute("dog");
    req.setAttribute("dog", dog);
    req.setAttribute("b", "breed");

    RequestDispatcher view = req.getRequestDispatcher("dog.jsp");
    view.forward(req, resp);
  }
}
