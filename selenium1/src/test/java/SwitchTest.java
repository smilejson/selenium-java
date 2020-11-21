import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchTest {

    static  WebDriver driver;
    @BeforeAll
    public static void before(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterAll
    public static void after(){
        driver.quit();
    }
    @Test
    public void switchTest(){
        driver.get("https://www.baidu.com");
        /*点击登录按钮*/
        driver.findElement(By.xpath("")).click();
        //获取百度首页句柄
        String baiduWin=driver.getWindowHandle();
        //点击注册，点击注册后会进入新页面，所以需要先获取句柄
        driver.findElement(By.xpath("")).click();
        //获取全部句柄
        Set<String> windowHandles = driver.getWindowHandles();
        for (String win:windowHandles){
            if (!win.equals(baiduWin)){
                //进行注册操作
                //注册完成切换到百度首页
                driver.switchTo().window(baiduWin);
                //进行登录操作

            }
        }
    }
}
