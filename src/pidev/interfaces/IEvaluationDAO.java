/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Evaluation;

/**
 *
 * @author SaddeM
 */
public interface IEvaluationDAO {
    void insertEvaluation(Evaluation evaluation);
    Evaluation FindEvaluationById(int id);
    List<Evaluation> DisplayAllEvaluation();
    
}
