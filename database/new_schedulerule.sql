-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: new
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `schedulerule`
--

DROP TABLE IF EXISTS `schedulerule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `schedulerule` (
  `schedule_rule_id` int(11) NOT NULL AUTO_INCREMENT,
  `schedule_rule_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) NOT NULL,
  `schedule_rule` binary(20) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL,
  PRIMARY KEY (`schedule_rule_id`,`doctor_id`) USING BTREE,
  KEY `department_id1_idx` (`department_id`) USING BTREE,
  KEY `doctor_type1_idx` (`doctor_id`) USING BTREE,
  CONSTRAINT `department_id1` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `doctor_id1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedulerule`
--

LOCK TABLES `schedulerule` WRITE;
/*!40000 ALTER TABLE `schedulerule` DISABLE KEYS */;
INSERT INTO `schedulerule` VALUES (1,'q1',1,1,_binary '11111111100000\0\0\0\0\0\0',1),(2,'q1',2,6,_binary '11111111110000\0\0\0\0\0\0',1),(3,'q1',1,2,_binary '11111100000000\0\0\0\0\0\0',1),(4,'q1',2,5,_binary '11111111100000\0\0\0\0\0\0',1),(5,'q1',2,4,_binary '11111100000000\0\0\0\0\0\0',1),(6,'q1',1,3,_binary '11111111100000\0\0\0\0\0\0',1),(7,'周日值班',2,6,_binary '1100\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',1),(8,'周日值班',2,5,_binary '11\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0',1),(9,'m1',2,6,_binary '11110000\0\0\0\0\0\0\0\0\0\0\0\0',1),(10,'b1',1,1,_binary '11111111100000\0\0\0\0\0\0',1);
/*!40000 ALTER TABLE `schedulerule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:43
