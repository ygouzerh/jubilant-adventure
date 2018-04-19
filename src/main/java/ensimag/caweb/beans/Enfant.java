/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.beans;

/**
 *
 * @author ayoubmrini424
 */
public class Enfant extends Personne {
   
    private String  classe;
    private String  regime;

    public Enfant(String classe, String regime, int id,
                    String email, String nom, String prenom,
                    String sexe, String adresse, String dateNaissance,
                    String formatDate, String telephone) {
        super(id, email, nom, prenom, sexe, adresse, dateNaissance, formatDate, telephone);
        this.classe = classe;
        this.regime = regime;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }
    
    
    
    
}
