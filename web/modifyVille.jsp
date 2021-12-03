<%@page import="tables.Ville"%>
<% Ville villeToModify = (Ville)request.getAttribute("villeToModify");%>
<div class="col-md-3">
    <form action="admin/ModifyVille" method="post">
        <div class="form-group">
            <label for="idVille">IdVille</label>
            <input type="text" class="form-control" id="nomVille" name="idVille" readonly value="<%=villeToModify.getIdVille()%>">
        </div>
        <div class="form-group">
            <label for="nomVille">NomVille</label>
            <input type="text" class="form-control" id="nomVille" name="nomVille" value="<%=villeToModify.getNom()%>">
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>