/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonjelly.view.karyawan;

import config.Database;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jonjelly.controllers.Karyawan;

/**
 *
 * @author mrpds
 */
public class CheckOut extends javax.swing.JFrame {
    private DefaultTableModel TblLaporan;
    private DefaultTableModel tmp;
    
    public long total;
    public long bayar;
    public long kembali;



    /**
     * Creates new form MenuKaryawan
     */
    public CheckOut() {
        initComponents();
        setTitle("Checkout Shopping");
        System.out.println("Selamat Datang Di Halaman Checkout Shopping Cart Karyawan Jon!");
        this.setLocationRelativeTo(this);
        
        
        // Table TMP
        TblLaporan = new DefaultTableModel();
        TblLaporanPenjualan.setModel(TblLaporan);
        TblLaporan.addColumn("ID");
        TblLaporan.addColumn("NAMA");
        TblLaporan.addColumn("MENU");
        TblLaporan.addColumn("HARGA");
        TblLaporan.addColumn("JUMLAH");
        TblLaporan.addColumn("TOTAL PEMBAYARAN");
        TblLaporan.addColumn("BAYAR");
        TblLaporan.addColumn("KEMBALIAN");
        TblLaporanPenjualan.getColumnModel().getColumn(0).setPreferredWidth(1);
        TblLaporanPenjualan.getColumnModel().getColumn(1).setPreferredWidth(80);
        TblLaporanPenjualan.getColumnModel().getColumn(2).setPreferredWidth(100);
        TblLaporanPenjualan.getColumnModel().getColumn(3).setPreferredWidth(50);
        TblLaporanPenjualan.getColumnModel().getColumn(4).setPreferredWidth(10);
        TblLaporanPenjualan.getColumnModel().getColumn(5).setPreferredWidth(50);
        TblLaporanPenjualan.getColumnModel().getColumn(6).setPreferredWidth(50);
        TblLaporanPenjualan.getColumnModel().getColumn(7).setPreferredWidth(50);
        getLaporanPesanan();
        
        // Table TMP
        tmp = new DefaultTableModel();
        TablePesananSementara.setModel(tmp);
        tmp.addColumn("ID TMP");
        tmp.addColumn("ID MENU ");
        tmp.addColumn("MENU");
        tmp.addColumn("HARGA");
        tmp.addColumn("JUMLAH");
        tmp.addColumn("TOTAL");
        TablePesananSementara.getColumnModel().getColumn(0).setPreferredWidth(1);
        TablePesananSementara.getColumnModel().getColumn(1).setPreferredWidth(1);
        TablePesananSementara.getColumnModel().getColumn(2).setPreferredWidth(100);
        TablePesananSementara.getColumnModel().getColumn(3).setPreferredWidth(150);
        TablePesananSementara.getColumnModel().getColumn(4).setPreferredWidth(55);
        TablePesananSementara.getColumnModel().getColumn(5).setPreferredWidth(55);
        getTmpPesanan();
        getFaktur();
        
        InputIdPesanan.setEnabled(false);
        InputUangBayar.setEnabled(false);
        BtnCount.setEnabled(false);
        BtnPayOrders.setEnabled(false);
        
    }
    
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "HARAP MASUKAN ANGKA SAJA!", "NOTICE VALIDATION", JOptionPane.WARNING_MESSAGE);
       }
   }
    public void FilterHuruf(KeyEvent a){
       if(Character.isDigit(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "HARAP MASUKAN HURUF SAJA!", "NOTICE VALIDATION", JOptionPane.WARNING_MESSAGE);
       }
   }


    // Ambil data table pesanan
    public void getLaporanPesanan(){
        TblLaporan.getDataVector( ).removeAllElements( );
        TblLaporan.fireTableDataChanged( );

        try{
              Statement stat = (Statement) Database.getKoneksi( ).createStatement( );
              String sql        = "SELECT * FROM pesanan ORDER BY id_pesanan DESC";
              ResultSet res   = stat.executeQuery(sql);
              while(res.next ()){
                   Object[ ] obj = new Object[9];
                   obj[0] = res.getString("id_pesanan");              
                   obj[1] = res.getString("nama_cust");
                   obj[2] = res.getString("nama_menu");
                   obj[3] = res.getString("harga_menu");
                   obj[4] = res.getString("jumlah_beli");
                   obj[5] = res.getString("total_pembayaran");
                   obj[6] = res.getString("uang_bayar");
                   obj[7] = res.getString("kembalian");
                   TblLaporan.addRow(obj);
               }
         }catch(SQLException err){
                System.out.println("Error Load Data Table Pesanan");
         }
    }
    
    // Ambil Data TMP
    public void getTmpPesanan(){
        tmp.getDataVector( ).removeAllElements( );
        tmp.fireTableDataChanged( );

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
                 tmp.addRow(obj);
             }
            }catch(SQLException err){
                System.out.println("Error Load Data TMP PESANAN");
            }
    }
    
    // Faktur
    private void getFaktur() {
        try {
            Connection c = Database.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM pesanan ORDER by id_pesanan DESC";
            ResultSet r = s.executeQuery(sql);
            
            if (r.next()) { 
                String idtmp = r.getString("id_pesanan").substring(1);
                String AN = "" + (Integer.parseInt(idtmp) + 1);
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

                InputIdPesanan.setText("F" + Nol + AN);
            } else {
                InputIdPesanan.setText("F0001");
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
        LblCust = new javax.swing.JLabel();
        LblJumlahBeli = new javax.swing.JLabel();
        LblTotal = new javax.swing.JLabel();
        LblTabelPesanan = new javax.swing.JLabel();
        InputIdPesanan = new javax.swing.JTextField();
        InputNamaPemesan = new javax.swing.JTextField();
        InputTotalBeli = new javax.swing.JTextField();
        InputUangBayar = new javax.swing.JTextField();
        InputKembalian = new javax.swing.JTextField();
        BtnCount = new javax.swing.JButton();
        BtnAddMenu = new javax.swing.JButton();
        BtnPayOrders = new javax.swing.JButton();
        BtnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePesananSementara = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblLaporanPenjualan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        LblJumlahBeli1 = new javax.swing.JLabel();
        SearchRelatedCart = new javax.swing.JTextField();

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

        LblFaktur.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblFaktur.setForeground(new java.awt.Color(190, 190, 190));
        LblFaktur.setText("NO. FAKTUR");

        LblCust.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblCust.setForeground(new java.awt.Color(190, 190, 190));
        LblCust.setText("CUSTOMER NAME");

        LblJumlahBeli.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblJumlahBeli.setForeground(new java.awt.Color(190, 190, 190));
        LblJumlahBeli.setText("CASH");

        LblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LblTotal.setForeground(new java.awt.Color(190, 190, 190));
        LblTotal.setText("SUBTOTAL");

        LblTabelPesanan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LblTabelPesanan.setForeground(new java.awt.Color(102, 102, 102));
        LblTabelPesanan.setText("CART");

        InputIdPesanan.setEditable(false);
        InputIdPesanan.setBackground(new java.awt.Color(45, 45, 45));
        InputIdPesanan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputIdPesanan.setForeground(new java.awt.Color(190, 190, 190));

        InputNamaPemesan.setBackground(new java.awt.Color(45, 45, 45));
        InputNamaPemesan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputNamaPemesan.setForeground(new java.awt.Color(190, 190, 190));
        InputNamaPemesan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputNamaPemesanKeyReleased(evt);
            }
        });

        InputTotalBeli.setEditable(false);
        InputTotalBeli.setBackground(new java.awt.Color(45, 45, 45));
        InputTotalBeli.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputTotalBeli.setForeground(new java.awt.Color(255, 51, 102));

        InputUangBayar.setBackground(new java.awt.Color(45, 45, 45));
        InputUangBayar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputUangBayar.setForeground(new java.awt.Color(190, 190, 190));
        InputUangBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputUangBayarKeyReleased(evt);
            }
        });

        InputKembalian.setEditable(false);
        InputKembalian.setBackground(new java.awt.Color(45, 45, 45));
        InputKembalian.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InputKembalian.setForeground(new java.awt.Color(255, 51, 102));

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

        BtnAddMenu.setBackground(new java.awt.Color(0, 0, 255));
        BtnAddMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnAddMenu.setForeground(new java.awt.Color(255, 255, 255));
        BtnAddMenu.setText("ADD MENU");
        BtnAddMenu.setBorder(null);
        BtnAddMenu.setBorderPainted(false);
        BtnAddMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnAddMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddMenuActionPerformed(evt);
            }
        });

        BtnPayOrders.setBackground(new java.awt.Color(0, 204, 0));
        BtnPayOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPayOrders.setForeground(new java.awt.Color(255, 255, 255));
        BtnPayOrders.setText("PAY ORDERS");
        BtnPayOrders.setBorder(null);
        BtnPayOrders.setBorderPainted(false);
        BtnPayOrders.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnPayOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPayOrdersActionPerformed(evt);
            }
        });

        BtnPrint.setBackground(new java.awt.Color(204, 0, 204));
        BtnPrint.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnPrint.setForeground(new java.awt.Color(255, 255, 255));
        BtnPrint.setText("PRINT");
        BtnPrint.setBorder(null);
        BtnPrint.setBorderPainted(false);
        BtnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
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

        TblLaporanPenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TblLaporanPenjualan);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Last Customer");

        LblJumlahBeli1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        LblJumlahBeli1.setForeground(new java.awt.Color(190, 190, 190));
        LblJumlahBeli1.setText("CHANGE");

        SearchRelatedCart.setBackground(new java.awt.Color(45, 45, 45));
        SearchRelatedCart.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        SearchRelatedCart.setForeground(new java.awt.Color(102, 102, 102));
        SearchRelatedCart.setText("Cari pemesanan terakhir");
        SearchRelatedCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchRelatedCartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchRelatedCartMouseEntered(evt);
            }
        });
        SearchRelatedCart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchRelatedCartKeyReleased(evt);
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
                        .addComponent(icon_header))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(InputUangBayar)
                            .addComponent(LblTotal)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LblFaktur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(InputIdPesanan))
                                .addGap(18, 18, 18)
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LblCust)
                                    .addComponent(InputNamaPemesan)))
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(InputTotalBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnCount, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LblJumlahBeli)
                            .addComponent(LblJumlahBeli1)
                            .addComponent(InputKembalian)
                            .addComponent(BtnPayOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BtnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TagPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(BtnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(BtnBack))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LblTabelPesanan)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(BackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SearchRelatedCart, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_header)
                    .addComponent(BtnBack))
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblFaktur)
                            .addComponent(LblCust))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputIdPesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InputNamaPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InputTotalBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnCount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblJumlahBeli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputUangBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblJumlahBeli1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnPayOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAddMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(TagPage))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(LblTabelPesanan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(SearchRelatedCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
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
        System.out.println("Kita Balik Ke Controllers Karyawan Jon!");
        Karyawan karyawan=new Karyawan();
        karyawan.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        karyawan.setVisible(true);
    }//GEN-LAST:event_BtnBackMouseClicked

    // Btn Add To Pesanan
    private void BtnPayOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPayOrdersActionPerformed
        // TODO add your handling code here:
        if(InputUangBayar.getText().equals("") ||InputKembalian.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "JonJelly", JOptionPane.WARNING_MESSAGE);
        }else{
            String a = InputKembalian.getText();
            int ab = Integer.parseInt(String.valueOf(InputKembalian.getText()));
            if(ab < 0){
                JOptionPane.showMessageDialog(null, "Uang anda kurang", "JonJelly", JOptionPane.WARNING_MESSAGE);
                InputUangBayar.setText("");
                InputKembalian.setText("");
            }else{
                try {
                    Connection c = Database.getKoneksi();
                    Statement s = c.createStatement();
                    String sql = "SELECT * FROM tmp_pesanan";
                    ResultSet r = s.executeQuery(sql);
                    while (r.next()) {
                        long millis=System.currentTimeMillis();
                        java.sql.Date date=new java.sql.Date(millis);
                        System.out.println(date); 
                        String tgl = date.toString();
                        String sqla = "INSERT INTO pesanan VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                         
                        PreparedStatement p = c.prepareStatement(sqla);
                        p.setString(1, InputIdPesanan.getText());
                        p.setString(2, r.getString("id_menu"));
                        p.setString(3, InputNamaPemesan.getText());
                        p.setString(4, r.getString("nama_menu"));
                        p.setString(5, r.getString("harga_menu"));
                        p.setString(6, r.getString("jumlah_beli"));
                        p.setString(7, InputTotalBeli.getText());
                        p.setString(8, InputUangBayar.getText());
                        p.setString(9, InputKembalian.getText());
                        p.setString(10, tgl);
                        p.executeUpdate();
                        p.close();
                    }
                    r.close();
                    s.close();
                } catch (SQLException e) {
                    System.out.println("Terjadi Error Insert Ke table pesanan");
                }finally{
                    try {
                        String sqla ="TRUNCATE `tmp_pesanan";java.sql.
                        Connection conn=(Connection)Database.getKoneksi();
                        java.sql.PreparedStatement pst=conn.prepareStatement(sqla);
                        pst.execute();
                        JOptionPane.showMessageDialog(null, "TRANSAKSI SELESAI", "JONJELLY", JOptionPane.INFORMATION_MESSAGE);
                        getTmpPesanan();
                        getLaporanPesanan();
                        getFaktur();
                        InputIdPesanan.setText(InputIdPesanan.getText());
                        InputNamaPemesan.setText("");
                        InputUangBayar.setText("");
                        InputKembalian.setText("");
                        InputTotalBeli.setText("");
                        BtnPrint.setEnabled(true);
                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, e.getMessage());
                        }
                    }
                }
            }
    }//GEN-LAST:event_BtnPayOrdersActionPerformed

    // Btn Count
    private void BtnCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCountActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = Database.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT SUM(`total_harga`) AS total FROM tmp_pesanan";
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()) {
                InputTotalBeli.setText(r.getString(""+"total"));
                InputUangBayar.setEnabled(true);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error Menghitung Total");
        }
        
    }//GEN-LAST:event_BtnCountActionPerformed

    // Btn Add Menu
    private void BtnAddMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddMenuActionPerformed
        // TODO add your handling code here:
        System.out.println("Kita pergi ke ShoppingCart staf Jon!");
        ShoppingCart SC=new ShoppingCart();
        SC.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        SC.setVisible(true);
    }//GEN-LAST:event_BtnAddMenuActionPerformed

    // Mouse Clicked Table Tmp Dellet Tmp
    private void TablePesananSementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePesananSementaraMouseClicked
        // TODO add your handling code here:
        int jawaban;
        if ( (jawaban = JOptionPane.showConfirmDialog(null,"Yakin batal?", "Konfirmasi", JOptionPane.YES_NO_OPTION) ) == 0) 
        {
            try{
                int i = TablePesananSementara.getSelectedRow();
                if (i == -1){
                    return;
                }
                String id = (String) tmp.getValueAt(i, 0);
                String sql ="DELETE FROM tmp_pesanan WHERE id_tmp='"+id+"'";
                java.sql.Connection conn=(Connection)Database.getKoneksi();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();

                getFaktur();
                getTmpPesanan();
            }catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_TablePesananSementaraMouseClicked

    // Btn Print
    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        // TODO add your handling code here:
        try{
            Desktop.getDesktop().browse(new URL("http://localhost/jonjelly_report/CustomerList.php").toURI());
            } catch (Exception e){
                System.out.println(e);
            }
    }//GEN-LAST:event_BtnPrintActionPerformed

    // Input Search
    private void SearchRelatedCartKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchRelatedCartKeyReleased
        // TODO add your handling code here:
        TblLaporan.getDataVector().removeAllElements();
        TblLaporan.fireTableDataChanged();

        try {
            Connection c = Database.getKoneksi();
            Statement s = c.createStatement();

            String srch = "SELECT * FROM pesanan "
                        + "WHERE id_pesanan LIKE '%" + SearchRelatedCart.getText() 
                        + "%' OR nama_cust LIKE '%" + SearchRelatedCart.getText() + "%'";
            ResultSet r = s.executeQuery(srch);

            while (r.next()) {
                Object[ ] SrchMenu = new Object[9];
                SrchMenu[0] = r.getString("id_pesanan");              
                SrchMenu[1] = r.getString("nama_cust");
                SrchMenu[2] = r.getString("nama_menu");
                SrchMenu[3] = r.getString("harga_menu");
                SrchMenu[4] = r.getString("jumlah_beli");
                SrchMenu[5] = r.getString("total_pembayaran");
                SrchMenu[6] = r.getString("uang_bayar");
                SrchMenu[7] = r.getString("kembalian");
                TblLaporan.addRow(SrchMenu);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Error Load Data Daftar pesanan");
        }
    }//GEN-LAST:event_SearchRelatedCartKeyReleased

    // Input Search Replace text
    private void SearchRelatedCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchRelatedCartMouseClicked
        // TODO add your handling code here:
        SearchRelatedCart.setText("");
    }//GEN-LAST:event_SearchRelatedCartMouseClicked

    // Input Search Replace text
    private void SearchRelatedCartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchRelatedCartMouseEntered
        // TODO add your handling code here:
        SearchRelatedCart.setText("");
    }//GEN-LAST:event_SearchRelatedCartMouseEntered

    // Input nama pemesan
    private void InputNamaPemesanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputNamaPemesanKeyReleased
        // TODO add your handling code here:
        FilterHuruf(evt);
        BtnCount.setEnabled(true);
    }//GEN-LAST:event_InputNamaPemesanKeyReleased

    // input uang bayar
    private void InputUangBayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputUangBayarKeyReleased
        // TODO add your handling code here:
        FilterAngka(evt);
        bayar = Integer.parseInt(String.valueOf(InputUangBayar.getText()));
        total = Integer.parseInt(String.valueOf(InputTotalBeli.getText()));
        kembali = bayar - total;
        InputKembalian.setText(Long.toString(kembali));
        BtnPayOrders.setEnabled(true);
    }//GEN-LAST:event_InputUangBayarKeyReleased

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
            CheckOut Co=new CheckOut();
            Co.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Co.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton BtnAddMenu;
    private javax.swing.JLabel BtnBack;
    private javax.swing.JButton BtnCount;
    private javax.swing.JButton BtnPayOrders;
    private javax.swing.JButton BtnPrint;
    private javax.swing.JTextField InputIdPesanan;
    private javax.swing.JTextField InputKembalian;
    private javax.swing.JTextField InputNamaPemesan;
    private javax.swing.JTextField InputTotalBeli;
    private javax.swing.JTextField InputUangBayar;
    private javax.swing.JLabel LblCust;
    private javax.swing.JLabel LblFaktur;
    private javax.swing.JLabel LblJumlahBeli;
    private javax.swing.JLabel LblJumlahBeli1;
    private javax.swing.JLabel LblTabelPesanan;
    private javax.swing.JLabel LblTotal;
    private javax.swing.JTextField SearchRelatedCart;
    private javax.swing.JTable TablePesananSementara;
    private javax.swing.JLabel TagPage;
    private javax.swing.JTable TblLaporanPenjualan;
    private javax.swing.JLabel icon_header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
