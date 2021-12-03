<%@page import="tables.Ville"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Ville> listeVille = new ArrayList();%>
<% listeVille=(ArrayList)request.getAttribute("listeVille"); %>
<div class="col-md-3">
    <form action="AjoutTrajet" method="post">
        <div class="form-group">
            <label for="villeDepart">Depart</label>
            <select id="villeDepart" class="form-select" name="idVilleDepart" >
                <% for(int i=0;i<listeVille.size();i++) { %>
                <% Ville villeTemp1 =listeVille.get(i); %>
                <option value="<%=villeTemp1.getIdVille()%>">
                    <% out.println(villeTemp1.getNom());%>
                </option>
                <% } %>
            </select>
            <label for="villeDestination">Destination</label>
            <select id="villeDestination" class="form-select" name="idVilleDestination">
                <% for(int i=listeVille.size()-1;0<=i;i--) { %>
                <% Ville villeTemp2 =listeVille.get(i); %>
                <option value="<%=villeTemp2.getIdVille()%>">
                    <% out.println(villeTemp2.getNom());%>
                </option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="distance">Distance</label>
            <input type="text" class="form-control" id="distance" value="100" name="distance">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>