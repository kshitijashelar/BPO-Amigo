# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                 127.0.0.1
# Database:             call_centre_db_
# Server version:       5.5.11
# Server OS:            Win32
# Target-Compatibility: Same as source server (MySQL 5.5.11)
# max_allowed_packet:   1048576
# HeidiSQL version:     3.2 Revision: 1129
# --------------------------------------------------------

/*!40100 SET CHARACTER SET latin1*/;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0*/;


#
# Database structure for database 'call_centre_db_'
#

CREATE DATABASE `call_centre_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `call_centre_db`;


#
# Table structure for table 'call_data'
#

CREATE TABLE `call_data` (
  `call_id` int(11) NOT NULL,
  `call_text` longtext,
  `proccessed_text` longtext,
  `audio_file_path` varchar(256) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `u_id` int(3) DEFAULT '10',
  PRIMARY KEY (`call_id`)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'call_data'
#

LOCK TABLES `call_data` WRITE;
/*!40000 ALTER TABLE `call_data` DISABLE KEYS*/;
INSERT INTO `call_data` (`call_id`, `call_text`, `proccessed_text`, `audio_file_path`, `add_date`, `status`, `u_id`) VALUES
	(1,'it\r\n has faulty camera and damage Factory camera resolution is I am very disappointed with \r\nthe quality of its pictures battery dies after every has no fingerprint sensor not \r\nworking properly','faulty camera damage Factory camera resolution disappointed quality pictures battery dies no fingerprint sensor not working properly ',NULL,NULL,1,10),
	(2,'Bluetooth is not working properly','Bluetooth not working properly ',NULL,'2018-03-30 00:45:46',1,10),
	(3,'Bluetooth is not working properly','Bluetooth not working properly ',NULL,'2018-03-30 00:52:52',1,10),
	(4,'Bluetooth is not working properly','Bluetooth not working properly ',NULL,'2018-03-30 00:53:07',1,14),
	(5,'cannot zoom while taking pictures  most  pictures of blur','cannot zoom taking pictures most pictures blur ',NULL,'2018-03-30 00:55:11',1,10),
	(6,'I cannot zoom in while taking pictures and most of the pictures of Blur','cannot zoom taking pictures most pictures Blur ',NULL,'2018-03-30 00:57:21',1,10),
	(7,'the Lenovo phone that I had purchased has certain issues the mobile phone getting connected to any any available WiFi','Lenovo phone purchased issues mobile phone connected WiFi ',NULL,'2018-03-30 00:57:49',1,10),
	(8,'but despite these issues I would like to mention that I am very happy with the camera quality but please help me solve my problem ','issues mention happy camera quality solve problem ',NULL,'2018-03-30 10:19:35',1,10),
	(9,'the Nokia phone that I had put just from your shop has some issues the back he seems to be damaged also Bluetooth is not working properly it does not getting connected to any other device','Nokia phone put shop issues back damaged Bluetooth not working properly not connected device ',NULL,'2018-03-30 10:21:13',1,10),
	(10,'the Nokia phone that I had put just from your shop has some issues the back he seems to be damaged also Bluetooth is not working properly it does not getting connected to any other device ','Nokia phone put shop issues back damaged Bluetooth not working properly not connected device ',NULL,'2018-03-30 11:50:51',1,10),
	(11,'but despite these issues I would like to mention that I am very happy with the camera quality but please help me solve my problem','issues mention happy camera quality solve problem ',NULL,'2018-03-30 11:51:47',1,10),
	(12,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also\r\nyes I have an issue with the camera','today Nokia phone purchased shop issues battery damaged issue camera ',NULL,'2018-04-06 22:41:32',1,11),
	(13,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also\r\nyes I have an issue with the camera','today Nokia phone purchased shop issues battery damaged issue camera ',NULL,'2018-04-06 22:44:39',1,11),
	(14,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also\r\nyes I have an issue with the camera','today Nokia phone purchased shop issues battery damaged issue camera ',NULL,'2018-04-06 22:46:18',1,11),
	(15,'okay madam is there any other issue that you are facing problem','madam issue face problem ',NULL,'2018-04-06 23:13:30',1,11),
	(16,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also\r\nyes I have an issue with the camera','today Nokia phone purchase shop issue battery damage issue camera ',NULL,'2018-04-06 23:37:19',1,11),
	(17,'hello this is my I am somebody \r\nhello so how can I help you today \r\nthe Nokia phone that I had put just from your shop has some issues the back he seems to be damaged also Bluetooth is not working properly it does not getting connected to any other device \r\nokay so I will get back to you regarding these issues is there anything else I can help you with \r\nbut despite these issues I would like to mention that I am very happy with the camera quality but please help me solve my problem \r\nso I will get back to you as soon as possible I am you know down your complaint eighty seven seven seven thank you for calling have a nice day \r\n','can today Nokia phone put shop issue back damage Bluetooth not work properly not connect device back issue can issue mention happy camera quality solve problem back possible complaint eighty call nice day ','831_2018_4_7_0_27_41.mp3','2018-04-07 00:28:22',1,10),
	(18,'hello this is my I am somebody \r\nhello so how can I help you today \r\nthe Nokia phone that I had put just from your shop has some issues the back he seems to be damaged also Bluetooth is not working properly it does not getting connected to any other device \r\nokay so I will get back to you regarding these issues is there anything else I can help you with \r\nbut despite these issues I would like to mention that I am very happy with the camera quality but please help me solve my problem \r\nso I will get back to you as soon as possible I am you know down your complaint eighty seven seven seven thank you for calling have a nice day \r\n','can today Nokia phone put shop issue back damage Bluetooth not work properly not connect device back issue can issue mention happy camera quality solve problem back possible complaint eighty call nice day ','3387_2018_4_7_0_35_31.mp3','2018-04-07 00:36:17',1,10),
	(19,'please help me solve my problem\r\nBluetooth is not working properly\r\nit has faulty camera and damage Factory camera resolution is','solve problem Bluetooth not work properly faulty camera damage Factory camera resolution ',NULL,'2018-04-07 11:49:58',1,10),
	(20,'please help me solve my problem Bluetooth is not working properly','solve problem Bluetooth not work properly ',NULL,'2018-04-07 11:55:13',1,10),
	(21,'please help me solve my problem Bluetooth is not working properly','solve problem Bluetooth not work properly ',NULL,'2018-04-07 11:59:08',1,10),
	(22,'I have a problem with bluetooth connectivity  its not working properly','problem bluetooth connectivity not work properly ',NULL,'2018-04-07 12:00:21',1,10),
	(23,'good battery','good battery ',NULL,'2018-04-10 19:19:13',1,10),
	(24,'good battery','good battery ',NULL,'2018-04-10 19:21:57',1,10),
	(25,'good battery backup','good battery backup ',NULL,'2018-04-10 19:23:31',1,10),
	(26,'camera quality is  poor','camera quality poor ',NULL,'2018-04-10 19:24:39',1,10),
	(27,'camera problem solve','camera problem solve ',NULL,'2018-04-10 19:26:11',1,10),
	(28,'faulty camera  damage ','faulty camera damage ',NULL,'2018-04-10 19:30:03',1,10),
	(29,'faulty bluetooth','faulty bluetooth ',NULL,'2018-04-10 19:34:20',1,14),
	(30,'Bluetooth not working','Bluetooth not working ',NULL,'2018-05-27 23:49:32',1,16),
	(31,'Hey this is Martin hello Sir how can I help you well my Motorola phone has a faulty camera he said okay not anymore problems no but I would like to mention that it\'s Bluetooth connects quickly and it has a high performance battery okay you complaint ID is ABC we will get back to you as soon as possible thank you for calling \r\n','Hey Martin Sir well Motorola phone faulty camera anymore problems mention it\'s Bluetooth connects quickly high performance battery complaint ID ABC back possible calling ','4329_2018_5_28_8_27_16.mp3','2018-05-28 08:27:37',1,16),
	(32,'worse camera and poor resolution','worse camera poor resolution ',NULL,'2018-05-28 09:32:36',1,16),
	(33,'satisfactory camera','satisfactory camera ',NULL,'2018-05-28 09:47:19',1,16),
	(34,'I cannot zoom in while taking pictures and most of the pictures are Blur','cannot zoom take picture picture Blur ',NULL,'2018-05-28 12:50:24',1,16),
	(35,'poor resolution','poor resolution ',NULL,'2018-05-28 12:50:56',1,16),
	(36,' poor resolution','poor resolution ',NULL,'2018-05-28 12:54:40',1,16),
	(37,'poor resolution and camera faulty','poor resolution camera faulty ',NULL,'2018-05-28 12:56:06',1,16),
	(38,'camera faulty','camera faulty ',NULL,'2018-05-28 13:01:03',1,16),
	(39,'hi my name is Sarah hello ma\'am how can I help you the Samsung phone that I purchased has Bluetooth connectivity issues please help okay are there any more problems no but I would like to mention that it\'s processing speed is efficient and the screen has excellent look and feel alright you complete ID is one eight nine we will get back to you as soon as possible thank you for calling \r\n','Sarah ma\'am Samsung phone purchase Bluetooth connectivity issue problem mention it\'s process speed efficient screen excellent feel alright complete ID nine back possible call ','4748_2018_5_28_13_1_41.mp3','2018-05-28 13:01:59',1,16),
	(40,'Hey this is Andrew hello Sir how can I help you the pictures clicked on my new Samsung phone have no clarity please help okay are there any more problems note but I would like to mention that it\'s processing speed is super fast alright your complete ID is one five six we will get back to you as soon as possible thank you for calling \r\n','Hey Andrew ir picture click Samsung phone clarity problem note mention it\'s process speed super fast alright complete ID back possible call ','3500_2018_5_28_13_7_13.mp3','2018-05-28 13:07:30',1,16),
	(41,'Nokia phone put shop issues back damaged Bluetooth not working properly not connected device ','Nokia phone put shop issue back damage Bluetooth not work properly not connect device ',NULL,'2018-05-29 20:35:40',1,16),
	(42,'Nokia phone put shop issues back damaged Bluetooth not working properly not connected device ','nokia phone put shop issue back damage bluetooth not work properly not connect device ',NULL,'2018-05-29 20:39:10',1,16),
	(43,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also yes I have an issue with the camera','today nokia phone purchase shop issue battery damage issue camera ',NULL,'2018-05-29 20:43:10',1,16),
	(44,'has no fingerprint sensor not working properly please assist','fingerprint sensor not work properly assist ',NULL,'2018-05-29 20:45:32',1,16),
	(45,'poor resolution and camera faulty','poor resolution camera faulty ',NULL,'2018-05-29 20:47:58',1,16),
	(46,'Hey this is Andrew hello Sir how can I help you the pictures clicked on my new Samsung phone have no clarity please help okay are there any more problems note but I would like to mention that it\'s processing speed is super fast alright your complete ID is one five six we will get back to you as soon as possible thank you for calling \n','hey andrew picture click samsung phone clarity problem note mention process speed super fast alright complete back possible call ','1248_2018_5_29_20_50_13.mp3','2018-05-29 20:50:32',1,16),
	(47,'hello this is my I am somebody \r\nhello so how can I help you today \r\nthe Nokia phone that I had put just from your shop has some issues the back he seems to be damaged also Bluetooth is not working properly it does not getting connected to any other device \r\nokay so I will get back to you regarding these issues is there anything else I can help you with \r\nbut despite these issues I would like to mention that I am very happy with the camera quality but please help me solve my problem \r\nso I will get back to you as soon as possible I am you know down your complaint eighty seven seven seven thank you for calling have a nice day ','today nokia phone put shop issue back damage bluetooth not work properly not connect device back issue issue mention happy camera quality solve problem back possible complaint eighty call nice day ',NULL,'2018-05-29 20:54:34',1,16);
/*!40000 ALTER TABLE `call_data` ENABLE KEYS*/;
UNLOCK TABLES;


#
# Table structure for table 'dataset'
#

CREATE TABLE `dataset` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `call_text_data` longtext,
  `processed_text_data` longtext,
  `category_name` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'dataset'
#

LOCK TABLES `dataset` WRITE;
/*!40000 ALTER TABLE `dataset` DISABLE KEYS*/;
INSERT INTO `dataset` (`record_id`, `call_text_data`, `processed_text_data`, `category_name`) VALUES
	(1,'battery dies after every has no fingerprint sensor not working properly please assist thank you   ','battery die half hour ','battery-negative'),
	(2,'camera resolution is poor','camera resolution poor ','camera-negative'),
	(3,'it has faulty camera','faulty camera ','camera-negative'),
	(4,'damage battery','damage battery ','battery-negative'),
	(5,'I am very disappointed with the quality of its pictures','disappoint quality picture ','camera-negative'),
	(10,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also','today nokia phone purchase shop issue battery damage ','battery-negative'),
	(11,'Bluetooth is not working properly','bluetooth work proper ','bluetooth-negative'),
	(12,'it is not getting connected to any other device regarding these issues is there anything else I can help you with despite these issues','connecte device regard issue issue ','bluetooth-negative'),
	(13,'I would like to mention that I am very happy with the camera quality','mention happy camera quality ','camera-positive'),
	(16,'I had purchased has some issues to the speakers are damaged','purchase issue speaker damage ','speaker-negative'),
	(19,'yes I have an issue with the camera','issue camera ','camera-negative'),
	(20,'I cannot zoom in while taking pictures and most of the pictures are Blur','cannot zoom picture picture blur ','camera-negative'),
	(25,'I would like to mention that the battery backup is indeed long lasting','mention battery backup long ','battery-positive'),
	(26,'I request you to please help me solve my problem as soon as possible phone ID is 333','request solve problem possible phone 333 ','service-negative'),
	(28,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also\r\n','today nokia phone purchase shop issue battery damage ','battery-negative'),
	(29,'yes I have an issue with the camera','issue camera ','camera-negative'),
	(30,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also\r\n','today nokia phone purchase shop issue battery damage ','battery-negative'),
	(31,'yes I have an issue with the camera','issue camera ','camera-negative'),
	(32,'okay madam is there any other issue that you are facing problem','issue face problem ','service-negative'),
	(33,'today the Nokia phone that I had purchased from your shop has some issues the battery seems to be damaged also\r\n','today nokia phone purchase shop issue battery damage ','battery-negative'),
	(34,'yes I have an issue with the camera','issue camera ','camera-negative'),
	(37,'the Nokia phone that I had put just from your shop has some issues the battery seems to be damaged','nokia phone put shop issue battery damage ','battery-negative'),
	(38,'okay so I will get back to you regarding these issues is there anything else I can help you with ','back issue ','battery-negative'),
	(39,'but despite these issues I would like to mention that I am very happy with the camera quality but please help me solve my problem ','issue mention happy camera quality solve problem ','camera-positive'),
	(43,'the Nokia phone that I had bought just from your shop has some issues the battery seems to be damaged also Bluetooth is not working properly it is not getting connected to any other device ','nokia phone put shop issue back damage bluetooth work properly connect device ','battery-negative'),
	(45,'but despite these issues I would like to mention that I am very happy with the camera quality','issue mention happy camera quality solve problem ','camera-positive'),
	(47,'please help me solve my problem\r\n','solve problem ','camera-positive'),
	(48,'Bluetooth is not working properly\r\n','bluetooth work properly ','bluetooth-negative'),
	(49,'it has faulty camera  camera resolution is poor','faulty camera  camera resolution ','camera-negative'),
	(50,'please help me solve my problem Bluetooth is not working properly','solve problem bluetooth work properly ','bluetooth-negative'),
	(51,'please help me solve my problem Bluetooth is not working properly','solve problem bluetooth work properly ','bluetooth-negative'),
	(52,'I have a problem with bluetooth connectivity  its not working properly','problem bluetooth connectivity work properly ','bluetooth-negative'),
	(53,'good battery','good battery backup ','battery-positive'),
	(55,'good battery backup','good battery backup ','battery-positive'),
	(57,'camera problem solve','camera problem solve ','camera-positive'),
	(58,'faulty camera  damage ','faulty camera damage ','camera-negative'),
	(59,'faulty bluetooth','faulty bluetooth ','bluetooth-negative'),
	(60,'Bluetooth not working','bluetooth work ','bluetooth-negative'),
	(63,'worse camera and poor resolution','bad camera poor resolution ','display-negative'),
	(64,'poor resolution','poor resolution ','display-negative'),
	(65,'awesome fingerprint sensor','awesome fingerprint sensor speaker volume low ','fingerprint sensor-positive'),
	(66,'amazing camera','amaze camera ','camera-positive'),
	(67,'mobile  hangs frequently','mobile hang frequently ','processing speed-negative'),
	(68,'phone is not getting charged fast and it overheats','phone is not getting charged fast','battery-negative'),
	(69,'battery drains fast','battery drain fast ','battery-negative'),
	(70,'classy display ','classy display ','display-positive'),
	(71,'phone is not good for gaming','phone good game ','processing speed-negative'),
	(72,'no clarity in pictures','clarity picture ','camera-negative'),
	(73,'phone runs slow','phone run slow ','processing speed-negative'),
	(74,'satisfactory camera','satisfactory camera ','camera-negative'),
	(75,'high performance battery','high performance battery ','battery-positive'),
	(76,'I cannot zoom in while taking pictures','cannot zoom picture picture blur ','camera-negative'),
	(77,'poor resolution','poor resolution ','display-negative'),
	(78,' poor resolution','poor resolution ','display-negative'),
	(79,'poor resolution','poor resolution ','display-negative'),
	(82,'processing speed is super fast','process speed super fast ','processing speed-positive'),
	(85,'has no fingerprint sensor not working properly please assist','fingerprint sensor not work properly assist ','fingureprint-negative'),
	(86,'Bluetooth is not working properly','bluetooth not work properly ','blutooth-negative'),
	(87,' Bluetooth is not working properly it is not getting connected to any other device ','bluetooth not work properly not connect device ','bluetooth-negative'),
	(88,'speaker volume very low ','speaker volume low ','speaker-negative'),
	(89,'good sound quality','good sound quality ','speaker-positive'),
	(90,'bluetooth connects quickly','bluetooth connect quickly ','bluetooth-positive'),
	(91,'poor resolution','poor resolution ','display-negative'),
	(92,'elegant display','elegant display ','display-positive'),
	(93,' camera faulty','camera faulty ','camera-negative'),
	(94,' most of the pictures are Blur',' most of the pictures are Blur','camera-negative'),
	(95,' most of the pictures are Blur','most of the pictures are Blur','camera-negative'),
	(96,'Nokia phone put shop issues back damaged Bluetooth not working properly not connected device ','Nokia phone put shop issues back damaged Bluetooth not working properly not connected device ','bluetooth-negative'),
	(97,'nokia phone put shop issues back damaged bluetooth not working properly not connected device ','nokia phone put shop issues back damaged bluetooth not working properly not connected device ','bluetooth-negative'),
	(98,'today the nokia phone that i had purchased from your shop has some issues the battery seems to be damaged','today nokia phone purchased shop issues battery damaged ','battery-negative'),
	(99,' yes i have an issue with the camera',' issue camera ','camera-negative'),
	(100,'has no fingerprint sensor not working properly please assist','fingerprint sensor not working properly assist ','fingureprint-negative'),
	(101,'poor resolution','poor resolution ','display-negative'),
	(102,' camera faulty',' camera faulty ','camera-negative'),
	(103,'hey this is','hey ','camera-negative'),
	(104,'rew hello sir how can i help you the pictures clicked on my new samsung phone have no clarity please help okay are there any more problems note','rew pictures clicked samsung phone clarity problems note ','battery-negative'),
	(105,'i would like to mention that it\'s processing speed is super fast alright your complete id is one five six we will get back to you as soon as possible thank you for calling ','mention processing speed super fast alright complete back possible calling ','processing speed-positive'),
	(106,'hello this is my i am somebody \r','','camera-negative'),
	(107,'hello so how can i help you today \r','today ','battery-negative'),
	(108,'the nokia phone that i had put just from your shop has some issues the back he seems to be damaged','nokia phone put shop issues back damaged ','battery-negative'),
	(109,'bluetooth is not working properly it does not getting connected to any other device \r','bluetooth not working properly not connected device ','bluetooth-negative'),
	(110,'okay so i will get back to you regarding these issues is there anything else i can help you with \r','back issues ','bluetooth-negative'),
	(111,'but despite these issues i would like to mention that i am very happy with the camera quality','issues mention happy camera quality ','camera-positive'),
	(112,'please help me solve my problem \r','solve problem ','camera-positive'),
	(113,'so i will get back to you as soon as possible i am you know down your complaint eighty seven seven seven thank you for calling have a nice day ','back possible complaint eighty calling nice day ','processing speed-positive');
/*!40000 ALTER TABLE `dataset` ENABLE KEYS*/;
UNLOCK TABLES;


#
# Table structure for table 'negative_keywords'
#

CREATE TABLE `negative_keywords` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `words` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=292 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'negative_keywords'
#

LOCK TABLES `negative_keywords` WRITE;
/*!40000 ALTER TABLE `negative_keywords` DISABLE KEYS*/;
INSERT INTO `negative_keywords` (`n_id`, `words`) VALUES
	(1,'poor'),
	(2,'worse'),
	(3,'worst'),
	(4,'bad'),
	(5,'not good'),
	(6,'pathetic'),
	(7,'can\'t'),
	(8,'isn\'t'),
	(9,'no'),
	(13,'cheap 	   '),
	(14,'cheapest	   '),
	(21,'aren\'t'),
	(23,'cannot'),
	(24,'couldnt'),
	(26,'dont'),
	(29,'never'),
	(31,'wont'),
	(33,'wouldnt'),
	(34,'cheap'),
	(35,'close'),
	(36,'out'),
	(37,'closeouts'),
	(39,'only'),
	(41,'waste'),
	(42,'worst'),
	(43,'torture'),
	(56,'bad'),
	(65,'isnt'),
	(115,'doesnt'),
	(194,'isnt'),
	(216,'boring'),
	(233,'wanted'),
	(286,'slow'),
	(287,'faulty'),
	(288,'faulty'),
	(289,'damaged'),
	(290,'damage'),
	(291,'overheat');
/*!40000 ALTER TABLE `negative_keywords` ENABLE KEYS*/;
UNLOCK TABLES;


#
# Table structure for table 'positive_keywords'
#

CREATE TABLE `positive_keywords` (
  `p_id` int(11) NOT NULL,
  `words` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'positive_keywords'
#

LOCK TABLES `positive_keywords` WRITE;
/*!40000 ALTER TABLE `positive_keywords` DISABLE KEYS*/;
INSERT INTO `positive_keywords` (`p_id`, `words`) VALUES
	(1,'satisfactory'),
	(2,'good'),
	(3,'better'),
	(4,'excellent'),
	(5,'awesome'),
	(6,'amazing'),
	(7,'fast'),
	(8,'best'),
	(9,'elegant'),
	(15,'Adorable'),
	(20,'Affluent'),
	(27,'Amaze'),
	(31,'Appreciation'),
	(32,'Approve'),
	(35,'Assertive'),
	(37,'Astounding'),
	(39,'Attractive'),
	(40,'Authentic'),
	(41,'Basic'),
	(42,'Beaming'),
	(43,'Beautiful'),
	(46,'Benefit'),
	(49,'Bliss'),
	(51,'Bountiful'),
	(54,'Bright'),
	(55,'Brilliant'),
	(66,'Charming'),
	(69,'Clarity'),
	(71,'Clean'),
	(73,'Clever'),
	(74,'Closeness'),
	(75,'Commend'),
	(76,'Companionship'),
	(77,'Complete'),
	(78,'Comradeship'),
	(79,'Confident'),
	(80,'Connect'),
	(81,'Connected'),
	(82,'Constant'),
	(89,'Creative'),
	(95,'Dazzling'),
	(97,'Direct'),
	(98,'Discover'),
	(105,'Easy'),
	(108,'Efficient'),
	(109,'Effortless'),
	(111,'Elegance'),
	(128,'Excited'),
	(129,'Exciting'),
	(130,'Exhilarating'),
	(131,'Expand'),
	(137,'Familiar'),
	(139,'Famous'),
	(143,'Fortunate'),
	(144,'Fortune'),
	(145,'Freedom'),
	(148,'Full'),
	(149,'Funny'),
	(155,'Glad'),
	(157,'Good'),
	(158,'Gorgeous'),
	(159,'Grace'),
	(160,'Graceful'),
	(166,'Handsome'),
	(167,'Happy'),
	(168,'Harmony'),
	(169,'Healed'),
	(170,'Healing'),
	(171,'Healthful'),
	(172,'Healthy'),
	(173,'Heart'),
	(174,'Hearty'),
	(175,'Heavenly'),
	(176,'Helpful'),
	(177,'Here'),
	(181,'Honest'),
	(182,'Honor'),
	(198,'Idea'),
	(199,'Ideal'),
	(200,'Imaginative'),
	(201,'Increase'),
	(202,'Incredible'),
	(203,'Independent'),
	(204,'Ingenious'),
	(206,'Innovate'),
	(207,'Inspire'),
	(208,'Instantaneous'),
	(210,'Intellectual'),
	(211,'Intelligence'),
	(212,'Intuitive'),
	(213,'Inventive'),
	(214,'Joined'),
	(215,'Jovial'),
	(216,'Joy'),
	(218,'Keen'),
	(219,'Key'),
	(220,'Kind'),
	(224,'Leader'),
	(225,'Learn'),
	(226,'Legendary'),
	(227,'Let'),
	(229,'Light'),
	(230,'Lively'),
	(232,'Loveliness'),
	(235,'Luminous'),
	(236,'Maintain'),
	(237,'Marvelous'),
	(238,'Master'),
	(239,'Meaningful'),
	(240,'Meditate'),
	(241,'Mend'),
	(243,'Mind-Blowing'),
	(244,'Miracle'),
	(245,'Mission'),
	(246,'Modify'),
	(247,'Motivate'),
	(248,'Moving'),
	(249,'Natural'),
	(250,'Nature'),
	(251,'Nourish'),
	(252,'Nourished'),
	(253,'Novel'),
	(254,'Now'),
	(255,'Nurture'),
	(256,'Nutritious'),
	(259,'Openhanded'),
	(260,'Optimistic'),
	(262,'Party'),
	(263,'Peace'),
	(264,'Perfect'),
	(265,'Phenomenon'),
	(266,'Pleasure'),
	(267,'Plenteous'),
	(268,'Plentiful'),
	(269,'Plenty'),
	(270,'Plethora'),
	(271,'Poise'),
	(272,'Polish'),
	(273,'Popular'),
	(274,'Positive'),
	(275,'Powerful'),
	(276,'Prepared'),
	(277,'Pretty'),
	(278,'Principle'),
	(279,'Productive'),
	(281,'Prominent'),
	(282,'Prosperous'),
	(283,'Protect'),
	(284,'Proud'),
	(285,'Purpose'),
	(286,'Quest'),
	(287,'Quick'),
	(288,'Quiet'),
	(289,'Ready'),
	(290,'Recognize'),
	(291,'Refinement'),
	(292,'Refresh'),
	(293,'Rejoice'),
	(294,'Rejuvenate'),
	(295,'Relax'),
	(296,'Reliance'),
	(297,'Rely'),
	(298,'Remarkable'),
	(299,'Renew'),
	(300,'Renowned'),
	(301,'Replenish'),
	(302,'Resolution'),
	(303,'Resound'),
	(304,'Resources'),
	(305,'Respec'),
	(307,'Restore'),
	(308,'Revere'),
	(309,'Revolutionize'),
	(310,'Rewarding'),
	(311,'Rich'),
	(312,'Robust'),
	(313,'Rousing'),
	(314,'Safe'),
	(315,'Secure'),
	(316,'See'),
	(317,'Sensation'),
	(318,'Serenity'),
	(319,'Shift'),
	(320,'Shine'),
	(321,'Show'),
	(322,'Silence'),
	(323,'Simple'),
	(324,'Sincerity'),
	(325,'Smart'),
	(326,'Smile'),
	(327,'Smooth'),
	(328,'Solution'),
	(329,'Soul'),
	(330,'Sparkling'),
	(331,'Spirit'),
	(332,'Spirited'),
	(333,'Spiritual'),
	(334,'Splendid'),
	(335,'Spontaneous'),
	(336,'Still'),
	(337,'Stir'),
	(338,'Strong'),
	(339,'Style'),
	(340,'Success'),
	(342,'Support'),
	(343,'Sure'),
	(344,'Surprise'),
	(351,'Thrilled'),
	(352,'Thrive'),
	(353,'Today'),
	(354,'Together'),
	(358,'Trust'),
	(359,'Truth'),
	(360,'Unity'),
	(362,'Unwavering'),
	(363,'Upbeat'),
	(364,'Value'),
	(365,'Vary'),
	(366,'Venerate'),
	(367,'Venture'),
	(368,'Very'),
	(369,'extremely stable'),
	(370,'decent'),
	(371,'Vigorous'),
	(372,'Vision'),
	(373,'Visualize'),
	(375,'Vivacious'),
	(376,'Voyage'),
	(377,'Wealthy'),
	(378,'Welcome Well'),
	(379,'Whole'),
	(380,'Wholesome'),
	(382,'Wonder'),
	(383,'Wonderful'),
	(384,'Wondrous'),
	(386,'Yes'),
	(387,'Yippee'),
	(388,'Young'),
	(389,'high performance'),
	(390,'Youthful'),
	(391,'Zeal'),
	(392,'Zest'),
	(395,'sleek'),
	(396,'good'),
	(400,'superfast'),
	(407,'properly'),
	(408,'star'),
	(414,'Awesome'),
	(420,'super'),
	(423,'powerful'),
	(427,'Great'),
	(428,'swiftly'),
	(431,'perfectly'),
	(450,'quickly'),
	(452,'efficient'),
	(454,'superhit'),
	(456,'huge'),
	(458,'nice'),
	(459,'amazing'),
	(462,'fantastic'),
	(468,'wonderful'),
	(470,'excellence'),
	(482,'nice');
/*!40000 ALTER TABLE `positive_keywords` ENABLE KEYS*/;
UNLOCK TABLES;


#
# Table structure for table 'result'
#

CREATE TABLE `result` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `call_id` int(11) DEFAULT NULL,
  `sentiment_category` varchar(256) DEFAULT NULL,
  `probability` float DEFAULT NULL,
  `aspect_result` longtext,
  PRIMARY KEY (`result_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'result'
#

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS*/;
INSERT INTO `result` (`result_id`, `call_id`, `sentiment_category`, `probability`, `aspect_result`) VALUES
	(1,14,'battery-negative','6.2323E-5','categoryName=battery-negative,probability=0.0021255433\r\ncategoryName=camera-negative,probability=0.06321839\r\n'),
	(2,15,'service-positive','0.0155141','categoryName=service-positive,probability=0.00517137\r\n'),
	(3,16,'Positive','0.000488281','categoryName=battery-negative,probability=0.0063245967\r\ncategoryName=camera-negative,probability=0.085734576\r\n'),
	(4,17,'Negative','2.61934E-10','categoryName=battery-negative,probability=0.027205884\r\ncategoryName=battery-negative,probability=1.9003215E-8\r\ncategoryName=battery-negative,probability=0.003523285\r\ncategoryName=camera-positive,probability=2.4932662E-5\r\n'),
	(5,18,'Negative','2.61934E-10','categoryName=battery-negative,probability=0.037760418\r\ncategoryName=battery-negative,probability=1.1405762E-7\r\ncategoryName=battery-negative,probability=0.011067708\r\ncategoryName=camera-positive,probability=0.003766095\r\n'),
	(6,19,'Negative','0.000366211','categoryName=camera-positive,probability=0.026675725\r\ncategoryName=camera-negative,battery-negative,fingureprint sensor-negative,probability=0.0015719355\r\ncategoryName=camera-negative,probability=0.0012110844\r\n'),
	(7,20,'Negative','0.0234375','categoryName=camera-negative,battery-negative,fingureprint sensor-negative,probability=7.2704075E-5\r\n'),
	(8,21,'Negative','0.0234375','categoryName=bluetooth-negative,probability=0.0010626613\r\n'),
	(9,22,'Negative','0.0234375','categoryName=bluetooth-negative,probability=0.0040592947\r\n'),
	(10,23,'Positive','0.1875','categoryName=battery-negative,probability=0.024381869\r\n'),
	(11,24,'Positive','0.1875','categoryName=battery-negative,probability=0.015919812\r\n'),
	(12,25,'Positive','0.09375','categoryName=battery-positive,probability=0.012283805\r\n'),
	(13,26,'Positive','0.0625','categoryName=camera-positive,probability=0.018904323\r\n'),
	(14,27,'Positive','0.0625','categoryName=camera-positive,probability=0.028307253\r\n'),
	(15,28,'Positive','0.0625','categoryName=camera-negative,probability=0.016862603\r\n'),
	(16,29,'Negative','0.1875','categoryName=camera-negative,probability=0.014508929\r\n'),
	(17,30,'Negative','0.1875','categoryName=bluetooth-negative,probability=0.046875\r\n'),
	(18,31,'Positive','2.23517E-8','categoryName=battery-negative,probability=1.0006763E-12\r\n'),
	(19,32,'Negative','0.0703125','categoryName=camera-negative,probability=0.012307097\r\n'),
	(20,33,'Positive','0.1875','categoryName=camera-negative,probability=0.082603246\r\n'),
	(21,34,'Negative','0.0117188','categoryName=camera-negative,probability=2.021538E-4\r\n'),
	(22,35,'Negative','0.1875','categoryName=battery-positive,bluetooth-positive,display-negative,probability=0.016041666\r\n'),
	(23,36,'Negative','0.1875','categoryName=display-negative,probability=0.008193277\r\n'),
	(24,37,'Negative','0.140625','categoryName=camera-negative,battery-negative,probability=0.0026396401\r\n'),
	(25,38,'Negative','0.375','categoryName=camera-negative,battery-negative,probability=0.05071641\r\n'),
	(26,39,'Positive','6.70552E-8','categoryName=battery-negative,probability=7.92533E-11\r\n'),
	(27,40,'Positive','2.68221E-7','categoryName=battery-negative,probability=1.5902245E-12\r\n'),
	(28,41,'Positive','2.28882E-5','categoryName=battery-negative,probability=4.7668532E-8\n'),
	(29,42,'Positive','2.28882E-5','categoryName=bluetooth-negative,probability=1.8006063E-9\n'),
	(30,43,'Negative','0.000732422','categoryName=battery-negative,probability=1.1215884E-4\ncategoryName=camera-negative,probability=0.011321429\n'),
	(31,44,'Positive','0.0117188','categoryName=fingureprint-negative,probability=0.0011086882\n'),
	(32,45,'Negative','0.140625','categoryName=display-negative,probability=0.073784724\ncategoryName=camera-negative,probability=0.011238666\n'),
	(33,46,'Positive','2.14577E-6','categoryName=camera-negative,probability=0.12162162\ncategoryName=battery-negative,probability=1.3825209E-4\ncategoryName=processing speed-positive,probability=1.0392474E-6\n'),
	(34,47,'Positive','5.23869E-10','categoryName=camera-negative,probability=0.060064934\ncategoryName=battery-negative,probability=0.06818182\ncategoryName=battery-negative,probability=5.160053E-5\ncategoryName=bluetooth-negative,probability=6.036772E-4\ncategoryName=bluetooth-negative,probability=0.0087686945\ncategoryName=camera-positive,probability=9.94318E-4\ncategoryName=camera-positive,probability=0.032711037\ncategoryName=processing speed-positive,probability=2.0292208E-4\n');
/*!40000 ALTER TABLE `result` ENABLE KEYS*/;
UNLOCK TABLES;


#
# Table structure for table 'user'
#

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(256) DEFAULT NULL,
  `mobile_number` varchar(50) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_type` varchar(256) DEFAULT NULL,
  `reg_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `product_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 /*!40100 DEFAULT CHARSET=latin1*/;



#
# Dumping data for table 'user'
#

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS*/;
INSERT INTO `user` (`u_id`, `full_name`, `mobile_number`, `email_id`, `password`, `user_type`, `reg_date`, `status`, `product_name`) VALUES
	(10,'Vivek Deshpande','8624847269','0/1ci6/pGBiKDLY7rwoXqP+s/eLN0etCuTq0SKrm3Wc=','Jkr/qP1atr4rLkRdZUX2LQ==','Manager','2018-04-10 18:37:46',1,'IphoneX'),
	(11,'Ganesh Patil','9096888722','HsDGt/WaO2K0ZGRBvsXMO0Ku9ljEOEwcROZgmrXOai8=','Z4NQhK8oG8JIkBqJt1nZgw==','Manager','2018-04-10 18:40:20',1,'Samsung Galaxy Grand Prime'),
	(13,'Ganesh Patil','9096888722','9t5QtE1OcX7CowMtB9xSb7gc5qQQBAw1OdtLmdDXQD8=','BrDBBU9HQEmQNAlD2PhvAw==','User','2018-04-20 13:10:09',1,NULL),
	(14,'Sanjay Tiwari','8989858658','6qs0u6tvgx6gXHjiZ61Uj7gc5qQQBAw1OdtLmdDXQD8=','BL1YB1Dijz0hL52d9Sk5fw==','Manager','2018-04-20 13:14:22',1,'Lenova K8'),
	(15,'Shruti','8988767787','cFSezNdKoKP2Yxk34HfM1mGKGf8UB0/NA0NVQewqcLY=','4d9vUfSGaIk2FqRt5MimSg==','User','2018-05-11 18:33:49',1,NULL),
	(16,'Nimita','9088907677','jOQ9lAXiDLNHQLlqE4+WJ2GKGf8UB0/NA0NVQewqcLY=','fONww4LzlmJr60ENVjEPsg==','Manager','2018-05-11 18:35:27',1,'Samsung');
/*!40000 ALTER TABLE `user` ENABLE KEYS*/;
UNLOCK TABLES;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS*/;
