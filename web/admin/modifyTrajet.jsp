<%@page import="tables.Trajet"%>
<%@page import="tables.Ville"%>
<%@page import="java.util.ArrayList"%>
<% Trajet trajetToModify = (Trajet)request.getAttribute("trajetToModify");%>
<% ArrayList<Ville> listeVille = new ArrayList();%>
<% listeVille=(ArrayList)request.getAttribute("listeVille"); %>
<div class="col-md-3">
    <form action="ModifyTrajet" method="post">
        <div class="form-group">
            <label for="idTrajet">IdTrajet</label>
            <input type="text" class="form-control" id="idTrajet" name="idTrajet" readonly value="<%=trajetToModify.getIdTrajet()%>" >
        </div>
        <div class="form-group">
            <label for="villeDepart">Depart</label>
            <select id="villeDepart" class="form-select" name="idVilleDepart" >
                <% for(int i=0;i<listeVille.size();i++) { %>
                <% Ville villeTemp1 =listeVille.get(i); %>
                <option <% if(villeTemp1.getIdVille().equals(trajetToModify.getIdVilleDepart())){%><%="selected"%><%}%> value="<%=villeTemp1.getIdVille()%>">
                    <% out.println(villeTemp1.getNom());%>
                </option>
                <% } %>
            </select>
            <label for="villeDestination">Destination</label>
            <select id="villeDestination" class="form-select" name="idVilleDestination">
                <% for(int i=listeVille.size()-1;0<=i;i--) { %>
                <% Ville villeTemp2 =listeVille.get(i); %>
                <option <% if(villeTemp2.getIdVille().equals(trajetToModify.getIdVilleDestination())){%><%="selected"%><%}%> value="<%=villeTemp2.getIdVille()%>">
                    <% out.println(villeTemp2.getNom());%>
                </option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="distance">Distance</label>
            <input type="text" class="form-control" id="distance"  value="100" name="distance" value="<%=trajetToModify.getDistance()%>"/>
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>
