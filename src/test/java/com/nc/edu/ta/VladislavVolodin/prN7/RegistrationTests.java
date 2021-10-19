package com.nc.edu.ta.VladislavVolodin.prN7;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RegistrationTests extends WebDriverSettings {

    private WebElement result;

    private void makeScreenShot(String s) throws Exception {
        Thread.sleep(3000);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        image.createGraphics();
        ImageIO.write(image, "PNG", new File(".\\src\\main\\resources\\" + s + ".png"));
    }

    @Test
    public void testTitle() {
        String title = webDriver.getTitle();
        Assert.assertEquals("Registration", title);
    }

    @Test // ID = 1
    public void testSuccessRegistrationRandomUser() throws Exception {
        System.out.println("Step 1: Fills form and Registration new User");
        String newUserName = "Qwerty12";     //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
//        driver.findElement(By.id("registerForm:role")).sendKeys("User1");
        makeScreenShot("1.testSuccessRegistrationRandomUser_Step1");
        mainPage.ClickRegistration();
        makeScreenShot("1.testSuccessRegistrationRandomUser_Step1.1");
        result = webDriver.findElement(By.cssSelector("div[class='justRegisteredBlock']"));
        String expectedMessage = "You have successfully registered\n" + "Use your credentials to login";
        assertEquals(result.getText(), expectedMessage);
        Thread.sleep(2000);
        loginPage.enterLogin(newUserName);
        System.out.println("Step 2: Fills form for login");
        makeScreenShot("1.testSuccessRegistrationRandomUser_Step2");
        System.out.println("Step 3: wrapper to next page");
        Thread.sleep(2000);
        loginPage.ClickLogin();
        makeScreenShot("1.testSuccessRegistrationRandomUser_Step3");
        result = webDriver.findElement(By.xpath("//a[@href='/pages/startpage.xhtml']"));
        result.getText();
        expectedMessage = "Software Logo";
        assertEquals(result.getText(), expectedMessage);
    }


    @Test // ID = 2
    public void testNecessaryUserNameField() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "";
        mainPage.createFieldsOfUser(newUserName);
        makeScreenShot("2.testNecessaryUserNameField_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("2.testNecessaryUserNameField_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']"));
        String expectedMessage = "Login must not be empty.";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 3.1
    public void testNecessaryPasswordField() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567"; //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setPasswordField("");
        makeScreenShot("3.1.testNecessaryPasswordField_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("3.1.testNecessaryPasswordField_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO логин ошибка и пассворд имеют один и тот же икспасс
        String expectedMessage = "Please enter password.";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }


    @Test // ID = 3.2
    public void testRequirementPasswordField() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567"; //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setPasswordField("pass");
        makeScreenShot("3.2.testRequirementPasswordField_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("3.2.testRequirementPasswordField_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO логин ошибка и пассворд имеют один и тот же икспасс
        String expectedMessage = "Password length must me >= 8 and <= 50.";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 3.3
    public void testRequirementPasswordField2() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567"; //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setPasswordField("password123");
        makeScreenShot("3.3.testRequirementPasswordField2_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("3.3.testRequirementPasswordField2_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO логин ошибка и пассворд имеют один и тот же икспасс
        String expectedMessage = "At least one upper letter must be in password";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 3.4
    public void testRequirementPasswordField3() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567"; //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setPasswordField("PASSWORD123");
        makeScreenShot("3.4.testRequirementPasswordField3_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("3.4.testRequirementPasswordField3_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO логин ошибка и пассворд имеют один и тот же икспасс
        String expectedMessage = "At least one lower letter must be in password";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 3.5
    public void testRequirementPasswordField4() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567"; //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setPasswordField("PASSWORd");
        makeScreenShot("3.5.testRequirementPasswordField4_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("3.5.testRequirementPasswordField4_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO логин ошибка и пассворд имеют один и тот же икспасс
        String expectedMessage = "At least one digit must be in password";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 3.6
    public void testRequirementPasswordField5() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567"; //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setPasswordField("PASSWORd1");
        makeScreenShot("3.6.testRequirementPasswordField5_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("3.6.testRequirementPasswordField5_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO логин ошибка и пассворд имеют один и тот же икспасс
        String expectedMessage = "At least one non alpha numeric symbol must be in password";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 4
    public void testNecessaryEmailField() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567"; //TODO Login don't repeat <<< change Login
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setEmailField("");
        makeScreenShot("4.testNecessaryEmailField_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("4.testNecessaryEmailField_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO логин ошибка и пассворд имеют один и тот же икспасс
        String expectedMessage = "email field can't be empty";
        System.out.println("Step 3: Compare expected error message with result message");
        assertEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 5
    public void testExistEmail() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty12345678";
        mainPage.createFieldsOfUser(newUserName);
        mainPage.setEmailField("User@mail.ru");
        makeScreenShot("5.testExistEmail_Step1");
        System.out.println("Step 2: Registration new User");
        mainPage.ClickRegistration();
        makeScreenShot("5.testExistEmail_Step2");
        result = webDriver.findElement(By.xpath("//span[@class='error']")); //TODO test failed
        String expectedMessage = "email field can't be empty";
        System.out.println("Step 3: Compare expected error message with result message");
        assertNotEquals(result.getText(), expectedMessage);
    }

    @Test // ID = 6
    public void testNotNecessaryRoleField() throws Exception {
        System.out.println("Step 1: Fills form");
        String newUserName = "Qwerty1234567";
        mainPage.createFieldsOfUser(newUserName);
        Select selectRole = new Select(webDriver.findElement(By.id("registerForm:role")));
        selectRole.selectByVisibleText("Read / Write");
//        WebElement role = webDriver.findElement(By.xpath("//option[@selected='RW']"));
        makeScreenShot("6.testNotNecessaryRoleField_Step1");

        String expectedMessage = "Read / Write";
        System.out.println("Step 3: Compare expected error message with result message");
//        assertEquals(selectRole.selectByVisibleText("Read / Write"), expectedMessage);
    }
}
