/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 14/06/2022 14:43:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态->0：停用，1：启用',
  `version` int(1) NULL DEFAULT NULL COMMENT '乐观锁',
  `deleted` int(1) NULL DEFAULT NULL COMMENT '逻辑删除',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `updated_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `updated_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1535219888673660930', 'admin', 'password', 1, 1, 0, '2022-06-10 19:18:39', 'system', '2022-06-10 19:58:05', 'system');
INSERT INTO `sys_user` VALUES ('1536596276148387841', 'username', 'password', 1, 0, 0, '2022-06-14 14:27:55', 'system', '2022-06-14 14:27:55', 'system');

SET FOREIGN_KEY_CHECKS = 1;
