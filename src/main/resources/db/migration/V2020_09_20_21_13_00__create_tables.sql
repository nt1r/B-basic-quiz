CREATE TABLE `cv_user` (
  `id`          bigint(20)     NOT NULL AUTO_INCREMENT,
  `name`        varchar(128)   NOT NULL,
  `age`         bigint(20)     NOT NULL,
  `avatar`      varchar(255)   NOT NULL,
  `description` varchar(255),
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `cv_education` (
  `id`          bigint(20)     NOT NULL AUTO_INCREMENT,
  `year`        bigint(20)     NOT NULL,
  `title`       varchar(255)   NOT NULL,
  `description` varchar(255)   NOT NULL,
  `user_id`     bigint(20)     NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_education_user` (`user_id`),
  CONSTRAINT `fk_education_user` FOREIGN KEY (`user_id`) REFERENCES `cv_user` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;