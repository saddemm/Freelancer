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
public class Test {
    
    private int id;
    private Freelancer freelancer;
    private Domaine domaine;
    private int note;
    private String dateTest;
    private int duree;

    public Test() {
    }

    public Test(int id, Freelancer freelancer, Domaine domaine, int note, String dateTest, int duree) {
        this.id = id;
        this.freelancer = freelancer;
        this.domaine = domaine;
        this.note = note;
        this.dateTest = dateTest;
        this.duree = duree;
    }

    public Test(Freelancer freelancer, Domaine domaine, int note, String dateTest, int duree) {
        this.freelancer = freelancer;
        this.domaine = domaine;
        this.note = note;
        this.dateTest = dateTest;
        this.duree = duree;
    }

    public Test(Freelancer freelancer, Domaine domaine, int note, int duree) {
        this.freelancer = freelancer;
        this.domaine = domaine;
        this.note = note;
        this.duree = duree;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getDateTest() {
        return dateTest;
    }

    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Test{" + "id=" + id + ", freelancer=" + freelancer + ", domaine=" + domaine + ", note=" + note + ", dateTest=" + dateTest + ", duree=" + duree + '}';
    }
    
    

    
    
}
