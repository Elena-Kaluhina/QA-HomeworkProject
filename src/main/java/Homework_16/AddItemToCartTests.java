package Homework_16;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        // Залогиниваемся перед тестами
        login("kalughina1234@bk.ru", "Password@123");
    }

    @Test
    public void addItemToCartTest() {
        // ✅ Выбираем второй товар
        selectSecondProduct();

        // ✅ Добавляем товар в корзину
        addSecondProductToCart();

        // ✅ Проверяем успешное добавление
        verifyItemAddedByText();
    }
}