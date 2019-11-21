<?php
include "config/database.php";
$id =$_GET["id"];

$invoice = mysqli_query($connection,
                                        "SELECT DISTINCT id_pesanan, nama_cust FROM pesanan WHERE id_pesanan = '$id' ");
$faktur = mysqli_fetch_array($invoice);

$payment = mysqli_query($connection,
                                        "SELECT DISTINCT id_pesanan, total_pembayaran, uang_bayar, kembalian FROM pesanan WHERE id_pesanan = '$id' ");

$ListMenu = mysqli_query($connection, "SELECT * FROM pesanan WHERE id_pesanan = '$id' ");


if (empty($id) ) {
    header('Location: CustomerList.php');
    exit;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Struk Customer | JONJELLY</title>
    <link rel="icon" href="img/icon-png.png">
    <link rel="stylesheet" href="style/css/style.css">
    <link rel="stylesheet" href="style/vendor/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <!-- Start Grid -->
        <div class="col col-6 mx-auto">
            <!-- Start Card Invoice -->
            <div class="card">
                <!-- Start Invoice Id -->
                <div class="card-header"> 
                    <div class="row">
                        <div class="col-sm font-weight-bold">
                        Invoice Code : <?= $faktur["id_pesanan"];?>
                        </div>
                        <div class="col-sm-auto font-weight-bold">
                            <?php 
                            date_default_timezone_set('Asia/Jakarta');
                            echo date('l, d-M-Y') ;
                            ?>
                        </div>
                    </div>
                </div>
                <!-- End Invoice Id -->
                <!-- Start Invoice Content -->
                <div class="card-body">
                    <!-- Start Invoice Header -->
                    <div class="row  mb-3">
                        <div class="col-sm-7 mt-4 ">
                            <img src="img/icon-png.png" alt="jonjelly" style="width: 5rem;" class="float-left  ml-4  mr-2">
                            <h2 class="text-black-50">JonJelly</h2>
                            <h6 class="text-black-50">Jebule Ora Nepu</h6>
                        </div>
                        <div class="col-sm-5">
                            <p>
                                <small class="text-black-50">Alamat  : Jalan RS Fatmawati Blok Ry No.24, RT.7/RW.1, Pd. Labu. Jakarta Selatan, Jakarta 12450</small>
                            </p>
                        </div>
                        <div class="col-sm">
                            <h5 class=" text-center mt-2 text-black-50">
                                Thank You! <strong class="text-body text-capitalize"><?= $faktur["nama_cust"];?></strong> Have a nice day!
                            </h5>
                        </div>
                    </div>
                    <!-- End Invoice Header -->
                    <!-- Start Invoice List Item -->
                    <div class="table-responsive-sm">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Item</th>
                                    <th scope="col"  >Qty</th>
                                    <th scope="col"  >Price </th>
                                </tr>
                            </thead>
                            <tbody>
                                <?php
                                    if( mysqli_num_rows($ListMenu)>0 ) { 
                                        $no = 1;
                                        while( $data = mysqli_fetch_array($ListMenu) ){
                                            $harga=number_format($data['harga_menu'],0,",",".");
                                ?>
                                <tr>
                                    <th scope="row"><?= $no ?></th>
                                    <td><?= $data["nama_menu"];?></td>
                                    <td><?= $data["jumlah_beli"];?></td>
                                    <td>Rp. <?= $harga?>/pcs</td>
                                </tr>
                                <?php $no++; } }?>
                            </tbody>
                        </table>
                    </div>
                    <!-- End Invoice List Item -->
                    <!-- Start Invoice Payment Item -->
                    <div class="row">
                        <div class="col-sm-5">
                            <img src="img/thanks.png" alt="Thanks" style="width: 10rem;" class="mt-2 ml-4">
                        </div>
                        <div class="col-sm-7">
                            <table class="table table-clear">
                                <tbody>
                                    <?php
                                        while($data = mysqli_fetch_array($payment)){
                                        $subtotal=number_format($data['total_pembayaran'],0,",",".");
                                        $cash=number_format($data['uang_bayar'],0,",",".");
                                        $change=number_format($data['kembalian'],0,",",".");
                                    ?>
                                    <tr>
                                        <td class="left"><strong>Subtotal</strong></td>
                                        <td>Rp. <?=  $subtotal ?></td>
                                    </tr>
                                    <tr>
                                        <td class="left"> <strong>Cash</strong></td>
                                        <td>Rp. <?= $cash ?></td>
                                    </tr>
                                    <tr>
                                        <td class="left"><strong>Change</strong></td>
                                        <td>Rp. <?= $change ?></td>
                                    </tr>
                                    <?php  } ?>
                                </tbody>
					        </table>
				        </div>
                    </div>
                    <!-- Start Invoice Payment Item -->
                    <hr>
                    <p class="text-black-50 text-center"><small>Copyright © 2019 - Jonjelly. All rights reserved.</small></p>
		        </div>
            </div>
            <!-- End Card Invoice -->
        </div>
        <!-- End Grid -->
    </div>
</div>
<script type = "text/javascript">
    window.print();
    function Redirect() {
        window.location = "CustomerList.php";
    }            
    setTimeout('Redirect()', 1000);
</script>
</body>
</html>