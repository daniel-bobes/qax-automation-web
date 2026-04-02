# 🌐 Demo Automation Testing

Automatización de pruebas web.

## 🛠️ Tecnologías Usadas
* Java 21+ ☕: Lenguaje de programación principal.
* TestNG ✅: Motor de ejecución y orquestación de pruebas.
* Selenium WebDriver 🌐: Automatización de interacciones con el navegador.
* Maven 📦: Gestión de dependencias y construcción del proyecto.
* JavaFaker 🎲: Generación de datos aleatorios para pruebas dinámicas.

## 📂 Estructura del Proyecto
El framework sigue una organización modular basada en Maven para separar la lógica de las pruebas de la configuración.

```text
demoautomationtesting-web-automation
├── src
│   └── main
│       └── java
│           └── com.danielbobes.web
│               └── config                              # URLs y configuración
│               └── pages                               # Clases implementando Page Object Model
├── src
│   └── test
│       ├── java
│           └── com.danielbobes.web
│               └── tests                               # Pruebas
│               └── utils                               # Utilidades
├── pom.xml                                             # Configuración y dependencias
└── README.md                                           # Documentación del proyecto
```

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