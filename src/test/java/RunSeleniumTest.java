import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RunSeleniumTest {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @Before
    public void start() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver,10);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @Test
    public void testGoogle() throws InterruptedException {
        Actions actions = new Actions(webDriver);
        webDriver.get("https://www.yandex.ru/");
        webDriver.findElement(By.linkText("Маркет")).click();
        webDriver.findElement(By.cssSelector("[data-bem *= Компьютерная]")).click();
        webDriver.findElement(By.cssSelector("a[href *= noutbuki]")).click();
    }
    @After
    public void stop(){
        webDriver.quit();
        webDriver = null;
    }
}
