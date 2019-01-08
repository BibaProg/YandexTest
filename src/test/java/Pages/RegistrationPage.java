package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends Page {


    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EbayHomePage registration(String name, String secondName, String email, String pass) {
        webDriver.findElement(By.id("firstname")).sendKeys(name);
        webDriver.findElement(By.id("lastname")).sendKeys(secondName);
        webDriver.findElement(By.id("email")).sendKeys(email);
        webDriver.findElement(By.id("PASSWORD")).sendKeys(pass);
        new WebDriverWait(webDriver,10).until(ExpectedConditions.elementToBeClickable(By.id("ppaFormSbtBtn")));
        webDriver.findElement(By.id("ppaFormSbtBtn")).click();
        webDriver.findElement(By.id("reginter")).click();
        return new EbayHomePage(webDriver);
    }
}
