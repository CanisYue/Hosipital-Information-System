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
-- Table structure for table `completedetail`
--

DROP TABLE IF EXISTS `completedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `completedetail` (
  `complete_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `complete_id` int(11) DEFAULT NULL,
  `medicine_id` int(11) DEFAULT NULL,
  `way` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `total` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `frequency` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`complete_detail_id`) USING BTREE,
  KEY `complete_id` (`complete_id`) USING BTREE,
  KEY `medicine_id` (`medicine_id`) USING BTREE,
  CONSTRAINT `complete_id` FOREIGN KEY (`complete_id`) REFERENCES `complete` (`complete_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `medicine_id` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`medicine_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `completedetail`
--

LOCK TABLES `completedetail` WRITE;
/*!40000 ALTER TABLE `completedetail` DISABLE KEYS */;
INSERT INTO `completedetail` VALUES (92,106,1,'口服','10g','一日一次','2',173),(93,106,3,'口服','3ml','一日两次','1',173),(94,106,6,'含服','5g','一日一次','2',173),(95,106,4,'吞服','1g','一日一次','3',173),(134,128,23,'静脉注射','100ml','一日一次','1',172),(135,128,30,'静脉注射','200ml','一日一次','1',172),(136,129,23,'静脉注射','100ml','一日一次','1',172),(137,129,30,'静脉注射','200ml','一日一次','1',172),(138,130,5,'11','11','11','1',172),(139,130,57,'22','22','22','1',172),(140,131,23,'静脉注射','100ml','一日一次','1',172),(141,131,30,'静脉注射','200ml','一日一次','1',172),(142,132,23,'静脉注射','100ml','一日一次','1',172),(143,132,30,'静脉注射','200ml','一日一次','1',172),(144,133,23,'静脉注射','100ml','一日一次','1',172),(145,133,30,'静脉注射','200ml','一日一次','1',172),(146,134,23,'静脉注射','100ml','一日一次','1',172),(147,134,30,'静脉注射','200ml','一日一次','1',172),(148,135,36,'1','1','1','1',172),(149,135,39,'1','1','1','1',172),(150,135,2,'wef','fawe','waef','1',172),(151,136,23,'静脉注射','100ml','一日一次','1',172),(152,136,30,'静脉注射','200ml','一日一次','1',172),(153,137,36,'1','1','1','1',172),(154,137,39,'1','1','1','1',172),(155,137,2,'wef','fawe','waef','1',172),(156,138,23,'静脉注射','100ml','一日一次','1',172),(157,138,30,'静脉注射','200ml','一日一次','1',172),(158,139,23,'静脉注射','100ml','一日一次','1',171),(159,139,30,'静脉注射','200ml','一日一次','1',171),(167,145,23,'静脉注射','100ml','一日一次','1',172),(168,145,30,'静脉注射','200ml','一日一次','1',171),(169,146,23,'静脉注射','100ml','一日一次','1',172),(170,146,30,'静脉注射','200ml','一日一次','1',171),(182,153,30,'静脉注射','200ml','一日一次','1',171),(188,157,23,'静脉注射','100ml','一日一次','1',171),(189,157,30,'静脉注射','200ml','一日一次','1',171),(190,158,23,'静脉注射','100ml','一日一次','1',175),(191,158,30,'静脉注射','200ml','一日一次','1',175),(192,159,23,'静脉注射','100ml','一日一次','1',171),(193,159,30,'静脉注射','200ml','一日一次','1',171);
/*!40000 ALTER TABLE `completedetail` ENABLE KEYS */;
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
