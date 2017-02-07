/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Domaine;
import pidev.entities.Freelancer;
import pidev.entities.SousDomaine;

/**
 *
 * @author SaddeM
 */
public interface IFreelancerDAO {
    
   void insertFreelancer(Freelancer freelancer);
   Freelancer FindFreelancerById(int id);
   List<Freelancer> DisplayAllFreelancers();
   void insertFreeLancerFormulaire(Freelancer f);
   void updateFreelancer(Freelancer f);
   void insertDomaine_Freelancer(int id_freelancer, List<SousDomaine> soudomaines);
   boolean haveThisSousDomaine(int id_freelancer,int id_domaine);
   void deleteDomaine_Freelancer(int id_freelancer,Domaine d);
   List<Freelancer> DisplayAllFreelancersByCritere(String search);
   void updateFreelancerGrade(int id);
   
   
}
