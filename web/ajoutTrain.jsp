<%@page import="tables.Compagnie"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Compagnie> listeCompagnie = new ArrayList();%>
<%listeCompagnie=(ArrayList)request.getAttribute("listeCompagnie");%>
<div class="col-md-3">
    <form action="AjoutTrain" method="post">
        <div class="form-group">
            <label for="nomCompagnie">NomCompagnie</label>
            <select id="nomCompagnie" class="form-select" name="idCompagnie">
                <% for(int i=0;i<listeCompagnie.size();i++) { %>
                <% Compagnie compagnieTemp = listeCompagnie.get(i);%>
                <option value="<%=compagnieTemp.getIdCompagnie()%>">
                    <% out.println(compagnieTemp.getNomCompagnie());%>
                </option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="numeroTrain">NumeroTrain</label>
            <input type="text" class="form-control" id="numeroTrain" placeholder="012345" name="numeroTrain" required>
        </div>
        <div class="form-group">
            <label for="nbrPlaces">Nombre de places</label>
            <input type="number" class="form-control" id="nbrPlaces" min="150" value="150" name="nbrPlaces" required >
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>