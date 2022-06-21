/*
 Navicat Premium Data Transfer

 Source Server         : 百度云数据库8
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 120.48.20.150:3306
 Source Schema         : book_manage

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 11/06/2022 20:00:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin@qq.com', '123456', '小李');

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `aid` int(0) NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (1, '关于延长2022年世界读书日系列活动截止日期的通知', '2022-05-25 21:34:20');
INSERT INTO `announcement` VALUES (2, '图书馆恢复开馆通知', '2022-05-25 21:35:22');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ISBN` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publisher` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `public_time` date NULL DEFAULT NULL,
  `price` decimal(19, 2) NULL DEFAULT NULL,
  `library_time` datetime(0) NOT NULL,
  `bookshelf_id` int(0) NULL DEFAULT NULL,
  `state` bit(1) NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (2, '水浒', '9783161484100', '小说', '施耐庵', '人民出版社', '2022-05-19', 34.00, '2022-05-27 09:52:40', 3, b'1');
INSERT INTO `book` VALUES (3, '水浒', '9783161484100', '小说', '施耐庵', '人民出版社', '2022-05-19', 34.00, '2022-05-27 09:52:40', 3, b'0');
INSERT INTO `book` VALUES (5, '三国', '9787302589891', '小说', '罗贯中', '中央出版社', '2022-05-26', 35.00, '2022-05-26 08:33:19', NULL, b'1');
INSERT INTO `book` VALUES (12, '红楼梦', '9787121248948', '个人传记', '曹雪芹', '中央出版社', '2022-05-26', NULL, '2022-05-26 22:40:02', 4, b'1');
INSERT INTO `book` VALUES (13, '李惜时', '9787121421655', '个人传记', '旅馆', 'A*出版社', NULL, NULL, '2022-05-26 22:43:47', 4, b'0');
INSERT INTO `book` VALUES (14, '迪爵的自我修养', '9787517062134', '个人传记', '迪爵与惜时', '淮大崛起出版社', NULL, NULL, '2022-05-26 22:54:03', 1, b'1');
INSERT INTO `book` VALUES (15, '马小跳淘气包', '9787517062134', '小说', '无名', '中央出版社', NULL, NULL, '2022-05-27 12:56:11', 4, b'1');
INSERT INTO `book` VALUES (16, '我的第一本事务书', '9787121248931', '科普', '无名', '中央出版社', NULL, NULL, '2022-05-30 22:18:08', 3, b'1');
INSERT INTO `book` VALUES (17, '大话西游', '9787501262397', '小说', '无名', '中央出版社', NULL, NULL, '2022-05-30 22:58:50', 5, b'0');
INSERT INTO `book` VALUES (18, '数据库设计', '9787302453482', '其他', '无名', '人民出版社', NULL, NULL, '2022-05-31 08:44:52', 3, b'0');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bid` int(0) NOT NULL,
  `borrow_time` datetime(0) NULL DEFAULT NULL,
  `return_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_mail_bid`(`mail`, `borrow_time`, `bid`) USING BTREE,
  INDEX `f_bid`(`bid`) USING BTREE,
  CONSTRAINT `f_bid` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `f_mail` FOREIGN KEY (`mail`) REFERENCES `reader` (`mail`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (4, '11@qq.com', 2, '2022-05-24 16:13:59', '2022-05-25 20:30:41');
INSERT INTO `borrow` VALUES (8, '11@qq.com', 2, '2022-05-25 13:30:12', '2022-05-27 12:59:55');
INSERT INTO `borrow` VALUES (10, '11@qq.com', 2, '2022-05-25 13:34:58', NULL);
INSERT INTO `borrow` VALUES (13, '11@qq.com', 14, '2022-05-26 22:55:04', NULL);
INSERT INTO `borrow` VALUES (14, '2928@qq.com', 12, '2022-05-26 23:36:09', NULL);
INSERT INTO `borrow` VALUES (15, 'dijue@qq.com', 5, '2022-05-27 12:55:31', NULL);
INSERT INTO `borrow` VALUES (16, '123@qq.com', 5, '2022-05-27 12:59:29', '2022-05-27 13:00:02');
INSERT INTO `borrow` VALUES (17, '123@qq.com', 15, '2022-05-27 13:01:25', NULL);
INSERT INTO `borrow` VALUES (18, '123@qq.com', 16, '2022-05-30 22:18:30', '2022-05-30 22:19:13');
INSERT INTO `borrow` VALUES (19, '123@qq.com', 16, '2022-05-30 22:52:36', NULL);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `mid` int(0) NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (6, '图书馆是一个地区的文化灵魂，它的存在可让文化有更多生长的可能，也让文化有安躺沉淀的空间。淮安图书馆为区民特别是青少年提供了一个专心读书的场所，让他们在此培养\n起乐于阅读的习惯。我想，当越来越多的青少年愿意与纸质书结缘，这个地方就会在文化的浸润中变得越发厚重。图书馆的作用就在于以书页的方式留住文化光芒的影子，使淮安图书馆注定永远年轻，永远在前进的路上。至于此，我作为一名经常带着儿子光顾图书馆的一名普通读者，对于图书馆，我有以下几点建议，如可取，望采纳！\n一、开放时间与阅读时间有所出入，适当增加开放时间。同学们与家长有课余时间了，图书馆却关门下班了，而同学们学习正紧张的上课时间，图书馆对外开放。比如说每天下午孩子\n们放学后，图书馆也就快关门下班了；周六、周日是大人和孩子的空余时间，有充足的时间去图书馆查阅图书丰富课外知识，但周六周日开放时间比平时还短。其实，孩子们上学期间，工作日内图书馆的儿童阅览区的人总是寥寥无几，有好几次的中午休息时间，我带孩子去图书馆看书，一中午就我和孩子两个人看书，真有点资源浪费了。最近放暑假了，图书馆的读者也越来越多，更希望图书馆在假期能够增加开放时间。\n二、书籍摆放凌乱，不便于读者寻找所需读物。\n三、可定期更新书籍，以小黑板的形式推荐新书，让读者一目了然。\n四、可招募一些小小志愿者参与图书馆管理工作，一来可以增加同学们的课外实践，二来可以填补图书馆人员不足问题。\n以上建议，望图书馆能采纳，让临潼再添上一笔古香古色的书香气。如有不合适的，请清多多原谅！', '123@qq.com', '2022-06-04 13:53:04');
INSERT INTO `message` VALUES (7, '在知识经济和信息技术已成为新时代发展核心的今天，图书馆\n为读者服务主要是为读者获取知识信息、掌握文献信息，使用馆藏文献信息而提供的一种重要的图书馆功能性服务工作。从图书馆的角度看，必须为所有读者提供一视同仁的服务，让每个读者都能充分利用图书馆的文献、馆舍、设施等。从读者的角度看，也必须遵守图书馆的各种规章制度，文明利用图书馆的资源和设施，为自己和其他读者创造良好的阅读环境。如何创新图书馆读者服务工作，这是每个图书馆馆员面临的重要课题。', '123@qq.com', '2022-06-04 15:02:31');
INSERT INTO `message` VALUES (8, '留言板咋做啊，太难了，呜呜┭┮﹏┭┮，先做个简易版吧', '123@qq.com', '2022-06-04 15:37:01');
INSERT INTO `message` VALUES (9, '少年时代的忧郁，是对整个宇宙的骄傲', '123@qq.com', '2022-06-04 17:05:53');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱\r\n\r\n',
  `password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码\r\n',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名\r\n',
  `sex` enum('男','女','其他') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别\r\n',
  `birth` date NULL DEFAULT NULL COMMENT '出生时间\r\n',
  `image` longblob NULL COMMENT '照片\r\n',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话\r\n',
  `state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '读者类别\r\n',
  `open_time` datetime(0) NOT NULL COMMENT '开卡时间',
  PRIMARY KEY (`mail`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('11@qq.com', '123456', '孙倩', '女', '2022-05-18', NULL, '13813449899', '大一', '2022-05-23 09:50:50');
INSERT INTO `reader` VALUES ('111@qq.com', '123456', '小红', '女', '2022-05-27', NULL, '17813449899', '大四', '2022-05-27 12:57:59');
INSERT INTO `reader` VALUES ('123@qq.com', '123456', '布昊', '男', '2022-05-27', NULL, '13553449899', '大二', '2022-05-27 12:59:05');
INSERT INTO `reader` VALUES ('2928@qq.com', '123456', '第', '男', '2022-05-04', NULL, '13443449899', '大二', '2022-05-28 23:35:49');
INSERT INTO `reader` VALUES ('321@qq.com', '123456', '王五', '男', '2022-05-31', NULL, '18813449899', '大四', '2022-05-31 08:46:11');
INSERT INTO `reader` VALUES ('changbao@qq.com', '123456', '刘畅', '女', '2022-05-29', NULL, '13813449877', '大二', '2022-05-29 21:01:12');
INSERT INTO `reader` VALUES ('dijue@qq.com', '123456', '迪爵', '男', '2022-05-27', NULL, '13713449899', '大二', '2022-05-27 12:54:48');
INSERT INTO `reader` VALUES ('zimei.li@qq.com', '123456', '李惜时', '男', '2022-06-07', NULL, '13813489206', '大二', '2022-06-07 10:38:07');

-- ----------------------------
-- View structure for book_rank_list
-- ----------------------------
DROP VIEW IF EXISTS `book_rank_list`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `book_rank_list` AS select distinct `book`.`ISBN` AS `ISBN`,`book`.`name` AS `name`,`book`.`author` AS `author`,`book`.`public_time` AS `public_time`,`c`.`cnt` AS `cnt` from ((select `a`.`ISBN` AS `ISBN`,count(0) AS `cnt` from (select `book`.`bid` AS `bid`,`book`.`ISBN` AS `ISBN`,`book`.`name` AS `NAME` from (`borrow` join `book` on((`book`.`bid` = `borrow`.`bid`)))) `a` group by `a`.`ISBN`) `c` join `book` on((`book`.`ISBN` = `c`.`ISBN`)));

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('9783161484100', '水浒', '施耐庵', '2022-05-19', 3);
INSERT INTO `reader` VALUES ('9787302589891', '三国', '罗贯中', '2022-05-26', 2);
INSERT INTO `reader` VALUES ('9787121248948', '红楼梦', '曹雪芹', '2022-05-26', 1);
INSERT INTO `reader` VALUES ('9787517062134', '迪爵的自我修养', '迪爵与惜时', NULL, 2);
INSERT INTO `reader` VALUES ('9787517062134', '马小跳淘气包', '无名', NULL, 2);
INSERT INTO `reader` VALUES ('9787121248931', '我的第一本事务书', '无名', NULL, 2);

-- ----------------------------
-- Triggers structure for table book
-- ----------------------------
DROP TRIGGER IF EXISTS `del_book`;
delimiter ;;
CREATE TRIGGER `del_book` BEFORE DELETE ON `book` FOR EACH ROW DELETE from borrow where bid=old.bid
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table reader
-- ----------------------------
DROP TRIGGER IF EXISTS `del`;
delimiter ;;
CREATE TRIGGER `del` BEFORE DELETE ON `reader` FOR EACH ROW DELETE from borrow	where mail=old.mail
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
