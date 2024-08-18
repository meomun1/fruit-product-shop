package com.itbulls.learnit.onlinestore.controllers;

import java.io.IOException;

import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.core.facades.ProductFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultProductFacade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product-detail")
public class ProductPageFruitShop extends HttpServlet{

    public static final long serialVersionUID = 1L;

    private ProductFacade productFacade;

    {
        productFacade = DefaultProductFacade.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("productId");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            request.setAttribute("product", productFacade.getProductById(id));
            request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER+"product-detail.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product id is required");
        }
    }
    
}
