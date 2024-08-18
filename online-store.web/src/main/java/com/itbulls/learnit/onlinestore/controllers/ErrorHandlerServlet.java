package com.itbulls.learnit.onlinestore.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ErrorHandlerServlet
 */
@WebServlet(urlPatterns = "/error-handler")
public class ErrorHandlerServlet extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // Analyze the servlet exception
      Throwable throwable = (Throwable) request.getAttribute("jakarta.servlet.error.exception");
      Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
      String servletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");

      if (servletName == null) {
         servletName = "Unknown";
      }
      String requestUri = (String) request.getAttribute("jakarta.servlet.error.request_uri");

      if (requestUri == null) {
         requestUri = "Unknown";
      }

      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String title = "Error/Exception Information";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " +
            "transitional//en\">\n";

      out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n");

      if (throwable == null && statusCode == null) {
         out.println("<style>");
         out.println(
               "body { display: flex; flex-direction: column; align-items: center; justify-content: center; height: 100vh; }");
         out.println("h2 { color: #333; font-size: 2em; }");
         out.println("p, a { color: #007BFF; text-decoration: none; font-size: 1.5em; }");
         out.println("p { margin-top: 10px; font-size: 1.2em; color: #555; }");
         out.println("</style>");
         out.println("<h2>Error information is missing 404 :) </h2>"); // h2 tag
         out.println("<p>Please return to the</p>"); // p tag
         out.println("<a href=\" /online-store.web-1.0/home-page\">Home Page</a>.");
      }

      if (statusCode != null) {
         out.println("<style>");
         out.println(
               "body { display: flex; flex-direction: column; align-items: center; justify-content: center; height: 100vh; }");
         out.println("h2 { color: #333; font-size: 2em; }");
         out.println("p, a { color: #007BFF; text-decoration: none; font-size: 1.5em; }");
         out.println("p { margin-top: 10px; font-size: 1.2em; color: #555; }");
         out.println("</style>");
         out.println("<h2>Error information is missing 404</h2>"); // h2 tag
         out.println("<p>Please return to the</p>"); // p tag
         out.println("<a href=\" /online-store.web-1.0/home-page\">Home Page</a>.");
      }
      if (throwable != null) {
         out.println("Exception Type : " + throwable.getClass().getName() + "</br></br>");
         out.println("The exception message: " + throwable.getMessage());
      }
      out.println("</body>");
      out.println("</html>");
   }

   // Method to handle POST method request.
   public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

      doGet(request, response);
   }
}