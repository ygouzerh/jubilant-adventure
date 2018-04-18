<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="Modif_infos.css" />
    </head>
    <body>
        <form method="post" action="Modif_infos">
            <fieldset>
                <legend>Infos</legend>
                <p>Vous pouvez changer vos infos via ce formulaire.</p>

                <label for="nom">Nom</label>
                <input type="tel" id="nom" name="nom" value="${parent.nom}" size="30" maxlength="29" />
                <br />

                <label for="Adresse">Prénom</label>
                <input type="text" id="adresse" name="prenom" value="${parent.prenom}" size="30" maxlength="29" />
                <br />
                
                <label for="sexe">Sexe</label>
                <input type="text" id="sexe" name="sexe" value="${parent.sexe}" size="5" maxlength="1" />
                <br />
                
                <label for="Datenaissance">Date de naissance</label>
                <input type="text" id="datenaissance" name="datenaissance" value="${parent.dateNaissance}" size="15" maxlength="15" />
                <br />

                <label for="Adresse">Adresse</label>
                <input type="text" id="adresse" name="adresse" value="${parent.adresse}" size="100" maxlength="100" />
                <br />
                
                <label for="telephone">Téléphone</label>
                <input type="tel" id="telephone" name="telephone" value="${parent.telephone}" size="10" maxlength="10" />
                <br />

                <input type="submit" value="Modifier" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>