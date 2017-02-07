/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Grade;

/**
 *
 * @author SaddeM
 */
public interface IGradeDAO {
    
    void insertGrade(Grade grade) ;
    void deleteGrade(int id);
    Grade findGradeById(int id);
    List<Grade> DisplayAllGrade();
}
