<%@page import="tables.Trajet"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Trajet> listeTrajet = new ArrayList();%>
<% listeTrajet=(ArrayList)request.getAttribute("listeTrajet"); %>
<table class="table table-hover table-dark .table-responsive">
  <thead>
    <tr>
      <th scope="col">idTrajet</th>
      <th scope="col">idVilleDepart</th>
      <th scope="col">idVilleDestination</th>
      <th scope="col">Distance</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
      <% Trajet trajetTemp = null; %>
      <% for(int i=0;i<listeTrajet.size();i++){%>
      <% trajetTemp=listeTrajet.get(i); %>
        <tr>
          <th scope="row"><%=trajetTemp.getIdTrajet() %></th>
          <td><%=trajetTemp.getIdVilleDepart() %></td>
          <td><%=trajetTemp.getIdVilleDestination() %></td>
          <td><%=trajetTemp.getDistance() %></td>
          <td><a href="ModifyTrajet?idTrajet=<%=trajetTemp.getIdTrajet()%>"><i class="far fa-edit"></i></a></td>
          <td><a href="DeleteTrajet?id=<%=trajetTemp.getIdTrajet()%>"><i class="far fa-trash-alt"></i></a></td>
        </tr>
      <% } %>
  </tbody>
</table>