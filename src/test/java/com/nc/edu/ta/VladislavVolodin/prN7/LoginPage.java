package com.nc.edu.ta.VladislavVolodin.prN7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver webDriver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@class='button']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@class='button']")
    WebElement RegistrationButton;

    @FindBy(xpath = "//input[@name='j_username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name='j_password']")
    WebElement passwordField;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void enterLogin(String userName) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys("Password123$");
    }


    public void ClickLogin() {
        loginButton.click();
    }

    public void ClickRegistration() {
        RegistrationButton.click();
    }
}
