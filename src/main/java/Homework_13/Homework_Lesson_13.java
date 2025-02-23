package Homework_13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework_Lesson_13 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // Открываем браузер
        driver.get("https://demowebshop.tricentis.com/"); // Переходим на сайт
        driver.manage().window().maximize(); // Разворачиваем браузер
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Ждем загрузки
    }

    @Test
    public void findElementsUsingXPath() {
        // 1. Найти логотип сайта
        WebElement logo = driver.findElement(By.xpath("//div[@class='header-logo']/a"));
        System.out.println("Логотип найден: " + logo.getAttribute("href"));

        // 2. Найти кнопку "Log in"
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='ico-login']"));
        System.out.println("Кнопка входа найдена: " + loginButton.getText());

        // 3. Найти поле поиска
        WebElement searchField = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        System.out.println("Поле поиска найдено, value: " + searchField.getAttribute("value"));

        // 4. Найти кнопку поиска
        WebElement searchButton = driver.findElement(By.xpath("//input[@class='search-box-button']"));
        System.out.println("Кнопка поиска найдена, текст: " + searchButton.getAttribute("value"));

        // 5. Найти ссылку "Shopping cart"
        WebElement shoppingCart = driver.findElement(By.xpath("//a[@class='ico-cart']"));
        System.out.println("Ссылка на корзину найдена: " + shoppingCart.getText());

        // 6. Найти все элементы главного меню
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='top-menu']/li"));
        System.out.println("Количество пунктов меню: " + menuItems.size());

        // 7. Найти кнопку "Register"
        WebElement registerButton = driver.findElement(By.xpath("//a[@class='ico-register']"));
        System.out.println("Кнопка регистрации найдена: " + registerButton.getText());

        // 8. Найти все категории товаров
        List<WebElement> categories = driver.findElements(By.xpath("//ul[@class='top-menu']/li/a"));
        System.out.println("Найдено категорий товаров: " + categories.size());

        // 9. Найти все ссылки в футере
        List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='footer']//a"));
        System.out.println("Количество ссылок в футере: " + footerLinks.size());

        // 10. Найти все кнопки "Add to cart"
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']"));
        System.out.println("Найдено кнопок 'Add to cart': " + addToCartButtons.size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit(); // Закрываем браузер
    }
}

