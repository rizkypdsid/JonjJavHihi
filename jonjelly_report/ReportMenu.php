<?php
include "config/database.php";
$getListMenu = mysqli_query($connection,
                                        "SELECT menu.nama_menu, menu.harga_menu, kategori.nama_kategori, menu.stok_menu FROM kategori INNER JOIN menu ON kategori.id_kategori = menu.id_kategori  
                                        ORDER BY kategori.nama_kategori ASC");
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
</head>
<body>
    <div class="container">
        <!-- Start Header -->
        <div class="row justify-content-md-center mt-2">
            <div class="col col-4">
                <img src="img/icon-png.png" alt="" width="60rem;" class="float-left mr-2 d-print-none">
                <h1 class="text-black-50 BrandTitle">JONJELLY</h1>
                <h2 class="BrandDesc text-black-50">- Jebule Ora Nepu</h2>
            </div>
            <div class="mx-auto text-center">
                <h1 class="text-black-50 BrandTitle text-uppercase">laporan data menu</h1>
                <h2 class="BrandDesc text-black-50 text-uppercase">- laporan stok data menu</h2>
            </div>
            <div class="col-3 text-right BrandTitle text-black-50">
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
            <div class="col-12 ">
                <table class="table table-striped mx-auto">
                    <thead>
                        <tr>
                        <th scope="col">NO</th>
                        <th scope="col">NAMA MENU</th>
                        <th scope="col">HARGA</th>
                        <th scope="col">STOK</th>
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
                            <td><?php echo $ListMenu["nama_kategori"];?></td>
                        </tr>
                        <?php $no++; } }?>
                    </tbody>
                </table>
            </div>
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
        window.print();
        function Redirect() {
            window.location = "index.php";
        }            
        setTimeout('Redirect()', 1000);
    </script>
</body>
</html>