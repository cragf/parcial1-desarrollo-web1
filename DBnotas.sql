-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               12.2.2-MariaDB - MariaDB Server
-- Server OS:                    Win64
-- HeidiSQL Version:             12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for p1dw1
CREATE DATABASE IF NOT EXISTS `p1dw1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `p1dw1`;

-- Dumping structure for table p1dw1.estudiantes
CREATE TABLE IF NOT EXISTS `estudiantes` (
  `IDestudiantes` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDestudiantes`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table p1dw1.estudiantes: ~8 rows (approximately)
DELETE FROM `estudiantes`;
INSERT INTO `estudiantes` (`IDestudiantes`, `nombre`) VALUES
	(1, 'Pepe Mujica'),
	(2, 'Leonardo Gomez'),
	(3, 'Diego Victoria'),
	(4, 'Francisco Garcia'),
	(5, 'Vicente Domingez'),
	(6, 'Maria Cortes'),
	(7, 'Luna Torres'),
	(8, 'Soledad Guzman');

-- Dumping structure for table p1dw1.notas
CREATE TABLE IF NOT EXISTS `notas` (
  `IDnota` int(11) NOT NULL AUTO_INCREMENT,
  `ID_estudiante` int(11) NOT NULL DEFAULT 0,
  `matematica` int(11) DEFAULT NULL,
  `naturales` int(11) DEFAULT NULL,
  `sociales` int(11) DEFAULT NULL,
  `lengua` int(11) DEFAULT NULL,
  `mes` enum('ene','feb','mar','abr','may','jun','jul','ago','sep','oct','nov','dic') DEFAULT NULL,
  PRIMARY KEY (`IDnota`),
  KEY `ID_estudiante` (`ID_estudiante`),
  CONSTRAINT `FK__estudiantes` FOREIGN KEY (`ID_estudiante`) REFERENCES `estudiantes` (`IDestudiantes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table p1dw1.notas: ~96 rows (approximately)
DELETE FROM `notas`;
INSERT INTO `notas` (`IDnota`, `ID_estudiante`, `matematica`, `naturales`, `sociales`, `lengua`, `mes`) VALUES
	(1, 1, 96, 90, 82, 77, 'ene'),
	(2, 1, 85, 95, 80, 72, 'feb'),
	(3, 1, 96, 92, 87, 85, 'mar'),
	(4, 1, 91, 86, 89, 87, 'abr'),
	(5, 1, 89, 98, 96, 75, 'may'),
	(6, 1, 88, 79, 93, 84, 'jun'),
	(7, 1, 90, 71, 98, 95, 'jul'),
	(8, 1, 98, 87, 91, 98, 'ago'),
	(9, 1, 97, 84, 91, 79, 'sep'),
	(13, 2, 76, 82, 100, 60, 'ene'),
	(14, 2, 90, 81, 74, 84, 'feb'),
	(15, 2, 80, 74, 85, 94, 'mar'),
	(16, 2, 90, 80, 90, 88, 'abr'),
	(17, 2, 77, 83, 62, 93, 'may'),
	(18, 2, 84, 70, 77, 96, 'jun'),
	(19, 2, 97, 73, 79, 91, 'jul'),
	(20, 2, 87, 79, 91, 81, 'ago'),
	(21, 2, 94, 61, 70, 79, 'sep'),
	(25, 3, 99, 74, 76, 97, 'ene'),
	(26, 3, 74, 64, 100, 80, 'feb'),
	(27, 3, 93, 91, 73, 94, 'mar'),
	(28, 3, 63, 76, 70, 78, 'abr'),
	(29, 3, 64, 80, 66, 92, 'may'),
	(30, 3, 81, 92, 82, 75, 'jun'),
	(31, 3, 86, 96, 96, 67, 'jul'),
	(32, 3, 77, 72, 94, 86, 'ago'),
	(33, 3, 73, 79, 83, 79, 'sep'),
	(37, 4, 98, 80, 88, 93, 'ene'),
	(38, 4, 70, 90, 100, 95, 'feb'),
	(39, 4, 96, 85, 76, 99, 'mar'),
	(40, 4, 94, 78, 72, 99, 'abr'),
	(41, 4, 78, 95, 60, 85, 'may'),
	(42, 4, 81, 66, 74, 72, 'jun'),
	(43, 4, 97, 98, 86, 76, 'jul'),
	(44, 4, 88, 78, 100, 66, 'ago'),
	(45, 4, 91, 97, 79, 75, 'sep'),
	(49, 5, 80, 64, 100, 60, 'ene'),
	(50, 5, 78, 79, 95, 78, 'feb'),
	(51, 5, 91, 79, 93, 79, 'mar'),
	(52, 5, 69, 70, 83, 89, 'abr'),
	(53, 5, 94, 87, 85, 74, 'may'),
	(54, 5, 77, 80, 78, 100, 'jun'),
	(55, 5, 64, 86, 85, 88, 'jul'),
	(56, 5, 66, 85, 99, 88, 'ago'),
	(57, 5, 82, 93, 85, 93, 'sep'),
	(61, 6, 75, 65, 87, 78, 'ene'),
	(62, 6, 97, 90, 61, 86, 'feb'),
	(63, 6, 92, 76, 63, 80, 'mar'),
	(64, 6, 78, 75, 93, 86, 'abr'),
	(65, 6, 80, 69, 95, 66, 'may'),
	(66, 6, 72, 76, 100, 65, 'jun'),
	(67, 6, 98, 84, 83, 98, 'jul'),
	(68, 6, 60, 93, 77, 97, 'ago'),
	(69, 6, 66, 65, 98, 86, 'sep'),
	(73, 7, 82, 71, 86, 77, 'ene'),
	(74, 7, 86, 93, 92, 89, 'feb'),
	(75, 7, 99, 81, 82, 62, 'mar'),
	(76, 7, 79, 63, 64, 70, 'abr'),
	(77, 7, 80, 100, 71, 60, 'may'),
	(78, 7, 89, 78, 76, 65, 'jun'),
	(79, 7, 76, 63, 83, 98, 'jul'),
	(80, 7, 99, 79, 94, 60, 'ago'),
	(81, 7, 62, 76, 76, 74, 'sep'),
	(85, 8, 72, 68, 77, 86, 'ene'),
	(86, 8, 92, 85, 85, 89, 'feb'),
	(87, 8, 88, 78, 72, 67, 'mar'),
	(88, 8, 78, 78, 94, 66, 'abr'),
	(89, 8, 89, 89, 99, 68, 'may'),
	(90, 8, 68, 78, 91, 94, 'jun'),
	(91, 8, 90, 92, 61, 64, 'jul'),
	(92, 8, 66, 77, 70, 74, 'ago'),
	(93, 8, 87, 65, 72, 78, 'sep');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
