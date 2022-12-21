CREATE DATABASE  IF NOT EXISTS `empresa_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `empresa_db`;
-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: empresa_db
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
-- Table structure for table `clientes_pagos`
--

DROP TABLE IF EXISTS `clientes_pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_pagos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `pago` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `indice_fecha` (`fecha`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_pagos`
--

LOCK TABLES `clientes_pagos` WRITE;
/*!40000 ALTER TABLE `clientes_pagos` DISABLE KEYS */;
INSERT INTO `clientes_pagos` VALUES (1,'34.111.222','01/01/2022',500),(2,'35.333.444','02/02/2022',1000),(3,'34.111.222','02/02/2022',540),(4,'35.333.444','07/02/2022',1000),(5,'35.333.444','07/02/2022',400),(6,'35.333.444','07/02/2022',100),(7,'35.333.444','07/02/2022',200);
/*!40000 ALTER TABLE `clientes_pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `iddepartamento` int NOT NULL,
  `depto_nro` varchar(45) DEFAULT NULL,
  `nombre_depto` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddepartamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'D-000-1','Software','Los Tigres'),(2,'D-000-2','Sistemas','Guadalupe'),(3,'D-000-3','Contabilidad','La Roca '),(4,'D-000-4','Ventas','La Plata');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEMPLEADO` int NOT NULL,
  `cod_emp` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `puesto` varchar(45) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `salario` int DEFAULT NULL,
  `comision` int DEFAULT NULL,
  `depto_nro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'E-0001','César','Piñero','Vendedor',NULL,80000,15000,'D-000-4'),(2,'E-0002','Yosep','Kowaleski','Analista',NULL,140000,0,'D-000-2'),(3,'E-0003','Mariela','Barrios','Director',NULL,185000,0,'D-000-3'),(4,'E-0004','Jonathan','Aguilera','Vendedor',NULL,85000,10000,'D-000-4'),(5,'E-0005','Daniel','Brezezicki','Vendedor',NULL,83000,10000,'D-000-4'),(6,'E-0006','Mito','Barchuk','Presidente',NULL,190000,0,'D-000-3'),(7,'E-0007','Emilio','Galarza','Desarrollador',NULL,60000,0,'D-000-1');
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

-- Dump completed on 2022-12-08 17:07:23
