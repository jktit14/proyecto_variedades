/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Logica.Conexion;
import Logica.Encrypt;
import Logica.SQLUsuarios;
import Logica.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Cambio_Contraseña extends javax.swing.JFrame {

    Conexion connect = new Conexion();
    Connection connection;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public Cambio_Contraseña() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnChangePassword = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblContraseña1 = new javax.swing.JLabel();
        lblContraseña2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPasswd1 = new javax.swing.JPasswordField();
        txtPasswd2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnChangePassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnChangePassword.setText("Cambiar Contraseña");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUser.setText("Usuario");

        lblContraseña1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña1.setText("Contraseña Nueva");

        lblContraseña2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContraseña2.setText("Confirmacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblContraseña1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(lblContraseña2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPasswd2)
                            .addComponent(txtPasswd1)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnChangePassword)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña1)
                    .addComponent(txtPasswd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContraseña2)
                    .addComponent(txtPasswd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnChangePassword)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed

        Usuarios users = new Usuarios();
        SQLUsuarios SqlUsuarios = new SQLUsuarios();
        String passwd1 = new String(txtPasswd1.getPassword());
        String passwd2 = new String(txtPasswd2.getPassword());

        Icon OkIcon = new ImageIcon(getClass().getResource("../Images/like1.png"));
        Icon BadIcon = new ImageIcon(getClass().getResource("../Images/unlike1.png"));
        Icon handIcon = new ImageIcon(getClass().getResource("../Images/hand1.png"));
        Icon cancelIcon = new ImageIcon(getClass().getResource("../Images/cancel.png"));
        Icon questionIcon = new ImageIcon(getClass().getResource("../Images/pregunta.png"));

        if (!txtUser.getText().equals("") && !passwd1.equals("") && !passwd2.equals("")) {
            if (passwd1.equals(passwd2)) {
                //connection = connect.getConection();
                String newPasswd = Encrypt.sha1(passwd1);
                users.setUsuario(txtUser.getText());
                users.setContraseña(newPasswd);
                if (SqlUsuarios.ExisteUsuario(users)) {

                    if (SqlUsuarios.CambiarContraseña(users)) {
                        JOptionPane.showMessageDialog(null, "Se cambio la contraseña exitosamente",
                        "Cambio Exitoso", JOptionPane.ERROR_MESSAGE, BadIcon);
                    } else {
                        System.out.println("No se pudo cambiar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El Ususario No Existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las Contraseñas Ingresadas no Coinciden",
                        "Datos No Coinciden", JOptionPane.ERROR_MESSAGE, BadIcon);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor diligencie los campos correspondientes",
                    "Datos Incompletos", JOptionPane.PLAIN_MESSAGE, handIcon);
        }
    }//GEN-LAST:event_btnChangePasswordActionPerformed

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
            java.util.logging.Logger.getLogger(Cambio_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cambio_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cambio_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cambio_Contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cambio_Contraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JLabel lblContraseña1;
    private javax.swing.JLabel lblContraseña2;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPasswd1;
    private javax.swing.JPasswordField txtPasswd2;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
