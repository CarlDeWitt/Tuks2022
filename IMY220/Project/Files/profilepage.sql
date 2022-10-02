-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2022 at 05:50 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventsurley`
--

-- --------------------------------------------------------

--
-- Table structure for table `profilepage`
--

CREATE TABLE `profilepage` (
  `id` int(11) NOT NULL,
  `pfpImg` varchar(100) NOT NULL,
  `followers` int(11) NOT NULL,
  `following` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `friends` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `userName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profilepage`
--

INSERT INTO `profilepage` (`id`, `pfpImg`, `followers`, `following`, `userID`, `friends`, `description`, `userName`) VALUES
(1, 'pfp3.jpg', 2, 1, 1, '[2,3]', 'legit like php', 'Carl'),
(2, 'pfp1.png', 1, 1, 2, '[1]', 'I own lewis ', 'Max'),
(3, 'pfp.jpg', 1, 2, 3, '[1]', '', 'Ida');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `profilepage`
--
ALTER TABLE `profilepage`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `profilepage`
--
ALTER TABLE `profilepage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
