-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: db_leturminha
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
-- Table structure for table `tb_aluno`
--

DROP TABLE IF EXISTS `tb_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_aluno` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `id_professor` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_id_professor` (`id_professor`),
  CONSTRAINT `FK_id_professor` FOREIGN KEY (`id_professor`) REFERENCES `tb_professor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_aluno`
--

LOCK TABLES `tb_aluno` WRITE;
/*!40000 ALTER TABLE `tb_aluno` DISABLE KEYS */;
INSERT INTO `tb_aluno` VALUES (1,'Teste231',NULL),(3,'Fernando da Silva Pereira',NULL),(4,'Mariana de Lima',NULL);
/*!40000 ALTER TABLE `tb_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_card`
--

DROP TABLE IF EXISTS `tb_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `img_card` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_card`
--

LOCK TABLES `tb_card` WRITE;
/*!40000 ALTER TABLE `tb_card` DISABLE KEYS */;
INSERT INTO `tb_card` VALUES (1,NULL,'https://drive.google.com/file/d/1-ydCnQoUwfwvg0Eiuokr3u_B57aSJmFx/view'),(2,'CERVO','https://trello.com/1/cards/6338da8d261d060024f59c91/attachments/6338daa2e21325019695368f/previews/6338daa3e213250196953699/download/00.jpeg.jpg'),(3,'Cervo','https://trello.com/1/cards/6338da8d261d060024f59c91/attachments/6338daa2e21325019695368f/previews/6338daa3e213250196953699/download/00.jpeg.jpg'),(4,NULL,'teste.com.br'),(6,'teste','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBwlvEnPcaxdTnAPN0Rmik3WEeid_5aPFu9Q&usqp=CAU'),(7,'ELEFANTE','https://trello.com/1/cards/6338da8d261d060024f59c91/attachments/6338daa306ce1503fa6b72b5/previews/6338daa406ce1503fa6b72f5/download/01.jpeg.jpg'),(8,'CAVALO','https://trello.com/1/cards/6338da8d261d060024f59c91/attachments/6338daa406ce1503fa6b7367/previews/6338daa506ce1503fa6b7380/download/02.jpeg.jpg'),(9,'TOURO','https://trello.com/1/cards/6338da8d261d060024f59c91/attachments/6338daa595ee940141cfab66/previews/6338daa695ee940141cfab88/download/03.jpeg.jpg'),(10,'ZEBRA','https://trello.com/1/cards/6338da8d261d060024f59c91/attachments/6338daa795ee940141cfabe4/previews/6338daa795ee940141cfabfc/download/04.jpeg.jpg'),(11,'ONÇA','https://trello.com/1/cards/6338da8d261d060024f59c91/attachments/6338daa8b9ab6f0052e0de69/previews/6338daa8b9ab6f0052e0de6f/download/05.jpeg.jpg'),(12,'teste grande','https://s2.glbimg.com/frDJkYXAF-B1e69nnK2_HMVxQJ8=/0x0:694x516/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2019/V/D/LZTF8gSkiDZnGjKCE2Wg/lagoa-verde-ilha-grande.png');
/*!40000 ALTER TABLE `tb_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_partida_memoria`
--

DROP TABLE IF EXISTS `tb_partida_memoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_partida_memoria` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tempo_partida` int DEFAULT NULL,
  `qtd_jogadas` int DEFAULT NULL,
  `id_aluno` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_id_aluno` (`id_aluno`),
  CONSTRAINT `FK_id_aluno` FOREIGN KEY (`id_aluno`) REFERENCES `tb_aluno` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_partida_memoria`
--

LOCK TABLES `tb_partida_memoria` WRITE;
/*!40000 ALTER TABLE `tb_partida_memoria` DISABLE KEYS */;
INSERT INTO `tb_partida_memoria` VALUES (1,180,10,NULL),(2,230,12,NULL),(3,101,11,NULL),(4,360,20,NULL);
/*!40000 ALTER TABLE `tb_partida_memoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_professor`
--

DROP TABLE IF EXISTS `tb_professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_professor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(300) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_professor`
--

LOCK TABLES `tb_professor` WRITE;
/*!40000 ALTER TABLE `tb_professor` DISABLE KEYS */;
INSERT INTO `tb_professor` VALUES (1,'Rosilda Cardoso','rosildacardoso@teste.com','ros123'),(2,'Marta Teixeira Silva','marta.teixeira@teste.com.br','teixeira123'),(4,'Wallz Teacher 2','teach_wallz@hotmail.com','Wal123');
/*!40000 ALTER TABLE `tb_professor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-02  0:25:38
