/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonjelly.view.karyawan;

import config.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import jonjelly.controllers.Karyawan;

/**
 *
 * @author mrpds
 */
public class MenuList extends javax.swing.JFrame {
private DefaultTableModel model;

    /**
     * Creates new form MenuKaryawan
     */
    public MenuList() {
        initComponents();
        setTitle("Menu List");
        System.out.println("Selamat Datang Di Halaman MenuList Karyawan Jon!");
        this.setLocationRelativeTo(this);
        
        //TableMenu
        model = new DefaultTableModel ( );
        TableMenu.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("HARGA");
        model.addColumn("KATEGORI");
        model.addColumn("STOK");
        TableMenu.getColumnModel().getColumn(0).setPreferredWidth(1);
        TableMenu.getColumnModel().getColumn(1).setPreferredWidth(150);
        TableMenu.getColumnModel().getColumn(2).setPreferredWidth(55);
        TableMenu.getColumnModel().getColumn(3).setPreferredWidth(1);
        getListMenu();    
    }
    
    // Ambil Data menu
    public void getListMenu( ){
     //menghapus isi table TabelUser
        model.getDataVector( ).removeAllElements( );
        model.fireTableDataChanged( );

        try{
            Statement stat = (Statement) Database.getKoneksi( ).createStatement( );
            String sql        = "SELECT menu.id_menu, menu.nama_menu, menu.harga_menu, menu.stok_menu,kategori.nama_kategori FROM kategori "
                              + "INNER JOIN menu ON kategori.id_kategori = menu.id_kategori ORDER BY kategori.nama_kategori ASC";
            ResultSet res   = stat.executeQuery(sql);
            
            while(res.next ()){
                 Object[ ] obj = new Object[9];
                 obj[0] = res.getString("id_menu");
                 obj[1] = res.getString("nama_menu");
                 obj[2] = res.getString("harga_menu");
                 obj[3] = res.getString("nama_kategori");
                 obj[4] = res.getString("stok_menu");
                 model.addRow(obj);
             }
         }catch(SQLException err){
                System.out.println("Error Load Data Daftar Menu");
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
        icon_header = new javax.swing.JLabel();
        TagPage = new javax.swing.JLabel();
        BtnBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        InputSearch = new javax.swing.JTextField();
        BtnSearch = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(45, 45, 45));

        icon_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/brand/header.png"))); // NOI18N

        TagPage.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        TagPage.setForeground(new java.awt.Color(190, 190, 190));
        TagPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/tag_page.png"))); // NOI18N
        TagPage.setText("Menu list");

        BtnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/back_header.png"))); // NOI18N
        BtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBackMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("DAFTAR MENU");

        InputSearch.setBackground(new java.awt.Color(45, 45, 45));
        InputSearch.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        InputSearch.setForeground(new java.awt.Color(102, 102, 102));
        InputSearch.setText("ex: drink/snacks/extra");
        InputSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InputSearchMouseEntered(evt);
            }
        });
        InputSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputSearchKeyReleased(evt);
            }
        });

        BtnSearch.setBackground(new java.awt.Color(54, 53, 53));
        BtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/search.png"))); // NOI18N
        BtnSearch.setBorder(null);
        BtnSearch.setBorderPainted(false);

        TableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TableMenu);
        if (TableMenu.getColumnModel().getColumnCount() > 0) {
            TableMenu.getColumnModel().getColumn(0).setMinWidth(20);
            TableMenu.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableMenu.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSearch))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(icon_header)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 874, Short.MAX_VALUE)
                        .addComponent(BtnBack))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackgroundLayout.createSequentialGroup()
                        .addComponent(TagPage)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_header)
                    .addComponent(BtnBack))
                .addGap(56, 56, 56)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TagPage)
                .addGap(24, 24, 24))
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

    
    // Button Back Header
    private void BtnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita kembali ke Controllers Karyawan Jon!");
        Karyawan karyawan=new Karyawan();
        karyawan.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        karyawan.setVisible(true);
    }//GEN-LAST:event_BtnBackMouseClicked

    // Input Search Menu
    private void InputSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputSearchKeyReleased
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = Database.getKoneksi();
            Statement s = c.createStatement();
            String srch = " SELECT menu.id_menu, menu.nama_menu, menu.harga_menu, menu.stok_menu, "
                        + "kategori.id_kategori, kategori.nama_kategori "
                        + "FROM kategori INNER JOIN menu ON kategori.id_kategori = menu.id_kategori "
                        + "WHERE id_menu LIKE '%" + InputSearch.getText()
                        + "%' OR nama_menu LIKE '%" + InputSearch.getText()
                        + "%' OR harga_menu LIKE '%" + InputSearch.getText()
                        + "%' OR nama_kategori LIKE '%" + InputSearch.getText() + "%'";
            ResultSet r = s.executeQuery(srch);

            while (r.next()) {
                Object[ ] SrchMenu = new Object[9];
                SrchMenu[0] = r.getString("id_menu");
                SrchMenu[1] = r.getString("nama_menu");
                SrchMenu[2] = r.getString("harga_menu");
                SrchMenu[3] = r.getString("nama_kategori");
                SrchMenu[4] = r.getString("stok_menu");
                   
                model.addRow(SrchMenu);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Error Load Data Daftar Menu");
        }
    }//GEN-LAST:event_InputSearchKeyReleased
    
    // Replace Input Search Menu
    private void InputSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputSearchMouseClicked
        // TODO add your handling code here:
        InputSearch.setText("");
    }//GEN-LAST:event_InputSearchMouseClicked

    // Replace Input Search Menu
    private void InputSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputSearchMouseEntered
        // TODO add your handling code here:
        InputSearch.setText("");
    }//GEN-LAST:event_InputSearchMouseEntered

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
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            MenuList ML=new MenuList();
            ML.setExtendedState(JFrame.MAXIMIZED_BOTH);
            ML.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel BtnBack;
    private javax.swing.JToggleButton BtnSearch;
    private javax.swing.JTextField InputSearch;
    private javax.swing.JTable TableMenu;
    private javax.swing.JLabel TagPage;
    private javax.swing.JLabel icon_header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
