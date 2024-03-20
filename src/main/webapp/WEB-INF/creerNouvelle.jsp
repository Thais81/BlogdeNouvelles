<%--
    Document   : creerNouvelle.jsp
    Created on : 19 mars 2024, 09:36:45
    Author     : kevinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CreateArticle</title>
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css" />">
        <link rel="stylesheet" href="<c:url value="/assets/css/form.css" />">
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
        <main>


            <form action="<c:url value="/profil/creer_nouvelle" />" method="post">
                <div class="error"> ${requestScope.errorMsg}</div>
                <fieldset>
                    <legend>Nouvelle</legend>
                    <div>
                        <label for="titre">Titre de la nouvelle</label>
                        <input type="text" id="titre" name="titre">
                        <div class="error">${requestScope.errors.titre}</div>
                    </div>
                    <div>
                        <label for="descriptif">Descriptif de la nouvelle</label>
                        <input type="text" id="descriptif" name="descriptif">
                        <div class="error">${requestScope.errors.descriptif}</div>
                    </div>
                    <div>
                        <label for="contenu">Contenu de la nouvelle</label>
                        <textarea id="contenu" name="next" rows="15" cols="25"></textarea>
                        <div class="error">${requestScope.errors.next}</div>

                    </div>
                </fieldset>
                <div class="buttons">
                    <input type="submit" value="Envoyer">
                    <input type="reset" value="Annuler">
                </div>
            </form>

        </main>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
