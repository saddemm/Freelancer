/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.UserDAO;
import pidev.entities.User;
import pidev.interfaces.IUserDAO;

/**
 *
 * @author kais
 */
public class ListJobowner extends AbstractTableModel {
String [] header={"Id", "Nom","Prenom", "Login","Password","Date of birth","Activated","Last login","Tokens"};
    List<User> users = new ArrayList() ;
    
    
     public ListJobowner() {
        IUserDAO usrdao=UserDAO.getInstance();
        users=usrdao.DisplayAllUsers();
    
       
    }
    
     @Override
    public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public int getRowCount() {
        return(users.size());
        }

    @Override
    public int getColumnCount() {
return ( header.length);  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 
        switch(columnIndex){
            case 0: 
                return users.get(rowIndex).getId();
            case 1: 
                return users.get(rowIndex).getNom();
            case 2: 
                return users.get(rowIndex).getPrenom();
            case 3: 
                return users.get(rowIndex).getLogin();
            case 4:
                return users.get(rowIndex).getPassword();
            case 5:
                return users.get(rowIndex).getDate_naissance();
            case 6:
                if(users.get(rowIndex).getEstActive()==1)
                    return ("Yes");
                else
                    return("No");
            case 7:
                return users.get(rowIndex).getLastLoginDate();
            case 8:
                return users.get(rowIndex).getTokens();
            default:
                return null;
        }
 }
    
}
