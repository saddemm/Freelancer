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
import pidev.entities.Domaine;
import pidev.entities.Freelancer;
import pidev.entities.Grade;
import pidev.interfaces.IGradeDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class GradeDAO implements IGradeDAO {
    
    private Connection connection;
    
    
    public GradeDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insertGrade(Grade grade) {
        
        String requete = "insert into grade (label) values (?)";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setString(1, grade.getLabel());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
     public void deleteGrade(int id) {
        
        String requete = "DELETE FROM grade where id=?";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, id);
            
            ps.executeUpdate();
            System.out.println("Grade supprimer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
     public Grade findGradeById(int id) {
        Grade grade = new Grade();
        String requete = "select * from grade where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                grade.setId(resultat.getInt(1));
                grade.setLabel(resultat.getString(2));
            }
            return grade;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
     
     
     public List<Grade> DisplayAllGrade() {

        List<Grade> listegr = new ArrayList<Grade>();

        String requete = "select * from grade";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IGradeDAO gdao = GradeDAO.getInstance();
            
            while (resultat.next()) {
                Grade grade = new Grade();
                
                grade.setId(resultat.getInt(1));
                grade.setLabel(resultat.getString(2));
                
              

                listegr.add(grade);
            }
            return listegr;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Grades " + ex.getMessage());
            return null;
        }
    }
    
     private static IGradeDAO igradedao;

    public static IGradeDAO getInstance() {
        if (igradedao == null) {
            igradedao = new GradeDAO();
        }
        return igradedao;
    }
     
}
