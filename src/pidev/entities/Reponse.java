/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

/**
 *
 * @author SaddeM
 */
public class Reponse {
    
    private int id;
    private Question question;
    private String label;
    private int estCorrect;

    public Reponse() {
    }

    public Reponse(int id, Question question, String label, int estCorrect) {
        this.id = id;
        this.question = question;
        this.label = label;
        this.estCorrect = estCorrect;
    }

    public Reponse(Question question, String label, int estCorrect) {
        this.question = question;
        this.label = label;
        this.estCorrect = estCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getEstCorrect() {
        return estCorrect;
    }

    public void setEstCorrect(int estCorrect) {
        this.estCorrect = estCorrect;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", question=" + question + ", label=" + label + ", estCorrect=" + estCorrect + '}';
    }

   
    
}
