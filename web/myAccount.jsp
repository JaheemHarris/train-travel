<%@page import="tables.Client"%>
<% Client user = (Client)session.getAttribute("user"); %>
<section class="mt-7 py-0">
    <div class="bg-holder w-50 bg-right d-none d-lg-block" style="background-image:url(assets/img/gallery/hero-section-1.png);"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 py-5 py-xl-5 py-xxl-7">
            <h1 class="display-3 text-primary fw-bold">Mon compte</h1>
                <div class="pt-5">
                    <nav>
                    <div class="col-md-6 text-center">
                        <form action="Disconnection" method="post" class="input-group">
                            <table class="table table-responsive">
                                <tr>
                                    <th class="table-primary" style="border-radius: 20px 0 0 0">Nom</th>
                                    <td><input type="text" readonly value="<%=user.getNom()%>" class="form-control text-center"></td>
                                </tr>
                                <tr>
                                    <th class="table-primary">Prénom</th>
                                    <td><input type="text" readonly value="<%=user.getPrenom()%>" class="form-control text-center"></td>
                                </tr>
                                <tr>
                                    <th class="table-primary">Email</th>
                                    <td><input type="text" readonly value="<%=user.getMail() %>" class="form-control text-center"></td>
                                </tr>                      
                            </table>
                            <input type="submit" class="btn btn-primary btn-lg btn-block" value="Se déconnecter">
                        </form>
                    </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</section>