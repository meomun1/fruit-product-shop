package com.itbulls.learnit.onlinestore.owasp.bac.solution;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultUserFacade;
import com.itbulls.learnit.onlinestore.persistence.enteties.User;
import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.controllers.SignInFruitShop;
import com.itbulls.learnit.onlinestore.filters.PartnerCodeFilter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private UserFacade userFacade = DefaultUserFacade.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedInUser = (User)request.getSession().getAttribute(SignInFruitShop.LOGGED_IN_USER_ATTR);
		
		if (loggedInUser != null) {
			String baseUrl = request.getScheme()
				      + "://"
				      + request.getServerName()
				      + ":"
				      + request.getServerPort()
				      + request.getServletContext().getContextPath();
			String partnerLink = baseUrl + "?" 
				      + PartnerCodeFilter.PARTNER_CODE_PARAMETER_NAME 
				      + "=" + loggedInUser.getPartnerCode();
			List<User> referrals = userFacade.getReferralsForUser(loggedInUser);
			loggedInUser = userFacade.getUserById(loggedInUser.getId());
			// We need to fetch latest state of the user from the database
			request.getSession().setAttribute(SignInFruitShop.LOGGED_IN_USER_ATTR, loggedInUser);
			
			request.setAttribute("referrals", referrals);
			request.setAttribute("partnerLink", partnerLink);
			request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "/my-profile.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "/sign-in.jsp").forward(request, response);
		}
	}
}