-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: departamento_empleado
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
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `depto_nro` varchar(7) NOT NULL,
  `nombre_depto` varchar(45) NOT NULL,
  `localidad` varchar(45) NOT NULL,
  PRIMARY KEY (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES ('D-000-1','Software','Los Tigres'),('D-000-2','Sistemas','Guadalupe'),('D-000-3','Contabilidad','La Roca'),('D-000-4','Ventas','Plata');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `cod_emp` varchar(6) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `puesto` varchar(45) NOT NULL,
  `fecha_alta` datetime NOT NULL,
  `salario` decimal(18,2) NOT NULL,
  `comision` decimal(18,2) NOT NULL,
  `depto_nro` varchar(7) NOT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `depto_nro_idx` (`depto_nro`),
  CONSTRAINT `depto_nro` FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('E-0001','César','Piñero','Vendedor','2018-05-12 00:00:00',80000.00,15000.00,'D-000-4'),('E-0002','Yosep','Kowaleski','Analista','2015-07-17 00:00:00',140000.00,0.00,'D-000-2'),('E-0003','Mariela','Barrios','Directo','2014-06-05 00:00:00',185000.00,0.00,'D-000-3'),('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03 00:00:00',85000.00,10000.00,'D-000-4'),('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03 00:00:00',83000.00,10000.00,'D-000-4'),('E-0006','Mito','Barchuk','Presidente','2014-06-05 00:00:00',80000.00,0.00,'D-000-3'),('E-0007','Emilio','Galarza','Desarrollador','2014-08-02 00:00:00',60000.00,0.00,'D-000-1');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 12:41:18
