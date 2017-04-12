CREATE DATABASE  IF NOT EXISTS `Pola` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `Pola`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: Pola
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Customization`
--

DROP TABLE IF EXISTS `Customization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customization` (
  `idCustomization` int(11) NOT NULL AUTO_INCREMENT,
  `ribbon` enum('W','B','NONE') NOT NULL DEFAULT 'B',
  `image` varchar(45) DEFAULT NULL,
  `elastic` enum('Y','N') NOT NULL DEFAULT 'Y',
  `pageType` enum('PLAIN','LINED','AGENDA') NOT NULL DEFAULT 'PLAIN',
  PRIMARY KEY (`idCustomization`),
  UNIQUE KEY `idCustomization_UNIQUE` (`idCustomization`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customization`
--

LOCK TABLES `Customization` WRITE;
/*!40000 ALTER TABLE `Customization` DISABLE KEYS */;
INSERT INTO `Customization` VALUES (1,'B','path','Y','PLAIN'),(2,'NONE','path','N','LINED'),(3,'W','','Y','PLAIN'),(4,'W','path','N','PLAIN'),(5,'NONE','path','N','LINED'),(6,'W','path','N','LINED');
/*!40000 ALTER TABLE `Customization` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-12  4:48:51
