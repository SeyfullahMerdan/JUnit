package praktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q5 {
     /*  ...Exercise5...
     @BeforeClass ın icerisinde driver i kuralim
     maximize edip tum web elementler yuklenene kadar 10 sn bekletelim
     Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim
     Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim
     @AfterClass ta driver ı kapatalim
      */

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void googleTest() {
       // Google 'a gidelim ve sayfa basliginin Google icerdigini dogrulayalim.
    driver.get("https://www.google.com/");
    String title=driver.getTitle();
    Assert.assertTrue("Google Title test FAİLED!",title.contains("Google"));

    }

    @Test
    public void amazonTest() {
      // Amazon'a gidelim ve url in www.amazon.com icerip icermedigini dogrulayalim.
        driver.get("https://www.amazon.com/");
        String url=driver.getCurrentUrl();
        Assert.assertTrue("Amazon URL test FAİLED!",url.contains("www.amazon.com"));
    }


}
