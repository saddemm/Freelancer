/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Commentaire;

/**
 *
 * @author SaddeM
 */
public interface ICommentaireDAO {
    
    void insertCommentaire(Commentaire commentaire);
    Commentaire FindCommentaireById(int id);
    List<Commentaire> DisplayAllCommentaires();
    void updateCommentaire(Commentaire c);
    List<Commentaire> FindCommentaireByIdProjet(int id);
    
    
}
