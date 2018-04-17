<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="Connexion_parents.css" />
    </head>
    <body>
        <form method="post" action="ParentsLogin">
            <fieldset>
                <legend>Connexion Parents</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${parent.email}"/>" size="40" maxlength="60" />
                <span class="erreur">${form.errors['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.errors['motdepasse']}</span>
                <br />
                
                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                
                <p class="${empty form.errors ? 'succes' : 'erreur'}">${form.result}</p>
            </fieldset>
        </form>
    </body>
</html>