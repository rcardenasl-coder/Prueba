Una API REST reactiva para gestionar franquicias, sucursales y productos, desarrollada con Spring Boot WebFlux y PostgreSQL. Utiliza una arquitectura hexagonal para garantizar modularidad y mantenibilidad. Permite operaciones como crear franquicias, sucursales, productos, y consultar el producto con mayor stock por sucursal para una franquicia específica.

🚀 Características
Reactiva: Construida con Spring WebFlux y Project Reactor para un manejo asíncrono y no bloqueante.
Arquitectura Hexagonal: Diseño modular con separación clara entre lógica de negocio, persistencia y presentación.
Base de Datos: PostgreSQL con soporte para relaciones entre franquicias, sucursales y productos.
Mapeo Automático: Usa MapStruct para transformar entidades a DTOs.
Endpoints Principales:
Consultar productos con mayor stock por sucursal.
Gestionar franquicias, sucursales y productos (CRUD).
📋 Requisitos previos
Java 21
PostgreSQL
Git
Postman o un cliente HTTP similar
🛠️ Instalación y configuración
1. Clonar el repositorio

Conéctate a PostgreSQL (con psql o pgAdmin) y Crea la base de datos:

CREATE DATABASE franchise_db;

-- Tabla franchise
CREATE TABLE franchise (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
);

-- Tabla branch con FK a franchise
CREATE TABLE branch (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    franchise_id BIGINT NOT NULL,
    CONSTRAINT fk_branch_franchise FOREIGN KEY (franchise_id) REFERENCES franchise (id) ON DELETE CASCADE
);

-- Tabla product con FK a branch
CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    stock INT NOT NULL,
    branch_id BIGINT,
    CONSTRAINT fk_product_branch FOREIGN KEY (branch_id) REFERENCES branch (id) ON DELETE CASCADE
);
