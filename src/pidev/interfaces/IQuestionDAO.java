/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Question;

/**
 *
 * @author SaddeM
 */
public interface IQuestionDAO {
    void insertQuestion(Question question);
     void deleteQuestion(int id);
     Question findQuestionById(int id);
     List<Question> DisplayAllQuestions();
     List<Question> DisplayAllQuestionsRepsByIdDomaine(int $id);
}
