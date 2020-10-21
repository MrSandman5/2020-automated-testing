package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginText = $(By.xpath("//input[@name='st.password']"));
    private final SelenideElement passwordText = $(By.xpath("//input[@name='st.email']"));
    private final SelenideElement authButton = $(By.xpath("//input[@type='submit']"));

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public MainPage authentication(final String login,
                                   final String password) {
        setLoginText(login);
        setPasswordText(password);
        authButton.click();
        return new MainPage();
    }

    public String getLoginText() {
        return loginText.getValue();
    }

    public String getPasswordText() {
        return passwordText.getValue();
    }

    public String getAuthButton() {
        return authButton.getValue();
    }

    public void setLoginText(final String text) {
        loginText.sendKeys(text);
    }

    public void setPasswordText(final String text) {
        passwordText.sendKeys(text);
    }

}
