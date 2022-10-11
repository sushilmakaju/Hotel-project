-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2022 at 12:25 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lutonhotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `bar`
--

CREATE TABLE `bar` (
  `bar_id` int(11) NOT NULL,
  `bar_item` varchar(150) DEFAULT NULL,
  `bar_price` int(10) DEFAULT NULL,
  `B_Id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bar`
--

INSERT INTO `bar` (`bar_id`, `bar_item`, `bar_price`, `B_Id`) VALUES
(1, 'ColdDrinks', 120, 1),
(2, 'SoftDrinks', 90, 2),
(3, 'SoftDrinks', 90, 4),
(4, 'SoftDrinks', 90, 5),
(5, 'SoftDrinks', 90, 5),
(6, 'SoftDrinks', 90, 6),
(7, 'ColdDrinks', 90, 7),
(8, 'ColdDrinks', 90, 8),
(9, 'HardDrinks', 2000, 9),
(10, 'HardDrinks', 2500, 13),
(11, 'SoftDrinks', 200, 14),
(12, 'HardDrinks', 3000, 16),
(13, 'SoftDrinks', 200, 17),
(14, 'ColdDrinks', 200, 20),
(15, 'HardDrinks', 2500, 24),
(16, 'HardDrinks', 2500, 26),
(17, 'HardDrinks', 2500, 26),
(18, 'HardDrinks', 2500, 29),
(19, 'HardDrinks', 2000, 30);

-- --------------------------------------------------------

--
-- Table structure for table `booking2`
--

CREATE TABLE `booking2` (
  `B_Id` int(11) NOT NULL,
  `Arrivaldate` date NOT NULL,
  `Departuredate` date NOT NULL,
  `bookingtype` varchar(250) NOT NULL,
  `bookingstatus` varchar(50) NOT NULL,
  `C_ID` int(10) NOT NULL,
  `Room_no` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking2`
--

INSERT INTO `booking2` (`B_Id`, `Arrivaldate`, `Departuredate`, `bookingtype`, `bookingstatus`, `C_ID`, `Room_no`) VALUES
(1, '2022-05-25', '2022-05-26', 'Single', 'Inactive', 4, 1),
(2, '2022-05-25', '2022-05-26', 'Twin', 'Inactive', 8, 6),
(4, '2022-05-25', '2022-05-26', 'Single', 'Inactive', 8, 2),
(5, '2022-05-25', '2022-05-26', 'Single', 'Inactive', 9, 7),
(6, '2022-05-25', '2022-05-26', 'Twin', 'Inactive', 9, 5),
(7, '2022-05-25', '2022-05-26', 'Double', 'Inactive', 10, 3),
(8, '2022-05-26', '2022-05-27', 'Twin', 'Inactive', 10, 12),
(9, '2022-05-25', '2022-05-26', 'Double', 'Inactive', 11, 4),
(12, '2022-05-26', '2022-05-27', 'Single', 'Booked', 15, 10),
(13, '2022-05-26', '2022-05-27', 'Double', 'Inactive', 16, 12),
(14, '2022-05-26', '2022-05-27', 'Double', 'Inactive', 19, 13),
(15, '2022-05-26', '2022-05-27', 'Twin', 'Booked', 21, 15),
(16, '2022-05-26', '2022-05-27', 'Twin', 'Inactive', 22, 14),
(17, '2022-05-26', '2022-05-27', 'Twin', 'Inactive', 27, 23),
(19, '2022-05-28', '2022-05-30', 'Double', 'Active', 31, 25),
(20, '2022-05-28', '2022-05-30', 'Twin', 'Inactive', 32, 24),
(21, '2022-05-26', '2022-05-28', 'Twin', 'Pending', 33, NULL),
(22, '2022-05-26', '2022-05-28', 'Double', 'Pending', 34, NULL),
(23, '2022-05-26', '2022-05-28', 'Single', 'Booked', 36, 11),
(24, '2022-05-28', '2022-05-30', 'Single', 'Inactive', 37, 16),
(25, '2022-05-28', '2022-05-30', 'Single', 'Booked', 39, 17),
(26, '2022-05-27', '2022-05-29', 'Single', 'Inactive', 56, 18),
(27, '2022-05-27', '2022-05-29', 'Single', 'Pending', 57, NULL),
(28, '2022-05-27', '2022-05-29', 'Double', 'Active', 58, 20),
(29, '2022-05-27', '2022-05-29', 'Double', 'Inactive', 59, 19),
(30, '2022-05-27', '2022-05-28', 'Double', 'Inactive', 61, 29);

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `Billing_ID` int(10) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Drink_Amount` int(50) DEFAULT NULL,
  `Service_Amount` int(10) DEFAULT NULL,
  `Food_Amount` int(10) DEFAULT NULL,
  `Room_Amount` int(10) DEFAULT NULL,
  `Total_Bill` double(10,1) DEFAULT NULL,
  `Total_Paid` double(10,1) DEFAULT NULL,
  `Return_Amount` double(10,1) DEFAULT NULL,
  `Discount` double(10,1) DEFAULT NULL,
  `Billling_Status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `checkout`
--

INSERT INTO `checkout` (`Billing_ID`, `Name`, `Drink_Amount`, `Service_Amount`, `Food_Amount`, `Room_Amount`, `Total_Bill`, `Total_Paid`, `Return_Amount`, `Discount`, `Billling_Status`) VALUES
(1, 'Nitesh', 120, 3000, 450, 1500, 5071.3, 5100.0, 28.7, 757.8, 'Paid'),
(2, 'Hancie', 90, 2000, 450, 3500, 6024.9, 6100.0, 75.1, 900.3, 'Paid'),
(3, 'Hancie', 90, 1500, 200, 1500, 3321.4, 3500.0, 178.6, 496.3, 'Paid'),
(4, 'Hancie', 90, 1500, 200, 1500, 3321.4, 3500.0, 178.6, 496.3, 'Paid'),
(5, 'Hancie', 90, 1500, 200, 1500, 3321.4, 4000.0, 678.6, 496.3, 'Paid'),
(6, 'Darsheel', 90, 500, 450, 1500, 2584.1, 2600.0, 15.9, 386.1, 'Paid'),
(7, 'Darsheel', 90, 2000, 200, 3500, 5779.1, 6000.0, 220.9, 863.6, 'Paid'),
(8, 'Omi', 90, 500, 200, 2500, 3321.4, 3500.0, 178.6, 496.3, 'Paid'),
(9, 'Omi', 90, 3000, 200, 8, 3329.3, 3500.0, 170.7, 497.5, 'Paid'),
(10, 'Shyam', 2000, 3000, 450, 2500, 7902.6, 8000.0, 97.4, 1180.9, 'Paid'),
(11, 'Dibash', 2500, 500, 200, 2500, 5690.7, 6000.0, 309.3, 850.3, 'Paid'),
(12, 'Sushil', 200, 500, 450, 2500, 3675.3, 4000.0, 324.7, 549.2, 'Paid'),
(13, 'Sudyan', 3000, 500, 500, 3500, 7460.2, 7500.0, 39.8, 1114.8, 'Paid'),
(14, 'Sushan', 200, 1500, 500, 3500, 5690.7, 6000.0, 309.3, 850.3, 'Paid'),
(15, 'Sudatta', 200, 500, 500, 7000, 8148.4, 8500.0, 351.6, 1217.6, 'Paid'),
(16, 'Sushan', 2500, 500, 200, 3000, 6182.2, 8500.0, 2317.8, 923.8, 'Paid'),
(17, 'Sushan', 2500, 500, 500, 5000, 8443.4, 10000.0, 1556.7, 1261.6, 'Paid'),
(18, 'Sushil', 2000, 500, 500, 3500, 6477.1, 7000.0, 522.9, 967.9, 'Paid');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `C_ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Mobile` varchar(22) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Role` varchar(50) NOT NULL,
  `Account` varchar(50) DEFAULT NULL,
  `CVC` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`C_ID`, `Name`, `Email`, `Mobile`, `Address`, `Username`, `Password`, `Role`, `Account`, `CVC`) VALUES
(4, 'Nitesh', 'nitesh.hamal@gmail.com', '9813371345', 'ktm', 'Nitesh720', 'hienih720', 'CorporateCustomer', '4456-8989-7676-4234', '667'),
(6, 'Sushil', 'sushil@gmail.com', '9800886644', 'Lokanthali', 'Admin', '12345', 'Receptionist', '', ''),
(8, 'Hancie', 'hancie@gmail.com', '9813871345', 'KTM', 'Hancie123', '1234', 'Customer', '', ''),
(9, 'Darsheel', 'darsheel.chudal@gmail.com', '9813933371', 'Lokanthali', 'Darsheel10', '5555', 'Customer', '', ''),
(10, 'Omi', 'omi.sijapati@gmail.com', '9845352703', 'Sanothimi', 'Omi18', '1111', 'Customer', '', ''),
(11, 'Shyam', 'shyam.makaju@gmail.com', '9851059153', 'Lokanthali', 'Shyam2', '0000', 'Customer', '', ''),
(14, 'Sijan', 'sijan.kdk1@gmail.com', '9855446622', 'Patan', 'Sijan20', '2222', 'Corp Customer', '5555-3335-6668-9998', '654'),
(15, 'Ajay', 'ajay.timsina@gmail.com', '9800776654', 'Sankhamul', 'Ajay12', '1212', 'Customer', '', ''),
(16, 'Dibash', 'dibash.suyal2@gmail.com', '9876543210', 'Kupondole', 'Dibash11', '1111', 'Customer', '', ''),
(17, 'Sijan', 'sijan23@gmail.com', '985647382', 'Bharatpur', 'Sijank7', 'sijank7', 'Staff', '', ''),
(18, 'Sishir', 'sishir231@gmail.com', '9875638218', 'Bhaktapur', 'Sishir362', 'Sishir2819', 'Customer', '', ''),
(19, 'Sushil', 'sushil.makaju559@gmail.com', '9840429641', 'Lokanthali', 'Sushil15', '1111', 'Customer', '', ''),
(20, 'Sijan', 'sijan.khadka26@gmail.com', '9860509594', 'Bharatpur', 'Sijan2', '1111', 'Customer', '', ''),
(21, 'Sijan', 'sijan.khadka2@gmail.com', '9877665544', 'Bharatpur', 'Sijan1', '1111', 'Customer', '', ''),
(22, 'Sudyan', 'sudyan.stha1@gmail.com', '9807654321', 'Lokanthali', 'Sudyan12', '2222', 'Customer', '', ''),
(31, 'Sudatta', 'sudatta@gmail.com', '9849440600', 'patan', 'Sudatta1', '1234', 'Customer', '', ''),
(32, 'Sudatta', 'sudatta1@gmail.com', '9849400600', 'patan', 'Sudatta0', '1234', 'Customer', '', ''),
(56, 'Sushan', 'sushan36@gmail.com', '9856477587', 'sanepa', 'Sushan552', '5522', 'Customer', '', ''),
(57, 'Sushan', 'sushan39@gmail.com', '9879688797', 'sanepa', 'Sushan501', '5011', 'Customer', '', ''),
(58, 'Sushan', 'sushan66@gmail.com', '9849733898', 'sanepa', 'Sushan222', '2222', 'Customer', '', ''),
(59, 'Sushan', 'sushan46@gmail.com', '9875055697', 'sanepa', 'Sushan255', '2555', 'Customer', '', ''),
(61, 'Sushil', 'sushil.makaju8@gmail.com', '9804246931', 'Lokanthali', 'Sushil1', '3333', 'Customer', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `Food_id` int(11) NOT NULL,
  `food_item` varchar(150) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `B_Id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`Food_id`, `food_item`, `price`, `B_Id`) VALUES
(1, 'Dinner', 450, 1),
(2, 'Dinner', 450, 2),
(3, 'Breakfast', 200, 4),
(4, 'Dinner', 450, 5),
(5, 'Breakfast', 200, 6),
(7, 'Breakfast', 200, 7),
(8, 'Breakfast', 200, 8),
(9, 'Dinner', 450, 9),
(10, 'Breakfast', 200, 13),
(11, 'Dinner', 450, 14),
(12, 'Dinner', 500, 16),
(13, 'Dinner', 500, 17),
(14, 'Breakfast', 500, 17),
(15, 'Dinner', 500, 20),
(17, 'Breakfast', 500, 24),
(18, 'Breakfast', 200, 26),
(19, 'Dinner', 500, 26),
(20, 'Breakfast', 500, 29),
(21, 'Dinner', 500, 30);

-- --------------------------------------------------------

--
-- Table structure for table `roomtest`
--

CREATE TABLE `roomtest` (
  `Room_no` int(11) NOT NULL,
  `Room_type` varchar(50) NOT NULL,
  `Room_price` decimal(11,0) NOT NULL,
  `Room_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roomtest`
--

INSERT INTO `roomtest` (`Room_no`, `Room_type`, `Room_price`, `Room_status`) VALUES
(1, 'Single', '1500', 'Booked'),
(2, 'Single', '1500', 'Booked'),
(3, 'Double', '2500', 'Booked'),
(4, 'Double', '2500', 'Booked'),
(5, 'Twin', '3500', 'Booked'),
(6, 'Twin', '3500', 'Booked'),
(7, 'Single', '1500', 'Booked'),
(8, 'Single', '1500', 'Booked'),
(9, 'Single', '1500', 'Booked'),
(10, 'Single', '1500', 'Booked'),
(11, 'Single', '1500', 'Booked'),
(12, 'Double', '2500', 'Booked'),
(13, 'Double', '2500', 'Booked'),
(14, 'Twin', '3500', 'Booked'),
(15, 'Twin', '3500', 'Booked'),
(16, 'Single', '1500', 'Booked'),
(17, 'Single', '1500', 'Booked'),
(18, 'Single', '1500', 'Booked'),
(19, 'Double', '2500', 'Booked'),
(20, 'Double', '2500', 'Booked'),
(21, 'Double', '2500', 'Available'),
(22, 'Double', '2500', 'Available'),
(23, 'Twin', '3500', 'Booked'),
(24, 'Twin', '3500', 'Booked'),
(25, 'Twin', '3500', 'Booked'),
(26, 'Twin', '3500', 'Booked'),
(27, 'Twin', '3500', 'Available'),
(28, 'Twin', '3500', 'Available'),
(29, 'Double', '3500', 'Booked'),
(30, 'Double', '2500', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `S_id` int(11) NOT NULL,
  `s_Type` varchar(200) NOT NULL,
  `s_Charge` int(10) NOT NULL,
  `B_Id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`S_id`, `s_Type`, `s_Charge`, `B_Id`) VALUES
(1, ' Massage', 3000, 1),
(2, 'sauna', 2000, 2),
(3, 'Laundray', 1500, 4),
(4, 'Gym', 500, 5),
(5, 'sauna', 2000, 6),
(6, 'Swimming', 500, 7),
(7, ' Massage', 3000, 8),
(8, ' Massage', 3000, 9),
(9, 'Gym', 500, 13),
(10, 'Gym', 500, 14),
(11, 'Laundray', 500, 16),
(12, 'Laundray', 1500, 17),
(13, ' Games', 500, 20),
(14, 'Swimming', 500, 24),
(15, 'Swimming', 500, 26),
(16, 'Swimming', 500, 26),
(17, 'Swimming', 500, 29),
(18, 'Gym', 500, 30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`bar_id`),
  ADD KEY `B_Id` (`B_Id`);

--
-- Indexes for table `booking2`
--
ALTER TABLE `booking2`
  ADD PRIMARY KEY (`B_Id`),
  ADD KEY `C_ID` (`C_ID`),
  ADD KEY `Room_no` (`Room_no`);

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`Billing_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`C_ID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Mobile` (`Mobile`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Username_2` (`Username`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`Food_id`),
  ADD KEY `B_Id` (`B_Id`);

--
-- Indexes for table `roomtest`
--
ALTER TABLE `roomtest`
  ADD PRIMARY KEY (`Room_no`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`S_id`),
  ADD KEY `B_Id` (`B_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bar`
--
ALTER TABLE `bar`
  MODIFY `bar_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `booking2`
--
ALTER TABLE `booking2`
  MODIFY `B_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `checkout`
--
ALTER TABLE `checkout`
  MODIFY `Billing_ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `C_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `Food_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `S_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bar`
--
ALTER TABLE `bar`
  ADD CONSTRAINT `bar_ibfk_1` FOREIGN KEY (`B_Id`) REFERENCES `booking2` (`B_Id`);

--
-- Constraints for table `booking2`
--
ALTER TABLE `booking2`
  ADD CONSTRAINT `booking2_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `customer` (`C_ID`),
  ADD CONSTRAINT `booking2_ibfk_2` FOREIGN KEY (`Room_no`) REFERENCES `roomtest` (`Room_no`);

--
-- Constraints for table `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `food_ibfk_1` FOREIGN KEY (`B_Id`) REFERENCES `booking2` (`B_Id`);

--
-- Constraints for table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `service_ibfk_1` FOREIGN KEY (`B_Id`) REFERENCES `booking2` (`B_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
