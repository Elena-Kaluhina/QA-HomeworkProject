package Homework_13A_14;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Homework_Lesson_13A extends TestBase {

    @Test
    public void findElementsUsingXPath() {
        // Клик по ЛОГОТИПУ
        driver.findElement(By.xpath("//div[@class='header-logo']/a")).click();
        System.out.println("Клик по логотипу");

        // Клик по КНОПКЕ "Log in"
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        System.out.println("Клик по кнопке 'Log in'");

        // Ввести текст в ПОЛЕ ПОИСКА
        driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("computer");
        System.out.println("Введен текст 'computer' в поле поиска");

        // Клик по КНОПКЕ ПОИСКА
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        System.out.println("Клик по кнопке поиска");

        // Клик по "Shopping cart"
        driver.findElement(By.xpath("//a[@class='ico-cart']")).click();
        System.out.println("Клик по 'Shopping cart'");

        // Клик по первой категории в меню
        driver.findElement(By.xpath("(//ul[@class='top-menu']/li)[1]")).click();
        System.out.println("Клик по первой категории в меню");

        // Клик по "Register"
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        System.out.println("Клик по 'Register'");

        // Клик по первой ссылке в футере
        driver.findElement(By.xpath("(//div[@class='footer']//a)[1]")).click();
        System.out.println("Клик по первой ссылке в футере");

        // Клик по "Add to cart"
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("(//input[@class='button-2 product-box-add-to-cart-button'])[1]")).click();
        System.out.println("Клик по первой кнопке 'Add to cart'");

        // Ввести email в подписку
        driver.findElement(By.xpath("//input[@id='newsletter-email']")).sendKeys("test@example.com");
        System.out.println("Введен email в поле подписки");
    }

}
