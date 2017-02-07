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
import pidev.entities.Domaine;
import pidev.entities.Freelancer;
import pidev.entities.Grade;
import pidev.entities.Question;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IGradeDAO;
import pidev.interfaces.IQuestionDAO;
import pidev.interfaces.IReponseDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class QuestionDAO implements IQuestionDAO{
    
    private Connection connection;
    
    
    private QuestionDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insertQuestion(Question question) {
        
        String requete = "insert into questions (id_domaine,label) values (?,?)";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, question.getDomaine().getId());
             ps.setString(2, question.getLabel());
            
            ps.executeUpdate();
            System.out.println("Question ajoutée");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
            
    @Override
     public void deleteQuestion(int id) {
        
        String requete = "DELETE FROM questions where id=?";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, id);
            
            ps.executeUpdate();
            System.out.println("Question supprimer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
     public Question findQuestionById(int id) {
        Question question = new Question();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        
        String requete = "select * from questions where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                question.setId(resultat.getInt(1));
                question.setDomaine(ddao.findDomaineById(resultat.getInt(2)));
                question.setLabel(resultat.getString(3));
            }
            return question;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
      
    @Override
     public List<Question> DisplayAllQuestions() {

        List<Question> listequestions = new ArrayList<Question>();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        
        String requete = "select * from questions";
        
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
    
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                   Question question = new Question();        
                question.setId(resultat.getInt(1));
                question.setDomaine(ddao.findDomaineById(resultat.getInt(2)));
                question.setLabel(resultat.getString(3));
         
         
                
                listequestions.add(question);
            }
            return listequestions;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
     
     @Override
     public List<Question> DisplayAllQuestionsRepsByIdDomaine(int id) {

        List<Question> listequestions = new ArrayList<Question>();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        IReponseDAO rdao = ReponseDAO.getInstance();
        
        String requete = "select * from questions where id_domaine="+id+" order by rand()";
        
        
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
    
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                   Question question = new Question();        
                question.setId(resultat.getInt(1));
                question.setDomaine(ddao.findDomaineById(resultat.getInt(2)));
                question.setLabel(resultat.getString(3));
                question.setReponses(rdao.DisplayAllReponsesByIdQuestion(resultat.getInt(1)));
     
                
                listequestions.add(question);
            }
            return listequestions;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
     private static IQuestionDAO iquestiondao;

    public static IQuestionDAO getInstance() {
        if (iquestiondao == null) {
            iquestiondao = new QuestionDAO();
        }
        return iquestiondao;
    }
     
    
}
