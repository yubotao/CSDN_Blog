DROP TABLE IF EXISTS `person`;

CREATE TABLE `person`(
   `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
   `name` varchar(50),
   `age` int(11),
   `sex` varchar(20)
)DEFAULT CHARSET=utf8;