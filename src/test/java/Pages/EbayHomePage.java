package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EbayHomePage extends Page {

    public EbayHomePage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get("https://www.ebay.com/");
    }

    public RegistrationPage gerRegPage() {
        webDriver.findElement(By.linkText("зарегистрируйтесь")).click();
        return new RegistrationPage(webDriver);
    }

    public EbayHomePage login(String email, String pass) {
        webDriver.findElement(By.linkText("Войдите")).click();
        webDriver.findElement(By.id("userid")).sendKeys(email);
        webDriver.findElement(By.id("pass")).sendKeys(pass);
        webDriver.findElement(By.id("sgnBt")).click();
        //Здесь может всплыть окно по лучшению защиты аккаунта, надо вставить дейтсвие если так будет
        return this;
    }

    public ResultPage search(String query) {
        webDriver.findElement(By.id("gh-ac")).sendKeys(query);
        webDriver.findElement(By.id("gh-btn")).click();
        return new ResultPage(webDriver);
    }
}
