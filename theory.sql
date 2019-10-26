/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : theory

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 26/10/2019 10:13:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' ',
  `title` varchar(1000) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `optionA` varchar(255) DEFAULT NULL,
  `optionB` varchar(255) DEFAULT NULL,
  `optionC` varchar(255) DEFAULT NULL,
  `optionD` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1223 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
BEGIN;
INSERT INTO `topic` VALUES (1, '计算机运行过程中，遇到突发事件，要求CPU暂时停止正在运行的程序，转去为突发事件服务，服务完毕，再自动返回原程序继续执行，这个过程称为（），其处理过程中保存现场的目的是返回去继续执行原程序。', 1, '阻塞', '中断', '动态绑定', '静态绑定', 'B', NULL);
INSERT INTO `topic` VALUES (2, '计算机运行过程中，遇到突发事件，要求CPU暂时停止正在运行的程序，转去为突发事件服务，服务完毕，再自动返回原程序继续执行，这个过程称为中断，其处理过程中保存现场的目的是（）。', 1, '防止丢失数据', '防止对其他部件造成影响', '返回去继续执行原程序', '为中断处理程序提供数据', 'C', NULL);
INSERT INTO `topic` VALUES (3, 'CPU在执行指令的过程中，会自动修改（）的内容，以使其保存的总是将要执行的下一条指令的地址', 1, '指令寄存器', '程序计数器', '地址寄存器', '指令译码器', 'B', NULL);
INSERT INTO `topic` VALUES (4, '在微机系统中，BIOS（基本输入输出系统）保存在（）中。', 1, '主板上的ROM', 'CPU的寄存器', '主板上的RAM', '虚拟存储器', 'A', NULL);
INSERT INTO `topic` VALUES (5, '采用n位补码（包含一个符号位）表示数据，可以直接在表示数值（）。', 1, '2n', '-2n', '2n-1', '-2n-1', 'D', NULL);
INSERT INTO `topic` VALUES (6, '以下关于采用一位奇校验法的叙述中，正确的是（）。', 1, '若所有奇数位出错，则可以检测出该错误但无法纠正错误', '若所有偶数位出错，则可以检测出该错误并加以纠正', '若所有奇数个数据位出错，则可以检测出该错误但无法纠正错误', '若有偶数个数据位出错，则可以检测出该错误并加以纠正', 'C', NULL);
INSERT INTO `topic` VALUES (7, '下列关于流水线方式执行指令的叙述中，不正确的是（）', 1, '流水线方式可提高单条指令的执行速度', '流水线方式下可同时执行多条指令', '流水线方式提高了各部件的利用率	', '流水线方式提高了系统的吞吐率', 'A', NULL);
INSERT INTO `topic` VALUES (8, 'CPU执行算术运算或者逻辑运算时，常将源操作数和结果暂存在（）中。', 1, '程序计数器(PC)	', '累加器(AC)	', '指令寄存器(IR)	', '地址寄存器(AR)', 'B', NULL);
INSERT INTO `topic` VALUES (9, '要判断字长为16位的整数a的低四位是否全为0，则（）。', 1, '将a与0x000F进行\"逻辑与\"运算，然后判断运算结果是否等于0', '将a与0x000F进行\"逻辑或\"运算，然后判断运算结果是否等于F', '将a与0x000F进行\"逻辑或\"运算，然后判断运算结果是否等于F', '将a与0x000F进行\"逻辑与\"运算，然后判断运算结果是否等于F', 'A', NULL);
INSERT INTO `topic` VALUES (10, '计算机系统中常用的输入/输出控制方式有无条件传送、中断、程序查询和DMA方式等。当采用（）方式时，不需要CPU执行程序指令来传送数据。', 1, '中断', '程序查询', '无条件传送', 'DMA', 'D', NULL);
INSERT INTO `topic` VALUES (1208, '计算机内存一般分为静态数据区、代码区、栈区和堆区，若某指令的操作数之一采用立即数寻址方式，则该操作数位于栈区。（）', 2, 'A', 'B', NULL, NULL, 'A', NULL);
INSERT INTO `topic` VALUES (1209, '计算机在进行浮点数的相加(减)运算之前先进行对阶操作，若x的阶码大于y的阶码，则应将y的阶码扩大至与x的阶码相同，且使y的尾数部分进行算术左移。（）', 2, 'A', 'B', NULL, NULL, 'B', NULL);
INSERT INTO `topic` VALUES (1210, '在CPU中，程序计数器可用于传送和暂存用户数据，为ALU执行算术逻辑运算提供工作区。（）', 2, 'A', 'B', NULL, NULL, 'B', NULL);
INSERT INTO `topic` VALUES (1211, 'I/O设备与主机间交换数据，中断方式和DMA方式下，CPU与I/O设备都可同步工作。（）', 2, 'A', 'B', NULL, NULL, 'B', NULL);
INSERT INTO `topic` VALUES (1212, '下面关于校验方法的叙述，采用CRC校验，需要将校验码分散开并插入数据的指定位置中。（）', 2, 'A', 'B', NULL, NULL, 'A', NULL);
INSERT INTO `topic` VALUES (1213, 'Cache用于存放主存数据的部分备份，主存单元地址与Cache单元地址之间的转换工作由用户完成。（）', 2, 'A', 'B', NULL, NULL, 'A', NULL);
INSERT INTO `topic` VALUES (1214, '《中华人民共和国著作权法》和《计算机软件保护条例》是构成我国保护计算机软件著作权的两个基本法律文件。（）', 2, 'A', 'B', NULL, NULL, 'A', NULL);
INSERT INTO `topic` VALUES (1215, '为了防止电子邮件中的恶意代码，应该用网页方式阅读电子邮件。（）', 2, 'A', 'B', NULL, NULL, 'B', NULL);
INSERT INTO `topic` VALUES (1216, 'TCP/IP在多个层次引入了安全机制，其中TLS协议位于应用层。（）', 2, 'A', 'B', NULL, NULL, 'B', NULL);
INSERT INTO `topic` VALUES (1217, '我国专利申请的原则之一是申请在先与使用在先相结合。（）', 2, 'A', 'B', NULL, NULL, 'B', NULL);
INSERT INTO `topic` VALUES (1218, '王某是M国际运输有限公司计算机系统管理员。任职期间，王某根据公司的业务要求开发了“海运出口业务系统”，并由公司使用，随后，王某向国家版权局申请了计算机软件著作权登记，并取得了《计算机软件著作权登记证书》。证书明确软件名称是“海运出口业务系统V1.0”，著作权人为王某。以下说法中，不正确的是______。', 3, '海运出口业务系统V1.0的著作权属于王某', '海运出口业务系统V1.0的著作权属于M公司', '海运出口业务系统V1.0的著作权属于王某和M公司', '王某获取的软件著作权登记证是不可以撤销的', 'ACD', NULL);
INSERT INTO `topic` VALUES (1219, '确定软件的模块划分及模块之间的调用关系不是______阶段的任务。', 3, '需求分析	', '概要设计', '详细设计', '编码', 'ACD', NULL);
INSERT INTO `topic` VALUES (1220, '甘特图(Gantt图)能______。', 3, '作为项目进度管理的一个工具', '清晰地描述每个任务的开始和截止时间', '清晰地获得任务并行进行的信息', '清晰地获得各任务之间的依赖关系', 'ABC', NULL);
INSERT INTO `topic` VALUES (1221, '以下关于风险管理的叙述中，正确的是______。', 3, '仅根据风险产生的后果来对风险排优先级', '可以通过改变系统性能或功能需求来避免某些风险', '不可能去除所有风险，但可以通过采取行动来降低或者减轻风险', '在项目开发过程中，需要定期地评估和管理风险', 'BCD', NULL);
INSERT INTO `topic` VALUES (1222, '若C程序的表达式中引用了未赋初值的变量，不会出现______。', 3, '编译时一定会报告错误信息，该程序不能运行', '可以通过编译并运行，但运行时一定会报告异常', '可以通过编译，但链接时一定会报告错误信息而不能运行', '可以通过编译并运行，但运行结果不一定是期望的结果', 'ABC', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT ' ',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'xx', '123123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
