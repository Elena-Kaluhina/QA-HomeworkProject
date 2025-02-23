package Homework_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework_Lesson_12 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver(); // этим шагом мы открываем браузер
        driver.get("https://demowebshop.tricentis.com/"); //открываем сайт с которым будем работать
        driver.manage().window().maximize(); // разворачивает на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // время задержки 10 секунд (неявное ожидание)

    }

    @Test
    public void FindElementsByCssSelectors() {

        // 1. Найти логотип сайта
        WebElement logo = driver.findElement(By.cssSelector("div.header-logo a"));
        System.out.println("Логотип найден, текст: " + logo.getAttribute("href"));

        // 2. Найти кнопку "Log in"
        WebElement loginButton = driver.findElement(By.cssSelector("a.ico-login"));
        System.out.println("Кнопка входа найдена, текст: " + loginButton.getText());

        // 3. Найти поле поиска
        WebElement searchField = driver.findElement(By.cssSelector("input#small-searchterms"));
        String searchValue = searchField.getAttribute("value");
        System.out.println("Текст в поле поиска: " + searchValue);

        // 4. Найти кнопку поиска
        WebElement searchButton = driver.findElement(By.cssSelector("input.search-box-button"));
        System.out.println("Кнопка поиска найдена, значение: " + searchButton.getAttribute("value"));

        // 5. Найти ссылку на "Shopping cart"
        WebElement shoppingCartLink = driver.findElement(By.cssSelector("a.ico-cart"));
        System.out.println("Ссылка на корзину найдена, текст: " + shoppingCartLink.getText());

        // 6. Найти все элементы главного меню
        List<WebElement> menuItems = driver.findElements(By.cssSelector("ul.top-menu > li"));
        System.out.println("Найдено пунктов меню: " + menuItems.size());

        // 7. Найти кнопку "Register" (регистрация)
        WebElement registerButton = driver.findElement(By.cssSelector("a.ico-register"));
        System.out.println("Кнопка регистрации найдена, текст: " + registerButton.getText());

        // 8. Найти все категории товаров (например, "Books", "Computers" и т. д.)
        List<WebElement> categories = driver.findElements(By.cssSelector("ul.top-menu > li > a"));
        System.out.println("Найдено категорий товаров: " + categories.size());

        // 9. Найти ссылки в футере
        List<WebElement> footerLinks = driver.findElements(By.cssSelector("div.footer a"));
        System.out.println("Количество ссылок в футере: " + footerLinks.size());

        // 10. Найти кнопки "Add to cart" на товарах
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("input.button-2.product-box-add-to-cart-button"));
        System.out.println("Найдено кнопок 'Add to cart': " + addToCartButtons.size());
    }


    @AfterMethod(enabled = true) // выполнять блок кода далее или нет
    public void tearDown(){
        driver.quit(); // завершает работу всего браузера

    }
}

