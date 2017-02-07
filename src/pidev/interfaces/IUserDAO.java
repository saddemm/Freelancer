/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.User;

/**
 *
 * @author SaddeM
 */
public interface IUserDAO {
    
    void insertUser(User user);
    void insertUser_inscri(User user);
    List<User> DisplayAllUsers();
    User FindUserById(int id);
    void deleteUser(int id);
    void updateUserProfile(User u);
     User findUserByLogin(String login);
     User findUserByEmail(String email);
    void updateUser(User u);
    void updateTokensUser(User source, User destination, int token );
    boolean comparebylogin(String login);
    boolean comparebyEmail(String email);
    
    
}
