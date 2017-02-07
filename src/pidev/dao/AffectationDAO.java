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
import pidev.entities.Domaine;
import pidev.entities.Projet;
import pidev.interfaces.IAffectationDAO;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IProjetDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class AffectationDAO implements IAffectationDAO {
    
    private Connection connection;
    
    private AffectationDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void AffecterFreelancer(Affectation a) {
        
        String requete = "insert into affectation (id_projet,id_freelancer,etat,estLu,dateDemande) values (?,?,?,?,NOW())";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, a.getProjet().getId());
             ps.setInt(2, a.getFreelancer().getId());
              ps.setInt(3, a.getEtat());
               ps.setInt(4, a.getEstLu());
      
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
       @Override
        public void updateAcceptAffectation(int id_affectation, int type) {
        String requete = "update affectation set etat=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, type);
            ps.setInt(2, id_affectation);
       
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    @Override
    public void deleteAffectation(int id) {
        
        String requete = "DELETE FROM affectation where id=?";
       
        
        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setInt(1, id);
            
            ps.executeUpdate();
            System.out.println("Affectation supprimer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Affectation findAffectationById(int id) {
        Affectation a = new Affectation();
        IProjetDAO pdao = ProjetDAO.getInstance();
        IFreelancerDAO fdao = FreelancerDAO.getInstance();
        
        String requete = "select * from domaine where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                a.setId(resultat.getInt(1));
                a.setProjet(pdao.findProjetById(resultat.getInt(2)));
                a.setFreelancer(fdao.FindFreelancerById(resultat.getInt(3)));
                a.setEtat(resultat.getInt(4));
                a.setEstLu(resultat.getInt(5));
                a.setDateDemande(resultat.getString(6));
            }
            return a;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du domaine " + ex.getMessage());
            return null;
        }
    }
    
    public List<Affectation> DisplayAllAffectation() {

        List<Affectation> listeaf = new ArrayList<Affectation>();

        String requete = "select * from affectation";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IAffectationDAO afdao = AffectationDAO.getInstance();
            IProjetDAO pdao = ProjetDAO.getInstance();
            IFreelancerDAO fdao = FreelancerDAO.getInstance();
            
            while (resultat.next()) {
                Affectation af = new Affectation();
                af.setId(resultat.getInt(1));
                af.setProjet(pdao.findProjetById(resultat.getInt(2)));
                af.setFreelancer(fdao.FindFreelancerById(resultat.getInt(3)));
                af.setEtat(resultat.getInt(4));
                af.setDateDemande(resultat.getString(5));

                listeaf.add(af);
            }
            return listeaf;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Affectations " + ex.getMessage());
            return null;
        }
    }
    @Override
    public List<Affectation> DisplayAllAffectationByIdFreelancer(int id) {

        List<Affectation> listeaf = new ArrayList<Affectation>();

        String requete = "select * from affectation where id_freelancer="+id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IAffectationDAO afdao = AffectationDAO.getInstance();
            IProjetDAO pdao = ProjetDAO.getInstance();
            IFreelancerDAO fdao = FreelancerDAO.getInstance();
            
            while (resultat.next()) {
                Affectation af = new Affectation();
                af.setId(resultat.getInt(1));
                af.setProjet(pdao.findProjetById(resultat.getInt(2)));
                af.setFreelancer(fdao.FindFreelancerById(resultat.getInt(3)));
                af.setEtat(resultat.getInt(4));
                af.setEstLu(resultat.getInt(5));
                af.setDateDemande(resultat.getString(6));

                listeaf.add(af);
            }
            return listeaf;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Affectations " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Affectation> DisplayAllAffectationByIdUser(int id) {

        List<Affectation> listeaf = new ArrayList<Affectation>();

        String requete = "select a.id,a.id_projet,a.id_freelancer,a.etat,a.estLu,a.dateDemande from affectation a, projet p, user u  where a.id_projet=p.id AND p.id_user=u.id AND u.id="+id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IAffectationDAO afdao = AffectationDAO.getInstance();
            IProjetDAO pdao = ProjetDAO.getInstance();
            IFreelancerDAO fdao = FreelancerDAO.getInstance();
            
            while (resultat.next()) {
                Affectation af = new Affectation();
                af.setId(resultat.getInt(1));
                af.setProjet(pdao.findProjetById(resultat.getInt(2)));
                af.setFreelancer(fdao.FindFreelancerById(resultat.getInt(3)));
                af.setEtat(resultat.getInt(4));
                af.setEstLu(resultat.getInt(5));
                af.setDateDemande(resultat.getString(6));

                listeaf.add(af);
            }
            return listeaf;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Affectations " + ex.getMessage());
            return null;
        }
    }
    
    
    
    private static IAffectationDAO iaffectationdao;

    public static IAffectationDAO getInstance() {
        if (iaffectationdao == null) {
            iaffectationdao = new AffectationDAO();
        }
        return iaffectationdao;
    }
    
}
