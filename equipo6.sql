-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-04-2021 a las 17:51:11
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `equipo6`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `idDireccion` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `apellido`, `email`, `sexo`, `idDireccion`, `id`) VALUES
('juan', 'guzman', 'adsdf@gmail.com', 'masculino', 12, 1),
('Ricardo', 'Garcia', 'ricardo@gmail.com', 'Masculino', 3, 2),
('Ricardo3', 'Garcia', 'ricardo@gmail.com', 'Masculino', 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventas`
--

CREATE TABLE `detalleventas` (
  `ventaId` int(11) NOT NULL,
  `productoId` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalleventas`
--

INSERT INTO `detalleventas` (`ventaId`, `productoId`, `cantidad`) VALUES
(1, 2, 5),
(3, 2, 3),
(2, 2, 2),
(3, 1, 4),
(8, 4, 1),
(9, 4, 1),
(10, 2, 1),
(11, 2, 3),
(12, 2, 10),
(12, 3, 2),
(13, 2, 2),
(14, 2, 5),
(14, 2, 2),
(15, 2, 2),
(15, 2, 2),
(16, 2, 2),
(16, 2, 2),
(16, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direccion`
--

CREATE TABLE `direccion` (
  `idDireccion` int(11) NOT NULL,
  `calle` varchar(80) NOT NULL,
  `numero` int(11) NOT NULL,
  `colonia` varchar(100) NOT NULL,
  `ciudad` varchar(80) NOT NULL,
  `estado` varchar(80) NOT NULL,
  `pais` varchar(80) NOT NULL,
  `codigoPostal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `direccion`
--

INSERT INTO `direccion` (`idDireccion`, `calle`, `numero`, `colonia`, `ciudad`, `estado`, `pais`, `codigoPostal`) VALUES
(1, 'independencia', 110, 'linda vista', 'oaxaca de juarez', 'oaxaca', 'mexico', 39220),
(3, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(12, 'nose', 3, 'frgr', 'rgrg', 'oaxaca', 'mexico', 4523),
(13, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(14, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(15, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(16, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(17, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000),
(19, 'Micaela Galindo', 3, 'Centro', 'Huajuapan', 'Oaxaca', 'Mexico', 69000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganancias`
--

CREATE TABLE `ganancias` (
  `idGanancia` int(11) NOT NULL,
  `ventaId` int(11) NOT NULL,
  `totalGanancia` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ganancias`
--

INSERT INTO `ganancias` (`idGanancia`, `ventaId`, `totalGanancia`, `fecha`) VALUES
(1, 1, 22.5, '2021-04-06'),
(3, 3, 33.24, '2021-04-26'),
(4, 3, 11.2, '2019-07-08'),
(8, 9, 601.8, '2019-07-08'),
(10, 11, 36, '2019-07-08'),
(13, 12, 120, '2019-07-08'),
(14, 12, 23.3, '2021-04-07'),
(15, 13, 24, '2019-07-08'),
(16, 14, 60, '2019-07-08'),
(17, 15, 24, '2019-07-08'),
(18, 15, 24, '2019-07-08'),
(19, 16, 24, '2019-07-08'),
(20, 16, 24, '2019-07-08'),
(21, 16, 300.9, '2019-07-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `idMarca` int(11) NOT NULL,
  `nombreMarca` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`idMarca`, `nombreMarca`) VALUES
(1, 'Vans'),
(2, 'Gucci');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  `precioVta` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `marcaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombre`, `precio`, `precioVta`, `cantidad`, `marcaId`) VALUES
(1, 'carro', 23.1, 324, 3, 2),
(2, 'telefono', 33.2, 45.2, 6, 1),
(3, 'carro', 23.34, 45.2, 2, 2),
(4, 'carro', 23.34, 45.2, 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `clienteId` int(11) NOT NULL,
  `totalVenta` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVenta`, `clienteId`, `totalVenta`, `fecha`) VALUES
(1, 2, 213.5, '2021-04-05'),
(2, 1, 45.2, '2021-04-02'),
(3, 3, 233.5, '2019-07-08'),
(6, 1, 45.2, '2019-07-08'),
(7, 1, 45.2, '2019-07-08'),
(8, 1, 45.2, '2019-07-08'),
(9, 1, 45.2, '2019-07-08'),
(10, 1, 648, '2019-07-08'),
(11, 1, 452, '2019-07-08'),
(12, 1, 542.4, '2019-07-08'),
(13, 1, 90.4, '2019-07-08'),
(14, 1, 316.4, '2019-07-08'),
(15, 1, 90.4, '2019-07-08'),
(16, 1, 504.8, '2019-07-08');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idDireccion` (`idDireccion`);

--
-- Indices de la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD KEY `productoId` (`productoId`),
  ADD KEY `ventaId` (`ventaId`);

--
-- Indices de la tabla `direccion`
--
ALTER TABLE `direccion`
  ADD PRIMARY KEY (`idDireccion`);

--
-- Indices de la tabla `ganancias`
--
ALTER TABLE `ganancias`
  ADD PRIMARY KEY (`idGanancia`),
  ADD KEY `ventaId` (`ventaId`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`idMarca`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `marcaId` (`marcaId`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `clienteId` (`clienteId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `direccion`
--
ALTER TABLE `direccion`
  MODIFY `idDireccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `ganancias`
--
ALTER TABLE `ganancias`
  MODIFY `idGanancia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `idMarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`idDireccion`) REFERENCES `direccion` (`idDireccion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD CONSTRAINT `detalleventas_ibfk_1` FOREIGN KEY (`productoId`) REFERENCES `productos` (`idProducto`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `detalleventas_ibfk_2` FOREIGN KEY (`ventaId`) REFERENCES `ventas` (`idVenta`);

--
-- Filtros para la tabla `ganancias`
--
ALTER TABLE `ganancias`
  ADD CONSTRAINT `ganancias_ibfk_1` FOREIGN KEY (`ventaId`) REFERENCES `ventas` (`idVenta`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`marcaId`) REFERENCES `marcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`clienteId`) REFERENCES `cliente` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
