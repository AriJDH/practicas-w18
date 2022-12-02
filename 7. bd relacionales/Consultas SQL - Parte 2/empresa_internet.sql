-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `cliente_id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  PRIMARY KEY (`cliente_id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'1020','Cristian','Ronaldo','2020-04-04 00:00:00','Antioquia','Medellín'),(2,'1021','Lionel','Messi','2001-06-12 00:00:00','Atlantico','Santa Marta'),(3,'1022','Andres','Iniesta','2000-06-07 00:00:00','Atlantico','Cartagena'),(4,'1023','Sergio','Ramos','1999-06-19 00:00:00','Antioquia','Itagui'),(5,'1024','Segio','Aguero','2003-08-16 00:00:00','Antioquia','Barbosa'),(6,'1025','James','Rodriguez','2000-06-12 00:00:00','Cundinamarca','Bogotá'),(7,'1026','Andres','Ricaute','2000-01-19 00:00:00','Antioquia','La estrella'),(8,'1027','Estella','Rojas','2001-02-18 00:00:00','Cundinamarca','Bayacá'),(9,'1028','Angela','Gritona','2002-06-21 00:00:00','Cundinamarca','Bayacá'),(10,'1029','Ruth','Giraldo','2001-06-15 00:00:00','Cundinamarca','Bayacá');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes_planes`
--

DROP TABLE IF EXISTS `clientes_planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_planes` (
  `idclientes_planes` int NOT NULL AUTO_INCREMENT,
  `plan_id` int NOT NULL,
  `cliente_id` int NOT NULL,
  PRIMARY KEY (`idclientes_planes`),
  KEY `cliente_id_idx` (`cliente_id`),
  KEY `plan_id_idx` (`plan_id`),
  CONSTRAINT `cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`cliente_id`),
  CONSTRAINT `plan_id` FOREIGN KEY (`plan_id`) REFERENCES `planes` (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_planes`
--

LOCK TABLES `clientes_planes` WRITE;
/*!40000 ALTER TABLE `clientes_planes` DISABLE KEYS */;
INSERT INTO `clientes_planes` VALUES (1,5,1),(2,5,2),(3,1,3),(4,3,4),(5,5,10),(6,1,6),(7,1,10),(8,1,5),(9,5,5),(10,4,5);
/*!40000 ALTER TABLE `clientes_planes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planes`
--

DROP TABLE IF EXISTS `planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planes` (
  `plan_id` int NOT NULL AUTO_INCREMENT,
  `megas` smallint NOT NULL,
  `precio` decimal(18,2) NOT NULL,
  `descuento` decimal(18,2) NOT NULL,
  PRIMARY KEY (`plan_id`),
  UNIQUE KEY `plan_id_UNIQUE` (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planes`
--

LOCK TABLES `planes` WRITE;
/*!40000 ALTER TABLE `planes` DISABLE KEYS */;
INSERT INTO `planes` VALUES (1,50,150000.00,0.00),(2,100,300000.00,0.00),(3,150,350000.00,0.00),(4,200,400000.00,0.00),(5,300,470000.00,0.70);
/*!40000 ALTER TABLE `planes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 11:54:27
