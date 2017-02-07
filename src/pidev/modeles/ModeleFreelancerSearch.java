/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.modeles;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.FreelancerDAO;
import pidev.entities.Freelancer;
import pidev.interfaces.IFreelancerDAO;

/**
 *
 * @author SaddeM
 */
public class ModeleFreelancerSearch extends AbstractTableModel{

 
    String[] col_names = {"email","nom","prenom","datenaissance","Grade",""};
    List<Freelancer> personnes;
    IFreelancerDAO fdao = FreelancerDAO.getInstance();
    public ModeleFreelancerSearch(String search){
        personnes = new ArrayList(fdao.DisplayAllFreelancersByCritere(search));
    }
    
    
    
    @Override
    public int getRowCount() {
       return personnes.size();
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
                return personnes.get(rowIndex).getEmail();
            case 1 :
                return personnes.get(rowIndex).getNom();
            case 2 :
                return personnes.get(rowIndex).getPrenom();
            case 3 :
                return personnes.get(rowIndex).getDate_naissance();
            case 4 :
                return personnes.get(rowIndex).getGrade().getLabel();
            case 5 :
                return personnes.get(rowIndex);
                
            default:
                return null;
          
             
    }
        
       }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       switch(columnIndex){
            case 0:
                personnes.get(rowIndex).setId((int) aValue);         
            case 1 :
                personnes.get(rowIndex).setLogin((String) aValue);
     
       }
       this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    
    
}
