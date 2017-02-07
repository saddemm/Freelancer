/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entities.Commentaire;
import pidev.entities.Message;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IMessageDAO;
import pidev.interfaces.IProjetDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class MessageDAO implements IMessageDAO{
    
     private Connection connection;
    
    
    public MessageDAO() {
        connection = DataSource.getInstance().getConnection();
    }

     @Override
    public void envoyerMessage(Message message) {
        String requete = "insert into message (id_emetteur,id_destinataire,message,estLu,dateEnvoie) values (?,?,?,?,NOW())";

        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, message.getEmetteur().getId());
            ps.setInt(2, message.getDestinataire().getId());
            ps.setString(3, message.getMessage());
            ps.setInt(4, message.getEstLu());
          
          
            
            ps.executeUpdate();
            
          
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     @Override
    public Message FindMessageById(int id) {

      
        String requete = "select * from message where id=?";
        Message message = new Message();
       
       
        IUserDAO udao = UserDAO.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            if (resultat.next()) {
                
                message.setId(resultat.getInt(1));
                message.setEmetteur(udao.FindUserById(resultat.getInt(2)));
                message.setDestinataire(udao.FindUserById(resultat.getInt(3)));
                message.setMessage(resultat.getString(4));
                message.setEstLu(resultat.getInt(5));
 
                
            }
            return message;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
   
     @Override
   public List<Message> FindMessageByIdEmetteur(int id) {

        List<Message> listemsg = new ArrayList<Message>();

        String requete = "select * from Message where id_emetteur="+id;
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IMessageDAO mdao = MessageDAO.getInstance();
            IUserDAO udao = UserDAO.getInstance();
            while (resultat.next()) {
                Message message = new Message();
                
                message.setId(resultat.getInt(1));
                message.setEmetteur(udao.FindUserById(resultat.getInt(2)));
                message.setDestinataire(udao.FindUserById(resultat.getInt(3)));
                message.setMessage(resultat.getString(4));
                message.setEstLu(resultat.getInt(5));
                message.setDateEnvoie(resultat.getString(6));
              

                listemsg.add(message);
            }
            return listemsg;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }
   
     @Override

      public List<Message> FindMessageByIdDestinateire(int id) {

        List<Message> listemsg = new ArrayList<Message>();

        String requete = "select * from Message where id_destinataire="+id;
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IMessageDAO mdao = MessageDAO.getInstance();
            IUserDAO udao = UserDAO.getInstance();
            while (resultat.next()) {
                Message message = new Message();
                
                message.setId(resultat.getInt(1));
                message.setEmetteur(udao.FindUserById(resultat.getInt(2)));
                message.setDestinataire(udao.FindUserById(resultat.getInt(3)));
                message.setMessage(resultat.getString(4));
                message.setEstLu(resultat.getInt(5));
                message.setDateEnvoie(resultat.getString(6));
              

                listemsg.add(message);
            }
            return listemsg;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }
   
     @Override
   public void deleteMessage(int id) {
        
        String requete = "DELETE FROM message where id=?";
       
        
        try {
            
         
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, id);
            
            ps.executeUpdate();
            System.out.println("Message supprimer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
   
    public List<Message> DisplayAllMessages() {

        List<Message> listemsg = new ArrayList<Message>();

        String requete = "select * from Message";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IMessageDAO mdao = MessageDAO.getInstance();
            IUserDAO udao = UserDAO.getInstance();
            while (resultat.next()) {
                Message message = new Message();
                
                message.setId(resultat.getInt(1));
                message.setEmetteur(udao.FindUserById(resultat.getInt(2)));
                message.setDestinataire(udao.FindUserById(resultat.getInt(3)));
                message.setMessage(resultat.getString(4));
                message.setEstLu(resultat.getInt(5));
                message.setDateEnvoie(resultat.getString(6));
              

                listemsg.add(message);
            }
            return listemsg;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }
    
    private static IMessageDAO imessagedao;

    public static IMessageDAO getInstance() {
        if (imessagedao == null) {
            imessagedao = new MessageDAO();
        }
        return imessagedao;
    }
    
}
