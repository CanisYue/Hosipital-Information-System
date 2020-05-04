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
-- Table structure for table `completemodel`
--

DROP TABLE IF EXISTS `completemodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `completemodel` (
  `complete_model_id` int(11) NOT NULL AUTO_INCREMENT,
  `complete_model_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `创建时间` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `suitable_area` int(11) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL,
  `suitable_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`complete_model_id`) USING BTREE,
  KEY `doctor_id_complete_model` (`doctor_id`) USING BTREE,
  CONSTRAINT `doctor_id_complete_model` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `completemodel`
--

LOCK TABLES `completemodel` WRITE;
/*!40000 ALTER TABLE `completemodel` DISABLE KEYS */;
INSERT INTO `completemodel` VALUES (2,'念珠菌性皮炎',1,'2019-03-21 13:25:45.000',1,1,NULL),(3,'急性黄疸性丁型肝炎',1,'2019-03-21 13:25:59.000',2,1,NULL),(4,'病毒性胃肠炎',1,'2019-03-21 13:26:25.000',3,1,NULL),(5,'流行性腮腺炎 NOS',1,'2019-03-21 13:26:33.000',1,1,NULL),(7,'春季常发性感冒',1,'2019-03-22 16:34:08.000',3,1,NULL),(8,'季节性常发哮喘',1,'2019-03-29 14:50:13.000',2,1,NULL),(9,'支气管哮喘',1,'2019-04-01 13:43:44.000',2,1,NULL);
/*!40000 ALTER TABLE `completemodel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:46
