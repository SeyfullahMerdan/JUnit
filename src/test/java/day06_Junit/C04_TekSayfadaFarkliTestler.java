package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {

    static WebDriver driver;
    static WebElement aramaKutusu;
    static WebElement sonucYazisiElementi;


    @Test
    public void test01(){
        // amazon sayfasında nutella için arama yapıp sonuç yazısnın nutella içerdigini test edelim

        aramaKutusu.sendKeys("nutella" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualNutellaResult=sonucYazisiElementi.getText();
        String searchWord="nutella";
        System.out.println(actualNutellaResult.contains(searchWord)? "Nutella test PASS" : "Nutella test FAİLED");
    }


    @Test
    public void test02(){
        // amazon sayfasında java için arama yapıp sonuç yazısnın java içerdigini test edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();

        aramaKutusu.sendKeys("java" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualJavaResult=sonucYazisiElementi.getText();
        String searchWord="java";
        System.out.println(actualJavaResult.contains(searchWord)? "Java test PASS" : "Java test FAİLED");
    }





    @Test
    public void test03(){
        // amazonda ali için arama yapıp sonuç yazısnın ali içerdigini test edelim
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();

        aramaKutusu.sendKeys("ali" + Keys.ENTER);
        sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualJavaResult=sonucYazisiElementi.getText();
        String searchWord="ali";
        System.out.println(actualJavaResult.contains(searchWord)? "Ali test PASS" : "Ali test FAİLED");

    }




    @BeforeClass
    public static void ayarlariDuzenle() {
        // driverları koyup buradan çagırırım. Her seferinde yazmak yerine, methodla çagırırım
        // tek bir defa yazarak her seferinde kullanırım.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

    }


    @AfterClass
    public static void ortaligiTopla(){
        driver.close();
    }




}
