import com.sun.org.apache.xml.internal.security.Init;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private ChromeDriver chromeDriver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver","D:\\IDEA_workspace_home\\Software_testing\\SimpleHotel\\useSelenium\\src\\main\\resources\\chromedriver.exe");
        chromeDriver = new ChromeDriver();

    }
    @Test
    public void test() throws InterruptedException {
        chromeDriver.get("http://baidu.com");
        System.out.println("Home page title:" + chromeDriver.getTitle());
        //使用assertEquals方法
        Assert.assertEquals("百度一下，你就知道",chromeDriver.getTitle());
        //通过标签的id获取
        WebElement kw = chromeDriver.findElement(By.id("kw"));
        kw.sendKeys("软件测试");
        kw.submit();
        Thread.sleep(3000);
        //通过链接的文字获取
        WebElement photo = chromeDriver.findElement(By.linkText("图片"));
        photo.click();
        Thread.sleep(3000);

    }
    @After
    public void after() {
        chromeDriver.quit();
    }
}
