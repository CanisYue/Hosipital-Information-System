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
-- Table structure for table `completemodeldetail`
--

DROP TABLE IF EXISTS `completemodeldetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `completemodeldetail` (
  `complete_model_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `complete_model_id` int(11) DEFAULT NULL,
  `medicine_id` int(11) DEFAULT NULL,
  `way` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `total` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `frequency` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`complete_model_detail_id`) USING BTREE,
  KEY `complete_model_id` (`complete_model_id`) USING BTREE,
  KEY `medicine_id_complete_model_detail` (`medicine_id`) USING BTREE,
  CONSTRAINT `complete_model_id` FOREIGN KEY (`complete_model_id`) REFERENCES `completemodel` (`complete_model_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `medicine_id_complete_model_detail` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`medicine_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `completemodeldetail`
--

LOCK TABLES `completemodeldetail` WRITE;
/*!40000 ALTER TABLE `completemodeldetail` DISABLE KEYS */;
INSERT INTO `completemodeldetail` VALUES (2,2,23,'静脉注射','100ml','一日一次',1),(3,2,30,'静脉注射','200ml','一日一次',1),(4,5,86,'fe','fe','fw',1),(6,3,5,'11','11','11',1),(7,3,57,'22','22','22',1),(8,7,9,'1','1','1',1),(9,4,36,'1','1','1',1),(10,4,39,'1','1','1',1),(11,4,2,'wef','fawe','waef',1),(12,8,9,'口服','1g','一日三次',1),(13,8,33,'口服','2g','一日三次',1),(14,8,47,'口服','适量','多次',1),(15,9,44,'11','11','11',1),(18,9,68,'22','22','22',1);
/*!40000 ALTER TABLE `completemodeldetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:50
