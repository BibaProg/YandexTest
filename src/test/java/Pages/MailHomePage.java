package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailHomePage extends Page{

    public MailHomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://www.mail.ru");
    }

    public MailHomePage login(String email, String pass) {
        webDriver.findElement(By.id("mailbox:login")).sendKeys(email);
        webDriver.findElement(By.id("mailbox:password")).sendKeys(pass);
        webDriver.findElement(By.id("mailbox:submit")).click();
        return this;
    }

    public EbayHomePage findActivateMail() {
        webDriver.findElement(By.cssSelector("a[data-subject = 'Подтвердите ваш адрес эл. почты в течение 24 часов']")).click();
        webDriver.findElement(By.linkText("Подтвердить")).click();
        webDriver.close();
        String[] strings = webDriver.getWindowHandles().toArray(new String[webDriver.getWindowHandles().size()]);
        webDriver.switchTo().window(strings[0]);
        new WebDriverWait(webDriver,10).until(ExpectedConditions.titleContains("Войдите или"));
        return new EbayHomePage(webDriver);
    }
}
