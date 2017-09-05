package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class GroupCreationTests {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/home/alex/IdeaProjects/java_pft/geckodriver");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();

        login("admin", "secret");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private void login(String username, String password) {
        driver.get("http://192.168.1.240:8080/addressbook/");
        driver.manage().window().setSize(new Dimension(1024, 744));
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }


    private void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    private void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());

        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());

        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    private void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }


    @Test
    public void newCat1() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Категория 1", "Header1", "Footer1"));
        submitGroupCreation();
        returnToGroupPage();
    }

    @Test
    public void newCat2() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Категория 2", "Header2", "Footer2"));
        submitGroupCreation();
        returnToGroupPage();
    }


}
