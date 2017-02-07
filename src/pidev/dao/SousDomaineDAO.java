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
import pidev.entities.SousDomaine;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IMessageDAO;
import pidev.interfaces.ISousDomaineDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class SousDomaineDAO implements ISousDomaineDAO{
   private Connection connection;
    
    private SousDomaineDAO() {
        connection = DataSource.getInstance().getConnection();
    }

   @Override
    public void insertSousDomaine(SousDomaine Sousdomaine) {
        
        String requete = "insert into sous_domaine (label,id_domaine) values (?,?)";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setString(1, Sousdomaine.getLabel());
            ps.setInt(2, Sousdomaine.getDomaine().getId());
                    
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   @Override
    public void deleteSousDomaine(int id) {
        
        String requete = "DELETE FROM sous_domaine where id=?";
       
        
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
    public SousDomaine findSousDomaineById(int id) {
        SousDomaine sousdomaine = new SousDomaine();
        IDomaineDAO domainedao = DomaineDAO.getInstance();
        
        String requete = "select * from sous_domaine where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                sousdomaine.setId(resultat.getInt(1));
                sousdomaine.setDomaine(domainedao.findDomaineById(resultat.getInt(2)));
                sousdomaine.setLabel(resultat.getString(3));
            }
            return sousdomaine;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<SousDomaine> findSousDomaineByIdDom(int id) {
        List<SousDomaine> listsousdomaines = new ArrayList<SousDomaine>();
        IDomaineDAO domainedao = DomaineDAO.getInstance();
        
        String requete = "select * from sous_domaine where id_domaine=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                SousDomaine sousdomaine = new SousDomaine();
                sousdomaine.setId(resultat.getInt(1));
                sousdomaine.setDomaine(domainedao.findDomaineById(resultat.getInt(2)));
                sousdomaine.setLabel(resultat.getString(3));
                
                listsousdomaines.add(sousdomaine);
            }
            return listsousdomaines;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<SousDomaine> findSousDomaineByIdFreelancer(int id) {
        List<SousDomaine> listsousdomaines = new ArrayList<SousDomaine>();
        IDomaineDAO domainedao = DomaineDAO.getInstance();
        
        String requete = "select sd.id,sd.id_domaine,sd.label from domaine_freelancer df, sous_domaine sd where df.id_sous_domaine=sd.id AND id_freelancer=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                SousDomaine sousdomaine = new SousDomaine();
                sousdomaine.setId(resultat.getInt(1));
                sousdomaine.setDomaine(domainedao.findDomaineById(resultat.getInt(2)));
                sousdomaine.setLabel(resultat.getString(3));
                
                listsousdomaines.add(sousdomaine);
            }
            return listsousdomaines;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
    
    @Override
     public List<SousDomaine> DisplayAllSousDomaines() {
        IDomaineDAO ddao = DomaineDAO.getInstance();
        List<SousDomaine> listsousdomaine = new ArrayList<SousDomaine>();

        String requete = "select * from sous_domaine";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                SousDomaine sousdomaine = new SousDomaine();
                
                sousdomaine.setId(resultat.getInt(1));
                sousdomaine.setDomaine(ddao.findDomaineById(resultat.getInt(2)));
                sousdomaine.setLabel(resultat.getString(3));
              
              

                listsousdomaine.add(sousdomaine);
            }
            return listsousdomaine;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }
    
    private static ISousDomaineDAO idomainedao;

    public static ISousDomaineDAO getInstance() {
        if (idomainedao == null) {
            idomainedao = new SousDomaineDAO();
        }
        return idomainedao;
    }
    
}

