package Homework_15;

import org.testng.annotations.Test;

public class CreateLoginTests extends TestBase{

    @Test
    public void loginExistedUserTest(){
        openLoginPage();
        enterEmail(("kalughina1234@bk.ru"));
        enterPassword(("Password@123"));
        submitLogin();
        verifyLoginSuccess();

    }

}
