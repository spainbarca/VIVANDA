-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-11-2017 a las 08:00:08
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdproductos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aseo_personal`
--

CREATE TABLE `aseo_personal` (
  `Codigo` int(15) NOT NULL,
  `Categoria` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Subcategoria` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Marca` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Descripcion` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Cantidad` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Preciounitario` varchar(15) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(200) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `aseo_personal`
--

INSERT INTO `aseo_personal` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
(1644, 'Aseo personal', 'Shampoo', 'Sedal', 'Shampoo Sedal duo', '744', '10.0', 'sedal duo.jpg', 'noe'),
(5454, 'Aseo personal', 'Shampoo', 'Elvive', 'Shampoo Elvive Loreal 760 ml', '144', '20.0', 'Shampoo-Elvive-LOreal-Paris-Color-Vive-Frasco-750-ml-385847001.png', 'noe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bebidas_y_licores`
--

CREATE TABLE `bebidas_y_licores` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bebidas_y_licores`
--

INSERT INTO `bebidas_y_licores` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('15751', 'Bebidas y licores', 'Vino', 'Concha y Toro', 'Vino Casillero del Diablo', '100', '110.0', 'ConchayToro_CasillerodelDiablo.jpg', 'noe'),
('47454', 'Bebidas y licores', 'Gaseosa', 'Inca Kola', 'Gaseosa Inka Kola lata 355ml', '147', '3.4', 'IncaKola Lata 355ml.PNG', 'noe'),
('54645', 'Bebidas y licores', 'Gaseosa', 'Coca Cola', 'Gaseosa Coca cOla 1.5', '545', '4.8', 'CocaCola 1.5L.PNG', 'noe'),
('78754', 'Bebidas y licores', 'Bebida Energética', 'Red Bull', 'Energizante Red Bull Cola', '144', '8.6', 'ReddbullCola.PNG', 'noe'),
('79754254', 'Bebidas y licores', 'Jugos', 'Tampico', 'Jugo sabor naranja plus 1lt', '50', '4.5', 'TampicoNaranjaPLUS 1L.jpg', 'dante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carnes_y_pescados`
--

CREATE TABLE `carnes_y_pescados` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `carnes_y_pescados`
--

INSERT INTO `carnes_y_pescados` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('154564', 'Carnes y pescados', 'Mariscos', 'Pescanova', 'Marisco #3', '144', '14.0', 'Marisco03.PNG', 'dante'),
('17874', 'Carnes y pescados', 'Atun', 'Marédoce', 'Atun ', '145', '14.0', 'Atun_marédoce.PNG', 'noe'),
('454212', 'Carnes y pescados', 'Conservas', 'Florida', 'Atun florida 170g light', '100', '6.5', 'Filete de Atún Light Florida Lata 170 g.png', 'dante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `codigo` char(3) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`codigo`, `categoria`) VALUES
('As', 'Aseo personal'),
('Be', 'Bebidas y licores'),
('Ca', 'Carnes y pescados'),
('De', 'Despensa'),
('El', 'Electrohogar'),
('Fru', 'Frutas y verduras'),
('Go', 'Golosinas'),
('Lac', 'Lacteos'),
('Li', 'Limpieza domestica'),
('Pan', 'Panaderia y pasteleria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `despensa`
--

CREATE TABLE `despensa` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `despensa`
--

INSERT INTO `despensa` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('1487', 'Despensa', 'Fideos', 'Nicolini', 'Nicolini codo chico 250 g', '24', '1.7', 'NicoliniCodoChico.png', 'noe'),
('2454212', 'Despensa', 'Aceites', 'Primor', 'Aceite Primor 1kG', '44', '8.5', 'Primor.PNG', 'dante'),
('4545124', 'Despensa', 'Flan', 'Universal', 'Flan Universal', '100', '3.0', 'Universal.jpg', 'noe'),
('5454', 'Despensa', 'Harina', 'Blanca Flor', 'Harina preparada 1kg', '10', '6.1', 'BlancaFlor_HarinaPreparada.png', 'dante'),
('7845421', 'Despensa', 'Salsa', 'Alacena', 'Alacena mayonesa 200gr.', '120', '4.5', 'AlacenaMayonesa 200gr.PNG', 'noe'),
('7987564', 'Despensa', 'Azúcar', 'Cartavio', 'Azucar cartavio 2 kg', '154', '8.0', 'Cartavio 2Kg.PNG', 'dante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `electrohogar`
--

CREATE TABLE `electrohogar` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `electrohogar`
--

INSERT INTO `electrohogar` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('14475445', 'Electrohogar', 'Televisor', 'Sony', 'TV Sony bravia 40', '20', '1900.0', 'SonyBravia.jpg', 'noe'),
('154', 'Electrohogar', 'Licuadora', 'Oster', 'Licuadora Oster 1.25 L', '15', '300.0', 'Oster Licuadora 6805 1.25L.png', 'noe'),
('4445634', 'Electrohogar', 'Aspiradora', 'Imaco', 'Aspiradora Imaco Rojo', '12', '654.0', 'aspiradoracicloimacorojo.jpg', 'noe'),
('45421', 'Electrohogar', 'Lavadora', 'LG', 'Lavadora LG 35\"', '12', '2000.0', 'Lavadora LG 35Lb.jpg', 'noe'),
('7912', 'Electrohogar', 'Tablet', 'Huawei', 'Tablet Huawei T1', '41', '500.0', 'Tablet HuaweiT1.jpg', 'noe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `frutas_y_verduras`
--

CREATE TABLE `frutas_y_verduras` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `frutas_y_verduras`
--

INSERT INTO `frutas_y_verduras` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('45748', 'Frutas y verduras', 'Cacao', 'Drimer', 'Cacao Drimer ', '44', '50.0', 'Drimer.PNG', 'noe'),
('4575424', 'Frutas y verduras', 'Lucuma', 'Zespri', 'Lucuma Zespri x kg', '100', '3.5', 'lucuma01.jpg', 'dante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `golosinas`
--

CREATE TABLE `golosinas` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `golosinas`
--

INSERT INTO `golosinas` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('16487', 'Golosinas', 'Snacks', 'Inka Chips', 'Snack Inka Chips Mix ', '144', '3.0', 'inka chips mmix.jpg', 'noe'),
('4571', 'Golosinas', 'Caramelos', 'Ambrosoli', 'Ambrosoli Gomitas Caliptus menta', '651', '10.0', 'ambrosoli gomitas caliptus menta.png', 'dante'),
('5787', 'Golosinas', 'Chocolates', 'Vizzio', 'Chocolate Vizzio bitter', '14', '9.4', 'vizzio bitter.png', 'noe'),
('964124', 'Golosinas', 'Cereales', 'Angel', 'Angel Zuck ', '100', '9.7', 'angel zuck.png', 'noe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lacteos`
--

CREATE TABLE `lacteos` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `lacteos`
--

INSERT INTO `lacteos` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('457454', 'Lacteos', 'Leche', 'Soy Vida', 'Leche Soy Vida en bolsa 1lt', '45', '2.7', 'SoyVidaEnBolsa.png', 'dante'),
('474574', 'Lacteos', 'Dulces Lácteos', 'Bonle', 'Manjar Blanco Bonlé ', '144', '4.9', 'ManajrBlanco_GloriaBonlé.PNG', 'noe'),
('487814', 'Lacteos', 'Helados', 'Haagen-Dazs', 'Helado sabor Chocolate', '114', '24.0', 'HaagenDaz_Chocolate.png', 'dante'),
('64984', 'Lacteos', 'Mantequilla', 'Manty', 'Mantequilla manty frasco pequeño', '244', '1.7', 'MantyFrascoPequeño.PNG', 'noe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `limpieza_domestica`
--

CREATE TABLE `limpieza_domestica` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `limpieza_domestica`
--

INSERT INTO `limpieza_domestica` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('479741', 'Limpieza domestica', 'Ambientadores', 'Poett', 'Poett Primavera 1lt', '100', '11.5', 'poett primavera 1 L.jpg', 'noe'),
('5745', 'Limpieza domestica', 'Desinfectantes', 'Mr Musculo', 'Antigrasa Mr Musculo 2x1', '14', '8.9', 'Antigrasa  Mr Músculo 2x1.jpg', 'noe'),
('596745', 'Limpieza domestica', 'Accesorios', 'Hude', 'Trapeador hude blanco', '414', '9.4', 'trapeadorhude.jpg', 'noe'),
('65545', 'Limpieza domestica', 'Detergente', 'Ace', 'Detergente Ace 5kg', '45', '60.0', 'Detergente en polvo ACE Regular Bolsa 5Kg.png', 'noe'),
('713218', 'Limpieza domestica', 'Limpiadores', 'Pinesol', 'Pinesol Liquid cleaner 40 FL', '74', '12.0', 'Pine-Sol 40125 Liquid Cleaner, 40 fl oz Bottle.jpg', 'noe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `panaderia_y_pasteleria`
--

CREATE TABLE `panaderia_y_pasteleria` (
  `Codigo` varchar(15) NOT NULL,
  `Categoria` varchar(50) NOT NULL,
  `Subcategoria` varchar(50) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` varchar(15) NOT NULL,
  `Preciounitario` varchar(15) NOT NULL,
  `Nombre` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `pers_nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `panaderia_y_pasteleria`
--

INSERT INTO `panaderia_y_pasteleria` (`Codigo`, `Categoria`, `Subcategoria`, `Marca`, `Descripcion`, `Cantidad`, `Preciounitario`, `Nombre`, `pers_nombre`) VALUES
('1545', 'Panaderia y pasteleria', 'Pasteles', 'Saint Honore', 'Torta de manjar mdiana (8 porciones)', '144', '20.0', 'Torta de manjar mediana #24 (8 porciones).png', 'dante'),
('1787', 'Panaderia y pasteleria', 'Turrones', 'San Jose', 'Turron de Doña Pepa 1kg', '44', '27.0', 'Turrón SAN JOSE De doña pepa Caja 1K.png', 'noe'),
('45787', 'Panaderia y pasteleria', 'Panetones', 'Todinno', 'Toddino caja 900g + todinnito 100g', '14', '30.0', 'Panetón Todinno Caja 900 g + Todinnito 100 g.png', 'dante'),
('545421', 'Panaderia y pasteleria', 'Panes', 'Vivanda', 'Pan Karamandunka x kg.', '1010', '9.0', 'Karamanduka.png', 'dante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personales`
--

CREATE TABLE `personales` (
  `pers_nombre` varchar(20) NOT NULL,
  `pers_password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personales`
--

INSERT INTO `personales` (`pers_nombre`, `pers_password`) VALUES
('dante', '456'),
('noe', '123'),
('prueba', '789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subcategoria`
--

CREATE TABLE `subcategoria` (
  `categoria` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `codigosub` char(7) COLLATE utf8_spanish_ci NOT NULL,
  `subcategoria` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aseo_personal`
--
ALTER TABLE `aseo_personal`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `bebidas_y_licores`
--
ALTER TABLE `bebidas_y_licores`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `carnes_y_pescados`
--
ALTER TABLE `carnes_y_pescados`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `categoria` (`categoria`);

--
-- Indices de la tabla `despensa`
--
ALTER TABLE `despensa`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `electrohogar`
--
ALTER TABLE `electrohogar`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `frutas_y_verduras`
--
ALTER TABLE `frutas_y_verduras`
  ADD PRIMARY KEY (`Codigo`),
  ADD UNIQUE KEY `Codigo` (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `golosinas`
--
ALTER TABLE `golosinas`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `lacteos`
--
ALTER TABLE `lacteos`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `limpieza_domestica`
--
ALTER TABLE `limpieza_domestica`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `panaderia_y_pasteleria`
--
ALTER TABLE `panaderia_y_pasteleria`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `personales`
--
ALTER TABLE `personales`
  ADD PRIMARY KEY (`pers_nombre`),
  ADD UNIQUE KEY `pers_nombre` (`pers_nombre`);

--
-- Indices de la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD PRIMARY KEY (`codigosub`),
  ADD KEY `categoria` (`categoria`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aseo_personal`
--
ALTER TABLE `aseo_personal`
  ADD CONSTRAINT `aseo_personal_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `bebidas_y_licores`
--
ALTER TABLE `bebidas_y_licores`
  ADD CONSTRAINT `bebidas_y_licores_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `carnes_y_pescados`
--
ALTER TABLE `carnes_y_pescados`
  ADD CONSTRAINT `carnes_y_pescados_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `despensa`
--
ALTER TABLE `despensa`
  ADD CONSTRAINT `despensa_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `electrohogar`
--
ALTER TABLE `electrohogar`
  ADD CONSTRAINT `electrohogar_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `frutas_y_verduras`
--
ALTER TABLE `frutas_y_verduras`
  ADD CONSTRAINT `frutas_y_verduras_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `golosinas`
--
ALTER TABLE `golosinas`
  ADD CONSTRAINT `golosinas_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `lacteos`
--
ALTER TABLE `lacteos`
  ADD CONSTRAINT `lacteos_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `limpieza_domestica`
--
ALTER TABLE `limpieza_domestica`
  ADD CONSTRAINT `limpieza_domestica_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `panaderia_y_pasteleria`
--
ALTER TABLE `panaderia_y_pasteleria`
  ADD CONSTRAINT `panaderia_y_pasteleria_ibfk_1` FOREIGN KEY (`pers_nombre`) REFERENCES `personales` (`pers_nombre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `subcategoria`
--
ALTER TABLE `subcategoria`
  ADD CONSTRAINT `subcategoria_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`categoria`) ON DELETE CASCADE ON UPDATE CASCADE;;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
