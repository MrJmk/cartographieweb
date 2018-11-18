<%-- 
    Document   : resultcarto
    Created on : 8 nov. 2018, 02:26:52
    Author     : jmk
--%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <link rel="stylesheet" href="assets/css/arbores.css">
        <title>Resultats Cartographie Web</title>
    </head>
    <body>
        
        <%@include file="menu.jsp" %>
        
        <h1 class="text-center">Resultats de "<c:out value="${action.root}"/>"</h1>
        <div>
            <ul id="abr">
                
                <%-- <li><input type="checkbox" id="c1" />
                    <i class="fa fa-angle-double-right"></i>
                    <i class="fa fa-angle-double-down"></i>
                    <label for="c1">  <c:out value="${action.root}"/> </label>
                    <ul>
                        <c:forEach items="${action.liens}" var="item">
                            <li><input type="checkbox" id="a<c:out value="${i}"/>" />
                                <i class="fa fa-angle-double-right"></i>
                                <i class="fa fa-angle-double-down"></i>
                                <label for="a<c:out value="${i}"/>"> <c:out value="${item}"/> </label>
                                <ul>
                                    <c:forEach items="${action.listes[i]}" var="list">
                                        <li><c:out value="${list}" /></li>
                                    </c:forEach>
                                </ul>
                                <% i++; %>
                            </li>
                        </c:forEach>
                    </ul>
                </li> --%>
                
                <li><input type="checkbox" id="c1" />
                    <i class="fa fa-angle-double-right"></i>
                    <i class="fa fa-angle-double-down"></i>
                    <label for="c1"> <c:out value="${action.root}"/> </label>
                    <ul>
                        <c:forEach items="${action.liens}" var="item">
                            <li><c:out value="${item}" /></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
        </div>
        
        <%@include file="footer.jsp" %>
        
        <script src="assets/js/jquery.min.js" type="text/javascript"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>
