package com.itbulls.learnit.onlinestore.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.core.facades.CategoryFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultCategoryFacade;
import com.itbulls.learnit.onlinestore.persistence.enteties.Category;

@WebServlet("/home-page")

public class HomePageFruitShop extends HttpServlet {

	CategoryFacade categoryFacade = new DefaultCategoryFacade().getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> categories = categoryFacade.getCategories();

		request.setAttribute("categories", categories);

		request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "index.jsp").forward(request, response);
	}


}
