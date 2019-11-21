<?php
//sleep(1);
include "../../config/database.php";

$keyword = $_GET['keyword'];
$CustList = mysqli_query($connection,
                                        "SELECT DISTINCT id_pesanan, nama_cust, total_pembayaran, tangga_beli FROM pesanan WHERE id_pesanan LIKE '%$keyword%' 
                                        OR nama_cust LIKE '%$keyword%' 
                                        OR total_pembayaran LIKE '%$keyword%' 
                                        OR tangga_beli LIKE '%$keyword%'  
                                        ORDER BY id_pesanan DESC");
?>
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
                    <?php
                        if(mysqli_num_rows($CustList)>0){ 
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
                            <a class="btn btn-info btn-sm" href="struk.php?id=<?= $data["id_pesanan"]; ?>">
                            <i class="fas fa-print"></i> PRINT</a> 
                        </td>
                    </tr>
                    <?php $no++; } }?>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- End Content Table Data -->
        