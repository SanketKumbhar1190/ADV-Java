package com.sanket.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.io.IOException;

@WebServlet("/FristServlet")
public class FristServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write("<h1>Hello World</h1>");
        response.getWriter().write("<p>Welcome to the first servlet!</p>");
        response.getWriter().write("<p>Current Time: " + java.time.LocalTime.now() + "</p>");
    }
    
}
