<%@page import="tables.HorraireTrain"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<HorraireTrain> listeHorraireTrain = new ArrayList();%>
<% listeHorraireTrain=(ArrayList)request.getAttribute("listeHorraireTrain"); %>
<table class="table table-hover table-dark .table-responsive">
  <thead>
    <tr>
      <th scope="col">idHorraireTrain</th>
      <th scope="col">idTrain</th>
      <th scope="col">idTrajet</th>
      <th scope="col">heureDepart</th>
      <th scope="col">heureArrivee</th>
      <th scope="col">Modifier</th>
      <th scope="col">Supprimer</th>
    </tr>
  </thead>
  <tbody>
      <% HorraireTrain horraireTrainTemp = null; %>
      <% for(int i=0;i<listeHorraireTrain.size();i++){%>
      <% horraireTrainTemp=listeHorraireTrain.get(i); %>
        <tr>
          <th scope="row"><%=horraireTrainTemp.getIdHorraireTrain() %></th>
          <td><%=horraireTrainTemp.getIdTrain() %></td>
          <td><%=horraireTrainTemp.getIdTrajet() %></td>
          <td><%=horraireTrainTemp.getHeureDepart() %></td>
          <td><%=horraireTrainTemp.getHeureArrivee() %></td>
          <td><a href="#"><i class="far fa-edit"></i></a></td>
          <td><a href="admin/DeleteHorraireTrain?id=<%=horraireTrainTemp.getIdHorraireTrain()%>"><i class="far fa-trash-alt"></i></a></td>
        </tr>
      <% } %>
  </tbody>
</table>