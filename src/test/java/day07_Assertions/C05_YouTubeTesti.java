package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YouTubeTesti {

    // 1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //  titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    static public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//yt-formatted-string[text()='Kabul ediyorum']")).click();
    }

    @Test
    public void titleTesti(){

        //  titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertEquals("Sayfa başlıgı YouTube degildir." ,expectedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        //  imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
       WebElement img=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
       Assert.assertTrue( img.isDisplayed() );
    }

    @Test
    public void searchBoxTest(){
        //  Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
       //  wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle2 = driver.getTitle();
        String expectedWrongTitle="youtube";
        // Assert.assertNotEquals("Sayfa başlıgı youtube degildir." ,expectedTitle,actualTitle2);
        Assert.assertFalse( expectedWrongTitle.equals(actualTitle2) );

    }



    @AfterClass
    static public void s(){

        driver.close();

    }



}
