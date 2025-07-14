package codenine.vista;

import codenine.dto.AsistenciaDTO;
import codenine.dto.OcurrenciaDto;
import codenine.dto.AreaDTO;
import codenine.interfaz.AsistenciaInterfaz;
import codenine.interfaz.AreaInterfaz;
import codenine.interfaz.PersonaInterfaz;
import codenine.modelo.AsistenciaImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import codenine.modelo.AreaImpl;
import codenine.modelo.PersonaImpl;
import codenine.modelo.VistaMensajes;
import javax.swing.table.DefaultTableModel;

public class PrincipalPanel extends javax.swing.JPanel {

    JComboBox comboBox = new JComboBox();
    AreaDTO cmbo = new AreaDTO();
    private Menu menuPrincipal;
    public PrincipalPanel(Menu menu) {
        initComponents();
        this.menuPrincipal = menu;
        VistaMensajes.mensaje();
        CargarTablaPersonas();
    }
    
    void CargarTablaPersonas() {
        PersonaImpl proc = new PersonaImpl(); // 'PersonaImpl' ahora es nuestro DAO de personas
        tbUsuariosWeb.setModel(proc.tablaCredencialesWeb());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuariosWeb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrearCuentaWeb = new javax.swing.JButton();
        txtNewPassword = new javax.swing.JPasswordField();
        txtWebUser = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(850, 560));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Cuentas");

        tbUsuariosWeb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbUsuariosWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosWebMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuariosWeb);

        jLabel1.setText("Email (Usuario):");

        jLabel3.setText("Contraseña:");

        btnCrearCuentaWeb.setText("CREAR/ACTUALIZAR CUENTA");
        btnCrearCuentaWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaWebActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtWebUser)
                                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCrearCuentaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(362, 362, 362)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtWebUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btnCrearCuentaWeb)
                        .addGap(161, 161, 161))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (menuPrincipal != null) {
            menuPrincipal.limpiarPanelContenido();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void tbUsuariosWebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosWebMouseClicked
        // Obtenemos el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) tbUsuariosWeb.getModel();

        // Obtenemos el índice de la fila seleccionada
        int selectedRow = tbUsuariosWeb.getSelectedRow();

        // Verificamos que se haya seleccionado una fila válida
        if (selectedRow >= 0) {
            // Obtenemos el email de la segunda columna (índice 1) de la fila seleccionada
            String email = model.getValueAt(selectedRow, 1).toString();

            // Ponemos el email en el campo de texto correspondiente
            // Asumo que el campo de texto se llama 'txtWebUser' o similar
            txtWebUser.setText(email); 

            // Limpiamos el campo de contraseña para que el admin escriba una nueva
            // Asumo que el campo de contraseña se llama 'txtNewPassword'
            txtNewPassword.setText(""); 
        }
    }//GEN-LAST:event_tbUsuariosWebMouseClicked

    private void btnCrearCuentaWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaWebActionPerformed
        String email = txtWebUser.getText();
        String password = new String(txtNewPassword.getPassword());

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (password.isEmpty() || password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una contraseña válida (mínimo 6 caracteres).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonaImpl per = new PersonaImpl();
        // Usamos el método que ya habíamos preparado para actualizar la contraseña
        boolean exito = per.actualizarPasswordWeb(email, password);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Contraseña actualizada exitosamente para el usuario " + email);
            txtNewPassword.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al actualizar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCrearCuentaWebActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuentaWeb;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuariosWeb;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JTextField txtWebUser;
    // End of variables declaration//GEN-END:variables
}
