/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Reclamation;
import pidev.entities.User;

/**
 *
 * @author SaddeM
 */
public interface IReclamationDAO {
    void envoyerReclamation(Reclamation reclamation);
    void deleteReclamation(int id);
    Reclamation findReclamationById(int id);
    List<Reclamation> DisplayAllReclamations() ;
    
    
}
