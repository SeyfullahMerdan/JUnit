package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class C01_TekrarTesti {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //2- https://www.google.com/ adresine gidin

        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin

        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();

        //4-Sayfa basliginin “Google” ifadesi icerdigini test edin

        String actualTitle=driver.getTitle();
        String arananKelime="Google";

        System.out.println(actualTitle.contains(arananKelime) ? "Test PASS" : "Test FAİLED" );


        //5- Arama cubuguna “Nutella” yazip aratin

        WebElement searchBox=driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        //6-Bulunan sonuc sayisini yazdirin

        WebElement resultElement=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(resultElement.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        String resultElementString=resultElement.getText();
       // String resultWord[]=resultElementString.split(" ");
       // System.out.println(Arrays.toString(resultWord));

        resultElementString = (resultElementString.substring(9,19));

       /*
        String resultNutellaNumber=resultWord[1];
        resultNutellaNumber=resultNutellaNumber.replace(".","");
        System.out.println(resultNutellaNumber);

        int nutellaSearchResult=Integer.parseInt(resultNutellaNumber);

        System.out.println(nutellaSearchResult>10000000 ? "Nutella search test PASS" : "Nutella search test FAİLED");

        //8-Sayfayi kapatin */









    }
}
