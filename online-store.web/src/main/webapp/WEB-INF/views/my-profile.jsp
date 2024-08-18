<%@ page language ="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%@ taglib prefix="shop" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Profile</title>
    <link rel="stylesheet" href="css/my_profile/style.css">

    <shop:indexcss />

</head>
<body>

    <section id="home" class="welcome-hero">
        <!-- top-area Start -->
        <div class="top-area">
          <div class="header-area">
            <!-- Start Navigation -->
            <nav
              class="navbar navbar-default bootsnav navbar-sticky navbar-scrollspy"
              data-minus-value-desktop="70"
              data-minus-value-mobile="55"
              data-speed="1000"
            >
              <div class="container">
                <!-- Start Header Navigation -->
                <div class="navbar-header">
                  <button
                    type="button"
                    class="navbar-toggle"
                    data-toggle="collapse"
                    data-target="#navbar-menu"
                  >
                    <i class="fa fa-bars"></i>
                  </button>
                  <a class="navbar-brand" href="">Max Luong<span></span></a>
                </div>
                <!--/.navbar-header-->
                <!-- End Header Navigation -->
    
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div
                  class="collapse navbar-collapse menu-ui-design"
                  id="navbar-menu"
                >
                  <ul
                    class="nav navbar-nav navbar-right"
                    data-in="fadeInDown"
                    data-out="fadeOutUp"
                  >
                    <li class="scroll active"><a href="#home">home</a></li>
                    <li class="scroll"><a href="#service">service</a></li>
                    <!-- <li class="scroll">
                      <a href="#featured-cars">featured product</a>
                    </li> -->
                    <li class="scroll"><a href="#new-cars">new product</a></li>
                    <li class="scroll"><a href="#contact">contact</a></li>
    
                    <c:if test="${loggedInUser != null}">
                      <li>
                        <a
                          style="font-size: 20px"
                          >Welcome
                          <c:if test="${loggedInUser != null}"
                            >${sessionScope.loggedInUser.getLastName()}</c:if
                          >
                        </a>
                      </li>
    
                      <li><a href="/online-store.web-1.0/sign-out">sign out</a></li>
                    </c:if>
                    
                    <c:if test="${loggedInUser == null}">
                      <li><a href="/online-store.web-1.0/sign-up">sign up</a></li>
                      <li><a href="/online-store.web-1.0/sign-in">sign in</a></li>
                    </c:if>
                  </ul>
                  <!--/.nav -->
                </div>
                <!-- /.navbar-collapse -->
              </div>
              <!--/.container-->
            </nav>
            <!--/nav-->
            <!-- End Navigation -->
          </div>
          <!--/.header-area-->
          <div class="clearfix"></div>
        </div>
        <!-- /.top-area-->
        <!-- top-area End -->
    
    
    </section>

    <section id="featured-cars" class="featured-cars">
        <div class="profile-container">

            <div class="profile-card">
                <div class = "profile-image-edit">
                    <div class="profile-image">
                        <img src="https://via.placeholder.com/150" alt="Profile Picture">
                    </div>
    
                    <div class = "profile-edit">
                        <h2>${loggedInUser.getFirstName()} ${loggedInUser.getLastName()}</h2>
                        <button class="edit-button">Edit</button>
                        <div class="tabs">
                            <button class="tab active" onclick="showTab('personal-info')">Personal Info</button>
                        </div>
                        <div class="tabs">
                            <button class="tab" onclick="showTab('referrals')">Referrals</button>
                        </div>
                    </div>
                </div>

                <div class="profile-info">
                    <div id="personal-info" class="tab-content active">
                        <p><strong>First Name:</strong> ${loggedInUser.getFirstName()}</p>
                        <p><strong>Last Name:</strong> ${loggedInUser.getLastName()}</p>
                        <p><strong>Email:</strong> ${loggedInUser.getEmail()}</p>
                        <p><strong>Money:</strong> ${loggedInUser.getMoney()}</p>
                        <p><strong>Role:</strong> ${loggedInUser.getRoleName()}</p>
                        <p><strong>Partner Code:</strong> ${loggedInUser.getPartnerCode()}</p>
                        <p><strong>Partner Link:</strong> <a href="http://localhost:8080/online-store.web-1.0?partner_code=${loggedInUser.getPartnerCode()}">http://localhost:8080/online-store.web-1.0?partner_code=${loggedInUser.getPartnerCode()}</a></p>
                    </div>
                    <div id="referrals" class="tab-content">
                        <!-- Referrals content goes here -->
                    </div>
                </div>
            </div>
        </div>
    </section>

    <shop:footer />

    <shop:indexjs />

    <script src="script.js"></script>
</body>
</html>
