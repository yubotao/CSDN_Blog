-- 创建user表---------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(20) UNIQUE ,
  `password` varchar(255),
  `role` bigint(20)
)DEFAULT CHARSET=utf8;

-- 创建role表 -------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`(
   `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
   `name` varchar(50),
   `permission` varchar(255)
)DEFAULT CHARSET=utf8;

-- user 插入数据-------------
INSERT INTO `user` (name,password,role) VALUES ("admin","123",1);
INSERT INTO `user` (name,password,role) VALUES ("yu","123",4);
INSERT INTO `user` (name,password,role) VALUES ("bo","123",2);
INSERT INTO `user` (name,password,role) VALUES ("tao","123",5);

-- role 插入数据------------
INSERT INTO `role` (name,permission) VALUES ("admin","1,2,3");
INSERT INTO `role` (name,permission) VALUES ("first","1");
INSERT INTO `role` (name,permission) VALUES ("second","2");
INSERT INTO `role` (name,permission) VALUES ("third","3");
INSERT INTO `role` (name,permission) VALUES ("test","1,3");
