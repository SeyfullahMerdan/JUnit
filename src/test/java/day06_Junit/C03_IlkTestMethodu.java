package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_IlkTestMethodu {

    WebDriver driver;

    @Test
    public void test01(){
       // Amazon.com gidelim ve title'ın amazon içerdigini test edelim.

        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        String searchWord="amazon";
        System.out.println(actualTitle.contains(searchWord) ? "Amazon test PASS" : "Amazon test FAİLED");

    }

    @Test
    public void test02(){
        // Google'a gidelim ve title'ın "google" içerdigini test edelim.

        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();
        String actualTitle = driver.getTitle();
        String searchWord="google";
        System.out.println(actualTitle.contains(searchWord) ? "Google test PASS" : "Google test FAİLED");

    }

    @Before
    public void ayarlariDuzenle(){
        // driverları koyup buradan çagırırım. Her seferinde yazmak yerine, methodla çagırırım
        // tek bir defa yazarak her seferinde kullanırım.
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @After
    public void ortaligiTopla(){

        driver.close();


    }




}
