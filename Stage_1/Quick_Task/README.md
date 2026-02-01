# Quick Task
___
- **📁 Carpeta:** `Stage_1/Quick_Task`
- **🎯 Objetivo:** Configurar el entorno y crear nuestro primer proyecto maven con Selenium Web Driver y Java para la automatización de pruebas Web.

___
# 🚀 Ejercicio 1
- **📁 Carpeta:** `Stage_1/Quick_Task/QuickTask1`
- **🎯 Objetivo:** Configurar el entorno y creación del primer proyecto maven con Selenium Web Driver y Java y ejecutar nuestra primera prueba web automatizada con Selenium y Java.

## 📝 Instrucciones
1. Crea un proyecto maven con Selenium Web Driver y Java.
2. Agrega la clase de test `MiPrimerTest.java`.
```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MiprimerTest {
        
            @Test
            public void searchBlogArticle() throws InterruptedException {
                // Configurar el driver de Chrome automáticamente
                WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
        
                // 1. Abrir QAXpert
                driver.get("https://qaxpert.com");
        
                // 2. Hacer click en el menú Blog
                driver.findElement(By.linkText("Blog")).click();
                Thread.sleep(2000);
        
                // Cerrar el navegador
                driver.quit();
            }
}
```

3. Abre la terminal y ejecuta el comando `mvn test` para ejecutar la prueba.
4. Graba un video corto (10-20 s) mostrando la ejecución de la prueba.

## Flujo de ejecución de la prueba
**Resumen del flujo:** abre el navegador, carga la página de QAXpert y hace clic en la página de blog.

**Pasos:**
1. Se configura de forma automática el driver de Google Chrome.
2. Se abre el navegador Google Chrome.
3. Se maximiza la ventana del navegador.
4. Se navega a la página de [QAXpert](https://qaxpert.com).
5. Se pulsa en la opción de menú `BLOG`.
6. Realiza una espera 2 segundos.
7. Se cierra el navegador.

Puedes ver la grabación de la ejecución [aquí](./QuickTask1/grabaciones/Grabación%20de%20la%20ejecución%20del%20test.mp4). 
___

# 🚀 Ejercicio 2
- **📁 Carpeta:** `Stage_1/Quick_Task/QuickTask2`
- **🎯 Objetivo:** TODO