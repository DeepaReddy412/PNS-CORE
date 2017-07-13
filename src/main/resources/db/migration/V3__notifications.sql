
CREATE TABLE `notifications` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `receiver_id` bigint(11) DEFAULT NULL,
  `sender_id` bigint(11) DEFAULT NULL,
  `sent_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` bigint(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `receiver_fk` (`receiver_id`),
  KEY `sender_fk` (`sender_id`),
  KEY `status_fk` (`status`),
  CONSTRAINT `receiver_fk` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`),
  CONSTRAINT `sender_fk` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`),
  CONSTRAINT `status_fk` FOREIGN KEY (`status`) REFERENCES `seed_request` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=140 DEFAULT CHARSET=utf8;


insert  into `notifications`(`id`,`receiver_id`,`sender_id`,`sent_on`,`status`) values (124,15,13,'2017-06-26 13:22:50',2),(125,11,13,'2017-06-26 13:22:58',2),(126,13,16,'2017-06-26 13:24:23',2),(127,13,14,'2017-06-26 13:24:51',2),(128,13,12,'2017-06-26 13:41:39',2),(129,12,17,'2017-06-27 14:26:12',1),(130,17,13,'2017-06-27 17:52:53',2),(131,11,17,'2017-06-27 18:10:18',2),(132,16,17,'2017-06-27 18:10:29',2),(133,15,17,'2017-06-27 18:10:39',2),(134,16,15,'2017-06-27 18:10:58',3),(135,16,12,'2017-06-28 17:49:10',3),(136,12,18,'2017-07-05 17:57:57',3),(137,13,18,'2017-07-05 19:05:13',2),(138,14,16,'2017-07-06 11:10:04',2),(139,18,17,'2017-07-06 18:20:48',2);

