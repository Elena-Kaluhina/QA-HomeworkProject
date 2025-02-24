package Homework_17.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window(); //.maximize();
    }

    @AfterMethod
    public void tearDown() {
        if ( driver != null) {
            driver.quit();
        }
    }

    // Метод для логина
    protected void login() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized! Make sure setUp() is called first.");
        }
        //driver.findElement(By.className("ico-login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        By loginButton = By.className("ico-login");

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        driver.findElement(By.id("Email")).sendKeys("kalughina1234@bk.ru");
        driver.findElement(By.id("Password")).sendKeys("Password@123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }
}