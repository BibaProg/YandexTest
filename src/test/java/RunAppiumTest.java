import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RunAppiumTest {
    AndroidDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "device");
        caps.setCapability("udid", "524a87ad"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.2.2");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity","com.android.contacts.activities.DialtactsActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testSearchAppium() throws MalformedURLException {
        String nameForTest = "Test";
        String secondNameForTest = "Contact";
        String telefonNumberForTest = "999 999-99-99";
        System.out.println("App launched"+"\n"+"Name for Test: " + nameForTest + "\n"+"Second name: " + secondNameForTest
                        + "\n" + "Telefon number: " + telefonNumberForTest +"\n");

        System.out.print("Заходим во вкладку контакты");
        List<WebElement> webElements = driver.findElements(By.className("android.widget.ImageView"));
        webElements.get(webElements.size()-1).click();
        System.out.println("....OK");

        System.out.print("Нажимаем создать новый контакт");
        driver.findElementByAccessibilityId("Новый контакт").click();
        System.out.println("....OK");

        System.out.print("Выбираем аккаунт которому добавляем контакт");
        webElements = driver.findElements(By.className("android.widget.ImageView"));
        webElements.get(0).click();
        System.out.println("....OK");

        System.out.print("Открываем дополнительные поля");
        driver.findElementByAccessibilityId("Показать/скрыть дополнительные поля").click();
        System.out.println("....OK");

        System.out.print("Заполняем поля тестовыми данными");
        driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Имя')]")).sendKeys(nameForTest);
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Фамилия')]")).sendKeys(secondNameForTest);
        driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Телефон')]")).sendKeys(telefonNumberForTest);
        System.out.println("....OK");

        System.out.print("Создаем контакт");
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Готово')]")).click();
        System.out.println("....OK");

        System.out.print("Открывем приложение контакты");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "device");
        caps.setCapability("udid", "524a87ad"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.2.2");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
        System.out.println("....OK");

        System.out.print("Открываем поле поиска");
        driver.findElementByAccessibilityId("Поиск").click();
        System.out.println("....OK");

        System.out.print("Вводим поисковый запрос");
        driver.findElementByAccessibilityId("Поисковый запрос").sendKeys(nameForTest);
        System.out.println("....OK");

        System.out.print("Выбираем первый вариант из списка");
        driver.findElement(By.xpath("//android.view.View/android.widget.TextView")).click();
        System.out.println("....OK");

        System.out.print("Читаем имя и фамилию");
        String str = driver.findElementByAccessibilityId("Перейти вверх")
                .findElement(By.className("android.widget.TextView")).getText();
        System.out.println("....OK");

        if(str.equals(secondNameForTest+", "+nameForTest)){
            System.out.println("Имя и фамилия совпадают");
        }

        System.out.print("Читаем номер телефона");
        str = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'МОБИЛЬНЫЙ')]/../../android.widget.TextView")).getText();
        System.out.println("....OK");

        if(str.equals(telefonNumberForTest)){
            System.out.println("Телефон совпадает");
        }

        System.out.print("Открываем вкладку еще");
        driver.findElementByAccessibilityId("Ещё").click();
        System.out.println("....OK");

        System.out.print("Удаляем контакт");
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Удалить')]")).click();
        driver.findElement(By.xpath("//android.widget.Button[contains(@text,'ОК')]")).click();
        System.out.println("....OK");

        System.out.println("Test complete");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
