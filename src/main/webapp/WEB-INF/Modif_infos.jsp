<%@ page pageEncoding="UTF-8" %>
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

                <label for="telephone">Téléphone</label>
                <input type="tel" id="telephone" name="telephone" value="0634234565" size="10" maxlength="10" />
                <br />

                <label for="Adresse">Adresse</label>
                <input type="text" id="adresse" name="adresse" value="old address" size="60" maxlength="60" />
                <br />
                
                <p>...</p>


                <input type="submit" value="Modifier" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>