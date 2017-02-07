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
import pidev.entities.Freelancer;
import pidev.entities.User;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class UserDAO implements IUserDAO {
    Connection connection;
    
        public UserDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    
    @Override
    public void insertUser(User user) {
        String requete = "insert into user (login,email,password,nom,prenom,date_naissance,photo,estActive,lastLoginDate,tokens) values (?,?,?,?,?,?,?,?,NOW(),?)";

       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getNom());
            ps.setString(5, user.getPrenom());
            ps.setString(6, user.getDate_naissance());
            ps.setString(7, user.getPhoto());
            ps.setInt(8, user.getEstActive());
            ps.setInt(9, user.getTokens());            
            ps.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override 
     public void updateUserProfile(User u) {
        String requete = "update user set prenom=?,nom=?,email=?,date_naissance=?,password=?  where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, u.getPrenom());
            ps.setString(2, u.getNom());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getDate_naissance());
            ps.setString(5, u.getPassword());
            ps.setInt(6,u.getId());
           
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour juju " + ex.getMessage());
        }
    }
     @Override
     public void updateTokensUser(User source, User destination, int token ){
         String requete1="update user set tokens=tokens - '"+token+"' where id=?";
         String requete2="update user set tokens=tokens + '"+token+"' where id=?";
         
         try {
         PreparedStatement ps1 = connection.prepareStatement(requete1);
         PreparedStatement ps2 = connection.prepareStatement(requete2);
        // ps1.setInt(1, token);
         ps1.setInt(1, source.getId());
         ps2.setInt(1, destination.getId());
         ps1.executeUpdate();
         ps2.executeUpdate();
         System.out.println("Mise à jour effectuée avec succès");
         }
         catch(SQLException ex){
              System.out.println("erreur lors de la mise à jour tokens " + ex.getMessage());
         }
     
     }
    
    
    public void insertUser_inscri(User user) {
        String requete = "insert into user (login,email,password,nom,prenom,date_naissance,estActive,tokens) values (?,?,?,?,?,?,?,?)";
  try {
         //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getNom());
            ps.setString(5, user.getPrenom());
            ps.setString(6, user.getDate_naissance());
            ps.setInt(7, user.getEstActive());
            ps.setInt(8, user.getTokens());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
      public List<User> DisplayAllUsers() {

        List<User> listeusers = new ArrayList<User>();

        String requete = "select * from user";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                User user = new User();
                user.setId(resultat.getInt(1));
                user.setLogin(resultat.getString(2));
                user.setEmail(resultat.getString(3));
                user.setPassword(resultat.getString(4));
                user.setNom(resultat.getString(5));
                user.setPrenom(resultat.getString(6));
                user.setDate_naissance(resultat.getString(7));
                user.setPhoto(resultat.getString(8));
                user.setEstActive(resultat.getInt(9));
                user.setLastLoginDate(resultat.getString(10));
                user.setTokens(resultat.getInt(11));
                listeusers.add(user);
            }
            return listeusers;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
      
    @Override
      public User FindUserById(int id) {

      
        String requete = "select * from user where id=? ";
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
           
            while (resultat.next()) {
                
                user.setId(resultat.getInt(1));
                user.setLogin(resultat.getString(2));
                user.setEmail(resultat.getString(3));
                user.setPassword(resultat.getString(4));
                user.setNom(resultat.getString(5));
                user.setPrenom(resultat.getString(6));
                user.setDate_naissance(resultat.getString(7));
                user.setPhoto(resultat.getString(8));
                user.setEstActive(resultat.getInt(9));
                user.setLastLoginDate(resultat.getString(10));
                user.setTokens(resultat.getInt(11));
                
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
    @Override
      public void deleteUser(int id) {
        
        String requete = "DELETE FROM user where id=?";
       
        
        try {
            
            
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, id);
            
            ps.executeUpdate();
            System.out.println("User supprimer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
      @Override
    public User findUserByEmail(String email) {
         User u = new User();
        String requete = "select email,password,nom,prenom,id from user where email=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
               u.setEmail(resultat.getString(1));
               u.setPassword(resultat.getString(2));
               u.setNom(resultat.getString(3));
               u.setPrenom(resultat.getString(4));
               u.setId(resultat.getInt(5));
            }
            return u;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
           return null;
        }
  }

    @Override
   public User findUserByLogin(String login) {
         User u = new User();
        String requete = "select id from user where login=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
//               u.setLogin(resultat.getString(1));
//               u.setPassword(resultat.getString(2));
//               u.setNom(resultat.getString(3));
//               u.setPrenom(resultat.getString(4));
               u.setId(resultat.getInt(1));
            }
            return u;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
           return null;
        }
  }

    @Override
    public boolean comparebylogin(String login) {
    
    IUserDAO udao = this.getInstance();
    //listLogin = udao.DisplayAllUsers();
   
        for(User u : udao.DisplayAllUsers())
        {
            if(u.getLogin().equals(login))
                return true;
        }
    return false;
    }
      
      @Override
    public void updateUser(User u) {
        String requete = "update user set login=? ,email=?,password=?,nom=?,prenom=?, date_naissance=?,photo=?,estActive=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getNom());
            ps.setString(5, u.getPrenom());
            ps.setString(6, u.getDate_naissance());
            ps.setString(7, u.getPhoto());
            ps.setInt(8, u.getEstActive());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    
    
    @Override
    public boolean comparebyEmail(String email) {

    IUserDAO udao = this.getInstance();
   
        for(User u : udao.DisplayAllUsers())
        {
            if(u.getEmail().equals(email))
                return true;
        }
    return false;
    }
      
      private static IUserDAO iuserdao;

    public static IUserDAO getInstance() {
        if (iuserdao == null) {
            iuserdao = new UserDAO();
        }
        return iuserdao;
    }
    
}
