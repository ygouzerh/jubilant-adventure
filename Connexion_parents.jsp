<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="Connexion_parents.css" />
    </head>
    <body>
        <form method="post" action="Connexion_parents">
            <fieldset>
                <legend>Espace Parents</legend>
                
                
                <label for="nom">Nom d'utilisateur</label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="20" />
                <br />

                <label for="motdepasse">Mot de passe</label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br />




                <input type="submit" value="Se connecter" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>