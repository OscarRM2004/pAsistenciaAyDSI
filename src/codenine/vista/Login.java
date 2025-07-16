package codenine.vista;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 * @author usuario
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        rb_mostrarpass = new javax.swing.JRadioButton();
        btn_ingresar = new javax.swing.JButton();
        user = new javax.swing.JLabel();
        key = new javax.swing.JLabel();
        ICONG = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userActionPerformed(evt);
            }
        });
        jPanel1.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 210, -1));

        jLabel3.setText("CONTRASEÑA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 210, -1));

        rb_mostrarpass.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rb_mostrarpass.setText("MOSTRAR CONTRASEÑA");
        rb_mostrarpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_mostrarpassActionPerformed(evt);
            }
        });
        jPanel1.add(rb_mostrarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 150, 20));

        btn_ingresar.setText("INGRESAR");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, -1));

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/userLabel.png"))); // NOI18N
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, -1));

        key.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/key.png"))); // NOI18N
        jPanel1.add(key, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        ICONG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Icono.png"))); // NOI18N
        jPanel1.add(ICONG, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        jLabel2.setText("USUARIO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        jLabel1.setText("¡BIENVENIDO!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userActionPerformed
        
    }//GEN-LAST:event_txt_userActionPerformed

    private void rb_mostrarpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_mostrarpassActionPerformed
        if(!rb_mostrarpass.isSelected()){
            txt_pass.setEchoChar('\u25cf');
        }else{
            txt_pass.setEchoChar((char)0);
        }
    }//GEN-LAST:event_rb_mostrarpassActionPerformed
 
    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        String username = txt_user.getText();
        String password = new String(txt_pass.getPassword());

        if("Admin".equals(username) && "12345".equals(password)){
            Menu menu = new Menu();
            menu.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Credenciales Incorrectas","error de inicio de sesion",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_ingresarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ICONG;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel key;
    private javax.swing.JRadioButton rb_mostrarpass;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}