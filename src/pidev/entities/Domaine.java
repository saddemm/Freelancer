/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.List;

/**
 *
 * @author SaddeM
 */
public class Domaine {
    private int id;
    private String label;
   


    
    
    public Domaine() {
    }

    public Domaine(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public Domaine(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
    
}
