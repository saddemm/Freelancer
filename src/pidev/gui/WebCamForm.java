package pidev.gui;




import JImage.JIResizeImage;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import pidev.dao.UserDAO;
import pidev.entities.User;
import pidev.interfaces.IUserDAO;

/**
 *
 * @author clickcentre
 */
public class WebCamForm extends javax.swing.JFrame {

    Player player;
    BufferedImage bi;
    String nfile;
    FileInputStream fin;
    /**
     * Creates new form WebCamForm
     */
    public WebCamForm() {
        initComponents();
        try {
            initCamera();
        } catch (IOException ex) {
            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoPlayerException ex) {
            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotRealizeException ex) {
            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   private void initCamera() throws IOException, NoPlayerException,CannotRealizeException
   {
       MediaLocator ml = new MediaLocator("vfw://0");
       player =Manager.createRealizedPlayer(ml);
       this.tbCamera.add(player.getVisualComponent());
       player.start();
   }
   
   private void setImageButton(JToggleButton tbutton,Image image)
   {
       tbutton.setIcon(new ImageIcon(image));
   }
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tbCamera = new javax.swing.JToggleButton();
        tbCapture = new javax.swing.JToggleButton();
        bCapture = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        btn_retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("WEBCAM APPLICATION & CAPTURE IMAGE");

        bCapture.setText("CAPTURE");
        bCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCaptureActionPerformed(evt);
            }
        });

        bSave.setText("SAVE");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        btn_retour.setText("retour");
        btn_retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(bCapture)
                .addGap(112, 112, 112)
                .addComponent(btn_retour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSave)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(tbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(tbCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbCapture, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bCapture)
                            .addComponent(btn_retour))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSave)
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCaptureActionPerformed
        // TODO add your handling code here:
        FrameGrabbingControl fgc = (FrameGrabbingControl)player.getControl("javax.media.control.FrameGrabbingControl");
        Buffer buffer = fgc.grabFrame();
        
        BufferToImage bti = new BufferToImage((VideoFormat)buffer.getFormat());
        Image image = bti.createImage(buffer);
        JIResizeImage resize = new JIResizeImage();
        bi = (BufferedImage) image;
        Image imageresize = resize.rescale(bi, 150,150);
        this.setImageButton(this.tbCapture, imageresize);
        
    }//GEN-LAST:event_bCaptureActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        // TODO add your handling code here:
        FileDialog fd= new FileDialog(WebCamForm.this,"Save Image",FileDialog.SAVE);
        fd.show();
        
        if(fd.getFile() != null)
        {
            nfile = fd.getDirectory() + fd.getFile() +".jpg";
            try{
                File make = new File(nfile);
                try
                {
                    ImageIO.write(bi, "jpg", make);
                }
              
            catch(IOException ex)
            {
                //Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE,NumberFormatException);
                Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null,ex);
            }
           }
            catch(Exception ex)
            {
                
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void btn_retourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retourActionPerformed
        // TODO add your handling code here:
     
        IUserDAO userdao = UserDAO.getInstance();
            FrameFreeLancer.jLabel7.setIcon(new javax.swing.ImageIcon(nfile)); // NOI18N
            System.out.println(nfile);
            this.setVisible(false);
            User user = new User();
            user.setEmail(FrameFreeLancer.tf_email.getText());
            File fil = new File(nfile);
            
        try {
            fin = new FileInputStream(fil);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WebCamForm.class.getName()).log(Level.SEVERE, null, ex);
        }
//            user.setPhoto(fin);
//            int len = (int) fil.length();
//            userdao.AjoutPhoto(user, len);
           
    }//GEN-LAST:event_btn_retourActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
           WebCamForm from = new WebCamForm();
            from.setVisible(true);
        
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
            java.util.logging.Logger.getLogger(WebCamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebCamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebCamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebCamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new WebCamForm().setVisible(true);
               // from.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCapture;
    private javax.swing.JButton bSave;
    private javax.swing.JButton btn_retour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton tbCamera;
    private javax.swing.JToggleButton tbCapture;
    // End of variables declaration//GEN-END:variables
}