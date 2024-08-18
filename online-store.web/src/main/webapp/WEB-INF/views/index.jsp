<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html class="no-js" lang="en">
  <head>
    <!-- meta data -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!--font-family-->
    <link
      href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    />

    <link
      href="https://fonts.googleapis.com/css?family=Rufina:400,700"
      rel="stylesheet"
    />

    <!-- title of site -->
    <title>MaxLuong</title>

    <!-- For favicon png -->
    <link rel="shortcut icon" type="image/icon" href="logo/favicon.png" />

    <!--font-awesome.min.css-->
    <link rel="stylesheet" href="css/font-awesome.min.css" />

    <!--linear icon css-->
    <link rel="stylesheet" href="css/linearicons.css" />

    <!--flaticon.css-->
    <link rel="stylesheet" href="css/flaticon.css" />

    <!--animate.css-->
    <link rel="stylesheet" href="css/animate.css" />

    <!--owl.carousel.css-->
    <link rel="stylesheet" href="css/owl.carousel.min.css" />
    <link rel="stylesheet" href="css/owl.theme.default.min.css" />

    <!--bootstrap.min.css-->
    <link rel="stylesheet" href="css/bootstrap.min.css" />

    <!-- bootsnav -->
    <link rel="stylesheet" href="css/bootsnav.css" />

    <!--style.css-->
    <link rel="stylesheet" href="css/style.css" />

    <!--responsive.css-->
    <link rel="stylesheet" href="css/responsive.css" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <!--[if lte IE 9]>
      <p class="browserupgrade">
        You are using an <strong>outdated</strong> browser. Please
        <a href="https://browsehappy.com/">upgrade your browser</a> to improve
        your experience and security.
      </p>
    <![endif]-->

    <!--welcome-hero start -->
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

      <div class="container">
        <div class="welcome-hero-txt">
          <h2>Get your desired product in Max-Luong-Shop</h2>
          <p>We have everything for you.</p>
          <form
            action="search-product-page"
            method="GET"
            style="
              display: flex;
              justify-content: center;
              margin-top: 20px;
              z-index: 1000;
              position: relative;
            "
          >
            <input
              type="text"
              name="searchQuery"
              placeholder="Search what you need"
              style="
                width: 300px;
                padding: 10px;
                border: none;
                border-radius: 5px 0 0 5px;
              "
            />
            <input
              type="submit"
              value="query"
              style="
                padding: 10px 20px;
                border: none;
                background-color: #333;
                color: #fff;
                cursor: pointer;
                border-radius: 0 5px 5px 0;
              "
            />
          </form>
        </div>
      </div>

      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="model-search-content">
              <div class="row">
                <div class="col-md-offset-1 col-md-2 col-sm-12">
                  <div class="single-model-search">
                    <h2>select season</h2>
                    <div class="model-select-icon">
                      <select class="form-control">
                        <option value="default">Season</option>
                        <!-- /.option-->

                        <option value="2018">Spring Fruits</option>

                        <option value="2018">Summer Fruits</option>
                        <!-- /.option-->

                        <option value="2017">Autumm Fruits</option>
                        <!-- /.option-->

                        <option value="2016">Winter Fruits</option>
                        <!-- /.option--></select
                      ><!-- /.select-->
                    </div>
                    <!-- /.model-select-icon -->
                  </div>
                  <div class="single-model-search">
                    <h2>Color style</h2>
                    <div class="model-select-icon">
                      <select class="form-control">
                        <option value="default">style</option>
                        <!-- /.option-->

                        <option value="sedan">Red Fruits</option>
                        <!-- /.option-->

                        <option value="van">Yellow Fruits</option>
                        <!-- /.option-->
                        <option value="roadster">Green Fruits</option>
                        <!-- /.option--></select
                      ><!-- /.select-->
                    </div>
                    <!-- /.model-select-icon -->
                  </div>
                </div>
                <div class="col-md-offset-1 col-md-2 col-sm-12">
                  <div class="single-model-search">
                    <h2>select Type</h2>
                    <div class="model-select-icon">
                      <select class="form-control">
                        <option value="default">Type</option>
                        <!-- /.option-->

                        <option value="toyota">Tropical Fruits</option>
                        <!-- /.option-->

                        <option value="holden">Stone Fruits</option>
                        <!-- /.option-->
                        <option value="maecedes-benz">Citrus Fruits.</option>
                        <!-- /.option--></select
                      ><!-- /.select-->
                    </div>
                    <!-- /.model-select-icon -->
                  </div>
                  <div class="single-model-search">
                    <h2>Fruit Condition</h2>
                    <div class="model-select-icon">
                      <select class="form-control">
                        <option value="default">condition</option>
                        <!-- /.option-->

                        <option value="something">Less than 1 weaks</option>
                        <!-- /.option-->

                        <option value="something">Less than 1-2 weaks</option>
                        <!-- /.option-->
                        <option value="something">Less than a month</option>
                        <!-- /.option--></select
                      ><!-- /.select-->
                    </div>
                    <!-- /.model-select-icon -->
                  </div>
                </div>
                <div class="col-md-offset-1 col-md-2 col-sm-12">
                  <div class="single-model-search">
                    <h2>select usage</h2>
                    <div class="model-select-icon">
                      <select class="form-control">
                        <option value="default">model</option>
                        <!-- /.option-->

                        <option value="kia-rio">Culinary fruits</option>
                        <!-- /.option-->

                        <option value="mitsubishi">Snack fruits</option>
                        <!-- /.option-->
                        <option value="ford">Juice fruits</option>
                        <!-- /.option--></select
                      ><!-- /.select-->
                    </div>
                    <!-- /.model-select-icon -->
                  </div>
                  <div class="single-model-search">
                    <h2>select price</h2>
                    <div class="model-select-icon">
                      <select class="form-control">
                        <option value="default">price</option>
                        <!-- /.option-->

                        <option value="$0.00">$0.50 - $2.00</option>
                        <!-- /.option-->

                        <option value="$0.00">$2.00 - $5.00</option>
                        <!-- /.option-->
                        <option value="$0.00">$5.00 - $10.00</option>
                        <!-- /.option--></select
                      ><!-- /.select-->
                    </div>
                    <!-- /.model-select-icon -->
                  </div>
                </div>
                <div class="col-md-2 col-sm-12">
                  <div class="single-model-search text-center">
                    <button
                      class="welcome-btn model-search-btn"
                      onclick="window.location.href='#'"
                    >
                      search
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!--/.welcome-hero-->
    <!--welcome-hero end -->

    <!--featured-cars start -->
 <section id="featured-fruits" class="featured-fruits">
  <div class="container">
    <div class="section-header">
      <p>checkout <span>the</span> featured fruits</p>
      <h2>featured Fruits</h2>
    </div>
    <!--/.section-header-->
    <div class="featured-fruits-content">
      <div class="row">
        <c:forEach var="category" items="${categories}">
          <div class="col-lg-3 col-md-4 col-sm-6">
            <div class="single-featured-fruits">
              <div class="featured-img-box">
                <div class="featured-fruits-img">
                  <img src="images/featured-fruits/${category.imgName}" alt="fruits" />
                </div>
                <div class="featured-model-info">
                  <p>
                    model: ${category.id}
                    <span class="featured-mi-span"> Price: </span>
                    <span class="featured-hp-span"> 5$/kg</span>
                  </p>
                </div>
              </div>
              <div class="featured-fruits-txt">
                <h2><a href="#">${category.categoryName} fruit model</a></h2>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
  <!--/.container-->
</section>
    <!--/.featured-cars-->
    <!--featured-cars end -->

    <!--service start -->
    <section id="service" class="service">
      <div class="container">
        <div class="service-content">
          <div class="row">
            <div class="col-md-4 col-sm-6">
              <div class="single-service-item">
                <!-- <div class="single-service-icon">
									<i class="flaticon-car"></i>
								</div> -->
                <h2>
                  <a href="#">Popular fruit <span> </span> </a>
                </h2>
                <p>Place for your shopping session.</p>
              </div>
            </div>
            <div class="col-md-4 col-sm-6">
              <div class="single-service-item">
                <!-- <div class="single-service-icon">
									<i class="flaticon-car-repair"></i>
								</div> -->
                <h2><a href="#">Fruit Discount</a></h2>
                <p>20% to 50% per product.</p>
              </div>
            </div>
            <div class="col-md-4 col-sm-6">
              <div class="single-service-item">
                <!-- <div class="single-service-icon">
									<i class="flaticon-car-1"></i>
								</div> -->
                <h2><a href="#">Cutomer support</a></h2>
                <p>Visit our chat bot</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--/.container-->
    </section>
    <!--/.service-->
    <!--service end-->


    <!--new-cars start -->
    <section id="new-cars" class="new-cars">
      <div class="container">
        <div class="section-header">
          <p>checkout <span>the</span> latest fruits</p>
          <h2>newest fruits</h2>
        </div>
        <!--/.section-header-->
        <div class="new-cars-content">
          <div class="owl-carousel owl-theme" id="new-cars-carousel">
            <div class="new-cars-item">
              <div class="single-new-cars-item">
                <div class="row">
                  <div class="col-md-7 col-sm-12">
                    <div class="new-cars-img">
                      <img
                        src="images/new-cars-model/fresh-berry.png"
                        alt="img"
                      />
                    </div>
                    <!--/.new-cars-img-->
                  </div>
                  <div class="col-md-5 col-sm-12">
                    <div class="new-cars-txt">
                      <h2>
                        <a href="#">Fresh Berry From Viet Nam <span></span></a>
                      </h2>
                      <p>Good fruit if you need a wealthy product.</p>
                      <p class="new-cars-para2">
                        You will not find it anywhere except Max Luong Shop.
                      </p>
                      <button
                        class="welcome-btn new-cars-btn"
                        onclick="window.location.href='#'"
                      >
                        view details
                      </button>
                    </div>
                    <!--/.new-cars-txt-->
                  </div>
                  <!--/.col-->
                </div>
                <!--/.row-->
              </div>
              <!--/.single-new-cars-item-->
            </div>
            <!--/.new-cars-item-->
            <div class="new-cars-item">
              <div class="single-new-cars-item">
                <div class="row">
                  <div class="col-md-7 col-sm-12">
                    <div class="new-cars-img">
                      <img
                        src="images/new-cars-model/fresh-cherry.png"
                        alt="img"
                      />
                    </div>
                    <!--/.new-cars-img-->
                  </div>
                  <div class="col-md-5 col-sm-12">
                    <div class="new-cars-txt">
                      <h2><a href="#">Fresh Cherry From Viet Nam</a></h2>
                      <p>Good fruit if you need a wealthy product.</p>
                      <p class="new-cars-para2">
                        You will not find it anywhere except Max Luong Shop.
                      </p>
                      <button
                        class="welcome-btn new-cars-btn"
                        onclick="window.location.href='#'"
                      >
                        view details
                      </button>
                    </div>
                    <!--/.new-cars-txt-->
                  </div>
                  <!--/.col-->
                </div>
                <!--/.row-->
              </div>
              <!--/.single-new-cars-item-->
            </div>
            <!--/.new-cars-item-->
            <div class="new-cars-item">
              <div class="single-new-cars-item">
                <div class="row">
                  <div class="col-md-7 col-sm-12">
                    <div class="new-cars-img">
                      <img
                        src="images/new-cars-model/fresh-pinapple.png"
                        alt="img"
                      />
                    </div>
                    <!--/.new-cars-img-->
                  </div>
                  <div class="col-md-5 col-sm-12">
                    <div class="new-cars-txt">
                      <h2><a href="#">Fresh Pinablle From Viet Nam</a></h2>
                      <p>Good fruit if you need a wealthy product.</p>
                      <p class="new-cars-para2">
                        You will not find it anywhere except Max Luong Shop.
                      </p>
                      <button
                        class="welcome-btn new-cars-btn"
                        onclick="window.location.href='#'"
                      >
                        view details
                      </button>
                    </div>
                    <!--/.new-cars-txt-->
                  </div>
                  <!--/.col-->
                </div>
                <!--/.row-->
              </div>
              <!--/.single-new-cars-item-->
            </div>
            <!--/.new-cars-item-->
          </div>
          <!--/#new-cars-carousel-->
        </div>
        <!--/.new-cars-content-->
      </div>
      <!--/.container-->
    </section>
    <!--/.new-cars-->
    <!--new-cars end -->



    <!-- clients-say strat -->
    <section id="clients-say" class="clients-say">
      <div class="container">
        <div class="section-header">
          <h2>what our clients say</h2>
        </div>
        <!--/.section-header-->
        <div class="row">
          <div class="owl-carousel testimonial-carousel">
            <div class="col-sm-3 col-xs-12">
              <div class="single-testimonial-box">
                <div class="testimonial-description">
                  <div class="testimonial-info">
                    <div class="testimonial-img">
                      <img
                        src="images/clients/c1.png"
                        alt="image of clients person"
                      />
                    </div>
                    <!--/.testimonial-img-->
                  </div>
                  <!--/.testimonial-info-->
                  <div class="testimonial-comment">
                    <p>This is so damm good.</p>
                  </div>
                  <!--/.testimonial-comment-->
                  <div class="testimonial-person">
                    <h2><a href="#">tomas lili</a></h2>
                    <h4>new york</h4>
                  </div>
                  <!--/.testimonial-person-->
                </div>
                <!--/.testimonial-description-->
              </div>
              <!--/.single-testimonial-box-->
            </div>
            <!--/.col-->
            <div class="col-sm-3 col-xs-12">
              <div class="single-testimonial-box">
                <div class="testimonial-description">
                  <div class="testimonial-info">
                    <div class="testimonial-img">
                      <img
                        src="images/clients/c2.png"
                        alt="image of clients person"
                      />
                    </div>
                    <!--/.testimonial-img-->
                  </div>
                  <!--/.testimonial-info-->
                  <div class="testimonial-comment">
                    <p>This is not so good.</p>
                  </div>
                  <!--/.testimonial-comment-->
                  <div class="testimonial-person">
                    <h2><a href="#">romi rain</a></h2>
                    <h4>london</h4>
                  </div>
                  <!--/.testimonial-person-->
                </div>
                <!--/.testimonial-description-->
              </div>
              <!--/.single-testimonial-box-->
            </div>
            <!--/.col-->
            <div class="col-sm-3 col-xs-12">
              <div class="single-testimonial-box">
                <div class="testimonial-description">
                  <div class="testimonial-info">
                    <div class="testimonial-img">
                      <img
                        src="images/clients/c3.png"
                        alt="image of clients person"
                      />
                    </div>
                    <!--/.testimonial-img-->
                  </div>
                  <!--/.testimonial-info-->
                  <div class="testimonial-comment">
                    <p>I love this store.</p>
                  </div>
                  <!--/.testimonial-comment-->
                  <div class="testimonial-person">
                    <h2><a href="#">john doe</a></h2>
                    <h4>washington</h4>
                  </div>
                  <!--/.testimonial-person-->
                </div>
                <!--/.testimonial-description-->
              </div>
              <!--/.single-testimonial-box-->
            </div>
            <!--/.col-->
          </div>
          <!--/.testimonial-carousel-->
        </div>
        <!--/.row-->
      </div>
      <!--/.container-->
    </section>
    <!--/.clients-say-->
    <!-- clients-say end -->

    <!--brand strat -->
    <section id="brand" class="brand">
      <div class="container">
        <div class="brand-area">
          <div class="owl-carousel owl-theme brand-item">
            <div class="item">
              <a href="#">
                <img src="images/brand/br1.png" alt="brand-image" />
              </a>
            </div>
            <!--/.item-->
            <div class="item">
              <a href="#">
                <img src="images/brand/br2.png" alt="brand-image" />
              </a>
            </div>
            <!--/.item-->
            <div class="item">
              <a href="#">
                <img src="images/brand/br3.png" alt="brand-image" />
              </a>
            </div>
            <!--/.item-->
            <div class="item">
              <a href="#">
                <img src="images/brand/br4.png" alt="brand-image" />
              </a>
            </div>
            <!--/.item-->

            <div class="item">
              <a href="#">
                <img src="images/brand/br5.png" alt="brand-image" />
              </a>
            </div>
            <!--/.item-->

            <div class="item">
              <a href="#">
                <img src="images/brand/br6.png" alt="brand-image" />
              </a>
            </div>
            <!--/.item-->
          </div>
          <!--/.owl-carousel-->
        </div>
        <!--/.clients-area-->
      </div>
      <!--/.container-->
    </section>
    <!--/brand-->
    <!--brand end -->

    <!--blog start -->
    <section id="blog" class="blog"></section>
    <!--/.blog-->
    <!--blog end -->

    <!--contact start-->
    <footer id="contact" class="contact">
      <div class="container">
        <div class="footer-top">
          <div class="row">
            <div class="col-md-3 col-sm-6">
              <div class="single-footer-widget">
                <div class="footer-logo">
                  <a href="index.html">Max Luong</a>
                </div>
                <p>This home page is support by free source</p>
                <div class="footer-contact">
                  <p>maluong1504@gmail.com</p>
                  <p>+84 905903608</p>
                </div>
              </div>
            </div>
            <div class="col-md-2 col-sm-6">
              <div class="single-footer-widget">
                <h2>about Max Luong</h2>
                <ul>
                  <li><a href="#">about me</a></li>
                  <li><a href="#">career</a></li>
                  <li>
                    <a href="#">terms <span> of service</span></a>
                  </li>
                  <li><a href="#">privacy policy</a></li>
                </ul>
              </div>
            </div>
            <div class="col-md-3 col-xs-12">
              <div class="single-footer-widget">
                <h2>top brands</h2>
                <div class="row">
                  <div class="col-md-7 col-xs-6">
                    <ul>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                    </ul>
                  </div>
                  <div class="col-md-5 col-xs-6">
                    <ul>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                      <li><a href="#">Nan</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-offset-1 col-md-3 col-sm-6">
              <div class="single-footer-widget">
                <h2>news letter</h2>
                <div class="footer-newsletter">
                  <p>Subscribe to get latest news update and informations</p>
                </div>
                <div class="hm-foot-email">
                  <div class="foot-email-box">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="Add Email"
                    />
                  </div>
                  <!--/.foot-email-box-->
                  <div class="foot-email-subscribe">
                    <span><i class="fa fa-arrow-right"></i></span>
                  </div>
                  <!--/.foot-email-icon-->
                </div>
                <!--/.hm-foot-email-->
              </div>
            </div>
          </div>
        </div>
        <div class="footer-copyright">
          <div class="row">
            <div class="col-sm-6">
              <p>
                &copy; copyright.designed and developed by
                <a href="https://www.themesine.com/">themesine</a>.
              </p>
              <!--/p-->
            </div>
            <div class="col-sm-6">
              <div class="footer-social">
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-instagram"></i></a>
                <a href="#"><i class="fa fa-linkedin"></i></a>
                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                <a href="#"><i class="fa fa-behance"></i></a>
              </div>
            </div>
          </div>
        </div>
        <!--/.footer-copyright-->
      </div>
      <!--/.container-->

      <div id="scroll-Top">
        <div class="return-to-top">
          <i
            class="fa fa-angle-up"
            id="scroll-top"
            data-toggle="tooltip"
            data-placement="top"
            title=""
            data-original-title="Back to Top"
            aria-hidden="true"
          ></i>
        </div>
      </div>
      <!--/.scroll-Top-->
    </footer>
    <!--/.contact-->
    <!--contact end-->

    <!-- Include all js compiled plugins (below), or include individual files as needed -->

    <script src="js/jquery.js"></script>

    <!--modernizr.min.js-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

    <!--bootstrap.min.js-->
    <script src="js/bootstrap.min.js"></script>

    <!-- bootsnav js -->
    <script src="js/bootsnav.js"></script>

    <!--owl.carousel.js-->
    <script src="js/owl.carousel.min.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>

    <!--Custom JS-->
    <script src="js/custom.js"></script>
  </body>
</html>
