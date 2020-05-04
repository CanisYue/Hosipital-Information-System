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
-- Table structure for table `complete`
--

DROP TABLE IF EXISTS `complete`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `complete` (
  `complete_id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_book_id` int(11) DEFAULT NULL,
  `registration_paper_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `complete_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`complete_id`) USING BTREE,
  KEY `registration_paper_id_complete` (`registration_paper_id`) USING BTREE,
  KEY `doctor_id_complete` (`doctor_id`) USING BTREE,
  CONSTRAINT `doctor_id_complete` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `registration_paper_id_complete` FOREIGN KEY (`registration_paper_id`) REFERENCES `registrationpaper` (`registration_paper_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complete`
--

LOCK TABLES `complete` WRITE;
/*!40000 ALTER TABLE `complete` DISABLE KEYS */;
INSERT INTO `complete` VALUES (106,600704,224,1,'处方1','2019-07-18 08:32:43',173),(111,600710,245,1,'f','2019-07-29 15:39:31',190),(128,600710,245,1,'念珠菌性皮炎','2019-07-29 21:57:52',176),(129,600711,246,1,'念珠菌性皮炎','2019-07-30 11:58:03',176),(130,600711,246,1,'急性黄疸性丁型肝炎','2019-07-30 12:01:29',176),(131,600711,246,1,'念珠菌性皮炎','2019-07-30 12:06:43',176),(132,600711,246,1,'念珠菌性皮炎','2019-07-30 12:08:04',176),(133,600711,246,1,'念珠菌性皮炎','2019-07-30 12:08:05',176),(134,600711,246,1,'念珠菌性皮炎','2019-07-30 12:08:06',176),(135,600711,246,1,'病毒性胃肠炎','2019-07-30 12:14:48',176),(136,600711,246,1,'念珠菌性皮炎','2019-07-30 12:19:17',176),(137,600711,246,1,'病毒性胃肠炎','2019-07-30 12:22:40',176),(138,600711,246,1,'念珠菌性皮炎','2019-07-30 12:22:45',176),(139,600711,246,1,'念珠菌性皮炎','2019-07-30 12:22:50',176),(145,600600,250,1,'念珠菌性皮炎','2019-08-30 14:58:33',171),(146,600600,250,1,'念珠菌性皮炎','2019-08-30 14:59:00',171),(153,600600,251,1,'念珠菌性皮炎','2019-08-30 15:57:01',171),(157,600600,250,1,'念珠菌性皮炎','2019-08-30 16:01:23',171),(158,600600,252,1,'念珠菌性皮炎','2019-08-31 15:33:41',175),(159,600600,258,1,'念珠菌性皮炎','2019-09-01 10:18:50',171),(161,600600,258,1,'r','2019-09-01 10:19:53',176);
/*!40000 ALTER TABLE `complete` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:40
