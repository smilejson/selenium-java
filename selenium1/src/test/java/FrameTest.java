import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FrameTest {

    public static WebDriver driver;

    @BeforeAll
    public static void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterAll
    public static void after(){
//        driver.quit();
    }

    @Test
    public void frameTest(){
        driver.get("https://www.runoob.com/try/try.php?filename=jqueryui-api-droppable");

        //跳转到frame
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.id("draggable")).getText());
        //跳出frame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.id("submitBTN")).getText());

    }

}
