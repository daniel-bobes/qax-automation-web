package com.bobes.daniel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MiPrimerTest {

    private static final String QAXPERT_URL = "https://qaxpert.com";

    @Test
    public void searchBlogArticle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Abrir QAXpert
        driver.get(QAXPERT_URL);

        // 2. Hacer click en el menú Blog
        driver.findElement(By.linkText("BLOG")).click();
        Thread.sleep(2000);

        // Cerrar el navegador
        driver.quit();
    }
}
