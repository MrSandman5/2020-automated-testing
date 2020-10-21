package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement profileUcard = $(By.xpath("//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']"));
    private final SelenideElement ucardExit = $(By.xpath("//a[@class='lp']"));

    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage exit() {
        profileUcard.click();
        ucardExit.click();
        return new LoginPage();
    }

}
