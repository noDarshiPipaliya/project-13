package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class LoginTest extends Utility {


    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");

        clickOnElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]"));

        String expectedMessage = "Secure Area";
        WebElement actualMessageelement = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals("navigate to secure area ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        sendTextToElement(By.id("username"),"tomsmithl");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");

        clickOnElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]"));

        String expectedMessage = "Your username is invalid!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals(" not able navigate to secure area ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {

        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"),"SuperSecretPassword");

        clickOnElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/button[1]"));

        String expectedMessage = "Your password is invalid!";
        WebElement actualMessageelement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMessageelement.getText();
        Assert.assertEquals(" not able navigate to secure area ", expectedMessage, actualMessage);
    }


}
