CREATE TABLE `s_user` (
  `name` varchar(30) NOT NULL,
  `age` int(11) NOT NULL DEFAULT '0',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `version` bigint(20) NOT NULL,
  UNIQUE KEY `s_user_name_IDX` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci