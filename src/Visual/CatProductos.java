package Visual;

import Logica.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CatProductos extends javax.swing.JFrame {

    Conexion connect = new Conexion();
    Connection con;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ResultSetMetaData mdrs = null;
    String sql = null;
    Productos producto = new Productos();
    SentenciasSQL sqlModel = new SentenciasSQL();
    Icon OkIcon = new ImageIcon(getClass().getResource("../Images/like1.png"));
    Icon BadIcon = new ImageIcon(getClass().getResource("../Images/unlike1.png"));
    Icon handIcon = new ImageIcon(getClass().getResource("../Images/hand1.png"));

    public void cargarDatos(String consulta) {
        DefaultTableModel modelo = new DefaultTableModel();
        tbCategorias.setBackground(Color.white);
        try {
            tbCategorias.setModel(modelo);
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            mdrs = rs.getMetaData();
            int columnas = mdrs.getColumnCount();
            modelo.addColumn("Codigo");

            modelo.addColumn("Descripcion");

            int anchoCol[] = {100, 200};
            for (int i = 0; i < columnas; i++) {
                tbCategorias.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    public CatProductos() {
        initComponents();
        con = connect.getConection();
        sql = "select * from categoria_productos";
        cargarDatos(sql);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        spTabla = new javax.swing.JScrollPane();
        tbCategorias = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        spTabla.setBackground(new java.awt.Color(255, 255, 255));
        spTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbCategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCategorias.setGridColor(new java.awt.Color(102, 102, 102));
        tbCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoriasMouseClicked(evt);
            }
        });
        spTabla.setViewportView(tbCategorias);

        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsertar.setText("INSERTAR");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCodigo.setText("Codigo");

        lblDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDescripcion.setText("Descripcion");

        txtDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoKeyReleased(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnInsertar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnModificar)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addComponent(txtCodigo))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(btnEliminar))))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed


    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        String texto = txtBuscar.getText();

        sql = "select * from categoria_productos where CodCategoria like '%" + texto
                + "%' or Descripcion like '%" + texto + "%'";
        cargarDatos(sql);

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void tbCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoriasMouseClicked
        int fila = tbCategorias.getSelectedRow();
        producto.setCodProducto(tbCategorias.getValueAt(fila, 0).toString());
        producto.setDescripcionCategoria(tbCategorias.getValueAt(fila, 1).toString());
        //String Codigo = tbCategorias.getValueAt(fila, 0).toString();
        //String Descripcion = tbCategorias.getValueAt(fila, 1).toString();
        /*if (sqlModel.crearProducto(producto)) {
            System.out.println("Ingreso Exitoso");
        }else{
            System.out.println("ERROR");
            
        }*/
        txtCodigo.setText(producto.getCodProducto());
        txtDescripcion.setText(producto.getDescripcionCategoria());

    }//GEN-LAST:event_tbCategoriasMouseClicked

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        producto.setCodCategoria(txtCodigo.getText());
        producto.setDescripcionCategoria(txtDescripcion.getText());
        //String Codigo = tbCategorias.getValueAt(fila, 0).toString();
        //String Descripcion = tbCategorias.getValueAt(fila, 1).toString();
        if (txtCodigo.getText().equals("") || txtDescripcion.getText().equals("")) {
            //JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes");
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);

        } else {
            if (sqlModel.ExisteCodCategoria(producto)) {
                //JOptionPane.showMessageDialog(null, "El Codigo ingresado ya existe\nSi lo va a actualizar presione modificar");
                JOptionPane.showMessageDialog(null, "El Codigo ingresado ya existe\n"
                        + "Si lo va a actualizar presione modificar", "Dato ya existe", JOptionPane.PLAIN_MESSAGE, BadIcon);

            } else {
                JOptionPane.showMessageDialog(null, "Se Creo la Categoria Exitosamente", "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, OkIcon);
                if (sqlModel.crearCategoria(producto)) { //System.out.println("Ingreso Exitoso");
                    cargarDatos(sql);
                } else {
                    System.out.println("ERROR");

                }
            }
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        producto.setCodCategoria(txtCodigo.getText());
        producto.setDescripcionCategoria(txtDescripcion.getText());
        if (txtCodigo.getText().equals("") || txtDescripcion.getText().equals("")) {
            //JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes");
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        } else {
            if (sqlModel.ExisteCodCategoria(producto) || sqlModel.ExisteDescripcionCategoria(producto)) {
                if (sqlModel.ModificarCategoria(producto)) {
                    JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente", "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, OkIcon);
                    cargarDatos(sql);
                } else {
                    System.out.println("ERROR");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos para ser actualizados", "Error de Actualizacion", JOptionPane.PLAIN_MESSAGE, BadIcon);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        producto.setCodCategoria(txtCodigo.getText());
        producto.setDescripcionCategoria(txtDescripcion.getText());
        if (txtCodigo.getText().equals("") || txtDescripcion.getText().equals("")) {
            //JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes");
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes\n"
                    + "o seleccione un dato de la tabla", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        } else {
            if (!sqlModel.ExisteCodCategoria(producto) || !sqlModel.ExisteDescripcionCategoria(producto)) {

                JOptionPane.showMessageDialog(null, "Los datos ingresados no coindiden", "Error de eliminacion", JOptionPane.PLAIN_MESSAGE, BadIcon);
            } else {
                JOptionPane.showMessageDialog(null, "Se eliminaron los datos exitosamente", "Eliminacion exitosa", JOptionPane.PLAIN_MESSAGE, OkIcon);
                sqlModel.EliminarCategoria(producto);
            }
        }
        cargarDatos(sql);
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CatProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JScrollPane spTabla;
    private javax.swing.JTable tbCategorias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
