CREATE TABLE `seed_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert  into `seed_request`(`id`,`status`) values (1,'CANCELED'),(2,'ACCEPTED'),(3,'REQUESTED');

