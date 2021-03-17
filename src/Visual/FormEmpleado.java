package Visual;

import Logica.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FormEmpleado extends javax.swing.JFrame {

    Conexion connect = new Conexion();
    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    Usuarios Users = new Usuarios();
    SQLEmpleados SqlModel = new SQLEmpleados();

    Icon OkIcon = new ImageIcon(getClass().getResource("../Images/like1.png"));
    Icon BadIcon = new ImageIcon(getClass().getResource("../Images/unlike1.png"));
    Icon handIcon = new ImageIcon(getClass().getResource("../Images/hand1.png"));
    Icon cancelIcon = new ImageIcon(getClass().getResource("../Images/cancel.png"));
    Icon questionIcon = new ImageIcon(getClass().getResource("../Images/pregunta.png"));

    public FormEmpleado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnPrincipal = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnResetPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(300, 300));

        pnPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnPrincipal.setLayout(null);

        lblEncabezado.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("CREACION DE NUEVO EMPLEADO");
        pnPrincipal.add(lblEncabezado);
        lblEncabezado.setBounds(10, 11, 421, 28);

        lblDocumento.setBackground(new java.awt.Color(255, 255, 255));
        lblDocumento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDocumento.setText("Documento");
        pnPrincipal.add(lblDocumento);
        lblDocumento.setBounds(90, 70, 90, 22);

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");
        pnPrincipal.add(lblNombre);
        lblNombre.setBounds(90, 100, 90, 22);

        lblApellido.setBackground(new java.awt.Color(255, 255, 255));
        lblApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApellido.setText("Apellido");
        pnPrincipal.add(lblApellido);
        lblApellido.setBounds(90, 130, 90, 22);

        lblTelefono.setBackground(new java.awt.Color(255, 255, 255));
        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setText("Telefono");
        pnPrincipal.add(lblTelefono);
        lblTelefono.setBounds(90, 160, 90, 22);

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario");
        pnPrincipal.add(lblUsuario);
        lblUsuario.setBounds(90, 190, 90, 22);

        lblContraseña.setBackground(new java.awt.Color(255, 255, 255));
        lblContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña");
        pnPrincipal.add(lblContraseña);
        lblContraseña.setBounds(90, 220, 90, 22);

        txtDocumento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDocumento.setToolTipText("");
        txtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusLost(evt);
            }
        });
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        pnPrincipal.add(txtDocumento);
        txtDocumento.setBounds(200, 70, 150, 30);

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        pnPrincipal.add(txtNombre);
        txtNombre.setBounds(200, 100, 150, 30);

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        pnPrincipal.add(txtApellido);
        txtApellido.setBounds(200, 130, 150, 30);

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        pnPrincipal.add(txtTelefono);
        txtTelefono.setBounds(200, 160, 150, 30);

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        pnPrincipal.add(txtUsuario);
        txtUsuario.setBounds(200, 190, 150, 30);

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        pnPrincipal.add(jSeparator1);
        jSeparator1.setBounds(20, 45, 411, 10);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnPrincipal.add(jSeparator2);
        jSeparator2.setBounds(180, 60, 10, 190);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnPrincipal.add(btnGuardar);
        btnGuardar.setBounds(140, 270, 160, 33);

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancelar 30.20.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnPrincipal.add(btnCancelar);
        btnCancelar.setBounds(400, 70, 30, 20);

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        pnPrincipal.add(txtContraseña);
        txtContraseña.setBounds(200, 220, 150, 30);

        btnBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lupa 30.20.png"))); // NOI18N
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });
        pnPrincipal.add(btnBuscarUsuario);
        btnBuscarUsuario.setBounds(360, 70, 30, 20);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash1.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnPrincipal.add(btnEliminar);
        btnEliminar.setBounds(380, 110, 40, 30);

        btnResetPassword.setBackground(new java.awt.Color(255, 255, 255));
        btnResetPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resetUser.png"))); // NOI18N
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });
        pnPrincipal.add(btnResetPassword);
        btnResetPassword.setBounds(370, 210, 40, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtDocumento.setBackground(Color.white);
        txtNombre.setBackground(Color.white);
        txtApellido.setBackground(Color.white);
        txtTelefono.setBackground(Color.white);
        txtUsuario.setBackground(Color.white);
        txtDocumento.setEnabled(true);
        txtContraseña.setEnabled(true);
        txtDocumento.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtTelefono.setText(null);
        txtUsuario.setText(null);
        txtContraseña.setText(null);
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        txtDocumento.setBackground(Color.white);
        txtNombre.setBackground(Color.white);
        txtApellido.setBackground(Color.white);
        txtTelefono.setBackground(Color.white);
        txtUsuario.setBackground(Color.white);
        if (txtDocumento.getText().equals("") || txtNombre.getText().equals("")
                || txtApellido.getText().equals("")
                || txtTelefono.getText().equals("") || txtUsuario.getText().equals("")
                || txtContraseña.getText().equals("")) {
            //JOptionPane.showMessageDialog(null, "Hay campos Vacios");
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);

            if (txtDocumento.getText().equals("")) {
                txtDocumento.setBackground(Color.red);
            }
            if (txtNombre.getText().equals("")) {
                txtNombre.setBackground(Color.red);
            }
            if (txtApellido.getText().equals("")) {
                txtApellido.setBackground(Color.red);
            }
            if (txtTelefono.getText().equals("")) {
                txtTelefono.setBackground(Color.red);
            }
            if (txtUsuario.getText().equals("")) {
                txtUsuario.setBackground(Color.red);
            }
        } else {
            Users.setUsuario(txtUsuario.getText());
            Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
            txtUsuario.setBackground(Color.white);
            txtDocumento.setBackground(Color.white);
            if (txtDocumento.isEnabled()) {

                if (SqlModel.DocumentoExiste(Users)) {
                    JOptionPane.showMessageDialog(null, "El Documento Ingresado Ya Existe\nPara Actualizar, Presione el Boton Buscar");
                    txtDocumento.setBackground(Color.red);
                } else if (SqlModel.UsuarioExiste(Users)) {
                    JOptionPane.showMessageDialog(null, "El Usuario Ingresado Ya Existe");
                    txtUsuario.setBackground(Color.red);
                } else {
                    Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                    Users.setNomEmpleado(txtNombre.getText());
                    Users.setApeEmpleado(txtApellido.getText());
                    Users.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                    Users.setUsuario(txtUsuario.getText());
                    Users.setContraseña(Encrypt.sha1(txtContraseña.getPassword().toString()));
                    SqlModel.registro(Users);
                    //JOptionPane.showMessageDialog(null, "Se Ingreso el Usuario Exitosamente");
                    JOptionPane.showMessageDialog(null, "Se Ingresaron los Datos Exitosamente", "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, OkIcon);
                }
            } else {
                Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                Users.setNomEmpleado(txtNombre.getText());
                Users.setApeEmpleado(txtApellido.getText());
                Users.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                Users.setUsuario(txtUsuario.getText());
                Users.setContraseña(txtContraseña.getPassword().toString());
                SqlModel.actualizacion(Users);
                //JOptionPane.showMessageDialog(null, "Se procedera con la actualizacion de datos");
                JOptionPane.showMessageDialog(null, "Se Actualizaron los Datos Exitosamente", "Actualizacion Exitosa", JOptionPane.PLAIN_MESSAGE, OkIcon);

            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusLost
        if (!txtDocumento.equals("")) {
            txtContraseña.setText(txtDocumento.getText());
        }
    }//GEN-LAST:event_txtDocumentoFocusLost

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        txtUsuario.setBackground(Color.white);
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        txtDocumento.setBackground(Color.white);
        txtNombre.setBackground(Color.white);
        txtApellido.setBackground(Color.white);
        txtTelefono.setBackground(Color.white);
        txtUsuario.setBackground(Color.white);
        if (!txtDocumento.getText().equals("")) {
            //con = connect.getConection();
            Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));

            if (SqlModel.ConsultarUsuarios(Users)) {
                txtNombre.setText(Users.getNomEmpleado());
                txtApellido.setText(Users.getApeEmpleado());
                txtTelefono.setText(String.valueOf(Users.getTelEmpleado()));
                txtUsuario.setText(Users.getUsuario());
                txtContraseña.setText(Users.getContraseña());
                txtContraseña.setEnabled(false);
                txtDocumento.setEnabled(false);
                btnGuardar.setText("Actualizar");
            } else {
                txtNombre.setText(null);
                txtApellido.setText(null);
                txtTelefono.setText(null);
                txtUsuario.setText(null);
                txtContraseña.setText(null);
                txtContraseña.setEnabled(true);
                btnGuardar.setText("Guardar");
                JOptionPane.showMessageDialog(null, "Usuario No Existe");
            }
        } else {

            //JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtDocumento.isEnabled() == true) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar el usuario seleccionado?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon);

            //JOptionPane.showConfirmDialog(null, "Por favor diligencie los campos correspondientes", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, 2);
            //JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar el usuario seleccionado?");
            System.out.println(opc);
            switch (opc) {
                case 0: //Opcion SI
                    JOptionPane.showMessageDialog(null, "Eliminacion Exitosa", "Exito", JOptionPane.PLAIN_MESSAGE, OkIcon);
                    break;
                case 1: //Opcion NO
                    JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminacion", "Cancelado por Usuario", JOptionPane.PLAIN_MESSAGE, cancelIcon);
                    break;
            }

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        connect.getConection();
        if (txtDocumento.getText().equals("") || txtNombre.getText().equals("")
                || txtApellido.getText().equals("")
                || txtTelefono.getText().equals("") || txtUsuario.getText().equals("")
                || txtContraseña.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);

            if (txtDocumento.getText().equals("")) {
                txtDocumento.setBackground(Color.red);
            }
            if (txtNombre.getText().equals("")) {
                txtNombre.setBackground(Color.red);
            }
            if (txtApellido.getText().equals("")) {
                txtApellido.setBackground(Color.red);
            }
            if (txtTelefono.getText().equals("")) {
                txtTelefono.setBackground(Color.red);
            }
            if (txtUsuario.getText().equals("")) {
                txtUsuario.setBackground(Color.red);
            }
        } else {

            Users.setUsuario(txtUsuario.getText());
            Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
            if (txtDocumento.isEnabled() == true) {
                JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes y presione buscar",
                        "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
            } else {
                if (SqlModel.UsuarioExiste(Users)) {
                    int opc = JOptionPane.showConfirmDialog(null,
                            "¿Esta seguro de querer restablecer la contraseña del usuario seleccionado?",
                            "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon);
                    switch (opc) {
                        case 0: //Opcion SI
                            if (SqlModel.restablecerPassword(Users)) {
                                JOptionPane.showMessageDialog(null,
                                        "Restablecimiento Exitoso\nUtilice la cedula de ciudadania para ingresar",
                                        "Exito", JOptionPane.PLAIN_MESSAGE, OkIcon);

                            } else {
                                JOptionPane.showMessageDialog(null, new JLabel(
                                        "<html><center>Restablecimiento Erroneo<br>"
                                        + "Verifique los Datos e Intente de Nuevo</center><html>",
                                        JLabel.CENTER), "Error", JOptionPane.PLAIN_MESSAGE, BadIcon);
                            }

                            break;
                        case 1: //Opcion NO
                            JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminacion",
                                    "Cancelado por Usuario", JOptionPane.PLAIN_MESSAGE, cancelIcon);
                            break;
                    }

                } else {
                }
            }
        }
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        if (txtDocumento.getText().length() == 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 10 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyTyped

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
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnResetPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnPrincipal;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
