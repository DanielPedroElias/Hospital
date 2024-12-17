CREATE DATABASE  IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hospital`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.23.10.1

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
-- Table structure for table `Consulta`
--

DROP TABLE IF EXISTS `Consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Consulta` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `paciente_cpf` varchar(255) DEFAULT NULL,
  `medico_nome` varchar(255) DEFAULT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `paciente_cpf` (`paciente_cpf`),
  KEY `medico_nome` (`medico_nome`),
  CONSTRAINT `Consulta_ibfk_1` FOREIGN KEY (`paciente_cpf`) REFERENCES `Paciente` (`CPF`),
  CONSTRAINT `Consulta_ibfk_2` FOREIGN KEY (`medico_nome`) REFERENCES `Medico` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Consulta`
--

LOCK TABLES `Consulta` WRITE;
/*!40000 ALTER TABLE `Consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Endereco`
--

DROP TABLE IF EXISTS `Endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Endereco` (
  `id` int NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Endereco`
--

LOCK TABLES `Endereco` WRITE;
/*!40000 ALTER TABLE `Endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `Endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Especialidade`
--

DROP TABLE IF EXISTS `Especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Especialidade` (
  `especialidade` varchar(255) NOT NULL,
  PRIMARY KEY (`especialidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Especialidade`
--

LOCK TABLES `Especialidade` WRITE;
/*!40000 ALTER TABLE `Especialidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `Especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Faringoplastia`
--

DROP TABLE IF EXISTS `Faringoplastia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Faringoplastia` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Faringoplastia`
--

LOCK TABLES `Faringoplastia` WRITE;
/*!40000 ALTER TABLE `Faringoplastia` DISABLE KEYS */;
/*!40000 ALTER TABLE `Faringoplastia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ITransmissaoDadoMinisterio`
--

DROP TABLE IF EXISTS `ITransmissaoDadoMinisterio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ITransmissaoDadoMinisterio` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITransmissaoDadoMinisterio`
--

LOCK TABLES `ITransmissaoDadoMinisterio` WRITE;
/*!40000 ALTER TABLE `ITransmissaoDadoMinisterio` DISABLE KEYS */;
/*!40000 ALTER TABLE `ITransmissaoDadoMinisterio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medico`
--

DROP TABLE IF EXISTS `Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Medico` (
  `nome` varchar(255) DEFAULT NULL,
  `CRM` int NOT NULL,
  `valorHora` double DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `endereco_id` int DEFAULT NULL,
  `especialidade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CRM`),
  KEY `nome` (`nome`),
  CONSTRAINT `Medico_ibfk_1` FOREIGN KEY (`nome`) REFERENCES `Pessoa` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medico`
--

LOCK TABLES `Medico` WRITE;
/*!40000 ALTER TABLE `Medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medico_Especialidade`
--

DROP TABLE IF EXISTS `Medico_Especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Medico_Especialidade` (
  `medico_crm` int NOT NULL,
  `especialidade` varchar(255) NOT NULL,
  PRIMARY KEY (`medico_crm`,`especialidade`),
  KEY `especialidade` (`especialidade`),
  CONSTRAINT `Medico_Especialidade_ibfk_1` FOREIGN KEY (`medico_crm`) REFERENCES `Medico` (`CRM`),
  CONSTRAINT `Medico_Especialidade_ibfk_2` FOREIGN KEY (`especialidade`) REFERENCES `Especialidade` (`especialidade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medico_Especialidade`
--

LOCK TABLES `Medico_Especialidade` WRITE;
/*!40000 ALTER TABLE `Medico_Especialidade` DISABLE KEYS */;
/*!40000 ALTER TABLE `Medico_Especialidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Neurocirurgia`
--

DROP TABLE IF EXISTS `Neurocirurgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Neurocirurgia` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Neurocirurgia`
--

LOCK TABLES `Neurocirurgia` WRITE;
/*!40000 ALTER TABLE `Neurocirurgia` DISABLE KEYS */;
/*!40000 ALTER TABLE `Neurocirurgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paciente`
--

DROP TABLE IF EXISTS `Paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Paciente` (
  `CPF` varchar(14) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `endereco_id` int DEFAULT NULL,
  `plano_nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CPF`),
  KEY `plano_nome` (`plano_nome`),
  KEY `nome` (`nome`),
  CONSTRAINT `Paciente_ibfk_1` FOREIGN KEY (`plano_nome`) REFERENCES `Plano` (`nome`),
  CONSTRAINT `Paciente_ibfk_2` FOREIGN KEY (`nome`) REFERENCES `Pessoa` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paciente`
--

LOCK TABLES `Paciente` WRITE;
/*!40000 ALTER TABLE `Paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `Paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pessoa`
--

DROP TABLE IF EXISTS `Pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pessoa` (
  `nome` varchar(255) NOT NULL,
  `dataNascimento` date DEFAULT NULL,
  `endereco_id` int DEFAULT NULL,
  PRIMARY KEY (`nome`),
  KEY `endereco_id` (`endereco_id`),
  CONSTRAINT `Pessoa_ibfk_1` FOREIGN KEY (`endereco_id`) REFERENCES `Endereco` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pessoa`
--

LOCK TABLES `Pessoa` WRITE;
/*!40000 ALTER TABLE `Pessoa` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Plano`
--

DROP TABLE IF EXISTS `Plano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Plano` (
  `nome` varchar(255) NOT NULL,
  `mensalidade` double DEFAULT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Plano`
--

LOCK TABLES `Plano` WRITE;
/*!40000 ALTER TABLE `Plano` DISABLE KEYS */;
/*!40000 ALTER TABLE `Plano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Procedimento`
--

DROP TABLE IF EXISTS `Procedimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Procedimento` (
  `id` int NOT NULL,
  `paciente_cpf` varchar(14) DEFAULT NULL,
  `medico_nome` varchar(255) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `sala` varchar(255) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `tempoDuracao` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sala` (`sala`),
  KEY `paciente_cpf` (`paciente_cpf`),
  KEY `medico_nome` (`medico_nome`),
  CONSTRAINT `Procedimento_ibfk_1` FOREIGN KEY (`sala`) REFERENCES `Sala` (`nome`),
  CONSTRAINT `Procedimento_ibfk_2` FOREIGN KEY (`paciente_cpf`) REFERENCES `Paciente` (`CPF`),
  CONSTRAINT `Procedimento_ibfk_3` FOREIGN KEY (`medico_nome`) REFERENCES `Medico` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Procedimento`
--

LOCK TABLES `Procedimento` WRITE;
/*!40000 ALTER TABLE `Procedimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Procedimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sala`
--

DROP TABLE IF EXISTS `Sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Sala` (
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sala`
--

LOCK TABLES `Sala` WRITE;
/*!40000 ALTER TABLE `Sala` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sala` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-15 12:21:53
