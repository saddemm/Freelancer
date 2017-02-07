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
import pidev.entities.Projet;
import pidev.entities.User;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IProjetDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class ProjetDAO implements IProjetDAO{
    private Connection connection;
 
    
    private ProjetDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    
   @Override
   
         public void insertProjet (Projet p) {
        String requete = "insert into projet (nom,details,id_user,id_domaine,estVisible) values (?,?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getDetails());
            ps.setInt(3, p.getUser().getId());
            ps.setInt(4, p.getDomaine().getId());
            ps.setInt(5, p.getEstVisible());
             ps.executeUpdate();
         
             } 
        catch (SQLException ex) {
             Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
          ex.printStackTrace();
            }
    }
    
   
    @Override
        public void updateProjet(Projet p) {
        String requete = "update projet set nom=? , details=?, estVisible=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getDetails());
            ps.setInt(3,p.getEstVisible());
            ps.setInt(4,p.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
     public void deleteProjet(int id) {

        String requete = "delete from projet where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
     
     
      public Projet findProjetById(int id) {

        String requete = "select * from projet where id=?";
        IUserDAO udao = UserDAO.getInstance();
        IDomaineDAO ddao = DomaineDAO.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            
            
            Projet projet = new Projet();
            while (resultat.next()) {
                projet.setId(resultat.getInt(1));
                projet.setNom(resultat.getString(2));
                projet.setDetails(resultat.getString(3));
                projet.setUser(udao.FindUserById(resultat.getInt(4)));
                projet.setDomaine(ddao.findDomaineById(resultat.getInt(5))); 
                projet.setEstVisible(resultat.getInt(6));
            }
            return projet;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    }
      
      public List<Projet> DisplayAllProjects() {

        List<Projet> listeprojets = new ArrayList<Projet>();

        String requete = "select * from projet";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            IUserDAO udao = UserDAO.getInstance();
            IDomaineDAO ddao = DomaineDAO.getInstance();
            
    
            while (resultat.next()) {
                Projet projet = new Projet();
                projet.setId(resultat.getInt(1));
                projet.setNom(resultat.getString(2));
                projet.setDetails(resultat.getString(3));
                projet.setUser(udao.FindUserById(resultat.getInt(4)));
                projet.setDomaine(ddao.findDomaineById(resultat.getInt(5)));
                projet.setEstVisible(resultat.getInt(6));

                listeprojets.add(projet);
            }
            return listeprojets;
        } catch (SQLException ex) {
            //Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
      
      public List<Projet> DisplayAllProjectsVisible() {

        List<Projet> listeprojets = new ArrayList<Projet>();

        String requete = "select * from projet where estVisible=1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            IUserDAO udao = UserDAO.getInstance();
            IDomaineDAO ddao = DomaineDAO.getInstance();
            
    
            while (resultat.next()) {
                Projet projet = new Projet();
                projet.setId(resultat.getInt(1));
                projet.setNom(resultat.getString(2));
                projet.setDetails(resultat.getString(3));
                projet.setUser(udao.FindUserById(resultat.getInt(4)));
                projet.setDomaine(ddao.findDomaineById(resultat.getInt(5)));
                projet.setEstVisible(resultat.getInt(6));

                listeprojets.add(projet);
            }
            return listeprojets;
        } catch (SQLException ex) {
            //Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
      @Override
      public List<Projet> DisplayAllProjectsByIdUser(int id_user) {

        List<Projet> listeprojets = new ArrayList<Projet>();

        String requete = "select * from projet where id_user="+id_user;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            IUserDAO udao = UserDAO.getInstance();
            IDomaineDAO ddao = DomaineDAO.getInstance();
            
    
            while (resultat.next()) {
                Projet projet = new Projet();
                projet.setId(resultat.getInt(1));
                projet.setNom(resultat.getString(2));
                projet.setDetails(resultat.getString(3));
                projet.setUser(udao.FindUserById(resultat.getInt(4)));
                projet.setDomaine(ddao.findDomaineById(resultat.getInt(5)));
                projet.setEstVisible(resultat.getInt(6));

                listeprojets.add(projet);
            }
            return listeprojets;
        } catch (SQLException ex) {
            //Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }

     private static IProjetDAO iProjetDao;

    public static IProjetDAO getInstance() {
        if (iProjetDao == null) {
            iProjetDao = new ProjetDAO();
        }
        return iProjetDao;
    }

    
}
