# Reto 1 - Automatización de Flujos Críticos en Parabank
- 📁 **Carpeta:** `Stage_1/Challenge/parabank-web-automation`
- 🎯 **Objetivo:** Establecer una base sólida de automatización web mediante la validación del proceso de registro y autenticación, aplicando patrones de diseño que garanticen la escalabilidad y el mantenimiento del código.
## Introducción
En este reto, he evolucionado desde el manejo básico de Selenium hacia la creación de un framework estructurado. 

Los hitos de aprendizaje clave han sido:
* Gestión de Driver y Ciclo de Vida: Configuración avanzada de WebDriver con ChromeOptions (Headless mode) y gestión del ciclo de vida del test con @BeforeMethod y @AfterMethod.
* Estrategias de Localización y Esperas: Uso de localizadores robustos e implementación de Explicit Waits (WebDriverWait) para manejar la asincronía de la web y evitar tests inestables.
* Data-Driven Testing con Pattern Builder: Creación de un modelo de datos para User utilizando el patrón Builder, permitiendo una construcción de objetos de prueba clara y flexible.
* Generación Dinámica de Datos: Integración de JavaFaker a través de una DataFactory para generar identidades únicas en cada ejecución, eliminando la dependencia de datos estáticos.
___
## ⚙️ Requisitos
Para poder ejecutar el proyecto necesitas:
* Java 21 instalado.
* Maven instalado.
* Una terminal de comandos o tu IDE de preferencia.

## 🚀 Ejecución y reportes
1. Clona o descarga el repositorio `https://github.com/daniel-bobes/qax-automation-web.git`.
2. Abre la terminal en la carpeta raíz `qax-automation-web`.
3. Sitúate en el directorio del proyecto con el comando:
    ```bash
    cd Stage_1/Challenge/parabank-web-automation
    ```
4. Ejecuta el siguiente comando para ejecutar todas las suites de pruebas:
    ```bash
    mvn test
    ```
5. El sistema generará el reporte en el directorio `target/surefire-reports`.
6. Accede al directorio anterior y abre el archivo `emailable-report.html` en tu navegador.

## 📊️ Evidencias
Puedes encontrar el reporte de la ejecución exitosa en la carpeta: 📁[ Ver Carpeta de Evidencias](./evidencias/challenge1)

- Reporte HTML con la ejecución de todos los escenarios de prueba: [Parabank TestNG Automation Report](./evidencias/challenge1/Parabank%20TestNG%20Automation%20Report.pdf)

## 🗒️ Historia de usuario: Gestión de Publicaciones y Comentarios
**Como** tester de aplicaciones web<br>
**Quiero** automatizar el flujo de registro e inicio de sesión<br>
**Para** asegurar que los nuevos usuarios puedan acceder a la plataforma correctamente.

## ✅ Escenarios de prueba
El script `ParabankTest` realiza las siguientes acciones validadas:
1. Acceso: Navegación a la URL oficial de Parabank.
2. Navegación: Interacción con el link de registro y validación de carga de página mediante el encabezado `<h1>` (impreso en consola).
3. Registro: Cumplimentación dinámica del formulario utilizando el objeto User construido utilizando Pattern Builder y Data Factory.
4. Verificación: Validación asertiva de que el mensaje de bienvenida coincide con el nombre del usuario creado.
5. Cierre: Finalización segura de la sesión del navegador para liberar recursos.