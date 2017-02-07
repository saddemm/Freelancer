/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SaddeM
 */
public class Question {
    
    private List<Reponse> reponses = new ArrayList<Reponse>();
    
    private int id;
    private Domaine domaine;
    private String label;

    public Question() {
    }

    public Question(int id, Domaine domaine, String label) {
        this.id = id;
        this.domaine = domaine;
        this.label = label;
    }

    public Question(Domaine domaine, String label) {
        this.domaine = domaine;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }
    
    
    
    
    
}
