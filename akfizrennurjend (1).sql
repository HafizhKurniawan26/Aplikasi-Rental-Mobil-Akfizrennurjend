-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2025 at 04:55 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `akfizrennurjend`
--

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `id_mobil` varchar(11) NOT NULL,
  `merk` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `tahun` int(11) NOT NULL,
  `no_plat` varchar(15) NOT NULL,
  `harga_sewa` int(10) NOT NULL,
  `status` enum('tersedia','disewa','maintenance') DEFAULT 'tersedia'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`id_mobil`, `merk`, `model`, `tahun`, `no_plat`, `harga_sewa`, `status`) VALUES
('DHS001', 'Daihatsu', 'Sigra', 2018, 'F5273DFG', 300000, 'disewa'),
('DHS002', 'Daihatsu', 'Terios', 2023, 'B6832WBK', 700000, 'tersedia'),
('DHS003', 'Daihatsu', 'Ayla', 2017, 'F9202GJS', 200000, 'maintenance'),
('HND', 'Honda', 'Civic', 2020, 'B9023BJD', 800000, 'tersedia'),
('HND001', 'Honda', 'Brio', 2020, 'A6382KJS', 300000, 'tersedia'),
('HND002', 'Honda', 'Jazz', 2021, 'B54799TYU', 400000, 'disewa'),
('MTS001', 'Mitsubishi', 'Xpander', 2020, 'B5437DSA', 500000, 'maintenance'),
('MTS002', 'Mitsubishi', 'Pajero', 2021, 'B7956LKJ', 600000, 'disewa'),
('TYT001', 'Toyota', 'Avanza', 2020, 'B6281WCL', 200000, 'maintenance'),
('TYT002', 'Toyota', 'Fortuner', 2023, 'B5273RFH', 500000, 'tersedia'),
('TYT003', 'Toyota', 'Agya', 2020, 'B5826CDG', 200000, 'tersedia'),
('TYT004', 'Toyota', 'Rush', 2020, 'B6281HTR', 600000, 'tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `jabatan` varchar(50) NOT NULL,
  `gaji` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `id_user`, `jabatan`, `gaji`) VALUES
('MN001', 7, 'staff penjualan', '8000000'),
('MN002', 12, 'manajer operasional', '8000000'),
('SP001', 9, 'staff penjualan', '5000000'),
('SP002', 14, 'staff penjualan', '5000000'),
('SP003', 15, 'staff penjualan', '5000000');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `id_rental` int(11) NOT NULL,
  `metode_pembayaran` enum('transfer','tunai') NOT NULL,
  `jumlah_bayar` int(10) NOT NULL,
  `tanggal_bayar` datetime NOT NULL,
  `status` enum('pending','lunas','gagal') DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_rental`, `metode_pembayaran`, `jumlah_bayar`, `tanggal_bayar`, `status`) VALUES
(9, 20, 'transfer', 400000, '2025-06-22 00:00:00', 'pending'),
(10, 21, 'transfer', 500000, '2025-06-06 00:00:00', 'lunas'),
(11, 22, 'tunai', 900000, '2025-01-01 00:00:00', 'lunas'),
(13, 23, 'transfer', 300000, '2025-01-03 00:00:00', 'lunas'),
(14, 24, 'transfer', 600000, '2025-01-03 00:00:00', 'pending'),
(15, 25, 'transfer', 300000, '2025-06-27 00:00:00', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE `rental` (
  `id_rental` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_mobil` varchar(11) NOT NULL,
  `tanggal_sewa` datetime NOT NULL,
  `tanggal_kembali` datetime NOT NULL,
  `total_biaya` int(10) NOT NULL,
  `status` enum('pending','diproses','selesai','dibatalkan') DEFAULT 'pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rental`
--

INSERT INTO `rental` (`id_rental`, `id_user`, `id_mobil`, `tanggal_sewa`, `tanggal_kembali`, `total_biaya`, `status`) VALUES
(19, 11, 'HND001', '2025-06-25 00:00:00', '2025-06-27 00:00:00', 600000, 'selesai'),
(20, 11, 'HND002', '2025-06-26 00:00:00', '2025-06-27 00:00:00', 400000, 'dibatalkan'),
(21, 11, 'MTS001', '2025-05-05 00:00:00', '2025-05-06 00:00:00', 500000, 'selesai'),
(22, 10, 'HND', '2025-01-01 00:00:00', '2025-01-03 00:00:00', 1600000, 'selesai'),
(23, 10, 'HND001', '2025-01-02 00:00:00', '2025-01-03 00:00:00', 300000, 'selesai'),
(24, 13, 'MTS002', '2025-01-01 00:00:00', '2025-01-02 00:00:00', 600000, 'diproses'),
(25, 11, 'DHS001', '2025-06-26 00:00:00', '2025-06-27 00:00:00', 300000, 'diproses');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nik` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(3000) NOT NULL,
  `role` enum('pelanggan','pegawai','admin') DEFAULT 'pelanggan',
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nama`, `nik`, `email`, `password`, `role`, `alamat`) VALUES
(7, 'ayu', '231011001', 'ayu@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'admin', 'bandung'),
(9, 'budi', '231011002', 'budi@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pegawai', 'Bogor'),
(10, 'zaki', '231011003', 'zaki@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pelanggan', 'jakarta'),
(11, 'ahmad', '231011004', 'ahmad@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pelanggan', 'tangerang'),
(12, 'hafizh', '231011005', 'hafizh@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'admin', 'tangerang'),
(13, 'rendi', '231011006', 'rendi@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pelanggan', 'jakarta'),
(14, 'ibnu', '231011007', 'ibnu@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pegawai', 'poncab'),
(15, 'akmal', '231011008', 'akmal@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pegawai', 'jakarta'),
(16, 'nurya', '231011009', 'nurya@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pelanggan', 'pamulang'),
(17, 'jendra', '231011010', 'jendra@gmail.com', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 'pelanggan', 'ciputat');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id_mobil`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `id_user` (`id_user`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `pembayaran_ibfk_1` (`id_rental`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`id_rental`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `rental_ibfk_2` (`id_mobil`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `rental`
--
ALTER TABLE `rental`
  MODIFY `id_rental` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `pegawai_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_rental`) REFERENCES `rental` (`id_rental`) ON DELETE CASCADE;

--
-- Constraints for table `rental`
--
ALTER TABLE `rental`
  ADD CONSTRAINT `rental_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  ADD CONSTRAINT `rental_ibfk_2` FOREIGN KEY (`id_mobil`) REFERENCES `mobil` (`id_mobil`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
