/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonjelly.view.staf;

import config.Database;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jonjelly.controllers.Staf;

/**
 *
 * @author mrpds
 */
public class ManageItemMenu extends javax.swing.JFrame {
private DefaultTableModel ModelMenu;
    /**
     * Creates new form ManageItemMenu
     */
    public ManageItemMenu() {
        initComponents();
        setTitle("Item Manage");
        System.out.println("Selamat Datang Di Halaman ItemManage Staf Jon!");
        this.setLocationRelativeTo(this);
        
        //TableMenu
        ModelMenu = new DefaultTableModel ( );
        TableMenu.setModel(ModelMenu);
        ModelMenu.addColumn("ID_MNU");
        ModelMenu.addColumn("NAMA");
        ModelMenu.addColumn("HARGA");
        ModelMenu.addColumn("ID_KTG");
        ModelMenu.addColumn("KATEGORI");
        ModelMenu.addColumn("STOK");
        TableMenu.getColumnModel().getColumn(0).setPreferredWidth(1);
        TableMenu.getColumnModel().getColumn(1).setPreferredWidth(150);
        TableMenu.getColumnModel().getColumn(2).setPreferredWidth(55);
        TableMenu.getColumnModel().getColumn(3).setPreferredWidth(1);
        TableMenu.getColumnModel().getColumn(4).setPreferredWidth(55);
        TableMenu.getColumnModel().getColumn(5).setPreferredWidth(1);
        getListMenu();
        kode();
        menu_combo();
        
        BtnUbah.setEnabled(false);
        BtnHapus.setEnabled(false);
    }
    
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "HARAP MASUKAN ANGKA SAJA!", "NOTICE VALIDATION", JOptionPane.WARNING_MESSAGE);
           InputHargaMenu.setText("");
           InputStokMenu.setText("");
       }
   }
    public void FilterHuruf(KeyEvent a){
       if(Character.isDigit(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "HARAP MASUKAN HURUF SAJA!", "NOTICE VALIDATION", JOptionPane.WARNING_MESSAGE);
           InputNamaMenu.setText("");
       }
   }
    
   //Create Auto number
   private void kode() {
        try {
            Connection c = Database.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM menu ORDER by id_menu DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) { 
                String idmenu = r.getString("id_menu").substring(1);
                String AN = "" + (Integer.parseInt(idmenu) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }
                InputIdMenu.setText("M" + Nol + AN);
            } else {
                InputIdMenu.setText("M0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   

   // set value menu combo
   public void menu_combo() {
        try {
        Connection c = Database.getKoneksi();
        Statement s = c.createStatement();

           String sql = "SELECT id_kategori FROM kategori ";
           ResultSet r = s.executeQuery(sql);

         while (r.next()) {
                   CategoryCombo.addItem(r.getString(1));
               }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
   // Ambil Data menu
    public void getListMenu( ){
        ModelMenu.getDataVector( ).removeAllElements( );
        ModelMenu.fireTableDataChanged( );

        try{
              Statement stat = (Statement) Database.getKoneksi( ).createStatement( );
              String sql        = "SELECT menu.id_menu, menu.nama_menu, menu.harga_menu, menu.stok_menu, kategori.id_kategori, kategori.nama_kategori FROM kategori "
                                + "INNER JOIN menu ON kategori.id_kategori = menu.id_kategori ORDER BY kategori.id_kategori ASC";
              ResultSet res   = stat.executeQuery(sql);
              while(res.next ()){
                   Object[ ] obj = new Object[9];
                   obj[0] = res.getString("id_menu");
                   obj[1] = res.getString("nama_menu");
                   obj[2] = res.getString("harga_menu");
                   obj[3] = res.getString("id_kategori");
                   obj[4] = res.getString("nama_kategori");
                   obj[5] = res.getString("stok_menu");
                   ModelMenu.addRow(obj);
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
        Lidmenu = new javax.swing.JLabel();
        LnamaMenu = new javax.swing.JLabel();
        Lcategory = new javax.swing.JLabel();
        Lharga = new javax.swing.JLabel();
        Lstok = new javax.swing.JLabel();
        InputSearch = new javax.swing.JTextField();
        InputIdMenu = new javax.swing.JTextField();
        InputNamaMenu = new javax.swing.JTextField();
        InputHargaMenu = new javax.swing.JTextField();
        InputStokMenu = new javax.swing.JTextField();
        BtnTambah = new javax.swing.JButton();
        BtnUbah = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnReset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMenu = new javax.swing.JTable();
        CategoryCombo = new javax.swing.JComboBox();
        BtnUpCategory = new javax.swing.JButton();
        LbtnSearch = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(45, 45, 45));

        icon_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/brand/header.png"))); // NOI18N

        TagPage.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        TagPage.setForeground(new java.awt.Color(190, 190, 190));
        TagPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/tag_page.png"))); // NOI18N
        TagPage.setText("Manage Menu");

        BtnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/back_header.png"))); // NOI18N
        BtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBackMouseClicked(evt);
            }
        });

        Lidmenu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Lidmenu.setForeground(new java.awt.Color(190, 190, 190));
        Lidmenu.setText("ID MENU");

        LnamaMenu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LnamaMenu.setForeground(new java.awt.Color(190, 190, 190));
        LnamaMenu.setText("NAME");

        Lcategory.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Lcategory.setForeground(new java.awt.Color(190, 190, 190));
        Lcategory.setText("ID CATEGORY");

        Lharga.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Lharga.setForeground(new java.awt.Color(190, 190, 190));
        Lharga.setText("PRICE");

        Lstok.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        Lstok.setForeground(new java.awt.Color(190, 190, 190));
        Lstok.setText("STOCK");

        InputSearch.setBackground(new java.awt.Color(45, 45, 45));
        InputSearch.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        InputSearch.setForeground(new java.awt.Color(102, 102, 102));
        InputSearch.setText("ex: Drink / Snacks");
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

        InputIdMenu.setEditable(false);
        InputIdMenu.setBackground(new java.awt.Color(45, 45, 45));
        InputIdMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputIdMenu.setForeground(new java.awt.Color(190, 190, 190));

        InputNamaMenu.setBackground(new java.awt.Color(45, 45, 45));
        InputNamaMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputNamaMenu.setForeground(new java.awt.Color(190, 190, 190));
        InputNamaMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputNamaMenuKeyReleased(evt);
            }
        });

        InputHargaMenu.setBackground(new java.awt.Color(45, 45, 45));
        InputHargaMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputHargaMenu.setForeground(new java.awt.Color(190, 190, 190));
        InputHargaMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputHargaMenuKeyReleased(evt);
            }
        });

        InputStokMenu.setBackground(new java.awt.Color(45, 45, 45));
        InputStokMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputStokMenu.setForeground(new java.awt.Color(190, 190, 190));
        InputStokMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputStokMenuKeyReleased(evt);
            }
        });

        BtnTambah.setBackground(new java.awt.Color(91, 59, 255));
        BtnTambah.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnTambah.setForeground(new java.awt.Color(255, 255, 255));
        BtnTambah.setText("CREATE");
        BtnTambah.setBorder(null);
        BtnTambah.setBorderPainted(false);
        BtnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnUbah.setBackground(new java.awt.Color(240, 123, 63));
        BtnUbah.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnUbah.setForeground(new java.awt.Color(255, 255, 255));
        BtnUbah.setText("UPDATE");
        BtnUbah.setBorder(null);
        BtnUbah.setBorderPainted(false);
        BtnUbah.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUbahActionPerformed(evt);
            }
        });

        BtnHapus.setBackground(new java.awt.Color(234, 84, 85));
        BtnHapus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnHapus.setForeground(new java.awt.Color(255, 255, 255));
        BtnHapus.setText("DELETE");
        BtnHapus.setBorder(null);
        BtnHapus.setBorderPainted(false);
        BtnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnReset.setBackground(new java.awt.Color(102, 102, 102));
        BtnReset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BtnReset.setForeground(new java.awt.Color(255, 255, 255));
        BtnReset.setText("RESET");
        BtnReset.setBorder(null);
        BtnReset.setBorderPainted(false);
        BtnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnResetMouseClicked(evt);
            }
        });

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
        TableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMenuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMenu);

        CategoryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih" }));

        BtnUpCategory.setBackground(new java.awt.Color(255, 0, 255));
        BtnUpCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BtnUpCategory.setForeground(new java.awt.Color(255, 255, 255));
        BtnUpCategory.setText("MANAGE CATEGORY");
        BtnUpCategory.setBorder(null);
        BtnUpCategory.setBorderPainted(false);
        BtnUpCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnUpCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpCategoryActionPerformed(evt);
            }
        });

        LbtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/search.png"))); // NOI18N

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(TagPage)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(icon_header)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnBack))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lidmenu)
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(BackgroundLayout.createSequentialGroup()
                                                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(BtnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                        .addComponent(BtnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGap(26, 26, 26)
                                                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(BtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(InputHargaMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                .addComponent(Lharga, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(LnamaMenu, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(InputIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(InputNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Lcategory)
                                            .addComponent(Lstok)
                                            .addComponent(InputStokMenu)
                                            .addComponent(CategoryCombo, 0, 282, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BtnUpCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LbtnSearch)))))
                        .addGap(22, 22, 22))))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_header)
                    .addComponent(BtnBack))
                .addGap(39, 39, 39)
                .addComponent(Lidmenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InputIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LnamaMenu)
                            .addComponent(Lcategory))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CategoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(Lstok)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InputStokMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(Lharga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InputHargaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(BtnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(BtnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbtnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnUpCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(TagPage)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Button Back Header
    private void BtnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnBackMouseClicked
        // TODO add your handling code here:
        System.out.println("Kita Balik Ke Controllers Staf Jon!");
        Staf st=new Staf();
        st.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        st.setVisible(true);
    }//GEN-LAST:event_BtnBackMouseClicked

    // Input Search Menu
    private void InputSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputSearchKeyReleased
        // TODO add your handling code here:
        ModelMenu.getDataVector().removeAllElements();
        ModelMenu.fireTableDataChanged();

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
                SrchMenu[3] = r.getString("id_kategori");
                SrchMenu[4] = r.getString("nama_kategori");
                SrchMenu[5] = r.getString("stok_menu");
                ModelMenu.addRow(SrchMenu);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error load data menu");
        }
    }//GEN-LAST:event_InputSearchKeyReleased

    // Replace ValueInput Search Menu
    private void InputSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputSearchMouseClicked
        // TODO add your handling code here:
        InputSearch.setText("");
    }//GEN-LAST:event_InputSearchMouseClicked

    // Button Created user
    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        if( 
            InputIdMenu.getText().equals("")||
            CategoryCombo.getSelectedItem().equals("")||
            InputNamaMenu.getText().equals("") || 
            InputHargaMenu.getText().equals("")|| 
            InputStokMenu.getText().equals("")
              
           ){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "JonJelly", JOptionPane.WARNING_MESSAGE);
        }else{
            String idmenu = InputIdMenu.getText();
            String categori = (String) CategoryCombo.getSelectedItem();
            String namamenu = InputNamaMenu.getText();
            String hargamenu = InputHargaMenu.getText();
            String stokmenu = InputStokMenu.getText();
            try {
                Connection c = Database.getKoneksi();

                String sql = "INSERT INTO menu VALUES (?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, idmenu);   
                p.setString(2, categori);
                p.setString(3, namamenu);
                p.setString(4, hargamenu);
                p.setString(5, stokmenu);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error insert ke table menu");
            } finally {
                getListMenu();
                kode();
                InputNamaMenu.setText("");
                InputHargaMenu.setText("");
                InputStokMenu.setText("");
                CategoryCombo.setSelectedItem("- Pilih");
                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "JonJelly", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnTambahActionPerformed

    // Button Reset
    private void BtnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnResetMouseClicked
        // TODO add your handling code here:
        kode();
        InputNamaMenu.setText("");
        InputHargaMenu.setText("");
        InputStokMenu.setText("");
        CategoryCombo.setSelectedItem("- Pilih");
        BtnUbah.setEnabled(false);
        BtnHapus.setEnabled(false);
        BtnTambah.setEnabled(true);
        InputIdMenu.setEnabled(true);
    }//GEN-LAST:event_BtnResetMouseClicked

    // Table user event Click post to textfield
    private void TableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMenuMouseClicked
        // TODO add your handling code here:
        int i = TableMenu.getSelectedRow();
        if (i == -1) {
            return;
        }
        String idmenu = (String) ModelMenu.getValueAt(i, 0);
        InputIdMenu.setText(idmenu);
        InputIdMenu.setEnabled(false);

        String namamenu = (String) ModelMenu.getValueAt(i, 1);
        InputNamaMenu.setText(namamenu);
        
        String hargamenu = (String) ModelMenu.getValueAt(i, 2);
        InputHargaMenu.setText(hargamenu);
        
        String categori = (String) ModelMenu.getValueAt(i, 3);
        CategoryCombo.setSelectedItem(categori);
        
        String stokmenu = (String) ModelMenu.getValueAt(i, 5);
        InputStokMenu.setText(stokmenu);
        
        BtnTambah.setEnabled(false);
        BtnUbah.setEnabled(true);
        BtnHapus.setEnabled(true);
    }//GEN-LAST:event_TableMenuMouseClicked

    // Button Update Menu
    private void BtnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUbahActionPerformed
        // TODO add your handling code here:
        if( 
            InputIdMenu.getText().equals("")||
            CategoryCombo.getSelectedItem().equals("")||
            InputNamaMenu.getText().equals("") || 
            InputHargaMenu.getText().equals("")|| 
            InputStokMenu.getText().equals("")
           ){
                JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "JonJelly", JOptionPane.WARNING_MESSAGE);
            }else{
                int i = TableMenu.getSelectedRow();
                if (i == -1) {
                    return;
                }
                String idmenu = (String) ModelMenu.getValueAt(i, 0);
                InputIdMenu.setText(idmenu);
                try {

                    Connection c = Database.getKoneksi();
                    String sql = "UPDATE menu SET "
                                + " nama_menu ='"+ InputNamaMenu.getText() + "',"
                                + " id_kategori ='"+ CategoryCombo.getSelectedItem() + "',"
                                + " harga_menu ='"+ InputHargaMenu.getText() + "',"
                                + " stok_menu ='"+ InputStokMenu.getText() +"' WHERE  id_menu ='" + InputIdMenu.getText() + "'";
                    PreparedStatement p = c.prepareStatement(sql);
                    p.executeUpdate();
                    p.close();
                } catch (SQLException e) {
                    System.out.println("Terjadi Error update menu");
                } finally {
                    getListMenu();
                    kode();
                    InputNamaMenu.setText("");
                    InputHargaMenu.setText("");
                    InputStokMenu.setText("");
                    CategoryCombo.setSelectedItem("- Pilih");
                    BtnTambah.setEnabled(true);
                    InputIdMenu.setEnabled(true);
                    BtnUbah.setEnabled(false);
                    BtnHapus.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "JonJelly", JOptionPane.INFORMATION_MESSAGE);
                }
           }
    }//GEN-LAST:event_BtnUbahActionPerformed

    // Button Delete User
    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(null, "Do You want to DELETE MENU?", "DELETE MENU", JOptionPane.YES_NO_OPTION);
        switch (res) {
            case JOptionPane.YES_OPTION:
                if( InputIdMenu.getText().equals("")||
                    CategoryCombo.getSelectedItem().equals("")||
                    InputNamaMenu.getText().equals("") || 
                    InputHargaMenu.getText().equals("")|| 
                    InputStokMenu.getText().equals("")
                   ){JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "JonJelly", JOptionPane.WARNING_MESSAGE);}
                else{
                    try {
                        String sql ="DELETE FROM menu WHERE id_menu='"+InputIdMenu.getText()+"'";
                        java.sql.Connection conn=(Connection)Database.getKoneksi();
                        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "berhasil di hapus!", "JonJelly", JOptionPane.INFORMATION_MESSAGE);
                        kode();
                        getListMenu();
                        InputNamaMenu.setText("");
                        InputHargaMenu.setText("");
                        InputStokMenu.setText("");
                        CategoryCombo.setSelectedItem("- Pilih");
                        BtnTambah.setEnabled(true);
                        InputIdMenu.setEnabled(true);
                        BtnUbah.setEnabled(false);
                        BtnHapus.setEnabled(false);
                    }catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                        }
                    }
            break;
            case JOptionPane.NO_OPTION:
                kode();
                InputNamaMenu.setText("");
                InputHargaMenu.setText("");
                InputStokMenu.setText("");
                CategoryCombo.setSelectedItem("- Pilih");
                BtnTambah.setEnabled(true);
                InputIdMenu.setEnabled(true);
                BtnUbah.setEnabled(false);
                BtnHapus.setEnabled(false);
            break;
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    // Btn go to view category
    private void BtnUpCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpCategoryActionPerformed
        // TODO add your handling code here:
        System.out.println("Kita pergi ke halaman view staf ManageKategori, Jon!");
        ManageKategori CategoryManage=new ManageKategori();
        CategoryManage.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        CategoryManage.setVisible(true);
    }//GEN-LAST:event_BtnUpCategoryActionPerformed

    // event input harga menu
    private void InputHargaMenuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputHargaMenuKeyReleased
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_InputHargaMenuKeyReleased

    // event input stok menu
    private void InputStokMenuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputStokMenuKeyReleased
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_InputStokMenuKeyReleased

    // event input nama menu
    private void InputNamaMenuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputNamaMenuKeyReleased
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_InputNamaMenuKeyReleased

    // event replace value search
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
            java.util.logging.Logger.getLogger(ManageItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageItemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            ManageItemMenu MenuManage=new ManageItemMenu();
            MenuManage.setExtendedState(JFrame.MAXIMIZED_BOTH);
            MenuManage.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel BtnBack;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnReset;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JButton BtnUbah;
    private javax.swing.JButton BtnUpCategory;
    private javax.swing.JComboBox CategoryCombo;
    private javax.swing.JTextField InputHargaMenu;
    private javax.swing.JTextField InputIdMenu;
    private javax.swing.JTextField InputNamaMenu;
    private javax.swing.JTextField InputSearch;
    private javax.swing.JTextField InputStokMenu;
    private javax.swing.JLabel LbtnSearch;
    private javax.swing.JLabel Lcategory;
    private javax.swing.JLabel Lharga;
    private javax.swing.JLabel Lidmenu;
    private javax.swing.JLabel LnamaMenu;
    private javax.swing.JLabel Lstok;
    private javax.swing.JTable TableMenu;
    private javax.swing.JLabel TagPage;
    private javax.swing.JLabel icon_header;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
