/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SaddeM
 */
public class Freelancer extends User {
    
    private String cv;
    Grade grade;
    List <SousDomaine> sousdomaines = new ArrayList<SousDomaine>();

    public List<SousDomaine> getSousdomaines() {
        return sousdomaines;
    }

    public void setSousdomaines(List<SousDomaine> sousdomaines) {
        this.sousdomaines = sousdomaines;
    }
    
    

    public Freelancer() {
        
    }

    
    public Freelancer(String cv, Grade grade, int id, String login, String email, String password, String nom, String prenom, String date_naissance, String photo, int estActive, String lastLoginDate, int tokens) {
        super(id,login, email, password, nom, prenom, date_naissance, photo, estActive, lastLoginDate, tokens);
        this.cv = cv;
        this.grade = grade;
    }

    public Freelancer(String cv, Grade grade, String login, String email, String password, String nom, String prenom, String date_naissance, String photo, int estActive, String lastLoginDate, int tokens) {
        super(login, email, password, nom, prenom, date_naissance, photo, estActive, lastLoginDate, tokens);
        this.cv = cv;
        this.grade = grade;
     
    }
    
    

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "";
    }

    
  
    
}
