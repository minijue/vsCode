package com.wangjue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangjue.entity.BeerExpert;

public class BeerSelect extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String c = req.getParameter("color");

    BeerExpert be = new BeerExpert();
    List<String> result = be.getBrands(c);

    req.setAttribute("styles", result);
    RequestDispatcher view = req.getRequestDispatcher("result.jsp");
    view.forward(req, resp);
  }
}
