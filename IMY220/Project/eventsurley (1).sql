-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2022 at 10:09 PM
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
-- Table structure for table `attending`
--

CREATE TABLE `attending` (
  `id` int(11) NOT NULL,
  `user_ids` varchar(100) NOT NULL,
  `event_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attending`
--

INSERT INTO `attending` (`id`, `user_ids`, `event_id`) VALUES
(1, '[5,8,9,3,1]', 7),
(2, '[3]', 2),
(3, '[1,3]', 3),
(4, '[1,3]', 8),
(5, '[3]', 15);

-- --------------------------------------------------------

--
-- Table structure for table `e_event`
--

CREATE TABLE `e_event` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `location` varchar(255) NOT NULL,
  `hastags` varchar(255) NOT NULL,
  `likes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `e_event`
--

INSERT INTO `e_event` (`id`, `user_id`, `name`, `description`, `img`, `date`, `location`, `hastags`, `likes`) VALUES
(2, 2, 'Winters dag', 'gonna be a huge night at tuks', 'eventplacholder.jpg', '2022-09-09', 'Tuks', '#sick', 0),
(3, 2, 'carl', 'gonna be a huge night at tukss', 'eventplacholder.jpg', '2022-08-31', 'Tuks', '#cool', 0),
(7, 1, 'Happy Clappy Musics', 'gonna be a huge night at tuks', 'ph8.jpg', '2022-09-29', '6 omdraai street', '#livelaughlove', 0),
(8, 3, 'Ida day', 'lekker tye', 'ph4.jpg', '2022-10-27', 'Tuks', '#cool', 0),
(15, 3, 'test2', 'test2', 'pic.jpg', '2022-09-28', 'test2', 'test2', 0);

-- --------------------------------------------------------

--
-- Table structure for table `e_users`
--

CREATE TABLE `e_users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `e_users`
--

INSERT INTO `e_users` (`id`, `name`, `surname`, `email`, `DOB`, `password`) VALUES
(1, 'Carl', 'De witt', 'carlisworldoftanks@gmail.com', '2022-08-21', '1'),
(2, 'Max ', 'Verstappen', 'maxisworldchamp@gmail.com', '2021-12-17', '1'),
(3, 'Ida', 'De witt', 'ida@gmail.com', '2022-10-26', '1');

-- --------------------------------------------------------

--
-- Table structure for table `list`
--

CREATE TABLE `list` (
  `id` int(11) NOT NULL,
  `ListName` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `list`
--

INSERT INTO `list` (`id`, `ListName`, `user_id`) VALUES
(3, 'my List', 2),
(5, 'Vaction', 1);

-- --------------------------------------------------------

--
-- Table structure for table `list_events`
--

CREATE TABLE `list_events` (
  `id` int(11) NOT NULL,
  `list_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `list_events`
--

INSERT INTO `list_events` (`id`, `list_id`, `event_id`, `user_id`) VALUES
(2, 1, 2, 2),
(6, 5, 3, 1),
(7, 5, 2, 1);

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
(2, 'pfp1.png', 2, 1, 2, '[1,3]', 'I own lewis ', 'Max'),
(3, 'pfp.jpg', 1, 3, 3, '[1]', '', 'Ida');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attending`
--
ALTER TABLE `attending`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `profilepage`
--
ALTER TABLE `profilepage`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attending`
--
ALTER TABLE `attending`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `e_event`
--
ALTER TABLE `e_event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `e_users`
--
ALTER TABLE `e_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `list`
--
ALTER TABLE `list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `list_events`
--
ALTER TABLE `list_events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `profilepage`
--
ALTER TABLE `profilepage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
