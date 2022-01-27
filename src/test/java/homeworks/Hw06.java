package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Hw06 {
    // /*
    //...Exercise2...
    //   http://www.bestbuy.com 'a gidin,
    //   Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    //   Ayrica Relative Locator kullanarak;
    //       logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
    //       mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
    //
    //*/

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Before
    public void beforeTest() {
        driver.get("http://www.bestbuy.com");
    }



    @Test
    public void titletest(){
        String title=driver.getTitle();
        boolean isThere=title.contains("Best");
        Assert.assertTrue("Title Best test FAİLED", isThere);
    }


    @Test
    public void logoTest() {
        WebElement heading=driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement logo=driver.findElement(RelativeLocator.with(By.tagName("img")).above(heading));
        boolean isDisplayed=logo.isDisplayed();
        Assert.assertTrue(isDisplayed);
    }


    @Test
    public void linkTest(){
      WebElement usLink=driver.findElement(By.xpath("(//a[@class='us-link'])[1]"));
      WebElement horizontal=driver.findElement(By.xpath("(//div[@class='horizontal-rule'])[1]"));
      WebElement mexLink=driver.findElement(RelativeLocator.with(By.tagName("a")).toRightOf(usLink).above(horizontal));
      boolean isDisplayed=mexLink.isDisplayed();
      Assert.assertTrue(isDisplayed);
    }




    @After
    public void tearDown() {
        // driver.close();
    }






}
