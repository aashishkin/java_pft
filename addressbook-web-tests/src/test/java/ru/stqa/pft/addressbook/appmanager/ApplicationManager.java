package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private String browser;
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        Properties properties = new Properties();
        String target = System.getProperty("target", "local");

        File currentDir = new File(".");
        System.out.println("Абсолютный путь ApplicationManager + " + currentDir.getAbsolutePath());

        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        System.setProperty("webdriver.gecko.driver", "/home/alex/IdeaProjects/java_pft/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/alex/IdeaProjects/java_pft/chromedriver");
        System.setProperty("webdriver.opera.driver", "/home/alex/IdeaProjects/java_pft/operadriver");

//        System.setProperty("webdriver.gecko.driver", "../geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
//        System.setProperty("webdriver.opera.driver", "../operadriver.exe");

        dbHelper = new DbHelper();
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.OPERA_BLINK)){
            driver = new OperaDriver();
        }

//        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get(properties.getProperty("web.baseUrl"));
        sessionHelper = new SessionHelper(driver);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login(properties.getProperty("web.AdminLogin"),
                properties.getProperty("web.AdminPassword"));


    }

    public void stop() {
        driver.quit();
    }



    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public DbHelper db() {
        return dbHelper;
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
