/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.ProjetDAO;
import pidev.entities.Projet;
import pidev.interfaces.IProjetDAO;

/**
 *
 * @author kais
 */
public class ListProjets extends AbstractTableModel {
String [] header={"Id", "Title","Details", "Propriétaire","Domaine","Visibilité"};
    List<Projet> projects = new ArrayList() ;
    
    
     public ListProjets() {
        IProjetDAO prjtdao=ProjetDAO.getInstance();
        projects=prjtdao.DisplayAllProjects();
    
       
    }
    
     @Override
    public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public int getRowCount() {
        return(projects.size());
        }

    @Override
    public int getColumnCount() {
return ( header.length);  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 
        switch(columnIndex){
            case 0: 
                return projects.get(rowIndex).getId();
            case 1: 
                return projects.get(rowIndex).getNom();
            case 2: 
                return projects.get(rowIndex).getDetails();
            case 3: 
                return (projects.get(rowIndex).getUser().getNom()+" "+projects.get(rowIndex).getUser().getPrenom());
            case 4:
                return(projects.get(rowIndex).getDomaine().getLabel());
            case 5:
                if((projects.get(rowIndex).getEstVisible())==1)
                    return ("Yes");
                else
                    return("No");
            default:
                return null;
        }
 }
    
}
