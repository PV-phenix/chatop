CREATE DATABASE IF NOT EXISTS CHATOP;

USE CHATOP;


CREATE TABLE IF NOT EXISTS `USERS` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `email` varchar(100),
  `name` varchar(255),
  `password` varchar(255),
  `role` varchar(255), 
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE IF NOT EXISTS `RENTALS` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `surface` numeric,
  `price` numeric,
  `picture` varchar(255),
  `description` varchar(2000),
  `owner_id` integer NOT NULL,
  `created_at` timestamp,
  `updated_at` timestamp
);

CREATE TABLE IF NOT EXISTS `MESSAGES` (
  `id` integer PRIMARY KEY AUTO_INCREMENT,
  `rental_id` integer,
  `user_id` integer,
  `message` varchar(2000),
  `created_at` timestamp,
  `updated_at` timestamp
);

ALTER TABLE `USERS` DROP INDEX `USERS_index`;

CREATE UNIQUE INDEX `USERS_index` ON `USERS` (`email`);

ALTER TABLE `USERS` ADD FOREIGN KEY (`id`) REFERENCES `RENTALS` (`owner_id`);

ALTER TABLE `USERS` ADD FOREIGN KEY (`id`) REFERENCES `MESSAGES` (`user_id`);

ALTER TABLE `RENTALS` ADD FOREIGN KEY (`id`) REFERENCES `MESSAGES` (`rental_id`);
