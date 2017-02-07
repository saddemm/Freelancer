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
import pidev.entities.Message;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IMessageDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class DomaineDAO implements IDomaineDAO{
   private Connection connection;
    
    private DomaineDAO() {
        connection = DataSource.getInstance().getConnection();
    }

   @Override
    public void insertDomaine(Domaine domaine) {
        
        String requete = "insert into domaine (label) values (?)";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setString(1, domaine.getLabel());
            
            
            ps.executeUpdate();
            
         
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   @Override
    public void deleteDomaine(int id) {
        
        String requete = "DELETE FROM domaine where id=?";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, id);
            
            ps.executeUpdate();
            System.out.println("Domaine supprimer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   @Override
    public Domaine findDomaineById(int id) {
        Domaine domaine = new Domaine();
        String requete = "select * from domaine where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                domaine.setId(resultat.getInt(1));
                domaine.setLabel(resultat.getString(2));
            }
            return domaine;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
    
    @Override
   public List<Domaine> DisplayAllDomaines() {

        List<Domaine> listdomaine = new ArrayList<Domaine>();

        String requete = "select * from domaine";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IMessageDAO mdao = MessageDAO.getInstance();
            IUserDAO udao = UserDAO.getInstance();
            while (resultat.next()) {
                Domaine domaine = new Domaine();
                
                domaine.setId(resultat.getInt(1));
                domaine.setLabel(resultat.getString(2));
              
              

                listdomaine.add(domaine);
            }
            return listdomaine;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }
    
    
    private static IDomaineDAO idomainedao;

    public static IDomaineDAO getInstance() {
        if (idomainedao == null) {
            idomainedao = new DomaineDAO();
        }
        return idomainedao;
    }
    
}
