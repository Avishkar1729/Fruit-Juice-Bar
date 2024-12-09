-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2024 at 05:41 PM
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
-- Database: `fruitbar`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientinfo`
--

CREATE TABLE `clientinfo` (
  `Id` int(10) NOT NULL,
  `cUname` varchar(30) NOT NULL,
  `cName` varchar(30) NOT NULL,
  `cEmail` varchar(30) NOT NULL,
  `cMob` varchar(30) NOT NULL,
  `cAddr` varchar(30) NOT NULL,
  `cPass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `clientinfo`
--

INSERT INTO `clientinfo` (`Id`, `cUname`, `cName`, `cEmail`, `cMob`, `cAddr`, `cPass`) VALUES
(1, 'mangesh15', 'Mangesh Patil', 'mangesh@gmail.com', '2345688888', 'Pune', 'mangesh'),
(1, 'mangesh15', 'Mangesh Patil', 'mangesh@gmail.com', '2345688888', 'Pune', 'mangesh');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(10) NOT NULL,
  `pName` varchar(30) DEFAULT NULL,
  `pPrice` varchar(30) DEFAULT NULL,
  `tPrice` varchar(30) DEFAULT NULL,
  `tId` varchar(30) DEFAULT NULL,
  `cId` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `pName`, `pPrice`, `tPrice`, `tId`, `cId`) VALUES
(14, 'Mosambi Shake', 'RS. 30', '30', '874569', '969'),
(22, 'Orange Shake', 'RS. 30', '30', '8654792', '646'),
(38, 'Orange Shake', 'RS. 30', '30', '9856324', '646'),
(56, 'Watermelon Fruit Plate', 'RS. 30', '30', '7854965', '564');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `id` varchar(1000) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `email` varchar(20) NOT NULL,
  `mob` varchar(20) DEFAULT NULL,
  `addr` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`id`, `uname`, `email`, `mob`, `addr`, `pass`) VALUES
('646', 'as', 'as@gmail.copm', '1234567890', 'Baramati', '1234'),
('660', 'avi', 'avi@gmail.com', '1236547890', 'Pune', '12345'),
('949', 'avis', 'avis@gmail.com', '8521479630', 'Pune', 'Avis@1234'),
('284', 'sandesh', 'sandesh@gmail.com', '1234567891', 'pune', 'Amit@123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`email`),
  ADD KEY `Id` (`id`(768));

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
