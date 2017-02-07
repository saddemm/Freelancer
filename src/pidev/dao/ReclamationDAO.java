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
import pidev.entities.Reclamation;
import pidev.entities.User;
import pidev.interfaces.IReclamationDAO;
import pidev.interfaces.IUserDAO;
import pidev.technique.DataSource;

/**
 *
 * @author SaddeM
 */
public class ReclamationDAO implements IReclamationDAO{
   
    private Connection connection;
    private Object ps;
    private Object ProjettDAO;
    private Object reclamation;
    
    private ReclamationDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void envoyerReclamation(Reclamation reclamation) {
        String requete = "insert into reclamation (id_user,message,estLu,dateReclamation) values (?,?,?,NOW())";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
             ps.setInt(1, reclamation.getUser().getId());
            ps.setString(2, reclamation.getMessage());
            ps.setInt(3, reclamation.getEstLu());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteReclamation(int id) {
        
        String requete = "delete from reclamation where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(ReclamationtDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }
   
    @Override
    public Reclamation findReclamationById(int id) {
        String requete = "select * from reclamation where id=?";
                 IUserDAO udao = UserDAO.getInstance();

        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            IReclamationDAO reclamationDao = ReclamationDAO.getInstance();
            Reclamation reclamation = new Reclamation();
            while (resultat.next()) {
                reclamation.setId(resultat.getInt(1));
                reclamation.setUser(udao.FindUserById(resultat.getInt(2)));
                reclamation.setMessage(resultat.getString(3));
                reclamation.setEstLu(resultat.getInt(4));
            }
            return reclamation;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement" + ex.getMessage());
            return null;
        }
    
    }

    @Override
    public List<Reclamation> DisplayAllReclamations() {
        List<Reclamation> listereclamation = new ArrayList<Reclamation>();

        String requete = "select * from reclamation";
        
         IUserDAO udao = UserDAO.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            IReclamationDAO reclamationDao = ReclamationDAO.getInstance();
            while (resultat.next()) {
                Reclamation reclamation = new Reclamation();
                reclamation.setId(resultat.getInt(1));
                reclamation.setUser(udao.FindUserById(resultat.getInt(2)));
                reclamation.setMessage(resultat.getString(3));
                reclamation.setDateReclamation(resultat.getString(4));
                reclamation.setEstLu(resultat.getInt(5));

                listereclamation .add(reclamation);
            }
            return listereclamation ;
        } catch (SQLException ex) {
            //Logger.getLogger(ProjetDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }
    
    
     private static IReclamationDAO iReclamationDao;

    public static IReclamationDAO getInstance() {
        if (iReclamationDao == null) {
            iReclamationDao = new ReclamationDAO();
        }
        return iReclamationDao;
    }

    
}