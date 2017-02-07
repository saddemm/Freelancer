/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import pidev.dao.QuestionDAO;
import pidev.entities.Question;
import pidev.interfaces.IQuestionDAO;

/**
 *
 * @author kais
 */
public class ListQuestions extends AbstractTableModel {
String [] header={"Id", "Domaine", "Enoncé"};
    List<Question> questions = new ArrayList() ;
    
    
     public ListQuestions() {
        IQuestionDAO qstdao=QuestionDAO.getInstance();
       questions= qstdao.DisplayAllQuestions();
       
       
    
       
    }
    
     @Override
    public String getColumnName(int column) {
        return header[column];
    }
    @Override
    public int getRowCount() {
        return(questions.size());
        }

    @Override
    public int getColumnCount() {
return ( header.length);  
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 
        switch(columnIndex){
            case 0: 
                return questions.get(rowIndex).getId();
            case 1: 
                return questions.get(rowIndex).getDomaine().getLabel();
            case 2: 
                return questions.get(rowIndex).getLabel();
            
            default:
                return null;
        }
     }
    @Override
    public void setValueAt(Object obj, int rowIndex, int columnIndex){
        obj.toString();
        fireTableCellUpdated(rowIndex,columnIndex);
    }
    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex){
        if (columnIndex!=2){
            return(false);
    }
        else return(true);
    }

    private static class Objet {

        public Objet() {
        }
    }
}