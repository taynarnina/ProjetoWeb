CREATE DATABASE  IF NOT EXISTS `biblioteca_ufab` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `biblioteca_ufab`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca_ufab
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `administradores`
--

DROP TABLE IF EXISTS `administradores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administradores` (
  `idadministrador` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) DEFAULT NULL,
  `rg` varchar(8) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `naturalidade` varchar(25) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `usuario` varchar(10) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idadministrador`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administradores`
--

LOCK TABLES `administradores` WRITE;
/*!40000 ALTER TABLE `administradores` DISABLE KEYS */;
INSERT INTO `administradores` VALUES (1,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(2,'09816785678','12345634','Tereza Telo','Pocinhos','Avenida do Campo','08399992222','tereza@gmail.com','tete','12345'),(3,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(5,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(6,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(7,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(8,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(9,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(10,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(11,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(12,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(13,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(14,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(15,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(16,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(17,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(18,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(19,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(20,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(21,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(22,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(23,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(24,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(25,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(26,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(27,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(28,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(29,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(30,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(31,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(32,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(33,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(34,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(35,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(36,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(37,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(38,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(39,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(40,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(41,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(42,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(43,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234'),(44,'09112345678','12345678','Silvio Telo','Pocinhos','Avenida do Campo','08399992222','silvio@gmail.com','oivlis','1234');
/*!40000 ALTER TABLE `administradores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alunos`
--

DROP TABLE IF EXISTS `alunos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alunos` (
  `idaluno` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(11) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `rg` varchar(8) DEFAULT NULL,
  `naturalidade` varchar(25) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `nome_da_mae` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `curso` int(11) DEFAULT NULL,
  `ano` year(4) DEFAULT NULL,
  `periodo_ingresso` enum('1','2') DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `inadimplente` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idaluno`),
  KEY `curso` (`curso`),
  CONSTRAINT `alunos_ibfk_1` FOREIGN KEY (`curso`) REFERENCES `cursos` (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alunos`
--

LOCK TABLES `alunos` WRITE;
/*!40000 ALTER TABLE `alunos` DISABLE KEYS */;
INSERT INTO `alunos` VALUES (1,'GCC-181001','12345678910','3567890','Campina Grande','Marcos Gabriel Silva','Maria José dos Santos','Rua Inventada','08399994444',2,2018,'1','1234','email@mail.com',0),(2,'GAD-141002','09112345678','12345678','Olivedos','João dos Santos','Joana dos Santos','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(3,'GAD141002','09112345678','12345678','Olivedos','João dos Santos','Joana dos Santos','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(4,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(5,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(6,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(7,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(8,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(9,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(10,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0),(11,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0),(12,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0),(13,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(14,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0),(15,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(16,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0),(17,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(18,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0),(19,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(20,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0),(21,'GAD-141004','09112345678','12345678','Pocinhos','Pedro da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'1','4321',NULL,0),(22,'GAD142002','09112345678','12345678','Pocinhos','João da Silva','Joana da Silva','Avenida do Campo','08399992222',1,2014,'2','4321',NULL,0);
/*!40000 ALTER TABLE `alunos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anais`
--

DROP TABLE IF EXISTS `anais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `anais` (
  `idanal` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(35) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `autores` varchar(35) DEFAULT NULL,
  `nome_congresso` varchar(35) DEFAULT NULL,
  `ano_publicacao` year(4) DEFAULT NULL,
  `local` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idanal`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anais`
--

LOCK TABLES `anais` WRITE;
/*!40000 ALTER TABLE `anais` DISABLE KEYS */;
INSERT INTO `anais` VALUES (1,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(2,'Seminario de Literatura','Artigo','JK Rowling','Hogwarts Congresso 2.0',2017,'Rio de Janeiro'),(3,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(5,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(6,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(7,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(8,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(9,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(10,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(11,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(12,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(13,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(14,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(15,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(16,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(17,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(18,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(19,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(20,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(21,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(22,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(23,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(24,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(25,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(26,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(27,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(28,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(29,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(30,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(31,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(32,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(33,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(34,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(35,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(36,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(37,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(38,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(39,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(40,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(41,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(42,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(43,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia'),(44,'Seminario Nacional de Literatura','Artigo','JK Rowling','Hogwarts Congresso',2015,'Brasilia');
/*!40000 ALTER TABLE `anais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cursos` (
  `idcurso` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) DEFAULT NULL,
  `codigo` varchar(2) DEFAULT NULL,
  `area` varchar(25) DEFAULT NULL,
  `tipo` enum('G','E','M','D') DEFAULT NULL,
  PRIMARY KEY (`idcurso`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Administração','AD','Ciências Humamas','G'),(2,'Ciência da Computação','CC','Ciências Exatas','G'),(3,'Direito','DI','Ciências Humamas','G'),(4,'Engenharia Elétrica','EE','Ciências Exatas','G'),(5,'Engenharia Espacial','ES','Ciências Exatas','G'),(6,'Engenharia Mecatrônica','EM','Ciências Exatas','G'),(7,'Matemática','MA','Ciências Exatas','G'),(8,'Medicina','ME','Ciências Biológicas','G'),(9,'Nutrição','NU','Ciências Biológicas','G'),(10,'Odontologia','OD','Ciências Biológicas','G'),(11,'Psicologia','PS','Ciências Biológicas','G'),(12,'Veterinária','VE','Ciências Biológicas','G'),(13,'Ciência da Computação','CC','Ciências Exatas','E'),(14,'Engenharia Elétrica','EE','Ciências Exatas','E'),(15,'Engenharia Espacial','ES','Ciências Exatas','E'),(16,'Engenharia Mecatrônica','EM','Ciências Exatas','E'),(17,'Psicologia','PS','Ciências Biológicas','E'),(18,'Ciência da Computação','CC','Ciências Exatas','M'),(19,'Engenharia Elétrica','EE','Ciências Exatas','M'),(20,'Engenharia Espacial','ES','Ciências Exatas','M'),(21,'Engenharia Mecatrônica','EM','Ciências Exatas','M'),(22,'Psicologia','PS','Ciências Biológicas','M'),(23,'Ciência da Computação','CC','Ciências Exatas','D'),(24,'Engenharia Elétrica','EE','Ciências Exatas','D'),(25,'Engenharia Espacial','ES','Ciências Exatas','D'),(26,'Engenharia Mecatrônica','EM','Ciências Exatas','D'),(27,'Psicologia','PS','Ciências Biológicas','D'),(28,'LetrasIngles','LI','Ciencias Humanas','G'),(29,'Letras-Espanhol','LE','Ciencias Humanas','G'),(31,'Musica','MU','Ciencias Humanas','G'),(32,'Letras','LI','Ciencias Humanas','G'),(33,'Letras','LI','Ciencias Humanas','G'),(34,'Letras','LI','Ciencias Humanas','G'),(35,'Musica','MU','Ciencias Humanas','G'),(36,'Musica','MU','Ciencias Humanas','G'),(37,'Musica','MU','Ciencias Humanas','G'),(38,'Letras','LI','Ciencias Humanas','G'),(39,'Letras','LI','Ciencias Humanas','G'),(40,'Musica','MU','Ciencias Humanas','G'),(41,'Letras','LI','Ciencias Humanas','G'),(42,'Musica','MU','Ciencias Humanas','G'),(43,'Letras','LI','Ciencias Humanas','G'),(44,'Musica','MU','Ciencias Humanas','G'),(45,'Letras','LI','Ciencias Humanas','G'),(46,'Musica','MU','Ciencias Humanas','G'),(47,'Letras','LI','Ciencias Humanas','G'),(48,'Musica','MU','Ciencias Humanas','G');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionarios` (
  `idfuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) DEFAULT NULL,
  `rg` varchar(8) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `naturalidade` varchar(25) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `usuario` varchar(10) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`idfuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (2,'1052345678','8765478','Maria Santos','Moca','Rua do Campo','08388880000','maria@mail.com','Mary','54321'),(3,'09215345678','14345578','Roberto Freire','Moca','Rua do Lobos','08399921222','roberto@mail.com','Robe','12345'),(5,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(6,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(7,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(8,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(9,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(10,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(11,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(12,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(13,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(14,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(15,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(16,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(17,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(18,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(19,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(20,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(21,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(22,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(23,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(24,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(25,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(26,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(27,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(28,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(29,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(30,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(31,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(32,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(33,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(34,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(35,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(36,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(37,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(38,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(39,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(40,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(41,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(42,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(43,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(44,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(45,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(46,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234'),(47,'09112345678','12345678','Silva Ribeiro','Pocinhos','Avenida do Campo','08399992222','silva@gmail.com','avlis','1234');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jornais`
--

DROP TABLE IF EXISTS `jornais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jornais` (
  `idjornal` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(35) DEFAULT NULL,
  `editora` varchar(25) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `edicao` varchar(25) DEFAULT NULL,
  `numero_paginas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idjornal`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jornais`
--

LOCK TABLES `jornais` WRITE;
/*!40000 ALTER TABLE `jornais` DISABLE KEYS */;
INSERT INTO `jornais` VALUES (1,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(2,'Jornal Estadual','Julho','2016-11-01','2º Edição',15),(3,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(5,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(6,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(7,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(8,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(9,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(10,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(11,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(12,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(13,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(14,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(15,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(16,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(17,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(18,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(19,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(20,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(21,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(22,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(23,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(24,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(25,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(26,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(27,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(28,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(29,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(30,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(31,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(32,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(33,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(34,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(35,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(36,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(37,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(38,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(39,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(40,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(41,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(42,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(43,'Jornal Nacional','Maio','2017-11-01','1º Edição',12),(44,'Jornal Nacional','Maio','2017-11-01','1º Edição',12);
/*!40000 ALTER TABLE `jornais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livros`
--

DROP TABLE IF EXISTS `livros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livros` (
  `idlivro` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` int(11) DEFAULT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `autores` varchar(35) DEFAULT NULL,
  `editora` varchar(25) DEFAULT NULL,
  `ano_publicacao` year(4) DEFAULT NULL,
  `edicao` varchar(25) DEFAULT NULL,
  `numero_paginas` int(11) DEFAULT NULL,
  `area` varchar(25) DEFAULT NULL,
  `tema` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idlivro`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livros`
--

LOCK TABLES `livros` WRITE;
/*!40000 ALTER TABLE `livros` DISABLE KEYS */;
INSERT INTO `livros` VALUES (1,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(2,345678913,'Engenharia de Software 3.0','Freire, João Paulo','Nova Era',2012,'2º Edição',255,'Computacao','Engenharia de Software'),(3,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(5,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(6,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(7,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(8,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(9,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(10,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(11,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(12,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(13,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(14,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(15,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(16,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(17,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(18,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(19,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(20,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(21,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(22,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(23,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(24,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(25,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(26,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(27,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(28,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(29,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(30,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(31,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(32,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(33,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(34,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(35,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(36,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(37,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(38,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(39,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(40,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(41,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(42,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(43,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software'),(44,345678912,'Engenharia de Software','Freire, João Paulo','Nova Era',2010,'2º Edição',255,'Computacao','Engenharia de Software');
/*!40000 ALTER TABLE `livros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `midias`
--

DROP TABLE IF EXISTS `midias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `midias` (
  `idmidia` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(35) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `data_gravacao` date DEFAULT NULL,
  PRIMARY KEY (`idmidia`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `midias`
--

LOCK TABLES `midias` WRITE;
/*!40000 ALTER TABLE `midias` DISABLE KEYS */;
INSERT INTO `midias` VALUES (1,'Java Free','DVD','2013-03-23'),(2,'Java 8','DVD','2016-06-29'),(3,'Java Free','DVD','2013-03-23'),(4,'Java Free','DVD','2013-03-23'),(5,'Java Free','DVD','2013-03-23'),(6,'Java Free','DVD','2013-03-23'),(7,'Java Free','DVD','2013-03-23'),(8,'Java Free','DVD','2013-03-23'),(9,'Java Free','DVD','2013-03-23'),(10,'Java Free','DVD','2013-03-23'),(11,'Java Free','DVD','2013-03-23'),(12,'Java Free','DVD','2013-03-23'),(13,'Java Free','DVD','2013-03-23'),(14,'Java Free','DVD','2013-03-23'),(15,'Java Free','DVD','2013-03-23'),(16,'Java Free','DVD','2013-03-23'),(17,'Java Free','DVD','2013-03-23'),(18,'Java Free','DVD','2013-03-23'),(19,'Java Free','DVD','2013-03-23'),(20,'Java Free','DVD','2013-03-23'),(21,'Java Free','DVD','2013-03-23'),(22,'Java Free','DVD','2013-03-23'),(23,'Java Free','DVD','2013-03-23'),(24,'Java Free','DVD','2013-03-23'),(25,'Java Free','DVD','2013-03-23'),(26,'Java Free','DVD','2013-03-23'),(27,'Java Free','DVD','2013-03-23'),(28,'Java Free','DVD','2013-03-23'),(29,'Java Free','DVD','2013-03-23'),(31,'Java Free','DVD','2013-03-23'),(32,'Java Free','DVD','2013-03-23'),(33,'Java Free','DVD','2013-03-23'),(34,'Java Free','DVD','2013-03-23'),(35,'Java Free','DVD','2013-03-23'),(36,'Java Free','DVD','2013-03-23'),(37,'Java Free','DVD','2013-03-23'),(38,'Java Free','DVD','2013-03-23'),(39,'Java Free','DVD','2013-03-23'),(40,'Java Free','DVD','2013-03-23'),(41,'Java Free','DVD','2013-03-23'),(42,'Java Free','DVD','2013-03-23'),(43,'Java Free','DVD','2013-03-23'),(44,'Java Free','DVD','2013-03-23');
/*!40000 ALTER TABLE `midias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revistas`
--

DROP TABLE IF EXISTS `revistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revistas` (
  `idrevista` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(35) DEFAULT NULL,
  `editora` varchar(25) DEFAULT NULL,
  `data_publicacao` date DEFAULT NULL,
  `edicao` varchar(25) DEFAULT NULL,
  `numero_paginas` int(11) DEFAULT NULL,
  PRIMARY KEY (`idrevista`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revistas`
--

LOCK TABLES `revistas` WRITE;
/*!40000 ALTER TABLE `revistas` DISABLE KEYS */;
INSERT INTO `revistas` VALUES (1,'TV Escola','Abril','2016-12-04','12º Edição',25),(2,'TV Nova Escola','Dezembro','2016-12-04','12º Edição',25),(3,'TV Escola','Abril','2016-12-04','12º Edição',25),(5,'TV Escola','Abril','2016-12-04','12º Edição',25),(6,'TV Escola','Abril','2016-12-04','12º Edição',25),(7,'TV Escola','Abril','2016-12-04','12º Edição',25),(8,'TV Escola','Abril','2016-12-04','12º Edição',25),(9,'TV Escola','Abril','2016-12-04','12º Edição',25),(10,'TV Escola','Abril','2016-12-04','12º Edição',25),(11,'TV Escola','Abril','2016-12-04','12º Edição',25),(12,'TV Escola','Abril','2016-12-04','12º Edição',25),(13,'TV Escola','Abril','2016-12-04','12º Edição',25),(14,'TV Escola','Abril','2016-12-04','12º Edição',25),(15,'TV Escola','Abril','2016-12-04','12º Edição',25),(16,'TV Escola','Abril','2016-12-04','12º Edição',25),(17,'TV Escola','Abril','2016-12-04','12º Edição',25),(18,'TV Escola','Abril','2016-12-04','12º Edição',25),(19,'TV Escola','Abril','2016-12-04','12º Edição',25),(20,'TV Escola','Abril','2016-12-04','12º Edição',25),(21,'TV Escola','Abril','2016-12-04','12º Edição',25),(22,'TV Escola','Abril','2016-12-04','12º Edição',25),(23,'TV Escola','Abril','2016-12-04','12º Edição',25),(24,'TV Escola','Abril','2016-12-04','12º Edição',25),(25,'TV Escola','Abril','2016-12-04','12º Edição',25),(26,'TV Escola','Abril','2016-12-04','12º Edição',25),(27,'TV Escola','Abril','2016-12-04','12º Edição',25),(28,'TV Escola','Abril','2016-12-04','12º Edição',25),(29,'TV Escola','Abril','2016-12-04','12º Edição',25),(30,'TV Escola','Abril','2016-12-04','12º Edição',25),(31,'TV Escola','Abril','2016-12-04','12º Edição',25),(32,'TV Escola','Abril','2016-12-04','12º Edição',25),(33,'TV Escola','Abril','2016-12-04','12º Edição',25),(34,'TV Escola','Abril','2016-12-04','12º Edição',25),(35,'TV Escola','Abril','2016-12-04','12º Edição',25),(36,'TV Escola','Abril','2016-12-04','12º Edição',25),(37,'TV Escola','Abril','2016-12-04','12º Edição',25),(38,'TV Escola','Abril','2016-12-04','12º Edição',25),(39,'TV Escola','Abril','2016-12-04','12º Edição',25),(40,'TV Escola','Abril','2016-12-04','12º Edição',25),(41,'TV Escola','Abril','2016-12-04','12º Edição',25),(42,'TV Escola','Abril','2016-12-04','12º Edição',25),(43,'TV Escola','Abril','2016-12-04','12º Edição',25),(44,'TV Escola','Abril','2016-12-04','12º Edição',25);
/*!40000 ALTER TABLE `revistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tcc`
--

DROP TABLE IF EXISTS `tcc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tcc` (
  `idtcc` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(35) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `autores` varchar(35) DEFAULT NULL,
  `orientador` varchar(35) DEFAULT NULL,
  `ano_defesa` year(4) DEFAULT NULL,
  `local` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`idtcc`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcc`
--

LOCK TABLES `tcc` WRITE;
/*!40000 ALTER TABLE `tcc` DISABLE KEYS */;
INSERT INTO `tcc` VALUES (1,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(2,'UML 2.0','Tese','Alan Turing','Robert Hulk',2014,'Patos'),(3,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(5,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(6,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(7,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(8,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(9,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(10,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(11,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(12,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(13,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(14,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(15,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(16,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(17,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(18,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(19,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(20,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(21,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(22,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(23,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(24,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(25,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(26,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(27,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(28,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(29,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(30,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(31,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(32,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(33,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(34,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(35,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(36,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(37,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(38,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(39,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(40,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(41,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(42,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(43,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande'),(44,'UML na pratica','Monografia','Alan Turing','Robert Hulk',2010,'Campina Grande');
/*!40000 ALTER TABLE `tcc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-20 21:24:59
