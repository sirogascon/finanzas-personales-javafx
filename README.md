# Gestión de Finanzas Personales

Aplicación de escritorio desarrollada con **Java y JavaFX** para registrar y consultar ingresos y gastos personales, con almacenamiento persistente en una base de datos relacional.

Proyecto académico del módulo **M03 – Programación**, del CFGS de Desarrollo de Aplicaciones Multiplataforma (DAM).

## Funcionalidades

- Registro de ingresos y gastos.
- Introducción de nuevas operaciones mediante una interfaz gráfica.
- Visualización de las operaciones registradas en una tabla.
- Almacenamiento de operaciones en una base de datos.
- Recuperación de los datos guardados al iniciar la aplicación.

## Tecnologías utilizadas

- **Java:** programación orientada a objetos y lógica de la aplicación.
- **JavaFX:** desarrollo de la interfaz gráfica.
- **FXML:** definición de las vistas.
- **MariaDB y JDBC:** conexión y persistencia de datos.
- **Maven:** gestión de dependencias y configuración del proyecto.

## Organización del código

El proyecto separa sus componentes en diferentes paquetes:

- `model/`: clases del dominio, como `Operacion`, `Ingreso` y `Gasto`.
- `controller/`: controladores de las interfaces JavaFX.
- `dao/`: acceso a datos y conexión con la base de datos.
- `gui/`: inicialización de la aplicación.
- `resources/gui/`: archivos FXML de las vistas.

Esta organización permite separar la presentación, la lógica de las operaciones y el acceso a los datos.

## Ejecución local

**Requisitos:**

- JDK 24.
- Maven.
- Una instancia de MariaDB.
- Una base de datos `gestion_finanzas` con las tablas necesarias para las operaciones.

El proyecto utiliza una conexión JDBC configurada en `ConexionBD.java`. Para ejecutarlo en otro entorno, es necesario adaptar los datos de conexión a la base de datos local.

La aplicación puede iniciarse desde un IDE compatible con JavaFX ejecutando la clase `app.Launcher`.

## Vídeo de demostración

[Ver demostración de la aplicación](https://drive.google.com/file/d/1NWNqiscgowpEdj0Bzg_Wc-L-f1Jpnobm/view?usp=sharing)

## Contexto académico

Proyecto desarrollado durante el CFGS de Desarrollo de Aplicaciones Multiplataforma, centrado en programación orientada a objetos, desarrollo de interfaces gráficas y persistencia de información mediante bases de datos relacionales.

**Autor:** Siro Gascón Ogasawara
