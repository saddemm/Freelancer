/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pidev.modeles;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import pidev.dao.MessageDAO;
import pidev.entities.Message;
import pidev.interfaces.IMessageDAO;

/**
 *
 * @author User
 */
public class ModeleMessageSent extends AbstractTableModel{
    
 String[] col_names ={"Message","From","To","Date","id"};
    List<Message> v_personnes = new ArrayList();

    public ModeleMessageSent() {
        
        IMessageDAO stkdao = MessageDAO.getInstance();
        
        v_personnes=stkdao.FindMessageByIdEmetteur(3);
     
    }
     
    

    @Override
    public int getRowCount() {
        
       return v_personnes.size();
        
        

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
                return v_personnes.get(rowIndex).getMessage();
            
            case 1 :
                return v_personnes.get(rowIndex).getEmetteur().getEmail();
            case 2 :
                return v_personnes.get(rowIndex).getDestinataire().getEmail();
            case 3 :
                return v_personnes.get(rowIndex).getDateEnvoie();
            case 4 :
                return v_personnes.get(rowIndex).getId();
            default :
                return null;
           
        
        
                           }
    }
    
}
