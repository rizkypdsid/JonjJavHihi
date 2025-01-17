/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonjelly.controllers;
import java.awt.Desktop;
import java.net.URL;
import jonjelly.view.staf.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jonjelly.Logout;



/**
 *
 * @author mrpds
 */
public class Staf extends javax.swing.JFrame {

    /**
     * Creates new form Staf
     */
    public Staf() {
        initComponents();
        setTitle("Dashboard Staf");
        System.out.println("Selamat Datang Di Halaman Dashboard Staf Jon!");
        this.setLocationRelativeTo(this);
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
        icon_header = new javax.swing.JLabel();
        LogoutHeader = new javax.swing.JLabel();
        ShoppingCart = new javax.swing.JLabel();
        MenuList = new javax.swing.JLabel();
        ItemManage = new javax.swing.JLabel();
        Reports = new javax.swing.JLabel();
        UserManage = new javax.swing.JLabel();
        Shutdown = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(45, 45, 45));

        icon_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/brand/header.png"))); // NOI18N

        LogoutHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/sign-out-header.png"))); // NOI18N
        LogoutHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutHeaderMouseClicked(evt);
            }
        });

        ShoppingCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/Shopping cart.png"))); // NOI18N
        ShoppingCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShoppingCartMouseClicked(evt);
            }
        });

        MenuList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/menu list.png"))); // NOI18N
        MenuList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuListMouseClicked(evt);
            }
        });

        ItemManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/item manage.png"))); // NOI18N
        ItemManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemManageMouseClicked(evt);
            }
        });

        Reports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/reports.png"))); // NOI18N
        Reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportsMouseClicked(evt);
            }
        });

        UserManage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserManage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/user manage.png"))); // NOI18N
        UserManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserManageMouseClicked(evt);
            }
        });

        Shutdown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/shutdown menu.png"))); // NOI18N
        Shutdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ShutdownMouseClicked(evt);
            }
        });

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu/logout menu.png"))); // NOI18N
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(ShoppingCart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MenuList))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(ItemManage)
                                .addGap(23, 23, 23)
                                .addComponent(Reports)))
                        .addGap(18, 18, 18)
                        .addComponent(UserManage)
                        .addGap(18, 18, 18)
                        .addComponent(Shutdown)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Logout)
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(icon_header)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogoutHeader)
                        .addGap(29, 29, 29))))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icon_header)
                            .addComponent(LogoutHeader))
                        .addGap(32, 32, 32)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Shutdown)
                            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(UserManage, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(BackgroundLayout.createSequentialGroup()
                                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ShoppingCart)
                                        .addComponent(MenuList))
                                    .addGap(18, 18, 18)
                                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Reports)
                                        .addComponent(ItemManage))))))
                    .addComponent(Logout))
                .addContainerGap(145, Short.MAX_VALUE))
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

    // Menu Button Shopping Cart
    private void ShoppingCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShoppingCartMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita pergi ke view Staf ShoppingCart Jon!");
        ShoppingCart SC=new ShoppingCart();
        SC.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        SC.setVisible(true);
    }//GEN-LAST:event_ShoppingCartMouseClicked

    // Menu Button Menu List
    private void MenuListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuListMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita pergi ke view Staf MenuList Jon!");
        MenuList ML=new MenuList();
        ML.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        ML.setVisible(true);
    }//GEN-LAST:event_MenuListMouseClicked

    // Menu Button Item Manage
    private void ItemManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemManageMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita pergi ke view Staf MenuItem Jon!");
        ManageItemMenu MenuManage=new ManageItemMenu();
        MenuManage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        MenuManage.setVisible(true);
    }//GEN-LAST:event_ItemManageMouseClicked

    // Menu Button Reports
    private void ReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita pergi ke Localhost Report Jon!");
        try{
            Desktop.getDesktop().browse(new URL("http://localhost/jonjelly_report/Report.php").toURI());
            } catch (Exception e){
                System.out.println(e);
            }
    }//GEN-LAST:event_ReportsMouseClicked

    // Menu Button User Manage
    private void UserManageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserManageMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita pergi ke view Staf UserManage Jon!");
        UserManage UM=new UserManage();
        UM.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        UM.setVisible(true);
    }//GEN-LAST:event_UserManageMouseClicked

    // Menu Button Shutdown
    private void ShutdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShutdownMouseClicked
        // TODO add your handling code here:
        System.out.println("Running System Shutdown Jon!");
        int res = JOptionPane.showConfirmDialog(null, "Do You want to Shutdown?", "Shutdown", JOptionPane.YES_NO_OPTION);
        switch (res) {
            case JOptionPane.YES_OPTION:
            System.out.println("Shutdown System JonJelly!");
            JOptionPane.showMessageDialog(null, "Thank You!","Succes Shutdown", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            break;
            case JOptionPane.NO_OPTION:
            System.out.println("Canceled System JonJelly!");
            JOptionPane.showMessageDialog(null, "Shutdown is Canceled!","Cancel Shutdown", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }//GEN-LAST:event_ShutdownMouseClicked

    // Menu Button Logout
    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
        System.out.println("Running System Logout Jon!");
        int res = JOptionPane.showConfirmDialog(null, "Do You want to Logout?", "Logout", JOptionPane.YES_NO_OPTION);
        switch (res) {
            case JOptionPane.YES_OPTION:
            System.out.println("Logout System JonJelly!");
            JOptionPane.showMessageDialog(null, "Thank You!","Succes Logout", JOptionPane.INFORMATION_MESSAGE);
            Logout LGT=new Logout();
            LGT.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(false);
            LGT.setVisible(true);
            break;
            case JOptionPane.NO_OPTION:
            System.out.println("Canceled Logout JonJelly!");
            JOptionPane.showMessageDialog(null, "Logout is Canceled!","Cancel Logout", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }//GEN-LAST:event_LogoutMouseClicked

    // Header Button Logout
    private void LogoutHeaderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutHeaderMouseClicked
        // TODO add your handling code here:
        System.out.println("Running System Logout Jon!");
        int res = JOptionPane.showConfirmDialog(null, "Do You want to Logout?", "Logout", JOptionPane.YES_NO_OPTION);
        switch (res) {
            case JOptionPane.YES_OPTION:
            System.out.println("Logout System JonJelly!");
            JOptionPane.showMessageDialog(null, "Thank You!","Succes Logout", JOptionPane.INFORMATION_MESSAGE);
            Logout LGT=new Logout();
            LGT.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setVisible(false);
            LGT.setVisible(true);
            break;
            case JOptionPane.NO_OPTION:
            System.out.println("Canceled Logout JonJelly!");
            JOptionPane.showMessageDialog(null, "Logout is Canceled!","Cancel Logout", JOptionPane.INFORMATION_MESSAGE);
            break;
        }
    }//GEN-LAST:event_LogoutHeaderMouseClicked

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
            java.util.logging.Logger.getLogger(Staf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Staf st=new Staf();
                st.setExtendedState(JFrame.MAXIMIZED_BOTH);
                st.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel ItemManage;
    private javax.swing.JLabel Logout;
    private javax.swing.JLabel LogoutHeader;
    private javax.swing.JLabel MenuList;
    private javax.swing.JLabel Reports;
    private javax.swing.JLabel ShoppingCart;
    private javax.swing.JLabel Shutdown;
    private javax.swing.JLabel UserManage;
    private javax.swing.JLabel icon_header;
    // End of variables declaration//GEN-END:variables
}
