-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2019 at 06:24 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jonjelly`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(10) NOT NULL,
  `nama_kategori` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(1, 'Drink'),
(2, 'Snacks'),
(3, 'Extra');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id_menu` varchar(20) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `nama_menu` varchar(150) NOT NULL,
  `harga_menu` int(11) NOT NULL,
  `stok_menu` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id_menu`, `id_kategori`, `nama_menu`, `harga_menu`, `stok_menu`) VALUES
('M0001', 1, 'Blend Coffee', 10000, 43),
('M0002', 1, 'Blend Strawberry javachip', 10000, 44),
('M0003', 1, 'Blend Cookies & cream', 10000, 42),
('M0004', 1, 'Chocolate Milkshake', 10000, 45),
('M0005', 1, 'Banana Milkshake', 10000, 41),
('M0006', 1, 'Strawberry Milkshake', 10000, 43),
('M0007', 2, 'Nacho Cheese', 20000, 42),
('M0008', 2, 'Chicken Bruschetta', 30000, 34),
('M0009', 2, 'Chicken Wings', 25000, 46),
('M0010', 2, 'Aussie Yuu Beef ', 35000, 43),
('M0012', 3, 'Chocochips Cookies', 5000, 47),
('M0013', 3, 'Cherry Chocolate Bombs', 7500, 43),
('M0014', 3, 'Cream Ball Love', 5000, 44),
('M0015', 3, 'Coconut Jelly Chocolate', 1500, 35),
('M0016', 3, 'Jelly Cream Cookies', 3500, 36),
('M0017', 3, 'Banana Dragon Cream', 5000, 44);

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id_pesanan` varchar(20) NOT NULL,
  `id_menu` varchar(20) NOT NULL,
  `nama_cust` varchar(100) NOT NULL,
  `nama_menu` varchar(150) NOT NULL,
  `harga_menu` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `total_pembayaran` int(11) NOT NULL,
  `uang_bayar` int(11) NOT NULL,
  `kembalian` int(11) NOT NULL,
  `tangga_beli` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`id_pesanan`, `id_menu`, `nama_cust`, `nama_menu`, `harga_menu`, `jumlah_beli`, `total_pembayaran`, `uang_bayar`, `kembalian`, `tangga_beli`) VALUES
('F0001', 'M0004', 'alfa', 'Chocolate Milkshake', 10000, 5, 137500, 150000, 12500, '2019-11-27'),
('F0001', 'M0013', 'alfa', 'Cherry Chocolate Bombs', 7500, 5, 137500, 150000, 12500, '2019-11-27'),
('F0001', 'M0009', 'alfa', 'Chicken Wings', 25000, 2, 137500, 150000, 12500, '2019-11-27'),
('F0002', 'M0002', 'alfi', 'Blend Strawberry javachip', 10000, 6, 138000, 150000, 12000, '2019-11-27'),
('F0002', 'M0015', 'alfi', 'Coconut Jelly Chocolate', 1500, 12, 138000, 150000, 12000, '2019-11-27'),
('F0002', 'M0007', 'alfi', 'Nacho Cheese', 20000, 3, 138000, 150000, 12000, '2019-11-27'),
('F0003', 'M0015', 'beta', 'Coconut Jelly Chocolate', 1500, 3, 304500, 350000, 45500, '2019-11-27'),
('F0003', 'M0003', 'beta', 'Blend Cookies & cream', 10000, 6, 304500, 350000, 45500, '2019-11-27'),
('F0003', 'M0005', 'beta', 'Banana Milkshake', 10000, 7, 304500, 350000, 45500, '2019-11-27'),
('F0003', 'M0009', 'beta', 'Chicken Wings', 25000, 2, 304500, 350000, 45500, '2019-11-27'),
('F0003', 'M0008', 'beta', 'Chicken Bruschetta', 30000, 4, 304500, 350000, 45500, '2019-11-27'),
('F0004', 'M0001', 'beti', 'Blend Coffee', 10000, 7, 140000, 150000, 10000, '2019-11-27'),
('F0004', 'M0010', 'beti', 'Aussie Yuu Beef ', 35000, 2, 140000, 150000, 10000, '2019-11-27'),
('F0005', 'M0006', 'caca', 'Strawberry Milkshake', 10000, 7, 227000, 250000, 23000, '2019-11-28'),
('F0005', 'M0017', 'caca', 'Banana Dragon Cream', 5000, 3, 227000, 250000, 23000, '2019-11-28'),
('F0005', 'M0016', 'caca', 'Jelly Cream Cookies', 3500, 12, 227000, 250000, 23000, '2019-11-28'),
('F0005', 'M0007', 'caca', 'Nacho Cheese', 20000, 5, 227000, 250000, 23000, '2019-11-28'),
('F0006', 'M0005', 'cici', 'Banana Milkshake', 10000, 2, 380000, 400000, 20000, '2019-11-28'),
('F0006', 'M0008', 'cici', 'Chicken Bruschetta', 30000, 4, 380000, 400000, 20000, '2019-11-28'),
('F0006', 'M0008', 'cici', 'Chicken Bruschetta', 30000, 8, 380000, 400000, 20000, '2019-11-28'),
('F0007', 'M0013', 'eca', 'Cherry Chocolate Bombs', 7500, 2, 235000, 250000, 15000, '2019-11-28'),
('F0007', 'M0014', 'eca', 'Cream Ball Love', 5000, 6, 235000, 250000, 15000, '2019-11-28'),
('F0007', 'M0012', 'eca', 'Chocochips Cookies', 5000, 3, 235000, 250000, 15000, '2019-11-28'),
('F0007', 'M0010', 'eca', 'Aussie Yuu Beef ', 35000, 5, 235000, 250000, 15000, '2019-11-28'),
('F0008', 'M0003', 'eci', 'Blend Cookies & cream', 10000, 2, 42000, 50000, 8000, '2019-11-29'),
('F0008', 'M0017', 'eci', 'Banana Dragon Cream', 5000, 3, 42000, 50000, 8000, '2019-11-29'),
('F0008', 'M0016', 'eci', 'Jelly Cream Cookies', 3500, 2, 42000, 50000, 8000, '2019-11-29');

-- --------------------------------------------------------

--
-- Table structure for table `tmp_pesanan`
--

CREATE TABLE `tmp_pesanan` (
  `id_tmp` int(20) NOT NULL,
  `id_menu` varchar(20) NOT NULL,
  `nama_menu` varchar(150) NOT NULL,
  `harga_menu` int(11) NOT NULL,
  `jumlah_beli` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(20) NOT NULL,
  `nama_user` varchar(200) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `username_user` varchar(50) NOT NULL,
  `password_user` varchar(50) NOT NULL,
  `email_user` varchar(150) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama_user`, `jabatan`, `username_user`, `password_user`, `email_user`, `no_telp`, `jenis_kelamin`, `alamat`) VALUES
('U0001', 'JonJelly', 'Staf', 'admin', 'admin', 'jonjelly@jonjell.com', '628954545', 'Laki-Laki', 'swedia'),
('U0002', 'staf jj', 'Staf', 'staf', 'staf', 'staf@jonjelly.com', '62895543', 'Laki-Laki', 'irlandia'),
('U0003', 'Putri Novitasari', 'Karyawan', 'putrinari', '28b8d8e0', 'putrinari@gmail.com', '628594891943', 'Perempuan', 'Ds. Bata Putih No. 601, Probolinggo 81722, SulSel'),
('U0004', 'Devi Stiani Putri', 'Staf', 'devi', '13180800', 'devi@jonjelly.com', '6259777', 'Perempuan', 'bogor'),
('U0005', 'Ahmad firdaus', 'Staf', 'daus', '13180393', 'daus@jonjelly.com', '6281245464', 'Laki-Laki', 'veteran'),
('U0006', 'Irfan Aziz', 'Staf', 'irfan', '13180868', 'irfan@jonjelly.com', '628123545', 'Laki-Laki', 'jabodetabek'),
('U0007', 'Muhammad Iqbal Saputra', 'Staf', 'iqbal', '13180139', 'iqbal@jonjelly.com', '62895646546', 'Laki-Laki', 'tanggerang'),
('U0008', 'PEBRYANSYAH KABYANTO WIBOWO', 'Staf', 'panji', '13180424', 'panji@jonjelly.com', '628956646446', 'Laki-Laki', 'bogor'),
('U0009', 'Rio Deswanto', 'Staf', 'rio', '13180746', 'rio@jonjelly.com', '6289554654', 'Laki-Laki', 'bogor'),
('U0010', 'RIZKY PRIA DWI SANTOSO', 'Staf', 'rizky', '13180401', 'rizky@jonjelly.com', '62895464654', 'Laki-Laki', 'depok'),
('U0013', 'Fathonah Lailasari', 'Karyawan', 'pratama.ellis', '&MV:0[8._i4v.R::0', 'maria94@purwanti.co', ' 6289869466 202', 'Perempuan', 'Psr. Basket No. 212, Binjai 37870, JaBar'),
('U0015', 'Cinta Maryati', 'Karyawan', 'cintaati', '6888d295', 'cintaati@gmail.com', '628849673377', 'Perempuan', 'Kpg. Bata Putih No. 483, Madiun 18915, DIY'),
('U0016', 'Halima Rahayu', 'Karyawan', 'halimaayu', '560c15a9', 'halimaayu@gmail.com', '6282859844912', 'Perempuan', 'Kpg. Sam Ratulangi No. 376, Yogyakarta 53979, Maluku'),
('U0017', 'Sadina Prastuti S.IP', 'Karyawan', 'sadinip', 'cc7f89d7', '222sadinip@gmail.com', '6282871390327', 'Perempuan', 'Ki. W.R. Supratman No. 655, Padangsidempuan 31244, KalBar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- Indexes for table `tmp_pesanan`
--
ALTER TABLE `tmp_pesanan`
  ADD PRIMARY KEY (`id_tmp`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username_user` (`username_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tmp_pesanan`
--
ALTER TABLE `tmp_pesanan`
  MODIFY `id_tmp` int(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
