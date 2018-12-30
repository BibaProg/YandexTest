import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


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
    public void testYandexMarket() {
        webDriver.get("https://www.yandex.ru/");
        webDriver.findElement(By.linkText("Маркет")).click();
        webDriver.findElement(By.cssSelector("[data-bem *= Компьютерная]")).click();
        webDriver.findElement(By.cssSelector("a[href *= noutbuki]")).click();
    }

    @Test
    public void testTinkof() throws InterruptedException {
        webDriver.get("https://www.tinkoff.ru/");
        List<WebElement> webElements = webDriver.findElements(By.xpath("//*[@class='header__1AlOP']"));
        System.out.println(webElements.get(webElements.size()-1).getTagName());//Обратились к последнему
        System.out.println(webElements.get(1).getText());//Обратились ко второму
        System.out.println(webElements.get(1).findElement(By.xpath("..")).getAttribute("class"));//Обратились к родителю второго
        List<WebElement> parentHrefs = webElements.get(1).findElements(By.xpath("..//a"));
        System.out.println("------------");
        for(WebElement we: parentHrefs){
            System.out.println(we.getText());
        }
    }
    @After
    public void stop(){
        webDriver.quit();
        webDriver = null;
    }
}
