/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.ArrayList;

/**
 *
 * @author SaddeM
 */
public class Projet {
    private int id;
    private String nom;
    private String details;
    private User user;
    private Domaine domaine;
    private int estVisible;

    public Projet() {
    }

    public Projet(int id, String nom, String details, User user, Domaine domaine, int estVisible) {
        this.id = id;
        this.nom = nom;
        this.details = details;
        this.user = user;
        this.domaine = domaine;
        this.estVisible = estVisible;
    }
    

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
    

    public Projet(String nom, String details, User user,Domaine domaine, int estVisible) {
        this.nom = nom;
        this.details = details;
        this.user = user;
        this.domaine = domaine;
        this.estVisible = estVisible;
    }

    
    
    public Projet(String nom, String details, User user,Domaine domaine) {
        this.nom = nom;
        this.details = details;
        this.user = user;
        this.domaine = domaine;
     
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
  

    public int getEstVisible() {
        return estVisible;
    }

    public void setEstVisible(int estVisible) {
        this.estVisible = estVisible;
    }

    @Override
    public String toString() {
        return "";
    }
    
    
   
    
    
    
    
    
}
