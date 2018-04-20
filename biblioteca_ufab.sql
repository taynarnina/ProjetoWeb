-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 20-Abr-2018 às 16:04
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
(1, '09112345675', '12345678', 'Silvio Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'silvio@gmail.com', 'oivlis', '1234'),
(2, '09816785678', '12345634', 'Tereza Telo', 'Pocinhos', 'Avenida do Campo', '08399992222', 'tereza@gmail.com', 'tete', '12345');

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
(3, 'GAD-151002', '09112345678', '12345678', 'Olivedos', 'Flavio dos Santos', 'Maria dos Santos', 'Avenida do Cabo', '08399792822', 1, 2015, '1', '4321', NULL, 0);

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
(1, 'Seminario Nacional de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso', 2015, 'São Paulo'),
(2, 'Seminario de Literatura', 'Artigo', 'JK Rowling', 'Hogwarts Congresso 2.0', 2017, 'Rio de Janeiro');

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
(29, 'Letras-Espanhol', 'LE', 'Ciencias Humanas', 'G');

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
(4, '09112345678', '12345678', 'Silva Ribeiro Campos', 'Soledade', 'Rua do Milho', '08399992222', 'silva@gmail.com', 'avlis', '1234');

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
(1, 'Jornal Nacional', 'Barla', '2017-10-01', '1º Edição', 12),
(2, 'Jornal Estadual', 'Julho', '2016-11-01', '2º Edição', 15);

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
(1, 345678911, 'Engenharia de Software', 'Freire, João Paulo', 'Nova Era', 2010, '2º Edição', 255, 'Computacao', 'Engenharia de Software'),
(2, 345678913, 'Engenharia de Software 3.0', 'Freire, João Paulo', 'Nova Era', 2012, '2º Edição', 255, 'Computacao', 'Engenharia de Software');

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
(1, 'Java Doc', 'DVD', '2013-03-23'),
(2, 'Java 8', 'DVD', '2016-06-29');

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
(1, 'TV Escola', 'Março', '2016-12-04', '12º Edição', 25),
(2, 'TV Nova Escola', 'Dezembro', '2016-12-04', '12º Edição', 25);

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
(1, 'UML na pratica', 'Monografia', 'Alan Turing', 'Robert Hulk', 2010, 'Campinas'),
(2, 'UML 2.0', 'Tese', 'Alan Turing', 'Robert Hulk', 2014, 'Patos');

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
  MODIFY `idadministrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `alunos`
--
ALTER TABLE `alunos`
  MODIFY `idaluno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `anais`
--
ALTER TABLE `anais`
  MODIFY `idanal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `cursos`
--
ALTER TABLE `cursos`
  MODIFY `idcurso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `idfuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `jornais`
--
ALTER TABLE `jornais`
  MODIFY `idjornal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `livros`
--
ALTER TABLE `livros`
  MODIFY `idlivro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `midias`
--
ALTER TABLE `midias`
  MODIFY `idmidia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `revistas`
--
ALTER TABLE `revistas`
  MODIFY `idrevista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `tcc`
--
ALTER TABLE `tcc`
  MODIFY `idtcc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

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
