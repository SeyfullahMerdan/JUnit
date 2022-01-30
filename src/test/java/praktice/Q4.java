package praktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Q4 {
     /*
    ...Exercise4...
    https://www.teknosa.com/ adresine gidiniz
    arama cubuguna oppo yazip enter deyiniz
      */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.teknosa.com/");

        driver.manage().deleteAllCookies();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);

        //sonuc sayisini yazdiriniz
        System.out.println( "Çıkan sonuç sayısı: " + driver.findElement(By.className("plp-info")).getText() );

        //cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();

        //sepete ekleyiniz

        JavascriptExecutor js= (JavascriptExecutor) driver;  // Javascript classından çagırdım
        js.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.id("addToCartButton")).click();

        //sepetime git e tiklayiniz
        // driver.findElement(By.className("icon icon-cart")).click();

        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

        //consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        System.out.println( "Sipariş özeti yazısı: "  + driver.findElement(By.className("cart-sum-title")).getText());


        //Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();

        //son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
        System.out.println( "Son sayfa yazısı:" + driver.findElement(By.xpath("(//div[@class='lrl-title'])[1]")).getText() );


        //driver i kapatiniz
        Thread.sleep(3000);
        driver.quit();

    }


}
