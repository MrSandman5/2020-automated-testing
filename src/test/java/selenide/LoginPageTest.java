package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import util.TestBot;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest {

    private LoginPage loginPage;
    private static final TestBot TEST_BOT = new TestBot("TechoBot9", "TechnoPolis19");

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru";
        Configuration.browser = "firefox";
        Configuration.browserBinary = "/usr/lib/firefox/firefox";
    }

    @BeforeEach
    public void init() {
        loginPage = new LoginPage();
        loginPage.open();
    }

    @Order(1)
    @Test
    public void checkButtonName() {
        assertEquals(loginPage.getAuthButton(), "Log in to OK");
    }

    @Order(2)
    @Test
    public void checkLogin() {
        loginPage.setLoginText(TEST_BOT.getLogin());
        assertEquals(loginPage.getLoginText(), TEST_BOT.getLogin());
    }

    @Order(3)
    @Test
    public void checkPassword() {
        loginPage.setPasswordText(TEST_BOT.getPassword());
        assertEquals(loginPage.getPasswordText(), TEST_BOT.getPassword());
    }

    @Order(4)
    @Test
    public void checkAuthentication() throws InterruptedException {
        loginPage.authentication(TEST_BOT.getLogin(), TEST_BOT.getPassword());
        Thread.sleep(3000);
    }

    @AfterEach
    public void drop() {
        loginPage = null;
    }

}
