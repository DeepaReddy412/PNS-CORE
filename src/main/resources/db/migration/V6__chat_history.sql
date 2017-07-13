CREATE TABLE `chat_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chat_id` bigint(20) NOT NULL,
  `message` blob,
  `delievered_on` timestamp NULL DEFAULT NULL,
  `is_delievered` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chat_id` (`chat_id`),
  CONSTRAINT `chat_history_ibfk_1` FOREIGN KEY (`chat_id`) REFERENCES `chat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=880 DEFAULT CHARSET=utf8;

insert  into `chat_history`(`id`,`chat_id`,`message`,`delievered_on`,`is_delievered`) values (840,841,'Hi','2017-07-06 18:49:07',NULL),(841,842,'undefined','2017-07-06 18:54:08',NULL),(842,843,'null','2017-07-06 18:54:09',NULL),(843,844,'undefined','2017-07-06 18:55:09',NULL),(844,845,'null','2017-07-06 18:55:10',NULL),(845,846,'null','2017-07-06 18:55:12',NULL),(846,847,'undefined','2017-07-06 19:00:37',NULL),(847,848,'null','2017-07-06 19:00:37',NULL),(848,849,'null','2017-07-06 19:00:38',NULL),(849,850,'null','2017-07-06 19:00:38',NULL),(850,851,'null','2017-07-06 19:00:39',NULL),(851,852,'undefined','2017-07-06 19:01:15',NULL),(852,853,'null','2017-07-06 19:01:16',NULL),(853,854,'null','2017-07-06 19:01:16',NULL),(854,855,'undefined','2017-07-06 19:04:52',NULL),(855,856,'dfdf','2017-07-06 19:09:01',NULL),(856,857,'fdf','2017-07-06 19:09:15',NULL),(857,858,'s','2017-07-06 19:09:30',NULL),(858,859,'undefined','2017-07-06 19:11:26',NULL),(859,860,'null','2017-07-06 19:11:27',NULL),(860,861,'null','2017-07-06 19:11:27',NULL),(861,862,'null','2017-07-06 19:11:27',NULL),(862,863,'null','2017-07-06 19:11:28',NULL),(863,864,'dfdf','2017-07-06 19:11:57',NULL),(864,865,'null','2017-07-06 19:12:00',NULL),(865,866,'xzzv','2017-07-06 19:13:00',NULL),(866,867,'null','2017-07-06 19:13:02',NULL),(867,868,'null','2017-07-06 19:13:03',NULL),(868,869,'null','2017-07-06 19:13:03',NULL),(869,870,'jjk','2017-07-06 19:13:08',NULL),(870,871,'hi','2017-07-06 19:18:38',NULL),(871,872,'ji','2017-07-06 19:18:45',NULL),(872,873,'hi','2017-07-06 19:19:07',NULL),(873,874,'hi','2017-07-07 16:35:53',NULL),(874,875,'hhhhhhhhhhhhhhhhhhhhhhhhhhhh','2017-07-07 16:36:05',NULL),(875,876,'hi','2017-07-07 16:37:10',NULL),(876,877,'how r u?','2017-07-07 16:37:21',NULL),(877,878,'fine','2017-07-07 16:37:32',NULL),(878,879,'bye','2017-07-07 16:37:36',NULL),(879,880,'undefined','2017-07-07 16:39:52',NULL);

