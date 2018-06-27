CREATE TABLE IF NOT EXISTS `country` (
  `id` int NOT NULL auto_increment,
  `registration_date` datetime NOT NULL,
  `language` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `population` int NOT NULL,
  PRIMARY KEY  (`id`)
) ;