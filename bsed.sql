-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bsed
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'住宅楼盘','type_landscape',''),(2,'主题商业','type_landscape',''),(3,'乡村文创旅游','type_tourism',''),(4,'民俗文化','type_tourism',''),(5,'旅游+','type_tourism',''),(6,'企业理念','type_other','以客户为中心，以创新为根本，以文化为灵魂 以创意天人合一的人居环境为理念，崇尚自然与艺术。 用心做事，真诚待人，信守承诺 在服务与技术方面，力求达到至善至美、优异卓越。 以客户为中心 ——成就客户梦想，共同发展 以创新为根本 ——创新是持续活力的源泉以文化为灵魂 ——文化是永恒的生命力'),(7,'蓝海动态','type_other',''),(8,'荣誉资质','type_other','蓝海设计集团是中国建设部园林景观乙级资质设计单位，美国景观建筑师协会（ASLA, American Society of LandscapeArchitecture）公司会员，亚洲园林景观建设国际协会(ALCA) 会员，加拿大景观设计协会会员，中国风景园林协会会员，中国景观研究协会理事单位。 荣获天府杯园林景观设计金奖、 2006最佳园林景观设计企业、 联合国人居署国际花园社区设计大奖等多项景观设计大奖'),(9,'主创团队','type_other','蓝海核心团队，秉承“创意天人合一的人居环境”的设计理念，均有行业内多年从业经验，具有资深的经历和丰富的经验，在景观设计、旅游规划、建筑装饰设计等领域均具有较强的设计能力。'),(10,'专家团队','type_other','蓝海专家团队的经验和能力覆盖了从旅游规划、城市规划，建筑设计，环境艺术，到室内设计，装置艺术，甚至空间导识设计等各个方面，是一个全方位项目专家组合。'),(11,'加入蓝海','type_other',''),(12,'合作伙伴','type_other','多年来，蓝海以独树一帜、精益求精的专业造诣获得了行业内外极高口碑，以超前理念树行业典范；同时加强与行业知名企业交流合作，强强联手，形成长期战略合作关系。'),(13,'test1','type_other','test1');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creator`
--

DROP TABLE IF EXISTS `creator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `category_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `job_title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `occupation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creator`
--

LOCK TABLES `creator` WRITE;
/*!40000 ALTER TABLE `creator` DISABLE KEYS */;
/*!40000 ALTER TABLE `creator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `category_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `news_page_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profession`
--

DROP TABLE IF EXISTS `profession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `category_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `job_title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `occupation` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profession`
--

LOCK TABLES `profession` WRITE;
/*!40000 ALTER TABLE `profession` DISABLE KEYS */;
/*!40000 ALTER TABLE `profession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `category_type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `owner` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `location` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `area` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `project_page_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,1,'type_landscape','东方人居魅力的现代中式宅邸','','2012-04-19 09:39:06','东方大院','金科股份','江阴/长沙','130000','2010-01-08 09:42:14','projectTestPage','imageTestUrl'),(2,1,'type_landscape','园中藏乾坤 江南园林大宅风景','','2012-07-21 09:39:06','置信芙蓉古城紫云园','成都置信','成都','150000','2010-01-08 09:42:14','projectTestPage','imageTestUrl'),(3,1,'type_landscape','成长互动式生活绿洲','','2016-10-17 09:39:06','成都广汇·御园','新疆广汇','成都','160000','2016-01-08 09:42:14','projectTestPage','imageTestUrl'),(4,2,'type_landscape','穿越时空的商业盛典','','2017-10-23 09:39:06','凉都里麒龙风情街','麒龙集团','六盘水','40000','2017-01-08 09:42:14','projectTestPage','imageTestUrl'),(5,3,'type_tourism','静归田园居，隐乐桃花源','荣膺第七届艾景奖“十佳景观设计奖”','2017-08-11 09:39:06','多利绿城·桃花源','多利（成都）农庄','成都市郫都区红光镇白云村','72000','2017-01-08 09:42:14','projectTestPage','imageTestUrl'),(6,4,'type_tourism','自然田园风光，泰式度假风情','自然与田园交融、低奢与国际范碰撞、原味泰式度假风情 ','2014-12-08 09:39:06','西双版纳四季国际度假区','明宇实业集团','西双版纳','270000','2014-01-08 09:42:14','projectTestPage','imageTestUrl'),(7,4,'type_tourism','夜郎牂牁江旅游景区','','2016-10-29 09:39:06','夜郎文化主题度假酒店','中国铁建','贵州','50000','2016-01-08 09:42:14','projectTestPage','imageTestUrl'),(8,5,'type_tourism','商业与艺术的升华','','2014-11-10 09:39:06','攀枝花苴却砚风情街','攀枝花金海文旅','攀枝花仁和区','30000','2014-01-08 09:42:14','projectTestPage','imageTestUrl'),(9,5,'type_tourism','生态与科技的碰撞','','2017-02-28 09:39:06','恒合工业云基地','恒合置业','德阳','130000','2016-01-08 09:42:14','projectTestPage','imageTestUrl'),(10,5,'type_tourism','园翁折梦 | 简之艺术\r\n','玄关名教，书户江山 花间碧松，溪云隐隐','2017-12-13 09:39:06','重庆房地产职业技术学院','新鸥鹏集团','重庆','150000','2011-01-08 09:42:14','projectTestPage','imageTestUrl'),(11,5,'type_tourism','芙蓉花开耀世间\r\n','','2018-01-09 22:24:55','都江堰万达国际文旅城','万达集团','都江堰','150000','2017-01-01 00:00:00','projectTestPage','imageTestUrl'),(12,1,NULL,'test1','','2018-01-09 22:49:31','test1','test1','test1','111','2012-01-01 00:00:00','projectTestPage','imageTestUrl'),(15,2,'type_landscape','test3','test3','2018-01-10 10:21:52','test3','test3','test3','12321321','2027-01-01 00:00:00','projectTestPage','imageTestUrl');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-10 12:33:36
