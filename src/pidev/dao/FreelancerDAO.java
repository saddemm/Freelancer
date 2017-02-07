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
import pidev.entities.Evaluation;
import pidev.entities.Freelancer;
import pidev.entities.SousDomaine;
import pidev.entities.User;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IGradeDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class FreelancerDAO implements IFreelancerDAO {
    
    private Connection connection;
    
    
    public FreelancerDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void insertFreelancer(Freelancer freelancer) {
        String requete = "insert into user (login,email,password,nom,prenom,date_naissance,photo,estActive,lastLoginDate,tokens) values (?,?,?,?,?,?,?,?,NOW(),?)";
        int last_inserted_id=0;
        String requete2 = "select id from user";
        String requete3 = "insert into freelancer (id_user,cv,id_grade) values (?,?,1)";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setString(1, freelancer.getLogin());
            ps.setString(2, freelancer.getEmail());
            ps.setString(3, freelancer.getPassword());
            ps.setString(4, freelancer.getNom());
            ps.setString(5, freelancer.getPrenom());
             ps.setString(6, freelancer.getDate_naissance());
             ps.setString(7, freelancer.getPhoto());
             ps.setInt(8, freelancer.getEstActive());
             ps.setInt(9, freelancer.getTokens());
            
            ps.executeUpdate();
            
            //retour du dernier id insérer
            PreparedStatement ps2 = connection.prepareStatement(requete2);
              ResultSet rs = ps2.executeQuery();
                if(rs.last())
                {
                    last_inserted_id = rs.getInt(1);
                }
           
                // Ajout dans freelancer
               PreparedStatement ps3 = connection.prepareStatement(requete3);
            ps3.setInt(1, last_inserted_id);     
            ps3.setString(2, freelancer.getCv());    
            ps3.executeUpdate();
     
            
            
            for(SousDomaine sousdomaine : freelancer.getSousdomaines()){
                requete = "insert into domaine_freelancer values(?,?)";
                PreparedStatement pss = connection.prepareStatement(requete);
                pss.setInt(1, last_inserted_id);
                pss.setInt(2, sousdomaine.getId());
                pss.executeUpdate(); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @Override
    public Freelancer FindFreelancerById(int id) {

      
        String requete = "select u.*,f.* from user u,freelancer f where u.id=f.id_user and f.id_user=?";
        Freelancer freelancer = new Freelancer();
        IGradeDAO gdao = GradeDAO.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                
                freelancer.setId(resultat.getInt(1));
                freelancer.setLogin(resultat.getString(2));
                freelancer.setEmail(resultat.getString(3));
                freelancer.setPassword(resultat.getString(4));
                freelancer.setNom(resultat.getString(5));
                freelancer.setPrenom(resultat.getString(6));
                freelancer.setDate_naissance(resultat.getString(7));
                freelancer.setPhoto(resultat.getString(8));
                freelancer.setEstActive(resultat.getInt(9));
                freelancer.setLastLoginDate(resultat.getString(10));
                freelancer.setTokens(resultat.getInt(11));
               // freelancer.setCv(resultat.getString(12));
                freelancer.setGrade(gdao.findGradeById(resultat.getInt(12)));
                
            }
            return freelancer;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
    public void insertFreeLancerFormulaire(Freelancer f)
    {
             String requete = "insert into freelancer (id_user,cv) values (?,?)";
             try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, f.getId());
            ps.setString(2, f.getCv());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    @Override
    public List<Freelancer> DisplayAllFreelancers() {

        List<Freelancer> listefreelancers = new ArrayList<Freelancer>();
        
        String requete = "select u.*,f.* from user u,freelancer f where u.id=f.id_user";
        
        IGradeDAO gdao = GradeDAO.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
    
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                Freelancer freelancer = new Freelancer();
                freelancer.setId(resultat.getInt(1));
                freelancer.setLogin(resultat.getString(2));
                freelancer.setEmail(resultat.getString(3));
                freelancer.setPassword(resultat.getString(4));
                freelancer.setNom(resultat.getString(5));
                freelancer.setPrenom(resultat.getString(6));
                freelancer.setDate_naissance(resultat.getString(7));
                freelancer.setPhoto(resultat.getString(8));
                freelancer.setEstActive(resultat.getInt(9));
                freelancer.setLastLoginDate(resultat.getString(10));
                freelancer.setTokens(resultat.getInt(11));
                freelancer.setCv(resultat.getString(12));
                freelancer.setGrade(gdao.findGradeById(resultat.getInt(13)));
                
                listefreelancers.add(freelancer);
            }
            return listefreelancers;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
        @Override
        public List<Freelancer> DisplayAllFreelancersByCritere(String search) {

        List<Freelancer> listefreelancers = new ArrayList<Freelancer>();
        
        String requete = "select u.id,u.email,u.nom,u.prenom,u.date_naissance,f.id_grade from user u,freelancer f where u.id=f.id_user and u.nom like '"+search+"%"+"'";
        
        IGradeDAO gdao = GradeDAO.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
              
    
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                
                Freelancer freelancer = new Freelancer();
                freelancer.setId(resultat.getInt(1));
                freelancer.setEmail(resultat.getString(2));
                freelancer.setNom(resultat.getString(3));
                freelancer.setPrenom(resultat.getString(4));
                freelancer.setDate_naissance(resultat.getString(5));
                freelancer.setGrade(gdao.findGradeById(resultat.getInt(6)));
                
                listefreelancers.add(freelancer);
            }
            return listefreelancers;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public void updateFreelancer(Freelancer f) {
        String requete = "update user set login=? ,email=?,password=?,nom=?,prenom=?, date_naissance=?,photo=?,estActive=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, f.getLogin());
            ps.setString(2, f.getEmail());
            ps.setString(3, f.getPassword());
            ps.setString(4, f.getNom());
            ps.setString(5, f.getPrenom());
            ps.setString(6, f.getDate_naissance());
            ps.setString(7, f.getPhoto());
            ps.setInt(8, f.getEstActive());
            ps.setInt(9, f.getId());
            ps.executeUpdate();
  
             String requete2 = "update freelancer set cv=?,id_grade=? where id=?";
             PreparedStatement ps2 = connection.prepareStatement(requete2);
       
                
                ps2.setString(1, f.getCv());
                ps2.setInt(2, f.getGrade().getId());
                ps2.setInt(3, f.getId());
            
        } catch (SQLException ex) {
            //Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    @Override
    public void updateFreelancerGrade(int id) {
        String requete = "update freelancer set id_grade = id_grade+1 where id_user=? and id_grade < (select count(id) from grade)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
    
            ps.executeUpdate();
  
            
        } catch (SQLException ex) {
            //Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
       @Override
       public void insertDomaine_Freelancer(int id_freelancer, List<SousDomaine> soudomaines)
        {
            String requete2 = "DELETE FROM domaine_freelancer where id_freelancer=? AND id_sous_domaine IN(select id from sous_domaine where id_domaine=?)";
           int id_domaine= soudomaines.get(0).getDomaine().getId();
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete2);
            
           
            ps.setInt(1, id_freelancer);
            ps.setInt(2, id_domaine);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        String requete = "insert into domaine_freelancer values(?,?)";
        try {
        for(SousDomaine sousdomaine : soudomaines){
                
                PreparedStatement pss = connection.prepareStatement(requete);
                pss.setInt(1, id_freelancer);
                pss.setInt(2, sousdomaine.getId());
                pss.executeUpdate(); 
            }
        
     
            
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       @Override
       public void deleteDomaine_Freelancer(int id_freelancer,Domaine d)
        {
            String requete2 = "DELETE FROM domaine_freelancer where id_freelancer=? AND id_sous_domaine IN(select id from sous_domaine where id_domaine=?)";
           int id_domaine= d.getId();
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete2);
            
           
            ps.setInt(1, id_freelancer);
            ps.setInt(2, id_domaine);
            
            ps.executeUpdate();
            
 
        } 
        catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
       
       public boolean haveThisSousDomaine(int id_freelancer,int id_domaine) {

    
        String requete = "select * from domaine_freelancer where id_freelancer=? AND id_sous_domaine=?";
   
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
             ps.setInt(1, id_freelancer);
             ps.setInt(2, id_domaine);
            ResultSet resultat = ps.executeQuery();
            
            if (resultat.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return false;
        }
    }
    
    
    
    private static IFreelancerDAO ifreelancerdao;

    public static IFreelancerDAO getInstance() {
        if (ifreelancerdao == null) {
            ifreelancerdao = new FreelancerDAO();
        }
        return ifreelancerdao;
    }
    
}
