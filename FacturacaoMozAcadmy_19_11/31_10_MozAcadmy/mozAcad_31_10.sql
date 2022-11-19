-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: mozacademydb
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `estudante`
--

DROP TABLE IF EXISTS `estudante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante` (
  `idestudante` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `contacto` varchar(9) NOT NULL,
  `status` varchar(2) NOT NULL DEFAULT 'R',
  PRIMARY KEY (`idestudante`),
  UNIQUE KEY `idestudante_UNIQUE` (`idestudante`),
  UNIQUE KEY `contacto_UNIQUE` (`contacto`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante`
--

LOCK TABLES `estudante` WRITE;
/*!40000 ALTER TABLE `estudante` DISABLE KEYS */;
INSERT INTO `estudante` VALUES (1,'Clementina','849267589','R'),(2,'Elihud','849267999','NR'),(3,'Jose','847787067','R'),(5,'Matimbe','841187067','NR'),(9,'Shelcia','849568765','R'),(10,'Carla','849568760','R'),(11,'Jean','859568760','R'),(12,'Jenny','86537398','NR'),(13,'Candida','87597398','NR'),(14,'Leonardo','82517398','NR'),(15,'Edite','86537090','NR'),(16,'Ilva','84497398','NR'),(17,'Joao','82517338','NR');
/*!40000 ALTER TABLE `estudante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante_inscricao`
--

DROP TABLE IF EXISTS `estudante_inscricao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante_inscricao` (
  `idestudante` int NOT NULL AUTO_INCREMENT,
  `dt_inscricao` date NOT NULL,
  PRIMARY KEY (`idestudante`),
  UNIQUE KEY `idestudante_UNIQUE` (`idestudante`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante_inscricao`
--

LOCK TABLES `estudante_inscricao` WRITE;
/*!40000 ALTER TABLE `estudante_inscricao` DISABLE KEYS */;
INSERT INTO `estudante_inscricao` VALUES (1,'2022-03-17'),(2,'2012-10-15');
/*!40000 ALTER TABLE `estudante_inscricao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante_item`
--

DROP TABLE IF EXISTS `estudante_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante_item` (
  `idestudante` int NOT NULL,
  `iditem` int NOT NULL,
  `valorPago` int NOT NULL,
  PRIMARY KEY (`idestudante`,`iditem`),
  KEY `iditem_idx` (`iditem`),
  CONSTRAINT `idestudante` FOREIGN KEY (`idestudante`) REFERENCES `estudante` (`idestudante`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `iditem` FOREIGN KEY (`iditem`) REFERENCES `item` (`iditem`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante_item`
--

LOCK TABLES `estudante_item` WRITE;
/*!40000 ALTER TABLE `estudante_item` DISABLE KEYS */;
INSERT INTO `estudante_item` VALUES (1,3,600),(1,4,1000);
/*!40000 ALTER TABLE `estudante_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudante_turma`
--

DROP TABLE IF EXISTS `estudante_turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudante_turma` (
  `idestudante` int NOT NULL,
  `idturma` int NOT NULL,
  PRIMARY KEY (`idestudante`,`idturma`),
  KEY `idturma_FK` (`idturma`),
  CONSTRAINT `idestudante_FK` FOREIGN KEY (`idestudante`) REFERENCES `estudante` (`idestudante`) ON UPDATE CASCADE,
  CONSTRAINT `idturma_FK` FOREIGN KEY (`idturma`) REFERENCES `turma` (`idturma`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudante_turma`
--

LOCK TABLES `estudante_turma` WRITE;
/*!40000 ALTER TABLE `estudante_turma` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudante_turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `iditem` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `preco` int NOT NULL,
  `nivel` varchar(3) DEFAULT NULL,
  `tipo` varchar(12) NOT NULL,
  PRIMARY KEY (`iditem`),
  UNIQUE KEY `iditem_UNIQUE` (`iditem`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Excel',1000,NULL,'formacao'),(2,'PowerPoint',800,NULL,'formacao'),(3,'Portugues',600,'10','disciplina'),(4,'matematica',1000,'10','disciplina');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turma`
--

DROP TABLE IF EXISTS `turma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turma` (
  `idturma` int NOT NULL AUTO_INCREMENT,
  `hora` time NOT NULL,
  `quant_estudantes` int NOT NULL,
  PRIMARY KEY (`idturma`),
  UNIQUE KEY `idturma_UNIQUE` (`idturma`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turma`
--

LOCK TABLES `turma` WRITE;
/*!40000 ALTER TABLE `turma` DISABLE KEYS */;
INSERT INTO `turma` VALUES (1,'07:00:00',30),(2,'12:00:00',10),(3,'09:00:00',20);
/*!40000 ALTER TABLE `turma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'clementina','123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-30 19:11:11
