package Homework_17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локатор для сообщения об успешном добавлении товара
    private By successMessage = By.xpath("//p[@class='content' and contains(text(), 'The product has been added')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Метод для ожидания сообщения о добавлении товара
    public boolean isItemAdded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElements(successMessage).size() > 0;
    }
}
