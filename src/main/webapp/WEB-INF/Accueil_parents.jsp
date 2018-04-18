<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil parents</title>
        <link type="text/css" rel="stylesheet" href="Acceuil_parents.css" />
    </head>
    <body>
    
    
    <h1>Bienvenue ${parent.sexe == 'm' ? 'M' : 'Mme'} ${parent.nom}</h1>
    <p>Pour modifier vos coordonnées cliquez <a href="ModifyInfo">ici</a></p>
    <p>Pour accéder aux fiches de vos enfants scolarisés cliquez <a href="DisplayChil">ici</a></p>
    
    <p>(Nouveau)La mairie vous invite à exprimer vos souhaits 
    pour les activités d'animation cliquez <a href="Expr_souhaits.jsp">ici</a>(
    seulement au début de chaque période)</p>
    
    
    
    <p>Pour modifier votre mot de passe cliquez <a href="Modif_mdp.jsp">ici</a></p>
    <p>(il faut qu'on l'ajoute partout: un header ..)Pour vous déconnecter cliquez <a href="ParentsSignout">ici</a></p> 
    



    

   </body>
</html>