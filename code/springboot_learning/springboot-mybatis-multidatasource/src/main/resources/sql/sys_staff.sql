
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `sys_staff`;
CREATE TABLE `sys_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `staff_name` varchar(32) DEFAULT NULL COMMENT '员工名',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `gender` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

