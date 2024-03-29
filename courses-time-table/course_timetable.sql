-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 09, 2011 at 01:54 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

--SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

create database course_timetable;
use course_timetable;

--
-- Database: `course_timetable`
--

-- --------------------------------------------------------

--
-- Table structure for table `classroom`
--

CREATE TABLE IF NOT EXISTS `classroom` (
  `ID` int(6) NOT NULL COMMENT 'Class Room ID',
  `Deprtment_name` varchar(50) NOT NULL COMMENT 'Class Room Department',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Class Room Table';

--
-- Dumping data for table `classroom`
--

INSERT INTO `classroom` (`ID`, `Deprtment_name`) VALUES
(207701, 'computer'),
(307701, 'architecture\r');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `ID` int(5) NOT NULL,
  `name` varchar(50) NOT NULL COMMENT 'Course Name',
  `Lab_HRs` int(2) DEFAULT '2' COMMENT 'Course laboratory Hours',
  `lec_HRs` int(2) NOT NULL DEFAULT '2' COMMENT 'Course lecture Hours',
  `sec_HRs` int(2) NOT NULL DEFAULT '2' COMMENT 'Course section HRs',
  `C_prof` int(4) DEFAULT NULL COMMENT 'professor ID that teach that course',
  `C_TA` int(4) DEFAULT NULL COMMENT 'TA ID that teach that course',
  `Year` year(4) NOT NULL COMMENT 'course start year',
  PRIMARY KEY (`ID`),
  KEY `prof` (`C_prof`),
  KEY `TA` (`C_TA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Courses Table';

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`ID`, `name`, `Lab_HRs`, `lec_HRs`, `sec_HRs`, `C_prof`, `C_TA`, `Year`) VALUES
(11111, 'software', 10, 14, 12, 1111, 2001, 1995),
(12345, 'algorithm', 10, 14, 12, 2210, NULL, 1995);

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE IF NOT EXISTS `exam` (
  `ID_Course` int(5) NOT NULL COMMENT 'THE EXAM course id',
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Class_ID` int(5) DEFAULT NULL,
  PRIMARY KEY (`ID_Course`),
  KEY `Class_ID` (`Class_ID`),
  KEY `CourseID` (`ID_Course`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table contains the Data of the Exams of all courses.';

--
-- Dumping data for table `exam`
--


-- --------------------------------------------------------

--
-- Table structure for table `graduated_students`
--

CREATE TABLE IF NOT EXISTS `graduated_students` (
  `ID` int(4) NOT NULL COMMENT 'student ID',
  `Year` year(4) NOT NULL COMMENT 'Graduation year\n Name',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `Graduated_student_ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table contains the Graduated students';

--
-- Dumping data for table `graduated_students`
--

INSERT INTO `graduated_students` (`ID`, `Year`) VALUES
(3001, 1998),
(3002, 2003);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `ID` int(4) NOT NULL COMMENT 'person ID ',
  `first_name` varchar(50) NOT NULL COMMENT ' first name',
  `last_name` varchar(50) NOT NULL COMMENT ' last name',
  `password` int(6) NOT NULL DEFAULT '123456' COMMENT 'Account password',
  `Gender` char(1) NOT NULL DEFAULT 'm' COMMENT 'person Gender',
  `Mail` varchar(50) DEFAULT NULL COMMENT 'Person mail',
  `Mobile` int(11) DEFAULT NULL COMMENT 'Person mobile',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Person data';

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`ID`, `first_name`, `last_name`, `password`, `Gender`, `Mail`, `Mobile`) VALUES
(1001, 'Mahmoud', 'Shokr', 123456, 'm', NULL, 1115348800),
(1111, 'mohsen', 'ahmed', 111111, 'm', NULL, 1022541963),
(1234, 'rabie', 'ramdan', 123456, 'm', NULL, 0),
(2001, 'Tarek', 'Osama', 123456, 'm', NULL, 1114269031),
(2210, 'mahmoud', 'hmed', 111111, 'm', NULL, 0),
(3001, 'Mahmoud', 'Nabil', 123456, 'm', NULL, 1271118424),
(3002, 'Mohamad', 'Nour', 123456, 'm', NULL, 1220302926),
(3003, 'ahmed', 'fathy', 123456, 'm', NULL, NULL),
(3004, 'hossam', 'zaki', 123456, 'm', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `precourses`
--

CREATE TABLE IF NOT EXISTS `precourses` (
  `crs_ID` int(5) NOT NULL COMMENT 'Course ID',
  `pre_ID` int(5) NOT NULL COMMENT 'Pre-request course Name',
  PRIMARY KEY (`crs_ID`,`pre_ID`),
  KEY `pre_ID` (`pre_ID`),
  KEY `course_ID` (`crs_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='this table contains the pre-request courses for such a cours';

--
-- Dumping data for table `precourses`
--

INSERT INTO `precourses` (`crs_ID`, `pre_ID`) VALUES
(12345, 11111);

-- --------------------------------------------------------

--
-- Table structure for table `prof_day`
--

CREATE TABLE IF NOT EXISTS `prof_day` (
  `prof_ID` int(4) NOT NULL COMMENT 'professor ID ',
  `day_ID` int(1) NOT NULL COMMENT 'Day ID',
  PRIMARY KEY (`prof_ID`,`day_ID`) USING BTREE,
  KEY `day_id` (`day_ID`),
  KEY `ID` (`prof_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='this table has the relation between the professor and his av';

--
-- Dumping data for table `prof_day`
--

INSERT INTO `prof_day` (`prof_ID`, `day_ID`) VALUES
(1234, 1),
(1234, 3),
(1111, 6);

-- --------------------------------------------------------

--
-- Table structure for table `system_status`
--

CREATE TABLE IF NOT EXISTS `system_status` (
  `Current_Year` year(4) NOT NULL COMMENT 'the system current year',
  `Current_Semster` int(1) NOT NULL COMMENT 'the system current semster',
  `Prof_Access` char(1) NOT NULL COMMENT 'T or F\nT means the professer still can change his days\nF cant',
  `TA_Access` char(1) NOT NULL COMMENT 'the same as Prof_Access\n',
  `Student_Access` char(1) NOT NULL COMMENT 'T-> the courses registeration is still open\nF-> not',
  PRIMARY KEY (`Current_Year`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='contains the current state of the system';

--
-- Dumping data for table `system_status`
--


-- --------------------------------------------------------

--
-- Table structure for table `take_course`
--

CREATE TABLE IF NOT EXISTS `take_course` (
  `std_ID` int(4) NOT NULL COMMENT 'Student ID',
  `crs_ID` int(5) NOT NULL COMMENT 'Course ID',
  PRIMARY KEY (`std_ID`,`crs_ID`),
  KEY `crouse` (`crs_ID`),
  KEY `course` (`crs_ID`),
  KEY `student` (`std_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='this table has the relation between the student and courses';

--
-- Dumping data for table `take_course`
--

INSERT INTO `take_course` (`std_ID`, `crs_ID`) VALUES
(3002, 11111),
(3001, 12345);

-- --------------------------------------------------------

--
-- Table structure for table `ta_day`
--

CREATE TABLE IF NOT EXISTS `ta_day` (
  `ta_ID` int(4) NOT NULL COMMENT 'TA ID',
  `day_ID` int(1) NOT NULL COMMENT 'Day ID',
  PRIMARY KEY (`ta_ID`,`day_ID`) USING BTREE,
  KEY `ID_day` (`day_ID`),
  KEY `TA_ID` (`ta_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='this table has the relation between the TA and his available';

--
-- Dumping data for table `ta_day`
--

INSERT INTO `ta_day` (`ta_ID`, `day_ID`) VALUES
(2210, 4),
(2001, 5);

-- --------------------------------------------------------

--
-- Table structure for table `timetable`
--

CREATE TABLE IF NOT EXISTS `timetable` (
  `Slot_ID` int(3) NOT NULL COMMENT 'Slot ID refers to slot number',
  `day_slot_ID` int(1) NOT NULL COMMENT 'day slot',
  `class_ID1` int(6) NOT NULL COMMENT 'room ID',
  `Course_ID1` int(5) NOT NULL COMMENT 'course ID',
  PRIMARY KEY (`Slot_ID`,`day_slot_ID`,`class_ID1`),
  KEY `1` (`day_slot_ID`),
  KEY `2` (`class_ID1`),
  KEY `3` (`Course_ID1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='the timetable';

--
-- Dumping data for table `timetable`
--

INSERT INTO `timetable` (`Slot_ID`, `day_slot_ID`, `class_ID1`, `Course_ID1`) VALUES
(3, 1, 307701, 11111),
(4, 1, 207701, 11111),
(5, 1, 207701, 11111),
(6, 1, 207701, 11111),
(1, 1, 307701, 12345),
(2, 1, 307701, 12345);

-- --------------------------------------------------------

--
-- Table structure for table `undergraduate_students`
--

CREATE TABLE IF NOT EXISTS `undergraduate_students` (
  `ID` int(4) NOT NULL COMMENT 'student ID',
  `Year` year(4) NOT NULL COMMENT 'start year',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `studentID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table contains the undergraduate students';

--
-- Dumping data for table `undergraduate_students`
--

INSERT INTO `undergraduate_students` (`ID`, `Year`) VALUES
(3003, 2010),
(3004, 2011);

-- --------------------------------------------------------

--
-- Table structure for table `week_day`
--

CREATE TABLE IF NOT EXISTS `week_day` (
  `ID` int(1) NOT NULL COMMENT 'Day ID',
  `name` varchar(20) NOT NULL COMMENT 'DayName',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table contains the days in the week (read only).';

--
-- Dumping data for table `week_day`
--

INSERT INTO `week_day` (`ID`, `name`) VALUES
(3, 'Monday\r'),
(1, 'Saturday\r'),
(2, 'Sunday\r'),
(6, 'thursday'),
(4, 'Tuesday\r'),
(5, 'Wednesday\r');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `TA` FOREIGN KEY (`C_TA`) REFERENCES `person` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `prof` FOREIGN KEY (`C_prof`) REFERENCES `person` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `CourseID` FOREIGN KEY (`ID_Course`) REFERENCES `courses` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Class_ID` FOREIGN KEY (`Class_ID`) REFERENCES `classroom` (`ID`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `graduated_students`
--
ALTER TABLE `graduated_students`
  ADD CONSTRAINT `Graduated_student_ID` FOREIGN KEY (`ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `precourses`
--
ALTER TABLE `precourses`
  ADD CONSTRAINT `course_ID` FOREIGN KEY (`crs_ID`) REFERENCES `courses` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pre_ID` FOREIGN KEY (`pre_ID`) REFERENCES `courses` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prof_day`
--
ALTER TABLE `prof_day`
  ADD CONSTRAINT `day_id` FOREIGN KEY (`day_ID`) REFERENCES `week_day` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ID` FOREIGN KEY (`prof_ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `take_course`
--
ALTER TABLE `take_course`
  ADD CONSTRAINT `course` FOREIGN KEY (`crs_ID`) REFERENCES `courses` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student` FOREIGN KEY (`std_ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ta_day`
--
ALTER TABLE `ta_day`
  ADD CONSTRAINT `ID_day` FOREIGN KEY (`day_ID`) REFERENCES `week_day` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `TA_ID` FOREIGN KEY (`ta_ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `timetable`
--
ALTER TABLE `timetable`
  ADD CONSTRAINT `3` FOREIGN KEY (`Course_ID1`) REFERENCES `courses` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `1` FOREIGN KEY (`day_slot_ID`) REFERENCES `week_day` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `2` FOREIGN KEY (`class_ID1`) REFERENCES `classroom` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `undergraduate_students`
--
ALTER TABLE `undergraduate_students`
  ADD CONSTRAINT `studentID` FOREIGN KEY (`ID`) REFERENCES `person` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
