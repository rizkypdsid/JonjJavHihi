<?php
include "config/database.php";
$menu = mysqli_query($connection,"SELECT menu.nama_menu, menu.harga_menu, kategori.nama_kategori, menu.stok_menu FROM kategori INNER JOIN menu ON kategori.id_kategori = menu.id_kategori  
ORDER BY kategori.nama_kategori ASC");
header("Content-type: application/vnd-ms-excel");
header("Content-Disposition: attachment; filename=JonJelly-DataMenu-excel.xls");
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Report Menu | JONJELLY</title>
    <link rel="icon" href="img/icon-png.png">
    <style type="text/css">
        * {box-sizing: border-box;}
        body{font-family:sans-serif}
        .title{text-align:center;color:#adadad;}
        .title h1{font-size: 32px;}
        .title h2{font-size: 14px;margin-top: -20px;}
        .title h3{font-size: 18px;margin-top: 30px;}
        .title {
            float: left;
            width: 25%;
            padding: 0 10px;
            position: relative;
            left: 350px;
        }
        .row {margin: 0 -5px;}
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
        table{margin:20px auto;border-collapse:collapse}
        table td,table th{border:1px solid #3c3c3c;padding:3px 8px}
     </style>
</head>
<body>
    <table>
        <thead>
            <div class="row">
                <div class="title">
                    <h1>Laporan Data Menu</h1>
                    <h2>- Laporan Stok Data Menu</h2>
                </div>
                <div class="title">
                    <h3>
                    <?php 
                        date_default_timezone_set('Asia/Jakarta');
                        $jam=date("G:i:s a");
                        echo date('l, d-M-Y')  . "<br>" .  $jam ;
                    ?>
                    </h3>
                </div>
            </div>
        </thead>
        <tr>
            <th>NO</th>
			<th>NAMA MENU</th>
			<th>HARGA</th>
			<th>STOK</th>
			<th>CATEGORY</th>
        </tr>
        <?php
        if( mysqli_num_rows($menu)>0 ){ 
        $no = 1;
        while( $data = mysqli_fetch_array($menu )){
            ?>
            <tr>
                <th scope="row"><?php echo $no ?></th>
                <td><?php echo $data["nama_menu"];?></td>
                <td><?php echo $data["harga_menu"];?></td>
                <td><?php echo $data["stok_menu"];?></td>
                <td><?php echo $data["nama_kategori"];?></td>
            </tr>
        <?php $no++; } } ?>
    </table>
</body>
</html>
