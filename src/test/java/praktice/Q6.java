package praktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Q6 {
      /*   ...Exercise6...

     1. Amazon.com'a gidelim.
     2. DropDown üzerinde Books secelim.(All yazan yerde)
         kategorilerin hepsini konsola yazdiralim
     3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
     4. Sonuc sayisini ekrana yazdiralim.
     5. Sonucların Les Miserables i icerdigini assert edelim
    */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.quit();
    }


    @Test
    public void amazonDropdown(){

        driver.get("https://www.amazon.com/");

        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdown);

        // Kategorilerin hepsini konsola yazdiralim..
        List<WebElement> dropdownAll=select.getOptions();
        int sayac=1;


        for (WebElement e:dropdownAll
             ) {
            System.out.println( sayac + "'inci dropdown: " + e.getText() + " ");
        sayac++;
        }


       // DropDown üzerinden Books secelim..
        select.selectByValue("search-alias=stripbooks-intl-ship");

        // Arama kutusuna Les Miserables yazalım ve arama yapalim.
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Les Miserables" + Keys.ENTER);

        // Sonuc sayisini ekrana yazdiralim.
        // Sonucların Les Miserables i icerdigini assert edelim.

        WebElement resultText=driver.findElement(By.xpath("//span[.='1-16 of over 5,000 results for']"));
        String result=resultText.getText();
        String resultArr[]=result.split(" ");
        String textResult=resultArr[3];
        System.out.println( "Bulunan sonuç sayısı: " + textResult );

        String actualContain=driver.getTitle();
        String expectedContain="Les Miserables";
        Assert.assertTrue("Actual Page doesnt content 'Les Miserables'",actualContain.contains(expectedContain));



    }


}
