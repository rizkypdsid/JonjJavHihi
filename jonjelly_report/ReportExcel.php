<?php
include "config/database.php";
//  table menu, kategori & pesanan
$getListMenu = mysqli_query($connection,
                                        "SELECT menu.nama_menu, menu.harga_menu, kategori.nama_kategori, menu.stok_menu, pesanan.jumlah_beli FROM kategori JOIN menu ON kategori.id_kategori = menu.id_kategori JOIN pesanan ON menu.id_menu = pesanan.id_menu ORDER BY kategori.nama_kategori ASC
                                        ");
//  table menu
$getAvailabeStockMenu = mysqli_query($connection, "SELECT SUM(stok_menu) AS AvailabeStockMenu FROM menu");
$getTotalAvailabeStock = mysqli_fetch_assoc($getAvailabeStockMenu); 

//  table pesanan
$getListSoldMenu = mysqli_query($connection, "SELECT SUM(jumlah_beli) AS SoldStockMenu FROM pesanan");
$getTotalSoldMenu = mysqli_fetch_assoc($getListSoldMenu); 

// hitung total stock menu
$getTotalStok =$getTotalAvailabeStock ['AvailabeStockMenu'] + $getTotalSoldMenu['SoldStockMenu'] ;

header("Content-type: application/vnd-ms-excel");
header("Content-Disposition: attachment; filename=JonJelly-ReportDataMenu-excel.xls");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Report Menu | JONJELLY</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
            text-transform: uppercase;
            }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr th h1{
            color: #2d3436;
            text-align: center;
            font-size: 22px;
        }
        tr th h2{
            color: #636e72;
            text-align: center;
            font-size: 14px;
            margin-top: -10px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>
                    <h1>JONJELLY</h1>
                    <h2>- Jebule Ora Nepu</h2>
                </th>
                <th>
                    <h1>report data menu</h1>
                    <h2>- report data stok menu</h2>
                </th>
                <th>
                    <?php 
                        date_default_timezone_set('Asia/Jakarta');
                        $jam=date("G:i:s a");
                        echo '<h1>' . date('l, d-M-Y') . '</h1>'  . 
                        '<h2>'  .  $jam  . '</h2>';
                    ?>
                </th>
            </tr>
        </thead>
    </table>
    <table>
        <thead>
            <tr>
                <th>NO</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>AVAILABLE STOCK</th>
                <th>SOLD STOCK</th>
                <th>CATEGORY</th>
            </tr>
        </thead>
        <tbody>
            <?php
                if( mysqli_num_rows($getListMenu)>0 ){ 
                    $no = 1;
                    while( $ListMenu = mysqli_fetch_array($getListMenu) ){
            ?>
            <tr>
                <th><?php echo $no ?></th>
                <td><?php echo $ListMenu["nama_menu"];?></td>
                <td><?php echo $ListMenu["harga_menu"];?></td>
                <td><?php echo $ListMenu["stok_menu"];?></td>
                <td><?php echo $ListMenu["jumlah_beli"];?></td>
                <td><?php echo $ListMenu["nama_kategori"];?></td>
            </tr>
            <?php $no++; } }?>
        </tbody>
    </table>
    <table>
        <thead>
            <tr>
                <th>TOTAL STOCK</th>
                <td><?= $getTotalStok ?></td>
            </tr>
            <tr>
                <th>TOTAL AVAILABLE STOCK</th>
                <td><?= $getTotalAvailabeStock ['AvailabeStockMenu']; ?></td>
            </tr>
            <tr>
                <th>TOTAL SOLD STOCK</th>
                <td><?= $getTotalSoldMenu['SoldStockMenu'] ; ?></td>
            </tr>
        </thead>
    </table>
</body>
</html>
