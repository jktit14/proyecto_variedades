package Visual.Ok;

import Logica.Verified.Conexion;
import Logica.Verified.Encrypt;
import Logica.Verified.SQLUsuarios;
import Logica.Verified.Usuarios;
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
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    Usuarios Users = new Usuarios();
    //SQLEmpleados SqlModel = new SQLEmpleados();
    SQLUsuarios SQLUsuario = new SQLUsuarios();

    Icon OkIcon = new ImageIcon(getClass().getResource("../../Images/like1.png"));
    Icon BadIcon = new ImageIcon(getClass().getResource("../../Images/unlike1.png"));
    Icon handIcon = new ImageIcon(getClass().getResource("../../Images/hand1.png"));
    Icon cancelIcon = new ImageIcon(getClass().getResource("../../Images/cancel.png"));
    Icon questionIcon = new ImageIcon(getClass().getResource("../../Images/pregunta.png"));
    Icon cancel1Icon = new ImageIcon(getClass().getResource("../../Images/Cancel1.png"));

    public FormEmpleado() {
        SQLUsuario.setConnection(connect.getConnection());
        initComponents();
        this.setLocationRelativeTo(null);
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

        pnPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        lblEncabezado.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("CREACION DE NUEVO EMPLEADO");

        lblDocumento.setBackground(new java.awt.Color(255, 255, 255));
        lblDocumento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDocumento.setText("Documento");

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");

        lblApellido.setBackground(new java.awt.Color(255, 255, 255));
        lblApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblApellido.setText("Apellido");

        lblTelefono.setBackground(new java.awt.Color(255, 255, 255));
        lblTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefono.setText("Telefono");

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario");

        lblContraseña.setBackground(new java.awt.Color(255, 255, 255));
        lblContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña.setText("Contraseña");

        txtDocumento.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDocumento.setToolTipText("");
        txtDocumento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDocumentoFocusLost(evt);
            }
        });
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancelar 30.20.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        btnBuscarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Lupa 30.20.png"))); // NOI18N
        btnBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuarioActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/trash1.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnResetPassword.setBackground(new java.awt.Color(255, 255, 255));
        btnResetPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/resetUser.png"))); // NOI18N
        btnResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnPrincipalLayout = new javax.swing.GroupLayout(pnPrincipal);
        pnPrincipal.setLayout(pnPrincipalLayout);
        pnPrincipalLayout.setHorizontalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnPrincipalLayout.setVerticalGroup(
            pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPrincipalLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblEncabezado)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addComponent(lblDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnPrincipalLayout.createSequentialGroup()
                                .addGroup(pnPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnResetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addComponent(btnGuardar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDocumentoFocusLost
        if (!txtDocumento.equals("")) {
            txtContraseña.setText(txtDocumento.getText());
        }
    }//GEN-LAST:event_txtDocumentoFocusLost

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped

        if (!isNum(evt.getKeyChar())) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, cancel1Icon);
            evt.consume();
        }
        if (txtDocumento.getText().length() == 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 10 caracteres");
            evt.consume();
        }

    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        txtUsuario.setBackground(Color.white);
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        txtDocumento.setBackground(Color.white);
        txtNombre.setBackground(Color.white);
        txtApellido.setBackground(Color.white);
        txtTelefono.setBackground(Color.white);
        txtUsuario.setBackground(Color.white);

        if (txtDocumento.getText().equals("") || txtNombre.getText().equals("")
                || txtApellido.getText().equals("")
                || txtTelefono.getText().equals("") || txtUsuario.getText().equals("")
                || txtContraseña.getPassword().equals("")) {
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
//            txtUsuario.setBackground(Color.white);
//            txtDocumento.setBackground(Color.white);
            if (txtDocumento.isEnabled()) {

                if (SQLUsuario.ExisteDocumento(Users)) {
                    JOptionPane.showMessageDialog(null, "El Documento Ingresado Ya Existe\nPara Actualizar, Presione el Boton Buscar");
                    txtDocumento.setBackground(Color.red);
                } else if (SQLUsuario.ExisteUsuario(Users)) {
                    JOptionPane.showMessageDialog(null, "El Usuario Ingresado Ya Existe");
                    txtUsuario.setBackground(Color.red);
                } else {
                    Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                    Users.setNomEmpleado(txtNombre.getText());
                    Users.setApeEmpleado(txtApellido.getText());
                    Users.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                    Users.setUsuario(txtUsuario.getText());
                    String passwd = new String(txtContraseña.getPassword());
                    Users.setContraseña(Encrypt.sha1(passwd));
                    SQLUsuario.nuevoUsuario(Users);
                    //JOptionPane.showMessageDialog(null, "Se Ingreso el Usuario Exitosamente");
                    JOptionPane.showMessageDialog(null, "Se Ingresaron los Datos Exitosamente", "Ingreso Exitoso", JOptionPane.PLAIN_MESSAGE, OkIcon);
                }
            } else {
                Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                Users.setNomEmpleado(txtNombre.getText());
                Users.setApeEmpleado(txtApellido.getText());
                Users.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                Users.setUsuario(txtUsuario.getText());
                Users.setContraseña(Encrypt.sha1(txtContraseña.getPassword().toString()));
                if (SQLUsuario.ExisteDocumento(Users)) {

                    Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                    Users.setNomEmpleado(txtNombre.getText());
                    Users.setApeEmpleado(txtApellido.getText());
                    Users.setTelEmpleado(Long.parseLong(txtTelefono.getText()));
                    Users.setUsuario(txtUsuario.getText());
                    Users.setContraseña(txtContraseña.getPassword().toString());
                    SQLUsuario.actualizarUsuario(Users);
                    JOptionPane.showMessageDialog(null, "Se Actualizaron los Datos Exitosamente", "Actualizacion Exitosa", JOptionPane.PLAIN_MESSAGE, OkIcon);
                } else {
                    JOptionPane.showMessageDialog(null, "No Existen datos para Actualizar", "Actualizacion Erronea", JOptionPane.PLAIN_MESSAGE, BadIcon);

                }

            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        txtDocumento.setBackground(Color.white);
        txtNombre.setBackground(Color.white);
        txtApellido.setBackground(Color.white);
        txtTelefono.setBackground(Color.white);
        txtUsuario.setBackground(Color.white);
        if (!txtDocumento.getText().equals("")) {
            //con = connect.getConection();
            Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));

            if (SQLUsuario.ConsultarUsuarios(Users)) {
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
                txtContraseña.setEnabled(true);
                btnGuardar.setText("Guardar");
                JOptionPane.showMessageDialog(null, "Usuario No Existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtDocumento.isEnabled() == true) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie el numero de documento y presione cargar",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        } else {
            int opc = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar el usuario seleccionado?",
                    "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon);

            //JOptionPane.showConfirmDialog(null, "Por favor diligencie los campos correspondientes", "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, 2);
            //JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar el usuario seleccionado?");
            System.out.println(opc);
            switch (opc) {
                case 0: //Opcion SI
                    Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
                    Users.setUsuario(txtUsuario.getText());
                    if (SQLUsuario.ExisteDocumento(Users) && SQLUsuario.ExisteUsuario(Users)) {

                        if (SQLUsuario.EliminarUsuario(Users)) {
                            JOptionPane.showMessageDialog(null, "Eliminacion Exitosa", "Exito", JOptionPane.PLAIN_MESSAGE, OkIcon);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar", "Error", JOptionPane.PLAIN_MESSAGE, BadIcon);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario Ingresado no existe o ya se elimino",
                                "Usuario no Existe", JOptionPane.PLAIN_MESSAGE, BadIcon);
                    }
                    break;
                case 1: //Opcion NO
                    JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminacion", "Cancelado por Usuario", JOptionPane.PLAIN_MESSAGE, cancelIcon);
                    break;
            }
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
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetPasswordActionPerformed
        //connect.getConnection();
        if (txtDocumento.isEnabled() == true) {
            JOptionPane.showMessageDialog(null, "Por favor diligencie el numero de documento y presione cargar",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        } else {
            Users.setUsuario(txtUsuario.getText());
            Users.setCodEmpleado(Long.parseLong(txtDocumento.getText()));
            if (SQLUsuario.ExisteUsuario(Users)) {
                //int opc = JOptionPane.showConfirmDialog(null,
                //        "¿Esta seguro de querer restablecer la contraseña del usuario seleccionado?",
                //        "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon);
                switch (JOptionPane.showConfirmDialog(null,
                        "¿Esta seguro de querer restablecer la contraseña del usuario seleccionado?",
                        "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon)) {
                    case 0: //Opcion SI
                        if (SQLUsuario.restablecerPassword(Users)) {
                            JOptionPane.showMessageDialog(null,
                                    "<html><center>Restablecimiento Exitoso<br>"
                                    + "Utilice la cedula de ciudadania para ingresar</html><center>",
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
    }//GEN-LAST:event_btnResetPasswordActionPerformed

    private void txtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyPressed
        if (!isNum(evt.getKeyChar())) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El dato ingresado no es valido,<br>"
                    + "solo se aceptan numeros</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, cancel1Icon);
            evt.consume();
        }
        if (txtDocumento.getText().length() == 10) {
            JOptionPane.showMessageDialog(null, "Solo se aceptan 10 caracteres");
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El Dato Ingresado No Es Valido,<br>"
                    + "Solo Se Aceptan Letras y Espacios</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, cancel1Icon);
            evt.consume();
        }

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        if (isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "<html><center>El Dato Ingresado No Es Valido,<br>"
                    + "Solo Se Aceptan Letras y Espacios</center><html>",
                    "Dato no Valido", JOptionPane.PLAIN_MESSAGE, cancel1Icon);
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped

    }//GEN-LAST:event_txtTelefonoKeyTyped
    private static boolean isNum(char caracter) {
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != '\b')) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isLetter(char caracter) {
        if (((caracter < 'a') || (caracter > 'z')) && ((caracter < 'A') || (caracter > 'Z'))
                && (caracter != '\b') && (caracter != ' ')) {
            return true;
        } else {
            return false;
        }
    }

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
