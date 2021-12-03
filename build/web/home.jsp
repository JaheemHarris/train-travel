<%@page import="tables.Ville"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Ville> listeVille = new ArrayList();%>
<% listeVille=(ArrayList)request.getAttribute("listeVille"); %>
<section class="mt-7 py-0">
    <div class="bg-holder w-50 bg-right d-none d-lg-block" style="background-image:url(assets/img/gallery/train.jpg);"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 py-5 py-xl-5 py-xxl-7">
                <h1 class="display-3 text-1000 fw-normal">Réservez vos billets de train.</h1>
                <h1 class="display-3 text-primary fw-bold">Voyagez en Europe.</h1>
                <div class="pt-5">
                    <nav>
                      <div class="tab-content" id="nav-tabContent">
                        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                            <form class="row g-4 mt-5" method="post" action="SimpleSearch" >
                            <div class="col-sm-6 col-md-6 col-xl-5">
                              <div class="input-group-icon">
                                <label class="form-label" for="inputAddress1">De</label>
                                <div class="input-group-icon">
                                    <select class="form-control text-center" name="villeDepart">
                                    <% Ville villeTemp = null;%>
                                    <% for(int i=0;i<listeVille.size();i++) { %>
                                        <% villeTemp=listeVille.get(i); %>
                                        <option value="<%=villeTemp.getIdVille() %>"><% out.println(villeTemp.getNom()); %></option>
                                    <% } %>
                                </select>
<!--                                <input class="form-control input-box form-voyage-control" id="inputAddress2" type="text" placeholder="To where" name="villeDestination" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"> </i></span>-->
                              </div>

<!--                                <input class="form-control input-box form-voyage-control" id="inputAddress1" type="text" placeholder="From where" name="villeDepart" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"></i></span>-->
                              </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-xl-5">
                              <div class="input-group-icon">
                                <label class="form-label" for="inputAddress2">Vers</label>
                                <select class="form-control text-center" name="villeDestination" >
                                    <% Ville villeTemp2 = null;%>
                                    <% for(int i=listeVille.size()-1;i>=0;i--) { %>
                                        <% villeTemp2=listeVille.get(i); %>
                                        <option value="<%=villeTemp2.getIdVille() %>"><% out.println(villeTemp2.getNom()); %></option>
                                    <% } %>
                                </select>
<!--                                <input class="form-control input-box form-voyage-control" id="inputAddress2" type="text" placeholder="To where" name="villeDestination" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-map-marker-alt"> </i></span>-->
                              </div>
                            </div>
                            <div class="col-sm-12 col-md-12 col-xl-10">
                              <div class="input-group-icon">
                                  <input class="form-control input-box form-voyage-control text-center" id="inputdateOne" type="date" name="dateDepart" /><span class="nav-link-icon text-800 fs--1 input-box-icon"><i class="fas fa-calendar"></i></span>
                              </div>
                            </div>
                            <div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
                              <button class="btn btn-secondary" type="submit">Rechercher</button>
                            </div>
                          </form>
                        </div>
                      </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</section>