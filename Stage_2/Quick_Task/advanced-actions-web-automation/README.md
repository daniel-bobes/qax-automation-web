# ⚡ Selenium Advanced Actions Suite
Este proyecto Maven contiene una suite de pruebas automatizadas diseñada para validar interacciones complejas de usuario utilizando Selenium WebDriver y TestNG.

## 🛠️ Tecnologías Usadas
* Java 21+ ☕: Lenguaje de programación principal.
* TestNG ✅: Motor de ejecución y orquestación de pruebas.
* Selenium WebDriver 🌐: Automatización de interacciones con el navegador.
* Maven 📦: Gestión de dependencias y construcción del proyecto.

## 📂 Estructura del Proyecto

```text
advanced-actions-web-automation
├── src
│   └── test
│       └── java
│           └── com.danielbobes.web
│               └── tests                               # Implementación de pruebas
├── pom.xml                                             # Configuración y dependencias
└── README.md                                           # Documentación del proyecto
```

## 🧪 Escenarios de Prueba Cubiertos

| Categoría   | Clase Java             | Descripción del Escenario                        | Tests  |
|:------------|:-----------------------|:-------------------------------------------------|:------:|
| Mouse       | ClickTest.java         | Click izquierdo, derecho (context) y doble click |   3    |
| Hover       | MouseOverTest.java     | Movimiento del cursor sobre imágenes dinámicas   |   1    |
| Drag & Drop | DragAndDropTest.java   | Arrastre directo y mediante clickAndHold         |   2    |
| Teclado     | SendKeysTest.java      | Simulación de teclas en calculadora con delay    |   1    |
| Diálogos    | HandleAlertsTest.java  | Alertas, Confirm, Prompt y Modales (HTML)        |   7    |
| Frames      | HandleIframesTest.java | iFrames simples y estructuras anidadas           |   2    |
| Ventanas    | HandleTabsTest.java    | Gestión de múltiples pestañas y ventanas         |   3    |
| Shadow DOM  | ShadowDomTest.java     | Acceso a elementos mediante SearchContext        |   1    |
| **TOTAL**   |                        |                                                  | **20** |

# 🛠️ Detalles de Implementación
* Actions API: Uso de la clase Actions para interacciones que el método `.click()` estándar no puede realizar.
* Sincronización: Implementación de WebDriverWait para manejar esperas, carga asíncrona de elementos y modales.
* Context Switching: Cambio de contexto dinámico para interactuar con Frames y Ventanas emergentes.
* Shadow Root: Uso de SearchContext para romper el aislamiento del Shadow DOM.


## 🚀 Instalación
1. Clona este repositorio.
2. Abre el proyecto en tu IDE favorito como un **Proyecto Maven**.
3. Asegurarte de tener configurado el **JDK 21**.

## 📊 Ejecución y reportes
Para ejecutar las pruebas y generar el informe de resultados:
1. Desde la terminal, sitúate en la carpeta raíz del proyecto.
2. Ejecuta los siguientes comandos:
    ```bash
    mvn clean test
    mvn surefire-report:report
    ```
El reporte detallado se generará en la ruta `target/surefire-reports/emailable-report.html`.

## 🚀 Resultados de la Ejecución
La suite ha sido validada con un 100% de éxito:
* Tests ejecutados: 20
* Fallos: 0

Puedes ver el reporte de la ejecución abriendo el archivo [📂 Advanced Actions Selenium WebDriver Report](../evidences/Advanced%20Actions%20Selenium%20WebDriver%20Report.pdf)