<%@page import="tables.Compagnie"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Compagnie> listeCompagnie = new ArrayList();%>
<%listeCompagnie=(ArrayList)request.getAttribute("listeCompagnie");%>
<table class="table table-hover table-dark .table-responsive">
  <thead>
    <tr>
      <th scope="col">idCompagnie</th>
      <th scope="col">nom</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
      <% Compagnie compagnieTemp = null;%>
      <% for(int i=0;i<listeCompagnie.size();i++) { %>
      <% compagnieTemp=listeCompagnie.get(i); %>
        <tr>
          <th scope="row"><%=compagnieTemp.getIdCompagnie() %></th>
          <td><%=compagnieTemp.getNomCompagnie() %></td>
          <td><a href="ModifyCompagnie?idCompagnie=<%=compagnieTemp.getIdCompagnie()%>"><i class="far fa-edit"></i></a></td>
          <td><a href="DeleteCompagnie?id=<%=compagnieTemp.getIdCompagnie()%>"><i class="far fa-trash-alt"></i></a></td>
        </tr>
       <% } %>
  </tbody>
</table>