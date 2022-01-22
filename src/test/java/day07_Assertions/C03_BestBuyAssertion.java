package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertion {

    // 1)Bir class oluşturun: BestBuyAssertions
    // 2)https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    // logoTest => BestBuy logosunun görüntülendigini test edin
    // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebDriver driver;
    @Before
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void test01(){

        // 2)https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

        driver.get("https://www.bestbuy.com/");


        // Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";

        Assert.assertEquals( "Lütfen test değerlerini gözden geçiriniz." ,expectedUrl,actualUrl);


        // titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String actualTitle=driver.getTitle();
        String istenmeyenKelime="Rest";

        Assert.assertFalse( "İstenmeyen kelimeyi içermemektedir."  , actualTitle.contains(istenmeyenKelime));
        System.out.println("Bu satır çalışmaz. Yukarıda false alınca orada kod çalışmayı durdurur");

        // logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue("logo görünmüyor" , logoElementi.isDisplayed());


        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francais= driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francais.isDisplayed());

    }


    @After
    public void teardown() {

        // driver.close();

    }












}


