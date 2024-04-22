INSERT INTO `users` (`id`, `email`, `name`, `password`, `role`, `created_at`, `updated_at`) VALUES 
(1, 'patrick.valeri@free.fr', 'patrick_free', 'pval77', 'USER', '2024-04-11 18:16:30', '2024-04-11 18:16:30'), 
(2, 'patrick.valeri@gmail.fr', 'patrick_gmail', 'pval77', 'USER', '2024-04-11 19:38:59', '2024-04-11 19:38:59'),
(3, 'patrick.p.valeri.v@gmail.com', 'patrick_v_gmail', 'pval77', 'USER', '2024-04-12 06:24:18', '2024-04-12 06:24:18'),
(4, 'patrick.p.valeri.v@free.com', 'patrick_v_free', 'pval77', 'USER', '2024-04-12 06:40:02', '2024-04-12 06:40:02'),
(5, 'alfred.demusset@test.fr', 'alfred', 'pval77', 'USER', '2024-04-12 20:57:14', '2024-04-12 20:57:14'),
(6, 'admin@user.fr', 'admin', 'admin', 'ADMIN', '2024-04-13 06:48:27', '2024-04-13 06:48:27'),
(7, 'user@user.fr', 'user', 'user', 'USER', '2024-04-13 07:07:53', '2024-04-13 07:07:53');
INSERT INTO `rentals` (`id`, `name`, `surface`, `price`, `picture`, `description`, `owner_id`, `created_at`, `updated_at`) VALUES
(1, 'studio', 28, 12000, '', 'Très calme avec jolie vue', 5, '2024-03-30 23:00:00', '2024-04-11 07:59:53'),
(2, 'maison', 78, 230000, '', 'Jolie maison avec 700 m² de terrain', 6, '2024-02-29 23:00:00', '2024-03-31 22:00:00');