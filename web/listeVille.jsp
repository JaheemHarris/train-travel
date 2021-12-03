<%@page import="tables.Ville"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Ville> listeVille = new ArrayList();%>
<% listeVille=(ArrayList)request.getAttribute("listeVille"); %>
<table class="table table-hover table-dark .table-responsive">
  <thead>
    <tr>
      <th scope="col">idVille</th>
      <th scope="col">nom</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
      <% Ville villeTemp = null;%>
      <% for(int i=0;i<listeVille.size();i++) { %>
      <% villeTemp=listeVille.get(i); %>
        <tr>
          <th scope="row"><%=villeTemp.getIdVille() %></th>
          <td><%=villeTemp.getNom() %></td>
          <td><a href="admin/ModifyVille?idVille=<%=villeTemp.getIdVille()%>"><i class="far fa-edit"></i></a></td>
          <td><a href="admin/DeleteVille?id=<%=villeTemp.getIdVille()%>"><i class="far fa-trash-alt"></i></a></td>
        </tr>
       <% } %>
  </tbody>
</table>