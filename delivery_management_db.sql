-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: delivery_management_db
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `bank`
--

DROP TABLE IF EXISTS `bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank`
--

LOCK TABLES `bank` WRITE;
/*!40000 ALTER TABLE `bank` DISABLE KEYS */;
INSERT INTO `bank` VALUES (1,'Sacombank'),(2,'Vietcombank'),(3,'BIDV'),(4,'ACB'),(5,'Agribank');
/*!40000 ALTER TABLE `bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Hà Nội'),(2,'Thành phố Hồ Chí Minh'),(3,'Hải Phòng'),(4,'Đà Nẵng'),(5,'Cần Thơ'),(6,'Nha Trang'),(7,'Huế'),(8,'Đà Lạt');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar_customer` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `account_id` int NOT NULL,
  `bank_id` int NOT NULL,
  `bank_number` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_customer_useraccount_idx` (`account_id`),
  KEY `fk_customer_bank_idx` (`bank_id`),
  CONSTRAINT `fk_customer_bank` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`),
  CONSTRAINT `fk_customer_useraccount` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,NULL,3,1,NULL),(2,NULL,7,2,NULL),(3,NULL,9,3,NULL),(4,NULL,10,4,NULL),(5,NULL,13,5,NULL),(6,NULL,14,1,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discount` (
  `id` int NOT NULL AUTO_INCREMENT,
  `discount_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `discount_percent` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discount`
--

LOCK TABLES `discount` WRITE;
/*!40000 ALTER TABLE `discount` DISABLE KEYS */;
INSERT INTO `discount` VALUES (1,'Sinh nhat',10),(16,'Quoc khanh',5),(17,'Tet nguyen dan',10),(18,'Gio to Hung Vuong',3),(19,'Noel',7);
/*!40000 ALTER TABLE `discount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `shipper_id` int NOT NULL,
  `comment` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `rating` int DEFAULT NULL,
  `created_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_feedback_shipper_idx` (`shipper_id`),
  KEY `fk_feedback_customer_idx` (`customer_id`),
  CONSTRAINT `fk_feedback_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_feedback_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,1,1,'tot',4,'2022-08-31 00:00:00'),(2,1,1,'than thien',4,'2022-09-02 10:31:18'),(3,1,5,'than thien',5,'2022-09-02 10:31:18'),(4,1,6,'than thien',4,'2022-09-02 10:31:19'),(5,1,7,'than thien',5,'2022-09-02 10:31:20'),(6,1,1,'de thuong\n',4,'2022-09-02 10:33:57'),(7,1,8,'de thuong\n',4,'2022-09-02 10:33:59'),(8,1,1,'dep trai',4,'2022-09-02 10:34:56'),(9,1,1,'de men',5,'2022-09-02 10:36:22'),(10,2,1,'dung gio',4,'2022-08-02 00:00:00'),(11,2,5,'qua tot',5,'2022-09-01 00:00:00'),(12,2,6,'tuyet',4,'2022-07-17 00:00:00'),(13,2,7,'nhanh nhen',4,'2022-08-18 00:00:00'),(14,3,8,'de gan',4,'2022-07-07 00:00:00'),(15,3,6,'kho chiu',2,'2022-07-05 00:00:00'),(16,4,7,'nong tinh',1,'2022-09-01 00:00:00'),(17,4,8,'gat gong',2,'2022-05-20 00:00:00'),(18,4,1,'lam phien',1,'2022-06-06 00:00:00'),(19,5,1,'de thuong',4,'2022-07-08 00:00:00'),(20,5,5,'nhay',2,'2022-08-25 00:00:00'),(21,6,6,'dang ghet',3,'2022-08-12 00:00:00'),(22,6,7,'gioi',4,'2022-08-10 00:00:00');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `shipper_id` int NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `required_date` datetime DEFAULT NULL,
  `shipped_date` datetime DEFAULT NULL,
  `ship_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ship_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city_id` int NOT NULL,
  `ship_postalcode` int NOT NULL,
  `ship_status` bit(1) DEFAULT b'1',
  `payment_status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `fk_orders_shipper_idx` (`shipper_id`),
  KEY `fk_orders_customer_idx` (`customer_id`),
  KEY `fk_orders_city_idx` (`city_id`),
  CONSTRAINT `fk_orders_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_orders_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_orders_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,1,1,'2022-08-23 00:00:00','2022-08-24 00:00:00','2022-08-25 00:00:00','Nhi','Tan Phu',2,123456,_binary '',_binary ''),(4,1,1,'2022-01-24 00:00:00','2022-01-25 00:00:00','2022-01-25 00:00:00','Lan','Tan Binh',2,123457,_binary '',_binary ''),(5,2,1,'2022-03-26 00:00:00','2022-03-27 00:00:00','2022-03-27 00:00:00','Huong','Thu Duc',2,123458,_binary '',_binary ''),(6,1,1,'2022-05-07 00:00:00','2022-05-08 00:00:00','2022-05-08 00:00:00','Cuong','Quan 1',2,123459,_binary '',_binary ''),(7,3,1,'2022-04-06 00:00:00','2022-04-09 00:00:00','2022-04-09 00:00:00','Uyen','Quan 2',2,123460,_binary '',_binary ''),(8,4,1,'2022-01-23 00:00:00','2022-10-26 00:00:00','2022-10-26 00:00:00','Chi','Quan 3',2,123461,_binary '',_binary ''),(9,5,1,'2022-02-22 00:00:00','2022-12-24 00:00:00','2022-12-24 00:00:00','Nam','Quan 4',2,123462,_binary '',_binary ''),(10,1,5,'2022-02-03 00:00:00','2022-02-04 00:00:00','2022-02-04 00:00:00','Le','Tan Phu',2,123463,_binary '',_binary ''),(11,2,5,'2022-06-08 00:00:00','2022-09-09 00:00:00','2022-09-09 00:00:00','Luyen','Binh Thanh',2,123466,_binary '',_binary ''),(12,3,5,'2022-01-04 00:00:00','2022-01-06 00:00:00','2022-01-06 00:00:00','Lam','Quan 10',2,123467,_binary '',_binary ''),(13,4,5,'2022-07-04 00:00:00','2022-07-07 00:00:00','2022-07-07 00:00:00','Tuyen','Quan 3',2,123468,_binary '',_binary ''),(14,5,5,'2022-03-05 00:00:00','2022-03-07 00:00:00','2022-03-07 00:00:00','Thinh','Quan 5',2,123469,_binary '',_binary ''),(15,1,5,'2022-05-06 00:00:00','2022-05-09 00:00:00','2022-05-09 00:00:00','Vi','Quan 6',2,123470,_binary '',_binary ''),(16,2,6,'2022-05-07 00:00:00','2022-05-08 00:00:00','2022-05-08 00:00:00','Uyen','Tan Phu',2,123471,_binary '',_binary ''),(17,3,6,'2022-07-05 00:00:00','2022-07-06 00:00:00','2022-07-06 00:00:00','Huong ','Tan Binh',2,123472,_binary '',_binary ''),(18,6,6,'2022-02-02 00:00:00','2022-02-03 00:00:00','2022-02-03 00:00:00','Tung','Go Vap',2,123473,_binary '',_binary ''),(19,5,6,'2022-04-04 00:00:00','2022-04-05 00:00:00','2022-04-05 00:00:00','Duong','Quan 8',2,123474,_binary '',_binary ''),(20,6,6,'2022-04-08 00:00:00','2022-04-09 00:00:00','2022-04-09 00:00:00','Linh','Quan 9',2,123475,_binary '',_binary ''),(21,2,7,'2022-01-09 00:00:00','2022-01-10 00:00:00','2022-01-10 00:00:00','Tri','Quan 10',2,123476,_binary '',_binary ''),(22,3,7,'2022-03-17 00:00:00','2022-03-18 00:00:00','2022-03-18 00:00:00','Nguyen','Quan 11',2,123477,_binary '',_binary ''),(23,1,7,'2022-05-28 00:00:00','2022-05-29 00:00:00','2022-05-29 00:00:00','Toan','Quan 12',2,123478,_binary '',_binary ''),(24,5,8,'2022-06-09 00:00:00','2022-06-10 00:00:00','2022-06-10 00:00:00','Tuan','Quan 1',2,123479,_binary '',_binary ''),(25,4,8,'2022-07-07 00:00:00','2022-07-09 00:00:00','2022-07-09 00:00:00','Hoang','Quan 2',2,123480,_binary '',_binary ''),(26,6,8,'2022-05-05 00:00:00','2022-05-06 00:00:00','2022-05-06 00:00:00','Lan','Quan3',2,123481,_binary '',_binary '');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_detail`
--

DROP TABLE IF EXISTS `orders_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int NOT NULL,
  `product_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ship_price` decimal(10,0) DEFAULT '0',
  `discount_id` int DEFAULT NULL,
  `order_status` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `fk_ordersdetail_orders_idx` (`order_id`),
  KEY `fk_ordersdetail_discount_idx` (`discount_id`),
  CONSTRAINT `fk_ordersdetail_discount` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`),
  CONSTRAINT `fk_ordersdetail_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_detail`
--

LOCK TABLES `orders_detail` WRITE;
/*!40000 ALTER TABLE `orders_detail` DISABLE KEYS */;
INSERT INTO `orders_detail` VALUES (3,3,'Quan ao',10000,1,_binary ''),(4,4,'Do an',20000,NULL,_binary ''),(5,5,'Thuc uong',35000,NULL,_binary ''),(6,6,'Do choi',40000,NULL,_binary ''),(7,7,'Dung cu',60000,NULL,_binary ''),(8,8,'Non',10000,NULL,_binary ''),(9,9,'Giay',10000,NULL,_binary ''),(10,10,'Dep',10000,NULL,_binary ''),(11,11,'Ban',80000,NULL,_binary ''),(12,12,'Ghe',90000,NULL,_binary ''),(13,13,'Dien thoai',50000,NULL,_binary ''),(14,14,'May tinh',125000,NULL,_binary ''),(15,15,'Tivi',115000,NULL,_binary ''),(16,16,'Tu lanh',220000,NULL,_binary ''),(17,17,'Quan ao',15000,NULL,_binary ''),(18,18,'Thuc uong',10000,NULL,_binary ''),(19,19,'Do an',5000,NULL,_binary ''),(20,20,'Quan ao',15000,NULL,_binary ''),(21,21,'May tinh',75000,NULL,_binary ''),(22,22,'May chup hinh',25000,NULL,_binary ''),(23,23,'May giat',165000,NULL,_binary ''),(24,24,'Bep',180000,NULL,_binary ''),(25,25,'Tu ',90000,NULL,_binary ''),(26,26,'Hop dung',20000,NULL,_binary '');
/*!40000 ALTER TABLE `orders_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_place_city_idx` (`city_id`),
  CONSTRAINT `fk_place_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (1,'05 Tràng Tiền, Hoàn Kiếm',1),(2,'99 Võ Văn Tần, Quận 3',2),(3,'180 Nguyễn Văn Linh, An Duong',3),(4,'220 Lý Tự Trọng, Hải Châu',4),(5,'30 Hòa Bình, Ninh Kiều',5),(6,'50 Lê Thánh Tôn, Lộc Thọ',6),(7,'100 Phạm Văn Đồng',7),(8,'43 Hoàng Văn Thụ',8);
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper` (
  `id` int NOT NULL AUTO_INCREMENT,
  `license_plate` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avatar_shipper` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city_id` int NOT NULL,
  `account_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shipper_city_idx` (`city_id`),
  KEY `fk_shipper_useraccount_idx` (`account_id`),
  CONSTRAINT `fk_shipper_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `fk_shipper_useraccount` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
INSERT INTO `shipper` VALUES (1,'123.56','https://res.cloudinary.com/lenvo1202/image/upload/v1661905096/w7destutdjoadseneyra.png',2,2),(5,'234.56','https://res.cloudinary.com/lenvo1202/image/upload/v1661905096/w7destutdjoadseneyra.png',2,8),(6,'536.67','https://res.cloudinary.com/lenvo1202/image/upload/v1661905096/w7destutdjoadseneyra.png',2,11),(7,'236.98','https://res.cloudinary.com/lenvo1202/image/upload/v1661905096/w7destutdjoadseneyra.png',2,12),(8,'565.98','https://res.cloudinary.com/lenvo1202/image/upload/v1661905096/w7destutdjoadseneyra.png',2,15);
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_firstname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_lastname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_dateofbirth` datetime DEFAULT NULL,
  `user_gender` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_phonenumber` int DEFAULT NULL,
  `user_gmail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_citizenidentitycard` int DEFAULT NULL,
  `user_active` bit(1) DEFAULT b'1',
  `user_role` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_avatar` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_UNIQUE` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,'phuc','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Nguyen','Phuc','2001-04-03 00:00:00','Nam','Tp HCM',384464799,'nguyenhuuphuc342001@gmail.com',123456789,_binary '','ROLE_ADMIN',NULL),(2,'cong','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Nguyen','Cong','2000-06-05 00:00:00','Nam','Tp HCM',112233445,'nguyenthanhcong@gmail.com',223311223,_binary '','ROLE_SHIPPER','https://res.cloudinary.com/lenvo1202/image/upload/v1662034876/95441316_2456895411267810_6596607044059398144_n_vqjpow.jpg'),(3,'tan','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Bui','Tan','2001-09-20 00:00:00','Nam','Tp HCM',223344556,'buitan@gmail.com',112233445,_binary '','ROLE_CUSTOMER','https://res.cloudinary.com/lenvo1202/image/upload/v1661918495/spxwksmtjghdwnsz2vib.webp'),(7,'vuong','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Tran','Vuong','1987-01-01 00:00:00','Nam','TP Cam Ranh',134223553,'tranvuong@gmail.com',435464533,_binary '','ROLE_CUSTOMER','https://res.cloudinary.com/lenvo1202/image/upload/v1660909108/cld-sample.jpg'),(8,'hung','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Nguyen','Hung','2000-08-07 00:00:00','Nam','TP Da Nang',124363299,'nguyenhung@gmail.com',453452356,_binary '','ROLE_SHIPPER','https://res.cloudinary.com/lenvo1202/image/upload/v1660909037/sample.jpg'),(9,'an','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Nguyen','An','2001-01-03 00:00:00','Nu','TP HCM',123512312,'an123@gmail.com',425235423,_binary '','ROLE_CUSTOMER','https://res.cloudinary.com/lenvo1202/image/upload/v1660909117/cld-sample-5.jpg'),(10,'toan','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Tran','Toan','2004-02-03 00:00:00','Nam','TP Vung tau',131352345,'toan@gmail.com',657876854,_binary '','ROLE_CUSTOMER','https://res.cloudinary.com/lenvo1202/image/upload/v1661884250/fc1xv2jqxjwwxezfeel1.jpg'),(11,'loc','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Pham','Loc','2001-08-09 00:00:00','Nu','TP Hue',432142342,'loc@gmail.com',453453454,_binary '','ROLE_SHIPPER','https://res.cloudinary.com/lenvo1202/image/upload/v1660909110/cld-sample-2.jpg'),(12,'ngan','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Pham','Ngan','2001-05-06 00:00:00','Nu','TP HCM',123524453,'ngan@gmail.com',232354343,_binary '','ROLE_SHIPPER','https://res.cloudinary.com/lenvo1202/image/upload/v1662039826/coagfviyp21ifpp1ezjw.jpg'),(13,'nhi','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Nguyen','Nhi','2001-12-20 00:00:00','Nu','TP Quang Ngai',546354343,'nhi@gmail.com',674564574,_binary '','ROLE_CUSTOMER','https://res.cloudinary.com/lenvo1202/image/upload/v1662034875/302162958_1770302933326536_3372463665377377695_n_kglyez.jpg'),(14,'lan','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','To','Lan','2001-09-08 00:00:00','Nu','TP Da Nang',123543223,'lan@gmail.com',342354335,_binary '','ROLE_CUSTOMER','https://res.cloudinary.com/lenvo1202/image/upload/v1662038893/pxinidmtrgnwaplo0hzz.jpg'),(15,'hieu','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','Phan','Hieu','2001-03-13 00:00:00','Nam','TP Da Nang',123123243,'hieu@gmail.com',345346765,_binary '','ROLE_SHIPPER','https://res.cloudinary.com/lenvo1202/image/upload/v1662034875/294033812_2970461823253461_2495008732196414807_n_i9ulxb.jpg');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-02 14:56:27
