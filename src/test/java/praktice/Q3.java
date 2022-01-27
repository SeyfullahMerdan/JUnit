package praktice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    ///*
    //     ...Exercise3...
    //    // http://the-internet.herokuapp.com/add_remove_elements/
    //    // click on the "Add Element" button 100 times
    //    // write a function that takes a number, and clicks the "Delete" button
    //    // given number of times, and then validates that given number of
    //    // buttons was deleted
    // */



    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }






    public void addElement(){




    }



    public void tearDown() {

       // driver.close();

    }






}
