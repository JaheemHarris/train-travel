<%-- 
    Document   : home.jsp
    Created on : 26 juil. 2021, 22:07:39
    Author     : HP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<ArrayList> result = (ArrayList)request.getAttribute("result"); %>
<% String dateVoyage = (String)request.getAttribute("dateVoyage");%>
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
        <div class="container"><a class="navbar-brand" href="home.jsp"><img class="d-inline-block" src="assets/img/gallery/logo.png" width="50" alt="logo" /><span class="fw-bold text-primary ms-2">TrainTravel</span></a>
          <button class="navbar-toggler collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse border-top border-lg-0 mt-4 mt-lg-0" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto pt-2 pt-lg-0 font-base">
            <% if(session.getAttribute("user")!=null){ %>
              <li class="nav-item px-2"><a class="nav-link fw-medium active" aria-current="page" href="mesReservations.jsp"><span class="nav-link-icon text-800 me-1"></span><span class="nav-link-text">Mes réservations </span></a></li>
            <% } %>
              <li class="nav-item px-2"><a class="nav-link" href="#flights"> <span class="nav-link-icon text-800 me-1 "></span><span class="nav-link-text">Recherche avancée</span></a></li>
<!--               <li class="nav-item px-2"><a class="nav-link" href="#hotels"> <span class="nav-link-icon text-800 me-1 fas fa-hotel"></span><span class="nav-link-text">Hotels</span></a></li>
              <li class="nav-item px-2"><a class="nav-link" href="#activities"><span class="nav-link-icon text-800 me-1 fas fa-bolt"></span><span class="nav-link-text">Activities</span></a></li>-->
            </ul>
            <% if(session.getAttribute("user")!=null){ %>
                <form method="post" action="myAccount.jsp">
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
      <section class="mt-7 py-0">
        <!--/.bg-holder-->

        <div class="container">
          <div class="row">
            <div class="col-lg-12 py-5 py-xl-5 py-xxl-7">
              <h1 class="display-3 text-primary fw-bold">Résultats</h1>
              <div class="pt-5">
                <nav>
                  <table class="table">
                    <thead class="thead-dark">
                      <tr class="table-primary">
                        <th scope="col">Compagnie</th>
                        <th scope="col">Ville Depart</th>
                        <th scope="col">Ville Arrivee</th>
                        <th scope="col">Distance</th>
                        <th scope="col">Heure de Depart</th>
                        <th scope="col">Heure d'Arrivee</th>
                        <th scope="col">Duree</th>
                        <th scope="col">Prix</th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                      <% for(int i=0;i<result.size();i++){ %>
                            <% ArrayList data = result.get(i); %>
                            <tr>
                              <td><% out.println(data.get(4));%></td>
                              <td><% out.println(data.get(10));%></td>
                              <td><% out.println(data.get(11));%></td>
                              <td><% out.println(data.get(12));%>Km</td>
                              <td><% out.println(data.get(13));%></td>
                              <td><% out.println(data.get(14));%></td>
                              <td><% out.println(data.get(15));%></td>
                              <td><% out.println(data.get(16));%>£</td>
                              <td>
                                  <form action="Voir?voyage=<%=data.get(0)%>&date=<%=dateVoyage%>" method="post" >
                                      <input type="submit" class="btn btn-primary" value="Voir">
                                  </form>
                              </td>
                            </tr>
                        <% } %>
                    </tbody>
                  </table>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </section>


      <!-- ============================================-->
      <!-- <section> begin ============================-->
      <section class="py-0 overflow-hidden">

        <div class="container">
          <div class="row">
            <div class="col-6 col-sm-4 col-lg-6">
              <div class="py-7"><img class="d-inline-block" src="assets/img/gallery/logo.png" width="50" alt="logo" /><span class="fw-bold fs-4 text-primary ms-2">voyage</span>
                <ul class="list-unstyled mt-4">
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">News</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">Terms &amp; Conditions</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">Privacy</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">About Us</a></li>
                  <li class="mb-2"><a class="text-800 fw-bold text-decoration-none" href="#!">FAQs</a></li>
                </ul>
              </div>
            </div>
            <div class="col-6 col-8 col-lg-6 bg-primary-gradient bg-offcanvas-right">
              <div class="p-3 py-7 p-md-7">
                <p class="text-light"><i class="fas fa-phone-alt me-3"></i><span class="text-light">+3930219390</span></p>
                <p class="text-light"><i class="fas fa-envelope me-3"></i><span class="text-light">something@gmail.com</span></p>
                <p class="text-light"><i class="fas fa-map-marker-alt me-3"></i><span class="text-light lh-lg">333, Lorem Street, Albania, Alifornia<br/>United States of America</span></p>
                <div class="mt-6"><a href="#!"> <img class="me-3" src="assets/img/icons/facebook.svg" alt="..." /></a><a href="#!"> <img class="me-3" src="assets/img/icons/twitter.svg" alt="..." /></a><a href="#!"> <img class="me-3" src="assets/img/icons/instagram.svg" alt="..." /></a></div>
                <p class="mt-3 text-light text-center text-md-start"> Made with&nbsp;
                  <svg class="bi bi-suit-heart-fill" xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="#EB6453" viewBox="0 0 16 16">
                    <path d="M4 1c2.21 0 4 1.755 4 3.92C8 2.755 9.79 1 12 1s4 1.755 4 3.92c0 3.263-3.234 4.414-7.608 9.608a.513.513 0 0 1-.784 0C3.234 9.334 0 8.183 0 4.92 0 2.755 1.79 1 4 1z"></path>
                  </svg>&nbsp;by&nbsp;<a class="text-light" href="https://themewagon.com/" target="_blank">ThemeWagon </a>
                </p>
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
    <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
    <script src="vendors/fontawesome/all.min.js"></script>
    <script src="assets/js/theme.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@300;400;600;700&amp;display=swap" rel="stylesheet">
  </body>

</html>
