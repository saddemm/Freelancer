/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Domaine;

/**
 *
 * @author SaddeM
 */
public interface IDomaineDAO {
    
    void insertDomaine(Domaine domaine);
    void deleteDomaine(int id);
    public Domaine findDomaineById(int aInt);
    List<Domaine> DisplayAllDomaines();
    
}
