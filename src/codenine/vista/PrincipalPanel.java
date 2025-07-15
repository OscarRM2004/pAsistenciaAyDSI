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

import java.awt.Image;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import codenine.modelo.AsistenciaImpl; // Asegúrate de que esta importación sea correcta

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
    }
    
    private void configurarColumnasVisibles() {
        // Asegurarse de que la tabla tiene columnas antes de intentar modificarlas
        if (tablaPendientes.getColumnCount() > 0) {
            // Ocultamos la columna 'ID Persona' que está en el índice 0
            tablaPendientes.getColumnModel().getColumn(0).setMinWidth(0);
            tablaPendientes.getColumnModel().getColumn(0).setMaxWidth(0);
            tablaPendientes.getColumnModel().getColumn(0).setWidth(0);

            // Ocultamos la columna 'Ruta Evidencia' que está en el índice 3
            tablaPendientes.getColumnModel().getColumn(3).setMinWidth(0);
            tablaPendientes.getColumnModel().getColumn(3).setMaxWidth(0);
            tablaPendientes.getColumnModel().getColumn(3).setWidth(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        chooserFechaConfirmacion = new com.toedter.calendar.JDateChooser();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarPendientes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPendientes = new javax.swing.JTable();
        lblEvidencia = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnRechazar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(chooserFechaConfirmacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 160, 40));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 713, 54, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Fecha a revisar:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, -1, 20));

        btnBuscarPendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa2.png"))); // NOI18N
        btnBuscarPendientes.setText("Buscar Pendientes");
        btnBuscarPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPendientesActionPerformed(evt);
            }
        });
        add(btnBuscarPendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 200, 60));

        tablaPendientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPendientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPendientes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 420, 250));

        lblEvidencia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblEvidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 390, 250));

        btnConfirmar.setText("Confirmar Asistencia");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 160, 40));

        btnRechazar.setText("Rechazar");
        btnRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRechazarActionPerformed(evt);
            }
        });
        add(btnRechazar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 460, 100, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("CONFIRMACION DE ASISTENCIA");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (menuPrincipal != null) {
            menuPrincipal.limpiarPanelContenido();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPendientesActionPerformed
        Date fechaSeleccionada = chooserFechaConfirmacion.getDate();
        if (fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formateamos la fecha al formato YYYY-MM-DD que usa la base de datos
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = sdf.format(fechaSeleccionada);

        // Llamamos al DAO para obtener las asistencias pendientes
        AsistenciaImpl asistenciaDAO = new AsistenciaImpl();
        DefaultTableModel modelo = asistenciaDAO.getAsistenciasPendientes(fechaFormateada);

        tablaPendientes.setModel(modelo);

        // tablaPendientes.removeColumn(tablaPendientes.getColumnModel().getColumn(4));
        configurarColumnasVisibles();
    }//GEN-LAST:event_btnBuscarPendientesActionPerformed

    private void tablaPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPendientesMouseClicked
        int filaSeleccionada = tablaPendientes.getSelectedRow();
        if (filaSeleccionada < 0) {
            return; // No hay fila seleccionada
        }

        // Obtenemos la ruta relativa de la evidencia (ej: "uploads/Captura de pantalla...")
        String rutaEvidencia = tablaPendientes.getValueAt(filaSeleccionada, 3).toString();

        try {
            // --- LÍNEA CLAVE DE LA SOLUCIÓN ---
            // Reemplazamos los espacios en la ruta con "%20" para crear una URL válida.
            String rutaCodificada = rutaEvidencia.replace(" ", "%20");
            // ---------------------------------

            // Construimos la URL completa y correcta
            URL urlImagen = new URL("http://136.0.42.211/" + rutaCodificada);

            // Cargamos la imagen desde la URL
            Image imagen = ImageIO.read(urlImagen);

            if (imagen != null) {
                // Redimensionamos la imagen para que quepa en el JLabel
                // Ajusta el tamaño (ej. 200x200) según el tamaño de tu lblEvidencia
                Image imagenRedimensionada = imagen.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                lblEvidencia.setIcon(new ImageIcon(imagenRedimensionada));
                lblEvidencia.setText(""); // Limpiamos cualquier texto de error
            } else {
                lblEvidencia.setIcon(null);
                lblEvidencia.setText("No se pudo decodificar la imagen.");
            }
        } catch (Exception e) {
            lblEvidencia.setIcon(null);
            lblEvidencia.setText("Error al cargar la imagen.");
            // Imprimimos el error en la consola para tener más detalles
            e.printStackTrace(); 
        }
    }//GEN-LAST:event_tablaPendientesMouseClicked

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int filaSeleccionada = tablaPendientes.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para confirmar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtenemos los datos de la fila seleccionada
        int idPersona = (int) tablaPendientes.getValueAt(filaSeleccionada, 0);
        String fecha = tablaPendientes.getValueAt(filaSeleccionada, 4).toString(); // Obtenemos la fecha de la columna 4

        AsistenciaImpl asistenciaDAO = new AsistenciaImpl();
        if (asistenciaDAO.confirmarAsistencia(idPersona, fecha)) {
            JOptionPane.showMessageDialog(this, "Asistencia confirmada exitosamente.");
            // Quitamos la fila de la tabla para que ya no aparezca como pendiente
            ((DefaultTableModel) tablaPendientes.getModel()).removeRow(filaSeleccionada);
            lblEvidencia.setIcon(null); // Limpiamos la imagen
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al confirmar la asistencia.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRechazarActionPerformed
        int filaSeleccionada = tablaPendientes.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro de la tabla para rechazar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea rechazar y eliminar este registro de asistencia?", "Confirmar Rechazo", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            int idPersona = (int) tablaPendientes.getValueAt(filaSeleccionada, 0);
            String fecha = tablaPendientes.getValueAt(filaSeleccionada, 4).toString();

            AsistenciaImpl asistenciaDAO = new AsistenciaImpl();
            if (asistenciaDAO.rechazarAsistencia(idPersona, fecha)) {
                JOptionPane.showMessageDialog(this, "Asistencia rechazada y eliminada exitosamente.");
                ((DefaultTableModel) tablaPendientes.getModel()).removeRow(filaSeleccionada);
                lblEvidencia.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al rechazar la asistencia.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRechazarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarPendientes;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRechazar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser chooserFechaConfirmacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEvidencia;
    private javax.swing.JTable tablaPendientes;
    // End of variables declaration//GEN-END:variables
}
