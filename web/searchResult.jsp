<%@page import="java.util.ArrayList"%>
<% ArrayList<ArrayList> result = (ArrayList)request.getAttribute("result"); %>
<% String dateVoyage = (String)request.getAttribute("dateVoyage");%>
<section class="mt-7 py-0">
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