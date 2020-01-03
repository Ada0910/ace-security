/*
Navicat MySQL Data Transfer

Source Server         : Ada
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : ag_admin_v1

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2020-01-03 10:53:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_element
-- ----------------------------
DROP TABLE IF EXISTS `base_element`;
CREATE TABLE `base_element` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '资源编码',
  `type` varchar(255) DEFAULT NULL COMMENT '资源类型',
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `uri` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `menu_id` varchar(255) DEFAULT NULL COMMENT '资源关联菜单',
  `parent_id` varchar(255) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL COMMENT '资源树状检索路径',
  `method` varchar(10) DEFAULT NULL COMMENT '资源请求类型',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_element
-- ----------------------------
INSERT INTO `base_element` VALUES ('3', 'userManager:btn_add', 'button', '新增', '/admin/user', '1', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('4', 'userManager:btn_edit', 'button', '编辑', '/admin/user/{*}', '1', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('5', 'userManager:btn_del', 'button', '删除', '/admin/user/{*}', '1', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('9', 'menuManager:element', 'uri', '按钮页面', '/admin/element', '6', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('10', 'menuManager:btn_add', 'button', '新增', '/admin/menu/{*}', '6', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('11', 'menuManager:btn_edit', 'button', '编辑', '/admin/menu/{*}', '6', '', '', 'PUT', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES ('12', 'menuManager:btn_del', 'button', '删除', '/admin/menu/{*}', '6', '', '', 'DELETE', '', '2017-06-24 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES ('13', 'menuManager:btn_element_add', 'button', '新增元素', '/admin/element', '6', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('14', 'menuManager:btn_element_edit', 'button', '编辑元素', '/admin/element/{*}', '6', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('15', 'menuManager:btn_element_del', 'button', '删除元素', '/admin/element/{*}', '6', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('16', 'groupManager:btn_add', 'button', '新增', '/admin/group', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('17', 'groupManager:btn_edit', 'button', '编辑', '/admin/group/{*}', '7', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('18', 'groupManager:btn_del', 'button', '删除', '/admin/group/{*}', '7', null, null, 'DELETE', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('19', 'groupManager:btn_userManager', 'button', '分配用户', '/admin/group/{*}/user', '7', null, null, 'PUT', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('20', 'groupManager:btn_resourceManager', 'button', '分配权限', '/admin/group/{*}/authority', '7', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('21', 'groupManager:menu', 'uri', '分配菜单', '/admin/group/{*}/authority/menu', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('22', 'groupManager:element', 'uri', '分配资源', '/admin/group/{*}/authority/element', '7', null, null, 'POST', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('23', 'userManager:view', 'uri', '查看', '/admin/user/{*}', '1', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES ('24', 'menuManager:view', 'uri', '查看', '/admin/menu/{*}', '6', '', '', 'GET', '', '2017-06-26 00:00:00', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `base_element` VALUES ('27', 'menuManager:element_view', 'uri', '查看', '/admin/element/{*}', '6', null, null, 'GET', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('28', 'groupManager:view', 'uri', '查看', '/admin/group/{*}', '7', null, null, 'GET', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('32', 'groupTypeManager:view', 'uri', '查看', '/admin/groupType/{*}', '8', null, null, 'GET', '', null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('33', 'groupTypeManager:btn_add', 'button', '新增', '/admin/groupType', '8', null, null, 'POST', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('34', 'groupTypeManager:btn_edit', 'button', '编辑', '/admin/groupType/{*}', '8', null, null, 'PUT', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('35', 'groupTypeManager:btn_del', 'button', '删除', '/admin/groupType/{*}', '8', null, null, 'DELETE', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('41', 'gateLogManager:view', 'button', '查看', '/admin/gateLog', '27', null, null, 'GET', '', '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('42', 'serviceManager:view', 'URI', '查看', '/auth/service/{*}', '30', null, null, 'GET', null, '2017-12-26 20:17:42', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('43', 'serviceManager:btn_add', 'button', '新增', '/auth/service', '30', null, null, 'POST', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('44', 'serviceManager:btn_edit', 'button', '编辑', '/auth/service/{*}', '30', null, null, 'PUT', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('45', 'serviceManager:btn_del', 'button', '删除', '/auth/service/{*}', '30', null, null, 'DELETE', null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_element` VALUES ('46', 'serviceManager:btn_clientManager', 'button', '服务授权', '/auth/service/{*}/client', '30', null, null, 'POST', null, '2017-12-30 16:32:48', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_group
-- ----------------------------
DROP TABLE IF EXISTS `base_group`;
CREATE TABLE `base_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `parent_id` int(11) NOT NULL COMMENT '上级节点',
  `path` varchar(2000) DEFAULT NULL COMMENT '树状关系',
  `type` char(1) DEFAULT NULL COMMENT '类型',
  `group_type` int(11) NOT NULL COMMENT '角色组类型',
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_group
-- ----------------------------
INSERT INTO `base_group` VALUES ('1', 'adminRole', '管理员', '-1', '/adminRole', null, '1', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group` VALUES ('3', 'testGroup', '体验组', '-1', '/testGroup', null, '1', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group` VALUES ('4', 'visitorRole', '游客', '3', '/testGroup/visitorRole', null, '1', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group` VALUES ('6', 'company', 'Ada集团', '-1', '/company', null, '2', 'Ada集团', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group` VALUES ('7', 'financeDepart', '财务部', '6', '/company/financeDepart', null, '2', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group` VALUES ('8', 'hrDepart', '人力资源部', '6', '/company/hrDepart', null, '2', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group` VALUES ('9', 'blogAdmin', '博客管理员', '-1', '/blogAdmin', null, '1', '', '2017-07-16 16:59:30', '1', 'Mr.AG', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_group_leader
-- ----------------------------
DROP TABLE IF EXISTS `base_group_leader`;
CREATE TABLE `base_group_leader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_group_leader
-- ----------------------------
INSERT INTO `base_group_leader` VALUES ('13', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group_leader` VALUES ('14', '9', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group_leader` VALUES ('15', '7', '8', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_group_member
-- ----------------------------
DROP TABLE IF EXISTS `base_group_member`;
CREATE TABLE `base_group_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_group_member
-- ----------------------------
INSERT INTO `base_group_member` VALUES ('2', '4', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group_member` VALUES ('10', '1', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group_member` VALUES ('11', '9', '8', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_group_member` VALUES ('12', '7', '8', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_group_type
-- ----------------------------
DROP TABLE IF EXISTS `base_group_type`;
CREATE TABLE `base_group_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `crt_time` datetime DEFAULT NULL COMMENT '创建时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '创建人ID',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '创建人',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '创建主机',
  `upd_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `upd_user` varchar(255) DEFAULT NULL COMMENT '最后更新人ID',
  `upd_name` varchar(255) DEFAULT NULL COMMENT '最后更新人',
  `upd_host` varchar(255) DEFAULT NULL COMMENT '最后更新主机',
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_group_type
-- ----------------------------
INSERT INTO `base_group_type` VALUES ('3', 'ddd', 'aaa', 'aaaaa', null, null, null, null, '2019-12-27 19:17:59', '1', 'admin', '192.168.56.1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_menu
-- ----------------------------
DROP TABLE IF EXISTS `base_menu`;
CREATE TABLE `base_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '路径编码',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `parent_id` int(11) NOT NULL COMMENT '父级节点',
  `href` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `type` char(10) DEFAULT NULL,
  `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `path` varchar(500) DEFAULT NULL COMMENT '菜单上下级关系',
  `enabled` char(1) DEFAULT NULL COMMENT '启用禁用',
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_menu
-- ----------------------------
INSERT INTO `base_menu` VALUES ('1', 'userManager', '用户管理', '5', '/admin/user', 'fa-user', 'menu', '0', '', '/adminSys/baseManager/userManager', null, null, null, null, null, '2017-09-05 21:06:51', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/user/index\')', null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('5', 'baseManager', '基础配置管理', '13', '/admin', 'setting', 'dirt', '0', '', '/adminSys/baseManager', null, null, null, null, null, '2017-09-05 21:46:11', '1', 'Mr.AG', '127.0.0.1', 'Layout', null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('6', 'menuManager', '菜单管理', '5', '/admin/menu', 'category', 'menu', '0', '', '/adminSys/baseManager/menuManager', null, null, null, null, null, '2017-09-05 21:10:25', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/menu/index\')', null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('7', 'groupManager', '角色权限管理', '5', '/admin/group', 'group_fill', 'menu', '0', '', '/adminSys/baseManager/groupManager', null, null, null, null, null, '2017-09-05 21:11:34', '1', 'Mr.AG', '127.0.0.1', 'import(\'admin/group/index\')', null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('8', 'groupTypeManager', '角色类型管理', '5', '/admin/groupType', 'fa-users', 'menu', '0', '', '/adminSys/baseManager/groupTypeManager', null, null, null, null, null, '2017-09-05 21:12:28', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/groupType/index\')', null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('13', 'adminSys', '权限管理系统', '-1', '/base', 'setting', 'dirt', '0', '', '/adminSys', null, null, null, null, null, '2017-09-28 12:09:22', '1', 'Mr.AG', '127.0.0.1', 'Layout', null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('27', 'gateLogManager', '操作日志', '5', '/admin/gateLog', 'viewlist', 'menu', '0', '', '/adminSys/baseManager/gateLogManager', null, '2017-07-01 00:00:00', '1', 'admin', '0:0:0:0:0:0:0:1', '2017-09-05 22:32:55', '1', 'Mr.AG', '127.0.0.1', '_import(\'admin/gateLog/index\')', null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('29', 'authManager', '服务权限管理', '13', '/auth', 'service', 'dirt', '0', '服务权限管理', '/adminSys/authManager', null, '2017-12-26 19:54:45', '1', 'Mr.AG', '127.0.0.1', '2019-01-27 12:42:09', '1', 'admin', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('30', 'serviceManager', '服务管理', '29', '/auth/service', 'client', null, '0', '服务管理', '/adminSys/authManager/serviceManager', null, '2017-12-26 19:56:06', '1', 'Mr.AG', '127.0.0.1', '2017-12-26 19:56:06', '1', 'Mr.AG', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('31', 'monitorManager', '监控模块管理', '13', '/service', 'service', 'dirt', '0', null, '/adminSys/monitorManager', null, '2018-02-25 09:36:35', '1', 'Mr.AG', '127.0.0.1', '2019-01-27 12:42:13', '1', 'admin', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('32', 'serviceEurekaManager', '服务注册中心', '31', 'http://localhost:8848/nacos', 'client', 'menu', '0', null, '/adminSys/monitorManager/serviceEurekaManager', null, '2018-02-25 09:37:04', '1', 'Mr.AG', '127.0.0.1', '2019-01-27 12:14:35', '1', 'admin', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('33', 'serviceMonitorManager', '服务状态监控', '31', '', 'client', 'menu', '0', null, '/adminSys/monitorManager/serviceEurekaManager', null, '2018-02-25 09:37:05', '1', 'Mr.AG', '127.0.0.1', '2019-01-27 12:07:14', '1', 'admin', '127.0.0.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_menu` VALUES ('34', 'serviceZipkinManager', '服务链路监控', '31', '', 'client', 'menu', '0', null, '/adminSys/monitorManager/serviceZipkinManager', null, '2018-02-25 09:38:05', '1', 'Mr.AG', '127.0.0.1', '2019-01-27 13:13:33', '1', 'admin', '127.0.0.1', '2121', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_resource_authority
-- ----------------------------
DROP TABLE IF EXISTS `base_resource_authority`;
CREATE TABLE `base_resource_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_id` varchar(255) DEFAULT NULL COMMENT '角色ID',
  `authority_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `resource_id` varchar(255) DEFAULT NULL COMMENT '资源ID',
  `resource_type` varchar(255) DEFAULT NULL COMMENT '资源类型',
  `parent_id` varchar(255) DEFAULT NULL,
  `path` varchar(2000) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_resource_authority
-- ----------------------------
INSERT INTO `base_resource_authority` VALUES ('287', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('288', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('289', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('290', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('291', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('294', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('295', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('296', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('297', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('298', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('299', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('300', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('301', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('302', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('303', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('304', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('305', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('306', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('307', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('308', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('309', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('310', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('311', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('312', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('313', '1', 'group', '16', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('314', '1', 'group', '17', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('315', '1', 'group', '18', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('317', '1', 'group', '20', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('318', '1', 'group', '21', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('319', '1', 'group', '22', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('349', '4', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('371', '1', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('372', '1', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('373', '1', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('374', '1', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('375', '1', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('378', '1', 'group', '5', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('379', '1', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('380', '1', 'group', '11', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('381', '1', 'group', '14', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('382', '1', 'group', '13', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('383', '1', 'group', '15', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('384', '1', 'group', '12', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('385', '1', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('386', '1', 'group', '10', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('387', '1', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('388', '1', 'group', '16', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('389', '1', 'group', '18', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('390', '1', 'group', '17', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('392', '1', 'group', '20', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('393', '1', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('394', '1', 'group', '22', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('395', '1', 'group', '21', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('396', '4', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('397', '4', 'group', '9', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('398', '4', 'group', '27', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('399', '4', 'group', '24', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('400', '4', 'group', '28', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('401', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('402', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('403', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('421', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('422', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('423', '4', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('424', '4', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('436', '1', 'group', '32', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('437', '1', 'group', '33', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('438', '1', 'group', '34', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('439', '1', 'group', '35', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('440', '4', 'group', '32', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('464', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('465', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('466', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('467', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('468', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('469', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('470', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('471', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('472', '1', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('492', '1', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('493', '1', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('494', '1', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('516', '4', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('517', '4', 'group', '30', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('518', '4', 'group', '31', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('519', '4', 'group', '40', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('611', '4', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('612', '4', 'group', '36', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('666', '1', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('689', '1', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('691', '1', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('710', '9', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('711', '9', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('712', '9', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('713', '9', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('718', '9', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('719', '9', 'group', '44', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('720', '9', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('721', '9', 'group', '43', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('722', '1', 'group', '41', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('749', '10', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('750', '10', 'group', '14', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('751', '10', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('752', '10', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('753', '10', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('754', '10', 'group', '17', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('755', '10', 'group', '20', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('774', '1', 'group', '3', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('775', '1', 'group', '4', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('812', '1', 'group', '19', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('924', '1', 'group', '42', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('945', '1', 'group', '45', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('956', '1', 'group', '46', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('967', '1', 'group', '33', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('968', '1', 'group', '34', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('969', '1', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('970', '1', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('971', '1', 'group', '27', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('972', '1', 'group', '29', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('973', '1', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('974', '1', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('975', '1', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('976', '1', 'group', '7', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('977', '1', 'group', '8', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('978', '1', 'group', '30', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('979', '1', 'group', '31', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('980', '1', 'group', '32', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('981', '9', 'group', '23', 'button', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('982', '9', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('983', '9', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('984', '9', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('985', '9', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('986', '4', 'group', '33', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('987', '4', 'group', '34', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('988', '4', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('989', '4', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('990', '4', 'group', '27', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('991', '4', 'group', '29', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('992', '4', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('993', '4', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('994', '4', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('995', '4', 'group', '7', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('996', '4', 'group', '8', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('997', '4', 'group', '30', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('998', '4', 'group', '31', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('999', '4', 'group', '32', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('1000', '7', 'group', '1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('1001', '7', 'group', '13', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('1002', '7', 'group', '-1', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('1003', '7', 'group', '5', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `base_resource_authority` VALUES ('1004', '7', 'group', '6', 'menu', '-1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `tel_phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `type` char(1) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `crt_time` datetime DEFAULT NULL,
  `crt_user` varchar(255) DEFAULT NULL,
  `crt_name` varchar(255) DEFAULT NULL,
  `crt_host` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `upd_user` varchar(255) DEFAULT NULL,
  `upd_name` varchar(255) DEFAULT NULL,
  `upd_host` varchar(255) DEFAULT NULL,
  `attr1` varchar(255) DEFAULT NULL,
  `attr2` varchar(255) DEFAULT NULL,
  `attr3` varchar(255) DEFAULT NULL,
  `attr4` varchar(255) DEFAULT NULL,
  `attr5` varchar(255) DEFAULT NULL,
  `attr6` varchar(255) DEFAULT NULL,
  `attr7` varchar(255) DEFAULT NULL,
  `attr8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('1', 'admin', '$2a$12$S/yLlj9kzi5Dgsz97H4rAekxrPlk/10eXp1lUJcAVAx.2M9tOpWie', 'Ada', '', null, '', null, '', '男', null, null, '超级管理员', null, null, null, null, '2019-12-24 20:10:49', '1', 'admin', '192.168.56.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_user` VALUES ('16', 'admina', null, 'aaaaa', null, null, null, null, null, '女', null, null, '无密码', '2019-12-27 19:17:31', '1', 'admin', '192.168.56.1', '2019-12-27 19:57:05', '1', 'admin', '192.168.56.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_user` VALUES ('17', 'adminaaa', '$2a$12$uF0bFoc2Oft9p4CsWpRzSem4NYdM2d7TQqzAuyZM6lNN7.66SkLo2', 'aaa', null, null, null, null, null, '男', null, null, null, '2019-12-27 19:26:58', '1', 'admin', '192.168.56.1', '2019-12-27 19:26:58', '1', 'admin', '192.168.56.1', null, null, null, null, null, null, null, null);
INSERT INTO `base_user` VALUES ('18', 'admin1', '$2a$12$zoega05wG3tlLbHPaD/RyeseKAGugQxpdedM6GR9yAJJu4dZf2VLy', '111', null, null, null, null, null, '男', null, null, null, '2019-12-27 19:29:42', '1', 'admin', '192.168.56.1', '2019-12-27 19:29:42', '1', 'admin', '192.168.56.1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for gate_log
-- ----------------------------
DROP TABLE IF EXISTS `gate_log`;
CREATE TABLE `gate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `menu` varchar(255) DEFAULT NULL COMMENT '菜单',
  `opt` varchar(255) DEFAULT NULL COMMENT '操作',
  `uri` varchar(255) DEFAULT NULL COMMENT '资源路径',
  `crt_time` datetime DEFAULT NULL COMMENT '操作时间',
  `crt_user` varchar(255) DEFAULT NULL COMMENT '操作人ID',
  `crt_name` varchar(255) DEFAULT NULL COMMENT '操作人',
  `crt_host` varchar(255) DEFAULT NULL COMMENT '操作主机',
  `body` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of gate_log
-- ----------------------------
INSERT INTO `gate_log` VALUES ('15', '用户管理', null, '/admin/user/{*}', '2019-12-16 15:20:51', '1', 'Ada', '/127.0.0.1:59133', 'null');
INSERT INTO `gate_log` VALUES ('16', '用户管理', null, '/admin/user/{*}', '2019-12-17 09:07:28', '1', 'Ada', '/127.0.0.1:56940', 'null');
INSERT INTO `gate_log` VALUES ('17', '用户管理', null, '/admin/user', '2019-12-17 09:08:28', '1', 'Ada', '/127.0.0.1:57341', 'null');
INSERT INTO `gate_log` VALUES ('18', '用户管理', null, '/admin/user', '2019-12-19 18:51:40', '1', 'Ada', '/127.0.0.1:53675', 'null');
INSERT INTO `gate_log` VALUES ('19', '用户管理', null, '/admin/user', '2019-12-19 18:57:06', '1', 'Ada', '/127.0.0.1:55748', 'null');
INSERT INTO `gate_log` VALUES ('20', '用户管理', null, '/admin/user', '2019-12-19 18:57:07', '1', 'Ada', '/127.0.0.1:55788', 'null');
INSERT INTO `gate_log` VALUES ('21', '用户管理', null, '/admin/user', '2019-12-19 19:01:25', '1', 'Ada', '/127.0.0.1:56521', 'null');
INSERT INTO `gate_log` VALUES ('22', '用户管理', null, '/admin/user/{*}', '2019-12-19 19:01:48', '1', 'Ada', '/127.0.0.1:56708', 'null');
INSERT INTO `gate_log` VALUES ('23', '用户管理', null, '/admin/user/{*}', '2019-12-19 19:07:47', '1', 'Ada', '/127.0.0.1:58865', 'null');
INSERT INTO `gate_log` VALUES ('24', '用户管理', null, '/admin/user', '2019-12-19 19:08:10', '1', 'Ada', '/127.0.0.1:59016', 'null');
INSERT INTO `gate_log` VALUES ('25', '用户管理', null, '/admin/user', '2019-12-19 19:20:33', '1', 'Ada', '/127.0.0.1:63195', 'null');
INSERT INTO `gate_log` VALUES ('26', '用户管理', null, '/admin/user/{*}', '2019-12-19 19:21:31', '1', 'Ada', '/127.0.0.1:63721', 'null');
INSERT INTO `gate_log` VALUES ('27', '用户管理', null, '/admin/user', '2019-12-19 19:21:50', '1', 'Ada', '/127.0.0.1:63854', 'null');
INSERT INTO `gate_log` VALUES ('28', '菜单管理', null, '/admin/menu/{*}', '2019-12-19 20:00:06', '1', 'Ada', '/127.0.0.1:62253', 'null');
INSERT INTO `gate_log` VALUES ('29', '菜单管理', null, '/admin/menu/{*}', '2019-12-19 20:02:05', '1', 'Ada', '/127.0.0.1:62937', 'null');
INSERT INTO `gate_log` VALUES ('30', '菜单管理', null, '/admin/element', '2019-12-19 20:02:57', '1', 'Ada', '/127.0.0.1:63238', 'null');
INSERT INTO `gate_log` VALUES ('31', '菜单管理', null, '/admin/element/{*}', '2019-12-19 20:03:09', '1', 'Ada', '/127.0.0.1:63396', 'null');
INSERT INTO `gate_log` VALUES ('32', '菜单管理', null, '/admin/menu/{*}', '2019-12-19 20:03:35', '1', 'Ada', '/127.0.0.1:63704', 'null');
INSERT INTO `gate_log` VALUES ('33', '菜单管理', null, '/admin/element/{*}', '2019-12-19 20:03:43', '1', 'Ada', '/127.0.0.1:63831', 'null');
INSERT INTO `gate_log` VALUES ('34', '菜单管理', null, '/admin/element/{*}', '2019-12-19 20:03:48', '1', 'Ada', '/127.0.0.1:63921', 'null');
INSERT INTO `gate_log` VALUES ('35', '角色权限管理', null, '/admin/group/{*}', '2019-12-19 20:05:50', '1', 'Ada', '/127.0.0.1:64997', 'null');
INSERT INTO `gate_log` VALUES ('36', '角色权限管理', null, '/admin/group', '2019-12-19 20:06:34', '1', 'Ada', '/127.0.0.1:65507', 'null');
INSERT INTO `gate_log` VALUES ('37', '角色权限管理', null, '/admin/group/{*}', '2019-12-19 20:06:41', '1', 'Ada', '/127.0.0.1:49315', 'null');
INSERT INTO `gate_log` VALUES ('38', '角色权限管理', null, '/admin/group/{*}/user', '2019-12-19 20:07:56', '1', 'Ada', '/127.0.0.1:50382', 'null');
INSERT INTO `gate_log` VALUES ('39', '角色权限管理', null, '/admin/group/{*}/user', '2019-12-19 20:08:24', '1', 'Ada', '/127.0.0.1:50862', 'null');
INSERT INTO `gate_log` VALUES ('40', '角色权限管理', null, '/admin/group', '2019-12-19 20:08:30', '1', 'Ada', '/127.0.0.1:50927', 'null');
INSERT INTO `gate_log` VALUES ('41', '角色权限管理', null, '/admin/group/{*}', '2019-12-19 20:08:34', '1', 'Ada', '/127.0.0.1:51038', 'null');
INSERT INTO `gate_log` VALUES ('42', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-19 20:08:48', '1', 'Ada', '/127.0.0.1:51231', 'null');
INSERT INTO `gate_log` VALUES ('43', '角色类型管理', null, '/admin/groupType', '2019-12-19 20:08:58', '1', 'Ada', '/127.0.0.1:51336', 'null');
INSERT INTO `gate_log` VALUES ('44', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-19 20:09:01', '1', 'Ada', '/127.0.0.1:51411', 'null');
INSERT INTO `gate_log` VALUES ('45', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-19 20:09:05', '1', 'Ada', '/127.0.0.1:51460', 'null');
INSERT INTO `gate_log` VALUES ('46', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-19 20:09:07', '1', 'Ada', '/127.0.0.1:51500', 'null');
INSERT INTO `gate_log` VALUES ('47', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-19 20:09:15', '1', 'Ada', '/127.0.0.1:51596', 'null');
INSERT INTO `gate_log` VALUES ('48', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-19 20:09:19', '1', 'Ada', '/127.0.0.1:51678', 'null');
INSERT INTO `gate_log` VALUES ('49', '角色类型管理', null, '/admin/groupType', '2019-12-24 18:55:04', '1', 'Ada', '/127.0.0.1:59522', 'null');
INSERT INTO `gate_log` VALUES ('50', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-24 18:55:14', '1', 'Ada', '/127.0.0.1:59655', 'null');
INSERT INTO `gate_log` VALUES ('51', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-24 18:55:17', '1', 'Ada', '/127.0.0.1:59732', 'null');
INSERT INTO `gate_log` VALUES ('52', '用户管理', null, '/admin/user/{*}', '2019-12-24 18:57:35', '1', 'Ada', '/127.0.0.1:60596', 'null');
INSERT INTO `gate_log` VALUES ('53', '用户管理', null, '/admin/user', '2019-12-24 19:03:52', '1', 'Ada', '/127.0.0.1:62622', 'null');
INSERT INTO `gate_log` VALUES ('54', '用户管理', null, '/admin/user', '2019-12-24 19:13:09', '1', 'Ada', '/127.0.0.1:65256', 'null');
INSERT INTO `gate_log` VALUES ('55', '用户管理', null, '/admin/user/{*}', '2019-12-24 19:14:08', '1', 'Ada', '/127.0.0.1:49241', 'null');
INSERT INTO `gate_log` VALUES ('56', '用户管理', null, '/admin/user', '2019-12-24 19:14:17', '1', 'Ada', '/127.0.0.1:49323', 'null');
INSERT INTO `gate_log` VALUES ('57', '用户管理', null, '/admin/user', '2019-12-24 19:51:26', '1', 'Ada', '/127.0.0.1:59745', 'null');
INSERT INTO `gate_log` VALUES ('58', '用户管理', null, '/admin/user', '2019-12-24 19:57:44', '1', 'Ada', '/127.0.0.1:61711', 'null');
INSERT INTO `gate_log` VALUES ('59', '用户管理', null, '/admin/user', '2019-12-24 20:03:48', '1', 'Ada', '/127.0.0.1:63483', 'null');
INSERT INTO `gate_log` VALUES ('60', '用户管理', null, '/admin/user/{*}', '2019-12-24 20:05:07', '1', 'Ada', '/127.0.0.1:63912', 'null');
INSERT INTO `gate_log` VALUES ('61', '用户管理', null, '/admin/user/{*}', '2019-12-24 20:09:04', '1', 'Ada', '/127.0.0.1:65150', 'null');
INSERT INTO `gate_log` VALUES ('62', '用户管理', null, '/admin/user/{*}', '2019-12-24 20:09:11', '1', 'Ada', '/127.0.0.1:65244', 'null');
INSERT INTO `gate_log` VALUES ('63', '用户管理', null, '/admin/user/{*}', '2019-12-24 20:09:12', '1', 'Ada', '/127.0.0.1:65280', 'null');
INSERT INTO `gate_log` VALUES ('64', '用户管理', null, '/admin/user/{*}', '2019-12-24 20:09:14', '1', 'Ada', '/127.0.0.1:65318', 'null');
INSERT INTO `gate_log` VALUES ('65', '用户管理', null, '/admin/user/{*}', '2019-12-24 20:09:16', '1', 'Ada', '/127.0.0.1:65360', 'null');
INSERT INTO `gate_log` VALUES ('66', '用户管理', null, '/admin/user/{*}', '2019-12-24 20:10:49', '1', 'Ada', '/127.0.0.1:49680', 'null');
INSERT INTO `gate_log` VALUES ('67', '角色类型管理', null, '/admin/groupType', '2019-12-24 20:11:05', '1', 'Ada', '/127.0.0.1:49970', 'null');
INSERT INTO `gate_log` VALUES ('68', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-24 20:11:19', '1', 'Ada', '/127.0.0.1:50122', 'null');
INSERT INTO `gate_log` VALUES ('69', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-24 20:11:22', '1', 'Ada', '/127.0.0.1:50199', 'null');
INSERT INTO `gate_log` VALUES ('70', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:05:24', '1', 'Ada', '/127.0.0.1:51152', 'null');
INSERT INTO `gate_log` VALUES ('71', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:06:49', '1', 'Ada', '/127.0.0.1:51614', 'null');
INSERT INTO `gate_log` VALUES ('72', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:07:05', '1', 'Ada', '/127.0.0.1:51779', 'null');
INSERT INTO `gate_log` VALUES ('73', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:09:26', '1', 'Ada', '/127.0.0.1:52520', 'null');
INSERT INTO `gate_log` VALUES ('74', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:10:22', '1', 'Ada', '/127.0.0.1:52812', 'null');
INSERT INTO `gate_log` VALUES ('75', '角色类型管理', null, '/admin/groupType', '2019-12-27 19:13:39', '1', 'Ada', '/127.0.0.1:53822', 'null');
INSERT INTO `gate_log` VALUES ('76', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:13:57', '1', 'Ada', '/127.0.0.1:54024', 'null');
INSERT INTO `gate_log` VALUES ('77', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:14:43', '1', 'Ada', '/127.0.0.1:54308', 'null');
INSERT INTO `gate_log` VALUES ('78', '用户管理', null, '/admin/user', '2019-12-27 19:14:51', '1', 'Ada', '/127.0.0.1:54371', 'null');
INSERT INTO `gate_log` VALUES ('79', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:17:11', '1', 'Ada', '/127.0.0.1:55309', 'null');
INSERT INTO `gate_log` VALUES ('80', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:17:24', '1', 'Ada', '/127.0.0.1:55426', 'null');
INSERT INTO `gate_log` VALUES ('81', '用户管理', null, '/admin/user', '2019-12-27 19:17:31', '1', 'Ada', '/127.0.0.1:55492', 'null');
INSERT INTO `gate_log` VALUES ('82', '角色类型管理', null, '/admin/groupType/{*}', '2019-12-27 19:17:59', '1', 'Ada', '/127.0.0.1:55864', 'null');
INSERT INTO `gate_log` VALUES ('83', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:26:12', '1', 'Ada', '/127.0.0.1:58555', 'null');
INSERT INTO `gate_log` VALUES ('84', '用户管理', null, '/admin/user', '2019-12-27 19:26:58', '1', 'Ada', '/127.0.0.1:58948', 'null');
INSERT INTO `gate_log` VALUES ('85', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:29:14', '1', 'Ada', '/127.0.0.1:59651', 'null');
INSERT INTO `gate_log` VALUES ('86', '用户管理', null, '/admin/user', '2019-12-27 19:29:42', '1', 'Ada', '/127.0.0.1:59861', 'null');
INSERT INTO `gate_log` VALUES ('87', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:32:36', '1', 'Ada', '/127.0.0.1:60859', 'null');
INSERT INTO `gate_log` VALUES ('88', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:44:54', '1', 'Ada', '/127.0.0.1:64845', 'null');
INSERT INTO `gate_log` VALUES ('89', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:46:20', '1', 'Ada', '/127.0.0.1:65426', 'null');
INSERT INTO `gate_log` VALUES ('90', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:53:26', '1', 'Ada', '/127.0.0.1:51202', 'null');
INSERT INTO `gate_log` VALUES ('91', '用户管理', null, '/admin/user/{*}', '2019-12-27 19:57:05', '1', 'Ada', '/127.0.0.1:52424', 'null');
