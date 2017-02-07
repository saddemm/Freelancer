/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Affectation;
import pidev.entities.Domaine;

/**
 *
 * @author SaddeM
 */
public interface IAffectationDAO {
    void AffecterFreelancer(Affectation a);
    void deleteAffectation(int id);
    Affectation findAffectationById(int id);
    List<Affectation> DisplayAllAffectation();
    List<Affectation> DisplayAllAffectationByIdFreelancer(int id);
    List<Affectation> DisplayAllAffectationByIdUser(int id);
    void updateAcceptAffectation(int id_affectation, int type);
}
