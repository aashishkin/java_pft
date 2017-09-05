package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "/home/alex/IdeaProjects/java_pft/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/home/alex/IdeaProjects/java_pft/chromedriver");
        System.setProperty("webdriver.opera.driver", "/home/alex/IdeaProjects/java_pft/operadriver");
        String browser = BrowserType.OPERA_BLINK;
        if (browser == BrowserType.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME) {
            driver = new ChromeDriver();
        } else if (browser == BrowserType.OPERA_BLINK){
            driver = new OperaDriver();
        }

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://192.168.1.240:8080/addressbook/");
        sessionHelper = new SessionHelper(driver);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }



    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
