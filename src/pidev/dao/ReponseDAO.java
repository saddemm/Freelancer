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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pidev.entities.Question;
import pidev.entities.Reponse;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IQuestionDAO;
import pidev.interfaces.IReponseDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class ReponseDAO implements IReponseDAO{
     private Connection connection;
    
    
    private ReponseDAO() {
        connection = DataSource.getInstance().getConnection();
    }

     @Override
    public void insertReponse(Reponse reponse) {
        
        String requete = "insert into reponses (id_question,label,estCorrect) values (?,?,?)";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, reponse.getQuestion().getId());
             ps.setString(2, reponse.getLabel());
             ps.setInt(3, reponse.getEstCorrect());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
            
     @Override
     public void deleteReponse(int id) {
        
        String requete = "DELETE FROM reponses where id=?";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, id);
            
            ps.executeUpdate();
            System.out.println("Reponse supprimer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     @Override
     public Reponse findReponseById(int id) {
        Reponse reponse = new Reponse();
        IQuestionDAO qdao = QuestionDAO.getInstance();
        
        String requete = "select * from reponses where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                reponse.setId(resultat.getInt(1));
                reponse.setQuestion(qdao.findQuestionById(resultat.getInt(2)));
                reponse.setLabel(resultat.getString(3));
                reponse.setEstCorrect(resultat.getShort(1));
            }
            return reponse;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
      
     @Override
     public List<Reponse> DisplayAllReponses() {

        List<Reponse> listereponse = new ArrayList<Reponse>();
       IQuestionDAO qdao = QuestionDAO.getInstance();
        
        String requete = "select * from reponses";
        
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
    
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                Reponse reponse = new Reponse();
                reponse.setId(resultat.getInt(1));
                reponse.setQuestion(qdao.findQuestionById(resultat.getInt(2)));
                reponse.setLabel(resultat.getString(3));
                reponse.setEstCorrect(resultat.getShort(1));
         
         
                
                listereponse.add(reponse);
            }
            return listereponse;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
     
     @Override
     public List<Reponse> DisplayAllReponsesByIdQuestion(int id) {

        List<Reponse> listereponse = new ArrayList<Reponse>();
       IQuestionDAO qdao = QuestionDAO.getInstance();
        
        String requete = "select * from reponses where id_question="+id;
        
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
    
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                Reponse reponse = new Reponse();
                reponse.setId(resultat.getInt(1));
                reponse.setQuestion(qdao.findQuestionById(resultat.getInt(2)));
                reponse.setLabel(resultat.getString(3));
                reponse.setEstCorrect(resultat.getShort(4));
         
         
                
                listereponse.add(reponse);
            }
            return listereponse;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
     private static IReponseDAO ireponsedao;

    public static IReponseDAO getInstance() {
        if (ireponsedao == null) {
            ireponsedao = new ReponseDAO();
        }
        return ireponsedao;
    }
     
    
}
