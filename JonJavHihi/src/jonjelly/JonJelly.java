/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonjelly;

import config.Database;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jonjelly.controllers.*;

/**
 *
 * @author mrpds
 */
public class JonJelly extends javax.swing.JFrame {

    /**
     * Creates new form JonJelly
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    public JonJelly() {
        initComponents();
        setTitle("JonJelly");
        System.out.println("Menjalankan System JonJelly!");
        this.setLocationRelativeTo(this);
    }
    
    public void cek_level(){
        try {
            Statement stat = (Statement) Database.getKoneksi().createStatement();
            sql = "SELECT * FROM user WHERE username_user='"+input_username.getText()+"' AND password_user='"+input_password.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if("Staf".equals(rs.getString("jabatan")) ){
                    sql = "SELECT * FROM user";
                    Object[ ] obj = new Object[4];
                    obj[1] = rs.getString("nama_user"); 
                    System.out.println("Kita pergi ke controllers Staf Jon!");
                    JOptionPane.showMessageDialog(null, "Wellcome Staf! " + obj[1]+"!","Succes Login JON!", JOptionPane.INFORMATION_MESSAGE);
                   
                    Staf st=new Staf();
                    st.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    this.setVisible(false);
                    st.setVisible(true);
                }
                else if("Karyawan".equals(rs.getString("jabatan")) ){
                    sql = "SELECT * FROM user";
                    Object[ ] obj = new Object[4];
                    obj[1] = rs.getString("nama_user"); 
                    System.out.println("Kita pergi ke controllers Karyawan Jon!");
                    JOptionPane.showMessageDialog(null, "Wellcome! " + obj[1]+"!","Succes Login JON!", JOptionPane.INFORMATION_MESSAGE);
                    
                    Karyawan karyawan=new Karyawan();
                    karyawan.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    this.setVisible(false);
                    karyawan.setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry, your password or username is Wrong!","Wrong!", JOptionPane.WARNING_MESSAGE);
                input_username.setText("");
                input_password.setText("");
                input_username.requestFocus();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
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

        Background = new javax.swing.JPanel();
        Icon = new javax.swing.JLabel();
        logoheaderlogin = new javax.swing.JLabel();
        L_username = new javax.swing.JLabel();
        L_password = new javax.swing.JLabel();
        input_username = new javax.swing.JTextField();
        input_password = new javax.swing.JPasswordField();
        Login_btn = new javax.swing.JLabel();
        Login_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(45, 45, 45));

        Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/brand/icon.png"))); // NOI18N

        logoheaderlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/brand/loginheader.png"))); // NOI18N

        L_username.setBackground(new java.awt.Color(190, 190, 190));
        L_username.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        L_username.setForeground(new java.awt.Color(190, 190, 190));
        L_username.setText("USERNAME");

        L_password.setBackground(new java.awt.Color(190, 190, 190));
        L_password.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        L_password.setForeground(new java.awt.Color(190, 190, 190));
        L_password.setText("PASSWORD");

        input_username.setBackground(new java.awt.Color(45, 45, 45));
        input_username.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        input_username.setForeground(new java.awt.Color(102, 102, 102));
        input_username.setText("Ex: jonjelly");
        input_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                input_usernameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_usernameMouseEntered(evt);
            }
        });

        input_password.setBackground(new java.awt.Color(45, 45, 45));
        input_password.setForeground(new java.awt.Color(102, 102, 102));
        input_password.setText("jPasswordField1");
        input_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                input_passwordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                input_passwordMouseEntered(evt);
            }
        });
        input_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_passwordKeyReleased(evt);
            }
        });

        Login_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/sign-in.png"))); // NOI18N
        Login_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login_btnMouseClicked(evt);
            }
        });

        Login_label.setBackground(new java.awt.Color(190, 190, 190));
        Login_label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Login_label.setForeground(new java.awt.Color(190, 190, 190));
        Login_label.setText("LOGIN");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(Icon)
                .addGap(26, 26, 26)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(logoheaderlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(input_username)
                        .addComponent(L_username)
                        .addComponent(L_password)
                        .addComponent(input_password, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(Login_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Login_btn)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(logoheaderlogin)
                        .addGap(30, 30, 30)
                        .addComponent(L_username)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_username, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(L_password)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_password, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(Login_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Login_btn)))
                        .addGap(230, 230, 230))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(Icon)
                        .addGap(176, 176, 176))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Button Login
    private void Login_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login_btnMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita pergi ke Controllers Staf!");
        cek_level();
    }//GEN-LAST:event_Login_btnMouseClicked

    // Textfield username
    private void input_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_usernameMouseClicked
        // TODO add your handling code here:
        input_username.setText("");
    }//GEN-LAST:event_input_usernameMouseClicked

    // Textfield password
    private void input_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_passwordMouseClicked
        // TODO add your handling code here:
        input_password.setText("");
    }//GEN-LAST:event_input_passwordMouseClicked

    // Textfield username hover mouse
    private void input_usernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_usernameMouseEntered
        // TODO add your handling code here:
        input_username.setText("");
    }//GEN-LAST:event_input_usernameMouseEntered

    // Textfield password hover mouse
    private void input_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_input_passwordMouseEntered
        // TODO add your handling code here:
        input_password.setText("");
    }//GEN-LAST:event_input_passwordMouseEntered

    // keyboard enter
    private void input_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_passwordKeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
             cek_level();
        }
    }//GEN-LAST:event_input_passwordKeyReleased

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
            java.util.logging.Logger.getLogger(JonJelly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JonJelly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JonJelly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JonJelly.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            JonJelly jj=new JonJelly();
            jj.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jj.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Icon;
    private javax.swing.JLabel L_password;
    private javax.swing.JLabel L_username;
    private javax.swing.JLabel Login_btn;
    private javax.swing.JLabel Login_label;
    private javax.swing.JPasswordField input_password;
    private javax.swing.JTextField input_username;
    private javax.swing.JLabel logoheaderlogin;
    // End of variables declaration//GEN-END:variables
}
