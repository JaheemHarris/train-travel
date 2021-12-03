<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Admin-TrainVago</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">

    

    <!-- Bootstrap core CSS -->
<link href="../assets/css/bootstrap.min.css" rel="stylesheet">
<link href="../assets/css/all.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="../assets/css/dashboard.css" rel="stylesheet">
  </head>
  <body>
    
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">TrainTravel</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="navbar-nav">
    <div class="nav-item text-nowrap">
      <a class="nav-link px-3" href="DeconnexionAdmin">Déconnexion</a>
    </div>
  </div>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="admin.jsp">
              <span data-feather="home"></span>
              Dashboard
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListeClientServlet">
              <span data-feather="layers"></span>
              Client
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListVille">
              <span data-feather="file"></span>
              Ville
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListeCompagnie">
              <span data-feather="shopping-cart"></span>
              Compagnie
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListeTrain">
              <span data-feather="users"></span>
              Train
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListeTrajet">
              <span data-feather="bar-chart-2"></span>
              Trajet
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListeHorraireTrain">
              <span data-feather="layers"></span>
              HorraireTrain
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="ListeVoyage">
              <span data-feather="layers"></span>
              Voyage
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Ajout</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="GestionPageAjout?page=ajoutVille">
              <span data-feather="file-text"></span>
              Ajout-Ville
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="GestionPageAjout?page=ajoutCompagnie">
              <span data-feather="file-text"></span>
              Ajout-Compagnie
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="GestionPageAjout?page=ajoutTrain">
              <span data-feather="file-text"></span>
              Ajout-Train
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="GestionPageAjout?page=ajoutTrajet">
              <span data-feather="file-text"></span>
              Ajout-Trajet
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="GestionPageAjout?page=ajoutHorraireTrain">
              <span data-feather="file-text"></span>
              Ajout-HorraireTrain
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="GestionPageAjout?page=ajoutVoyage">
              <span data-feather="file-text"></span>
              Ajout-Voyage
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <div class="col-md-12">
                <div class="row justify-content-center">
                <% String content=(String)request.getAttribute("content");
                    if(content==null){
                        content="dashboard.jsp";
                    }
                %>
                <jsp:include page="<%=content%>"/>
                </div>
            </div>
      </div>
    </main>
  </div>
</div>


    <script src="../assets/js/bootstrap.bundle.min.js"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="../assets/js/dashboard.js"></script>
  </body>
</html>
