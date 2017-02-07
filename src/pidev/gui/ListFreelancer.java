/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.FreelancerDAO;
import pidev.dao.UserDAO;
import pidev.entities.Freelancer;
import pidev.entities.User;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IUserDAO;

/**
 *
 * @author kais
 */
public class ListFreelancer extends AbstractTableModel {
String [] header={"Id", "Nom","Prenom", "Login","Password","Date of birth","Activated","Last login","Tokens","Grade"};
    List<Freelancer> flancers = new ArrayList() ;
    
    
     public ListFreelancer() {
        
        IFreelancerDAO flancer =  FreelancerDAO.getInstance();
        flancers = flancer.DisplayAllFreelancers();
       
       
       
    }
    
     @Override
    public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public int getRowCount() {
        return(flancers.size());
        }

    @Override
    public int getColumnCount() {
return ( header.length);  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 
        switch(columnIndex){
            case 0: 
                return flancers.get(rowIndex).getId();
            case 1: 
                return flancers.get(rowIndex).getNom();
            case 2: 
                return flancers.get(rowIndex).getPrenom();
            case 3: 
                return flancers.get(rowIndex).getLogin();
            case 4:
                return flancers.get(rowIndex).getPassword();
            case 5:
                return flancers.get(rowIndex).getDate_naissance();
            case 6:
                if(flancers.get(rowIndex).getEstActive()==1)
                    return ("Yes");
                else
                    return("No");
            case 7:
                return flancers.get(rowIndex).getLastLoginDate();
            case 8:
                return flancers.get(rowIndex).getTokens();
            case 9:
                return (flancers.get(rowIndex).getGrade().getLabel());
            default:
                return null;
        }
 }    
}
