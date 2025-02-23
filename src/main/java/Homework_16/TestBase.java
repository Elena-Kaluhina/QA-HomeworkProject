package Homework_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        driver.manage().window().maximize();
    }

    @AfterMethod (enabled = false)
    public void tearDown() {
        driver.quit();
    }

    protected void login(String email, String password) {
        click(By.className("ico-login"));
        typeText(By.id("Email"), email);
        typeText(By.id("Password"), password);
        click(By.xpath("//input[@value='Log in']"));
    }

    protected void selectSecondProduct() {
        By secondProduct = By.xpath("(//div[@class='item-box'])[2]");
        Assert.assertTrue(isElementPresent(secondProduct), "❌ Второй товар не найден!");
    }

    protected void addSecondProductToCart() {
        By addToCartButton = By.xpath("(//input[@value='Add to cart'])[2]");
        click(addToCartButton);
    }

    protected void verifyItemAddedByText() {
        // Ожидаем появления сообщения о добавлении товара
        By successMessage = By.xpath("//p[@class='content' and contains(text(), 'The product has been added')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        // Получаем текст уведомления
        String messageText = driver.findElement(successMessage).getText();
        // Проверяем, содержит ли текст подтверждение
        Assert.assertTrue(isElementPresent(successMessage), "❌ Товар не добавлен в корзину!");
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void typeText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}