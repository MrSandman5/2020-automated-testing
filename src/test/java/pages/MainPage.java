package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement profileUcard = $(By.xpath("//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']"));
    private final SelenideElement ucardExit = $(By.xpath("//a[@class='lp']"));
    private final SelenideElement navSideShow = $(By.xpath("//div[@class='nav-side_toggler_tx __show-more']"));
    private final SelenideElement navSide = $(By.xpath("//div[@class='nav-side __navigation __user-main']"));

    public MainPage open() {
        Selenide.open("/");
        return this;
    }

    public LoginPage exitBot() {
        profileUcard.click();
        ucardExit.click();
        return new LoginPage();
    }

    public ElementsCollection getNavSides() {
        navSideShow.click();
        return navSide.$$(By.xpath("//*[count(ancestor::*) = 1]"));
    }

}
