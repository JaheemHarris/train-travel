<%@page import="tables.Train"%>
<%@page import="tables.Compagnie"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Compagnie> listeCompagnie = new ArrayList();%>
<% listeCompagnie=(ArrayList)request.getAttribute("listeCompagnie");%>
<% Train trainToModify = (Train)request.getAttribute("trainToModify");%>
<div class="col-md-3">
    <form action="admin/ModifyTrain" method="post">
        <div class="form-group">
            <label for="idTrain">IdTrain</label>
            <input type="text" class="form-control" id="idTrain" name="idTrain" readonly value="<%=trainToModify.getIdTrain()%>">
        </div>
        <div class="form-group">
            <label for="nomCompagnie">NomCompagnie</label>
            <select id="nomCompagnie" class="form-select" name="idCompagnie">
                <% for(int i=0;i<listeCompagnie.size();i++) { %>
                    <% Compagnie compagnieTemp = listeCompagnie.get(i);%>
                    <option <% if(compagnieTemp.getIdCompagnie().equals(trainToModify.getIdCompagnie())){%><%="selected"%><%}%> value="<%=compagnieTemp.getIdCompagnie()%>">
                        <% out.println(compagnieTemp.getNomCompagnie());%>
                    </option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="numeroTrain">NumeroTrain</label>
            <input type="text" class="form-control" id="numeroTrain" name="numeroTrain" value="<%=trainToModify.getNumero()%>">
        </div>
        <div class="form-group">
            <label for="nombreDePlaces">Nombre de places</label>
            <input type="number" class="form-control" id="nombreDePlaces" name="nombreDePlaces" value="<%=trainToModify.getNombreDePlaces()%>">
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>
