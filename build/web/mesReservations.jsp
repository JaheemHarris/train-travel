<%@page import="java.util.ArrayList"%>
<% ArrayList<ArrayList> mesReservations = new ArrayList();%>
<% mesReservations = (ArrayList)request.getAttribute("myReservations");%>
<section class="mt-7 py-0">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 py-5 py-xl-5 py-xxl-7">
            <h1 class="display-3 text-primary fw-bold">Mes réservations</h1>
                <div class="pt-5">
                    <nav>
                      <table class="table">
                        <thead class="thead-dark">
                          <tr class="table-primary">
                            <th scope="col">#</th>
                            <th scope="col">Trajet</th>
                            <th scope="col">Date de départ</th>
                            <th scope="col">Heure de départ</th>
                            <th scope="col">Compagnie</th>
                            <th scope="col">Numero du train</th>
                            <th scope="col">Nombre de places</th>
                            <th scope="col">Date de réservation</th>
                          </tr>
                        </thead>
                        <tbody>
                        <% for(int i=0;i<mesReservations.size();i++){%>
                            <% ArrayList reservation = new ArrayList();%>
                            <% reservation = mesReservations.get(i);%>
                            <tr>
                              <th scope="row"><% out.println(i+1); %></th>
                              <td><% out.println(reservation.get(1)+" - "+reservation.get(2));%></td>
                              <td><% out.println(reservation.get(3));%></td>
                              <td><% out.println(reservation.get(4)); %></td>
                              <td><% out.println(reservation.get(5)); %></td>
                              <td><% out.println(reservation.get(6)); %></td>
                              <td><% out.println(reservation.get(7)); %></td>
                              <td><% out.println(reservation.get(8)); %></td>
                            </tr>
                        <% } %>
                        </tbody>
                      </table>
                    </nav>
                </div>
                <% if (request.getAttribute("nbrLink")!=null){%>
                    <% int nbrLink = (int) request.getAttribute("nbrLink"); %>
                    <div class="col-md-12 d-flex justify-content-center">
                        <nav  class="d-flex justify-content-center" aria-label="...">
                            <ul class="pagination pagination-lg justify-content-center">
                                <% for(int i=1;i<=nbrLink;i++) {%>
                                <li class="page-item"><a class="page-link" href="MyReservations?listNo=<%=i%>"><% out.println(i);%></a></li>
                                <% } %>
                            </ul>
                        </nav>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
</section>