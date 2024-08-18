package com.itbulls.learnit.onlinestore.controllers;

import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultUserFacade;
import com.itbulls.learnit.onlinestore.core.services.Validator;
import com.itbulls.learnit.onlinestore.core.services.impl.PasswordValidator;
import com.itbulls.learnit.onlinestore.persistence.enteties.User;
import com.itbulls.learnit.onlinestore.persistence.enteties.impl.DefaultUser;
import com.itbulls.learnit.onlinestore.filters.PartnerCodeFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/sign-up")

public class SignUpFruitShop extends HttpServlet {

	private UserFacade userFacade = DefaultUserFacade.getInstance();
	private Validator validator = PasswordValidator.getInstance();
	private ResourceBundle rb = ResourceBundle.getBundle(Configurations.RESOURCE_BUNDLE_BASE_NAME);

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "sign-up.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String baseURL = request.getScheme() + "://"
				+ request.getServerName() + ":"
				+ request.getServerPort()
				+ request.getServletContext().getContextPath();

		User user = new DefaultUser();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		// Validate email format
		User existingUser = userFacade.getUserByEmail(user.getEmail());
		if (existingUser != null) {
			request.getSession().setAttribute("errorMessage", rb.getString("signup.err.msg.email.exists"));
			response.sendRedirect(baseURL + "/sign-up");
			return;
		}
		
		// Validate password confirmation
		if (!user.getPassword().equals(request.getParameter("repeat_password"))) {
			request.getSession().setAttribute("errorMessage", rb.getString("signup.err.msg.repeat.password"));
			response.sendRedirect(baseURL + "/sign-up");
			return;
		}
		
		// Validate password format
		if (!validator.isValidate(user.getPassword())) {
			request.getSession().setAttribute("errorMessage", rb.getString("signup.err.msg.special.character"));
			response.sendRedirect(baseURL + "/sign-up");
			return;
		}
		
		String partnerCode = null;
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals(PartnerCodeFilter.PARTNER_CODE_COOKIE_NAME)) {
					partnerCode = cookie.getValue();
				}
			}
		}
		
		userFacade.registerUser(user, partnerCode);
		response.sendRedirect(baseURL + "/sign-in");

	}

}
