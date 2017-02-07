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
public class Message {
    private int id;
    private User emetteur;
    private User destinataire;
    private String message;
    private String dateEnvoie;
    private int estLu;

    public Message() {
    }

    
    
    public Message(int id, User emetteur, User destinataire, String message, String dateEnvoie, int estLu) {
        this.id = id;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.message = message;
        this.dateEnvoie = dateEnvoie;
        this.estLu = estLu;
    }

    public Message(User emetteur, User destinataire, String message, String dateEnvoie, int estLu) {
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.message = message;
        this.dateEnvoie = dateEnvoie;
        this.estLu = estLu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getEmetteur() {
        return emetteur;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", emetteur=" + emetteur + ", destinataire=" + destinataire + ", message=" + message + ", dateEnvoie=" + dateEnvoie + ", estLu=" + estLu + '}';
    }

    
    public void setEmetteur(User emetteur) {
        this.emetteur = emetteur;
    }

    public User getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(User destinataire) {
        this.destinataire = destinataire;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(String dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public int getEstLu() {
        return estLu;
    }

    public void setEstLu(int estLu) {
        this.estLu = estLu;
    }
    
    
    
    
}
