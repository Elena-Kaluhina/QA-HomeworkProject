package Homework_17.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Локатор для второго товара
    private By secondProduct = By.xpath("(//div[@class='item-box'])[2]");
    private By addToCartButton = By.xpath("(//input[@value='Add to cart'])[2]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для проверки наличия товара
    public boolean isSecondProductPresent() {
        return driver.findElements(secondProduct).size() > 0;
    }

    // Метод для добавления товара в корзину
    public void addSecondProductToCart() {
        driver.findElement(addToCartButton).click();
    }

}
