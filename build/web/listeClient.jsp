<%@page import="tables.Client"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Client> listeClient= new ArrayList(); %>
<% listeClient=(ArrayList)request.getAttribute("lesClients");%>
<table class="table table-hover table-dark .table-responsive">
  <thead>
    <tr>
      <th scope="col">idClient</th>
      <th scope="col">nom</th>
      <th scope="col">prenom</th>
      <th scope="col">mail</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
      <% Client userTemp = null;%>
      <% for(int i=0;i<listeClient.size();i++){ %>
      <% userTemp = listeClient.get(i);%>
        <tr>
          <th scope="row"><%=userTemp.getIdClient() %></th>
          <td><%=userTemp.getNom() %></td>
          <td><%=userTemp.getPrenom() %></td>
          <td><%=userTemp.getMail() %></td>
          <td><a href="#"><i class="far fa-edit"></i></a></td>
          <td><a href="admin/DeleteClient?id=<%=userTemp.getIdClient()%>"><i class="far fa-trash-alt"></i></a></td>
        </tr>
       <% } %>
  </tbody>
</table>