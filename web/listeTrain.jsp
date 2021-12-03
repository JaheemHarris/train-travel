<%@page import="tables.Train"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Train> listeTrain = new ArrayList();%>
<% listeTrain=(ArrayList)request.getAttribute("listeTrain"); %>
<table class="table table-hover table-dark .table-responsive">
  <thead>
    <tr>
      <th scope="col">idTrain</th>
      <th scope="col">idCompagnie</th>
      <th scope="col">numero</th>
      <th scope="col">nombreDePlaces</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
      <% Train trainTemp = null; %>
      <% for(int i=0;i<listeTrain.size();i++){%>
      <% trainTemp=listeTrain.get(i); %>
        <tr>
          <th scope="row"><%=trainTemp.getIdTrain() %></th>
          <td><%=trainTemp.getIdCompagnie() %></td>
          <td><%=trainTemp.getNumero() %></td>
          <td><%=trainTemp.getNombreDePlaces() %></td>
          <td><a href="admin/ModifyTrain?idTrain=<%=trainTemp.getIdTrain()%>"><i class="far fa-edit"></i></a></td>
          <td><a href="admin/DeleteTrain?id=<%=trainTemp.getIdTrain()%>"><i class="far fa-trash-alt"></i></a></td>
        </tr>
      <% } %>
  </tbody>
</table>