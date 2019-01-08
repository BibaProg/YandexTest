import Pages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class RunEbayTest {
    private WebDriver webDriver;
    String name, secondName,email,pass,query;

    @Before
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        webDriver = new ChromeDriver(capabilities);
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        name = "Diablo";
        secondName = "PonelitelUjasa";
        email = "kray2020@inbox.ru";
        pass = "123qwesdxc";
        query = "blackberry";
    }

    @Test
    public void ebayTest(){
        EbayHomePage ebayHomePage = new EbayHomePage(webDriver).gerRegPage().registration(name,secondName,email,pass);
        ResultPage resultPage = new MailHomePage(webDriver).login(email,pass).findActivateMail().login(email,pass).search(query);
        assertTrue(resultPage.getResultCount() == 50);
        assertTrue(resultPage.exit().getStatus());

    }

    @After
    public void stop(){
        webDriver.quit();
        webDriver = null;
    }
}
