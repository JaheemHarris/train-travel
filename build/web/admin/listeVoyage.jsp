<%@page import="tables.Voyage"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Voyage> listeVoyage = new ArrayList();%>
<% listeVoyage=(ArrayList)request.getAttribute("listeVoyage"); %>
<table class="table table-hover table-dark .table-responsive">
  <thead>
    <tr>
      <th scope="col">idVoyage</th>
      <th scope="col">idHorraireTrain</th>
      <th scope="col">prixBillet(euro)</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
      <% Voyage voyageTemp = null; %>
      <% for(int i=0;i<listeVoyage.size();i++){%>
      <% voyageTemp=listeVoyage.get(i); %>
        <tr>
          <th scope="row"><%=voyageTemp.getIdVoyage() %></th>
          <td><%=voyageTemp.getIdHorraireTrain() %></td>
          <td><%=voyageTemp.getPrixBillet() %></td>
          <td><a href="#"><i class="far fa-edit"></i></a></td>
          <td><a href="DeleteVoyage?id=<%=voyageTemp.getIdVoyage()%>"><i class="far fa-trash-alt"></i></a></td>
        </tr>
      <% } %>
  </tbody>
</table>