/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : smart_mine

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 06/03/2023 14:12:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int NOT NULL,
  `equipment_code` int DEFAULT NULL COMMENT '设备编号',
  `equipment_name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `equipment_type` varchar(255) DEFAULT NULL COMMENT '设备类型',
  `date` datetime DEFAULT NULL COMMENT '设备信息',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for measure
-- ----------------------------
DROP TABLE IF EXISTS `measure`;
CREATE TABLE `measure` (
  `id` int DEFAULT NULL,
  `measure_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '采集编号',
  `create_time` datetime DEFAULT NULL COMMENT '采集时间',
  `equipment_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '采集的设备编号',
  `data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '采集信息'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `id` int NOT NULL,
  `plan_code` varchar(255) DEFAULT NULL COMMENT '计划编号',
  `plan_time` datetime DEFAULT NULL COMMENT '计划时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `data` text COMMENT '计划信息',
  `yield` varchar(255) DEFAULT NULL COMMENT '产量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `id` int NOT NULL,
  `repair_code` varchar(255) DEFAULT NULL COMMENT '维修编号',
  `equipment_code` varchar(255) DEFAULT NULL COMMENT '设备编号',
  `repair_time` datetime DEFAULT NULL COMMENT '维修时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `repair_user` varchar(255) DEFAULT NULL COMMENT '维修人员',
  `date` datetime DEFAULT NULL COMMENT '维修信息',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `state` varchar(255) DEFAULT NULL COMMENT '维修状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for smart_lookup
-- ----------------------------
DROP TABLE IF EXISTS `smart_lookup`;
CREATE TABLE `smart_lookup` (
  `id` int NOT NULL,
  `type_name` varchar(255) DEFAULT NULL COMMENT '类型（岗位类型，部门类型）',
  `code` varchar(255) DEFAULT NULL COMMENT '类型编码',
  `code_name` varchar(255) DEFAULT NULL COMMENT '对应的名字',
  `orderno` int DEFAULT NULL COMMENT '编号',
  `time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `dept_id` bigint NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和部门关联表';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int NOT NULL,
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint DEFAULT NULL COMMENT '部门ID',
  `post_id` int DEFAULT NULL COMMENT '岗位id\n',
  `id_card` varchar(255) DEFAULT NULL COMMENT '身份证',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '密码',
  `addres` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `user_position` varchar(255) DEFAULT NULL COMMENT '定位',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) DEFAULT '' COMMENT '头像地址',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间//入职时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`,`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post` (
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `post_id` bigint NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与岗位关联表';

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int NOT NULL,
  `task_code` varchar(255) DEFAULT NULL COMMENT '任务编号',
  `task_time` datetime DEFAULT NULL COMMENT '任务时间',
  `task_type` varchar(255) DEFAULT NULL COMMENT '任务类型',
  `task_yield` varchar(255) DEFAULT NULL COMMENT '任务产量',
  `state` varchar(255) DEFAULT NULL COMMENT '任务状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for warn
-- ----------------------------
DROP TABLE IF EXISTS `warn`;
CREATE TABLE `warn` (
  `id` int DEFAULT NULL,
  `warn_code` varchar(255) DEFAULT NULL COMMENT '告警编码',
  `equipment_code` varchar(255) DEFAULT NULL COMMENT '告警设备',
  `warn_type` varchar(255) DEFAULT NULL COMMENT '告警类型',
  `warn_data` text COMMENT '告警信息',
  `create_time` datetime DEFAULT NULL COMMENT '告警时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
