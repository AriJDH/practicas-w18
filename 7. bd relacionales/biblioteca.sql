CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: biblioteca
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
-- Table structure for table `Autor`
--

DROP TABLE IF EXISTS `Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Autor` (
  `idAutor` int NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Nacionalidad` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autor`
--

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;
INSERT INTO `Autor` VALUES (1,'Andrea ponce','Francesa'),(2,'Jose Sabatier','Italiana'),(3,'David giacomo','Italiana'),(4,'J.K. Rowling','Inglesa'),(5,'Linus torvalds','Finlandes');
/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudiante`
--

DROP TABLE IF EXISTS `Estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudiante` (
  `idLector` int NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellido` varchar(45) DEFAULT NULL,
  `Direccion` varchar(45) DEFAULT NULL,
  `Carrera` varchar(45) DEFAULT NULL,
  `Edad` int DEFAULT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudiante`
--

LOCK TABLES `Estudiante` WRITE;
/*!40000 ALTER TABLE `Estudiante` DISABLE KEYS */;
INSERT INTO `Estudiante` VALUES (1,'Felipe','Gomez','CLL 3 #4567','Informatica',24),(2,'Santiago','Velez','AV 4 25A30','Informatica',34),(3,'Daniel','Gaviria','CR 23 #2019','Astronomia',20),(4,'Filippo','Galli','Dg 52 20AA12','Sociales',15),(5,'Heilen','Benavides','Cll 13 #1220','Fisica',19);
/*!40000 ALTER TABLE `Estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro`
--

DROP TABLE IF EXISTS `Libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro` (
  `idLibro` int NOT NULL,
  `Titulo` varchar(45) NOT NULL,
  `Editorial` varchar(45) NOT NULL,
  `Area` varchar(45) NOT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro`
--

LOCK TABLES `Libro` WRITE;
/*!40000 ALTER TABLE `Libro` DISABLE KEYS */;
INSERT INTO `Libro` VALUES (1,'Busqueda avanzada en google','Babel','Internet'),(2,'Navegacion basica en la web','ww3','Internet'),(3,'Guerras civiles en america','Salamandra','Historia'),(4,'El Universo:Guia de viaje','Nasa','Astronomia'),(5,'Consultas SQL Avanzadas','DDBB','Base de datos'),(6,'Harry Potter','Salamandra','Fantasia');
/*!40000 ALTER TABLE `Libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro_Autor`
--

DROP TABLE IF EXISTS `Libro_Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro_Autor` (
  `idAutor` int NOT NULL,
  `idLibro` int NOT NULL,
  PRIMARY KEY (`idAutor`,`idLibro`),
  KEY `Libro_idx` (`idLibro`),
  CONSTRAINT `Autor` FOREIGN KEY (`idAutor`) REFERENCES `Autor` (`idAutor`),
  CONSTRAINT `Libro` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro_Autor`
--

LOCK TABLES `Libro_Autor` WRITE;
/*!40000 ALTER TABLE `Libro_Autor` DISABLE KEYS */;
INSERT INTO `Libro_Autor` VALUES (1,1),(1,2),(3,2),(2,4),(5,5),(4,6);
/*!40000 ALTER TABLE `Libro_Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prestamo`
--

DROP TABLE IF EXISTS `Prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prestamo` (
  `idLector` int NOT NULL,
  `idLibro` int NOT NULL,
  `FechaPrestamo` datetime NOT NULL,
  `FechaDevolucion` datetime DEFAULT NULL,
  `Devuelto` tinyint NOT NULL,
  PRIMARY KEY (`idLector`,`idLibro`),
  KEY `Libro_idx` (`idLibro`),
  CONSTRAINT `Lector` FOREIGN KEY (`idLector`) REFERENCES `Estudiante` (`idLector`),
  CONSTRAINT `Libro_prestamo` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamo`
--

LOCK TABLES `Prestamo` WRITE;
/*!40000 ALTER TABLE `Prestamo` DISABLE KEYS */;
INSERT INTO `Prestamo` VALUES (1,1,'2021-03-20 00:00:00','2021-04-17 00:00:00',1),(2,2,'2021-05-19 00:00:00','2021-07-16 00:00:00',0),(2,5,'2021-07-19 00:00:00','2021-09-04 00:00:00',0),(3,4,'2021-05-19 00:00:00','2021-07-16 00:00:00',0),(4,3,'2021-01-30 00:00:00','2021-02-15 00:00:00',1),(4,6,'2021-08-16 00:00:00','2021-09-18 00:00:00',0),(5,4,'2021-04-15 00:00:00','2021-05-05 00:00:00',1);
/*!40000 ALTER TABLE `Prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-07 15:27:59
