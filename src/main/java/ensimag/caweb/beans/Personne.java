/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.beans;

/**
 *
 * @author
 */
public class Personne {

    private int id;
    private String    email;    
    private String    nom;    
    private String    prenom;
    private String    sexe;
    private String    adresse;
    private String dateNaissance;
    private String telephone;

    public Personne(int id, String email, String nom, String prenom, String sexe,
                    String adresse, String dateNaissance, String telephone) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
            
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }        
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }  
    
}
