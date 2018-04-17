<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="Modif_mdp.css" />
    </head>
    <body>
        <form method="post" action="Modif_mdp">
            <fieldset>
                <legend>Changement mdp</legend>
                <p>Vous pouvez canger votre mpd via ce formulaire.</p>
                <h3>Ou bien</h3>
                <p>Par mesure de sécurité, on vous demande de changer le mot de passe qu'on vient
                de vous délivrer. (On se sert de la même vue pour le changement du mpd lors de la 
                première connexion)</p>
                

                <label for="old_motdepasse">Ancien Mot de passe</label>
                <input type="password" id="old_motdepasse" name="old_motdepasse" value="" size="20" maxlength="20" />
                <br />
                
                <label for="new_motdepasse">Nouveau Mot de passe</label>
                <input type="password" id="new_motdepasse" name="new_motdepasse" value="" size="20" maxlength="20" />
                <br />

                <label for="confirmation">Confirmation du nouveau mot de passe<span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Changer" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </body>
</html>