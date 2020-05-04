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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_encoding` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `department_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `department_type_id` int(11) DEFAULT NULL,
  `department_category_id` int(11) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL,
  PRIMARY KEY (`department_id`) USING BTREE,
  KEY `_idx` (`department_type_id`) USING BTREE,
  CONSTRAINT `department_type_id` FOREIGN KEY (`department_type_id`) REFERENCES `constant` (`constant_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'XXGNK','心血管内科',11,1,1),(2,'SJNK','神经内科',11,1,1),(3,'PTNK','普通内科',11,1,1),(4,'XHNK','消化内科',11,1,1),(5,'HXNK','呼吸内科',11,1,1),(6,'NFMK','内分泌科',11,1,1),(7,'SBNK','肾病内科',11,1,1),(8,'XYNK','血液内科',11,1,1),(9,'GRNK','感染内科',11,1,1),(10,'LNBNK','老年病内科',11,1,1),(11,'FSMYNK','风湿免疫内科',11,1,1),(12,'TXK','透析科',11,1,1),(13,'BTFYK','变态反应科',11,1,1),(14,'PTWK','普通外科',12,1,1),(15,'MNWK','泌尿外科',12,1,1),(16,'SJWK','神经外科',12,1,1),(17,'XWK','胸外科',12,1,1),(18,'ZXWK','整形外科',12,1,1),(19,'GCWK','肛肠外科',12,1,1),(20,'GDWK','肝胆外科',12,1,1),(21,'RXWK','乳腺外科',12,1,1),(22,'XXGWK','心血管外科',12,1,1),(23,'XZWK','心脏外科',12,1,1),(24,'QGYZ','器官移植',12,1,1),(25,'WCWK','微创外科',12,1,1),(26,'GNSJWK','功能神经外科',12,1,1),(27,'XTWK','腺体外科',12,1,1),(28,'EKZH','儿科综合',14,1,1),(29,'XEWK','小儿外科',14,1,1),(30,'ETBJK','儿童保健科',14,1,1),(31,'XSEK','新生儿科',14,1,1),(32,'XEGK','小儿骨科',14,1,1),(33,'XESJNK','小儿神经内科',14,1,1),(34,'XEHXK','小儿呼吸科',14,1,1),(35,'XEXYK','小儿血液科',14,1,1),(36,'XEEBHK','小儿耳鼻喉科',14,1,1),(37,'XEXNK','小儿心内科',14,1,1),(38,'XEKFK','小儿康复科',14,1,1),(39,'XEJSK','小儿精神科',14,1,1),(40,'XESNK','小儿肾内科',14,1,1),(41,'XEXHK','小儿消化科',14,1,1),(42,'XEPFK','小儿皮肤科',14,1,1),(43,'XEJZK','小儿急诊科',14,1,1),(44,'XENFMK','小儿内分泌科',14,1,1),(45,'XEMNWK','小儿泌尿外科',14,1,1),(46,'XEGRK','小儿感染科',14,1,1),(47,'XEXWK01','小儿心外科',14,1,1),(48,'XEXWK02','小儿胸外科',14,1,1),(49,'XESJWK','小儿神经外科',14,1,1),(50,'XEZXK','小儿整形科',14,1,1),(51,'XEFSMYK','小儿风湿免疫科',14,1,1),(52,'XEFK','小儿妇科',14,1,1),(53,'CRK','传染科',15,1,1),(54,'GBK','肝病科',15,1,1),(55,'AZBK','艾滋病科',15,1,1),(56,'CRWZS','传染危重室',15,1,1),(57,'FCKZH','妇产科综合',16,1,1),(58,'FK','妇科',16,1,1),(59,'CK','产科',16,1,1),(60,'JHSYK','计划生育科',16,1,1),(61,'FKNFM','妇科内分泌',16,1,1),(62,'YCZYK','遗传咨询科',16,1,1),(63,'CQJCK','产前检查科',16,1,1),(64,'FMNK','妇泌尿科',16,1,1),(65,'QLX','前列腺',17,1,1),(66,'XGNZA','性功能障碍',17,1,1),(67,'SZQGR','生殖器感染',17,1,1),(68,'NXBY','男性不育',17,1,1),(69,'SZZX','生殖整形',17,1,1),(70,'JSK','精神科',18,1,1),(71,'SFJDK','司法鉴定科',18,1,1),(72,'YWYLK','药物依赖科',18,1,1),(73,'ZYJSK','中医精神科',18,1,1),(74,'SXZAK','双相障碍科',18,1,1),(75,'PFK','皮肤科',19,1,1),(76,'XBK','性病科',19,1,1),(77,'ZYZHK','中医综合科',20,1,1),(78,'ZJK','针灸科',20,1,1),(79,'ZYGK','中医骨科',20,1,1),(80,'ZYFCK','中医妇产科',20,1,1),(81,'ZYWK','中医外科',20,1,1),(82,'ZYEK','中医儿科',20,1,1),(83,'ZYGCK','中医肛肠科',20,1,1),(84,'ZYPFK','中医皮肤科',20,1,1),(85,'ZYWGK','中医五官科',20,1,1),(86,'ZYAMK','中医按摩科',20,1,1),(87,'ZYXHK','中医消化科',20,1,1),(88,'ZYZLK','中医肿瘤科',20,1,1),(89,'ZYXNK','中医心内科',20,1,1),(90,'ZYSJNK','中医神经内科',20,1,1),(91,'ZYSBNK','中医肾病内科',20,1,1),(92,'ZYNFM','中医内分泌',20,1,1),(93,'ZYHXK','中医呼吸科',20,1,1),(94,'ZYGBK','中医肝病科',20,1,1),(95,'ZYNK','中医男科',20,1,1),(96,'ZYFSMYNK','中医风湿免疫内科',20,1,1),(97,'ZYXYK','中医血液科',20,1,1),(98,'ZYRXWK','中医乳腺外科',20,1,1),(99,'ZYLNBK','中医老年病科',20,1,1),(100,'ZLZHK','肿瘤综合科',21,1,1),(101,'ZLNK','肿瘤内科',21,1,1),(102,'FLK','放疗科',21,1,1),(103,'ZLWK','肿瘤外科',21,1,1),(104,'ZLFK','肿瘤妇科',21,1,1),(105,'GZLK','骨肿瘤科',21,1,1),(106,'ZLKFK','肿瘤康复科',21,1,1),(107,'GWK','骨外科',22,1,1),(108,'SWK','手外科',22,1,1),(109,'CSGK','创伤骨科',22,1,1),(110,'JZWK','脊柱外科',22,1,1),(111,'GGJK','骨关节科',22,1,1),(112,'GZSSK','骨质疏松科',22,1,1),(113,'JXGK','矫形骨科',22,1,1),(114,'EBYHTJK','耳鼻咽喉头颈科',23,1,1),(115,'KQK','口腔科',23,1,1),(116,'YK','眼科',23,1,1),(117,'KFK','康复科',24,2,1),(118,'LLK','理疗科',24,2,1),(119,'MZK','麻醉科',25,2,1),(120,'TTK','疼痛科',25,2,1),(121,'YYK','营养科',26,2,1),(122,'GYYK','高压氧科',27,2,1),(123,'GNJCK','功能检查科',27,2,1),(124,'BLK','病理科',27,2,1),(125,'JYK','检验科',27,2,1),(126,'SYZX','实验中心',27,2,1),(127,'XDTK','心电图科',27,2,1),(128,'FSK','放射科',28,2,1),(129,'CSZDK','超声诊断科',28,2,1),(130,'YXYXK','医学影像科',28,2,1),(131,'HYK','核医学科',28,2,1),(132,'YJK','药剂科',29,2,1),(133,'HLK','护理科',29,2,1),(134,'TJK','体检科',29,2,1),(135,'JZK','急诊科',29,2,1),(136,'GGWSYYFK','公共卫生与预防科',29,2,1),(137,'SBK','设备科',29,4,1),(138,'CWK','财务科',29,3,1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
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
