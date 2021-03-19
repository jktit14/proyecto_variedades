package Visual;

import Logica.Verified.Conexion;
import Logica.Verified.Productos;
import Logica.SQLProductos;
import Logica.SentenciasSQL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormProducto extends JFrame {

    Conexion connect = new Conexion();
    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ResultSetMetaData mdrs = null;
    String sql = "",
            sqlTabla = "select producto.CodProducto, producto.Descripcion,categoria_productos.Descripcion "
            + "from producto, categoria_productos "
            + "where producto.CodCategoria = categoria_productos.CodCategoria";

    public SQLProductos SQLProducto = new SQLProductos();
    public SentenciasSQL sqlModel = new SentenciasSQL();
    public Productos producto = new Productos();

    Icon OkIcon = new ImageIcon(getClass().getResource("../Images/like1.png"));
    Icon BadIcon = new ImageIcon(getClass().getResource("../Images/unlike1.png"));
    Icon handIcon = new ImageIcon(getClass().getResource("../Images/hand1.png"));
    Icon cancelIcon = new ImageIcon(getClass().getResource("../Images/cancel.png"));
    Icon questionIcon = new ImageIcon(getClass().getResource("../Images/pregunta.png"));

    public FormProducto() {
        //SQLProducto.setConnection(connect.getConnection());
        //connection = connect.getConnection();
        initComponents();
        //cargarListaCategorias();
        //cargarDatos(sqlTabla);
        this.setLocationRelativeTo(null);
    }

    public void cargarDatos(String consulta) {
        connection = connect.getConnection();
        SQLProducto.setConnection(connection);
        int columnas;
        DefaultTableModel modelo = new DefaultTableModel();
        tbProductos.setBackground(Color.white);
        tbProductos.setModel(modelo);
        try {
            ps = connection.prepareStatement(consulta);
            //System.out.println(ps);
            rs = ps.executeQuery();
            mdrs = rs.getMetaData();
            columnas = mdrs.getColumnCount();
            modelo.addColumn("Codigo");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Categoria");

            int anchoCol[] = {100, 200, 200};
            for (int i = 0; i < columnas; i++) {
                tbProductos.getColumnModel().getColumn(i).setPreferredWidth(anchoCol[i]);
            }
            while (rs.next()) {
                Object[] filas = new Object[columnas];

                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

    }

    public void cargarListaCategorias() {
        connection = connect.getConnection();
        int columnas;
        try {
            ps = connection.prepareStatement("select * from categoria_productos");
            rs = ps.executeQuery();
            mdrs = rs.getMetaData();
            columnas = mdrs.getColumnCount();

            while (rs.next()) {
                cbCategoria.addItem(rs.getObject(2).toString());
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        spTabla = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        btnInsertar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        spTabla.setBackground(new java.awt.Color(255, 255, 255));
        spTabla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProductos.setGridColor(new java.awt.Color(102, 102, 102));
        tbProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosMouseClicked(evt);
            }
        });
        spTabla.setViewportView(tbProductos);

        btnInsertar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsertar.setText("INSERTAR");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        txtBuscar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtBuscarInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
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

        lblCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCategoria.setText("Categoria");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
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
                        .addComponent(spTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnInsertar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnModificar))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(btnEliminar)))))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosMouseClicked
        SQLProducto.setConnection(connect.getConnection());
        int fila = tbProductos.getSelectedRow();
        producto.setCodProducto(tbProductos.getValueAt(fila, 0).toString());
        producto.setDescripcion(tbProductos.getValueAt(fila, 1).toString());
        producto.setDescripcionCategoria(tbProductos.getValueAt(fila, 2).toString());
        producto.setCodCategoria(SQLProducto.ObtenerCodCategoria(tbProductos.getValueAt(fila, 2).toString()));

        txtCodigo.setText(producto.getCodProducto());
        txtDescripcion.setText(producto.getDescripcion());
        cbCategoria.setSelectedItem(producto.getDescripcionCategoria());
        //.setText(producto.getDescripcionCategoria());

        SQLProducto.setCodProducto(tbProductos.getValueAt(fila, 0).toString());
        SQLProducto.setDescProducto(tbProductos.getValueAt(fila, 1).toString());
        SQLProducto.setCodCategoria(SQLProducto.ObtenerCodCategoria(tbProductos.getValueAt(fila, 2).toString()));
        SQLProducto.setCodCategoria(SQLProducto.ObtenerCodCategoria(tbProductos.getValueAt(fila, 2).toString()));

    }//GEN-LAST:event_tbProductosMouseClicked

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed

        if (txtCodigo.getText().equals("") || txtDescripcion.getText().equals("") || cbCategoria.getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        } else {
            producto.setCodProducto(txtCodigo.getText());
            producto.setDescripcion(txtDescripcion.getText());
            //producto.setDescripcionCategoria(cbCategoria.getSelectedItem().toString());
            producto.setCodCategoria(SQLProducto.ObtenerCodCategoria(cbCategoria.getSelectedItem().toString()));
            if (SQLProducto.ExisteCodProducto(producto)) {
                JOptionPane.showMessageDialog(null, "El Codigo ingresado ya existe\n"
                        + "Si lo va a actualizar presione modificar", "Dato ya existe",
                        JOptionPane.PLAIN_MESSAGE, BadIcon);

            } else {
                if (SQLProducto.crearProducto(producto)) { //System.out.println("Ingreso Exitoso");
                    JOptionPane.showMessageDialog(null, "Se Creo la Categoria Exitosamente",
                            "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, OkIcon);
                } else {
                    System.out.println("ERROR");

                }
            }
            cargarDatos(sqlTabla);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String texto = txtBuscar.getText();
        cargarDatos(sqlTabla + " and (producto.CodProducto like '%" + texto
                + "%' or producto.Descripcion like '%" + texto
                + "%' or categoria_productos.Descripcion like '%" + texto + "%')");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoKeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (txtCodigo.getText().equals("") || txtDescripcion.getText().equals("") || cbCategoria.getSelectedItem().equals("Seleccione")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);

        } else {
            producto.setCodProducto(SQLProducto.getCodProducto());
            producto.setDescripcion(SQLProducto.getDescProducto());
            producto.setCodCategoria(SQLProducto.getCodCategoria());
            if (SQLProducto.ExisteProducto(producto)) {

                producto.setCodProducto(txtCodigo.getText());
                producto.setDescripcion(txtDescripcion.getText());
                producto.setCodCategoria(SQLProducto.ObtenerCodCategoria(cbCategoria.getSelectedItem().toString()));

                if (producto.getCodProducto().equals(SQLProducto.getCodProducto())
                        && producto.getDescripcion().equals(SQLProducto.getDescProducto())
                        && producto.getCodCategoria().equals(SQLProducto.getCodCategoria())) {
                    JOptionPane.showMessageDialog(null, "<html><center>No Se Actualizaron Los Datos,<br>"
                            + "Los Datos Ingresados Son Iguales A Los Almacenados</center><html>", "Actualización Erronea", JOptionPane.PLAIN_MESSAGE, BadIcon);
                } else {

                    if (producto.getCodProducto().equals(SQLProducto.getCodProducto())) {
                        if (SQLProducto.ModificarProducto(producto)) {
                            JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                    "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, OkIcon);
                        } else {
                            System.out.println("ERROR");
                        }
                    } else {
                        if (SQLProducto.ExisteCodProducto(producto)) {
                            JOptionPane.showMessageDialog(null, "El Codigo Ingresado Ya Existe", "No Se Puede Modificar",
                                    JOptionPane.PLAIN_MESSAGE, BadIcon);
                        } else {
                            if (SQLProducto.ModificarProducto(producto)) {
                                JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente",
                                        "Actualización Exitosa", JOptionPane.PLAIN_MESSAGE, OkIcon);
                            } else {
                                System.out.println("ERROR");
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "<html><center>No Se Encontraron Datos Para Ser Actualizados,<br>"
                        + "Seleccione El Valor De La Tabla e Intente De Nuevo</center><html>",
                        "Error de Actualizacion", JOptionPane.PLAIN_MESSAGE, BadIcon);
            }
        }
        txtBuscar.setText("");
        cargarDatos(sqlTabla);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //connection=connect.getConnection();
        //producto.setCodProducto(txtCodigo.getText().toString());
        sql = "select * from producto "
                + "where CodProducto=?";
        try {
            //System.out.println(sql);
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getCodProducto());
            rs = ps.executeQuery();
            if (rs.next()) {
                //System.out.println("OK");
                //return true;
            } else {
                System.out.println("Error");
                //return false;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(SentenciasSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Excepcion: " + ex);
            //return false;
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txtBuscarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtBuscarInputMethodTextChanged

    }//GEN-LAST:event_txtBuscarInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JScrollPane spTabla;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
