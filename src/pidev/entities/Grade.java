/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author SaddeM
 */
public class Grade {

    public Grade(int id, String label) {
        this.id = id;
        this.label = label;
    }
    
    private int id;
    private String label;

    public Grade() {
    }

    public Grade(String label) {
        
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
        return "Grade{" + "id=" + id + ", label=" + label + '}';
    }
    
    
    
}
