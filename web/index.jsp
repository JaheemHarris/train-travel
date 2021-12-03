<%-- 
    Document   : home.jsp
    Created on : 26 juil. 2021, 22:07:39
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US" dir="ltr">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <!-- ===============================================-->
    <!--    Document Title-->
    <!-- ===============================================-->
    <title>TrainTravel</title>


    <!-- ===============================================-->
    <!--    Favicons-->
    <!-- ===============================================-->
    <link rel="apple-touch-icon" sizes="180x180" href="assets/img/favicons/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/favicons/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="assets/img/favicons/favicon-16x16.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicons/favicon.ico">
    <link rel="manifest" href="assets/img/favicons/manifest.json">
    <meta name="msapplication-TileImage" content="assets/img/favicons/mstile-150x150.png">
    <meta name="theme-color" content="#ffffff">


    <!-- ===============================================-->
    <!--    Stylesheets-->
    <!-- ===============================================-->
    <link href="assets/css/theme.css" rel="stylesheet" />

  </head>


  <body>

    <!-- ===============================================-->
    <!--    Main Content-->
    <!-- ===============================================-->
    <main class="main" id="top">
      <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3 d-block" data-navbar-on-scroll="data-navbar-on-scroll">
        <div class="container"><a class="navbar-brand" href="GestionPageClient"><img class="d-inline-block" src="assets/img/gallery/logo.png" width="50" alt="logo" /><span class="fw-bold text-primary ms-2">TrainTravel</span></a>
          <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto pt-2 pt-lg-0 font-base">
            <% if(session.getAttribute("user")!=null){ %>
              <li class="nav-item px-2"><a class="nav-link fw-medium active" aria-current="page" href="MyReservations"><span class="nav-link-icon text-800 me-1"></span><span class="nav-link-text">Mes réservations </span></a></li>
            <% } %>
<!--              <li class="nav-item px-2"><a class="nav-link" href="#"> <span class="nav-link-icon text-800 me-1 "></span><span class="nav-link-text">Recherche avancée</span></a></li>-->
<!--               <li class="nav-item px-2"><a class="nav-link" href="#hotels"> <span class="nav-link-icon text-800 me-1 fas fa-hotel"></span><span class="nav-link-text">Hotels</span></a></li>
              <li class="nav-item px-2"><a class="nav-link" href="#activities"><span class="nav-link-icon text-800 me-1 fas fa-bolt"></span><span class="nav-link-text">Activities</span></a></li>-->
            </ul>
            <% if(session.getAttribute("user")!=null){ %>
                <form method="post" action="GestionPageClient?page=myAccount">
                  <button class="btn btn-voyage-outline order-0" type="submit"><span class="text-primary">Mon compte</span></button>
                </form>
            <% } %>
            <% if(session.getAttribute("user")==null){%>
                <form method="post" action="login.jsp">
                  <button class="btn btn-voyage-outline order-0" type="submit"><span class="text-primary">Sign in</span></button>
                </form>
            <% } %>
          </div>
        </div>
      </nav>
        <!--/.bg-holder-->
        <% String content=(String)request.getAttribute("content");
            if(content==null){
                content="home.jsp";
            }
        %>
        <jsp:include page="<%=content%>"/>


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0 overflow-hidden">

        <div class="container">
          <div class="row">
            <div class="col-6 col-sm-4 col-lg-6">
              <div class="py-7"><img class="d-inline-block" src="assets/img/gallery/logo.png" width="50" alt="logo" /><span class="fw-bold fs-4 text-primary ms-2">Traintravel</span>
                <ul class="list-unstyled mt-4">
<!--                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">News</a></li>-->
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">Conditions &amp Termes</a></li>
<!--                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">Privacy</a></li>-->
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">À propos</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">FAQs</a></li>
                </ul>
              </div>
            </div>
            <div class="col-6 col-8 col-lg-6 bg-primary-gradient bg-offcanvas-right">
              <div class="p-3 py-7 p-md-7">
                <p class="text-light"><i class="fas fa-phone-alt me-3"></i><span class="text-light">+33 6 10 20 30 10</span></p>
                <p class="text-light"><i class="fas fa-envelope me-3"></i><span class="text-light">traintravel@outlook.fr</span></p>
                <p class="text-light"><i class="fas fa-map-marker-alt me-3"></i><span class="text-light lh-lg">39 Rue d'Alsace Lorraine, 31000 Toulouse<br/>France</span></p>
              </div>
            </div>
          </div>
        </div>
        <!-- end of .container-->

      </section>
      <!-- <section> close ============================-->
      <!-- ============================================-->


    </main>
    <!-- ===============================================-->
    <!--    End of Main Content-->
    <!-- ===============================================-->




    <!-- ===============================================-->
    <!--    JavaScripts-->
    <!-- ===============================================-->
    <script src="vendors/@popperjs/popper.min.js"></script>
    <script src="vendors/bootstrap/bootstrap.min.js"></script>
    <script src="vendors/is/is.min.js"></script>
<!--    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>-->
    <script src="vendors/fontawesome/all.min.js"></script>
    <script src="assets/js/theme.js"></script>

<!--    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600;700&amp;display=swap" rel="stylesheet">-->
  </body>

</html>
