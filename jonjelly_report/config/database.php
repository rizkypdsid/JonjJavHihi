<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "jonjelly";

$connection = mysqli_connect($servername, $username, $password, $dbname);
if (!$connection){
        die("Connection Failed:".mysqli_connect_error());
    }
?>
