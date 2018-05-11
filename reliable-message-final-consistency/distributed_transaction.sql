/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : distributed_transaction

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-11 11:37:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rp_account
-- ----------------------------
DROP TABLE IF EXISTS `rp_account`;
CREATE TABLE `rp_account` (
  `id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `edit_time` datetime DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `account_no` varchar(50) NOT NULL,
  `balance` decimal(20,6) NOT NULL,
  `unbalance` decimal(20,6) NOT NULL,
  `security_money` decimal(20,6) NOT NULL,
  `status` varchar(36) NOT NULL,
  `total_income` decimal(20,6) NOT NULL,
  `total_expend` decimal(20,6) NOT NULL,
  `today_income` decimal(20,6) NOT NULL,
  `today_expend` decimal(20,6) NOT NULL,
  `account_type` varchar(50) NOT NULL,
  `sett_amount` decimal(20,6) NOT NULL,
  `user_no` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户表';

-- ----------------------------
-- Records of rp_account
-- ----------------------------
INSERT INTO `rp_account` VALUES ('1715f68276d54027b405bd99d4641cc6', '2016-07-21 01:06:51', '2016-09-17 17:54:12', '0', null, '99992016072100000004', '0.000000', '0.000000', '0.000000', 'ACTIVE', '0.000000', '0.000000', '0.000000', '0.000000', '0', '0.000000', '88882016072100000004');
INSERT INTO `rp_account` VALUES ('20b7c1ce75644da6b044437db217ee59', '2016-07-19 16:55:09', '2016-09-17 17:54:12', '0', null, '99992016071900000003', '0.000000', '0.000000', '0.000000', 'ACTIVE', '0.000000', '0.000000', '0.000000', '0.000000', '0', '0.000000', '88882016071900000003');
INSERT INTO `rp_account` VALUES ('77842f563a6b4b918b6955b5f07b583c', '2016-07-24 20:21:45', '2016-09-17 17:54:12', '0', null, '99992016072400000007', '0.000000', '0.000000', '0.000000', 'ACTIVE', '0.000000', '0.000000', '0.000000', '0.000000', '0', '0.000000', '88882016072400000007');
INSERT INTO `rp_account` VALUES ('a34b5b788c884dadbd640c52b4d7be61', '2016-07-24 20:20:26', '2016-09-17 17:54:12', '0', null, '99992016072400000006', '0.000000', '0.000000', '0.000000', 'ACTIVE', '0.000000', '0.000000', '0.000000', '0.000000', '0', '0.000000', '88882016072400000006');
INSERT INTO `rp_account` VALUES ('f79ae95111f6405887b41d000e793552', '2016-07-22 15:56:26', '2016-09-17 17:54:12', '0', null, '99992016072200000005', '0.000000', '0.000000', '0.000000', 'ACTIVE', '0.000000', '0.000000', '0.000000', '0.000000', '0', '0.000000', '88882016072200000005');

-- ----------------------------
-- Table structure for rp_accounting_voucher
-- ----------------------------
DROP TABLE IF EXISTS `rp_accounting_voucher`;
CREATE TABLE `rp_accounting_voucher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `edit_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `entry_type` smallint(6) NOT NULL COMMENT '会计分录类型',
  `request_no` varchar(32) NOT NULL COMMENT '请求号',
  `from_system` smallint(6) NOT NULL COMMENT '来源系统',
  `voucher_no` varchar(32) DEFAULT NULL COMMENT '原始凭证号',
  `accounting_date` date DEFAULT NULL COMMENT '会计日期',
  `bank_change_amount` decimal(24,10) DEFAULT NULL COMMENT '平台银行帐户变动金额',
  `payer_account_no` varchar(20) DEFAULT NULL COMMENT '付款方账号',
  `receiver_account_no` varchar(20) DEFAULT NULL COMMENT '收款方账号',
  `bank_account` varchar(20) DEFAULT NULL COMMENT '银行账户',
  `bank_channel_code` varchar(32) DEFAULT NULL COMMENT '银行渠道编码',
  `payer_change_amount` decimal(24,10) DEFAULT NULL COMMENT '付款方账户变动金额',
  `receiver_change_amount` decimal(24,10) DEFAULT NULL COMMENT '收款方账户变动金额',
  `profit` decimal(24,10) DEFAULT NULL COMMENT '利润',
  `income` decimal(24,10) DEFAULT NULL COMMENT '收入',
  `cost` decimal(24,10) DEFAULT NULL COMMENT '成本',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `bank_order_no` varchar(32) DEFAULT NULL COMMENT '银行订单号',
  `payer_account_type` smallint(6) DEFAULT NULL COMMENT '付款方帐户类型',
  `pay_amount` decimal(20,6) DEFAULT NULL COMMENT '支付金额',
  `receiver_account_type` smallint(6) DEFAULT NULL COMMENT '收款方帐户类型',
  `receiver_fee` decimal(20,6) DEFAULT NULL COMMENT '收款方手续费',
  `payer_fee` decimal(20,6) DEFAULT NULL COMMENT '付款方手续费',
  PRIMARY KEY (`id`),
  UNIQUE KEY `REQUEST_NOTE_UKEY` (`entry_type`,`voucher_no`,`from_system`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会计原始凭证表';

-- ----------------------------
-- Records of rp_accounting_voucher
-- ----------------------------

-- ----------------------------
-- Table structure for rp_account_history
-- ----------------------------
DROP TABLE IF EXISTS `rp_account_history`;
CREATE TABLE `rp_account_history` (
  `id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `edit_time` datetime DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `account_no` varchar(50) NOT NULL,
  `amount` decimal(20,6) NOT NULL,
  `balance` decimal(20,6) NOT NULL,
  `fund_direction` varchar(36) NOT NULL,
  `is_allow_sett` varchar(36) NOT NULL,
  `is_complete_sett` varchar(36) NOT NULL,
  `request_no` varchar(36) NOT NULL,
  `bank_trx_no` varchar(50) DEFAULT NULL,
  `trx_type` varchar(36) NOT NULL,
  `risk_day` int(11) DEFAULT NULL,
  `user_no` varchar(50) DEFAULT NULL,
  `status` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金账户流水表';

-- ----------------------------
-- Records of rp_account_history
-- ----------------------------

-- ----------------------------
-- Table structure for rp_notify_record
-- ----------------------------
DROP TABLE IF EXISTS `rp_notify_record`;
CREATE TABLE `rp_notify_record` (
  `id` varchar(50) NOT NULL,
  `version` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `editor` varchar(100) DEFAULT NULL COMMENT '修改者',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `edit_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `notify_times` int(11) NOT NULL,
  `limit_notify_times` int(11) NOT NULL,
  `url` varchar(2000) NOT NULL,
  `merchant_order_no` varchar(50) NOT NULL,
  `merchant_no` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL COMMENT '100:成功 101:失败',
  `notify_type` varchar(30) DEFAULT NULL COMMENT '通知类型',
  PRIMARY KEY (`id`),
  KEY `AK_KEY_2` (`merchant_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知记录表 RP_NOTIFY_RECORD';

-- ----------------------------
-- Records of rp_notify_record
-- ----------------------------

-- ----------------------------
-- Table structure for rp_notify_record_log
-- ----------------------------
DROP TABLE IF EXISTS `rp_notify_record_log`;
CREATE TABLE `rp_notify_record_log` (
  `id` varchar(50) NOT NULL,
  `version` int(11) NOT NULL,
  `editor` varchar(100) DEFAULT NULL COMMENT '修改者',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `edit_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime NOT NULL,
  `notify_id` varchar(50) NOT NULL,
  `request` varchar(2000) NOT NULL,
  `response` varchar(2000) NOT NULL,
  `merchant_no` varchar(50) NOT NULL,
  `merchant_order_no` varchar(50) NOT NULL COMMENT '商户订单号',
  `http_status` varchar(50) NOT NULL COMMENT 'HTTP状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知记录日志表 RP_NOTIFY_RECORD_LOG';

-- ----------------------------
-- Records of rp_notify_record_log
-- ----------------------------

-- ----------------------------
-- Table structure for rp_pay_product
-- ----------------------------
DROP TABLE IF EXISTS `rp_pay_product`;
CREATE TABLE `rp_pay_product` (
  `id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `edit_time` datetime DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `status` varchar(36) NOT NULL,
  `product_code` varchar(50) NOT NULL COMMENT '支付产品编号',
  `product_name` varchar(200) NOT NULL COMMENT '支付产品名称',
  `audit_status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付产品表';

-- ----------------------------
-- Records of rp_pay_product
-- ----------------------------
INSERT INTO `rp_pay_product` VALUES ('5ac23e853c454edcb2bf51624bdbc194', '2016-07-19 17:53:12', '2016-07-19 17:58:21', '0', 'ACTIVE', 'RonCooPay', '龙果支付', 'YES');
INSERT INTO `rp_pay_product` VALUES ('7e496b1206714527863fa2cf3f836db5', '2016-07-19 18:51:38', '2016-07-21 16:39:58', '0', 'ACTIVE', 'RC', 'RC', 'YES');
INSERT INTO `rp_pay_product` VALUES ('ec7502bbf1894cb69ede121433594285', '2016-09-17 18:08:50', '2016-09-17 18:09:16', '0', 'UNACTIVE', 'BBB', 'BBB', 'NO');

-- ----------------------------
-- Table structure for rp_pay_way
-- ----------------------------
DROP TABLE IF EXISTS `rp_pay_way`;
CREATE TABLE `rp_pay_way` (
  `ID` varchar(50) NOT NULL COMMENT 'ID',
  `version` bigint(20) NOT NULL DEFAULT '0' COMMENT 'version',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `pay_way_code` varchar(50) NOT NULL COMMENT '支付方式编号',
  `pay_way_name` varchar(100) NOT NULL COMMENT '支付方式名称',
  `pay_type_code` varchar(50) NOT NULL COMMENT '支付类型编号',
  `pay_type_name` varchar(100) NOT NULL COMMENT '支付类型名称',
  `pay_product_code` varchar(50) DEFAULT NULL COMMENT '支付产品编号',
  `status` varchar(36) NOT NULL COMMENT '状态(100:正常状态,101非正常状态)',
  `sorts` int(11) DEFAULT '1000' COMMENT '排序(倒序排序,默认值1000)',
  `pay_rate` double NOT NULL COMMENT '商户支付费率',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付方式';

-- ----------------------------
-- Records of rp_pay_way
-- ----------------------------
INSERT INTO `rp_pay_way` VALUES ('1431d5a280fc4c51afcfbca9f32822d8', '0', '2016-07-19 17:53:52', null, 'WEIXIN', '微信', 'SCANPAY', '扫码支付', 'RonCooPay', 'ACTIVE', null, '0.8');
INSERT INTO `rp_pay_way` VALUES ('3ee734a9ed68405c89ead08683cad6c7', '0', '2016-09-17 18:09:05', '2016-09-17 18:09:10', 'TEST_PAY', '测试模拟支付', 'TEST_PAY', '测试模拟支付', 'BBB', 'UNACTIVE', null, '9');
INSERT INTO `rp_pay_way` VALUES ('a4af58b75b3e40c4bd38ac647e27800f', '0', '2016-07-19 18:51:52', null, 'TEST_PAY', '测试模拟支付', 'TEST_PAY', '测试模拟支付', 'RC', 'ACTIVE', null, '0.8');
INSERT INTO `rp_pay_way` VALUES ('c5cdda3d8f1e47bca9ac96ffb2ea17b1', '0', '2016-07-19 17:54:16', '2016-07-19 17:54:25', 'ALIPAY', '支付宝', 'DIRECT_PAY', '即时到账', 'RonCooPay', 'ACTIVE', null, '0.8');
INSERT INTO `rp_pay_way` VALUES ('db522b1446ff4dc2bd6fcd73bc1f3423', '0', '2016-07-21 16:39:51', null, 'TEST_PAY_HTTP_CLIENT', '测试模拟httpclient支付', 'TEST_PAY_HTTP_CLIENT', '测试模拟httpclient支付', 'RC', 'ACTIVE', null, '0.8');
INSERT INTO `rp_pay_way` VALUES ('dcda9a88435e47b3b6d24df2c6358be1', '0', '2016-07-19 18:52:41', null, 'ALIPAY', '支付宝', 'DIRECT_PAY', '即时到账', 'RC', 'ACTIVE', null, '0.8');
INSERT INTO `rp_pay_way` VALUES ('ff242c5f9c3e4ea7a857860e57f6ddd4', '0', '2016-07-19 18:52:29', null, 'WEIXIN', '微信', 'SCANPAY', '扫码支付', 'RC', 'ACTIVE', null, '0.8');

-- ----------------------------
-- Table structure for rp_trade_payment_order
-- ----------------------------
DROP TABLE IF EXISTS `rp_trade_payment_order`;
CREATE TABLE `rp_trade_payment_order` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `editor` varchar(100) DEFAULT NULL COMMENT '修改者',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `edit_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `status` varchar(50) DEFAULT NULL COMMENT '状态(参考枚举:OrderStatusEnum)',
  `product_name` varchar(300) DEFAULT NULL COMMENT '商品名称',
  `merchant_order_no` varchar(30) NOT NULL COMMENT '商户订单号',
  `order_amount` decimal(20,6) DEFAULT '0.000000' COMMENT '订单金额',
  `order_from` varchar(30) DEFAULT NULL COMMENT '订单来源',
  `merchant_name` varchar(100) DEFAULT NULL COMMENT '商家名称',
  `merchant_no` varchar(100) NOT NULL COMMENT '商户编号',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `order_date` date DEFAULT NULL COMMENT '下单日期',
  `order_ip` varchar(50) DEFAULT NULL COMMENT '下单IP(客户端IP,在网关页面获取)',
  `order_referer_url` varchar(100) DEFAULT NULL COMMENT '从哪个页面链接过来的(可用于防诈骗)',
  `return_url` varchar(600) DEFAULT NULL COMMENT '页面回调通知URL',
  `notify_url` varchar(600) DEFAULT NULL COMMENT '后台异步通知URL',
  `cancel_reason` varchar(600) DEFAULT NULL COMMENT '订单撤销原因',
  `order_period` smallint(6) DEFAULT NULL COMMENT '订单有效期(单位分钟)',
  `expire_time` datetime DEFAULT NULL COMMENT '到期时间',
  `pay_way_code` varchar(50) DEFAULT NULL COMMENT '支付通道编号',
  `pay_way_name` varchar(100) DEFAULT NULL COMMENT '支付通道名称',
  `remark` varchar(200) DEFAULT NULL COMMENT '支付备注',
  `trx_type` varchar(30) DEFAULT NULL COMMENT '交易业务类型  ：消费、充值等',
  `pay_type_code` varchar(50) DEFAULT NULL COMMENT '支付方式类型编号',
  `pay_type_name` varchar(100) DEFAULT NULL COMMENT '支付方式类型名称',
  `fund_into_type` varchar(30) DEFAULT NULL COMMENT '资金流入类型',
  `is_refund` varchar(30) DEFAULT '101' COMMENT '是否退款(100:是,101:否,默认值为:101)',
  `refund_times` int(11) DEFAULT '0' COMMENT '退款次数(默认值为:0)',
  `success_refund_amount` decimal(20,6) DEFAULT NULL COMMENT '成功退款总金额',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  `field4` varchar(500) DEFAULT NULL,
  `field5` varchar(500) DEFAULT NULL,
  `trx_no` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_KEY_2` (`merchant_order_no`,`merchant_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='roncoo pay 龙果支付 支付订单表';

-- ----------------------------
-- Records of rp_trade_payment_order
-- ----------------------------

-- ----------------------------
-- Table structure for rp_trade_payment_record
-- ----------------------------
DROP TABLE IF EXISTS `rp_trade_payment_record`;
CREATE TABLE `rp_trade_payment_record` (
  `id` varchar(50) NOT NULL COMMENT 'ID',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(30) DEFAULT NULL COMMENT '状态(参考枚举:PaymentRecordStatusEnum)',
  `editor` varchar(100) DEFAULT NULL COMMENT '修改者',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `edit_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `product_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `merchant_order_no` varchar(50) NOT NULL COMMENT '商户订单号',
  `trx_no` varchar(50) NOT NULL COMMENT '支付流水号',
  `bank_order_no` varchar(50) DEFAULT NULL COMMENT '银行订单号',
  `bank_trx_no` varchar(50) DEFAULT NULL COMMENT '银行流水号',
  `merchant_name` varchar(300) DEFAULT NULL COMMENT '商家名称',
  `merchant_no` varchar(50) NOT NULL COMMENT '商家编号',
  `payer_user_no` varchar(50) DEFAULT NULL COMMENT '付款人编号',
  `payer_name` varchar(60) DEFAULT NULL COMMENT '付款人名称',
  `payer_pay_amount` decimal(20,6) DEFAULT '0.000000' COMMENT '付款方支付金额',
  `payer_fee` decimal(20,6) DEFAULT '0.000000' COMMENT '付款方手续费',
  `payer_account_type` varchar(30) DEFAULT NULL COMMENT '付款方账户类型(参考账户类型枚举:AccountTypeEnum)',
  `receiver_user_no` varchar(15) DEFAULT NULL COMMENT '收款人编号',
  `receiver_name` varchar(60) DEFAULT NULL COMMENT '收款人名称',
  `receiver_pay_amount` decimal(20,6) DEFAULT '0.000000' COMMENT '收款方支付金额',
  `receiver_fee` decimal(20,6) DEFAULT '0.000000' COMMENT '收款方手续费',
  `receiver_account_type` varchar(30) DEFAULT NULL COMMENT '收款方账户类型(参考账户类型枚举:AccountTypeEnum)',
  `order_ip` varchar(30) DEFAULT NULL COMMENT '下单IP(客户端IP,从网关中获取)',
  `order_referer_url` varchar(100) DEFAULT NULL COMMENT '从哪个页面链接过来的(可用于防诈骗)',
  `order_amount` decimal(20,6) DEFAULT '0.000000' COMMENT '订单金额',
  `plat_income` decimal(20,6) DEFAULT NULL COMMENT '平台收入',
  `fee_rate` decimal(20,6) DEFAULT NULL COMMENT '费率',
  `plat_cost` decimal(20,6) DEFAULT NULL COMMENT '平台成本',
  `plat_profit` decimal(20,6) DEFAULT NULL COMMENT '平台利润',
  `return_url` varchar(600) DEFAULT NULL COMMENT '页面回调通知URL',
  `notify_url` varchar(600) DEFAULT NULL COMMENT '后台异步通知URL',
  `pay_way_code` varchar(50) DEFAULT NULL COMMENT '支付通道编号',
  `pay_way_name` varchar(100) DEFAULT NULL COMMENT '支付通道名称',
  `pay_success_time` datetime DEFAULT NULL COMMENT '支付成功时间',
  `complete_time` datetime DEFAULT NULL COMMENT '完成时间',
  `is_refund` varchar(30) DEFAULT '101' COMMENT '是否退款(100:是,101:否,默认值为:101)',
  `refund_times` int(11) DEFAULT '0' COMMENT '退款次数(默认值为:0)',
  `success_refund_amount` decimal(20,6) DEFAULT NULL COMMENT '成功退款总金额',
  `trx_type` varchar(30) DEFAULT NULL COMMENT '交易业务类型  ：消费、充值等',
  `order_from` varchar(30) DEFAULT NULL COMMENT '订单来源',
  `pay_type_code` varchar(50) DEFAULT NULL COMMENT '支付方式类型编号',
  `pay_type_name` varchar(100) DEFAULT NULL COMMENT '支付方式类型名称',
  `fund_into_type` varchar(30) DEFAULT NULL COMMENT '资金流入类型',
  `remark` varchar(3000) DEFAULT NULL COMMENT '备注',
  `field1` varchar(500) DEFAULT NULL,
  `field2` varchar(500) DEFAULT NULL,
  `field3` varchar(500) DEFAULT NULL,
  `field4` varchar(500) DEFAULT NULL,
  `field5` varchar(500) DEFAULT NULL,
  `bank_return_msg` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付记录表';

-- ----------------------------
-- Records of rp_trade_payment_record
-- ----------------------------

-- ----------------------------
-- Table structure for rp_transaction_message
-- ----------------------------
DROP TABLE IF EXISTS `rp_transaction_message`;
CREATE TABLE `rp_transaction_message` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '主键ID',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `editor` varchar(100) DEFAULT NULL COMMENT '修改者',
  `creater` varchar(100) DEFAULT NULL COMMENT '创建者',
  `edit_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `message_id` varchar(50) NOT NULL DEFAULT '' COMMENT '消息ID',
  `message_body` longtext NOT NULL COMMENT '消息内容',
  `message_data_type` varchar(50) DEFAULT NULL COMMENT '消息数据类型',
  `consumer_queue` varchar(100) NOT NULL DEFAULT '' COMMENT '消费队列',
  `message_send_times` smallint(6) NOT NULL DEFAULT '0' COMMENT '消息重发次数',
  `areadly_dead` varchar(20) NOT NULL DEFAULT '' COMMENT '是否死亡',
  `status` varchar(20) NOT NULL DEFAULT '' COMMENT '状态',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `field1` varchar(200) DEFAULT NULL COMMENT '扩展字段1',
  `field2` varchar(200) DEFAULT NULL COMMENT '扩展字段2',
  `field3` varchar(200) DEFAULT NULL COMMENT '扩展字段3',
  PRIMARY KEY (`id`),
  KEY `AK_Key_2` (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rp_transaction_message
-- ----------------------------

-- ----------------------------
-- Table structure for rp_user_info
-- ----------------------------
DROP TABLE IF EXISTS `rp_user_info`;
CREATE TABLE `rp_user_info` (
  `id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `status` varchar(36) NOT NULL,
  `user_no` varchar(50) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `account_no` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_Key_2` (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='该表用来存放用户的基本信息';

-- ----------------------------
-- Records of rp_user_info
-- ----------------------------
INSERT INTO `rp_user_info` VALUES ('0101ff47cd1f43a5b6a52144e9a78e30', '2016-07-24 20:20:26', 'ACTIVE', '88882016072400000006', 'hpt', '99992016072400000006');
INSERT INTO `rp_user_info` VALUES ('0764455933ce43a093bbe0f60867ee91', '2016-07-22 15:56:26', 'ACTIVE', '88882016072200000005', 'Along', '99992016072200000005');
INSERT INTO `rp_user_info` VALUES ('18fee8f2fafe4251a5aa2e95e30dc126', '2016-07-21 01:06:51', 'ACTIVE', '88882016072100000004', 'wusc', '99992016072100000004');
INSERT INTO `rp_user_info` VALUES ('64b098ee76574c5681710b47d10bcd64', '2016-07-24 20:21:45', 'ACTIVE', '88882016072400000007', 'leslie', '99992016072400000007');
INSERT INTO `rp_user_info` VALUES ('c48f5ac8024a4547878b5708b311215c', '2016-07-19 16:55:09', 'ACTIVE', '88882016071900000003', 'roncoo', '99992016071900000003');

-- ----------------------------
-- Table structure for rp_user_pay_config
-- ----------------------------
DROP TABLE IF EXISTS `rp_user_pay_config`;
CREATE TABLE `rp_user_pay_config` (
  `id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `edit_time` datetime DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` varchar(36) NOT NULL,
  `audit_status` varchar(45) DEFAULT NULL,
  `is_auto_sett` varchar(36) NOT NULL DEFAULT 'NO',
  `product_code` varchar(50) NOT NULL COMMENT '支付产品编号',
  `product_name` varchar(200) NOT NULL COMMENT '支付产品名称',
  `user_no` varchar(50) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `risk_day` int(11) DEFAULT NULL,
  `pay_key` varchar(50) DEFAULT NULL,
  `fund_into_type` varchar(50) DEFAULT NULL,
  `pay_secret` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付设置表';

-- ----------------------------
-- Records of rp_user_pay_config
-- ----------------------------
INSERT INTO `rp_user_pay_config` VALUES ('2a7f8f1c8ebf4379a42a6f88b8b8bc56', '2016-07-22 15:57:40', null, '0', null, 'ACTIVE', 'YES', 'NO', 'RC', 'RC', '88882016072100000004', 'wusc', '1', '8ba459f55ff04f39b0128a3cb4a48f2b', 'PLAT_RECEIVES', '3e2ca2eb1f024570b241d65eb4832c37');
INSERT INTO `rp_user_pay_config` VALUES ('3eef704ce6ef4f27b39f8b9ba1af71e4', '2016-07-24 20:22:48', null, '0', null, 'ACTIVE', 'YES', 'NO', 'RC', 'RC', '88882016072400000007', 'leslie', '1', '93d1ea2f9f3b448994f39d6efc7746ef', 'PLAT_RECEIVES', 'fad7ea79810c4af7a973c091aa7c6143');
INSERT INTO `rp_user_pay_config` VALUES ('8d5a1884969a4bf68dc9c19b7a0bdc18', '2016-07-22 15:56:57', null, '0', null, 'ACTIVE', 'YES', 'NO', 'RC', 'RC', '88882016072200000005', 'Along', '1', 'abcf900288114d5fa7fde764966eb2ff', 'PLAT_RECEIVES', 'd94d7c2d56eb4b06828cf746c8be17e6');
INSERT INTO `rp_user_pay_config` VALUES ('c101c24326554b848f0f497234f129d7', '2016-07-19 17:59:38', '2016-07-21 16:40:17', '0', null, 'ACTIVE', 'YES', 'NO', 'RC', 'RC', '88882016071900000003', 'roncoo', '1', '4c52295065654407b42797cda80dd07d', 'PLAT_RECEIVES', '6606353e0dab4f7b9a723f2d3e3276b7');
INSERT INTO `rp_user_pay_config` VALUES ('e510d10eed13497d9fafb492688d09d3', '2016-07-24 20:23:11', null, '0', null, 'ACTIVE', 'YES', 'NO', 'RC', 'RC', '88882016072400000006', 'hpt', '1', 'ca6577dff6d647ac882dfb405ceda21e', 'PLAT_RECEIVES', '1b8da6c9b7544856955fcff6bf920f84');

-- ----------------------------
-- Table structure for rp_user_pay_info
-- ----------------------------
DROP TABLE IF EXISTS `rp_user_pay_info`;
CREATE TABLE `rp_user_pay_info` (
  `id_` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `edit_time` datetime DEFAULT NULL,
  `version` bigint(20) NOT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `status` varchar(36) NOT NULL,
  `app_id` varchar(50) NOT NULL,
  `app_sectet` varchar(100) DEFAULT NULL,
  `merchant_id` varchar(50) DEFAULT NULL,
  `app_type` varchar(50) DEFAULT NULL,
  `user_no` varchar(50) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `partner_key` varchar(100) DEFAULT NULL,
  `pay_way_code` varchar(50) NOT NULL COMMENT '支付方式编号',
  `pay_way_name` varchar(100) NOT NULL COMMENT '支付方式名称',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='该表用来存放用户开通的第三方支付信息';

-- ----------------------------
-- Records of rp_user_pay_info
-- ----------------------------
INSERT INTO `rp_user_pay_info` VALUES ('04a257f258f74d4eb8a2182b627a199f', '2016-07-24 20:22:48', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072400000007', 'leslie', '', 'WEIXIN', '微信');
INSERT INTO `rp_user_pay_info` VALUES ('1834040201214f9a8ca0557045fc7c72', '2016-07-24 20:23:11', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072400000006', 'hpt', '', 'ALIPAY', '支付宝');
INSERT INTO `rp_user_pay_info` VALUES ('45ecd39829cb4c009ad9c5a1153cbd57', '2016-07-22 15:56:57', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072200000005', 'Along', '', 'WEIXIN', '微信');
INSERT INTO `rp_user_pay_info` VALUES ('4821fb3f63db4f58a0fc75a91a38bc04', '2016-07-22 15:57:40', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072100000004', 'wusc', '', 'WEIXIN', '微信');
INSERT INTO `rp_user_pay_info` VALUES ('4ee1f39ecb0544e792ef5d5df6ec6fb2', '2016-07-24 20:23:11', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072400000006', 'hpt', '', 'WEIXIN', '微信');
INSERT INTO `rp_user_pay_info` VALUES ('52bca84256154c588d2952b34a68dad4', '2016-07-22 15:56:57', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072200000005', 'Along', '', 'ALIPAY', '支付宝');
INSERT INTO `rp_user_pay_info` VALUES ('8a23a87d6afb425cb8974110bb015f06', '2016-07-22 15:57:40', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072100000004', 'wusc', '', 'ALIPAY', '支付宝');
INSERT INTO `rp_user_pay_info` VALUES ('8f3064039e8241029b71be1b8a9be7ce', '2016-07-19 17:59:38', '2016-07-21 16:40:17', '0', null, 'ACTIVE', '', null, '', null, '88882016071900000003', 'roncoo', '', 'ALIPAY', '支付宝');
INSERT INTO `rp_user_pay_info` VALUES ('981cd025a111452cafb9c103c5df0f9d', '2016-07-24 20:22:48', null, '0', null, 'ACTIVE', '', null, '', null, '88882016072400000007', 'leslie', '', 'ALIPAY', '支付宝');
INSERT INTO `rp_user_pay_info` VALUES ('d6ecaedb883149a28356d2510b711793', '2016-07-19 17:59:38', '2016-07-21 16:40:17', '0', null, 'ACTIVE', '', null, '', null, '88882016071900000003', 'roncoo', '', 'WEIXIN', '微信');

-- ----------------------------
-- Table structure for seq_table
-- ----------------------------
DROP TABLE IF EXISTS `seq_table`;
CREATE TABLE `seq_table` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `CURRENT_VALUE` bigint(20) NOT NULL DEFAULT '1000000002',
  `INCREMENT` smallint(6) NOT NULL DEFAULT '1',
  `REMARK` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seq_table
-- ----------------------------
INSERT INTO `seq_table` VALUES ('ACCOUNTING_REQUEST_NO_SEQ', '1000000001', '1', '会计--请求号自增序列');
INSERT INTO `seq_table` VALUES ('BANK_ORDER_NO_SEQ', '1000000001', '1', '银行订单号');
INSERT INTO `seq_table` VALUES ('TRX_NO_SEQ', '1000000003', '1', '支付流水号序列');

-- ----------------------------
-- Function structure for FUN_DATE_ADD
-- ----------------------------
DROP FUNCTION IF EXISTS `FUN_DATE_ADD`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `FUN_DATE_ADD`(STR_DATE VARCHAR(10), STR_INTERVAL INTEGER) RETURNS date
BEGIN
     RETURN date_add(STR_DATE, INTERVAL STR_INTERVAL DAY);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for FUN_NOW
-- ----------------------------
DROP FUNCTION IF EXISTS `FUN_NOW`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `FUN_NOW`() RETURNS datetime
BEGIN 
		RETURN now();
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for FUN_SEQ
-- ----------------------------
DROP FUNCTION IF EXISTS `FUN_SEQ`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `FUN_SEQ`(SEQ VARCHAR(50)) RETURNS bigint(20)
BEGIN
     UPDATE SEQ_TABLE
     SET CURRENT_VALUE = CURRENT_VALUE + INCREMENT
     WHERE  SEQ_NAME=SEQ;
     RETURN FUN_SEQ_CURRENT_VALUE(SEQ);
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for FUN_SEQ_CURRENT_VALUE
-- ----------------------------
DROP FUNCTION IF EXISTS `FUN_SEQ_CURRENT_VALUE`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `FUN_SEQ_CURRENT_VALUE`(SEQ VARCHAR(50)) RETURNS bigint(20)
BEGIN
    DECLARE VALUE INTEGER;
    SET VALUE=0;
    SELECT CURRENT_VALUE INTO VALUE
    FROM SEQ_TABLE 
    WHERE SEQ_NAME=SEQ;
    RETURN VALUE;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for FUN_SEQ_SET_VALUE
-- ----------------------------
DROP FUNCTION IF EXISTS `FUN_SEQ_SET_VALUE`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `FUN_SEQ_SET_VALUE`(SEQ VARCHAR(50), VALUE INTEGER) RETURNS bigint(20)
BEGIN
     UPDATE SEQ_TABLE 
     SET CURRENT_VALUE=VALUE
     WHERE SEQ_NAME=SEQ;
     RETURN FUN_SEQ_CURRENT_VALUE(SEQ);
END
;;
DELIMITER ;
