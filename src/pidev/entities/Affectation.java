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
public class Affectation {
    
    private int id;
    private Projet projet;
    private Freelancer freelancer;
    private int etat;
    private int estLu;
    private String dateDemande;

    public Affectation() {
    }

    public Affectation(int id, Projet projet, Freelancer freelancer, int etat, int estLu, String dateDemande) {
        this.id = id;
        this.projet = projet;
        this.freelancer = freelancer;
        this.etat = etat;
        this.estLu = estLu;
        this.dateDemande = dateDemande;
    }

    
    public Affectation(Projet projet, Freelancer freelancer, int etat, int estLu, String dateDemande) {
        this.projet = projet;
        this.freelancer = freelancer;
        this.etat = etat;
        this.estLu = estLu;
        this.dateDemande = dateDemande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getEstLu() {
        return estLu;
    }

    public void setEstLu(int estLu) {
        this.estLu = estLu;
    }

    public String getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(String dateDemande) {
        this.dateDemande = dateDemande;
    }

    @Override
    public String toString() {
        return "";
    }
    
    
    
}
