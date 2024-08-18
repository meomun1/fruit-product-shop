package com.itbulls.learnit.onlinestore.filters;

import static com.itbulls.learnit.onlinestore.controllers.SignInFruitShop.*;
import static com.itbulls.learnit.onlinestore.persistence.dto.RoleDto.*;


import com.itbulls.learnit.onlinestore.persistence.enteties.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(servletNames = {"purchase", "fulfilment"})
public class ManagementFilter extends HttpFilter implements Filter {
       
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		User user = (User)((HttpServletRequest)request).getSession().getAttribute(LOGGED_IN_USER_ATTR);
		System.out.println(user);
		if (user != null) {
			if (user.getRoleName().equals(MANAGER_ROLE_NAME)) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse)response).sendError(403);
			}
		} else {
			((HttpServletResponse)response).sendRedirect(
					request.getScheme()
				      + "://"
				      + request.getServerName()
				      + ":"
				      + request.getServerPort()
				      + request.getServletContext().getContextPath() + "/sign-in");
		}
	}


}
