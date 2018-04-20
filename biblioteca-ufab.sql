-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 20-Abr-2018 às 08:07
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblioteca_ufab`
--
CREATE DATABASE IF NOT EXISTS `biblioteca_ufab` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `biblioteca_ufab`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `administradores`
--

CREATE TABLE `administradores` (
  `idadministrador` int(11) NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `rg` varchar(8) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `naturalidade` varchar(25) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `usuario` varchar(10) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `administradores`
--

INSERT INTO `administradores` (`idadministrador`, `cpf`, `rg`, `nome`, `naturalidade`, `endereco`, `telefone`, `email`, `usuario`, `senha`) VALUES
(1, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(2, '09816785678', '12345634', 'Tereza Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'tereza@gmail.com', 'tete', '12345'),
(3, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(4, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(5, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(6, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(7, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(8, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(9, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(10, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(11, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(12, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(13, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(14, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(15, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(16, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(17, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(18, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(19, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(20, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(21, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(22, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(23, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(24, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(25, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(26, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(27, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(28, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(29, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(30, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(31, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(32, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(33, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(34, '09816785678', '12345634', 'Tereza Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'tereza@gmail.com', 'tete', '12345'),
(35, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(36, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(37, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(38, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(39, '09112345678', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `idaluno` int(11) NOT NULL,
  `matricula` varchar(11) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `rg` varchar(8) DEFAULT NULL,
  `naturalidade` varchar(25) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `nome_da_mae` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `curso` int(11) DEFAULT NULL,
  `ano` year(4) DEFAULT NULL,
  `periodo_ingresso` enum('1','2') DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `inadimplente` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`idaluno`, `matricula`, `cpf`, `rg`, `naturalidade`, `nome`, `nome_da_mae`, `endereco`, `telefone`, `curso`, `ano`, `periodo_ingresso`, `senha`, `email`, `inadimplente`) VALUES
(1, 'GCC-181001', '12345678910', '3567890', 'Campina Grande', 'Marcos Gabriel Silva', 'Maria José dos Santos', 'Rua Inventada', '08399994444', 2, 2018, '1', '1234', 'email@mail.com', 0),
(2, 'GAD-141002', '09112345678', '12345678', 'Olivedos', 'João dos Santos', 'Joana dos Santos', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(3, 'GAD-151002', '09112345678', '12345678', 'Olivedos', 'Flavio dos Santos', 'Maria dos Santos', 'Avenida do Cabo', '08399792822', 1, 2015, '1', '4321', NULL, 0),
(4, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(5, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(6, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(7, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(8, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(9, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(10, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(11, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(12, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(13, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(14, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(15, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(16, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(17, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0),
(18, 'GAD-141004', '09112345678', '12345678', 'Pocinhos', 'Pedro da Silva', 'Joana da Silva', 'Avenida do Campo', '08399992222', 1, 2014, '1', '4321', NULL, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `anais`
--

CREATE TABLE `anais` (
  `idanal` int(11) NOT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `autores` varchar(35) DEFAULT NULL,
  `nome_congresso` varchar(35) DEFAULT NULL,
  `ano_publicacao` year(4) DEFAULT NULL,
  `local` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `anais`
--

INSERT INTO `anais` (`idanal`, `titulo`, `tipo`, `autores`, `nome_congresso`, `ano_publicacao`, `local`) VALUES
(1, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(2, 'Seminario de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso 2.0', 2017, 'Rio de Janeiro'),
(3, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(4, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(5, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(6, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(7, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(8, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(9, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(10, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(11, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(12, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(13, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(14, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(15, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(16, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(17, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(18, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(19, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(20, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(21, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(22, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(23, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(24, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(25, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(26, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(27, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(28, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(29, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(30, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(31, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(32, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(33, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia'),
(34, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'Brasilia');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cursos`
--

CREATE TABLE `cursos` (
  `idcurso` int(11) NOT NULL,
  `nome` varchar(25) DEFAULT NULL,
  `codigo` varchar(2) DEFAULT NULL,
  `area` varchar(25) DEFAULT NULL,
  `tipo` enum('G','E','M','D') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cursos`
--

INSERT INTO `cursos` (`idcurso`, `nome`, `codigo`, `area`, `tipo`) VALUES
(1, 'Administração', 'AD', 'Ciências Humamas', 'G'),
(2, 'Ciência da Computação', 'CC', 'Ciências Exatas', 'G'),
(3, 'Direito', 'DI', 'Ciências Humamas', 'G'),
(4, 'Engenharia Elétrica', 'EE', 'Ciências Exatas', 'G'),
(5, 'Engenharia Espacial', 'ES', 'Ciências Exatas', 'G'),
(6, 'Engenharia Mecatrônica', 'EM', 'Ciências Exatas', 'G'),
(7, 'Matemática', 'MA', 'Ciências Exatas', 'G'),
(8, 'Medicina', 'ME', 'Ciências Biológicas', 'G'),
(9, 'Nutrição', 'NU', 'Ciências Biológicas', 'G'),
(10, 'Odontologia', 'OD', 'Ciências Biológicas', 'G'),
(11, 'Psicologia', 'PS', 'Ciências Biológicas', 'G'),
(12, 'Veterinária', 'VE', 'Ciências Biológicas', 'G'),
(13, 'Ciência da Computação', 'CC', 'Ciências Exatas', 'E'),
(14, 'Engenharia Elétrica', 'EE', 'Ciências Exatas', 'E'),
(15, 'Engenharia Espacial', 'ES', 'Ciências Exatas', 'E'),
(16, 'Engenharia Mecatrônica', 'EM', 'Ciências Exatas', 'E'),
(17, 'Psicologia', 'PS', 'Ciências Biológicas', 'E'),
(18, 'Ciência da Computação', 'CC', 'Ciências Exatas', 'M'),
(19, 'Engenharia Elétrica', 'EE', 'Ciências Exatas', 'M'),
(20, 'Engenharia Espacial', 'ES', 'Ciências Exatas', 'M'),
(21, 'Engenharia Mecatrônica', 'EM', 'Ciências Exatas', 'M'),
(22, 'Psicologia', 'PS', 'Ciências Biológicas', 'M'),
(23, 'Ciência da Computação', 'CC', 'Ciências Exatas', 'D'),
(24, 'Engenharia Elétrica', 'EE', 'Ciências Exatas', 'D'),
(25, 'Engenharia Espacial', 'ES', 'Ciências Exatas', 'D'),
(26, 'Engenharia Mecatrônica', 'EM', 'Ciências Exatas', 'D'),
(27, 'Psicologia', 'PS', 'Ciências Biológicas', 'D'),
(28, 'Letras-Ingles', 'LI', 'Ciencias Humanas', 'G'),
(29, 'Letras-Espanhol', 'LE', 'Ciencias Humanas', 'G'),
(30, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(31, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(32, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(33, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(34, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(35, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(36, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(37, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(38, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(39, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(40, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(41, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(42, 'Musica', 'MU', 'Ciencias Humanas', 'G'),
(43, 'Musica', 'MU', 'Ciencias Humanas', 'G');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `idfuncionario` int(11) NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `rg` varchar(8) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `naturalidade` varchar(25) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `usuario` varchar(10) DEFAULT NULL,
  `senha` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`idfuncionario`, `cpf`, `rg`, `nome`, `naturalidade`, `endereco`, `telefone`, `email`, `usuario`, `senha`) VALUES
(2, '1052345678', '8765478', 'Maria Santos', 'Moca', 'Rua do Campo', '08388880000', 'maria@mail.com', 'Mary', '54321'),
(3, '09215345678', '14345578', 'Roberto Freire', 'Moca', 'Rua do Lobos', '08399921222', 'roberto@mail.com', 'Robe', '12345'),
(4, '09112345678', '12345678', 'Silva Ribeiro Campos', 'Soledade', 'Rua do Milho', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(5, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(6, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(7, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(8, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(9, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(10, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(11, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(12, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(13, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(14, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(15, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(16, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(17, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(18, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(19, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(20, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(21, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(22, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(23, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(24, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(25, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(26, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(27, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(28, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(29, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(30, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(31, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(32, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(33, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(34, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(35, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(36, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(37, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(38, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234'),
(39, '09112345678', '12345678', 'Silva Ribeiro', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silva@gmail.com', 'avlis', '1234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `jornais`
--

CREATE TABLE `jornais` (
  `idjornal` int(11) NOT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `editora` varchar(25) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `edicao` varchar(25) DEFAULT NULL,
  `numero_paginas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `jornais`
--

INSERT INTO `jornais` (`idjornal`, `titulo`, `editora`, `data`, `edicao`, `numero_paginas`) VALUES
(1, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(2, 'Jornal Estadual', 'Julho', '2016-11-01', '2º Edição', 15),
(3, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(4, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(5, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(6, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(7, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(8, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(9, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(10, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(11, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(12, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(13, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(14, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(15, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(16, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(17, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(18, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(19, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(20, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(21, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(22, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(23, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(24, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(25, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(26, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(27, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(28, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(29, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(30, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(31, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(32, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(33, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(34, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(35, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12),
(36, 'Jornal Nacional', 'Maio', '2017-11-01', '1º Edição', 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livros`
--

CREATE TABLE `livros` (
  `idlivro` int(11) NOT NULL,
  `isbn` int(11) DEFAULT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `autores` varchar(35) DEFAULT NULL,
  `editora` varchar(25) DEFAULT NULL,
  `ano_publicacao` year(4) DEFAULT NULL,
  `edicao` varchar(25) DEFAULT NULL,
  `numero_paginas` int(11) DEFAULT NULL,
  `area` varchar(25) DEFAULT NULL,
  `tema` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `livros`
--

INSERT INTO `livros` (`idlivro`, `isbn`, `titulo`, `autores`, `editora`, `ano_publicacao`, `edicao`, `numero_paginas`, `area`, `tema`) VALUES
(1, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(2, 345678913, 'Engenharia de Software 3.0', 'Freire, João Paulo', 'Nova Era', 2012, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(3, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(4, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(5, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(6, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(7, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(8, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(9, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(10, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(11, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(12, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(13, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(14, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(15, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(16, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(17, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(18, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(19, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(20, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(21, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(22, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(23, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(24, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(25, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(26, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(27, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(28, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(29, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(30, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(31, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(32, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(33, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(34, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(35, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(36, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(37, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(38, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(39, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(40, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(41, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(42, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(43, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(44, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(45, 345678912, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software');

-- --------------------------------------------------------

--
-- Estrutura da tabela `midias`
--

CREATE TABLE `midias` (
  `idmidia` int(11) NOT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `data_gravacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `midias`
--

INSERT INTO `midias` (`idmidia`, `titulo`, `tipo`, `data_gravacao`) VALUES
(1, 'Java Free', 'DVD', '2013-03-23'),
(2, 'Java 8', 'DVD', '2016-06-29'),
(3, 'Java Free', 'DVD', '2013-03-23'),
(4, 'Java Free', 'DVD', '2013-03-23'),
(5, 'Java Free', 'DVD', '2013-03-23'),
(6, 'Java Free', 'DVD', '2013-03-23'),
(7, 'Java Free', 'DVD', '2013-03-23'),
(8, 'Java Free', 'DVD', '2013-03-23'),
(9, 'Java Free', 'DVD', '2013-03-23'),
(10, 'Java Free', 'DVD', '2013-03-23'),
(11, 'Java Free', 'DVD', '2013-03-23'),
(12, 'Java Free', 'DVD', '2013-03-23'),
(13, 'Java Free', 'DVD', '2013-03-23'),
(14, 'Java Free', 'DVD', '2013-03-23'),
(15, 'Java Free', 'DVD', '2013-03-23'),
(16, 'Java Free', 'DVD', '2013-03-23'),
(17, 'Java Free', 'DVD', '2013-03-23'),
(18, 'Java Free', 'DVD', '2013-03-23'),
(19, 'Java Free', 'DVD', '2013-03-23'),
(20, 'Java Free', 'DVD', '2013-03-23'),
(21, 'Java Free', 'DVD', '2013-03-23'),
(22, 'Java Free', 'DVD', '2013-03-23'),
(23, 'Java Free', 'DVD', '2013-03-23'),
(24, 'Java Free', 'DVD', '2013-03-23'),
(25, 'Java Free', 'DVD', '2013-03-23'),
(26, 'Java Free', 'DVD', '2013-03-23'),
(27, 'Java Free', 'DVD', '2013-03-23'),
(28, 'Java Free', 'DVD', '2013-03-23'),
(29, 'Java Free', 'DVD', '2013-03-23'),
(30, 'Java Free', 'DVD', '2013-03-23'),
(31, 'Java Free', 'DVD', '2013-03-23'),
(32, 'Java Free', 'DVD', '2013-03-23');

-- --------------------------------------------------------

--
-- Estrutura da tabela `revistas`
--

CREATE TABLE `revistas` (
  `idrevista` int(11) NOT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `editora` varchar(25) DEFAULT NULL,
  `data_publicacao` date DEFAULT NULL,
  `edicao` varchar(25) DEFAULT NULL,
  `numero_paginas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `revistas`
--

INSERT INTO `revistas` (`idrevista`, `titulo`, `editora`, `data_publicacao`, `edicao`, `numero_paginas`) VALUES
(1, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(2, 'TV Nova Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(3, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(4, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(5, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(6, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(7, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(8, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(9, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(10, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(11, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(12, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(13, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(14, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(15, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(16, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(17, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(18, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(19, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(20, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(21, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(22, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(23, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(24, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(25, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(26, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(27, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(28, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(29, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(30, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(31, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(32, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(33, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(34, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(35, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(36, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25),
(37, 'TV Escola', 'Abril', '2016-12-04', '12º Edição', 25);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tcc`
--

CREATE TABLE `tcc` (
  `idtcc` int(11) NOT NULL,
  `titulo` varchar(35) DEFAULT NULL,
  `tipo` varchar(15) DEFAULT NULL,
  `autores` varchar(35) DEFAULT NULL,
  `orientador` varchar(35) DEFAULT NULL,
  `ano_defesa` year(4) DEFAULT NULL,
  `local` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tcc`
--

INSERT INTO `tcc` (`idtcc`, `titulo`, `tipo`, `autores`, `orientador`, `ano_defesa`, `local`) VALUES
(1, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(2, 'UML 2.0', 'Tese', 'Alan Turing', 'Robert Hulk', 2014, 'Campina Grande'),
(3, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(4, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(5, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(6, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(7, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(8, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(9, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(10, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(11, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(12, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(13, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(14, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(15, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(16, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(17, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(18, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(19, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(20, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(21, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(22, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(23, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(24, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(25, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(26, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(27, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(28, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(29, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(30, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(31, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(32, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande'),
(33, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campina Grande');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`idadministrador`);

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`idaluno`),
  ADD KEY `curso` (`curso`);

--
-- Indexes for table `anais`
--
ALTER TABLE `anais`
  ADD PRIMARY KEY (`idanal`);

--
-- Indexes for table `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`idcurso`);

--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`idfuncionario`);

--
-- Indexes for table `jornais`
--
ALTER TABLE `jornais`
  ADD PRIMARY KEY (`idjornal`);

--
-- Indexes for table `livros`
--
ALTER TABLE `livros`
  ADD PRIMARY KEY (`idlivro`);

--
-- Indexes for table `midias`
--
ALTER TABLE `midias`
  ADD PRIMARY KEY (`idmidia`);

--
-- Indexes for table `revistas`
--
ALTER TABLE `revistas`
  ADD PRIMARY KEY (`idrevista`);

--
-- Indexes for table `tcc`
--
ALTER TABLE `tcc`
  ADD PRIMARY KEY (`idtcc`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administradores`
--
ALTER TABLE `administradores`
  MODIFY `idadministrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `alunos`
--
ALTER TABLE `alunos`
  MODIFY `idaluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `anais`
--
ALTER TABLE `anais`
  MODIFY `idanal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `cursos`
--
ALTER TABLE `cursos`
  MODIFY `idcurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `jornais`
--
ALTER TABLE `jornais`
  MODIFY `idjornal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `livros`
--
ALTER TABLE `livros`
  MODIFY `idlivro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT for table `midias`
--
ALTER TABLE `midias`
  MODIFY `idmidia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `revistas`
--
ALTER TABLE `revistas`
  MODIFY `idrevista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `tcc`
--
ALTER TABLE `tcc`
  MODIFY `idtcc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `alunos`
--
ALTER TABLE `alunos`
  ADD CONSTRAINT `alunos_ibfk_1` FOREIGN KEY (`curso`) REFERENCES `cursos` (`idcurso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
