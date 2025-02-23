package Homework_15;

import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void createAccountPositiveTest() {
        // ✅ 1. Открываем сайт и кликаем "Log in"
        openLoginPage();

        // ✅ 2. Кликаем "Register"
        openRegisterPage();
        
        // ✅ 3. Заполняем регистрационную форму
        fillRegistrationForm();

        // ✅ 4. Кликаем "Register"
        submitRegistration();

        // ✅ 5. Ожидаем появления сообщения "Your registration completed" или кнопки "Log out"
        verifyRegistrationSuccess();

        // ✅ 6. Выходим из аккаунта
        logout();
    }

}
