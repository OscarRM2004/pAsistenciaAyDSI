package codenine.vista;

import codenine.dto.AsistenciaDTO;
import codenine.dto.OcurrenciaDto;
import codenine.dto.AreaDTO;
import codenine.interfaz.AsistenciaInterfaz;
import codenine.interfaz.AreaInterfaz;
import codenine.modelo.AsistenciaImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import codenine.modelo.AreaImpl;
import codenine.modelo.VistaMensajes;

public class PrincipalPanel extends javax.swing.JPanel {

    JComboBox comboBox = new JComboBox();
    AreaDTO cmbo = new AreaDTO();
    private Menu menuPrincipal;
    public PrincipalPanel(Menu menu) {
        initComponents();
        this.menuPrincipal = menu;
        VistaMensajes.mensaje();
        CargarTablaIndex();
        CargarComboBox();
        CargarComboBoxArea();
        txtFecha.setEnabled(false);
    }

    void CargarComboBox() {

        AsistenciaInterfaz proc = new AsistenciaImpl();
        comboBox.setModel(proc.combo());

        tbAsistencia.setRowHeight(22);

        tbAsistencia.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
        tbAsistencia.setDefaultRenderer(Object.class, new CeldaRenderer(6));
    }

    void CargarComboBoxArea() {
        AreaInterfaz proc = new AreaImpl();
        cmbArea.setModel(proc.combo());
    }

    void CargarTabla(AreaDTO cmbo) {
        AsistenciaInterfaz proc = new AsistenciaImpl();
        tbAsistencia.setModel(proc.tablaAsistencia(cmbo));
        tbAsistencia.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbAsistencia.getColumnModel().getColumn(1).setPreferredWidth(20);
        tbAsistencia.getColumnModel().getColumn(2).setPreferredWidth(20);
        tbAsistencia.getColumnModel().getColumn(3).setPreferredWidth(20);
        tbAsistencia.getColumnModel().getColumn(4).setPreferredWidth(10);
        tbAsistencia.getColumnModel().getColumn(5).setPreferredWidth(40);
        tbAsistencia.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBox));
        tbAsistencia.getColumnModel().getColumn(7).setPreferredWidth(100);

    }

    void CargarTablaIndex() {
        AsistenciaInterfaz proc = new AsistenciaImpl();
        tbAsistencia.setModel(proc.tabla());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbAsistencia = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        btnRegresar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(850, 560));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tbAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Nombre", "Opciones", "Detalles"
            }
        ));
        jScrollPane1.setViewportView(tbAsistencia);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/registrar_1.png"))); // NOI18N
        btnAgregar.setText("REGISTRAR ASISTENCIA");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel1.setText("AREA:");

        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("CONTROL DE ASISTENCIA DEL PERSONAL");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("FECHA:");

        txtFecha.setBackground(new java.awt.Color(255, 255, 255));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update_2.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnAgregar)
                            .addGap(15, 15, 15)
                            .addComponent(btnActualizar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnActualizar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        AsistenciaInterfaz proc = new AsistenciaImpl();
        AsistenciaDTO dto = new AsistenciaDTO();
        Date date = txtFecha.getDate();

        if (date == null) {
            JOptionPane.showMessageDialog(null, "Debe Colocar Fecha");
        } else {

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = null;
            fecha = format1.format(date);

            for (int i = 0; i < tbAsistencia.getRowCount(); i++) {
                Object f = tbAsistencia.getModel().getValueAt(i, 1);
                Object g = tbAsistencia.getModel().getValueAt(i, 2);
                dto.setNombre(f + " " + g);
                OcurrenciaDto c6 = (OcurrenciaDto) tbAsistencia.getValueAt(i, 6);

                int c0 = (int) tbAsistencia.getValueAt(i, 0);
                dto.setIdpersona(c0);
                dto.setFecha(fecha);

                proc.eliminar(dto);

                System.out.println("vuelta: " + i + f);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        AsistenciaInterfaz proc = new AsistenciaImpl();
        AsistenciaDTO dto = new AsistenciaDTO();
        Date date = txtFecha.getDate();

        if (date == null) {
            JOptionPane.showMessageDialog(null, "Debe Colocar Fecha");
        } else {

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = null;
            fecha = format1.format(date);

            for (int i = 0; i < tbAsistencia.getRowCount(); i++) {
                Object f = tbAsistencia.getModel().getValueAt(i, 1);
                Object g = tbAsistencia.getModel().getValueAt(i, 2);
                dto.setNombre(f + " " + g);

                OcurrenciaDto c6 = (OcurrenciaDto) tbAsistencia.getValueAt(i, 6);

                if (c6 == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione una ocurrencia");
                } else {
                    int c0 = (int) tbAsistencia.getValueAt(i, 0);
                    String c7 = (String) tbAsistencia.getValueAt(i, 7);
                    dto.setIdpersona(c0);
                    dto.setFecha(fecha);
                    dto.setOcurrencia(String.valueOf(c6.getIdOcurrencia()));
                    dto.setDetalle(c7);

                    proc.registrar(dto);
                }
                System.out.println("vuelta: " + i + " - " + dto.getIdpersona() + " " + dto.getFecha());
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        AreaDTO cmbo = (AreaDTO) cmbArea.getSelectedItem();
        CargarTabla(cmbo);
        txtFecha.setEnabled(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (menuPrincipal != null) {
            menuPrincipal.limpiarPanelContenido();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        AsistenciaInterfaz proc = new AsistenciaImpl();
        AsistenciaDTO dto = new AsistenciaDTO();
        Date date = txtFecha.getDate();

        if (date == null) {
            JOptionPane.showMessageDialog(null, "Debe Colocar Fecha");
        } else {

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = null;
            fecha = format1.format(date);

            for (int i = 0; i < tbAsistencia.getRowCount(); i++) {
                Object f = tbAsistencia.getModel().getValueAt(i, 1);
                Object g = tbAsistencia.getModel().getValueAt(i, 2);
                dto.setNombre(f + " " + g);
                OcurrenciaDto c6 = (OcurrenciaDto) tbAsistencia.getValueAt(i, 6);

                if (c6 == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione una ocurrencia");
                } else {
                    int c0 = (int) tbAsistencia.getValueAt(i, 0);
                    String c7 = (String) tbAsistencia.getValueAt(i, 7);

                    dto.setIdpersona(c0);
                    dto.setFecha(fecha);
                    dto.setOcurrencia(c6.getDescripcion());
                    dto.setDetalle(c7);

                    proc.actualizar(dto);
                }
                System.out.println("vuelta: " + i + f);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAsistencia;
    private com.toedter.calendar.JDateChooser txtFecha;
    // End of variables declaration//GEN-END:variables
}
