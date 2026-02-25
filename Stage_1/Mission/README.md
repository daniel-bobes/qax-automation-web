# Misión: Automatización Web con Selenium.
* 📁 Carpeta: Stage_1/Mission/selenium-web-automation

---
# Introducción
Este repositorio contiene el desarrollo y las soluciones de la misión práctica de automatización web. El enfoque principal ha sido la creación de un framework robusto utilizando **Selenium WebDriver** para enfrentar diversos retos de interacción en interfaces de usuario.

## 🎯 Objetivos de la Misión
- Estructuración de proyectos de automatización con **Maven**.
- Implementación de localizadores avanzados mediante **XPath y CSS Selectors** (evitando IDs dinámicos).
- Manejo de esperas explícitas para garantizar la estabilidad de los tests.
- Automatización de flujos complejos: scroll infinito, acciones de ratón avanzadas y lógica de negocio en aplicaciones de salud.

## 📂 Proyectos Incluidos
- **[selenium-web-automation](./selenium-web-automation)**: Suite completa con los 8 ejercicios resueltos, configurada para ejecuciones tanto locales (Chrome) como en entornos de CI (Headless).

## 🚀 Ejecución y reportes
1. Clona o descarga el repositorio `https://github.com/daniel-bobes/qax-automation-web.git`.
2. Abre la terminal en la carpeta raíz `qax-automation-web`.
3. Sitúate en el directorio del proyecto con el comando:
    ```bash
    cd Stage_1/Mission/selenium-web-automation
    ```
4. Ejecuta el siguiente comando para ejecutar todas las suites de pruebas:
    ```bash
    mvn test
    ```
5. El sistema generará el reporte en el directorio `target/surefire-reports`.
6. Accede al directorio anterior y abre el archivo `emailable-report.html` en tu navegador.

## 📊️ Evidencias
Puedes encontrar el reporte de la ejecución exitosa en la carpeta: 📁[ Ver Carpeta de Evidencias](./evidencias)

- Reporte HTML con la ejecución de todos los escenarios de prueba: [Selenium TestNG Automation Report](./evidencias/Selenium%20TestNG%20Automation%20Report.pdf)

# 📝 Ejercicios

## Ejercicio 1 - Login automático
* 🌐 URL: `https://bonigarcia.dev/selenium-webdriver-java/login-form.html`
* 🎯 Objetivo: automatizar el login con un usuario y contraseña de prueba.
* Instrucciones:
  1. Localizar los campos de usuario y contraseña sin user `id` ni `name`.
  2. Informar los campos con los datos de prueba.
  3. Hacer clic en el botón de login.
  4. Imprimir por consulta si el login fue exitoso.

## Ejercicio 2 - Acciones del menú
* 🌐 URL: `https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html`
* 🎯 Objetivo: Realizar clic, clic derecho y doble clic en los menús.
* Instrucciones:
  1. Localizar los menús usando CSS Selector o XPath avanzado.
  2. Hacer clic, doble clic y clic derecho en los elementos seleccionados.
  3. Imprimir la acción realizada para cada elemento.

## Ejercicio 3 - Scroll infinito
* 🌐 URL: `https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html`
* 🎯 Objetivo: Practicar scroll infinito y detección de nuevos elementos.
* Instrucciones:
  1. Automatizar el scroll hacia abajo hasta que se carguen al menos 20 elementos nuevos.
  2. Imprimir en consola los textos de los elementos visibles.

## Ejercicio 4 - Calculadora aleatoria
* 🌐 URL: `https://bonigarcia.dev/selenium-webdriver-java/random-calculator.html`
* 🎯 Objetivo: Realizar operaciones matemáticas automáticamente.
* Instrucciones:
  1. Localizar los botones de la calculadora usando XPath o selectores CSS.
  2. Realizar operaciones básicas: suma, resta, multiplicación y división.
  3. Imprimir los resultados de cada operación en consola.

## Ejercicio 5 - Login correcto
* 🌐 URL: `https://katalon-demo-cura.herokuapp.com/profile.php#login`
* 🎯 Objetivo: Validar el acceso al sistema con credenciales correctas.
* Instrucciones:
  1. Hacer clic en el botón **Make Appointment** desde la página principal.
  2. Informar las credenciales:
     * Username: `John Doe`
     * Password: `ThisIsNotAPassword`
  3. Hacer clic en el botón **Login**.
  4. Verificar que se muestra el encabezado **Make Appointment** e imprimir en consola: `Inicio de sesión exitoso`.

## Ejercicio 6 - Login incorrecto
* 🌐 URL: `https://katalon-demo-cura.herokuapp.com/profile.php#login`
* 🎯 Objetivo: Validar el acceso al sistema con credenciales incorrectas.
* Instrucciones:
  1. Hacer clic en el botón **Make Appointment** desde la página principal.
  2. Informar las credenciales:
     * Username: `QAX`
     * Password: `ThisIsNotAPassword`
  3. Hacer clic en el botón **Login**.
  4. Verificar el mensaje: `Login failed! Please ensure the username and password are valid.`.

## Ejercicio 7 - Agendar una cita
* 🌐 URL: `https://katalon-demo-cura.herokuapp.com/#appointment`
* 🎯 Objetivo: Automatizar el flujo completo de agendamiento de una cita médica.
* Instrucciones:
  1. Seleccionar la opción **Seoul CURA Healthcare Center** del menú desplegable.
  2. Marcar la casilla **Apply for hospital readmission**.
  3. Elegir el programa **Medicare**.
  4. Abrir el calendario y seleccionar una fecha disponible.
  5. En el campo **Comment**, informar: `Cita automatizada con QA Xpert`.
  6. Hacer clic en **Book Appointment** y validar que aparece el mensaje **Appointment Confirmation**.

## Ejercicio 8 - Navegación en el menú
* 🌐 URL: `https://katalon-demo-cura.herokuapp.com/`
* 🎯 Objetivo: Validar los enlaces del menú lateral.
* Instrucciones:
  1. Abrir el menú lateral derecho (ícono ☰).
  2. Hacer clic en los enlaces **Home**, **History**, **Profile** y **Logout** uno por uno.
  3. Imprimir en consola el título o texto principal de cada página.
  4. Cerrar sesión al finalizar la ejecución.
