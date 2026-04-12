package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.pages.bonigarcia.InfiniteScrollPage;
import com.danielbobes.web.tests.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

public class InfiniteScrollTest extends BaseTest {

    @Test(testName = "Infinite Scroll Test")
    public void infiniteScrollTest() {
        int timesToScroll = 20;
        driver.get(Config.URL_BONI_GARCIA_INFINITE_SCROLL);

        InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage(driver);

        List<String> paragraphs = infiniteScrollPage.getParagraphs();
        System.out.println("Párrafos iniciales: " + paragraphs.size());

        infiniteScrollPage.doInfiniteScroll(timesToScroll);

        System.out.println("Párrafos cargados: ");
        for (String paragraph : paragraphs) {
            System.out.println(paragraph);
        }
    }
}
