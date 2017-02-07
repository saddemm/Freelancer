/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Domaine;
import pidev.entities.Projet;
import pidev.entities.User;

/**
 *
 * @author SaddeM
 */
public interface IProjetDAO {
    void insertProjet(Projet p);

    void updateProjet(Projet p);

    void deleteProjet(int id);

    Projet findProjetById(int id);

    List<Projet> DisplayAllProjects();
    
    List<Projet> DisplayAllProjectsVisible();
    
    List<Projet> DisplayAllProjectsByIdUser(int id_user);
    
}
