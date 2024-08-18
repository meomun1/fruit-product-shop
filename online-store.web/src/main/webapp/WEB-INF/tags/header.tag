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
                        >${loggedInUser.getLastName()}</c:if
                      >
                    </a>
                  </li>

                  <li><a href="sign-out">sign out</a></li>
                </c:if>
                
                <c:if test="${loggedInUser == null}">
                  <li><a href="sign-up">sign up</a></li>
                  <li><a href="sign-in">sign in</a></li>
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