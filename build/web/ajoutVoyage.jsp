<%@page import="tables.HorraireTrain"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<HorraireTrain> listeHorraireTrain = new ArrayList();%>
<% listeHorraireTrain=(ArrayList)request.getAttribute("listeHorraireTrain"); %>
<div class="col-md-3">
    <form action="AjoutVoyage" method="post">
        <div class="form-group">
            <label for="nomCompagnie">HorraireTrain</label>
            <select id="nomCompagnie" class="form-select" name="idHorraireTrain">
                <% for(int i=0;i<listeHorraireTrain.size();i++) { %>
                <% HorraireTrain horraireTemp = listeHorraireTrain.get(i);%>
                <option value="<%=horraireTemp.getIdHorraireTrain()%>">
                    <% out.println(horraireTemp.getIdHorraireTrain());%>
                </option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="nbrPlaces">Prix Billet</label>
            <input type="number" class="form-control" id="nbrPlaces"  name="prixBillet" min="1" value="1" required >
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>