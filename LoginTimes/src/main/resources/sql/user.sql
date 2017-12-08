DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
   `id` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
   `username` varchar(50),
   `password` varchar(255),
   `wrongtimes` int(10),
   `lastlogin` bigint(20),
   `locked` int(10)
)DEFAULT CHARSET=utf8;

INSERT INTO user (username,password,wrongtimes,lastlogin,locked) VALUES ("yubotao","123",0,null,0);