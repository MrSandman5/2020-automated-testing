package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import util.TestBot;

import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest {

    private MainPage mainPage;


    private static final TestBot TEST_BOT = new TestBot("TechoBot9", "TechnoPolis19");

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://ok.ru";
        Configuration.browser = "firefox";
        Configuration.browserBinary = "/usr/lib/firefox/firefox";
    }

    @BeforeEach
    public void init() {
        final LoginPage loginPage = new LoginPage();
        loginPage.open();
        mainPage = loginPage.authentication(TEST_BOT.getLogin(), TEST_BOT.getPassword());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.open();
    }

    @Test
    public void checkExit() {
        mainPage.exitBot();
    }

    @Test void checkNavSideCount() {
        ElementsCollection navSides = mainPage.getNavSides();
        assertEquals(15, navSides.size());
    }

    @AfterEach
    public void drop() {
        mainPage = null;
    }

}
