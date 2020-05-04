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
-- Table structure for table `frontpage`
--

DROP TABLE IF EXISTS `frontpage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `frontpage` (
  `front_page_id` int(11) NOT NULL AUTO_INCREMENT,
  `registration_paper_id` int(11) DEFAULT NULL,
  `main_problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `disease_for_now` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `treatment_for_now` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `disease_for_past` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `allergic_history` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `body_check` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `check_advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `notice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`front_page_id`) USING BTREE,
  KEY `registration_paper_id1` (`registration_paper_id`) USING BTREE,
  CONSTRAINT `registration_paper_front_page` FOREIGN KEY (`registration_paper_id`) REFERENCES `registrationpaper` (`registration_paper_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frontpage`
--

LOCK TABLES `frontpage` WRITE;
/*!40000 ALTER TABLE `frontpage` DISABLE KEYS */;
INSERT INTO `frontpage` VALUES (29,224,'胃疼','胃很疼','吃饭','胃炎','无','没有','无建议','无注意事项',176),(30,225,'哈','无','无','无','青霉素','无','无建议','无注意事项',176),(31,226,'1','1','1','1','1','1','无建议','无注意事项',176),(32,227,'1','1','1','1','1','1','无建议','无注意事项',176),(33,228,'1','1','1','1','1','1','无建议','无注意事项',176),(34,231,'2','2','2','2','2','2','无建议','无注意事项',176),(35,231,'2','2','2','2','2','2','无建议','无注意事项',176),(36,231,'2','2','2','2','2','2','无建议','无注意事项',176),(37,232,'2','2','2','2','2','2','无建议','无注意事项',176),(38,233,'2','2','2','2','2','2','无建议','无注意事项',176),(39,234,'2','2','2','2','2','2','无建议','无注意事项',176),(40,244,'test','test','tset','test','test','setse','无建议','无注意事项',176),(41,245,'test','tes','test','test','test','tsets','无建议','无注意事项',176),(42,246,'1','1','1','1','1','1','无建议','无注意事项',176),(43,250,'f','f','f','f','f','f','无建议','无注意事项',176),(44,251,'f','f','f','f','f','f','无建议','无注意事项',176),(45,252,'f','f','f','f','f','f','无建议','无注意事项',176),(46,255,'1','1','1','1','1','1','无建议','无注意事项',176),(47,258,'w','w','w','w','w','w','无建议','无注意事项',176);
/*!40000 ALTER TABLE `frontpage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:51
