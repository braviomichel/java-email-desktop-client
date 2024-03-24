-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2022 at 05:23 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emailmanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `archive`
--

CREATE TABLE `archive` (
  `number` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `subject` varchar(30) DEFAULT NULL,
  `sender` varchar(50) NOT NULL,
  `content` text DEFAULT NULL,
  `dateReception` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `archive`
--

INSERT INTO `archive` (`number`, `userId`, `subject`, `sender`, `content`, `dateReception`) VALUES
(10, 1, 'Ahmed vient de vous envoyer un', 'Ahmed BARYAZ via LinkedIn <messaging-digest-norepl', NULL, '2022-06-09'),
(11, 1, 'Ahmed vient de vous envoyer un', 'Ahmed BARYAZ via LinkedIn <messaging-digest-norepl', NULL, '2022-06-09'),
(12, 1, 'Ahmed vient de vous envoyer un', 'Ahmed BARYAZ via LinkedIn <messaging-digest-norepl', NULL, '2022-06-09'),
(13, 1, 'Ahmed vient de vous envoyer un', 'Ahmed BARYAZ via LinkedIn <messaging-digest-norepl', NULL, '2022-06-09'),
(14, 1, 'Ahmed vient de vous envoyer un', 'Ahmed BARYAZ via LinkedIn <messaging-digest-norepl', NULL, '2022-06-09'),
(15, 1, 'Ahmed vient de vous envoyer un', 'Ahmed BARYAZ via LinkedIn <messaging-digest-norepl', NULL, '2022-06-09');

-- --------------------------------------------------------

--
-- Table structure for table `email`
--

CREATE TABLE `email` (
  `number` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `subject` varchar(30) DEFAULT NULL,
  `reciever` varchar(50) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `path` text NOT NULL,
  `dateEvoie` date DEFAULT curdate()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `email`
--

INSERT INTO `email` (`number`, `userId`, `subject`, `reciever`, `content`, `path`, `dateEvoie`) VALUES
(1, 1, 'objet1', 'r.rachidsaad@gmail.com', 'just a text to test the functionality', '', '2022-06-05'),
(3, 1, 'test3', 'r.rachidsaad@gmail.com', 'rachid saad la legende', '', '2022-06-07'),
(4, 1, 'test4', 'r.rachidsaad@gmail.com', 'kfdyugpuhuiqgfoqgygougouwftftydffdufd', 'C:\\\\Users\\\\rrach\\\\eclipse-workspace\\\\EmailManager\\\\ressources\\\\images/logout.png', '2022-06-07'),
(5, 1, 'test45', 'r.rachidsaad@gmail.com', 'ygoiigudglyugilugo;iwhqougdufgwdgydihohoyufhvyufdyu', 'C:\\\\Users\\\\rrach\\\\eclipse-workspace\\\\EmailManager\\\\ressources\\\\images/logout.png', '2022-06-07'),
(6, 1, 'test 5', 'r.rachidsaad@gmail.com', 'saad rachid 1 india', 'C:\\\\Users\\\\rrach\\\\eclipse-workspace\\\\EmailManager\\\\ressources\\\\images/logout.png', '2022-06-07'),
(7, 1, 'test', 'r.rachidsaad@gmail.com', 'type your message here ', 'C:\\\\Users\\\\rrach\\\\eclipse-workspace\\\\EmailManager\\\\ressources\\\\images/logout.png', '2022-06-09');

-- --------------------------------------------------------

--
-- Table structure for table `listuser`
--

CREATE TABLE `listuser` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `User_id` int(11) NOT NULL,
  `members` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `firstName` varchar(25) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `departement` varchar(30) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL COMMENT 'Password'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Id`, `firstName`, `lastName`, `departement`, `adresse`, `password`) VALUES
(1, 'saad', 'rachid', '', 'r.rachidsaad@gmail.com', '123'),
(2, 'michel', 'sagbo', 'aa', 'm.sagbo@edu.umi.ac.ma', '321');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `archive`
--
ALTER TABLE `archive`
  ADD PRIMARY KEY (`number`),
  ADD KEY `k` (`userId`);

--
-- Indexes for table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`number`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `listuser`
--
ALTER TABLE `listuser`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `User_id` (`User_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `email` (`adresse`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `archive`
--
ALTER TABLE `archive`
  MODIFY `number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `archive`
--
ALTER TABLE `archive`
  ADD CONSTRAINT `k` FOREIGN KEY (`userId`) REFERENCES `user` (`Id`);

--
-- Constraints for table `email`
--
ALTER TABLE `email`
  ADD CONSTRAINT `email_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`Id`);

--
-- Constraints for table `listuser`
--
ALTER TABLE `listuser`
  ADD CONSTRAINT `FOREIGN KEY` FOREIGN KEY (`User_id`) REFERENCES `user` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
