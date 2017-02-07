/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import pidev.dao.AffectationDAO;
import pidev.dao.CommentaireDAO;
import pidev.dao.DomaineDAO;
import pidev.dao.EvaluationDAO;
import pidev.dao.FreelancerDAO;
import pidev.dao.GradeDAO;
import pidev.dao.MessageDAO;
import pidev.dao.ProjetDAO;
import pidev.dao.QuestionDAO;
import pidev.dao.ReclamationDAO;
import pidev.dao.ReponseDAO;
import pidev.dao.SousDomaineDAO;
import pidev.dao.TestDAO;
import pidev.dao.UserDAO;
import pidev.entities.Affectation;
import pidev.entities.Commentaire;
import pidev.entities.Domaine;
import pidev.entities.Evaluation;
import pidev.entities.Freelancer;
import pidev.entities.Grade;
import pidev.entities.Message;
import pidev.entities.Projet;
import pidev.entities.Question;
import pidev.entities.Reclamation;
import pidev.entities.Reponse;
import pidev.entities.SousDomaine;
import pidev.entities.Test;
import pidev.entities.User;
import pidev.interfaces.IAffectationDAO;
import pidev.interfaces.ICommentaireDAO;
import pidev.interfaces.IDomaineDAO;
import pidev.interfaces.IEvaluationDAO;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IGradeDAO;
import pidev.interfaces.IMessageDAO;
import pidev.interfaces.IProjetDAO;
import pidev.interfaces.IQuestionDAO;
import pidev.interfaces.IReclamationDAO;
import pidev.interfaces.IReponseDAO;
import pidev.interfaces.ISousDomaineDAO;
import pidev.interfaces.ITestDAO;
import pidev.interfaces.IUserDAO;

/**
 *
 * @author SaddeM
 */
public class Pidev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //5edmettou maroua :o
//        User u1 = new User();
//        u1.setId(3);
//        User u2 =new User();
//        u2.setId(7);
//        IUserDAO beredsekka = UserDAO.getInstance();
//        beredsekka.updateTokensUser(u1,u2 , 2);
        // TODO code application logic here      
//          
//      Grade g = new Grade(9,"Expert123");
//      //IGradeDAO gdao = GradeDAO.getInstance();
//      //gdao.insertGrade(g);
//     
//       Freelancer f = new Freelancer("cv", g, "test", "email@dz.dz", "dqdq", "sami", "qzdqzdzq","17/05/1992","photo",1, "08/02/2015", 100);
//       IFreelancerDAO fdao = FreelancerDAO.getInstance();
//      
//      // fdao.insertFreelancer(f); 
//     
//       User u = new User("marouatest", "march@me.fr", "tatty122", "chouari", "maroua", "06/06/3343", "image", 1, "05/02/2015", 10);
//       User u3 = new User("samitesting123", "sadd@sda.fr", "sadsad113", "Anene", "Saddem", "21/02/1991", "lienPhoto", 1, "05/02/2015", 10);
//       User u4 = new User("tatty", "mar@chou.com", "123", "chou", "mar", "02/06/1992", "photo", 0, "11/10/2014", 500);
//       UserDAO udao = new UserDAO();
////        udao.insertUser(u);
////        udao.insertUser(u3);
//          //udao.insertUser(u4);
//        
//        
//     
//        IGradeDAO gdao = GradeDAO.getInstance();
//        System.out.println(gdao.findGradeById(4));
//        List<Grade> tab_g = new ArrayList<Grade>();
//        tab_g = gdao.DisplayAllGrade();
//        for (Iterator<Grade> it = tab_g.iterator(); it.hasNext();) {
//            Grade grade = it.next();
//            System.out.println(grade.toString());
//            
//        }
////        Grade g = new Grade("SaddemTest");
////        gdao.insertGrade(g);
////        
////        UserDAO ddao = new UserDAO();
////        ddao.deleteUser(10);
////       
////        
//       Domaine d = new Domaine("Reseaux");
//      IDomaineDAO ddao = (DomaineDAO) DomaineDAO.getInstance();
//      
//      List<Domaine> tab_d = new ArrayList<Domaine>();
////        tab_d = ddao.DisplayAllDomaines();
//        for (Iterator<Domaine> it = tab_d.iterator(); it.hasNext();) {
//            Domaine domaine = it.next();
//            System.out.println(domaine.toString());
//            
//        }
//        
//        
//        
//        
//        
////       
////       ddao.deleteDomaine(4);
//       Domaine d3 = new Domaine(5, "GL");
//       
//        Question q = new Question(6, d3, "testing");
//        IQuestionDAO qdao = QuestionDAO.getInstance();
//        //qdao.insertQuestion(q);
//       
//        //ddao.insertDomaine(d);
//
////        Grade g = new Grade("Expert");
////        Freelancer f = new Freelancer("MyCv", g, 100, "sadd2", "sad@sda.fr", "sadsad113", "Anene", "Saddem", "21/02/1991", "lienPhoto", 1, "05/02/2015", 10);
////      
//        
//               User u5 = new User("marouatestnow", "marchdqzdq@me.fr", "tattydzqdqz122", "chouaridzq", "marofeua", "06/06/2004", "image", 1, "05/02/2015", 10);
//      //udao.insertUser(u5);
////        Reclamation rec2 = new Reclamation(u5 , "Je rdbtrbyfytbyt po", "29/02/2070", 0);
////        IReclamationDAO rdao = (ReclamationDAO) ReclamationDAO.getInstance();
////        rdao.envoyerReclamation(rec2);
////        
////       Domaine d = new Domaine(1,"Reseau");
////        Question q = new Question(d, "Que fait bered sekka ?");
////       
////        System.out.println(q.getDomaine().getId());
////        System.out.println(q.getDomaine().getLabel());
////        System.out.println(q.getLabel());
////       IQuestionDAO gdao = QuestionDAO.getInstance();
////       
//////                
////       gdao.insertQuestion(q);
////        
//        User u1 = new User(20,"testmessagethree", "sadd@sda.fr", "saddqzdqzd113", "Anene", "Saddem", "21/02/1991", "lienPhoto", 1, "05/02/2015", 10);
//        User u2 = new User(21,"messagefour", "sadd@sda.fr", "saddqdzd113", "Anene", "Saddem", "21/02/1991", "lienPhoto", 1, "05/02/2015", 10);
////         
//      // IUserDAO udao = UserDAO.getInstance();
//       
//    //   System.out.println(udao.FindUserById(20).toString());
//    //    udao.insertUser(u1);
//    //    udao.insertUser(u2);
//       
//       Message m2 = new Message(u, u3, "fkljdqkfqlm", "fdjslfksjfs", 1);
////        System.out.println(m.getDestinataire().getId());
////        System.out.println(m.getEmetteur());
//       
//       
//           IMessageDAO mdao = MessageDAO.getInstance();
////             mdao.envoyerMessage(m2);
////       List<Message> tab_m = new ArrayList<Message>();
////         tab_m = mdao.DisplayAllMessages();
////         
////          for (Iterator<Message> it = tab_m.iterator(); it.hasNext();) {
////            Message message = it.next();
////             // System.out.println(message.toString());
////            
////        }
//        ;
//         
//         
//       
//       
//       Domaine d5 = new Domaine(2,"WEB");
//       
//     Projet p = new Projet(5,"projet 1", "details", u2, d5, 1);
////       IProjetDAO pdao = ProjetDAO.getInstance();
////       pdao.insertProjet(p);
////       System.out.println( pdao.findProjetById(5).toString());
////       
//       
////          Grade g = new Grade("Expert");
////          Freelancer f = new Freelancer("MyCv", g, 22, "test2", "sad@sda.fr", "sadsad113", "test", "test", "21/02/1991", "lienPhoto", 1, "05/02/2015", 10);
////          Freelancer f1 = new Freelancer("MyCv", g, 50, "test2", "sad@sda.fr", "sadsad113", "test", "test", "21/02/1991", "lienPhoto", 1, "05/02/2015", 10);
////          IFreelancerDAO fdao = FreelancerDAO.getInstance();
//        //  fdao.insertFreelancer(f1);
//      //  System.out.println(fdao.FindFreelancerById(23).toString());
//          
//
//        Affectation af = new Affectation(2,p, f, 1, 1, "17/07/1992");
//        IAffectationDAO afdao = AffectationDAO.getInstance();
//        //afdao.AffecterFreelancer(af);
//        
////        List<Affectation> tab_a = new ArrayList<Affectation>();
////        tab_a = afdao.DisplayAllAffectation();
////        for (Iterator<Affectation> it = tab_a.iterator(); it.hasNext();) {
////            Affectation affectation = it.next();
////         //   System.out.println(affectation.toString());
////            
////        }
//        
//       // afdao.AffecterFreelancer(af);
//        
//      //  System.out.println( afdao.findAffectationById(5));
//        
//        Test t = new Test(f, d, 4, "15/05/1992", 1);
//        ITestDAO tdao = TestDAO.getInstance();
//       // tdao.insertTest(t);
//        
//        
//       
//       Evaluation e = new Evaluation("good", 4, u5, u4, "15/89/58");
//       IEvaluationDAO edao = EvaluationDAO.getInstance();
//        //edao.insertEvaluation(e);
//       
////       List<Evaluation> tab_e = new ArrayList<Evaluation>();
////        tab_e = edao.DisplayAllEvaluation();
////        for (Iterator<Evaluation> it = tab_e.iterator(); it.hasNext();) {
////            Evaluation evaluation = it.next();
////            System.out.println(evaluation.toString());
////            
////        }
//       
////       
////            Reclamation rec = new Reclamation(u2, "message", "15/15/15", 0);
////       
////    IReclamationDAO rdao = (ReclamationDAO) ReclamationDAO.getInstance();
////     
////     rdao.envoyerReclamation(rec);
////       
//       
//       // Question q = new Question(1,d, "s5oun train est ?");       
//       
//        Reponse r = new Reponse(q, "bla", 0);
//       
//        IReponseDAO repdao = ReponseDAO.getInstance();
//       
////        System.out.println(repdao.findReponseById(1).toString());
//       
////       repdao.insertReponse(r);
//       
//       SousDomaine sd = new SousDomaine(1, d, "C#");
//       ISousDomaineDAO sddao = SousDomaineDAO.getInstance();
// //      sddao.insertSousDomaine(sd);
//       
//       Commentaire c = new Commentaire(p, u2, "votre honneur", "15/05/2005");
//       ICommentaireDAO ccdao = CommentaireDAO.getInstance();
////       ccdao.insertCommentaire(c);
//       
//       List<Commentaire> tab_c = new ArrayList<Commentaire>();
//        tab_c = ccdao.DisplayAllCommentaires();
//        for (Iterator<Commentaire> it = tab_c.iterator(); it.hasNext();) {
//            Commentaire commentaire = it.next();
//            System.out.println(commentaire.toString());
//       }
    }
    
    
}
    

