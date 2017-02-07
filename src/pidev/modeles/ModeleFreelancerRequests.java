/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.modeles;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.AffectationDAO;
import pidev.dao.MessageDAO;
import pidev.dao.ProjetDAO;
import pidev.entities.Affectation;
import pidev.entities.Domaine;
import pidev.entities.Message;
import pidev.entities.Projet;
import pidev.interfaces.IAffectationDAO;
import pidev.interfaces.IMessageDAO;
import pidev.interfaces.IProjetDAO;

/**
 *
 * @author SaddeM
 */
public class ModeleFreelancerRequests extends AbstractTableModel{
    
 String[] col_names ={"Nom","Domaine","Job Owner","Etat","Date Demande",""};
    List<Affectation> v_affectation = new ArrayList();

    public ModeleFreelancerRequests(int id_user) {
        
        IAffectationDAO adao = AffectationDAO.getInstance();
        //XX113XX id_freelancer 1
        v_affectation=adao.DisplayAllAffectationByIdUser(id_user);
     
    }
     
    

    @Override
    public int getRowCount() {
        
       return v_affectation.size();
        
        

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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        Domaine d = new Domaine();
        d= (Domaine) aValue;
        
       switch(columnIndex){
            case 3:
                v_affectation.get(rowIndex).setEtat((int) d.getId());         
         
     
       }
       this.fireTableRowsUpdated(rowIndex, rowIndex);
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            
            case 0 :
                return v_affectation.get(rowIndex).getProjet().getNom();
            case 1 :
                return v_affectation.get(rowIndex).getProjet().getDomaine().getLabel();
            
            case 2 :
                return v_affectation.get(rowIndex).getProjet().getUser().getNom();
            case 3 :
                if (v_affectation.get(rowIndex).getEtat()==0)
                return "On hold";
                else if (v_affectation.get(rowIndex).getEtat()==1)
                return "Accepted";
                else if (v_affectation.get(rowIndex).getEtat()==2)
                return "Rejected";
            case 4 :
                return v_affectation.get(rowIndex).getDateDemande();
            case 5 :
                return v_affectation.get(rowIndex);
            default :
                return null;
           
        
        
                           }
    }
    
}

