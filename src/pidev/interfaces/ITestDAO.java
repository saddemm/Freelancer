/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Test;

/**
 *
 * @author SaddeM
 */
public interface ITestDAO {
    
void insertTest(Test test);        
void deleteTest(int id);
Test findTestById(int id);
Test findTestByFreelancer(int id); 
 Test findTestByDomaine(int id);
 List<Test> DisplayAllTests();
 
}
