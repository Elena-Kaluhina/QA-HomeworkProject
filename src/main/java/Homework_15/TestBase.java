package Homework_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false) // ❌ Отключено, чтобы тест не закрывал браузер
    public void tearDown() {
        driver.quit();
    }

    // ✅ Метод для клика по элементу
    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    // ✅ Метод для ввода текста
    protected void typeText(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    // ✅ Проверяет, есть ли элемент на странице
    protected boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    protected void logout() {
        click(By.xpath("//a[@class='ico-logout']"));
    }

    protected void verifyRegistrationSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Ожидаем, что появится сообщение об успешной регистрации
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Your registration completed')]")
        ));

        Assert.assertTrue(successMessage.isDisplayed(), "Ошибка: Сообщение об успешной регистрации не найдено!");

        // ✅ Ожидаем, что кнопка "Log in" исчезнет
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@class='ico-login']")));

        // ✅ Ожидаем, что кнопка "Log out" появится
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@class='ico-logout']")
        ));

        Assert.assertTrue(logoutButton.isDisplayed(), "Ошибка: Кнопка 'Log out' не появилась!");
    }

    protected void submitRegistration() {
        click(By.id("register-button"));
    }

    protected void fillRegistrationForm() {
        // ✅  Выбираем пол (Female)
        click(By.xpath("//input[@id='gender-female']"));

        // ✅  Вводим имя
        typeText(By.id("FirstName"), "Anna");

        // ✅  Вводим фамилию
        typeText(By.id("LastName"), "Smith");

        // ✅ Вводим УНИКАЛЬНЫЙ email (чтобы не было ошибки "Email уже существует")
        // String email = "test1" + System.currentTimeMillis() + "@test.com";
        typeText(By.id("Email"), "kalughina1234@bk.ru"); // для одноразовой регистрации

        // ✅  Вводим пароль
        typeText(By.id("Password"), "Password@123");

        // ✅  Подтверждаем пароль
        typeText(By.id("ConfirmPassword"), "Password@123");
    }

    protected void openRegisterPage() {
        click(By.xpath("//input[@value='Register']"));
    }

    protected void openLoginPage() {
        click(By.xpath("//a[@class='ico-login']"));
    }

    protected void verifyLoginSuccess() {
        // Ожидаем появления кнопки "Log out" после успешного входа
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ico-logout']")));
            Assert.assertTrue(isElementPresent(By.xpath("//a[@class='ico-logout']")),
                    "Кнопка 'Log out' не найдена. Логин не выполнен.");
        } catch (Exception e) {
            Assert.fail("Ошибка при проверке успешного логина: " + e.getMessage());
        }
    }

        protected void submitLogin () {
            click(By.xpath("//input[@class='button-1 login-button']"));
        }

        protected void enterPassword (String password){
            typeText(By.id("Password"), password);
        }

        protected void enterEmail (String email){
            // Проверяем, находимся ли мы на странице логина
            if (!driver.getCurrentUrl().contains("login")) {
                System.out.println("Перенаправляемся на страницу логина...");
                openLoginPage();
            }

            // Ожидаем, пока появится поле email, чтобы убедиться, что мы точно на странице логина
            WebElement emailField = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='Email' or @name='Email']")));

            emailField.clear();
            emailField.sendKeys(email);
        }
    }
