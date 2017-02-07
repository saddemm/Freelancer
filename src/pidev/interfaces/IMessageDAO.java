/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.interfaces;

import java.util.List;
import pidev.entities.Message;

/**
 *
 * @author SaddeM
 */
public interface IMessageDAO {
    
      List<Message> FindMessageByIdDestinateire(int id);
      List<Message> FindMessageByIdEmetteur(int id);
      void envoyerMessage(Message message);
      Message FindMessageById(int id);
      void deleteMessage(int id);
      public List<Message> DisplayAllMessages();
    
}
