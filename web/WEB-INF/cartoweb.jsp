<%-- 
    Document   : cartoweb
    Created on : 7 nov. 2018, 23:23:09
    Author     : jmk
--%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>CartoWeb</title>
    </head>
    <body>
        
        <%@include file="menu.jsp" %>
        
        <h1 class="text-center logo">Carto Web</h1>
        <form method="post" action="${ (statut == 'carto') ? 'resultcarto' : 'resultrech' }">
            <div id="rech">
                <input class="input-lg" type="search" name="recherche" id="recherche" placeholder="${ (statut == 'carto') ? 'http://example.com' : 'Entre votre recherche...' }" >
            </div>
            <p class="text-center">
                <c:if test="${ statut == 'carto' }">
                    <input style="margin: 10px;width: 200px" class="btn btn-primary btn-lg" value="Créer la cartographie" role="button" type="submit">
                </c:if>
                <c:if test="${ statut == 'rech' }">
                    <input style="margin: 10px; width: 200px" class="btn btn-primary btn-lg" value="Recherche" role="button" type="submit">
                </c:if>
            </p>
        </form> 
        
        <%@include file="footer.jsp" %>
        
        <script src="assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
