<%@page import="tables.Compagnie"%>
<% Compagnie compagnieToModify = (Compagnie)request.getAttribute("compagnieToModify");%>
<div class="col-md-3">
    <form action="admin/ModifyCompagnie" method="post">
        <div class="form-group">
            <label for="idCompagnie">IdCompagnie</label>
            <input type="text" class="form-control" id="idCompagnie" name="idCompagnie" readonly value="<%=compagnieToModify.getIdCompagnie()%>">
        </div>
        <div class="form-group">
            <label for="nomVille">NomCompagnie</label>
            <input type="text" class="form-control" id="nomCompagnie" name="nomCompagnie" value="<%=compagnieToModify.getNomCompagnie()%>">
        </div>
        <button type="submit" class="btn btn-primary">Modifier</button>
    </form>
</div>