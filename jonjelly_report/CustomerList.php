<?php
include "config/database.php";
$CustList = mysqli_query($connection,
                                        "SELECT DISTINCT id_pesanan, nama_cust, total_pembayaran, tangga_beli FROM pesanan ORDER BY id_pesanan DESC");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer List | JONJELLY</title>
    <link rel="icon" href="img/icon-png.png">
    <link rel="stylesheet" href="style/css/style.css">
    <link rel="stylesheet" href="style/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/vendor/fontawesome/css/fontawesome.css">
    <link rel="stylesheet" href="style/vendor/fontawesome/css/all.min.css">
    <script src="style/js/jquery-3.2.1.min.js"></script>
</head>
<body>
    <div class="container">
        <!-- Start Header -->
        <div class="row justify-content-md-center mt-2">
            <div class="col col-3 ">
                <img src="img/icon-png.png" alt="" width="60rem;" class="float-left mr-2 d-print-none">
                <h1 class="text-black-50 BrandTitle">JONJELLY</h1>
                <h2 class="BrandDesc text-black-50">- Jebule Ora Nepu</h2>
            </div>
            <div class="mx-auto text-center">
                <h2 class="text-black-50">Customer List</h2>
               <p class="DescTitleLaprn text-black-50 text-capitalize">last customer service</p>
            </div>
            <div class="col-3 text-right text-black-50">
                <?php 
                    date_default_timezone_set('Asia/Jakarta');
                    $jam=date("G:i:s a");
                    echo date('l, d-M-Y')  . "<br>" .  $jam  
                ?>
            </div>
        </div>
        <!-- End Header -->
        <!-- Start Search And Back -->
        <form autocomplete="off">
            <div class="form-group row d-print-none">
                <div class="col-sm-5 mr-auto">
                    <a href="index.php" class="btn btn-info BackToHome" title="back to home"></a>
                    <a href="javascript:printpdf();" class="btn btn-info CustDownload" title="Download List Customer"></a>
                </div>
                <div class="col-sm-5 ml-auto">
                <input type="text" class="form-control" name="keyword" id="keyword" placeholder="please insert id faktur..." >
                </div>
                <button type="submit"  name="cari" id="Btncari" class="btn btn-primary" disabled style="height:38px;"><i class="fas fa-search"></i> Search</button>
            </div>
        </form>
        <div class="row">
            <div class="col-sm-3 mx-auto d-print-none">
            <img src="img/loader.gif" alt=""  style="width: 250px;" id="loader">
            </div>
        </div>
        <!-- End Search And Back -->
        <!-- Start Content Table Data -->
        <div class="row mt-4">
            <div class="col col-lg-12">
                <div id="container">
                <table class="table table-striped mx-auto table-sm">
                    <thead>
                        <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID FAKTUR</th>
                        <th scope="col">NAME</th>
                        <th scope="col">SUBTOTAL</th>
                        <th scope="col">DATE</th>
                        <th scope="col" class="d-print-none">ACTION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php if(mysqli_num_rows($CustList)>0){ ?>
                        <?php
                            $no = 1;
                            while($data = mysqli_fetch_array($CustList)){
                                $payment=number_format($data['total_pembayaran'],0,",",".");
                        ?>
                        <tr>
                            <th scope="row"><?= $no ?></th>
                            <td><?= $data["id_pesanan"];?></td>
                            <td class="text-capitalize"><?= $data["nama_cust"];?></td>
                            <td>Rp. <?= $payment ?></td>
                            <td><?= $data["tangga_beli"];?></td>
                            <td class="d-print-none">
                                <a class="btn btn-info btn-sm" href="struk.php?id=<?= $data["id_pesanan"]; ?>" title="Print Struk">
                                <i class="fas fa-print"></i> PRINT</a> 
                            </td>
                        </tr>
                        <?php $no++; } ?>
                        <?php } ?>
                    </tbody>
                </table>
                </div>
            </div>
        </div>
        <!-- End Content Table Data -->
        <!-- Start Copyright  -->
        <div class="row">
            <div class="col fixed-bottom text-black-50  d-print-inline">
                <hr>
            Copyright © 2019 - Jonjelly. All rights reserved.
            </div>
        </div>
        <!-- End Copyright  -->
    </div>
    <script src="style/js/script.js"></script>
    <script>
        function printpdf() {
            window.print();
        }
    </script>
</body>
</html>