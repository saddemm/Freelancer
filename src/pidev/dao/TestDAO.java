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
import pidev.entities.Test;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IQuestionDAO;
import pidev.interfaces.ITestDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class TestDAO implements ITestDAO{
    
    private Connection connection;
    
    
    private TestDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insertTest(Test test) {
        
        String requete = "insert into test (id_freelancer,id_domaine,note,duree,dateTest) values (?,?,?,?,NOW())";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, test.getFreelancer().getId());
             ps.setInt(2, test.getDomaine().getId());
             ps.setInt(3, test.getNote());
             ps.setInt(4, test.getDuree());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
           
    @Override
     public void deleteTest(int id) {
        
        String requete = "DELETE FROM test where id=?";
       
        
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
     public Test findTestById(int id) {
        Test test = new Test();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        IFreelancerDAO fdao = FreelancerDAO.getInstance();
        
        String requete = "select * from question where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                test.setId(resultat.getInt(1));
                test.setFreelancer(fdao.FindFreelancerById(resultat.getInt(2)));
                test.setDomaine(ddao.findDomaineById(resultat.getInt(3)));
                test.setNote(resultat.getInt(4));
                test.setDuree(resultat.getInt(5));
                test.setDateTest(resultat.getString(6));
            }
            return test;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
     
    @Override
     public Test findTestByFreelancer(int id) {
        Test test = new Test();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        IFreelancerDAO fdao = FreelancerDAO.getInstance();
        
        String requete = "select * from question where id_freelancer=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                test.setId(resultat.getInt(1));
                test.setFreelancer(fdao.FindFreelancerById(resultat.getInt(2)));
                test.setDomaine(ddao.findDomaineById(resultat.getInt(3)));
                test.setNote(resultat.getInt(4));
                test.setDuree(resultat.getInt(5));
                test.setDateTest(resultat.getString(6));
            }
            return test;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
     
    @Override
     public Test findTestByDomaine(int id) {
        Test test = new Test();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        IFreelancerDAO fdao = FreelancerDAO.getInstance();
        
        String requete = "select * from question where id_domaine=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                test.setId(resultat.getInt(1));
                test.setFreelancer(fdao.FindFreelancerById(resultat.getInt(2)));
                test.setDomaine(ddao.findDomaineById(resultat.getInt(3)));
                test.setNote(resultat.getInt(4));
                test.setDuree(resultat.getInt(5));
                test.setDateTest(resultat.getString(6));
            }
            return test;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
      
    @Override
     public List<Test> DisplayAllTests() {

        List<Test> listetests = new ArrayList<Test>();
        Test test = new Test();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        IFreelancerDAO fdao = FreelancerDAO.getInstance();
        
        String requete = "select * from questions";
       
        
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
    
            ResultSet resultat = ps.executeQuery(requete);
            
            while (resultat.next()) {
                
                test.setId(resultat.getInt(1));
                test.setFreelancer(fdao.FindFreelancerById(resultat.getInt(2)));
                test.setDomaine(ddao.findDomaineById(resultat.getInt(3)));
                test.setNote(resultat.getInt(4));
                test.setDuree(resultat.getInt(5));
                test.setDateTest(resultat.getString(6));
                
                listetests.add(test);
            }
            return listetests;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
     private static ITestDAO itestdao;

    public static ITestDAO getInstance() {
        if (itestdao == null) {
            itestdao = new TestDAO();
        }
        return itestdao;
    }
    
}
