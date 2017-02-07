/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.TestDAO;
import pidev.entities.Test;
import pidev.interfaces.ITestDAO;
import pidev.gui.FrameTest;

/**
 *
 * @author kais
 */
public class ListTests extends AbstractTableModel {
String [] header ={"Domaine","Candidat","note","Date Du test"};
    List<Test> tests = new ArrayList() ;
    
    
     public ListTests() {
        ITestDAO tstdao=TestDAO.getInstance();
       
       tests=tstdao.DisplayAllTests();
       
    
       
    }
    
     @Override
    public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public int getRowCount() {
        return(tests.size());
        }

    @Override
    public int getColumnCount() {
return ( header.length);  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 
        switch(columnIndex){
            case 0: 
                return tests.get(rowIndex).getDomaine().getLabel();
            case 1: 
                return (tests.get(rowIndex).getFreelancer().getPrenom()+" "+tests.get(rowIndex).getFreelancer().getNom());
            case 2: 
                return tests.get(rowIndex).getNote();
            case 3: 
                return tests.get(rowIndex).getDateTest();
            
            default:
                return null;
        }
 }
} 
