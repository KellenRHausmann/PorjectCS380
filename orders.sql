-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: projectdatabase
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `drinkNumber` int NOT NULL AUTO_INCREMENT,
  `customerID` int NOT NULL,
  `orderDate` varchar(45) NOT NULL,
  `drinkType` varchar(45) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `calories` int NOT NULL,
  `additions` varchar(255) DEFAULT NULL,
  `size` varchar(100) DEFAULT NULL,
  `temp` varchar(100) DEFAULT NULL,
  `caffeine` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`drinkNumber`,`customerID`),
  KEY `ordersFKaccounts_idx` (`customerID`),
  CONSTRAINT `ordersFKaccounts` FOREIGN KEY (`customerID`) REFERENCES `accounts` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'06/04/2023','Mocha',7.80,550,'Milk,Whipped Cream,Syrup,','Medium','Iced','Split-shot'),(2,1,'06/04/2023','Cappucino',8.50,845,'Sugar,Whipped Cream,','Small','Hot','Split-shot'),(3,1,'06/04/2023','Latte',7.05,415,'Milk,Sugar,Whipped Cream,Syrup,','Medium','Iced','Decaf'),(4,2,'06/04/2023','Latte',5.05,325,'Syrup,','Medium','Iced','Regular');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 16:05:11
