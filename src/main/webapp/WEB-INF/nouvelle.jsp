<%--
    Document   : nouvelle
    Created on : 19 mars 2024, 13:21:41
    Author     : kevinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nouvelle</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
        <link rel="shortcut icon" href="<c:url value="/assets/img/logoLivre.png"/>" type="livre"/>

    </head>

    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main>

            <h1 class="titre"><c:out value="${nouvelle.titre}"/></h1>
            <div class="under">Écrit par <c:out value="${sessionScope.user.pseudo}}"/> le ${nouvelle.date_publication}</div>
            <div><c:out value="${nouvelle.contenu}"/></div>

            <c:if test="${sessionScope.user != null}">

                <div class="avis">
                    <form action="nouvelle.jsp" method="post">
                        <label for="commentaire">Tu as un avis? Partage le :</label><br>
                        <div class="error">${requestScope.errors.contenu}</div>
                        <textarea id="contenu" name="contenu" rows="4" cols="50"></textarea><br>
                        <input type="submit" value="Poster">
                        <input type="reset" value="Annuler" onclick="history.back()">
                    </form>
                </div>
            </c:if>
            <h2>Liste des commentaires</h2>
            <c:forEach var="commentaire" items="${requestScope.commentaire}">
                <article>
                    <div class="under">Écrit par ${commentaire.pseudo} le ${commentaire.date}</div>
                    <div>${commentaire.contenu}</div>
                </article>
            </c:forEach>

        </main>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>

</html>

