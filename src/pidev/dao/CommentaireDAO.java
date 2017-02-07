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
import pidev.entities.Affectation;
import pidev.entities.Commentaire;
import pidev.entities.Domaine;
import pidev.entities.Freelancer;

import pidev.interfaces.ICommentaireDAO;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IGradeDAO;
import pidev.interfaces.IProjetDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class CommentaireDAO implements ICommentaireDAO {
    
    private Connection connection;
    
    
    public CommentaireDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insertCommentaire(Commentaire commentaire) {
        String requete = "insert commentaire (id_projet,id_user,contenu,datePost) values (?,?,?,NOW())";

        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, commentaire.getProjet().getId());
            ps.setInt(2, commentaire.getUser().getId());
            ps.setString(3, commentaire.getContenu());
          
          
            
            ps.executeUpdate();
            
          
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Commentaire FindCommentaireById(int id) {

      
        String requete = "select * from commentaire where id=?";
        Commentaire commentaire = new Commentaire();
       
        IProjetDAO pdao = ProjetDAO.getInstance();
        IUserDAO udao = UserDAO.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            if (resultat.next()) {
                
                commentaire.setId(resultat.getInt(1));
                commentaire.setProjet(pdao.findProjetById(resultat.getInt(2)));
                commentaire.setUser(udao.FindUserById(resultat.getInt(3)));
                commentaire.setContenu(resultat.getString(4));
                commentaire.setDatePost(resultat.getString(5));
 
                
            }
            return commentaire;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
   
    @Override
    public List<Commentaire> FindCommentaireByIdProjet(int id) {

        List<Commentaire> listecommentaires = new ArrayList<Commentaire>();
         IProjetDAO pdao = ProjetDAO.getInstance();
        IUserDAO udao = UserDAO.getInstance();
        
        String requete = "select * from commentaire where id_projet=?";
        
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
    
            
            while (resultat.next()) {
                
                Commentaire commentaire = new Commentaire();
                 commentaire.setId(resultat.getInt(1));
                commentaire.setProjet(pdao.findProjetById(resultat.getInt(2)));
                commentaire.setUser(udao.FindUserById(resultat.getInt(3)));
                commentaire.setContenu(resultat.getString(4));
                commentaire.setDatePost(resultat.getString(5));
                
                listecommentaires.add(commentaire);
            }
            return listecommentaires;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Commentaire> DisplayAllCommentaires() {

        List<Commentaire> listecommentaires = new ArrayList<Commentaire>();
         IProjetDAO pdao = ProjetDAO.getInstance();
        IUserDAO udao = UserDAO.getInstance();
        
        String requete = "select * from commentaire";
        Commentaire commentaire = new Commentaire();
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
    
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                
                 commentaire.setId(resultat.getInt(1));
                commentaire.setProjet(pdao.findProjetById(resultat.getInt(2)));
                commentaire.setUser(udao.FindUserById(resultat.getInt(3)));
                commentaire.setContenu(resultat.getString(4));
                commentaire.setDatePost(resultat.getString(5));
                
                listecommentaires.add(commentaire);
            }
            return listecommentaires;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public void updateCommentaire(Commentaire c) {
        String requete = "update commentaire set contenu=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, c.getContenu());
            ps.setInt(1, c.getId());
           
            ps.executeUpdate();
  
 
            
        } catch (SQLException ex) {
            //Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    
     
    
    private static ICommentaireDAO icommentairedao;

    public static ICommentaireDAO getInstance() {
        if (icommentairedao == null) {
            icommentairedao = new CommentaireDAO();
        }
        return icommentairedao;
    }
    
}
