CREATE DATABASE  IF NOT EXISTS `biblioteca_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca_db`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: biblioteca_db
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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `nacionalidad` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Dulac, George','Francesa'),(2,'Bertomeu,Andrés','Española'),(3,'Uosiken, Fred','Finlandesa'),(4,'Müller, Klaus','Italiana'),(5,'Llorens, Antonias','Alemana'),(6,'Leverling, Janet','Estadounidense'),(7,'Kröpotkin,Albert','Alemana'),(8,'Bazilian, Eric','Estadounidense'),(9,'Davolio, Nancy','Australiana'),(10,'Becket, Samuel','Francesa'),(11,'Dion, Paul','Britanica'),(12,'Richter, Helmut','Alemana'),(13,'Chabrier, Louis','Francesa'),(14,'Sanabria, Carmelo','Italiana'),(15,'Plasencia,Juan Luis','Española'),(16,'Santos, Miguel','Colombiana'),(17,'Montenegro, Miguel','Chilena'),(18,'J.K. Rowling.','Britanica');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `carrera` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Juan','Perez','Calle 25#4-23','Informática',24),(2,'Filippo','Galli','Calle 45#4-89','Ciencias politicas',26),(3,'Felipe','Rodriguez','Calle 38 #5-78','Ingeniería ambiental',24),(4,'Tannia','Hernandez','Calle 38 #2-94','Ingeniería electrónica',22),(5,'Lucía','Rojas','Calle 78 #4-34','Informática',18),(6,'Maria','Gonzalez','Calle 23 # 4-56','Administración de empresas',21);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `area` varchar(45) NOT NULL,
  `editorial` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'El tránsito terreno','Filosofía','Larrosa Mas, S.L.'),(2,'Sistemas operativos','Base de Datos','GGG&G'),(3,'Poemas intrínsecos','Poesía','Deloria Editores'),(4,'El Universo: Guía de viaje','Historia','TechniBooks'),(5,'Las balas del bien','Novela','GGG&G'),(6,'La mente y el sentir','Filosofía','Salamandra'),(7,'Ensayos póstumos','Base de Datos','Deloria Editores'),(8,'La dualidad aparente','Internet','Larrosa Mas, S.L.'),(9,'Arquitectura y arte','Base de Datos','Grisham Publishing.'),(10,'Historia de Occidente','Historia','Salamandra'),(11,'Sentimiento popular','Poesía','Larrosa Mas, S.L.'),(12,'Amigos o enemigos','Novela','GGG&G'),(13,'La burguesía del XIX','Historia','Deloria Editores'),(14,'Procesadores cuánticos','Internet','Grisham Publishing'),(15,'Canto de esperanza','Poesía','McCoy Hill'),(16,'Harry Potter y la piedra filosofal','Fantasía','Salamandra'),(17,'Harry Potter y el caliz de fuego','Fantasía','McCoy Hill');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro_autor`
--

DROP TABLE IF EXISTS `libro_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro_autor` (
  `id_autor` int NOT NULL,
  `id_libro` int NOT NULL,
  KEY `Libro_foreign_idx` (`id_libro`),
  KEY `Autor_foreign_idx` (`id_autor`),
  CONSTRAINT `Autor_foreign` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id`),
  CONSTRAINT `Libro_autor_foreign` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro_autor`
--

LOCK TABLES `libro_autor` WRITE;
/*!40000 ALTER TABLE `libro_autor` DISABLE KEYS */;
INSERT INTO `libro_autor` VALUES (1,10),(1,13),(2,7),(15,1),(8,2),(5,3),(12,4),(6,5),(15,6),(2,7),(14,8),(12,9),(5,11),(14,12),(8,14),(9,15),(3,10),(4,13),(6,7),(8,1),(7,2),(7,3),(11,4),(12,5),(13,6),(3,7),(13,8),(14,9),(15,11),(17,12),(16,14),(16,15),(18,16),(18,17);
/*!40000 ALTER TABLE `libro_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `id_lector` int NOT NULL,
  `id_libro` int NOT NULL,
  `fecha_prestamo` datetime NOT NULL,
  `fecha_devolucion` datetime NOT NULL,
  `devuelto` tinyblob NOT NULL,
  PRIMARY KEY (`id_lector`,`id_libro`),
  KEY `libro_foreign_idx` (`id_libro`),
  KEY `estudiante_foreign_idx` (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 16:15:06
