Una API REST reactiva para gestionar franquicias, sucursales y productos, desarrollada con Spring Boot WebFlux y PostgreSQL. Utiliza una arquitectura hexagonal para garantizar modularidad y mantenibilidad.\n
Permite operaciones como crear franquicias, sucursales, productos, y consultar el producto con mayor stock por sucursal para una franquicia específica.\n

Características\n
Reactiva: Construida con Spring WebFlux y Project Reactor para un manejo asíncrono y no bloqueante.\n
Arquitectura Hexagonal: Diseño modular con separación clara entre lógica de negocio, persistencia y presentación.\n
Base de Datos: PostgreSQL con soporte para relaciones entre franquicias, sucursales y productos.\n
Mapeo Automático: Usa MapStruct para transformar entidades a DTOs.\n
Endpoints Principales:\n
Consultar productos con mayor stock por sucursal.\n
Gestionar franquicias, sucursales y productos (CRUD).\n
Requisitos previos\n
Java 21\n
PostgreSQL\n
Git\n
Postman o un cliente HTTP similar\n
🛠Instalación y configuración\n
1. Clonar el repositorio\n

Conéctate a PostgreSQL (con psql o pgAdmin) y Crea la base de datos:\n

CREATE DATABASE franchise_db;\n

-- Tabla franchise\n
CREATE TABLE franchise (\n
    id BIGSERIAL PRIMARY KEY NOT NULL,\n
    name VARCHAR(255) NOT NULL\n
);\n

-- Tabla branch con FK a franchise\n
CREATE TABLE branch (\n
    id BIGSERIAL PRIMARY KEY NOT NULL,\n
    name VARCHAR(255) NOT NULL,\n
    franchise_id BIGINT NOT NULL,\n
    CONSTRAINT fk_branch_franchise FOREIGN KEY (franchise_id) REFERENCES franchise (id) ON DELETE CASCADE\n
);
\n
-- Tabla product con FK a branch\n
CREATE TABLE product (\n
    id BIGSERIAL PRIMARY KEY NOT NULL,\n
    name VARCHAR(255) NOT NULL,\n
    stock INT NOT NULL,\n
    branch_id BIGINT,\n
    CONSTRAINT fk_product_branch FOREIGN KEY (branch_id) REFERENCES branch (id) ON DELETE CASCADE\n
);\n
