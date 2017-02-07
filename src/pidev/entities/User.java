/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import java.util.Date;

/**
 *
 * @author SaddeM
 */
public class User {
    private int id;
    private String login;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String photo;
    private int estActive;
    private String lastLoginDate;
    private int tokens;

    public User() {
    }

    
    public User(int id, String login, String email, String password, String nom, String prenom, String date_naissance, String photo, int estActive, String lastLoginDate, int tokens) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.photo = photo;
        this.estActive = estActive;
        this.lastLoginDate = lastLoginDate;
        this.tokens = tokens;
    }

    public User(String login, String email, String password, String nom, String prenom, String date_naissance, String photo, int estActive, String lastLoginDate, int tokens) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.photo = photo;
        this.estActive = estActive;
        this.lastLoginDate = lastLoginDate;
        this.tokens = tokens;
    }
    
    public User(String login, String email, String password, String nom, String prenom, String date_naissance, int estActive, int tokens) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.estActive = estActive;
        this.tokens = tokens;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getEstActive() {
        return estActive;
    }

    public void setEstActive(int estActive) {
        this.estActive = estActive;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", photo=" + photo + ", estActive=" + estActive + ", lastLoginDate=" + lastLoginDate + ", tokens=" + tokens + '}';
    }
    
    
    
    
}
