package Homework_13A_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    /**
    *Этот метод отправляет в раздел ювелирных изделий
     */
    protected void navigateToJewelry(){
        driver.findElement(By.xpath("(//a[@href='/jewelry'])[1]")).click();
    }
}
