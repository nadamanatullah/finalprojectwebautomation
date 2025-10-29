package hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;

public class Hooks {
    
     private static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("===== [Before Scenario] Inisialisasi WebDriver =====");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        System.out.println("===== [After Scenario] Menutup WebDriver =====");
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
