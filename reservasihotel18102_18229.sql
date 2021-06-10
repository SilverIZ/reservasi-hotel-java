-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 05, 2021 at 08:40 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reservasihotel18102_18229`
--
CREATE DATABASE IF NOT EXISTS `reservasihotel18102_18229` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `reservasihotel18102_18229`;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `reservasi`
--

CREATE TABLE `reservasi` (
  `id_pesanan` int(50) NOT NULL,
  `nama_pemesan` varchar(50) NOT NULL,
  `nik` varchar(50) NOT NULL,
  `checkin` varchar(50) NOT NULL,
  `lama_booking` int(10) NOT NULL,
  `jumlah_kamar` int(10) NOT NULL,
  `jenis_kamar` varchar(50) NOT NULL,
  `paket_menu` varchar(50) NOT NULL,
  `fasilitas` varchar(100) NOT NULL,
  `harga_kamar` int(50) NOT NULL,
  `tambahan` int(50) NOT NULL,
  `total_harga` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservasi`
--

INSERT INTO `reservasi` (`id_pesanan`, `nama_pemesan`, `nik`, `checkin`, `lama_booking`, `jumlah_kamar`, `jenis_kamar`, `paket_menu`, `fasilitas`, `harga_kamar`, `tambahan`, `total_harga`) VALUES
(30, 'iskandar zulkarnaen', '3209271101010101', '2021-01-13', 5, 5, 'Deluxe ', 'Lunch Dinner', 'Double Bed + Bathroom + AC + TV + Internet', 600000, 90000, 3090000),
(31, 'last stardust', '23556667', '2021-01-14', 4, 5, 'Reguler', 'Breakfast Lunch', 'Double Bed + Bathroom + AC', 500000, 85000, 2585000),
(32, 'last stardust', '23556667', '2021-01-14', 4, 5, 'Reguler', 'Breakfast Lunch', 'Double Bed + Bathroom + AC', 500000, 85000, 2585000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `id_pesanan` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
