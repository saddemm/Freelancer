/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.modeles;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.MessageDAO;
import pidev.dao.ProjetDAO;
import pidev.entities.Message;
import pidev.entities.Projet;
import pidev.interfaces.IMessageDAO;
import pidev.interfaces.IProjetDAO;

/**
 *
 * @author SaddeM
 */
public class ModeleManageProjets extends AbstractTableModel{
    
 String[] col_names ={"Nom","Domaine","Etat",""};
    List<Projet> v_projets = new ArrayList();

    public ModeleManageProjets(int id_user) {
        
        IProjetDAO pdao = ProjetDAO.getInstance();
        
        v_projets=pdao.DisplayAllProjectsByIdUser(id_user);
     
    }
     
    

    @Override
    public int getRowCount() {
        
       return v_projets.size();
        
        

    }

    @Override
    public int getColumnCount() {
        
        return col_names.length;

    }

    @Override
    public String getColumnName(int column) {
        
        return col_names[column];

    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            
            case 0 :
                return v_projets.get(rowIndex).getNom();
            
            case 1 :
                return v_projets.get(rowIndex).getDomaine().getLabel();
            case 2 :
                if (v_projets.get(rowIndex).getEstVisible()==0)
                return "On hold";
                else if (v_projets.get(rowIndex).getEstVisible()==1)
                return "Accepted";
                else if (v_projets.get(rowIndex).getEstVisible()==2)
                return "Rejected";
            case 3 :
                return v_projets.get(rowIndex);
            default :
                return null;
           
        
        
                           }
    }
    
}

