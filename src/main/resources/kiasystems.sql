-- MySQL dump 10.13  Distrib 5.7.10, for Win64 (x86_64)
--
-- Host: localhost    Database: kiasystems
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departments` (
  `department_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(70) NOT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Конструкторский отдел'),(2,'Лаборатория систем управления антенных комплексов');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `employee_id` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `father_name` varchar(30) DEFAULT NULL,
  `department_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `department_id_fk` (`department_id`),
  CONSTRAINT `department_id_fk` FOREIGN KEY (`department_id`) REFERENCES `departments` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Максим','Рыжов','Валерьевич',1),(2,'Александр','Андриевский','Юрьевич',2),(3,'Павел','Шестаков',NULL,1),(4,'Андей','Двойченков',NULL,1),(6,'Дмитрий','Матюшкин','Михайлович',1),(7,'Николай','Крылов',NULL,1),(8,'Марат','Мусин','Хамисович',2);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metric_number_images`
--

DROP TABLE IF EXISTS `metric_number_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metric_number_images` (
  `metric_number_id` int(20) unsigned NOT NULL,
  `image` mediumblob,
  PRIMARY KEY (`metric_number_id`),
  UNIQUE KEY `metric_number_id` (`metric_number_id`),
  CONSTRAINT `metric_number_id_images_fk` FOREIGN KEY (`metric_number_id`) REFERENCES `metric_numbers` (`metric_number_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metric_number_images`
--

LOCK TABLES `metric_number_images` WRITE;
/*!40000 ALTER TABLE `metric_number_images` DISABLE KEYS */;
INSERT INTO `metric_number_images` VALUES (17,'');
/*!40000 ALTER TABLE `metric_number_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metric_number_logs`
--

DROP TABLE IF EXISTS `metric_number_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metric_number_logs` (
  `log_date` date NOT NULL,
  `message` varchar(300) NOT NULL,
  `employee_id` int(15) unsigned NOT NULL,
  KEY `employee_id_fk_idx` (`employee_id`),
  CONSTRAINT `metric_number_logs_fk` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metric_number_logs`
--

LOCK TABLES `metric_number_logs` WRITE;
/*!40000 ALTER TABLE `metric_number_logs` DISABLE KEYS */;
INSERT INTO `metric_number_logs` VALUES ('2016-02-17','Добавление децимального номера КМНШ.203349.003',6),('2016-02-18','Добавление номера',1),('2016-02-18','Добавление номера',2),('2015-12-21','Добавление номера',3),('2016-02-10','Удаление номера',4);
/*!40000 ALTER TABLE `metric_number_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metric_numbers`
--

DROP TABLE IF EXISTS `metric_numbers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metric_numbers` (
  `metric_number_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL,
  `title` varchar(120) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`metric_number_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metric_numbers`
--

LOCK TABLES `metric_numbers` WRITE;
/*!40000 ALTER TABLE `metric_numbers` DISABLE KEYS */;
INSERT INTO `metric_numbers` VALUES (1,'КМНШ.203349','Устройства контроля, стабилизации, управления, регулирования, настройки совмещения, фиксирования, слежения и т.п.',''),(3,'КМНШ.203413','Устройства светодиозирующие, светозащитные, щели спектральные - диафрагмы постоянные круглые',''),(4,'КМНШ.297219','Макеты',''),(5,'КМНШ.300003','Документы на маркировку',''),(8,'КМНШ.301112','Устройства корпусные(корпуса)',''),(9,'КМНШ.301114','Устройства корпусные(корпуса)',''),(16,'КМНШ.665333','Тестовая запись','Без пометок'),(17,'КМНШ.999999','sdsadasdsdf','');
/*!40000 ALTER TABLE `metric_numbers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `policies`
--

DROP TABLE IF EXISTS `policies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policies` (
  `employee_id` int(15) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  UNIQUE KEY `prim_key` (`employee_id`,`role_id`),
  KEY `role_id_fk` (`role_id`),
  CONSTRAINT `policies_employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `policies`
--

LOCK TABLES `policies` WRITE;
/*!40000 ALTER TABLE `policies` DISABLE KEYS */;
INSERT INTO `policies` VALUES (1,1),(2,1),(8,1),(6,2);
/*!40000 ALTER TABLE `policies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `metric_number_id` int(20) unsigned NOT NULL,
  `product_index` int(3) unsigned zerofill NOT NULL,
  `employee_taking_id` int(15) unsigned NOT NULL,
  `taking_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `employee_return_id` int(15) unsigned DEFAULT NULL,
  `theme_id` int(15) unsigned NOT NULL,
  `notes` varchar(250) DEFAULT NULL,
  `special_notes` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_name` (`metric_number_id`,`product_index`),
  KEY `employee_taking_id_fk` (`employee_taking_id`),
  KEY `employee_return_id_fk` (`employee_return_id`),
  KEY `theme_id_fk` (`theme_id`),
  KEY `metric_numbers_id_fk_idx` (`metric_number_id`),
  CONSTRAINT `employee_return_id_fk` FOREIGN KEY (`employee_return_id`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `employee_taking_id_fk` FOREIGN KEY (`employee_taking_id`) REFERENCES `employees` (`employee_id`),
  CONSTRAINT `metric_numbers_id_fk` FOREIGN KEY (`metric_number_id`) REFERENCES `metric_numbers` (`metric_number_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `theme_id_fk` FOREIGN KEY (`theme_id`) REFERENCES `themes` (`theme_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,8,001,1,'2008-05-30','2008-09-19',1,1,NULL,NULL),(2,8,002,1,'2008-05-30','2012-06-19',6,2,NULL,NULL),(3,8,003,3,'2014-02-04',NULL,NULL,3,NULL,NULL),(4,8,004,3,'2014-02-07',NULL,NULL,3,NULL,NULL),(5,8,005,2,'2009-07-27','2010-08-06',1,4,NULL,NULL),(6,8,006,4,'2011-08-11','2011-08-15',3,5,NULL,NULL),(95,16,001,6,'2016-02-12',NULL,NULL,2,'',''),(96,16,002,6,'2016-02-12',NULL,NULL,1,'',''),(97,16,003,6,'2016-02-12',NULL,NULL,1,'',''),(98,16,004,6,'2016-02-12','2016-02-13',2,2,'',''),(99,1,001,6,'2016-02-01','2016-02-03',1,1,'',''),(100,16,005,6,'2016-02-01',NULL,NULL,1,'',''),(101,16,006,6,'2016-02-01',NULL,NULL,2,'',''),(102,16,007,6,'2016-02-02',NULL,NULL,6,'',''),(103,16,008,6,'2016-02-02',NULL,NULL,2,'',''),(104,1,002,6,'2016-02-02',NULL,NULL,6,'',''),(105,17,001,1,'2016-02-01','2016-02-03',NULL,6,'',''),(106,1,003,6,'2016-02-01',NULL,NULL,1,'','');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Admin','Администратор системы, имеющий доступ ко всему'),(2,'Constructor','Сотрудники конструкторского отдела');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `themes`
--

DROP TABLE IF EXISTS `themes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `themes` (
  `theme_id` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(250) NOT NULL,
  `start_date` date DEFAULT NULL,
  `close_date` date DEFAULT NULL,
  PRIMARY KEY (`theme_id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themes`
--

LOCK TABLES `themes` WRITE;
/*!40000 ALTER TABLE `themes` DISABLE KEYS */;
INSERT INTO `themes` VALUES (1,'Ступень',NULL,NULL),(2,'Оргтехника',NULL,NULL),(3,'Байконур-НКИ-ММА',NULL,NULL),(4,'Отличие',NULL,NULL),(5,'Байконур 11',NULL,NULL),(6,'Обновление ОПУ',NULL,NULL),(8,'Test theme 1','2016-02-24',NULL);
/*!40000 ALTER TABLE `themes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `employee_id` int(15) unsigned NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` char(32) NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  CONSTRAINT `employee_id_fk` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ryzhov','db84c7c2d4aef61692ec7f9f1776b937'),(2,'andrievskij','4c335536443ed3f176840ae0ad8f440b'),(6,'matyusjkin','84b1c73a7763d3ba89dbad2ab02fa6da'),(8,'admin','a189c633d9995e11bf8607170ec9a4b8');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_user_role`
--

DROP TABLE IF EXISTS `v_user_role`;
/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_user_role` AS SELECT 
 1 AS `employee_id`,
 1 AS `username`,
 1 AS `password`,
 1 AS `role_id`,
 1 AS `rolename`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_user_role`
--

/*!50001 DROP VIEW IF EXISTS `v_user_role`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_user_role` AS select `u`.`employee_id` AS `employee_id`,`u`.`username` AS `username`,`u`.`password` AS `password`,`r`.`role_id` AS `role_id`,`r`.`name` AS `rolename` from ((`users` `u` join `policies` `p` on((`u`.`employee_id` = `p`.`employee_id`))) join `roles` `r` on((`r`.`role_id` = `p`.`role_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-24 22:26:12
