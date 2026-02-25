# Parabank Web Automation 🚀

Framework de automatización de pruebas web para la web de **[Parabank](https://parabank.parasoft.com/parabank/index.htm)**, desarrollado con un enfoque profesional y mantenible.

## 🛠️ Tecnologías Usadas
* **Java 21+** ☕: lenguaje de programación principal utilizado para el desarrollo del framework de automatización.
* **TestNG** ✅: Motor de ejecución de pruebas.
* **Selenium WebDriver** 🌐: Herramienta esencial para la automatización de navegadores que permite simular interacciones humanas con la interfaz web.
* **JavaFaker** 🎲: Librería utilizada para la generación de datos aleatorios y realistas (nombres, direcciones, etc.), garantizando que cada registro sea único.
* **Aspectos de Diseño (Pattern Builder)** 🏗️: Implementación del patrón de diseño Builder para una creación de objetos de prueba (User) más legible y flexible.
* **Maven** 📦: Gestor de dependencias y automatización de la construcción del proyecto.

## 📂 Estructura del Proyecto
El framework sigue una organización modular basada en Maven para separar la lógica de las pruebas de la configuración.

```text
parabank-web-automation
├── src
│   └── test
│       └── java
│           └── com.danielbobes.web.challenges.parabank
│               └── config                              # URLs y configuración y de Endpoints
│               └── data.factory                        # Generación de datos dinámicos con JavaFaker
│               └── models                              # POJOs para el mapeo de peticiones y respuestas de la API
│               └── tests                               # Implementación de pruebas
├── pom.xml                                             # Configuración y dependencias 📦
└── README.md                                           # Documentación del proyecto
```

## 🚀 Instalación
1. Clona este repositorio.
2. Abre el proyecto en tu IDE favorito como un **Proyecto Maven**.
3. Asegurarte de tener configurado el **JDK 21**.

## 🧪 Ejecución
Para ejecutar las pruebas desde la terminal, primero sitúate en la carpeta raíz del proyecto.

Después, si quieres ejecutar todas las suites de pruebas ejecuta en la terminal:
```bash
mvn clean test
mvn surefire-report:report
```
Por el contrario, si deseas ejecutar una suite de pruebas concreta:
* `mvn test -Dtest=<nombre del test>`

Por ejemplo:
```bash
mvn test -Dtest=ParabankTest
```

## 📊 Reportes
Trás la ejecución, se generan reportes detallados en la ruta `target/surefire-reports`.

Para visualizar el reporte solo tienes que abrir el reporte `emailable-report.html` en tu navegador favorito 🌐.