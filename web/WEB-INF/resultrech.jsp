<%-- 
    Document   : resultrech
    Created on : 8 nov. 2018, 03:13:18
    Author     : jmk
--%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Resultats Recherche</title>
    </head>
    <body>
        
        <%@include file="menu.jsp" %>
        
        <h1 class="text-center">Resultats de "<c:out value="${actionrech.rootRech}"/>" </h1>
        <div class="container">
            <div class="row">
                <c:forEach items="${actionrech.resultats}" var="list">
                    <div class="col-md-12">
                        <h1><c:out value="${list.value[1]}"/></h1>
                        <p><a href="<c:out value="${list.value[0]}"/>"><c:out value="${list.value[0]}"/></a></p>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        <%@include file="footer.jsp" %>
        
        <script src="assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>
