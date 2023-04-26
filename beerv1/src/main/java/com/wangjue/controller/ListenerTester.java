package com.wangjue.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangjue.entity.Dog;

public class ListenerTester extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();

    out.println("<h1>Test context attributes set by listener</h1>");
    Dog dog = (Dog) getServletContext().getAttribute("dog");
    out.println("Dog's breed is: " + dog.getBreed());
  }

}
