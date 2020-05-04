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
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL AUTO_INCREMENT,
  `time` date DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `morning_afternoon` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `schedule_rule_id` int(11) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL,
  PRIMARY KEY (`schedule_id`) USING BTREE,
  KEY `depatment_id_idx` (`department_id`) USING BTREE,
  KEY `doctor_id_idx` (`doctor_id`) USING BTREE,
  CONSTRAINT `depatment_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `doctor_id` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (54,'2019-04-01',1,1,'上午',1,1),(55,'2019-04-01',1,2,'上午',3,1),(56,'2019-04-01',1,3,'上午',6,1),(57,'2019-04-01',1,2,'下午',3,1),(58,'2019-04-01',1,3,'下午',6,1),(59,'2019-04-02',1,2,'上午',3,1),(60,'2019-04-02',1,3,'上午',6,1),(61,'2019-04-02',1,2,'下午',3,1),(62,'2019-04-02',1,3,'下午',6,1),(63,'2019-04-03',1,2,'上午',3,1),(64,'2019-04-01',1,1,'下午',1,1),(65,'2019-04-03',1,3,'上午',6,1),(66,'2019-04-03',1,2,'下午',3,1),(67,'2019-04-02',1,1,'上午',1,1),(68,'2019-04-03',1,3,'下午',6,1),(69,'2019-04-02',1,1,'下午',1,1),(70,'2019-04-04',1,3,'上午',6,1),(71,'2019-04-03',1,1,'上午',1,1),(72,'2019-04-04',1,3,'下午',6,1),(73,'2019-04-03',1,1,'下午',1,1),(74,'2019-04-05',1,3,'上午',6,1),(75,'2019-04-04',1,1,'上午',1,1),(76,'2019-04-04',1,1,'下午',1,1),(77,'2019-04-05',1,1,'上午',1,1),(78,'2019-03-25',1,1,'上午',10,1),(79,'2019-03-25',1,1,'下午',10,1),(80,'2019-03-26',1,1,'上午',10,1),(81,'2019-03-26',1,1,'下午',10,1),(82,'2019-03-27',1,1,'上午',10,1),(83,'2019-03-27',1,1,'下午',10,1),(84,'2019-03-28',1,1,'上午',10,1),(85,'2019-03-28',1,1,'下午',10,1),(86,'2019-03-29',1,1,'上午',10,1);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:41
