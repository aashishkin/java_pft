package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    WebDriver driver;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        Properties properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        System.setProperty("webdriver.gecko.driver", "/home/alex/IdeaProjects/java_pft/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/alex/IdeaProjects/java_pft/chromedriver");
        System.setProperty("webdriver.opera.driver", "/home/alex/IdeaProjects/java_pft/operadriver");

        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.OPERA_BLINK)){
            driver = new OperaDriver();
        }

        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.baseUrl"));



    }

    public void stop() {
        driver.quit();
    }



}
