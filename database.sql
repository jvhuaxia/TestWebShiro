/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.19 : Database - db_shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_shiro`;

/*Table structure for table `static_permission` */

DROP TABLE IF EXISTS `static_permission`;

CREATE TABLE `static_permission` (
  `permission_id` varchar(20) NOT NULL,
  `permission_name` varchar(50) DEFAULT NULL,
  `permission_uri` varchar(256) DEFAULT NULL,
  `permission_note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `static_permission` */

insert  into `static_permission`(`permission_id`,`permission_name`,`permission_uri`,`permission_note`) values ('1','ALL_PERMISSION','/user,/index','所有权限'),('10','ANNUAL_TURNOVER_STATISTICS',NULL,'年营业额统计权限'),('11','USER_EDIT',NULL,'用户修改权限'),('12','PERMISSION_EDIT',NULL,'修改权限权限'),('13','ROLE_EDIT',NULL,'角色管理'),('2','REGISTRATION',NULL,'挂号权限'),('3','DOCTOR_EDIT',NULL,'修改医生权限'),('4','MEDICINE_EDIT',NULL,'修改药品权限'),('5','HOSPITALIZATION_EDIT',NULL,'修改住院权限'),('6','PAY_SERVICE_EDIT',NULL,'修改收费项目权限'),('7','SELLING_MEDICINE_EDIT',NULL,'医院卖药权限'),('8','HOSPITALIZATION_BALANCE_EDIT',NULL,'住院结算权限'),('9','MONTHLY_TURNOVER_STATISTICS',NULL,'月营业额统计权限');

/*Table structure for table `static_role` */

DROP TABLE IF EXISTS `static_role`;

CREATE TABLE `static_role` (
  `role_id` varchar(20) NOT NULL,
  `role_name` varchar(20) DEFAULT NULL,
  `role_note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `static_role` */

insert  into `static_role`(`role_id`,`role_name`,`role_note`) values ('1','SUPER_MANAGER','超级管理员'),('2','MANAGER','管理员');

/*Table structure for table `static_role_permission` */

DROP TABLE IF EXISTS `static_role_permission`;

CREATE TABLE `static_role_permission` (
  `role_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) DEFAULT NULL,
  `permission_id` varchar(20) DEFAULT NULL,
  `role_permission_note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_permission_id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`),
  CONSTRAINT `static_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `static_role` (`role_id`),
  CONSTRAINT `static_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `static_permission` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `static_role_permission` */

insert  into `static_role_permission`(`role_permission_id`,`role_id`,`permission_id`,`role_permission_note`) values (1,'1','1','超级管理员'),(2,'2','3',NULL),(3,'2','4',NULL),(4,'2','5',NULL),(5,'2','1','Super Manager'),(6,'2','2','AA');

/*Table structure for table `static_user` */

DROP TABLE IF EXISTS `static_user`;

CREATE TABLE `static_user` (
  `user_id` varchar(20) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `last_sign_time` datetime DEFAULT NULL,
  `signstate` int(11) DEFAULT NULL,
  `ticke_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `static_user` */

insert  into `static_user`(`user_id`,`user_name`,`user_password`,`last_sign_time`,`signstate`,`ticke_id`) values ('A0001','Admin','admin','2018-05-07 17:55:19',1,NULL),('A0002','Manager','admin','2019-01-03 16:14:28',1,NULL);

/*Table structure for table `static_user_role` */

DROP TABLE IF EXISTS `static_user_role`;

CREATE TABLE `static_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `role_id` varchar(20) DEFAULT NULL,
  `user_role_note` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `static_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `static_user` (`user_id`),
  CONSTRAINT `static_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `static_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `static_user_role` */

insert  into `static_user_role`(`user_role_id`,`user_id`,`role_id`,`user_role_note`) values (1,'A0001','1','超级管理员'),(2,'A0002','2','普通管理员');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
