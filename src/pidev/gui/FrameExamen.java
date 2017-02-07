/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import pidev.dao.FreelancerDAO;
import pidev.dao.TestDAO;
import pidev.entities.Domaine;
import pidev.entities.Freelancer;
import pidev.entities.Question;
import pidev.entities.Test;
import pidev.interfaces.IFreelancerDAO;
import pidev.interfaces.ITestDAO;

/**
 *
 * @author SaddeM
 */
public class FrameExamen extends javax.swing.JFrame {

    /**
     * Creates new form FrameExamen
     */
    public FrameExamen() {
        initComponents();
        buttonGroup1.add(rep1);
        buttonGroup1.add(rep2);
        buttonGroup1.add(rep3);
        timer1 = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                counter--;
                ChronoZ.setText(counterMin+":"+counter);
                if (counter == 0) {
                    counter=59;
                    counterMin--;
                    ChronoZ.setText(counterMin+":"+counter);
                    
                    
                }
            }
        });

        

        timer1.setInitialDelay(1000);
        timer1.start();
        
        

    }
    Timer timer1;

    private int counter = 60;
    private int counterMin = 29;
    private List<Question> Questions;
    private int nbr;
    private String reponseVrai = "";
    private int moy = 0;
    private Domaine d;
    private Freelancer f;

    public Domaine getD() {
        return d;
    }

    public void setD(Domaine d) {
        this.d = d;
        NomDomaine.setText(d.getLabel());
    }

    public Freelancer getF() {
        return f;
    }

    public void setF(Freelancer f) {
        this.f = f;
    }

    public int getMoy() {
        return moy;
    }

    public void setMoy(int moy) {
        this.moy = moy;
    }

    public String getReponseVrai() {
        return reponseVrai;
    }

    public void setReponseVrai(String reponseVrai) {
        this.reponseVrai = reponseVrai;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public List<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(List<Question> Questions) {
        this.Questions = Questions;
    }

    public void calculMoyenne(JRadioButton r1, JRadioButton r2, JRadioButton r3) {
        
         if (r1.isSelected() || r2.isSelected() || r3.isSelected()) {

        if (r1.isSelected() && r1.getText().equals(this.reponseVrai)) {
            this.setMoy(this.getMoy() + 2);
        }
        if (r2.isSelected() && r2.getText().equals(this.reponseVrai)) {
            this.setMoy(this.getMoy() + 2);
        }
        if (r3.isSelected() && r3.getText().equals(this.reponseVrai)) {
            this.setMoy(this.getMoy() + 2);
        }
        
        this.remplir(this.getQuestions(), this.getNbr() + 1);

            buttonGroup1.clearSelection();
        
        
         
           } else {
            JOptionPane.showMessageDialog(this, "Vous n'avez choisit aucune reponse", "Test", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void remplir(List<Question> qs, int nbr) {
        if (nbr < 10) {
            this.setQuestions(qs);
            this.setNbr(nbr);

            Question q = new Question();
            q = qs.get(nbr);
            QuestionTest.setText(q.getLabel());

            rep1.setText(q.getReponses().get(0).getLabel());
            int vrai1 = q.getReponses().get(0).getEstCorrect();

            if (vrai1 == 1) {
                this.setReponseVrai(q.getReponses().get(0).getLabel());
            }

            rep2.setText(q.getReponses().get(1).getLabel());
            int vrai2 = q.getReponses().get(1).getEstCorrect();
            if (vrai2 == 1) {
                this.setReponseVrai(q.getReponses().get(1).getLabel());
            }

            rep3.setText(q.getReponses().get(2).getLabel());
            int vrai3 = q.getReponses().get(2).getEstCorrect();
            if (vrai3 == 1) {
                this.setReponseVrai(q.getReponses().get(2).getLabel());
            }

        } else {
            ITestDAO tdao = TestDAO.getInstance();
            Test t = new Test(this.getF(), this.getD(), this.getMoy(), 20);
            tdao.insertTest(t);
            if (this.getMoy()>14){
                IFreelancerDAO fdao = FreelancerDAO.getInstance();
                fdao.updateFreelancerGrade(this.getF().getId());
            }
            JOptionPane.showMessageDialog(this, "Vous avez terminer votre Test \n Vous avez eu " + this.getMoy() + " /20", "Test", JOptionPane.INFORMATION_MESSAGE);

            this.setVisible(false);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        NomDomaine = new javax.swing.JLabel();
        QuestionTest = new javax.swing.JLabel();
        rep2 = new javax.swing.JRadioButton();
        rep3 = new javax.swing.JRadioButton();
        rep1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ChronoZ = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NomDomaine.setText("jLabel1");

        QuestionTest.setForeground(new java.awt.Color(0, 102, 255));
        QuestionTest.setText("jLabel1");

        rep2.setText("jRadioButton1");

        rep3.setText("jRadioButton1");

        rep1.setText("jRadioButton1");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ChronoZ.setIcon(new javax.swing.ImageIcon("C:\\Users\\SaddeM\\Downloads\\rsz_chrono.png")); // NOI18N
        ChronoZ.setText("jLabel1");
        ChronoZ.setMaximumSize(new java.awt.Dimension(50, 50));
        ChronoZ.setMinimumSize(new java.awt.Dimension(50, 50));
        ChronoZ.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ChronoZ, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(NomDomaine, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(QuestionTest, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rep2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rep3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NomDomaine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))
                    .addComponent(ChronoZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(QuestionTest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rep1)
                .addGap(18, 18, 18)
                .addComponent(rep2)
                .addGap(18, 18, 18)
                .addComponent(rep3)
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

            calculMoyenne(rep1, rep2, rep3);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameExamen().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChronoZ;
    private javax.swing.JLabel NomDomaine;
    private javax.swing.JLabel QuestionTest;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rep1;
    private javax.swing.JRadioButton rep2;
    private javax.swing.JRadioButton rep3;
    // End of variables declaration//GEN-END:variables
}
