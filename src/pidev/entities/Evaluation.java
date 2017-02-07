/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.sql.Date;

/**
 *
 * @author SaddeM
 */
public class Evaluation {
    
    private int id;
    private String contenu;
    private int nb_etoiles;
    private User evaluant;
    private User evaluer;
    private String dateEvaluation;

    public Evaluation() {
    }

    
    public Evaluation(int id, String contenu, int nb_etoiles, User evaluant, User evaluer, String dateEvaluation) {
        this.id = id;
        this.contenu = contenu;
        this.nb_etoiles = nb_etoiles;
        this.evaluant = evaluant;
        this.evaluer = evaluer;
        this.dateEvaluation = dateEvaluation;
    }

    public Evaluation(String contenu, int nb_etoiles, User evaluant, User evaluer, String dateEvaluation) {
        this.contenu = contenu;
        this.nb_etoiles = nb_etoiles;
        this.evaluant = evaluant;
        this.evaluer = evaluer;
        this.dateEvaluation = dateEvaluation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getNb_etoiles() {
        return nb_etoiles;
    }

    public void setNb_etoiles(int nb_etoiles) {
        this.nb_etoiles = nb_etoiles;
    }

    public User getEvaluant() {
        return evaluant;
    }

    public void setEvaluant(User evaluant) {
        this.evaluant = evaluant;
    }

    public User getEvaluer() {
        return evaluer;
    }

    public void setEvaluer(User evaluer) {
        this.evaluer = evaluer;
    }

    public String getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(String dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "id=" + id + ", contenu=" + contenu + ", nb_etoiles=" + nb_etoiles + ", evaluant=" + evaluant + ", evaluer=" + evaluer + ", dateEvaluation=" + dateEvaluation + '}';
    }
    
    
    
}
