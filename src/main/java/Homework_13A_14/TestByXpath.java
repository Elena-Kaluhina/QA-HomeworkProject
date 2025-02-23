package Homework_13A_14;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestByXpath extends TestBase {

    @Test
    public void FindElementsByXpath(){
        driver.findElement(By.xpath("*[//@class='top-menu-triangle']"));
        driver.findElement(By.xpath("//*[@class='top-menu-triangle']"));
        driver.findElement(By.xpath("//div[@class='header-logo']//img[1]"));
        driver.findElement(By.xpath("//*[starts-with(text(),'Demo')]"));
        //driver.findElements(By.xpath("//div[@class='price actual-price' and text()='2100.00']"));
        driver.findElements(By.xpath("//*[class='price actual-price' and text()='2100.00']"));
        driver.findElements(By.xpath("//*[contains(@class,  'price') and contains(text(),'210')]"));
        navigateToJewelry();
        //driver.get("https://demowebshop.tricentis.com/jewelry");
        //driver.navigate().to("https://demowebshop.tricentis.com/jewelry");
        driver.findElement(By.xpath("//*[@id='products-orderby']"));

    }
}
