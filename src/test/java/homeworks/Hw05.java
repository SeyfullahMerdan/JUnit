package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// //● https://www.amazon.com/ adresine gidin.
////            - Test 1
////    Arama kutusunun yanindaki kategori menusundeki kategori
////    sayisinin 45 oldugunu test edin
////             -Test 2
////1. Kategori menusunden Books secenegini secin
////2. Arama kutusuna Java yazin ve aratin
////3. Bulunan sonuc sayisini yazdirin
////4. Sonucun Java kelimesini icerdigini test edin


public class Hw05 {

    static WebDriver driver;

    @Test
    public void Test1(){

       List<WebElement>kategori=driver.findElements(By.xpath("//option"));
       //System.out.println(kategori.size());
       int expectedResult=45;
       System.out.println(expectedResult==kategori.size() ? "Test PASS" : "Test FAİLED" );
    }


    @Test
    public void Test2(){

        driver.findElement(By.xpath("//option[@value='search-alias=stripbooks-intl-ship']")).click();
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java" + Keys.ENTER);

        WebElement result=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        String resultString=result.getText();


        String[] resultTextArr=resultString.split(" ");
        String resultText=resultTextArr[3];
        resultText=resultText.replaceAll("\\D" , "");
        System.out.println("Amazon java araması bulunan sonuç: " + resultText ) ;


        String expectedWord="java";
        System.out.println(resultString.contains(expectedWord) ? "Java içeriyor PASS" : "Java içeriyor FAİLED" );


    }



    @BeforeClass
    public static void settings(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }



    @AfterClass
    public static void close() throws InterruptedException {
       Thread.sleep(2000);
       driver.close();
    }




}
