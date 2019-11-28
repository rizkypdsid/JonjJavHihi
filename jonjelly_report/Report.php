<?php
include "config/database.php";
//  ambil field table menu, kategori & pesanan
$getListMenu = mysqli_query($connection,
                                        "SELECT menu.nama_menu, menu.harga_menu, kategori.nama_kategori, menu.stok_menu, pesanan.jumlah_beli FROM kategori JOIN menu ON kategori.id_kategori = menu.id_kategori JOIN pesanan ON menu.id_menu = pesanan.id_menu ORDER BY kategori.id_kategori ASC
                                        ");
//  ambil field table menu
$getAvailabeStockMenu = mysqli_query($connection, "SELECT SUM(stok_menu) AS AvailabeStockMenu FROM menu");
$getTotalAvailabeStock = mysqli_fetch_assoc($getAvailabeStockMenu); 

//  ambil field table pesanan
$getListSoldMenu = mysqli_query($connection, "SELECT SUM(jumlah_beli) AS SoldStockMenu FROM pesanan");
$getTotalSoldMenu = mysqli_fetch_assoc($getListSoldMenu); 

// hitung total stock menu
$getTotalStok =$getTotalAvailabeStock ['AvailabeStockMenu'] + $getTotalSoldMenu['SoldStockMenu'] ;

?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Report Menu | JONJELLY</title>
    <link rel="icon" href="img/icon-png.png">
    <link rel="stylesheet" href="style/css/style.css">
    <link rel="stylesheet" href="style/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/vendor/fontawesome/css/fontawesome.css">
    <link rel="stylesheet" href="style/vendor/fontawesome/css/all.min.css">
</head>
<body>
    <div class="container">
        <!-- Start Header -->
        <div class="row justify-content-md-center mt-2">
            <div class="col col-4">
                <h1 class="text-black-50 BrandTitle">JONJELLY</h1>
                <h2 class="text-black-50 BrandDesc">- Jebule Ora Nepu</h2>
            </div>
            <div class="mx-auto text-center">
                <h1 class="text-black-50 BrandTitle text-uppercase">report data menu</h1>
                <h2 class="text-black-50 BrandDesc  text-uppercase">- report data stok menu</h2>
            </div>
            <div class="col-3 text-right text-black-50 BrandTitle">
                <?php 
                    date_default_timezone_set('Asia/Jakarta');
                    $jam=date("G:i:s a");
                    echo date('l, d-M-Y')  . "<br>" .  $jam ;
                ?>
            </div>
        </div>
        <!-- End Header -->
        <!-- Start Content -->
        <div class="row mt-4">
            <!-- Start table data menu -->
            <div class="col-12 ">
                <table class="table table-striped mx-auto">
                    <thead>
                        <tr>
                            <th scope="col">NO</th>
                            <th scope="col">NAME</th>
                            <th scope="col">PRICE</th>
                            <th scope="col">AVAILABLE STOCK</th>
                            <th scope="col">SOLD STOCK</th>
                            <th scope="col">CATEGORY</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                            if( mysqli_num_rows($getListMenu)>0 ){ 
                                $no = 1;
                                while( $ListMenu = mysqli_fetch_array($getListMenu) ){
                        ?>
                        <tr>
                            <th scope="row"><?php echo $no ?></th>
                            <td><?php echo $ListMenu["nama_menu"];?></td>
                            <td><?php echo $ListMenu["harga_menu"];?></td>
                            <td><?php echo $ListMenu["stok_menu"];?></td>
                            <td><?php echo $ListMenu["jumlah_beli"];?></td>
                            <td><?php echo $ListMenu["nama_kategori"];?></td>
                        </tr>
                        <?php $no++; } }?>
                    </tbody>
                </table>
            </div>
            <!-- End table data menu -->
            <!-- Start table count stock menu -->
            <div class="col-12 mt-5">
                <table class="table mx-auto">
                    <thead>
                        <tr>
                            <th scope="col">TOTAL STOCK</th>
                            <th class="text-right"><?= $getTotalStok ?></th>
                        </tr>
                        <tr>
                            <th scope="col">TOTAL AVAILABLE STOCK</th>
                            <th class="text-right"><?= $getTotalAvailabeStock ['AvailabeStockMenu']; ?></th>
                        </tr>
                        <tr>
                            <th scope="col">TOTAL SOLD STOCK</th>
                            <th class="text-right"><?= $getTotalSoldMenu['SoldStockMenu'] ; ?></th>
                        </tr>
                    </thead>
                </table>
            </div>
            <!-- End table count stock menu -->
        </div>
        <!-- End Content -->
        <!-- Start Footer -->
        <div class="row">
            <div class="col fixed-bottom text-black-50 d-none d-print-inline">
                <hr>
                Copyright © 2019 - Jonjelly. All rights reserved.
            </div>
        </div>
        <!-- End Footer -->
    </div>
    <script type = "text/javascript">
        setTimeout('Redirect()', 1000);
        window.print();
        function Redirect() {
            window.location = "index.php";
        }            
    </script>
</body>
</html>
