package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private String browser;
    protected WebDriver driver;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
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

        driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://192.168.1.240:8080/addressbook/");
        sessionHelper = new SessionHelper(driver);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }



    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
