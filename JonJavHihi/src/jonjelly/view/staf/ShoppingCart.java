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
public class ShoppingCart extends javax.swing.JFrame {
private DefaultTableModel ModelMenu;
private DefaultTableModel ModelTmp;

    public long total;
    public long bayar;
    public long kembali;
    
    /**
     * Creates new form ShoppingCart
     */
    public ShoppingCart() {
        initComponents();
        setTitle("Shopping Cart");
        System.out.println("Selamat Datang Di Halaman ShoppingCart Staf Jon!");
        this.setLocationRelativeTo(this);
        
        //Table Menu
        ModelMenu = new DefaultTableModel();
        TableMenu.setModel(ModelMenu);
        ModelMenu.addColumn("ID");
        ModelMenu.addColumn("NAMA");
        ModelMenu.addColumn("HARGA");
        ModelMenu.addColumn("KATEGORI");
        ModelMenu.addColumn("STOK");
        TableMenu.getColumnModel().getColumn(0).setPreferredWidth(1);
        TableMenu.getColumnModel().getColumn(1).setPreferredWidth(150);
        TableMenu.getColumnModel().getColumn(2).setPreferredWidth(55);
        TableMenu.getColumnModel().getColumn(3).setPreferredWidth(1);
        getListMenu(); 
        
        // Table TMP
        ModelTmp = new DefaultTableModel();
        TablePesananSementara.setModel(ModelTmp);
        ModelTmp.addColumn("ID TMP");
        ModelTmp.addColumn("ID MENU ");
        ModelTmp.addColumn("MENU");
        ModelTmp.addColumn("HARGA");
        ModelTmp.addColumn("JUMLAH");
        ModelTmp.addColumn("TOTAL");
        TablePesananSementara.getColumnModel().getColumn(0).setPreferredWidth(1);
        TablePesananSementara.getColumnModel().getColumn(1).setPreferredWidth(1);
        TablePesananSementara.getColumnModel().getColumn(2).setPreferredWidth(100);
        TablePesananSementara.getColumnModel().getColumn(3).setPreferredWidth(150);
        TablePesananSementara.getColumnModel().getColumn(4).setPreferredWidth(55);
        TablePesananSementara.getColumnModel().getColumn(5).setPreferredWidth(55);
        getTmpPesanan();
        getFaktur();
        
        InputJumlahBeli.setEnabled(false);
        BtnCount.setEnabled(false);        
        BtnAddToCart.setEnabled(false);
        BtnDellet.setEnabled(false);
    }
    
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "HARAP MASUKAN ANGKA SAJA!", "NOTICE VALIDATION", JOptionPane.WARNING_MESSAGE);
           InputJumlahBeli.setText("");
       }
   }
    
    // Ambil Data menu
    public void getListMenu(){
        ModelMenu.getDataVector( ).removeAllElements( );
        ModelMenu.fireTableDataChanged( );

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
                 ModelMenu.addRow(obj);
             }
         }catch(SQLException err){
                System.out.println("Error Load Data Daftar Menu");
         }
    }
    
    // Ambil Data TMP
    public void getTmpPesanan(){
        ModelTmp.getDataVector( ).removeAllElements( );
        ModelTmp.fireTableDataChanged( );

        try{
            Statement stat = (Statement) Database.getKoneksi( ).createStatement( );
            String sql        = "SELECT * FROM tmp_pesanan ORDER BY id_tmp ASC";
            ResultSet res   = stat.executeQuery(sql);

            while(res.next ()){
                 Object[ ] obj = new Object[9];
                 obj[0] = res.getString("id_tmp");
                 obj[1] = res.getString("id_menu");                
                 obj[2] = res.getString("nama_menu");
                 obj[3] = res.getString("harga_menu");
                 obj[4] = res.getString("jumlah_beli");
                 obj[5] = res.getString("total_harga");
                 ModelTmp.addRow(obj);
             }
         }catch(SQLException err){
                System.out.println("Error Load Data tmp_pesanan");
         }
    }
    
    // Faktur pesanan
    private void getFaktur() {
       try {
            Connection c = Database.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM pesanan ORDER BY id_pesanan DESC";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("id_pesanan").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
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
                InputIdTmp.setText("F" + Nol + AN);
            } else {
                InputIdTmp.setText("F0001");
            }

          } catch (Exception e) {
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
        icon_header = new javax.swing.JLabel();
        TagPage = new javax.swing.JLabel();
        BtnBack = new javax.swing.JLabel();
        LblFaktur = new javax.swing.JLabel();
        LblIdMenu = new javax.swing.JLabel();
        LblNamaMenu = new javax.swing.JLabel();
        LblHargaMenu = new javax.swing.JLabel();
        LblStokMenu = new javax.swing.JLabel();
        LblJumlahBeli = new javax.swing.JLabel();
        LblTotal = new javax.swing.JLabel();
        LblBtnSearch = new javax.swing.JLabel();
        LblTabelPesanan = new javax.swing.JLabel();
        LblTabelPesanan1 = new javax.swing.JLabel();
        InputIdTmp = new javax.swing.JTextField();
        InputIdMenu = new javax.swing.JTextField();
        InputNamaMenu = new javax.swing.JTextField();
        InputHargaMenu = new javax.swing.JTextField();
        InputJumlahBeli = new javax.swing.JTextField();
        InputStokMenu = new javax.swing.JTextField();
        InputTotalBeli = new javax.swing.JTextField();
        BtnCount = new javax.swing.JButton();
        BtnAddToCart = new javax.swing.JButton();
        BtnDellet = new javax.swing.JButton();
        BtnChekOut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMenu = new javax.swing.JTable();
        InputSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePesananSementara = new javax.swing.JTable();
        TStok = new javax.swing.JTextField();
        BtnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(45, 45, 45));

        icon_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/brand/header.png"))); // NOI18N

        TagPage.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        TagPage.setForeground(new java.awt.Color(190, 190, 190));
        TagPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/tag_page.png"))); // NOI18N
        TagPage.setText("Shopping Cart");

        BtnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/back_header.png"))); // NOI18N
        BtnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnBackMouseClicked(evt);
            }
        });

        LblFaktur.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblFaktur.setForeground(new java.awt.Color(190, 190, 190));
        LblFaktur.setText("NO. FAKTUR");

        LblIdMenu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblIdMenu.setForeground(new java.awt.Color(190, 190, 190));
        LblIdMenu.setText("ID MENU");

        LblNamaMenu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblNamaMenu.setForeground(new java.awt.Color(190, 190, 190));
        LblNamaMenu.setText("MENU");

        LblHargaMenu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblHargaMenu.setForeground(new java.awt.Color(190, 190, 190));
        LblHargaMenu.setText("PRICE");

        LblStokMenu.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblStokMenu.setForeground(new java.awt.Color(190, 190, 190));
        LblStokMenu.setText("STOCK");

        LblJumlahBeli.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblJumlahBeli.setForeground(new java.awt.Color(190, 190, 190));
        LblJumlahBeli.setText("AMOUNT");

        LblTotal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblTotal.setForeground(new java.awt.Color(190, 190, 190));
        LblTotal.setText("SUBTOTAL");

        LblBtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/search.png"))); // NOI18N

        LblTabelPesanan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LblTabelPesanan.setForeground(new java.awt.Color(102, 102, 102));
        LblTabelPesanan.setText("CART");

        LblTabelPesanan1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LblTabelPesanan1.setForeground(new java.awt.Color(102, 102, 102));
        LblTabelPesanan1.setText("MENU");

        InputIdTmp.setEditable(false);
        InputIdTmp.setBackground(new java.awt.Color(45, 45, 45));
        InputIdTmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputIdTmp.setForeground(new java.awt.Color(190, 190, 190));

        InputIdMenu.setEditable(false);
        InputIdMenu.setBackground(new java.awt.Color(204, 204, 204));
        InputIdMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputIdMenu.setForeground(new java.awt.Color(190, 190, 190));

        InputNamaMenu.setEditable(false);
        InputNamaMenu.setBackground(new java.awt.Color(204, 204, 204));
        InputNamaMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputNamaMenu.setForeground(new java.awt.Color(255, 51, 102));

        InputHargaMenu.setEditable(false);
        InputHargaMenu.setBackground(new java.awt.Color(204, 204, 204));
        InputHargaMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputHargaMenu.setForeground(new java.awt.Color(255, 51, 102));

        InputJumlahBeli.setBackground(new java.awt.Color(45, 45, 45));
        InputJumlahBeli.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputJumlahBeli.setForeground(new java.awt.Color(190, 190, 190));
        InputJumlahBeli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputJumlahBeliKeyReleased(evt);
            }
        });

        InputStokMenu.setEditable(false);
        InputStokMenu.setBackground(new java.awt.Color(204, 204, 204));
        InputStokMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputStokMenu.setForeground(new java.awt.Color(255, 51, 102));

        InputTotalBeli.setEditable(false);
        InputTotalBeli.setBackground(new java.awt.Color(204, 204, 204));
        InputTotalBeli.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputTotalBeli.setForeground(new java.awt.Color(255, 51, 102));

        BtnCount.setBackground(new java.awt.Color(0, 51, 255));
        BtnCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnCount.setForeground(new java.awt.Color(255, 255, 255));
        BtnCount.setText("COUNT");
        BtnCount.setBorder(null);
        BtnCount.setBorderPainted(false);
        BtnCount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCountActionPerformed(evt);
            }
        });

        BtnAddToCart.setBackground(new java.awt.Color(0, 211, 55));
        BtnAddToCart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAddToCart.setForeground(new java.awt.Color(255, 255, 255));
        BtnAddToCart.setText("ENTRY TO CART");
        BtnAddToCart.setBorder(null);
        BtnAddToCart.setBorderPainted(false);
        BtnAddToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddToCartActionPerformed(evt);
            }
        });

        BtnDellet.setBackground(new java.awt.Color(255, 51, 51));
        BtnDellet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnDellet.setForeground(new java.awt.Color(255, 255, 255));
        BtnDellet.setText("DELLET CART");
        BtnDellet.setBorder(null);
        BtnDellet.setBorderPainted(false);
        BtnDellet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnDellet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDelletActionPerformed(evt);
            }
        });

        BtnChekOut.setBackground(new java.awt.Color(204, 0, 204));
        BtnChekOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnChekOut.setForeground(new java.awt.Color(255, 255, 255));
        BtnChekOut.setText("CHECK OUT");
        BtnChekOut.setBorder(null);
        BtnChekOut.setBorderPainted(false);
        BtnChekOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnChekOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnChekOutActionPerformed(evt);
            }
        });

        TableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        TableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMenuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableMenu);

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

        TablePesananSementara.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePesananSementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePesananSementaraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablePesananSementara);

        TStok.setEditable(false);
        TStok.setBackground(new java.awt.Color(45, 45, 45));
        TStok.setForeground(new java.awt.Color(45, 45, 45));
        TStok.setText("jTextField1");
        TStok.setBorder(null);

        BtnReset.setBackground(new java.awt.Color(255, 0, 51));
        BtnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnReset.setForeground(new java.awt.Color(255, 255, 255));
        BtnReset.setText("RESET");
        BtnReset.setBorder(null);
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(icon_header)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnBack))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblFaktur)
                                    .addComponent(InputIdTmp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addComponent(InputIdMenu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(InputStokMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(LblIdMenu)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LblNamaMenu)
                                    .addComponent(InputNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InputHargaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LblHargaMenu)
                                    .addComponent(LblStokMenu)))
                            .addComponent(BtnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(InputJumlahBeli)
                                        .addComponent(BtnAddToCart, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                    .addComponent(TagPage)
                                    .addComponent(LblJumlahBeli)
                                    .addComponent(TStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addComponent(LblTotal)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(BackgroundLayout.createSequentialGroup()
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(InputTotalBeli)
                                            .addComponent(BtnDellet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BtnChekOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BtnCount, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))))
                        .addGap(150, 150, 150)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LblTabelPesanan)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(LblTabelPesanan1)
                                .addGap(180, 180, 180)
                                .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LblBtnSearch))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))))
                .addGap(29, 29, 29))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_header)
                    .addComponent(BtnBack))
                .addGap(30, 30, 30)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LblFaktur)
                                    .addComponent(LblIdMenu))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InputIdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(BackgroundLayout.createSequentialGroup()
                                    .addComponent(LblStokMenu)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(InputStokMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(InputIdTmp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(LblNamaMenu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InputNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(LblHargaMenu)
                                .addGap(6, 6, 6)
                                .addComponent(InputHargaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblJumlahBeli)
                            .addComponent(LblTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputJumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputTotalBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnChekOut, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnDellet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(TStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TagPage))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblBtnSearch)
                            .addComponent(LblTabelPesanan1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblTabelPesanan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Btn Clear TextField Search
    private void InputSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputSearchMouseClicked
        // TODO add your handling code here:
        InputSearch.setText("");
    }//GEN-LAST:event_InputSearchMouseClicked

    // Input Search
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
                SrchMenu[3] = r.getString("nama_kategori");
                SrchMenu[4] = r.getString("stok_menu");
                ModelMenu.addRow(SrchMenu);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Error Load Data Daftar Menu");
        }
    }//GEN-LAST:event_InputSearchKeyReleased

    // Btn Count
    private void BtnCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCountActionPerformed
        // TODO add your handling code here:
        if(
            InputIdTmp.getText().equals("") ||
            InputIdMenu.getText().equals("") ||
            InputHargaMenu.getText().equals("")|| 
            InputJumlahBeli.getText().equals("")
           )
            {
                JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "JONJELLY", JOptionPane.WARNING_MESSAGE);
            }else{
                String a = InputJumlahBeli.getText();
                int aa = Integer.parseInt(a);

                String b = InputStokMenu.getText();
                int bb = Integer.parseInt(b);
                
                if(aa > bb){
                     JOptionPane.showMessageDialog(null, "jumlah melebihi stok", "JONJELLY", JOptionPane.WARNING_MESSAGE);
                     InputJumlahBeli.setText("");
                }else{
                    if(InputJumlahBeli.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "ISI JUMLAH BELI !", "JONJELLY", JOptionPane.WARNING_MESSAGE);
                    }else{
                        int jumlah, harga, total;
                        jumlah = Integer.parseInt(InputJumlahBeli.getText().toString());
                        harga = Integer.parseInt(InputHargaMenu.getText().toString());
                        total = jumlah * harga;
                        InputTotalBeli.setText(Integer.toString(total));
                        BtnAddToCart.setEnabled(true);
                    }
                }
            } 
        
    }//GEN-LAST:event_BtnCountActionPerformed

    // Table TMP Into TextField
    private void TablePesananSementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePesananSementaraMouseClicked
        // TODO add your handling code here:
        
        int i = TablePesananSementara.getSelectedRow();
        if (i == -1) {
            return;
        }
        String idtmp = (String) ModelTmp.getValueAt(i, 0);
        InputIdTmp.setText(idtmp);
        InputIdTmp.setEnabled(false);
        
        String idmenu = (String) ModelTmp.getValueAt(i, 1);
        InputIdMenu.setText(idmenu);
        InputIdMenu.setEnabled(false);
        
        String menu = (String) ModelTmp.getValueAt(i, 2);
        InputNamaMenu.setText(menu);
        InputNamaMenu.setEnabled(false);
        
        String harga = (String) ModelTmp.getValueAt(i, 3);
        InputHargaMenu.setText(harga);
        InputHargaMenu.setEnabled(false);
        
        String jumlah = (String) ModelTmp.getValueAt(i, 4);
        InputJumlahBeli.setText(jumlah);
        InputJumlahBeli.setEnabled(false);
        
        String total = (String) ModelTmp.getValueAt(i, 5);
        InputTotalBeli.setText(total);
        InputTotalBeli.setEnabled(false);

        BtnAddToCart.setEnabled(false);
        BtnCount.setEnabled(false);
        BtnDellet.setEnabled(true);
    }//GEN-LAST:event_TablePesananSementaraMouseClicked

    // Btn Dellet
    private void BtnDelletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDelletActionPerformed
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(null, "Ingin Membatalkan Pesanan?", "DELETE MENU", JOptionPane.YES_NO_OPTION);
        switch (res) {
            case JOptionPane.YES_OPTION:
                if( InputIdTmp.getText().equals("") ||
                    InputIdMenu.getText().equals("") || 
                    InputNamaMenu.getText().equals("") || 
                    InputHargaMenu.getText().equals("")|| 
                    InputJumlahBeli.getText().equals("")|| 
                    InputTotalBeli.getText().equals("")
                   ){JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "JonJelly", JOptionPane.WARNING_MESSAGE);}
                else{
                    try {
                        String sql ="DELETE FROM tmp_pesanan WHERE id_tmp='"+InputIdTmp.getText()+"'";
                        java.sql.Connection conn=(Connection)Database.getKoneksi();
                        java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "Pesanan berhasil di hapus!", "JonJelly", JOptionPane.INFORMATION_MESSAGE);
                        getListMenu();
                        getTmpPesanan();
                        getFaktur();
                        InputStokMenu.setText("");
                        InputIdMenu.setText("");
                        InputNamaMenu.setText("");
                        InputHargaMenu.setText("");
                        InputJumlahBeli.setText("");
                        InputTotalBeli.setText("");
                        InputJumlahBeli.setEnabled(false);
                        BtnAddToCart.setEnabled(false);
                        BtnCount.setEnabled(false);
                        BtnDellet.setEnabled(false);
                    }catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                        }
                    }
            break;
            case JOptionPane.NO_OPTION:
                getListMenu();
                getTmpPesanan();
                getFaktur();
                InputStokMenu.setText("");
                InputIdMenu.setText("");
                InputNamaMenu.setText("");
                InputHargaMenu.setText("");
                InputJumlahBeli.setText("");
                InputTotalBeli.setText("");
                InputJumlahBeli.setEnabled(true);
                BtnAddToCart.setEnabled(true);
                BtnCount.setEnabled(true);
            break;
        }
        
    }//GEN-LAST:event_BtnDelletActionPerformed

    // Btn Checkout
    private void BtnChekOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnChekOutActionPerformed
        // TODO add your handling code here:
        System.out.println("Kita pergi Ke view Staf CheckOut Jon!");
        CheckOut Co=new CheckOut();
        Co.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        Co.setVisible(true);
    }//GEN-LAST:event_BtnChekOutActionPerformed

    // Btn Add To TMP
    private void BtnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddToCartActionPerformed
        // TODO add your handling code here:
        if(
            InputIdTmp.getText().equals("") ||
            InputIdMenu.getText().equals("") || 
            InputNamaMenu.getText().equals("") || 
            InputHargaMenu.getText().equals("")|| 
            InputJumlahBeli.getText().equals("")|| 
            InputStokMenu.getText().equals("")||
            InputTotalBeli.getText().equals("")
          ){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "JONJELLY", JOptionPane.WARNING_MESSAGE);
        }else{
            String idmenu = InputIdMenu.getText();
            String namamenu = InputNamaMenu.getText();
            String hargamenu = InputHargaMenu.getText();
            String jumlahbeli = InputJumlahBeli.getText();
            String totalbeli = InputTotalBeli.getText();
            try {
                Connection c = Database.getKoneksi();
                String sql = "INSERT INTO tmp_pesanan VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, null);
                p.setString(2, idmenu);
                p.setString(3, namamenu);
                p.setString(4, hargamenu);
                p.setString(5, jumlahbeli);
                p.setString(6, totalbeli);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error insert ke table tmp_pesanan");
            }
            try {
                bayar = Integer.parseInt(String.valueOf(InputStokMenu.getText()));
                total = Integer.parseInt(String.valueOf(InputJumlahBeli.getText()));
                kembali = bayar - total;
                TStok.setText(Long.toString(kembali));
                Connection c = Database.getKoneksi();
                String sql = "UPDATE menu SET "
                           + " stok_menu ='"+ TStok.getText() +"' WHERE  id_menu ='" + InputIdMenu.getText() + "'";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error update stok menu");
            }
            finally {
                getListMenu();
                getTmpPesanan();
                getFaktur();
                InputStokMenu.setText("");
                InputIdMenu.setText("");
                InputNamaMenu.setText("");
                InputHargaMenu.setText("");
                InputJumlahBeli.setText("");
                InputTotalBeli.setText("");
                InputJumlahBeli.setEnabled(false);
                BtnAddToCart.setEnabled(false);
                BtnCount.setEnabled(false);
                BtnDellet.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Pesanan Berhasil Ditambahkan", "JONJELLY", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_BtnAddToCartActionPerformed

    // Table MENU Into TextField
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
        
        String stokmenu = (String) ModelMenu.getValueAt(i, 4);
        InputStokMenu.setText(stokmenu);
        
        InputJumlahBeli.setEnabled(true);
        BtnDellet.setEnabled(false);
        BtnAddToCart.setEnabled(false);
    }//GEN-LAST:event_TableMenuMouseClicked

    // Textfield input search
    private void InputSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputSearchMouseEntered
        // TODO add your handling code here:
        InputSearch.setText("");
    }//GEN-LAST:event_InputSearchMouseEntered

    // Textfield jumlah beli
    private void InputJumlahBeliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputJumlahBeliKeyReleased
        // TODO add your handling code here:
        FilterAngka(evt);
        BtnCount.setEnabled(true);
    }//GEN-LAST:event_InputJumlahBeliKeyReleased

    // Btn Reset
    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
        // TODO add your handling code here:
        System.out.println("Click btn reset");
        ShoppingCart SC=new ShoppingCart();
        SC.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        SC.setVisible(true);
    }//GEN-LAST:event_BtnResetActionPerformed

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
            ShoppingCart SC=new ShoppingCart();
            SC.setExtendedState(JFrame.MAXIMIZED_BOTH);
            SC.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton BtnAddToCart;
    private javax.swing.JLabel BtnBack;
    private javax.swing.JButton BtnChekOut;
    private javax.swing.JButton BtnCount;
    private javax.swing.JButton BtnDellet;
    private javax.swing.JButton BtnReset;
    private javax.swing.JTextField InputHargaMenu;
    private javax.swing.JTextField InputIdMenu;
    private javax.swing.JTextField InputIdTmp;
    private javax.swing.JTextField InputJumlahBeli;
    private javax.swing.JTextField InputNamaMenu;
    private javax.swing.JTextField InputSearch;
    private javax.swing.JTextField InputStokMenu;
    private javax.swing.JTextField InputTotalBeli;
    private javax.swing.JLabel LblBtnSearch;
    private javax.swing.JLabel LblFaktur;
    private javax.swing.JLabel LblHargaMenu;
    private javax.swing.JLabel LblIdMenu;
    private javax.swing.JLabel LblJumlahBeli;
    private javax.swing.JLabel LblNamaMenu;
    private javax.swing.JLabel LblStokMenu;
    private javax.swing.JLabel LblTabelPesanan;
    private javax.swing.JLabel LblTabelPesanan1;
    private javax.swing.JLabel LblTotal;
    private javax.swing.JTextField TStok;
    private javax.swing.JTable TableMenu;
    private javax.swing.JTable TablePesananSementara;
    private javax.swing.JLabel TagPage;
    private javax.swing.JLabel icon_header;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
