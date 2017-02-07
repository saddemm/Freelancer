/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Domaine;
import pidev.entities.SousDomaine;

/**
 *
 * @author SaddeM
 */
public interface ISousDomaineDAO {
    public void insertSousDomaine(SousDomaine Sousdomaine);
    void deleteSousDomaine(int id);
    SousDomaine findSousDomaineById(int id);
    List<SousDomaine> DisplayAllSousDomaines();
    List<SousDomaine> findSousDomaineByIdDom(int id);
    List<SousDomaine> findSousDomaineByIdFreelancer(int id);
}
