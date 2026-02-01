package com.bobes.daniel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MiPrimerTest {

    @Test
    public void searchBlogArticle() throws InterruptedException {
        // Configurar el driver de Chrome automáticamente
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Abrir QAXpert
        driver.get("https://qaxpert.com");

        // 2. Hacer click en el menú Blog
        driver.findElement(By.linkText("BLOG")).click();
        Thread.sleep(2000);

        // Cerrar el navegador
        driver.quit();
    }
}
