package com.wangjue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangjue.entity.BeerExpert;

public class BeerSelect extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("Beer Selection Advice<br>");
    String c = req.getParameter("color");

    BeerExpert be = new BeerExpert();
    List<String> result = be.getBrands(c);
    for (String s : result) {
      out.println("<br>try: <span style=\"color: " + c + ";\">" + s + "</span>");
    }
  }
}
