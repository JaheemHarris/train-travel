<%@page import="tables.Trajet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tables.Ville"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tables.Train"%>
<%@page import="java.util.ArrayList"%>
<% ArrayList<Train> listeTrain = new ArrayList();%>
<% listeTrain=(ArrayList)request.getAttribute("listeTrain"); %>
<% ArrayList<Ville> listeVille = new ArrayList();%>
<% listeVille=(ArrayList)request.getAttribute("listeVille"); %>
<% ArrayList<Trajet> listeTrajet = new ArrayList();%>
<% listeTrajet=(ArrayList)request.getAttribute("listeTrajet"); %>
<div class="col-md-3">
    <form action="AjoutHorraireTrain" method="post">
        <div class="form-group">
            <label for="idTrain">NumeroTrain</label>
            <select id="idTrain" class="form-select" name="idTrain" >
                <% for(int i=0;i<listeTrain.size();i++) { %>
                    <% Train trainTemp = listeTrain.get(i);%>
                    <option value="<%=trainTemp.getIdTrain()%>">
                        <% out.println(trainTemp.getIdTrain()); %>  N° <% out.println(trainTemp.getNumero() ); %>
                    </option>
                <% } %>
            </select>
        </div>
            <div class="form-group">
            <label for="trajet">Trajet</label>
            <select id="trajet" class="form-select" name="idTrajet">
                <% for(int i=0;i<listeTrajet.size();i++) { %>
                    <% Trajet trajetTemp=listeTrajet.get(i); %>
                    <%for(int ii=0;ii<listeVille.size();ii++){ %>
                        <% Ville villeTemp1 = listeVille.get(ii);%>
                        <%for(int iii=0;iii<listeVille.size();iii++){ %>
                            <% Ville villeTemp2 = listeVille.get(iii);%>
                            <% if(trajetTemp.getIdVilleDepart().compareTo(villeTemp1.getIdVille())==0 && trajetTemp.getIdVilleDestination().compareTo(villeTemp2.getIdVille())==0){ %>
                            <option value="<%=trajetTemp.getIdTrajet()%>">
                                <% out.println(villeTemp1.getNom());%>-<% out.println(villeTemp2.getNom());%>
                            </option>
                            <% }%>
                        <% }%>
                    <% }%>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="heureDepart">HeureDepart</label>
            <input type="time" class="form-control" id="heureDepart" placeholder="04:20" name="heureDepart">
        </div>
            <div class="form-group">
            <label for="heureArrivee">HeureArrivee</label>
            <input type="time" class="form-control" id="heureArrivee" placeholder="04:20" name="heureArrivee">
        </div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
    </form>
</div>