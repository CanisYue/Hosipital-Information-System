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
-- Table structure for table `operationmodeldetail`
--

DROP TABLE IF EXISTS `operationmodeldetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `operationmodeldetail` (
  `operation_model_detail_id` int(40) NOT NULL AUTO_INCREMENT,
  `medicalproject_id` int(11) DEFAULT NULL,
  `operation_model_id` int(11) DEFAULT NULL,
  `checked_body` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `operation_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `aim` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`operation_model_detail_id`) USING BTREE,
  KEY `operation_model_id` (`operation_model_id`) USING BTREE,
  KEY `medical_project_ie` (`medicalproject_id`) USING BTREE,
  CONSTRAINT `medical_project_ie` FOREIGN KEY (`medicalproject_id`) REFERENCES `medicalproject` (`nonmedicine_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `operation_model_id` FOREIGN KEY (`operation_model_id`) REFERENCES `operationmodel` (`operation_model_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operationmodeldetail`
--

LOCK TABLES `operationmodeldetail` WRITE;
/*!40000 ALTER TABLE `operationmodeldetail` DISABLE KEYS */;
INSERT INTO `operationmodeldetail` VALUES (1,41,2,NULL,NULL,NULL,NULL),(2,44,2,NULL,NULL,NULL,NULL),(3,1,4,'全身',NULL,NULL,NULL),(4,10,4,'胃部',NULL,NULL,NULL),(5,55,1,NULL,NULL,NULL,NULL),(6,36,1,NULL,NULL,NULL,NULL),(7,29,3,NULL,NULL,NULL,NULL),(8,5,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `operationmodeldetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:42
