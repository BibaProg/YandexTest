package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends Page{

    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public int getResultCount() {
        return webDriver.findElements(By.cssSelector("[class *= sresult]")).size();
    }
}
