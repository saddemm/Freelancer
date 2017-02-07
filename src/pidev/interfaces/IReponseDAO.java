/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Reponse;

/**
 *
 * @author SaddeM
 */
public interface IReponseDAO {
    
    List<Reponse> DisplayAllReponses();
    Reponse findReponseById(int id);
    void deleteReponse(int id);
    void insertReponse(Reponse reponse);
    List<Reponse> DisplayAllReponsesByIdQuestion(int id);
    
}
