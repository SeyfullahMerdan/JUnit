package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestler {

    static WebDriver driver;


    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        // 2)https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");
    }



    @Test
    public void urlTesti() {
        // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.bestbuy.com/";
        Assert.assertEquals("Lütfen test değerlerini gözden geçiriniz.", expectedUrl, actualUrl);
    }


    @Test
    public void titleTesti() {
        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle = driver.getTitle();
        String istenmeyenKelime = "Rest";
        Assert.assertFalse("İstenmeyen kelimeyi içermektedir.", actualTitle.contains(istenmeyenKelime));
        System.out.println("Bu satır çalışmaz. Yukarıda false alınca orada kod çalışmayı durdurur");
    }


    @Test
    public void logoTesti() {
        // logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("logo görünmüyor", logoElementi.isDisplayed());
    }


    @Test
    public void linkTesti() {
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francais= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francais.isDisplayed());
    }



    @AfterClass
    public static void teardown() {
       driver.close();
    }



}
