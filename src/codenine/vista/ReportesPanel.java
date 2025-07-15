package codenine.vista;

import codenine.dto.ReporteDTO;
import codenine.modelo.ReporteImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import codenine.modelo.VistaMensajes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.base.Strings;

public class ReportesPanel extends javax.swing.JPanel {
    private Menu menuPrincipal;
    public ReportesPanel(Menu menu) {
        initComponents();
        this.menuPrincipal = menu;
        VistaMensajes.mensaje();
    }

    void CargarTabla(ReporteDTO dto) {
        ReporteImpl proc = new ReporteImpl();
        tbReporte.setModel(proc.tablaReporte(dto));
    }

    
    private Date[] mergeSort(Date[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middle = array.length / 2;
        Date[] left = new Date[middle];
        Date[] right = new Date[array.length - middle];

        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private Date[] merge(Date[] left, Date[] right) {
        Date[] result = new Date[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].after(right[j])) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReporte = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cartel = new javax.swing.JPanel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtFechaFin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        NUEVOS = new javax.swing.JButton();
        VIEJOS = new javax.swing.JButton();
        lista = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1000, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tbReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbReporte);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 239, 988, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("REPORTE DE ASISTENCIA DEL PERSONAL");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        cartel.setBackground(new java.awt.Color(255, 255, 255));
        cartel.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario"));

        jLabel1.setText("Fecha Inicio:");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Fin:");

        NUEVOS.setText("ASCENDENTE");
        NUEVOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUEVOSActionPerformed(evt);
            }
        });

        VIEJOS.setText("DESCENDENTE");
        VIEJOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEJOSActionPerformed(evt);
            }
        });

        lista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "A. Paterno", "A. Materno", "Sexo", "Cargo", "Area", "Ocurrencia", "Fecha" }));
        lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cartelLayout = new javax.swing.GroupLayout(cartel);
        cartel.setLayout(cartelLayout);
        cartelLayout.setHorizontalGroup(
            cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartelLayout.createSequentialGroup()
                        .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(NUEVOS, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cartelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VIEJOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(11, 11, 11))
        );
        cartelLayout.setVerticalGroup(
            cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cartelLayout.createSequentialGroup()
                        .addGroup(cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(cartelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VIEJOS, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NUEVOS, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lista, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        add(cartel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 930, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/regresar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        btnExportar.setText("Exportar a Excel");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private Date[] mergeAbajo(Date[] left, Date[] right) {
        Date[] result = new Date[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].before(right[j])) {  
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
    private Date[] mergeSortabajo(Date[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middle = array.length / 2;
        Date[] left = new Date[middle];
        Date[] right = new Date[array.length - middle];

        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        left = mergeSortabajo(left);
        right = mergeSortabajo(right);
        return mergeAbajo(left, right);
    }
    
    
    private void ordenarPorFecha() {
        int rowCount = tbReporte.getRowCount();
        Date[] fechas = new Date[rowCount];

        for (int i = 0; i < rowCount; i++) {
            try {
                String fechaStr = tbReporte.getValueAt(i, 7).toString(); 
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fechas[i] = sdf.parse(fechaStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al parsear fechas: " + e.getMessage());
                return; 
            }
        }

        fechas = mergeSort(fechas);

        for (int i = 0; i < rowCount; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tbReporte.setValueAt(sdf.format(fechas[i]), i, 7); 
        }
    }

    private void ordenarPorFecha2() {
        int rowCount = tbReporte.getRowCount();
        Date[] fechas = new Date[rowCount];

        for (int i = 0; i < rowCount; i++) {
            try {
                String fechaStr = tbReporte.getValueAt(i, 7).toString(); 
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                fechas[i] = sdf.parse(fechaStr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al parsear fechas: " + e.getMessage());
                return; 
            }
        }

        fechas = mergeSortabajo(fechas);

        for (int i = 0; i < rowCount; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tbReporte.setValueAt(sdf.format(fechas[i]), i, 7); 
        }
    }
    


    private void ordenarPorColumna(int columnIndex, boolean ascendente) {
        DefaultTableModel model = (DefaultTableModel) tbReporte.getModel();
        int rowCount = model.getRowCount();
        List<Object[]> filas = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            Object[] fila = new Object[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                fila[j] = model.getValueAt(i, j);
            }
            filas.add(fila);
        }

        if (columnIndex == 7) { 
            if (ascendente) {
                ordenarPorFecha(); 
            } else {
                ordenarPorFecha2();  
            }
        } else {  
            filas.sort((fila1, fila2) -> {
                Object valor1 = fila1[columnIndex];
                Object valor2 = fila2[columnIndex];

                if (valor1 instanceof Comparable && valor2 instanceof Comparable) {
                    Comparable<Object> comparable1 = (Comparable<Object>) valor1;
                    Comparable<Object> comparable2 = (Comparable<Object>) valor2;
                    return ascendente ? comparable1.compareTo(comparable2) : comparable2.compareTo(comparable1);
                }
                return 0; 
            });

            model.setRowCount(0);
            for (Object[] fila : filas) {
                model.addRow(fila);
            }
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (menuPrincipal != null) {
            menuPrincipal.limpiarPanelContenido();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // 1. Verificar si hay datos en la tabla
        if (tbReporte.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay datos en la tabla para exportar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 2. Abrir un diálogo para que el usuario elija dónde guardar el archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte como");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de Excel (*.xlsx)", "xlsx"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            // Asegurarse de que el archivo tenga la extensión .xlsx
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".xlsx")) {
                fileToSave = new java.io.File(filePath + ".xlsx");
            }

            // 3. Crear el libro y la hoja de Excel
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Reporte de Asistencia");

            // 4. Escribir las cabeceras
            DefaultTableModel model = (DefaultTableModel) tbReporte.getModel();
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < model.getColumnCount(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(model.getColumnName(i));
            }

            // 5. Escribir los datos de las filas
            for (int i = 0; i < model.getRowCount(); i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    Cell cell = row.createCell(j);
                    Object value = model.getValueAt(i, j);
                    cell.setCellValue(Strings.nullToEmpty(value != null ? value.toString() : null));
                }
            }

            // 6. Guardar el archivo
            try (FileOutputStream outputStream = new FileOutputStream(fileToSave)) {
                workbook.write(outputStream);
                JOptionPane.showMessageDialog(this, "Reporte exportado exitosamente a:\n" + fileToSave.getAbsolutePath(), "Exportación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaActionPerformed

    private void VIEJOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEJOSActionPerformed

        ordenarPorColumna(lista.getSelectedIndex(), false);
    }//GEN-LAST:event_VIEJOSActionPerformed

    private void NUEVOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUEVOSActionPerformed
        ordenarPorColumna(lista.getSelectedIndex(), true);
    }//GEN-LAST:event_NUEVOSActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ReporteDTO dto = new ReporteDTO();
        Date date1 = txtFechaInicio.getDate();
        Date date2 = txtFechaFin.getDate();

        if (date1 == null) {
            JOptionPane.showMessageDialog(null, "Debe Colocar Fecha Inicio");
        } else if (date2 == null) {
            JOptionPane.showMessageDialog(null, "Debe Colocar Fecha Fin");
        } else {

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicio = null;
            String fechaFin = null;
            fechaInicio = format1.format(date1);
            fechaFin = format2.format(date2);

            dto.setFechaInicio(fechaInicio);
            dto.setFechaFin(fechaFin);

            CargarTabla(dto);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NUEVOS;
    private javax.swing.JButton VIEJOS;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JPanel cartel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lista;
    private javax.swing.JTable tbReporte;
    private com.toedter.calendar.JDateChooser txtFechaFin;
    private com.toedter.calendar.JDateChooser txtFechaInicio;
    // End of variables declaration//GEN-END:variables
}
