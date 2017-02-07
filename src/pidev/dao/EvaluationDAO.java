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
import pidev.entities.Commentaire;
import pidev.entities.Evaluation;
import pidev.interfaces.IEvaluationDAO;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IProjetDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class EvaluationDAO implements IEvaluationDAO{
    
      
    private Connection connection;
    
    
    public EvaluationDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void insertEvaluation(Evaluation evaluation) {
        String requete = "insert into evaluation (contenu,nb_etoiles,id_evaluant,id_evalue,dateEvaluation) values (?,?,?,?,NOW())";

        try {
            
            //Ajout user
            PreparedStatement ps = connection.prepareStatement(requete);
            
           
            ps.setString(1, evaluation.getContenu());
            ps.setInt(2, evaluation.getNb_etoiles());
            ps.setInt(3, evaluation.getEvaluant().getId());
            ps.setInt(4, evaluation.getEvaluer().getId()); 
            ps.executeUpdate();
            
          
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Evaluation FindEvaluationById(int id) {

      
        String requete = "select * from evaluation where id=?";
        Evaluation evaluation = new Evaluation();
       
       
        IUserDAO udao = UserDAO.getInstance();
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
         //   ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            
            if (resultat.next()) {
                
                evaluation.setId(resultat.getInt(1));
                evaluation.setContenu(resultat.getString(2));
                evaluation.setNb_etoiles(resultat.getInt(3));
                evaluation.setEvaluant(udao.FindUserById(resultat.getInt(4)));
                evaluation.setEvaluer(udao.FindUserById(resultat.getInt(5)));
                evaluation.setDateEvaluation(resultat.getString(6));
               
 
                
            }
            return evaluation;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des users " + ex.getMessage());
            return null;
        }
    }
    
    public List<Evaluation> DisplayAllEvaluation() {

        List<Evaluation> listeeval = new ArrayList<Evaluation>();

        String requete = "select * from evaluation";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IEvaluationDAO edao = EvaluationDAO.getInstance();
            
            IUserDAO udao = UserDAO.getInstance();
            while (resultat.next()) {
                Evaluation e = new Evaluation();
                e.setId(resultat.getInt(1));
                e.setContenu(resultat.getString(2));
                e.setNb_etoiles(resultat.getInt(3));
                e.setEvaluant(udao.FindUserById(resultat.getInt(4)));
                e.setEvaluer(udao.FindUserById(resultat.getInt(5)));
                e.setDateEvaluation(resultat.getString(6));
                

                listeeval.add(e);
            }
            return listeeval;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Evaluations " + ex.getMessage());
            return null;
        }
    }
   
   
    
    private static IEvaluationDAO ievaluationdao;

    public static IEvaluationDAO getInstance() {
        if (ievaluationdao == null) {
            ievaluationdao = new EvaluationDAO();
        }
        return ievaluationdao;
    }
    
    
}
