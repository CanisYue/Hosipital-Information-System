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
-- Table structure for table `medicalproject`
--

DROP TABLE IF EXISTS `medicalproject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicalproject` (
  `nonmedicine_id` int(11) NOT NULL AUTO_INCREMENT,
  `nonmedicine_encoding` int(11) DEFAULT NULL,
  `nonmedicine_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `measurement` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `unitprice` double DEFAULT NULL,
  `belong_department_id` int(11) DEFAULT NULL,
  `x_department_id` int(11) DEFAULT NULL,
  `pingyin` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `最后修改时间` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `徙木立信` int(11) DEFAULT NULL,
  `delete` int(11) DEFAULT NULL,
  PRIMARY KEY (`nonmedicine_id`) USING BTREE,
  KEY ` _idx` (`x_department_id`) USING BTREE,
  KEY `belong_department_id_idx` (`belong_department_id`) USING BTREE,
  CONSTRAINT `belong_department_id` FOREIGN KEY (`belong_department_id`) REFERENCES `department` (`department_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `x_department_id` FOREIGN KEY (`x_department_id`) REFERENCES `department` (`department_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalproject`
--

LOCK TABLES `medicalproject` WRITE;
/*!40000 ALTER TABLE `medicalproject` DISABLE KEYS */;
INSERT INTO `medicalproject` VALUES (1,120200001,'大抢救','日',200,16,133,'DQJ','2019-03-01','',3,1),(2,120200002,'中抢救','日',150,16,133,'ZQJ','2019-03-01','',3,1),(3,120200003,'小抢救','日',80,16,133,'XQJ','2019-03-01','',3,1),(4,120300001,'中心吸氧','小时',2.5,16,122,'ZXXY','2019-03-01','',3,1),(5,120300002,'低流量吸氧','小时',2,16,122,'DLLXY','2019-03-01','',3,1),(6,120300003,'高频吸氧','小时',4,16,122,'GPXY','2019-03-01','',3,1),(7,120500001,'大清创缝合','次',120,16,133,'DQCFH','2019-03-01','',3,1),(8,120500002,'中清创缝合','次',80,16,133,'ZQCFH','2019-03-01','',3,1),(9,120500003,'小清创缝合','次',40,16,133,'XQCFH','2019-03-01','',3,1),(10,121000001,'洗胃','次',40,16,133,'XW','2019-03-01','',3,1),(11,120800002,'肠内高营养治疗','日',5,16,133,'CNGYYZL','2019-03-01','',3,1),(12,121500001,'灌肠','次',10,16,133,'GC','2019-03-01','',3,1),(13,240100003,'计算机治疗计划系统(TPS)','疗程',180,7,128,'JSJZLJHXT','2019-03-01','',3,1),(14,240100004,'特定计算机治疗计划系统','疗程',500,7,128,'TDJSJZLJHXT','2019-03-01','',3,1),(18,240100004,'逆向调强TPS及优化治疗计划系统','疗程',500,7,128,'NXTQTPSJYHZLJHXT','2019-03-01','',3,1),(19,240100005,'放射治疗的适时监控','次',50,7,128,'FSZLDSSJK','2019-03-01','',3,1),(20,210101001,'普通透视','每个部位',5,7,128,'PTTS','2019-03-01','',1,1),(25,210101002,'食管钡餐透视','次',15,7,128,'SGBCTS','2019-03-01','',1,1),(26,210101003,'床旁透视与术中透视','半小时',40,7,128,'CPTSYSZTS','2019-03-01','',1,1),(27,210101004,'C型臂术中透视','半小时',150,7,128,'CXBSZTS','2019-03-01','',1,1),(28,210103001,'气脑造影','次',80,7,128,'QNZY','2019-03-01','',1,1),(29,210103003,'脑室碘水造影','次',60,7,128,'NSDSZY','2019-03-01','',1,1),(30,210103004,'X清肌酸激酶－MB同工酶活性测定（干化X法）','次',60,3,125,'XQJSJM－MBTGMHXCD（GHXF）','2019-03-01','',2,1),(31,210103005,'X清肌酸激酶－MB同工酶活性测定（金标法）','次',60,3,125,'XQJSJM－MBTGMHXCD（JBF）','2019-03-01','',2,1),(32,210103006,'尿α1微量球蛋白测定（化X发光法）','单侧',50,3,125,'Nα1WLQDBCD（HXFGF）','2019-03-01','',2,1),(33,210103007,'β2微球蛋白测定（各种免疫X方法）','单侧',50,3,125,'β2WQDBCD（GZMYXFF）','2019-03-01','',2,1),(34,210103008,'X清β2微球蛋白测定（化X发光法）','单侧',40,3,125,'XQβ2WQDBCD（HXFGF）','2019-03-01','',2,1),(35,210103009,'尿β2微球蛋白测定（化X发光法）','单侧',80,3,125,'Nβ2WQDBCD（HXFGF）','2019-03-01','',2,1),(36,210103010,'尿蛋白电泳分析（凝胶法）','单侧',70,3,125,'NDBDYFX（NJF）','2019-03-01','',2,1),(37,210103011,'X清抗谷氨酸脱J酶抗体测定（各种免疫X方法）','单侧',50,3,125,'XQKGASTJMKTCD（GZMYXFF）','2019-03-01','',2,1),(38,210103012,'胃泌素测定（各种免疫X方法）','次',50,3,125,'WMSCD（GZMYXFF）','2019-03-01','',2,1),(39,210103013,'X浆凝X酶原时间测定(PT)(仪器法)','次',50,3,125,'XJNXMYSJCD(PT)(YQF)','2019-03-01','',2,1),(40,210103014,'X清肌酸激酶－MB同工酶活性测定（速率法）','次',60,3,125,'XQJSJM－MBTGMHXCD（SLF）','2019-03-01','',2,1),(41,210103015,'醛固酮测定（化X发光法、荧光免疫法）','次',50,3,125,'QGTCD（HXFGF、YGMYF）','2019-03-01','',2,1),(42,210103016,'尿儿茶酚胺测定（色谱法）','次',80,3,125,'NECFACD（SPF）','2019-03-01','',2,1),(43,210103017,'尿香草苦杏仁酸(VMA)测定（色谱法）','次',60,3,125,'NXCKXRS(VMA)CD（SPF）','2019-03-01','',2,1),(44,210103018,'X浆肾素活性测定','次',80,3,125,'XJSSHXCD','2019-03-01','',2,1),(45,210103019,'X管紧张素Ⅱ测定','次',100,3,125,'XGJZSⅡCD','2019-03-01','',2,1),(46,210103020,'促红细胞生成素测定','次',50,3,125,'CHXBSCSCD','2019-03-01','',2,1),(47,210103021,'睾酮测定（化X发光法、荧光免疫法）','次',80,3,125,'ZTCD（HXFGF、YGMYF）','2019-03-01','',2,1),(48,210103022,'葡萄糖测定（干化X法）(X清)','次',300,3,125,'PTTCD（GHXF）(XQ)','2019-03-01','',2,1),(49,210103023,'糖化X红蛋白测定（色谱法）','次',80,3,125,'THXHDBCD（SPF）','2019-03-01','',2,1),(50,210103024,'X浆乳酸测定','次',80,3,125,'XJRSCD','2019-03-01','',2,1),(51,210103025,'尿N-X-β-D-氨基葡萄糖苷酶测定','次',70,3,125,'NN-X-β-D-AJPTTZMCD','2019-03-01','',2,1),(52,210103026,'尿β-D-半乳糖苷酶测定','次',50,3,125,'Nβ-D-BRTZMCD','2019-03-01','',2,1),(53,210103027,'唐氏综合症筛查','单侧',70,3,125,'TSZHZSC','2019-03-01','',2,1),(54,210103028,'雌三醇测定（化X发光法、荧光免疫法）','次',50,3,125,'CSCCD（HXFGF、YGMYF）','2019-03-01','',2,1),(55,210103029,'雌二醇测定（化X发光法、荧光免疫法）','次',50,3,125,'CECCD（HXFGF、YGMYF）','2019-03-01','',2,1),(56,210103030,'孕酮测定（化X发光法、荧光免疫法）','单侧',50,3,125,'YTCD（HXFGF、YGMYF）','2019-03-01','',2,1);
/*!40000 ALTER TABLE `medicalproject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 10:37:39
