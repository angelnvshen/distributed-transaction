/*
Navicat MySQL Data Transfer

Source Server         : lawBest
Source Server Version : 50624
Source Host           : 172.16.252.115:3306
Source Database       : javashop_dev

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2018-05-17 13:19:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for es_regions
-- ----------------------------
DROP TABLE IF EXISTS `es_regions`;
CREATE TABLE `es_regions` (
  `region_id` int(10) NOT NULL AUTO_INCREMENT,
  `p_region_id` int(10) DEFAULT NULL,
  `region_path` varchar(255) DEFAULT NULL,
  `region_grade` int(8) DEFAULT NULL,
  `local_name` varchar(100) NOT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `cod` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`region_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3908 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of es_regions
-- ----------------------------
INSERT INTO `es_regions` VALUES ('1', '0', ',1,', '1', '北京', '', '1');
INSERT INTO `es_regions` VALUES ('2', '0', ',2,', '1', '上海', '', '1');
INSERT INTO `es_regions` VALUES ('33', '1', ',1,33,', '2', '密云县', '', '1');
INSERT INTO `es_regions` VALUES ('35', '1', ',1,35,', '2', '海淀区', '100093', '1');
INSERT INTO `es_regions` VALUES ('36', '1', ',1,36,', '2', '丰台区', '', '1');
INSERT INTO `es_regions` VALUES ('37', '1', ',1,37,', '2', '大兴区', '', '1');
INSERT INTO `es_regions` VALUES ('38', '1', ',1,38,', '2', '通州区', '', '1');
INSERT INTO `es_regions` VALUES ('39', '1', ',1,39,', '2', '平谷区', '', '1');
INSERT INTO `es_regions` VALUES ('40', '1', ',1,40,', '2', '怀柔区', '', '1');
INSERT INTO `es_regions` VALUES ('41', '1', ',1,41,', '2', '东城区', '', '1');
INSERT INTO `es_regions` VALUES ('42', '1', ',1,42,', '2', '崇文区', '', '1');
INSERT INTO `es_regions` VALUES ('43', '1', ',1,43,', '2', '石景山区', '', '1');
INSERT INTO `es_regions` VALUES ('44', '1', ',1,44,', '2', '宣武区', '', '1');
INSERT INTO `es_regions` VALUES ('45', '1', ',1,45,', '2', '延庆县', '', '1');
INSERT INTO `es_regions` VALUES ('46', '1', ',1,46,', '2', '昌平区', '', '1');
INSERT INTO `es_regions` VALUES ('47', '1', ',1,47,', '2', '门头沟区', '', '1');
INSERT INTO `es_regions` VALUES ('48', '1', ',1,48,', '2', '西城区', '', '1');
INSERT INTO `es_regions` VALUES ('49', '1', ',1,49,', '2', '房山区', '', '1');
INSERT INTO `es_regions` VALUES ('50', '1', ',1,50,', '2', '朝阳区', '', '1');
INSERT INTO `es_regions` VALUES ('51', '1', ',1,51,', '2', '顺义区', '', '1');
INSERT INTO `es_regions` VALUES ('52', '2', ',2,52,', '2', '黄浦区', '', '1');
INSERT INTO `es_regions` VALUES ('53', '2', ',2,53,', '2', '卢湾区', '', '1');
INSERT INTO `es_regions` VALUES ('54', '2', ',2,54,', '2', '徐汇区', '', '1');
INSERT INTO `es_regions` VALUES ('55', '2', ',2,55,', '2', '长宁区', '', '1');
INSERT INTO `es_regions` VALUES ('56', '2', ',2,56,', '2', '静安区', '', '1');
INSERT INTO `es_regions` VALUES ('57', '2', ',2,57,', '2', '普陀区', '', '1');
INSERT INTO `es_regions` VALUES ('58', '2', ',2,58,', '2', '闸北区', '', '1');
INSERT INTO `es_regions` VALUES ('59', '2', ',2,59,', '2', '虹口区', '', '1');
INSERT INTO `es_regions` VALUES ('60', '2', ',2,60,', '2', '杨浦区', '', '1');
INSERT INTO `es_regions` VALUES ('61', '2', ',2,61,', '2', '闵行区', '', '1');
INSERT INTO `es_regions` VALUES ('62', '2', ',2,62,', '2', '宝山区', '', '1');
INSERT INTO `es_regions` VALUES ('63', '2', ',2,63,', '2', '嘉定区', '', '1');
INSERT INTO `es_regions` VALUES ('64', '2', ',2,64,', '2', '浦东新区', '', '1');
INSERT INTO `es_regions` VALUES ('65', '2', ',2,65,', '2', '金山区', '', '1');
INSERT INTO `es_regions` VALUES ('66', '2', ',2,66,', '2', '松江区', '', '1');
INSERT INTO `es_regions` VALUES ('67', '2', ',2,67,', '2', '青浦区', '', '1');
INSERT INTO `es_regions` VALUES ('68', '2', ',2,68,', '2', '南汇区', '', '1');
INSERT INTO `es_regions` VALUES ('69', '2', ',2,69,', '2', '奉贤区', '', '1');
INSERT INTO `es_regions` VALUES ('70', '2', ',2,70,', '2', '崇明县', '', '1');
INSERT INTO `es_regions` VALUES ('451', '33', ',1,33,451,', '3', '密云县', '101505', '1');
INSERT INTO `es_regions` VALUES ('453', '35', ',1,35,453,', '3', '海淀区', '100093', '1');
INSERT INTO `es_regions` VALUES ('454', '36', ',1,36,454,', '3', '丰台区', '100072', '1');
INSERT INTO `es_regions` VALUES ('455', '37', ',1,37,455,', '3', '大兴区', '100076', '1');
INSERT INTO `es_regions` VALUES ('456', '38', ',1,38,456,', '3', '通州区', '101100', '1');
INSERT INTO `es_regions` VALUES ('457', '39', ',1,39,457,', '3', '平谷区', '101205', '1');
INSERT INTO `es_regions` VALUES ('458', '40', ',1,40,458,', '3', '怀柔区', '101402', '1');
INSERT INTO `es_regions` VALUES ('459', '41', ',1,41,459,', '3', '东城区', '100704', '1');
INSERT INTO `es_regions` VALUES ('460', '42', ',1,42,460,', '3', '崇文区', '100077', '1');
INSERT INTO `es_regions` VALUES ('461', '43', ',1,43,461,', '3', '石景山区', '100043', '1');
INSERT INTO `es_regions` VALUES ('462', '44', ',1,44,462,', '3', '宣武区', '100050', '1');
INSERT INTO `es_regions` VALUES ('463', '45', ',1,45,463,', '3', '延庆县', '102104', '1');
INSERT INTO `es_regions` VALUES ('464', '46', ',1,46,464,', '3', '昌平区', '102200', '1');
INSERT INTO `es_regions` VALUES ('465', '47', ',1,47,465,', '3', '门头沟区', '102301', '1');
INSERT INTO `es_regions` VALUES ('466', '48', ',1,48,466,', '3', '西城区', '100044', '1');
INSERT INTO `es_regions` VALUES ('467', '49', ',1,49,467,', '3', '房山区', '102503', '1');
INSERT INTO `es_regions` VALUES ('468', '50', ',1,50,468,', '3', '朝阳区', '100021', '1');
INSERT INTO `es_regions` VALUES ('469', '51', ',1,51,469,', '3', '顺义区', '101307', '1');
INSERT INTO `es_regions` VALUES ('470', '52', ',2,52,470,', '3', '黄浦区', '200001', '1');
INSERT INTO `es_regions` VALUES ('471', '53', ',2,53,471,', '3', '卢湾区', '200023', '1');
INSERT INTO `es_regions` VALUES ('472', '54', ',2,54,472,', '3', '徐汇区', '200030', '1');
INSERT INTO `es_regions` VALUES ('473', '55', ',2,55,473,', '3', '长宁区', '200050', '1');
INSERT INTO `es_regions` VALUES ('474', '56', ',2,56,474,', '3', '静安区', '200041', '1');
INSERT INTO `es_regions` VALUES ('475', '57', ',2,57,475,', '3', '普陀区', '200062', '0');
INSERT INTO `es_regions` VALUES ('476', '58', ',2,58,476,', '3', '闸北区', '200070', '1');
INSERT INTO `es_regions` VALUES ('477', '59', ',2,59,477,', '3', '虹口区', '200085', '1');
INSERT INTO `es_regions` VALUES ('478', '60', ',2,60,478,', '3', '杨浦区', '200090', '1');
INSERT INTO `es_regions` VALUES ('479', '61', ',2,61,479,', '3', '闵行区', '200240', '1');
INSERT INTO `es_regions` VALUES ('480', '62', ',2,62,480,', '3', '宝山区', '200940', '1');
INSERT INTO `es_regions` VALUES ('481', '63', ',2,63,481,', '3', '嘉定区', '201822', '1');
INSERT INTO `es_regions` VALUES ('482', '64', ',2,64,482,', '3', '浦东新区', '200122', '1');
INSERT INTO `es_regions` VALUES ('483', '65', ',2,65,483,', '3', '金山区', '200540', '1');
INSERT INTO `es_regions` VALUES ('484', '66', ',2,66,484,', '3', '松江区', '201600', '1');
INSERT INTO `es_regions` VALUES ('485', '67', ',2,67,485,', '3', '青浦区', '201700', '1');
INSERT INTO `es_regions` VALUES ('486', '68', ',2,68,486,', '3', '南汇区', '201313', '1');
INSERT INTO `es_regions` VALUES ('487', '69', ',2,69,487,', '3', '奉贤区', '201400', '1');
INSERT INTO `es_regions` VALUES ('488', '70', ',2,70,488,', '3', '崇明县', '202150', '1');
INSERT INTO `es_regions` VALUES ('495', '0', ',495,', '1', '湖北省', '430000', '0');

