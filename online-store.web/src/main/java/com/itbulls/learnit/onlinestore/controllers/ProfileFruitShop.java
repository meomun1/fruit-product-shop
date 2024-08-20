package com.itbulls.learnit.onlinestore.controllers;

import java.io.IOException;
import java.util.List;

import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.core.facades.UserFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultUserFacade;
import com.itbulls.learnit.onlinestore.filters.PartnerCodeFilter;
import com.itbulls.learnit.onlinestore.persistence.enteties.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/my-profile")
public class ProfileFruitShop extends HttpServlet {

    private UserFacade userFacade = DefaultUserFacade.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User loggedInUser = (User) request.getSession().getAttribute(SignInFruitShop.LOGGED_IN_USER_ATTR);

        if(loggedInUser == null) {
            response.sendRedirect(request.getContextPath() + "/sign-in");
            return;
        }
        else{
            String baseURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletContext().getContextPath();
            
            String partnerLink = baseURL + "?" + PartnerCodeFilter.PARTNER_CODE_PARAMETER_NAME + "=" + loggedInUser.getPartnerCode();

            List<User> referrals = userFacade.getReferralsForUser(loggedInUser);
            loggedInUser = userFacade.getUserById(loggedInUser.getId());

            request.getSession().setAttribute(SignInFruitShop.LOGGED_IN_USER_ATTR, loggedInUser);

            request.setAttribute("partnerLink", partnerLink);
            request.setAttribute("referrals", referrals);
            request.getRequestDispatcher(Configurations.VIEWS_PATH_RESOLVER + "my-profile.jsp").forward(request, response);
        }

    }

}
