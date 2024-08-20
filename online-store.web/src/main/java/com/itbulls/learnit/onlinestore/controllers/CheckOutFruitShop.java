package com.itbulls.learnit.onlinestore.controllers;
import java.io.IOException;
import java.util.ResourceBundle;
import com.itbulls.learnit.onlinestore.Configurations;
import com.itbulls.learnit.onlinestore.core.facades.ProductFacade;
import com.itbulls.learnit.onlinestore.core.facades.PurchaseFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultProductFacade;
import com.itbulls.learnit.onlinestore.core.facades.impl.DefaultPurchaseFacade;
import com.itbulls.learnit.onlinestore.persistence.enteties.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkout")
public class CheckOutFruitShop extends HttpServlet {
    
    private PurchaseFacade purchaseFacade = DefaultPurchaseFacade.getInstance();
    private ProductFacade productFacade = DefaultProductFacade.getInstance();
    private ResourceBundle resourceBundle = ResourceBundle.getBundle(Configurations.RESOURCE_BUNDLE_BASE_NAME);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String productId = request.getParameter("productId");

        purchaseFacade.createPurchase((User) request.getSession().getAttribute(SignInFruitShop.LOGGED_IN_USER_ATTR), 
                                    productFacade.getProductById(Integer.valueOf(productId)));

		String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getServletContext().getContextPath();

        request.getSession().setAttribute("orderStatus", resourceBundle.getString("order.created.msg"));

        response.sendRedirect(baseUrl + "/product-detail?productId=" + productId);

    }

}
