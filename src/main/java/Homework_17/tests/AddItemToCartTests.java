package Homework_17.tests;

import Homework_17.pages.CartPage;
import Homework_17.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase{
    private HomePage homePage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        login();
    }
    @Test
    public void addItemToCartTest() {
        // ✅ Проверяем наличие второго товара
        Assert.assertTrue(homePage.isSecondProductPresent(), "❌ Второй товар не найден!");

        // ✅ Добавляем товар в корзину
        homePage.addSecondProductToCart();

        // ✅ Проверяем успешное добавление
        Assert.assertTrue(cartPage.isItemAdded(), "❌ Товар не был добавлен в корзину!");
    }

}
