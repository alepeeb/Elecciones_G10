-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-07-2022 a las 04:34:56
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_elecciones_g10`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_cadidatosxeleccion`
--

CREATE TABLE `tbl_cadidatosxeleccion` (
  `id_candidato` varchar(100) NOT NULL,
  `id_eleccion` int(100) NOT NULL,
  `fecha_asociacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_candidatos`
--

CREATE TABLE `tbl_candidatos` (
  `id_candidato` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `partido_politico` varchar(100) DEFAULT NULL,
  `ciudad_origen` varchar(100) DEFAULT NULL,
  `descripcion` text NOT NULL,
  `mensaje_campania` varchar(100) DEFAULT NULL,
  `propuestas` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_elecciones`
--

CREATE TABLE `tbl_elecciones` (
  `id_eleccion` int(100) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `fecha_insercion` date DEFAULT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `ganador` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_propuestas`
--

CREATE TABLE `tbl_propuestas` (
  `id_propuesta` int(11) NOT NULL,
  `id_candidato` varchar(20) DEFAULT NULL,
  `fecha_insercion` date DEFAULT NULL,
  `sector` varchar(20) DEFAULT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_votantes`
--

CREATE TABLE `tbl_votantes` (
  `id_votante` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_votos`
--

CREATE TABLE `tbl_votos` (
  `id_voto` int(11) NOT NULL,
  `id_votante` varchar(100) DEFAULT NULL,
  `id_candidato` varchar(100) DEFAULT NULL,
  `id_eleccion` int(11) DEFAULT NULL,
  `fecha_insercion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_cadidatosxeleccion`
--
ALTER TABLE `tbl_cadidatosxeleccion`
  ADD PRIMARY KEY (`id_candidato`,`id_eleccion`),
  ADD KEY `id_eleccion` (`id_eleccion`);

--
-- Indices de la tabla `tbl_candidatos`
--
ALTER TABLE `tbl_candidatos`
  ADD PRIMARY KEY (`id_candidato`);

--
-- Indices de la tabla `tbl_elecciones`
--
ALTER TABLE `tbl_elecciones`
  ADD PRIMARY KEY (`id_eleccion`);

--
-- Indices de la tabla `tbl_propuestas`
--
ALTER TABLE `tbl_propuestas`
  ADD PRIMARY KEY (`id_propuesta`),
  ADD KEY `id_candidato` (`id_candidato`);

--
-- Indices de la tabla `tbl_votantes`
--
ALTER TABLE `tbl_votantes`
  ADD PRIMARY KEY (`id_votante`);

--
-- Indices de la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  ADD PRIMARY KEY (`id_voto`),
  ADD KEY `id_votante` (`id_votante`),
  ADD KEY `id_candidato` (`id_candidato`),
  ADD KEY `id_eleccion` (`id_eleccion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_elecciones`
--
ALTER TABLE `tbl_elecciones`
  MODIFY `id_eleccion` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_propuestas`
--
ALTER TABLE `tbl_propuestas`
  MODIFY `id_propuesta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  MODIFY `id_voto` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_cadidatosxeleccion`
--
ALTER TABLE `tbl_cadidatosxeleccion`
  ADD CONSTRAINT `tbl_cadidatosxeleccion_ibfk_1` FOREIGN KEY (`id_candidato`) REFERENCES `tbl_candidatos` (`id_candidato`),
  ADD CONSTRAINT `tbl_cadidatosxeleccion_ibfk_2` FOREIGN KEY (`id_eleccion`) REFERENCES `tbl_elecciones` (`id_eleccion`);

--
-- Filtros para la tabla `tbl_propuestas`
--
ALTER TABLE `tbl_propuestas`
  ADD CONSTRAINT `tbl_propuestas_ibfk_1` FOREIGN KEY (`id_candidato`) REFERENCES `tbl_candidatos` (`id_candidato`);

--
-- Filtros para la tabla `tbl_votos`
--
ALTER TABLE `tbl_votos`
  ADD CONSTRAINT `tbl_votos_ibfk_1` FOREIGN KEY (`id_votante`) REFERENCES `tbl_votantes` (`id_votante`),
  ADD CONSTRAINT `tbl_votos_ibfk_2` FOREIGN KEY (`id_candidato`) REFERENCES `tbl_candidatos` (`id_candidato`),
  ADD CONSTRAINT `tbl_votos_ibfk_3` FOREIGN KEY (`id_eleccion`) REFERENCES `tbl_elecciones` (`id_eleccion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
