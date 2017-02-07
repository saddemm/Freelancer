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
public class Commentaire {
    
    private int id;
    private Projet projet;
    private User user;
    private String contenu;
    private String datePost;

    public Commentaire() {
    }

    public Commentaire(int id, Projet projet, User user, String contenu, String datePost) {
        this.id = id;
        this.projet = projet;
        this.user = user;
        this.contenu = contenu;
        this.datePost = datePost;
    }

    public Commentaire(Projet projet, User user, String contenu, String datePost) {
        this.projet = projet;
        this.user = user;
        this.contenu = contenu;
        this.datePost = datePost;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", projet=" + projet + ", user=" + user + ", contenu=" + contenu + ", datePost=" + datePost + '}';
    }
    
    
    
}
