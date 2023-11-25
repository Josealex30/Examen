/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Forms;

import BD.ClsBD;
import Class.ClsContactos;
import Class.ClsGlobales;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinva
 */
public class FrmContactos extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmContactos
     */
        ClsContactos contactos = new ClsContactos();
    
    public FrmContactos() {
        initComponents();
        contactos.ObtenerDatosMemoria();
        RellenarTabla();
        LlenarLista("");
    }
    
        public void LlenarLista(String buscar) {
        DefaultTableModel modelo = (DefaultTableModel) tblContactos.getModel();
        modelo.setRowCount(0);

        for (ClsContactos contacto : ClsBD.jsonContactos) {
            Object[] row = new Object[]{contacto.idContacto,
                                        contacto.cedula,
                                        contacto.nombre,
                                        contacto.apellidos,
                                        contacto.telefono,
                                        contacto.correo};
            
            if (buscar.equals("")) {
                modelo.addRow(row);
            } else if (String.valueOf(contacto.idContacto).toLowerCase().contains(buscar) ||
                       contacto.cedula.toLowerCase().contains(buscar) ||
                       contacto.nombre.toLowerCase().contains(buscar) ||
                       contacto.apellidos.toLowerCase().contains(buscar) ||
                       contacto.telefono.toLowerCase().contains(buscar) ||
                       contacto.correo.toLowerCase().contains(buscar)) {
                modelo.addRow(row);
            }
        }
    }
    
       private void RellenarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.tblContactos.getModel();
        modelo.setRowCount(0);
        
        for (ClsContactos contacto : ClsBD.jsonContactos) {
            Object[] row = new Object[] { contacto.idContacto, contacto.cedula, contacto.nombre, contacto.apellidos, contacto.telefono, contacto.correo };
            modelo.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAgregarContacto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContactos = new javax.swing.JTable();
        btnRefrescar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setText("Listado de Contactos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        btnAgregarContacto.setBackground(new java.awt.Color(0, 51, 153));
        btnAgregarContacto.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnAgregarContacto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarContacto.setText("Agregar contacto");
        btnAgregarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarContactoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 160, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar contacto:");

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 260, 50));

        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Cedula", "Nombre", "Apellidos", "Telefono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContactosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContactos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 680, 180));

        btnRefrescar.setBackground(new java.awt.Color(51, 153, 0));
        btnRefrescar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setText("Agregar contacto");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRefrescar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 160, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarContactoActionPerformed
        ClsGlobales.idSeleccionado = -1;
        FrmAgregarEditarContacto frmAgregar = new FrmAgregarEditarContacto();
        frmAgregar.setVisible(true);
    }//GEN-LAST:event_btnAgregarContactoActionPerformed

    private void tblContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContactosMouseClicked
        /*OBTENGO EL ID DE LA FILA SELECCIONADA Y 
        LA GUARDO EN UNA VARIABLE ESTATICA PARA 
        PODER CONSULTAR Y ASI INICIALIZAR 
        LOS DATOS EN EL OTRO FORMULARIO*/
        int selectedRow = tblContactos.getSelectedRow();
        Object idValue = tblContactos.getValueAt(selectedRow, 0);

        if (idValue != null) {
            ClsGlobales.idSeleccionado = Integer.parseInt(idValue.toString());
            System.out.println("ID seleccionado al dar click: " + ClsGlobales.idSeleccionado);
            FrmAgregarEditarContacto frmAgregar = new FrmAgregarEditarContacto();
            frmAgregar.setVisible(true);
        }
    }//GEN-LAST:event_tblContactosMouseClicked

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        RellenarTabla();
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        LlenarLista(txtBuscar.getText().toLowerCase());
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarContacto;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblContactos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
