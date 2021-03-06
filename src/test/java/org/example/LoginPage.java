package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LoginPage {
    public SelenideElement customerButton = $("button[ng-click='customer()']");
    public SelenideElement userSelection = $(By.id("userSelect"));
    public SelenideElement loginButton = $(By.className("btn-default"));
    public SelenideElement foundTextAboutUser = $("span.fontBig.ng-binding");

    public void checkUrl(String OurUrl) {
        webdriver().shouldHave(url(ConfProperties.getProperty(OurUrl)));
    }

    public void clickCustomerButton() {
        customerButton.click();
    }

    public void enterUserSelection(String userName) {
        userSelection.selectOptionContainingText(userName);
    }

    public void loginButtonNotBe() {
        loginButton.shouldNotBe(visible);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void foundTextAboutUser(String UserName) {
        foundTextAboutUser.shouldHave(exactText(UserName));
    }
}
