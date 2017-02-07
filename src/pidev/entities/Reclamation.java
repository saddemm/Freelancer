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
public class Reclamation {
    private int id;
    private User user;
    private String message;
    private String dateReclamation;
    private int estLu;

    public Reclamation() {
    }

    public Reclamation(int id, User user, String message, String dateReclamation, int estLu) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.dateReclamation = dateReclamation;
        this.estLu = estLu;
    }
    
    

    public Reclamation(User user, String message,String dateReclamation, int estLu) {
        this.user = user;
        this.message = message;
        this.dateReclamation = dateReclamation;
        this.estLu = estLu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

  

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(String dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    public int getEstLu() {
        return estLu;
    }

    public void setEstLu(int estLu) {
        this.estLu = estLu;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", user=" + user + ", message=" + message + ", dateReclamation=" + dateReclamation + ", estLu=" + estLu + '}';
    }
    
    
    
}

