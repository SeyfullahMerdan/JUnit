package praktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q3 {
    /*
        ...Exercise3...
        http://the-internet.herokuapp.com/add_remove_elements/
       click on the "Add Element" button 100 times
       write a function that takes a number, and clicks the "Delete" button
       given number of times, and then validates that given number of
        buttons was deleted
     */


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createButtons(driver,100);
        deleteButtons(driver,60);

    }



    private static void createButtons(WebDriver driver, int eklenecekSayi) {

        WebElement button=driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i=1; i<= eklenecekSayi ;i++) {
            button.click();
        }

    }



    private static void deleteButtons(WebDriver driver, int silinecekSayi) {

       List<WebElement> elementList=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
       int sizeBefore=elementList.size();

        List<WebElement> elementListDelete=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sayac=0;


        for (WebElement w:elementListDelete) {
            sayac++;
            if (sayac>silinecekSayi) {
                break;
            }
            w.click();
        }

        List<WebElement> elementListAfter=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeAfter=elementListAfter.size();

        if (sizeBefore-silinecekSayi==sizeAfter) {
            System.out.println( "Size after delete: " + sizeAfter  );
            System.out.println( "SUCCESS !" );
        } else {
            System.out.println( "FAİLED !" );
        }



    }


}
