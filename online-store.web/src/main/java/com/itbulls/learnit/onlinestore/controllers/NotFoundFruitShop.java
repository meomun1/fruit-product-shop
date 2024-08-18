package com.itbulls.learnit.onlinestore.controllers;

import java.io.IOException;

import com.itbulls.learnit.onlinestore.Configurations;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/not-found")
public class NotFoundFruitShop {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "notfound.jsp").forward(request, response);
    }
}
