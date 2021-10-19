package com.nc.edu.ta.VladislavVolodin.prN7;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
    ChromeDriver webDriver;
    MainPage mainPage;
    LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vlad\\OneDrive\\Документы\\tools\\chromedriver.exe");
        webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, 30, 500);
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        webDriver.get("https://inventory.edu-netcracker.com/pages/registration.xhtml");
        System.out.println("Test start");
    }

    @After
    public void close() {
        if (webDriver != null) {
            webDriver.quit();
            System.out.println("Test close");
        }
    }
}
