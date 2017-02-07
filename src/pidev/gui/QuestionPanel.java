/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author SaddeM
 */
public class QuestionPanel  extends JPanel{
    public QuestionPanel(String ss){
    
        this.setLayout(null);
        
   
        JLabel question = new JLabel("Question");
        
        question.setBounds(10,10,20,200);
     
        
        this.add(question);
 
    }
}
