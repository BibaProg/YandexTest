package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    public WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public EbayHomePage exit(){
        webDriver.findElement(By.id("gh-ug")).click();
        webDriver.findElement(By.linkText("Выход")).click();
        return new EbayHomePage(webDriver);
    }

    public boolean getStatus() {
        if(webDriver.findElements(By.linkText("Войдите")).size() > 0 ){
            return true;
        }
        else {
            return false;
        }
    }
}
