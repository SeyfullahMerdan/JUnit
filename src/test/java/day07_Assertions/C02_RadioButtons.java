package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButtons {
// https://www.facebook.com adresine gidin
//Cookies’i kabul edin
//“Create an Account” button’una basin
//“radio buttons” elementlerini locate edin
//Secili degilse cinsiyet butonundan size uygun olani secin

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[text()='Tüm Çerezlere İzin Ver']")).click();
        driver.findElement(By.xpath("//a[text()='Yeni Hesap Oluştur']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
    }



    @After
    public void teardown() {
        driver.close();
    }



}
