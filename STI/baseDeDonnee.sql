# ************************************************************
# Sequel Pro SQL dump
# Version 4135
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.21)
# Database: sti
# Generation Time: 2014-12-16 16:54:11 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Messagerie
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Messagerie`;

CREATE TABLE `Messagerie` (
  `idMessage` int(11) NOT NULL AUTO_INCREMENT,
  `idAuteur` int(11) DEFAULT NULL,
  `contenu` text,
  `typeMessage` varchar(256) DEFAULT '',
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `dateMessage` varchar(256) DEFAULT '',
  `destinataire` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`idMessage`)
) ENGINE=InnoDB AUTO_INCREMENT=449 DEFAULT CHARSET=latin1;

LOCK TABLES `Messagerie` WRITE;
/*!40000 ALTER TABLE `Messagerie` DISABLE KEYS */;

INSERT INTO `Messagerie` (`idMessage`, `idAuteur`, `contenu`, `typeMessage`, `longitude`, `latitude`, `dateMessage`, `destinataire`)
VALUES
	(100,1,'Accident signalÃ©','accident',48.85341,2.3488,'','0'),
	(200,1,'Bouchon signalé','bouchon',48.86341,2.3488,'','0'),
	(300,1,'Panne signalée','panne',48.84341,2.3488,'','1'),
	(400,1,'Accident signalé','accident',48.85341,2.359,'','1'),
	(408,1,'Bouchon signalé !','bouchon',48.86341,2.36,'','2'),
	(409,1,'essage','messagePersonnalise',48.86341,2.36,'','0'),
	(410,1,'Panne signalée !','panne',2.36,48.86341,'',NULL),
	(411,1,'Bouchon signalé !','bouchon',2.36,48.86341,'',NULL),
	(412,1,'fds','messagePersonnalise',1,1,'',NULL),
	(413,1,'fds','messagePersonnalise',1,1,'',NULL),
	(414,1,'fds','messagePersonnalise',1,1,'',NULL),
	(415,1,'jkkjkj','accident',1,1,'',NULL),
	(416,1,'jkkjkj','accident',1,1,'',NULL),
	(417,1,'jkjkjkjkjk','accident',1,1,'',NULL),
	(418,1,'jkjkjkjkjk','accident',1,1,'',NULL),
	(419,1,'Vous vous trouvez a la positionautomobilistePosition{latitude=2.0, longitude=3.0}vous voulez vous rendre au parking le plus proche de positionTrajet{distance=3, paths=[], tempsmoyen=1.0, nom=napoleon III}','accident',1,1,'',NULL),
	(420,1,'Vous vous trouvez a la positionautomobilistePosition{latitude=2.0, longitude=3.0}vous voulez vous rendre au parking le plus proche de positionTrajet{distance=3, paths=[], tempsmoyen=1.0, nom=napoleon III}','accident',1,1,'',NULL),
	(421,1,'  Le parking pk1 est ouvert    Le parking pk2 est ferme  ','accident',1,1,'',NULL),
	(422,1,'Frank se trouve  un point PointAPosition{latitude=0.0, longitude=0.0}il veut se rendre  un point PointBPosition{latitude=1.0, longitude=1.0}Le chemin le plus court est : Trajet{distance=12, paths=[], tempsmoyen=1.0, nom=Route 66}','messagePersonnalise',1,1,'',NULL),
	(423,1,'Frank se trouve  un point PointAPosition{latitude=0.0, longitude=0.0}il veut se rendre  un point PointBPosition{latitude=1.0, longitude=1.0}Le chemin le plus court est : Trajet{distance=12, paths=[], tempsmoyen=1.0, nom=Route 66}','messagePersonnalise',1,1,'',NULL),
	(424,1,'Assez de carburant ?: true134km','messagePersonnalise',1,1,'',NULL),
	(425,1,'Vous vous trouvez a la positionautomobilistePosition{latitude=2.0, longitude=3.0}vous voulez vous rendre au parking le plus proche de positionTrajet{distance=3, paths=[], tempsmoyen=1.0, nom=napoleon III}','accident',1,1,'',NULL),
	(426,1,'Vous vous trouvez a la positionautomobilistePosition{latitude=2.0, longitude=3.0}vous voulez vous rendre au parking le plus proche de positionTrajet{distance=3, paths=[], tempsmoyen=1.0, nom=napoleon III}','accident',1,1,'',NULL),
	(427,1,'vous voulez vous rendre au parking le plus proche de positionTrajet{distance=3, paths=[], tempsmoyen=1.0, nom=napoleon III}','accident',1,1,'',NULL),
	(428,1,'  Le parking pk1 est ouvert    Le parking pk2 est ferme  ','accident',1,1,'',NULL),
	(429,1,'Assez de carburant ?: true  134km','messagePersonnalise',1,1,'',NULL),
	(430,1,'Frank se trouve  un point PointAPosition{latitude=0.0, longitude=0.0}il veut se rendre  un point PointBPosition{latitude=1.0, longitude=1.0}Le chemin le plus court est : Trajet{distance=12, paths=[], tempsmoyen=1.0, nom=Route 66}','messagePersonnalise',1,1,'',NULL),
	(431,1,'vous voulez vous rendre au parking le plus proche de positionTrajet{distance=3, paths=[], tempsmoyen=1.0, nom=napoleon III}','messagePersonnalise',1,1,'',NULL),
	(432,1,'  Le parking pk1 est ouvert    Le parking pk2 est ferme  ','messagePersonnalise',1,1,'',NULL),
	(433,1,'En gnral il vaut mieux passer par Boulevard napoleon III a 11h23 il est plus avise de passer par la voie rapide','messagePersonnalise',1,1,'',NULL),
	(434,1,'Assez de carburant ?: true  134km','messagePersonnalise',1,1,'',NULL),
	(435,1,'Frank se trouve  un point PointAPosition{latitude=0.0, longitude=0.0}il veut se rendre  un point PointBPosition{latitude=1.0, longitude=1.0}Le chemin le plus court est : Trajet{distance=12, paths=[], tempsmoyen=1.0, nom=Route 66}','messagePersonnalise',1,1,'',NULL),
	(436,1,'En gnral il vaut mieux passer par Boulevard napoleon III a 11h23 il est plus avise de passer par la voie rapide','messagePersonnalise',1,1,'',NULL),
	(437,1,'  Le parking pk1 est ouvert    Le parking pk2 est ferme  ','messagePersonnalise',1,1,'',NULL),
	(438,1,'En gnral il vaut mieux passer par Boulevard napoleon III a 11h23 il est plus avise de passer par la voie rapide','messagePersonnalise',1,1,'',NULL),
	(439,1,'Assez de carburant ?: true  134km','messagePersonnalise',1,1,'',NULL),
	(440,1,'Frank se trouve  un point PointAPosition{latitude=0.0, longitude=0.0}il veut se rendre  un point PointBPosition{latitude=1.0, longitude=1.0}Le chemin le plus court est : Trajet{distance=12, paths=[], tempsmoyen=1.0, nom=Route 66}','messagePersonnalise',1,1,'',NULL),
	(441,1,'Bonjour','messagePersonnalise',48.86341,2.36,'',NULL),
	(442,1,'Panne signalée !','panne',48.86341,2.36,'',NULL),
	(443,1,'Accident signalé !','accident',48.86341,2.36,'',NULL),
	(444,1,'vous voulez vous rendre au parking le plus proche de positionTrajet{distance=3, paths=[], tempsmoyen=1.0, nom=napoleon III}','messagePersonnalise',1,1,'',NULL),
	(445,1,'  Le parking pk1 est ouvert    Le parking pk2 est ferme  ','messagePersonnalise',1,1,'',NULL),
	(446,1,'En general il vaut mieux passer par Boulevard napoleon III a 11h23 il est plus avise de passer par la rue Louis XVI','messagePersonnalise',1,1,'',NULL),
	(447,1,'Assez de carburant ?: true  134km','messagePersonnalise',1,1,'',NULL),
	(448,1,'Frank se trouve  un point PointAPosition{latitude=0.0, longitude=0.0}il veut se rendre  un point PointBPosition{latitude=1.0, longitude=1.0}Le chemin le plus court est : Trajet{distance=12, paths=[], tempsmoyen=1.0, nom=Route 66}','messagePersonnalise',1,1,'',NULL);

/*!40000 ALTER TABLE `Messagerie` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table User
# ------------------------------------------------------------

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `panneMessage` tinyint(1) DEFAULT NULL,
  `accidentMessage` tinyint(1) DEFAULT NULL,
  `messagePersonnalise` tinyint(1) DEFAULT NULL,
  `numTel` int(11) DEFAULT NULL,
  `identification` varchar(256) DEFAULT NULL,
  `bouchonMessage` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;

INSERT INTO `User` (`idUser`, `latitude`, `longitude`, `panneMessage`, `accidentMessage`, `messagePersonnalise`, `numTel`, `identification`, `bouchonMessage`)
VALUES
	(1,48.86341,2.36,1,1,1,0,'Tim Keynes',1),
	(2,8228,8282,1,1,1,0,'Francois Chastel',1);

/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
