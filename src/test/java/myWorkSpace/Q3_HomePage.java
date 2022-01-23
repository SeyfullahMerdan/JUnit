package myWorkSpace;

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
import java.util.List;

public class Q3_HomePage {

    // 1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Arrivals only
    //6) The Home page must contains only three Arrivals
    //7) Now click the image in the Arrivals
    //8) Test whether it is navigating to next page where the user can add that book into his basket.
    //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket

    static WebDriver driver;

    @BeforeClass
     public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://practice.automationtesting.in/");
     }


     @Test
     public void arrivalsTest() {
         //3) Click on Shop Menu
         driver.findElement(By.xpath("//a[text()='Shop']")).click();

         //4) Now click on Home menu button
         driver.findElement(By.xpath("(//a[@href='http://practice.automationtesting.in'])[2]")).click();

         //5) Test whether the Home page has Three Arrivals only
         //6) The Home page must contains only three Arrivals
         List<WebElement> arrivals=driver.findElements(By.cssSelector(".woocommerce-LoopProduct-link"));
         int expectedArrival=3;
         int actualArrival= arrivals.size();
         Assert.assertTrue(expectedArrival==actualArrival);

         //7) Now click the image in the Arrivals
         driver.findElement(By.xpath("(//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image'])[1]")).click();


         //8) Test whether it is navigating to next page where the user can add that book into his basket.
         //9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
             // navigate to next page
         WebElement nextPage=driver.findElement(By.xpath("//div[@itemprop='description']"));
         Assert.assertTrue(nextPage.isEnabled());

         //10) click basket button
         WebElement basketButton=driver.findElement(By.xpath("//button[@type='submit']"));
         basketButton.click();

         //11) "Selenium Ruby” has been added to your basket should be disable
         WebElement text= driver.findElement(By.xpath("//a[@class='button wc-forward']"));
         Assert.assertTrue(text.isDisplayed());
     }



    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2500);
        //driver.quit();
    }





}
