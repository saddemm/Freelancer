/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pidev.dao.FreelancerDAO;
import pidev.dao.UserDAO;
import pidev.entities.Freelancer;
import pidev.entities.User;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.IUserDAO;


/**
 *
 * @author HP
 */
public class FrameAuth extends javax.swing.JFrame {
    private String who;
    private String username;
    private String password;
    
    /**
     * Creates new form FrameUser
     */
    public FrameAuth() {
        initComponents(); 
        setLocationRelativeTo(null);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cb_whoareyou = new javax.swing.JComboBox();
        lb_title = new javax.swing.JLabel();
        btn_log = new javax.swing.JButton();
        chk_remember = new javax.swing.JCheckBox();
        lb_forgot = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_signup = new javax.swing.JLabel();
        tf_login = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cb_whoareyou.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        cb_whoareyou.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FreeLancer", "JobOwner" }));
        cb_whoareyou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_whoareyouActionPerformed(evt);
            }
        });

        lb_title.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        lb_title.setForeground(new java.awt.Color(0, 153, 153));
        lb_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_title.setText("Log in and get to work");

        btn_log.setBackground(new java.awt.Color(51, 153, 0));
        btn_log.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        btn_log.setForeground(new java.awt.Color(255, 255, 255));
        btn_log.setText("Log In");
        btn_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logActionPerformed(evt);
            }
        });

        chk_remember.setBackground(new java.awt.Color(255, 255, 255));
        chk_remember.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        chk_remember.setText("Remember me");
        chk_remember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_rememberActionPerformed(evt);
            }
        });

        lb_forgot.setFont(new java.awt.Font("Century Schoolbook", 0, 12)); // NOI18N
        lb_forgot.setForeground(new java.awt.Color(0, 204, 204));
        lb_forgot.setText("Forgot your password?");
        lb_forgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_forgotMouseClicked(evt);
            }
        });

        tf_password.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tf_password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel3.setText("You are a");

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel5.setText("Password");

        lb_signup.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        lb_signup.setForeground(new java.awt.Color(0, 153, 153));
        lb_signup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_signup.setText("You are new? Sign Up");
        lb_signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_signupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_signupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_signupMouseExited(evt);
            }
        });

        tf_login.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        tf_login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        tf_login.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tf_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_loginActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Or Log In With Your");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pidev/gui/images/fb.png"))); // NOI18N
        jButton1.setMaximumSize(new java.awt.Dimension(73, 73));
        jButton1.setMinimumSize(new java.awt.Dimension(73, 73));
        jButton1.setPreferredSize(new java.awt.Dimension(73, 73));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.setMaximumSize(new java.awt.Dimension(73, 73));
        jButton2.setMinimumSize(new java.awt.Dimension(73, 73));
        jButton2.setPreferredSize(new java.awt.Dimension(73, 73));

        jButton3.setText("jButton3");
        jButton3.setMaximumSize(new java.awt.Dimension(73, 73));
        jButton3.setMinimumSize(new java.awt.Dimension(73, 73));
        jButton3.setPreferredSize(new java.awt.Dimension(73, 73));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(chk_remember, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_log, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lb_title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                .addComponent(lb_forgot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_password)
                                        .addComponent(tf_login)
                                        .addComponent(cb_whoareyou, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lb_title, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_whoareyou, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_login, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_log, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_remember, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_forgot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(110, 40, 460, 480);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(51, 21, 306, 0);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pidev/gui/images/téléchargement.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(3000, 3000));
        jLabel2.setMinimumSize(new java.awt.Dimension(3000, 3000));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 700, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_loginActionPerformed
        
    }//GEN-LAST:event_tf_loginActionPerformed

    private void cb_whoareyouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_whoareyouActionPerformed
        
    }//GEN-LAST:event_cb_whoareyouActionPerformed

    private void chk_rememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_rememberActionPerformed
        
    }//GEN-LAST:event_chk_rememberActionPerformed

    private void lb_forgotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_forgotMouseClicked
       
    }//GEN-LAST:event_lb_forgotMouseClicked

    private void btn_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logActionPerformed
        who=String.valueOf(cb_whoareyou.getSelectedItem());
        username= tf_login.getText();
        password=String.copyValueOf(tf_password.getPassword()) ;
      
            if  (username.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Please enter your login and password", "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_login.setBorder(BorderFactory.createLineBorder(Color.decode("#FE1B00")));
            tf_password.setBorder(BorderFactory.createLineBorder(Color.decode("#FE1B00")));
            }
            
        else
            if ((password.isEmpty()))
        {
            JOptionPane.showMessageDialog(this, "Please enter your password", "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_password.setBorder(BorderFactory.createLineBorder(Color.decode("#FE1B00")));
            tf_login.setBorder(BorderFactory.createLineBorder(Color.decode("#CCCCCC")));
            
        }    
        else 
            if  (username.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter your login", "Error Message", JOptionPane.ERROR_MESSAGE);
            tf_login.setBorder(BorderFactory.createLineBorder(Color.decode("#FE1B00")));
            tf_password.setBorder(BorderFactory.createLineBorder(Color.decode("#CCCCCC")));
            }
        else
            {/*try{*/
                IUserDAO udao = UserDAO.getInstance();
                User u = new User();
                
                u=udao.findUserByEmail(username);
                String email = u.getEmail();
                String pwd = u.getPassword();
                String nom = u.getNom();
                String prenom = u.getPrenom();
                int id = u.getId();
                IFreelancerDAO freeDAO = FreelancerDAO.getInstance();
                Freelancer f = new Freelancer();
                f = freeDAO.FindFreelancerById(id);
               // int a =  freeDAO.findFreeLancerByEmail(username);
              
                if(who.equals("JobOwner"))
                {
                    try{
                      if(password.equals(u.getPassword()))
                        {
                        JOptionPane.showMessageDialog(this, "Bienvenue  JobOwner "+nom+" "+prenom, "Message", JOptionPane.INFORMATION_MESSAGE);
                        FrameJobOwner job = new FrameJobOwner();
                        FrameJobOwner.id_login=u.getId();
                        this.setVisible(false);
                        job.setVisible(true);
                        }
                     else
                     JOptionPane.showMessageDialog(this, "Vérifiez votre login ou mot de passe", "Error Message", JOptionPane.ERROR_MESSAGE);
                } 
                    catch(NullPointerException ex)
                              {JOptionPane.showMessageDialog(this, "Vérifiez votre login ou mot de passe", "Error Message", JOptionPane.ERROR_MESSAGE);}
                }
                else if(who.equals("FreeLancer"))
                {  
                   
                   {try{
                    if(password.equals(u.getPassword()))
                        {
                        JOptionPane.showMessageDialog(this, "Bienvenue FreeLancer "+nom+" "+prenom, "Message", JOptionPane.INFORMATION_MESSAGE);
                        FrameFreeLancer free = new FrameFreeLancer();
                        this.setVisible(false);
                        free.setVisible(true);
                        }
                         else
                         JOptionPane.showMessageDialog(this, "Vérifiez votre login ou mot de passe", "Error Message", JOptionPane.ERROR_MESSAGE);}
                       catch(NullPointerException aa)
                              {JOptionPane.showMessageDialog(this, "Vérifiez votre login ou mot de passe", "Error Message", JOptionPane.ERROR_MESSAGE);}
               }
             }  
            
            } 
    }//GEN-LAST:event_btn_logActionPerformed

            
    
    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        
    }//GEN-LAST:event_tf_passwordActionPerformed

    private void lb_signupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_signupMouseEntered
        // TODO add your handling code here:
     lb_signup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        
    }//GEN-LAST:event_lb_signupMouseEntered

    private void lb_signupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_signupMouseExited
        // TODO add your handling code here:
        lb_signup.setBorder(null);
    }//GEN-LAST:event_lb_signupMouseExited

    private void lb_signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_signupMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        FrameInscription f = new FrameInscription();
        f.setVisible(true);
    }//GEN-LAST:event_lb_signupMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       
   
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAuth().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_log;
    private javax.swing.JComboBox cb_whoareyou;
    private javax.swing.JCheckBox chk_remember;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_forgot;
    private javax.swing.JLabel lb_signup;
    private javax.swing.JLabel lb_title;
    private javax.swing.JTextField tf_login;
    private javax.swing.JPasswordField tf_password;
    // End of variables declaration//GEN-END:variables
}
