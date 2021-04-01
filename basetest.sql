-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 08, 2021 at 11:48 AM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `basetest`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idclient` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `dateNaissance` varchar(45) NOT NULL,
  `adresse` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `tel` int(8) NOT NULL,
  `cin` varchar(45) NOT NULL,
  PRIMARY KEY (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`idclient`, `nom`, `prenom`, `dateNaissance`, `adresse`, `email`, `tel`, `cin`) VALUES
(1, 'habib', 'charfeddine', 'aaaa', 'aaaa', 'aaa', 22222, '111115272');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `idemployee` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `dateNaissance` varchar(45) NOT NULL,
  `adresse` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `tel` int(11) NOT NULL,
  `cin` varchar(45) NOT NULL,
  `motdepass` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idemployee`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`idemployee`, `nom`, `prenom`, `dateNaissance`, `adresse`, `email`, `tel`, `cin`, `motdepass`) VALUES
(4, '33', '22', '2018-12-11', '14', '14', 14, '11', 'pp');

-- --------------------------------------------------------

--
-- Table structure for table `endroit`
--

DROP TABLE IF EXISTS `endroit`;
CREATE TABLE IF NOT EXISTS `endroit` (
  `id_endroit` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  `taille` int(11) NOT NULL,
  `prix_jour` int(11) NOT NULL,
  `nbrch` int(11) NOT NULL,
  `location` varchar(30) DEFAULT NULL,
  `disponibilite` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_endroit`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `endroit`
--

INSERT INTO `endroit` (`id_endroit`, `type`, `taille`, `prix_jour`, `nbrch`, `location`, `disponibilite`) VALUES
(5, 'zaddazdz', 10, 20, 10, 'azdazd', 'disponible');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int(10) NOT NULL AUTO_INCREMENT,
  `idclient` int(11) NOT NULL,
  `matricule` int(10) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `date_retour` varchar(45) DEFAULT NULL,
  `Cautionnement` int(11) NOT NULL,
  `prix_total` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `_idx` (`idclient`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `idclient`, `matricule`, `date_debut`, `date_fin`, `date_retour`, `Cautionnement`, `prix_total`) VALUES
(17, 1, 2, '2021-03-19', '2021-03-29', '2021-03-29', 10, '0');

-- --------------------------------------------------------

--
-- Table structure for table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `matricule` varchar(10) NOT NULL,
  `marque` varchar(45) NOT NULL,
  `modele` varchar(45) NOT NULL,
  `puissance` varchar(45) NOT NULL,
  `prix_jour` int(11) NOT NULL,
  `penalisation_jour` int(11) NOT NULL,
  `assurance` varchar(45) NOT NULL,
  `visite` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `capacite` int(11) DEFAULT NULL,
  `nbPlace` int(11) DEFAULT NULL,
  `disponibilite` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vehicule`
--

INSERT INTO `vehicule` (`matricule`, `marque`, `modele`, `puissance`, `prix_jour`, `penalisation_jour`, `assurance`, `visite`, `type`, `capacite`, `nbPlace`, `disponibilite`) VALUES
('111', '111', 'azdaz', '100', 10, 5, '2021-03-27', '2021-03-19', 'bus', NULL, 10, 'Non disponible'),
('111tun1111', 'zazdazaz', 'azdazda', '111', 10, 5, '2021-03-20', '2021-03-10', 'voiture', NULL, NULL, 'Non disponible');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `idclient` FOREIGN KEY (`idclient`) REFERENCES `client` (`idclient`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
