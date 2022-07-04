-- test_db.`member` definition

CREATE TABLE `member` (
  `seq` int NOT NULL AUTO_INCREMENT,
  `id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;