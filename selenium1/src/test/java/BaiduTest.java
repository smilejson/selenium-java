import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BaiduTest {
    public WebDriver driver;
    String baseUrl = "http://www.baidu.com/";
    @Test
    public void testBaiduSearch() {
        driver.get(baseUrl);
        WebElement inputBox = driver.findElement(By.id("kw"));
        Assert.assertTrue(inputBox.isDisplayed());
        inputBox.sendKeys("CSDN");
        driver.findElement(By.id("su")).click();
    }

    @Test
    public void waitTest(){
        driver.get(baseUrl);
//        driver.findElement(By.id("kw"));


        WebDriverWait wait=new WebDriverWait(driver,5);
        /*显示等待方式1*/
        WebElement kw = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                /*内部类的方式可以做其他的操作*/
                return driver.findElement(By.id("kw"));
            }
        });
        kw.sendKeys("CSDN");

        /*显示等待方式2*/
        /*WebElement kw1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kw")));
        kw1.sendKeys("CSDN");*/

        driver.findElement(By.id("su")).click();
    }

    @BeforeAll
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public void afterMethod() {
        driver.quit();
    }

}
