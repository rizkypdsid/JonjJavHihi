<?php
include "config/database.php";
$getCustList = mysqli_query($connection,
                                        "SELECT DISTINCT id_pesanan, nama_cust, total_pembayaran, tangga_beli FROM pesanan ORDER BY id_pesanan DESC");

$getListPayment = mysqli_query($connection, 
                                        "SELECT tangga_beli AS TANGGAL, SUM(DISTINCT total_pembayaran) AS TOTAL FROM pesanan GROUP BY tangga_beli");

header("Content-type: application/vnd-ms-excel");
header("Content-Disposition: attachment; filename=JonJelly-ReportPayment-excel.xls");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer List | JONJELLY</title>
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
                    <h1>Customer List</h1>
                    <h2>- last customer service</h2>
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
                <th>#</th>
                <th>ID FAKTUR</th>
                <th>NAME</th>
                <th>SUBTOTAL</th>
                <th>DATE</th>
            </tr>
        </thead>
        <tbody>
            <?php if(mysqli_num_rows($getCustList)>0){ ?>
            <?php
                $no = 1;
                while($data = mysqli_fetch_array($getCustList)){
                    $CustList=number_format($data['total_pembayaran'],0,",",".");
            ?>
            <tr>
                <th><?= $no ?></th>
                <td><?= $data["id_pesanan"];?></td>
                <td ><?= $data["nama_cust"];?></td>
                <td>Rp. <?= $CustList ?></td>
                <td><?= $data["tangga_beli"];?></td>
            </tr>
            <?php $no++; } ?>
            <?php } ?>
        </tbody>
    </table>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>DAILY PAYMENT</th>
                <th>TOTAL</th>
            </tr>
        </thead>
        <tbody>
            <?php if(mysqli_num_rows($getListPayment)>0){ ?>
            <?php
                $no = 1;
                while($data = mysqli_fetch_array($getListPayment)){
                    $payment=number_format($data['TOTAL'],0,",",".");
            ?>
            <tr>
                <th><?= $no ?></th>
                <td><?= $data["TANGGAL"];?></td>
                <td>Rp. <?= $payment ?></td>
            </tr>
            <?php $no++; } ?>
            <?php } ?>
        </tbody>
    </table>
</body>
</html>