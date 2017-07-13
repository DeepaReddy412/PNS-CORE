
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `mobile_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

insert  into `user`(`id`,`name`,`email`,`password`,`mobile_no`) values (11,'senthamil','sent@yopmail.com','Pass123$','7567456757'),(12,'amala','amala@yopmail.com','Pass123$','3423434343'),(13,'deepa reddy','deepa@yopmail.com','Pass123$','5555555555'),(14,'jaya','jaya@yopmail.com','Pass123$','2432423444'),(15,'test','test@yopmail.com','pass123$','3242343434'),(16,'merjil','merjil@yopmail.com','pass123$','2312423234'),(17,'ram1','ram@yopmail.com','Pass123$','4634853565'),(18,'smily','smily@yopmail.com','pass123$','3242342343');

