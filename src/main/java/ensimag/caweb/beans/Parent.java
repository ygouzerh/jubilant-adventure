
package ensimag.caweb.beans;

/**
 *
 * @author 
 */
public class Parent extends Personne {
    
    private String motDePasse;    

    public Parent(int id, String motDePasse, String email, String nom, String prenom, String sexe, String adresse, String dateNaissance, String telephone) {
        super(id, email, nom, prenom, sexe, adresse, dateNaissance, telephone);
        this.motDePasse = motDePasse;
    }
    
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
   
}