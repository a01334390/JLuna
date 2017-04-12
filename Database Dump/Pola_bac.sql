-- MySQL dump 10.13  Distrib 5.7.17, for osx10.12 (x86_64)
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
-- Table structure for table `Client`
--

DROP TABLE IF EXISTS `Client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `second_name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `isPhysical` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `idClient_UNIQUE` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Client`
--

LOCK TABLES `Client` WRITE;
/*!40000 ALTER TABLE `Client` DISABLE KEYS */;
INSERT INTO `Client` VALUES (3,'Otra Pola','menos pola','Ella tambien vive en tu cora',0);
/*!40000 ALTER TABLE `Client` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `Inventory`
--

DROP TABLE IF EXISTS `Inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Inventory` (
  `ammount` int(11) NOT NULL,
  `id_Notebook` int(11) NOT NULL,
  UNIQUE KEY `id_Notebook_UNIQUE` (`id_Notebook`),
  CONSTRAINT `idNotebook` FOREIGN KEY (`id_Notebook`) REFERENCES `Notebook` (`idNotebook`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Inventory`
--

LOCK TABLES `Inventory` WRITE;
/*!40000 ALTER TABLE `Inventory` DISABLE KEYS */;
INSERT INTO `Inventory` VALUES (100,1),(300,2),(300,3);
/*!40000 ALTER TABLE `Inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Material`
--

DROP TABLE IF EXISTS `Material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Material` (
  `idMaterial` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `cost` float NOT NULL,
  PRIMARY KEY (`idMaterial`),
  UNIQUE KEY `idMaterial_UNIQUE` (`idMaterial`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Material`
--

LOCK TABLES `Material` WRITE;
/*!40000 ALTER TABLE `Material` DISABLE KEYS */;
INSERT INTO `Material` VALUES (1,'Prensa',200,200),(3,'Tijeras',400,500);
/*!40000 ALTER TABLE `Material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Notebook`
--

DROP TABLE IF EXISTS `Notebook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Notebook` (
  `idNotebook` int(11) NOT NULL AUTO_INCREMENT,
  `average_time` time NOT NULL,
  `type` varchar(45) NOT NULL,
  `benefit` float NOT NULL,
  PRIMARY KEY (`idNotebook`),
  UNIQUE KEY `idNotebook_UNIQUE` (`idNotebook`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Notebook`
--

LOCK TABLES `Notebook` WRITE;
/*!40000 ALTER TABLE `Notebook` DISABLE KEYS */;
INSERT INTO `Notebook` VALUES (1,'04:00:00','Hard Cover Grande',200),(2,'06:00:00','Hard Cover Mediano',70),(3,'08:00:00','Hard Cover Agenda',50);
/*!40000 ALTER TABLE `Notebook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Notebook_Material`
--

DROP TABLE IF EXISTS `Notebook_Material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Notebook_Material` (
  `notebook_id` int(11) DEFAULT NULL,
  `material_id` int(11) DEFAULT NULL,
  KEY `material_id_idx` (`material_id`),
  KEY `notebook_id` (`notebook_id`),
  CONSTRAINT `material_id` FOREIGN KEY (`material_id`) REFERENCES `Material` (`idMaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `notebook_id` FOREIGN KEY (`notebook_id`) REFERENCES `Notebook` (`idNotebook`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Notebook_Material`
--

LOCK TABLES `Notebook_Material` WRITE;
/*!40000 ALTER TABLE `Notebook_Material` DISABLE KEYS */;
/*!40000 ALTER TABLE `Notebook_Material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Notebook_Order`
--

DROP TABLE IF EXISTS `Notebook_Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Notebook_Order` (
  `id_Notebook` int(11) NOT NULL,
  `id_Order` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  `id_Customization` int(11) NOT NULL,
  KEY `id_Order_idx` (`id_Order`),
  KEY `id_Notebook_idx` (`id_Notebook`),
  KEY `id_customization_idx` (`id_Customization`),
  CONSTRAINT `id_Notebook` FOREIGN KEY (`id_Notebook`) REFERENCES `Notebook` (`idNotebook`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `id_Order` FOREIGN KEY (`id_Order`) REFERENCES `Order` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_customization` FOREIGN KEY (`id_Customization`) REFERENCES `Customization` (`idCustomization`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Notebook_Order`
--

LOCK TABLES `Notebook_Order` WRITE;
/*!40000 ALTER TABLE `Notebook_Order` DISABLE KEYS */;
INSERT INTO `Notebook_Order` VALUES (2,6,2,'Diseño',4),(1,7,32,'Diseño',5),(1,8,4,'Diseño',6);
/*!40000 ALTER TABLE `Notebook_Order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Order`
--

DROP TABLE IF EXISTS `Order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Order` (
  `idOrder` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `priority` enum('LOW','MEDIUM','HIGH') NOT NULL DEFAULT 'LOW',
  `create_time` datetime NOT NULL,
  `client_id` int(11) NOT NULL,
  PRIMARY KEY (`idOrder`),
  UNIQUE KEY `idOrder_UNIQUE` (`idOrder`),
  KEY `client_id_idx` (`client_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `Client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Order`
--

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;
INSERT INTO `Order` VALUES (6,'2017-02-21','LOW','2017-04-12 02:53:03',3),(7,'2029-02-22','LOW','2017-04-12 02:57:23',3),(8,'2022-02-21','LOW','2017-04-12 03:01:33',3);
/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `username` varchar(16) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `privilege` enum('admin','manager','worker') NOT NULL DEFAULT 'worker',
  `first_name` varchar(255) NOT NULL,
  `second_name` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('arpi','arpi@torres.arpi','arpi','worker','Arpi','Torres Arpi','path','2017-04-11 21:04:56'),('Coraline','cor@laika.com','coraline','manager','Coraline','Jones','Path','2017-04-11 23:17:24'),('pola','pola@imakenotebooks.com','pola','admin','Polita','Garza','path','2017-04-11 22:55:36');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-12 12:53:12
