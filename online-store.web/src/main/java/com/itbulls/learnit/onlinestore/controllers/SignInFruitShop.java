package com.itbulls.learnit.onlinestore.controllers;

import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultUserFacade;
import com.itbulls.learnit.onlinestore.filters.PartnerCodeFilter;
import com.itbulls.learnit.onlinestore.persistence.enteties.User;

import static com.itbulls.learnit.onlinestore.persistence.dto.RoleDto.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SignInFruitShop
 */
@WebServlet("/sign-in")

public class SignInFruitShop extends HttpServlet {

	public static final String LOGGED_IN_USER_ATTR = "loggedInUser";

	private UserFacade userFacade = DefaultUserFacade.getInstance(); // get instance to query user data

	public static final String PARTNER_CODE_PARAMETER_NAME = "partner_code";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER
				+ "sign-in.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = userFacade.getUserByEmail(request.getParameter("email")); // get user by email
		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getServletContext().getContextPath();

		if (user != null && user.getPassword().equals(request.getParameter("password"))) {

			request.getSession().setAttribute(LOGGED_IN_USER_ATTR, user);
			if (user.getRoleName().equals(ADMIN_ROLE_NAME)) {
				response.sendRedirect(baseUrl + "/admin/panel");
			} else {
				response.sendRedirect(baseUrl + "/home-page");
			}
		} else { // when password or email is invalid
			response.sendRedirect(request.getContextPath() + "/sign-in");
		}
	}

}
