-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 01, 2022 at 05:43 PM
-- Server version: 8.0.30-0ubuntu0.20.04.2
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u21444928`
--

-- --------------------------------------------------------

--
-- Table structure for table `e_event`
--

CREATE TABLE `e_event` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `location` varchar(255) NOT NULL,
  `hastags` varchar(255) NOT NULL,
  `likes` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `e_event`
--

INSERT INTO `e_event` (`id`, `user_id`, `name`, `description`, `img`, `date`, `location`, `hastags`, `likes`) VALUES
(1, 2, '7 Nation army', '& nation army show at loftus park don t miss it', 'ph2.jpeg', '2022-10-18', 'Loftus Park', '#goodvibes', 0),
(2, 2, 'Rocking Potch', 'Come join us for a big show in Potch and come and have a great time', 'ph3.jpg', '2022-09-27', 'potchefstroom', '#kuier', 0),
(3, 2, 'Cape Christmas ', 'Christmas music concert at cape point this year. There will be a lot of artists dont miss it', 'ph4.jpg', '2022-12-25', 'Cape point', '#sunset', 0),
(4, 2, 'Bon Jovi', 'This is your last chance to see Bon in South Africa, dont miss his legendary performance ', 'ph5.jpg', '2022-11-17', 'State theatre', '#classic', 0),
(5, 2, 'Park accoustics', 'The most diverse music concert you will ever see, this one will be big and loud come and join us', 'ph6.webp', '2022-09-20', 'Voortrekker monument', '#great', 0),
(6, 1, 'Harry Styles', 'Harry is coming to South Africa to share his story one how he became and songwriter and musician  ', 'ph7.jpg', '2022-09-29', 'Red barn', '#1D', 0),
(7, 1, 'Karaoke night', 'If you can sign in the shower then you can definetly sign here, come and join us and win amazing prizes', 'ph8.jpg', '2022-11-30', '23 on Hazelwood', '#fakeItTillYouMakeIT', 0),
(8, 1, 'Lente dag', 'Kom join ons by Sonop vir n groot kuier  en luister na die beste musiek in die land', 'ph9.webp', '2022-09-13', 'Sonop', '#kuier', 0),
(9, 1, 'sketchy bongo', 'come join sketchy bongo on their nation wide tour ', 'ph10.jpg', '2023-01-05', 'Lynwood square', '#beats', 0),
(10, 1, 'Post Malone', 'Join post at the FNB stadium for his new album release this will be an event that you do not want to miss', 'ph11.webp', '2023-04-13', 'FNB Stadium', '#betterNow', 0);

-- --------------------------------------------------------

--
-- Table structure for table `e_users`
--

CREATE TABLE `e_users` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `e_users`
--

INSERT INTO `e_users` (`id`, `name`, `surname`, `email`, `DOB`, `password`) VALUES
(1, 'Carl', 'de Witt', 'carlisworldoftanks@gmail.com', '2002-07-04', '12345678'),
(2, 'Max', 'Verstappen', 'maxisworldchamp@gmail.com', '1998-11-09', 'lewis');

-- --------------------------------------------------------

--
-- Table structure for table `list`
--

CREATE TABLE `list` (
  `id` int NOT NULL,
  `ListName` varchar(255) NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `list`
--

INSERT INTO `list` (`id`, `ListName`, `user_id`) VALUES
(1, 'vacation', 2),
(2, 'summer 2023', 1);

-- --------------------------------------------------------

--
-- Table structure for table `list_events`
--

CREATE TABLE `list_events` (
  `id` int NOT NULL,
  `list_id` int NOT NULL,
  `event_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `list_events`
--

INSERT INTO `list_events` (`id`, `list_id`, `event_id`, `user_id`) VALUES
(1, 1, 5, 2),
(2, 2, 10, 1),
(3, 2, 9, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `e_event`
--
ALTER TABLE `e_event`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `e_users`
--
ALTER TABLE `e_users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `list_events`
--
ALTER TABLE `list_events`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `e_event`
--
ALTER TABLE `e_event`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `e_users`
--
ALTER TABLE `e_users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `list`
--
ALTER TABLE `list`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `list_events`
--
ALTER TABLE `list_events`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
