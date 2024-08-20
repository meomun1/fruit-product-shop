package com.itbulls.learnit.onlinestore.owasp.bac.problem;

import java.io.IOException;
import java.util.List;

import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.controllers.SignInFruitShop;
import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultUserFacade;
import com.itbulls.learnit.onlinestore.filters.PartnerCodeFilter;
import com.itbulls.learnit.onlinestore.persistence.enteties.User;
import com.itbulls.learnit.onlinestore.persistence.enteties.impl.DefaultUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user-profile")
public class UserProfileServet extends HttpServlet {

    private UserFacade userFacade = DefaultUserFacade.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        if(id != null && !id.isBlank()){
            User user = userFacade.getUserById(Integer.parseInt(id));

            String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletContext().getContextPath();
            String partnerLink = baseUrl + "?" + PartnerCodeFilter.PARTNER_CODE_PARAMETER_NAME + "="
					+ user.getPartnerCode();
            List<User> referrals = userFacade.getReferralsForUser(user);
            request.setAttribute(SignInFruitShop.LOGGED_IN_USER_ATTR, user);
			request.setAttribute("referrals", referrals);
			request.setAttribute("partnerLink", partnerLink);
			request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "/my-profile.jsp").forward(request,
					response);
        } else{
            request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "/sign-in.jsp").forward(request, response);
        }
    }
}
