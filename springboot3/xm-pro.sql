-- MySQL dump 10.13  Distrib 9.0.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: xm-pro
-- ------------------------------------------------------
-- Server version	9.0.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `username`, `password`, `name`, `role`, `avatar`) VALUES (1,'admin','123','管理员','ADMIN','http://localhost:9090/files/download/1733146614669_lun2.png');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '封面',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简介',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '内容',
  `time` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文章';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`id`, `title`, `img`, `description`, `content`, `time`) VALUES (1,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-01 00:40:09'),(2,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-02 00:40:09'),(3,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-03 00:40:09'),(4,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-04 00:40:09'),(5,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-05 00:40:09'),(6,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-10-31 00:40:09'),(7,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-10-30 00:40:09'),(8,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-10-31 00:40:09'),(9,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-01 00:40:09'),(10,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-02 00:40:09'),(11,'23rf',NULL,'dsf','<p>dsfgg</p>','2024-11-01 00:40:09'),(12,'23rf','http://localhost:9090/files/download/1730771655575_lun2.png','dsf','<p>dsfgg</p>','2024-11-04 00:40:09'),(13,'rt','http://localhost:9090/files/download/1731977095594_lun1.png','rty','<p>dsfggrthgbfdttfng</p><p><img src=\"http://localhost:9090/files/download/1730772308541_lun3.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"/><img src=\"http://localhost:9090/files/download/1731977083240_lun1.png\" alt=\"\" data-href=\"\" style=\"\"/></p>','2024-11-05 09:54:40'),(14,'cdmscoskcs',NULL,'cnisdjcnsdocnsd','<p>clksdcnpsdcpdsncpsdcpsdcsodcsdlkcdslcksdkds<img src=\"http://localhost:9090/files/download/1733146712291_bg.jpg\" alt=\"\" data-href=\"\" style=\"\"/></p>','2024-12-02 21:38:19');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`, `name`) VALUES (1,'采购部'),(2,'销售部'),(3,'技术部'),(4,'后勤部');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工号',
  `age` int DEFAULT NULL COMMENT '年龄',
  `description` longtext COLLATE utf8mb4_unicode_ci COMMENT '个人介绍',
  `department_id` int DEFAULT NULL COMMENT '部门',
  `avatar` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `IDCard` char(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employee_pk` (`IDCard`),
  UNIQUE KEY `no` (`no`) USING BTREE,
  CONSTRAINT `employee_chk_1` CHECK (((char_length(`IDCard`) = 18) and regexp_like(`IDCard`,_utf8mb4'^[0-9]{17}[0-9X]$')))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='员工信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`, `username`, `password`, `role`, `name`, `sex`, `no`, `age`, `description`, `department_id`, `avatar`, `address`, `IDCard`) VALUES (1,'djjj','123','EMP','妲己姐姐','女','104',20,'妲己姐姐是王者里面的一位非常厉害的法师',4,'http://localhost:9090/files/download/1730336921183_bg.jpg','河南省洛阳市伊川县','410329200410202046'),(2,'qgg','123','EMP','青哥哥','男','103',32,'青哥哥是一位非常良心的知识UP主，每天都会分享很多有趣实用的编程项目',3,'http://localhost:9090/files/download/1730335826465_lun2.png','河南省许昌市魏都区','411002199204141157'),(3,'xwgg','123','EMP','小武哥哥','男','102',35,'小武哥哥是一位非常风骚的知识区UP主',2,'http://localhost:9090/files/download/1730770916969_lun3.png','河南省许昌市禹州市','411081198901141110'),(4,'zpq','123','EMP','朱佩奇','女','1001',22,'小猪佩奇，一生无敌~',1,'http://localhost:9090/files/download/1733146601689_lun2.png','河南省南阳市邓州市','411381200210040106'),(5,'zqz','123','EMP','朱乔治','男','1002',21,'小猪乔治，真的没治~',1,'http://localhost:9090/files/download/1730336887662_lun1.png','湖北省襄阳市襄城区','420602200301183315'),(6,'xn','123','EMP','xn','男','200111',32,NULL,3,'http://localhost:9090/files/download/1733146577552_lun3.png','湖北省襄阳市宜城市','420684199210102312'),(7,'bgh','123','EMP','白狐','女','1283',19,NULL,1,'http://localhost:9090/files/download/1733146549769_lun1.png','上海市浦东新区','310115200510172048');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'xm-pro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-03 10:26:24
