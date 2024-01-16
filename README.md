# forsoftware
# Sistema de Gestión de Empresa de Videojuegos

## Descripción
Este proyecto de Java es un sistema de gestión para una empresa de desarrollo de videojuegos. Permite la creación y el manejo de una base de datos con múltiples tablas relacionadas, representando diferentes roles dentro de la empresa y sus proyectos.

## Funcionalidades
- **Gestión de Empleados**: Control de información personal y profesional de los empleados.
- **Gestión de Proyectos**: Creación, asignación y seguimiento de proyectos de videojuegos.
- **Interfaz de Usuario y Seguridad**: Inicio de sesión y Manejo seguro de credenciales y permisos de acceso.

## Estructura de la Base de Datos
La base de datos incluye tablas como `Trabajadores`, y `Proyectos`, cada una con sus respectivos campos y claves.

## Interfaz Gráfica
Una interfaz gráfica permite a los usuarios iniciar sesión y acceder a diferentes opciones, como visualización de datos personales y gestión de tareas.

## Uso
La aplicación utiliza una interfaz gráfica para gestionar el inicio de sesión. Aquí hay una guía paso a paso sobre cómo usar la ventana de inicio de sesión:

Al ejecutar la aplicación, se abrirá una ventana de inicio de sesión (VentanaInicioSesion).
Verás campos para ingresar tu correo electrónico y contraseña, así como un botón de confirmación.
Ingreso de Credenciales:

Ingresa tu correo electrónico en el campo correspondiente.
Ingresa tu contraseña en el campo respectivo.
Asegúrate de proporcionar valores válidos en ambos campos.

Confirmación:
Haz clic en el botón "Confirmar" para iniciar sesión.
La aplicación verificará la validez de las credenciales ingresadas.

Resultado de la Iniciación de Sesión:
Si las credenciales son correctas, se abrirá una nueva ventana (VentanaInicial), indicando que la sesión se ha iniciado correctamente.
Si hay algún error en las credenciales o campos vacíos, aparecerá un mensaje de error.

La clase VentanaInicial representa la interfaz principal de la aplicación después de iniciar sesión. Aquí se detalla cómo utilizar las funciones proporcionadas por esta ventana:

Visualización de Datos del Usuario:
Al iniciar sesión, se abrirá la ventana VentanaInicial con pestañas que contienen información sobre el usuario actual.
En la pestaña "Inicio", encontrarás detalles sobre tu perfil, incluyendo ID, nombre, apellido, sexo, puesto, provincia, teléfono, dirección de correo y sueldo.
Los campos son de solo lectura y no pueden modificarse directamente desde esta ventana.

Cambiar Contraseña:
En la pestaña "Inicio", hay un botón "Cambiar contraseña". Haz clic en este botón para abrir una ventana emergente.
Introduce tu contraseña actual cuando se te solicite. Si la contraseña es correcta, podrás ingresar y confirmar tu nueva contraseña.
La contraseña no se actualiza en este momento debido a la falta de una base de datos de usuarios, pero el flujo de cambio de contraseña está implementado.

Cerrar Sesión:
En la pestaña "Inicio", hay un botón "Cerrar sesión". Haz clic en este botón para cerrar la sesión actual.
Se abrirá la ventana de inicio de sesión (VentanaInicioSesion), permitiéndote iniciar sesión con otra cuenta.

Visualización de Proyectos y Trabajadores:
La pestaña "Proyectos" te llevará a una ventana (VentanaProyectos) que muestra información sobre los proyectos de videojuegos. 
La pestaña "Trabajadores" te llevará a una ventana (VentanaTrabajadores) que muestra información sobre los trabajadores de la empresa. Podrás añadir, eliminar y editar trabajadores.

Hora y Fecha en Tiempo Real:
La parte superior de la ventana muestra en tiempo real la hora actual y la fecha actualizada cada segundo.
Además, el título de la ventana se actualiza para dar la bienvenida al usuario y mostrar la hora actual, la fecha y el nombre del usuario.
Persistencia de la Sesión:

La sesión del usuario se mantiene activa mientras la ventana VentanaInicial esté abierta. Al cerrar la ventana, se vuelve a la ventana de inicio de sesión.
