/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.beans;
import ensimag.caweb.config.DateModifier;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author
 */
public abstract class Personne {

    private int id;
    private String    email;    
    private String    nom;    
    private String    prenom;
    private String    sexe;
    private String    adresse;
    private Date dateNaissance;
    private String telephone;

    public Personne(int id, String email, String nom, String prenom, String sexe,
                    String adresse, String dateNaissance, String formatDate, String telephone) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateNaissance = DateModifier.dateFromString(dateNaissance, formatDate);
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

    public Date getDateNaissance() {
        return dateNaissance;
    }
    
    public java.sql.Date getDateNaissanceSql(){
        return DateModifier.convertDateUtilToSql(dateNaissance);
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public void setDateNaissance(String dateString, String format) {
        this.dateNaissance = DateModifier.dateFromString(dateString, format);
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }  

    @Override
    public String toString() {
        return "id=" + id + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", adresse=" + adresse + ", dateNaissance=" + dateNaissance + ", telephone=" + telephone+" ,";
    }
    
    
    
}
