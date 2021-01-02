/*
Navicat MySQL Data Transfer

Source Server         : club
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : address

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2021-01-01 15:00:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addressbook
-- ----------------------------
DROP TABLE IF EXISTS `addressbook`;
CREATE TABLE `addressbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone1` varchar(255) DEFAULT NULL,
  `phone2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `phone1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
