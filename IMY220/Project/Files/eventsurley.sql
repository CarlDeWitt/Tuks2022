-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 01, 2022 at 08:09 AM
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
(1, '[5,8,9,1,3]', 7),
(2, '[3]', 2),
(3, '[1,3]', 3),
(4, '[1,3]', 8),
(5, '[-1]', 15);

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `id` int(11) NOT NULL,
  `from_uid` int(11) NOT NULL,
  `to_uid` int(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`id`, `from_uid`, `to_uid`, `message`, `time`) VALUES
(1, 2, 3, 'Hello there', '1666637868531'),
(2, 3, 2, 'Wassup', '1666637868532'),
(4, 2, 3, 'Naah all good bruh', '1666637868535'),
(5, 2, 3, 'cool', '1666639895088'),
(6, 2, 3, 'u still down for games', '1666639966912'),
(7, 0, 0, '', ''),
(8, 2, 1, 'Hello', '1667139873353');

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
(2, 2, 'Lente Dag 2', 'gonna be a huge night at tuks', 'eventplacholder.jpg', '2022-09-09', 'Tuks', '#sick', 0),
(3, 2, 'carl', 'gonna be a huge night at tukss', 'eventplacholder.jpg', '2022-08-31', 'Tuks', '#cool', 0),
(7, 1, 'Happy Clappy Musics', 'gonna be a huge night at tuks', 'ph8.jpg', '2022-09-29', '6 omdraai street', '#livelaughlove', 0),
(8, 3, 'Ida day', 'lekker tye', 'ph4.jpg', '2022-10-27', 'Tuks', '#cool', 0),
(15, 3, 'wack', 'wack nation', 'pic.jpg', '2022-10-27', 'nerens', '#cool', 0),
(16, 1, 'Spoegwolf', 'Gaan groot wees daarso', 'ph7.jpg', '2022-10-26', '33 lynood Road', '#kuier', 0),
(17, 1, 'One Republic', 'Big day bring all your money', 'ph2.jpeg', '2022-10-09', 'Pretria', '#foreigner', 0),
(18, 1, 'The Lumineers', 'Bruh it is the Lumineers what are you waiting for', 'ph11.webp', '2022-11-18', 'Cape Town', '#awesome', 0),
(19, 1, 'Imagine Dragons', 'Big Event at the calabash', 'ph6.webp', '2022-12-16', 'Soweto', '#SowetoPepsi', 0),
(20, 2, 'Sting', 'No way, he is finally here in Pretoria', 'ph10.jpg', '2023-02-09', 'Sun Bet', '#PretoriaRocks', 0),
(21, 2, 'Pitbul', 'Timber baby', 'ph8.jpg', '2022-10-28', 'Cape Town', '#Timber', 0),
(22, 2, 'One Direction', 'Come listen to the best song ever', 'ph3.jpg', '2022-10-20', 'LC de viliers ', '#JustSick', 0);

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
(3, 'Ida', 'De witt', 'ida@gmail.com', '2022-10-26', '1'),
(4, 'Admin', 'Admin', 'admin@gmail.com', '2022-06-16', 'admin');

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
(5, 'Vaction', 1),
(7, 'my List', 3);

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
(7, 5, 2, 1),
(9, 7, 2, 3);

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
(3, 'pfp2.jpg', 1, 3, 3, '[1]', 'sjooooooooooo', 'Ida'),
(4, 'pfp.jpg', 0, 0, 4, '[]', '', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `review_img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `user_id`, `event_id`, `rating`, `description`, `review_img`) VALUES
(5, 3, 15, 4, 'nice job', 'pic.jpg'),
(6, 3, 15, 5, 'aweh was lekka', 'pfp.png'),
(9, 3, 15, 1, 'sjooooooooooo', 'pfp2.jpg'),
(11, 2, 3, 5, 'nice job', 'IMG-20220927-WA0000.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attending`
--
ALTER TABLE `attending`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
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
-- Indexes for table `review`
--
ALTER TABLE `review`
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
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `e_event`
--
ALTER TABLE `e_event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `e_users`
--
ALTER TABLE `e_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `list`
--
ALTER TABLE `list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `list_events`
--
ALTER TABLE `list_events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `profilepage`
--
ALTER TABLE `profilepage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
