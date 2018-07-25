/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-07-26 00:26:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `hobby` varchar(100) DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '子', '10', '甲');
INSERT INTO `tbl_user` VALUES ('2', '丑', '11', '乙');
INSERT INTO `tbl_user` VALUES ('3', '寅', '12', '丙');
INSERT INTO `tbl_user` VALUES ('4', '卯', '13', '丁');
INSERT INTO `tbl_user` VALUES ('5', '辰', '14', '戊');
INSERT INTO `tbl_user` VALUES ('6', '巳', '15', '己');
INSERT INTO `tbl_user` VALUES ('7', '午', '16', '庚');
INSERT INTO `tbl_user` VALUES ('8', '未', '17', '辛');
INSERT INTO `tbl_user` VALUES ('9', '申', '18', '壬');
INSERT INTO `tbl_user` VALUES ('10', '酉', '19', '癸');
INSERT INTO `tbl_user` VALUES ('11', '戌', '20', '甲');
INSERT INTO `tbl_user` VALUES ('12', '亥', '21', '乙');
