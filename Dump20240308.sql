CREATE DATABASE  IF NOT EXISTS `carburante` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carburante`;
-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: carburante
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

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
-- Table structure for table `acquisti`
--

DROP TABLE IF EXISTS `acquisti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acquisti` (
  `id_acquisto` int NOT NULL AUTO_INCREMENT,
  `prodotto` varchar(45) NOT NULL,
  `qta` double NOT NULL,
  `pu_imp` double NOT NULL,
  `data_a` date NOT NULL,
  `stazione` varchar(45) NOT NULL,
  PRIMARY KEY (`id_acquisto`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acquisti`
--

LOCK TABLES `acquisti` WRITE;
/*!40000 ALTER TABLE `acquisti` DISABLE KEYS */;
INSERT INTO `acquisti` VALUES (24,'BENZINA',7000,1.4147,'2024-01-05','Stazione'),(25,'DIESEL',18000,1.37372,'2024-01-05','Stazione'),(26,'BENZINA',7000,1.4147,'2024-01-10','Stazione'),(27,'DIESEL',20000,1.37372,'2024-01-10','Stazione'),(28,'BENZINA',7000,1.39831,'2024-01-15','Stazione'),(29,'DIESEL',20000,1.35732,'2024-01-15','Stazione'),(30,'BENZINA',5999,1.4147,'2024-01-18','Stazione'),(31,'DIESEL',19000,1.37372,'2024-01-18','Stazione'),(32,'S-DIESEL',1999,1.49667,'2024-01-18','Stazione'),(33,'BENZINA',6999,1.43109,'2024-01-23','Stazione'),(34,'DIESEL',19000,1.39011,'2024-01-23','Stazione'),(35,'BENZINA',6001,1.44749,'2024-01-27','Stazione'),(36,'DIESEL',14999,1.4147,'2024-01-27','Stazione'),(37,'BENZINA',6000,1.46388,'2024-01-31','Stazione'),(38,'DIESEL',15000,1.4229,'2024-01-31','Stazione'),(39,'BENZINA',15944,1.4229,'2024-01-01','Stazione'),(40,'S-DIESEL',3183,1.50486,'2024-01-01','Stazione'),(41,'DIESEL',25337,1.38191,'2024-01-01','Stazione');
/*!40000 ALTER TABLE `acquisti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendite`
--

DROP TABLE IF EXISTS `vendite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendite` (
  `id_vendita` int NOT NULL AUTO_INCREMENT,
  `prodotto` varchar(100) NOT NULL,
  `quantità` double NOT NULL,
  `pu` double NOT NULL,
  `data` date NOT NULL,
  `stazione` varchar(50) NOT NULL,
  PRIMARY KEY (`id_vendita`)
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendite`
--

LOCK TABLES `vendite` WRITE;
/*!40000 ALTER TABLE `vendite` DISABLE KEYS */;
INSERT INTO `vendite` VALUES (282,'BENZINA',1013.6,1.769,'2024-01-01','Stazione'),(283,'DIESEL',2017.9,1.719,'2024-01-01','Stazione'),(284,'S-DIESEL',137.21,1.869,'2024-01-01','Stazione'),(285,'BENZINA',1346.38,1.769,'2024-01-02','Stazione'),(286,'BENZINA',164.41,1.969,'2024-01-02','Stazione'),(287,'DIESEL',4602.81,1.719,'2024-01-02','Stazione'),(288,'DIESEL',73.72,1.919,'2024-01-02','Stazione'),(289,'S-DIESEL',53.51,1.869,'2024-01-02','Stazione'),(290,'BENZINA',1366.27,1.769,'2024-01-03','Stazione'),(291,'BENZINA',202.17,1.969,'2024-01-03','Stazione'),(292,'DIESEL',3401.98,1.719,'2024-01-03','Stazione'),(293,'DIESEL',224.57,1.919,'2024-01-03','Stazione'),(294,'S-DIESEL',88.96,1.869,'2024-01-03','Stazione'),(295,'S-DIESEL',6.38,2.069,'2024-01-03','Stazione'),(296,'BENZINA',1480.27,1.759,'2024-01-04','Stazione'),(297,'BENZINA',50.88,1.769,'2024-01-04','Stazione'),(298,'BENZINA',180.36,1.959,'2024-01-04','Stazione'),(299,'DIESEL',4209.47,1.719,'2024-01-04','Stazione'),(300,'DIESEL',230.33,1.919,'2024-01-04','Stazione'),(301,'S-DIESEL',82.95,1.869,'2024-01-04','Stazione'),(302,'BENZINA',1455.15,1.759,'2024-01-05','Stazione'),(303,'BENZINA',216.37,1.959,'2024-01-05','Stazione'),(304,'DIESEL',4105.7399999,1.709,'2024-01-05','Stazione'),(305,'DIESEL',172.39,1.719,'2024-01-05','Stazione'),(306,'DIESEL',175.52,1.909,'2024-01-05','Stazione'),(307,'S-DIESEL',177.77,1.859,'2024-01-05','Stazione'),(308,'S-DIESEL',34.24,1.869,'2024-01-05','Stazione'),(309,'S-DIESEL',9.71,2.059,'2024-01-05','Stazione'),(310,'BENZINA',1261.62,1.759,'2024-01-06','Stazione'),(311,'DIESEL',3374.7999999,1.709,'2024-01-06','Stazione'),(312,'S-DIESEL',53.8,1.859,'2024-01-06','Stazione'),(313,'BENZINA',1540.18,1.759,'2024-01-07','Stazione'),(314,'DIESEL',2890.17,1.709,'2024-01-07','Stazione'),(315,'S-DIESEL',43.04,1.859,'2024-01-07','Stazione'),(316,'BENZINA',1475.84,1.759,'2024-01-08','Stazione'),(317,'BENZINA',246.38,1.959,'2024-01-08','Stazione'),(318,'DIESEL',3954.7499999,1.709,'2024-01-08','Stazione'),(319,'DIESEL',128.4,1.909,'2024-01-08','Stazione'),(320,'S-DIESEL',32.28,1.859,'2024-01-08','Stazione'),(321,'S-DIESEL',42.26,2.059,'2024-01-08','Stazione'),(322,'BENZINA',1204.32,1.759,'2024-01-09','Stazione'),(323,'BENZINA',206.41,1.959,'2024-01-09','Stazione'),(324,'DIESEL',3867.9299999,1.709,'2024-01-09','Stazione'),(325,'DIESEL',283.47,1.909,'2024-01-09','Stazione'),(326,'S-DIESEL',99.33,1.859,'2024-01-09','Stazione'),(327,'S-DIESEL',9.71,2.059,'2024-01-09','Stazione'),(328,'BENZINA',1267.73,1.759,'2024-01-10','Stazione'),(329,'BENZINA',271.52,1.959,'2024-01-10','Stazione'),(330,'DIESEL',4176.7699999,1.709,'2024-01-10','Stazione'),(331,'DIESEL',178.16,1.909,'2024-01-10','Stazione'),(332,'S-DIESEL',109.37,1.859,'2024-01-10','Stazione'),(333,'BENZINA',1578.52,1.759,'2024-01-11','Stazione'),(334,'BENZINA',328.56,1.959,'2024-01-11','Stazione'),(335,'DIESEL',3830.5899999,1.709,'2024-01-11','Stazione'),(336,'DIESEL',166.62,1.909,'2024-01-11','Stazione'),(337,'S-DIESEL',115.68,1.859,'2024-01-11','Stazione'),(338,'BENZINA',1422.88,1.749,'2024-01-12','Stazione'),(339,'BENZINA',39.8,1.759,'2024-01-12','Stazione'),(340,'BENZINA',207.84,1.949,'2024-01-12','Stazione'),(341,'DIESEL',4037.02,1.699,'2024-01-12','Stazione'),(342,'DIESEL',130.12,1.709,'2024-01-12','Stazione'),(343,'DIESEL',311.1,1.899,'2024-01-12','Stazione'),(344,'S-DIESEL',86.53,1.849,'2024-01-12','Stazione'),(345,'BENZINA',1894.65,1.739,'2024-01-13','Stazione'),(346,'BENZINA',17.16,1.749,'2024-01-13','Stazione'),(347,'BENZINA',139.27,1.939,'2024-01-13','Stazione'),(348,'DIESEL',4396.45,1.689,'2024-01-13','Stazione'),(349,'DIESEL',117.82,1.699,'2024-01-13','Stazione'),(350,'DIESEL',199.81,1.889,'2024-01-13','Stazione'),(351,'S-DIESEL',91.92,1.839,'2024-01-13','Stazione'),(352,'BENZINA',1530.83,1.739,'2024-01-14','Stazione'),(353,'DIESEL',3443.22,1.689,'2024-01-14','Stazione'),(354,'S-DIESEL',89.25,1.839,'2024-01-14','Stazione'),(355,'BENZINA',1689.44,1.739,'2024-01-15','Stazione'),(356,'BENZINA',185.71,1.939,'2024-01-15','Stazione'),(357,'DIESEL',4108.76,1.689,'2024-01-15','Stazione'),(358,'DIESEL',185.83,1.889,'2024-01-15','Stazione'),(359,'S-DIESEL',152.08,1.839,'2024-01-15','Stazione'),(360,'S-DIESEL',40.95,2.039,'2024-01-15','Stazione'),(361,'BENZINA',1499.14,1.739,'2024-01-16','Stazione'),(362,'BENZINA',191.98,1.939,'2024-01-16','Stazione'),(363,'DIESEL',4890.21,1.689,'2024-01-16','Stazione'),(364,'DIESEL',151.92,1.889,'2024-01-16','Stazione'),(365,'S-DIESEL',29.04,1.839,'2024-01-16','Stazione'),(366,'S-DIESEL',7.36,2.039,'2024-01-16','Stazione'),(367,'BENZINA',53.21,1.739,'2024-01-17','Stazione'),(368,'BENZINA',1444.4,1.759,'2024-01-17','Stazione'),(369,'BENZINA',247.61,1.959,'2024-01-17','Stazione'),(370,'DIESEL',116.01,1.689,'2024-01-17','Stazione'),(371,'DIESEL',3690.1399999,1.709,'2024-01-17','Stazione'),(372,'DIESEL',283.88,1.909,'2024-01-17','Stazione'),(373,'S-DIESEL',40.35,1.859,'2024-01-17','Stazione'),(374,'BENZINA',1636.85,1.759,'2024-01-18','Stazione'),(375,'BENZINA',210.75,1.959,'2024-01-18','Stazione'),(376,'DIESEL',4217.0999999,1.709,'2024-01-18','Stazione'),(377,'DIESEL',157.2,1.909,'2024-01-18','Stazione'),(378,'S-DIESEL',112.37,1.859,'2024-01-18','Stazione'),(379,'BENZINA',25.58,1.759,'2024-01-19','Stazione'),(380,'BENZINA',1432.33,1.779,'2024-01-19','Stazione'),(381,'BENZINA',211.89,1.979,'2024-01-19','Stazione'),(382,'DIESEL',193.11,1.709,'2024-01-19','Stazione'),(383,'DIESEL',3890.95,1.729,'2024-01-19','Stazione'),(384,'DIESEL',259.68,1.929,'2024-01-19','Stazione'),(385,'S-DIESEL',5.38,1.859,'2024-01-19','Stazione'),(386,'S-DIESEL',50.54,1.879,'2024-01-19','Stazione'),(387,'BENZINA',1481.02,1.779,'2024-01-20','Stazione'),(388,'BENZINA',195.22,1.979,'2024-01-20','Stazione'),(389,'DIESEL',3653.05,1.729,'2024-01-20','Stazione'),(390,'DIESEL',146.65,1.929,'2024-01-20','Stazione'),(391,'S-DIESEL',74.95,1.879,'2024-01-20','Stazione'),(392,'S-DIESEL',38,2.079,'2024-01-20','Stazione'),(393,'BENZINA',1501.2,1.779,'2024-01-21','Stazione'),(394,'DIESEL',3084.67,1.729,'2024-01-21','Stazione'),(395,'S-DIESEL',72.02,1.879,'2024-01-21','Stazione'),(396,'BENZINA',1484.65,1.779,'2024-01-22','Stazione'),(397,'BENZINA',194.55,1.979,'2024-01-22','Stazione'),(398,'DIESEL',4478.17,1.729,'2024-01-22','Stazione'),(399,'DIESEL',307.36,1.929,'2024-01-22','Stazione'),(400,'S-DIESEL',101.12,1.879,'2024-01-22','Stazione'),(401,'BENZINA',1517.32,1.779,'2024-01-23','Stazione'),(402,'BENZINA',211.71,1.979,'2024-01-23','Stazione'),(403,'DIESEL',4149.86,1.729,'2024-01-23','Stazione'),(404,'DIESEL',274.19,1.929,'2024-01-23','Stazione'),(405,'S-DIESEL',39.9,1.879,'2024-01-23','Stazione'),(406,'BENZINA',1553.3,1.779,'2024-01-24','Stazione'),(407,'BENZINA',160.47,1.979,'2024-01-24','Stazione'),(408,'DIESEL',4118.3,1.729,'2024-01-24','Stazione'),(409,'DIESEL',244.87,1.929,'2024-01-24','Stazione'),(410,'S-DIESEL',97.69,1.879,'2024-01-24','Stazione'),(411,'S-DIESEL',7.22,2.079,'2024-01-24','Stazione'),(412,'BENZINA',34.47,1.779,'2024-01-25','Stazione'),(413,'BENZINA',1442.02,1.789,'2024-01-25','Stazione'),(414,'BENZINA',194.99,1.989,'2024-01-25','Stazione'),(415,'DIESEL',144.62,1.729,'2024-01-25','Stazione'),(416,'DIESEL',3832.93,1.739,'2024-01-25','Stazione'),(417,'DIESEL',281.59,1.939,'2024-01-25','Stazione'),(418,'S-DIESEL',153.37,1.889,'2024-01-25','Stazione'),(419,'S-DIESEL',13.12,2.089,'2024-01-25','Stazione'),(420,'BENZINA',16.76,1.789,'2024-01-26','Stazione'),(421,'BENZINA',1700.3399999,1.809,'2024-01-26','Stazione'),(422,'BENZINA',145,2.009,'2024-01-26','Stazione'),(423,'DIESEL',105.85,1.739,'2024-01-26','Stazione'),(424,'DIESEL',3975.46,1.759,'2024-01-26','Stazione'),(425,'DIESEL',178.1,1.959,'2024-01-26','Stazione'),(426,'S-DIESEL',5.29,1.889,'2024-01-26','Stazione'),(427,'S-DIESEL',41.92,1.909,'2024-01-26','Stazione'),(428,'BENZINA',1394.17,1.799,'2024-01-27','Stazione'),(429,'BENZINA',30.41,1.809,'2024-01-27','Stazione'),(430,'BENZINA',199.51,1.999,'2024-01-27','Stazione'),(431,'DIESEL',3918.96,1.759,'2024-01-27','Stazione'),(432,'DIESEL',151.38,1.959,'2024-01-27','Stazione'),(433,'S-DIESEL',128.39,1.909,'2024-01-27','Stazione'),(434,'BENZINA',1548.4499999,1.799,'2024-01-28','Stazione'),(435,'DIESEL',3302.16,1.759,'2024-01-28','Stazione'),(436,'S-DIESEL',98.24,1.909,'2024-01-28','Stazione'),(437,'BENZINA',1678.5099999,1.799,'2024-01-29','Stazione'),(438,'BENZINA',183.1,1.999,'2024-01-29','Stazione'),(439,'DIESEL',4031.11,1.759,'2024-01-29','Stazione'),(440,'DIESEL',211.78,1.959,'2024-01-29','Stazione'),(441,'S-DIESEL',34.06,1.909,'2024-01-29','Stazione'),(442,'BENZINA',30.58,1.799,'2024-01-30','Stazione'),(443,'BENZINA',1321.74,1.809,'2024-01-30','Stazione'),(444,'BENZINA',265.87,2.009,'2024-01-30','Stazione'),(445,'DIESEL',99.59,1.759,'2024-01-30','Stazione'),(446,'DIESEL',4051.38,1.769,'2024-01-30','Stazione'),(447,'DIESEL',222.19,1.969,'2024-01-30','Stazione'),(448,'S-DIESEL',116.12,1.919,'2024-01-30','Stazione'),(449,'S-DIESEL',43.7,2.119,'2024-01-30','Stazione'),(450,'BENZINA',35.08,1.809,'2024-01-31','Stazione'),(451,'BENZINA',1632.09,1.819,'2024-01-31','Stazione'),(452,'BENZINA',132.63,2.019,'2024-01-31','Stazione'),(453,'DIESEL',4116.27,1.769,'2024-01-31','Stazione'),(454,'DIESEL',228.59,1.969,'2024-01-31','Stazione'),(455,'S-DIESEL',10.58,1.919,'2024-01-31','Stazione'),(457,'Supreme',4,4,'2024-02-14','Stazione');
/*!40000 ALTER TABLE `vendite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendite_seq`
--

DROP TABLE IF EXISTS `vendite_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendite_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendite_seq`
--

LOCK TABLES `vendite_seq` WRITE;
/*!40000 ALTER TABLE `vendite_seq` DISABLE KEYS */;
INSERT INTO `vendite_seq` VALUES (101);
/*!40000 ALTER TABLE `vendite_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-08 16:55:10