-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2017 at 06:27 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_peramalan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_admin`
--

CREATE TABLE IF NOT EXISTS `tbl_admin` (
  `id_admin` varchar(8) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_admin`
--

INSERT INTO `tbl_admin` (`id_admin`, `username`, `password`) VALUES
('US001', 'admin', 'admin'),
('US002', 'user', 'user'),
('US003', 'moses', 'moses');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_beli`
--

CREATE TABLE IF NOT EXISTS `tbl_beli` (
  `kd_beli` varchar(8) NOT NULL,
  `kd_pemasok` varchar(8) NOT NULL,
  `kd_persediaan` varchar(8) NOT NULL,
  `tgl_beli` date NOT NULL,
  `jml_kayu` int(9) NOT NULL,
  `harga` int(9) NOT NULL,
  PRIMARY KEY (`kd_beli`),
  KEY `kd_persediaan` (`kd_persediaan`),
  KEY `kd_pemasok` (`kd_pemasok`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_beli`
--

INSERT INTO `tbl_beli` (`kd_beli`, `kd_pemasok`, `kd_persediaan`, `tgl_beli`, `jml_kayu`, `harga`) VALUES
('B001', 'S001', 'K001', '2017-04-11', 20, 600000),
('B002', 'S002', 'K003', '2017-05-12', 25, 55555),
('B003', 'S001', 'K001', '2017-06-12', 30, 666);

--
-- Triggers `tbl_beli`
--
DROP TRIGGER IF EXISTS `INPUT_BELI`;
DELIMITER //
CREATE TRIGGER `INPUT_BELI` BEFORE INSERT ON `tbl_beli`
 FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok+NEW.jml_kayu  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `UPDATE_BELI`;
DELIMITER //
CREATE TRIGGER `UPDATE_BELI` AFTER UPDATE ON `tbl_beli`
 FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok-(OLD.jml_kayu-NEW.jml_kayu)  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_jenis`
--

CREATE TABLE IF NOT EXISTS `tbl_jenis` (
  `kd_jenis` varchar(8) NOT NULL,
  `nama_jenis` varchar(25) NOT NULL,
  PRIMARY KEY (`kd_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_jenis`
--

INSERT INTO `tbl_jenis` (`kd_jenis`, `nama_jenis`) VALUES
('J001', 'Kampas'),
('J002', 'Mahoni'),
('J003', 'Bengkirai');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pakai`
--

CREATE TABLE IF NOT EXISTS `tbl_pakai` (
  `kd_pakai` varchar(8) NOT NULL,
  `kd_persediaan` varchar(8) NOT NULL,
  `tgl_pakai` date NOT NULL,
  `jml_pakai` int(11) NOT NULL,
  PRIMARY KEY (`kd_pakai`),
  KEY `kd_persediaan` (`kd_persediaan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pakai`
--

INSERT INTO `tbl_pakai` (`kd_pakai`, `kd_persediaan`, `tgl_pakai`, `jml_pakai`) VALUES
('P001', 'K001', '2016-05-01', 50),
('P002', 'K001', '2016-06-01', 38),
('P003', 'K001', '2016-07-01', 31),
('P004', 'K001', '2016-08-01', 27),
('P005', 'K001', '2016-09-01', 34),
('P006', 'K001', '2016-10-01', 40),
('P007', 'K001', '2016-11-01', 54),
('P008', 'K001', '2016-12-01', 50),
('P009', 'K001', '2017-01-01', 44),
('P010', 'K001', '2017-02-01', 75),
('P011', 'K001', '2017-03-01', 81),
('P012', 'K001', '2017-04-01', 42),
('P013', 'K002', '2017-04-01', 43),
('P014', 'K002', '2017-05-01', 58),
('P015', 'K002', '2017-06-01', 50),
('P016', 'K002', '2017-07-01', 38),
('P017', 'K002', '2017-08-01', 31);

--
-- Triggers `tbl_pakai`
--
DROP TRIGGER IF EXISTS `INPUT_PAKAI`;
DELIMITER //
CREATE TRIGGER `INPUT_PAKAI` AFTER INSERT ON `tbl_pakai`
 FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok-NEW.jml_pakai  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `UPDATE_PAKAI`;
DELIMITER //
CREATE TRIGGER `UPDATE_PAKAI` AFTER UPDATE ON `tbl_pakai`
 FOR EACH ROW BEGIN
 UPDATE tbl_persediaan SET stok=stok+(OLD.jml_pakai-NEW.jml_pakai)  
 WHERE kd_persediaan=NEW.kd_persediaan; 
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pemasok`
--

CREATE TABLE IF NOT EXISTS `tbl_pemasok` (
  `kd_pemasok` varchar(8) NOT NULL,
  `nama_pemasok` varchar(25) NOT NULL,
  `alamat_pemasok` varchar(35) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  PRIMARY KEY (`kd_pemasok`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_pemasok`
--

INSERT INTO `tbl_pemasok` (`kd_pemasok`, `nama_pemasok`, `alamat_pemasok`, `no_telepon`) VALUES
('S001', 'UD. Murah', 'Batang', '082138228410'),
('S002', 'Nawa Raya', 'Pekalongan', '085728332525');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_peramalan`
--

CREATE TABLE IF NOT EXISTS `tbl_peramalan` (
  `kd_peramalan` varchar(8) NOT NULL,
  `kd_persediaan` varchar(8) NOT NULL,
  `tgl_peramalan` date NOT NULL,
  `alpha` float NOT NULL,
  `mse` float NOT NULL,
  `hasil` int(8) NOT NULL,
  PRIMARY KEY (`kd_peramalan`),
  KEY `kd_persediaan` (`kd_persediaan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_peramalan`
--

INSERT INTO `tbl_peramalan` (`kd_peramalan`, `kd_persediaan`, `tgl_peramalan`, `alpha`, `mse`, `hasil`) VALUES
('F001', 'K001', '2017-04-10', 0.1, 267.833, 50),
('F002', 'K001', '2017-04-11', 0.8, 249.833, 49),
('F003', 'K001', '2017-05-17', 0.1, 267.833, 50),
('F004', 'K001', '2017-05-18', 0.5, 242.583, 56),
('F005', 'K001', '2017-05-22', 0.9, 253, 46),
('F006', 'K002', '2017-06-04', 0.3, 107.4, 41);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_persediaan`
--

CREATE TABLE IF NOT EXISTS `tbl_persediaan` (
  `kd_persediaan` varchar(8) NOT NULL,
  `kd_jenis` varchar(8) NOT NULL,
  `ukuran` varchar(25) NOT NULL,
  `stok` int(8) NOT NULL,
  PRIMARY KEY (`kd_persediaan`),
  KEY `kd_jenis` (`kd_jenis`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_persediaan`
--

INSERT INTO `tbl_persediaan` (`kd_persediaan`, `kd_jenis`, `ukuran`, `stok`) VALUES
('K001', 'J001', '400x2x20cm', 43),
('K002', 'J002', '400x4x12cm', 30),
('K003', 'J003', '400x8x12cm', 40);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_beli`
--
ALTER TABLE `tbl_beli`
  ADD CONSTRAINT `tbl_beli_ibfk_2` FOREIGN KEY (`kd_pemasok`) REFERENCES `tbl_pemasok` (`kd_pemasok`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_beli_ibfk_1` FOREIGN KEY (`kd_persediaan`) REFERENCES `tbl_persediaan` (`kd_persediaan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_pakai`
--
ALTER TABLE `tbl_pakai`
  ADD CONSTRAINT `tbl_pakai_ibfk_1` FOREIGN KEY (`kd_persediaan`) REFERENCES `tbl_persediaan` (`kd_persediaan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_peramalan`
--
ALTER TABLE `tbl_peramalan`
  ADD CONSTRAINT `tbl_peramalan_ibfk_1` FOREIGN KEY (`kd_persediaan`) REFERENCES `tbl_persediaan` (`kd_persediaan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_persediaan`
--
ALTER TABLE `tbl_persediaan`
  ADD CONSTRAINT `tbl_persediaan_ibfk_1` FOREIGN KEY (`kd_jenis`) REFERENCES `tbl_jenis` (`kd_jenis`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
