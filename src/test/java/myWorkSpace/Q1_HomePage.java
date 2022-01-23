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

public class Q1_HomePage {

    // 1) Open the browser
    //2) Enter the URL “http://practice.automationtesting.in/”
    //3) Click on Shop Menu
    //4) Now click on Home menu button
    //5) Test whether the Home page has Three Sliders only
    //6) The Home page must contains only three sliders


   static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://practice.automationtesting.in/");
    }

@Test
    public void slidersTest() {
     //3) Click on Shop Menu
    driver.findElement(By.xpath("//a[text()='Shop']")).click();

    //4) Now click on Home menu button
    driver.findElement(By.xpath("(//a[@href='http://practice.automationtesting.in'])[2]")).click();

    //5) Test whether the Home page has Three Sliders only
    //6) The Home page must contains only three sliders

    int expectedSliders=3;
    int actualSliders;

    List<WebElement>sliders= driver.findElements(By.className("row_inner_wrapper"));
    actualSliders=sliders.size();

    Assert.assertTrue(expectedSliders==actualSliders);

    }



@AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }



}
