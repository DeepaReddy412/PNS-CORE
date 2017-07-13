CREATE TABLE `friends` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `friend_id` bigint(11) NOT NULL,
  `is_block` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `friend_id` (`friend_id`),
  CONSTRAINT `friends_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `friends_ibfk_2` FOREIGN KEY (`friend_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;


insert  into `friends`(`id`,`user_id`,`friend_id`,`is_block`) values (93,11,13,0),(94,13,11,0),(95,13,16,0),(96,16,13,0),(97,13,14,1),(98,14,13,0),(99,13,12,0),(100,12,13,0),(101,15,13,0),(102,13,15,0),(103,17,13,0),(104,13,17,0),(105,15,17,0),(106,17,15,0),(107,16,17,0),(108,17,16,0),(109,11,17,0),(110,17,11,0),(111,13,18,0),(112,18,13,0),(113,14,16,0),(114,16,14,0),(115,18,17,0),(116,17,18,0);


