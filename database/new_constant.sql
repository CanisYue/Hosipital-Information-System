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
-- Table structure for table `constant`
--

DROP TABLE IF EXISTS `constant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `constant` (
  `constant_id` int(11) NOT NULL AUTO_INCREMENT,
  `constant_category_id` int(11) DEFAULT NULL,
  `constant_encoding` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `constant_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `delete` int(11) DEFAULT NULL,
  PRIMARY KEY (`constant_id`) USING BTREE,
  KEY `_idx` (`constant_category_id`) USING BTREE,
  CONSTRAINT `constantcategory_id` FOREIGN KEY (`constant_category_id`) REFERENCES `constantcategory` (`constant_category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `constant`
--

LOCK TABLES `constant` WRITE;
/*!40000 ALTER TABLE `constant` DISABLE KEYS */;
INSERT INTO `constant` VALUES (11,1,'NK','内科',1),(12,1,'WK','外科',1),(14,1,'EK','儿科',1),(15,1,'CRBK','传染病科',1),(16,1,'FCK','妇产科',1),(17,1,'NK','男科',1),(18,1,'JSXLK','精神心理科',1),(19,1,'PFXBK','皮肤性病科',1),(20,1,'ZYK','中医科',1),(21,1,'ZLK','肿瘤科',1),(22,1,'GK','骨科',1),(23,1,'WGK','五官科',1),(24,1,'KFYXK','康复医学科',1),(25,1,'MZYXK','麻醉医学科',1),(26,1,'YYK','营养科',1),(27,1,'YJK','医技科',1),(28,1,'YXYXX','医学影像学',1),(29,1,'QTKS','其他科室',1),(51,5,'XJ','现金',1),(52,5,'YBK','医保卡',1),(53,5,'YHK','银行卡',1),(54,5,'XYK','信用卡',1),(55,5,'WX','微信',1),(56,5,'ZFB','支付宝',1),(57,5,'YSF','云闪付',1),(58,5,'QT','其它',1),(71,7,'NAN','男',1),(72,7,'NV','女',1),(81,8,'ZRYS','主任医师',1),(82,8,'FZRYS','副主任医师',1),(83,8,'ZZYS','主治医师',1),(84,8,'ZYYS','住院医师',1),(101,10,'XY','西药',1),(102,10,'ZCY','中成药',1),(103,10,'ZCY','中草药',1),(110,11,'ZJ','针剂',1),(111,11,'PJ','片剂',1),(112,11,'ZYYP','中药饮片',1),(113,11,'SJ','散剂',1),(114,11,'JN','胶囊',1),(115,11,'KLJ','颗粒剂',1),(116,11,'FJ','粉剂',1),(117,11,'BMP','簿膜片',1),(118,11,'RJ','乳剂',1),(119,11,'YJ','液剂',1),(120,11,'NJ','凝胶',1),(121,11,'RGJ','软膏剂',1),(122,11,'QWJ','气雾剂',1),(123,11,'FSP','分散片',1),(124,11,'YPQX','药品器械',1),(125,11,'SJ','栓剂',1),(126,11,'NFSJ','内服水剂',1),(127,11,'PJ','喷剂',1),(128,11,'JJ','胶剂',1),(129,11,'TJ','酊剂',1),(130,11,'DJ','滴剂',1),(131,11,'HSP','缓释片',1),(132,11,'YGZJ','眼膏制剂',1),(133,11,'CRP','肠溶片',1),(134,11,'SJ','霜剂',1),(135,11,'DEJ','滴耳剂',1),(136,11,'HXJ','混悬剂',1),(137,11,'HSJN','缓释胶囊',1),(138,11,'NJJN','凝胶胶囊',1),(139,11,'CJ','擦剂',1),(140,11,'HP','含片',1),(141,11,'GHJ','干混剂',1),(142,11,'XJ','洗剂',1),(143,11,'BPJ','鼻喷剂',1),(144,11,'MJ','膜剂',1),(145,11,'TG','贴膏',1),(146,11,'TJ','贴剂',1),(147,11,'HJ','合剂',1),(148,11,'SJ','湿巾',1),(149,11,'KPJ','口喷剂',1),(150,11,'DSY','大输液',1),(151,11,'YPCL','药品材料',1),(152,11,'KSP','控释片',1),(153,11,'DBJ','滴鼻剂',1),(154,11,'DW','滴丸',1),(155,11,'GTJJ','干糖浆剂',1),(156,11,'WHXRJ','雾化吸入剂',1),(157,11,'YLY','原料药',1),(158,11,'TJJ','糖浆剂',1),(159,11,'RJN','软胶囊',1),(160,11,'DYJ','滴眼剂',1),(161,11,'DGFZ','冻干粉针',1),(162,11,'CJ','冲剂',1),(163,11,'WJ','丸剂',1),(164,11,'KFYL','口服液类',1),(165,12,'MZYS','门诊医生',1),(166,12,'YJYS','医技医生',1),(167,13,'GHSFY','挂号收费员',1),(168,13,'YIGLY','医院管理员',1),(169,13,'YPGLY','药品管理员',1),(170,14,'WJF','未缴费',1),(171,14,'WXF','未消费',1),(172,14,'YXF','已消费',1),(173,14,'YTF','已退费',1),(174,14,'ZF','作废',1),(175,15,'ZC','暂存',1),(176,15,'TJ','提交',1),(177,15,'ZB','诊毕',1),(178,16,'CZ','初诊',1),(179,16,'ZZ','终诊',1);
/*!40000 ALTER TABLE `constant` ENABLE KEYS */;
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
