package automotion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat; 
//import io.cucumber.messages.types.Duration;

public class BookingFlight {

    WebDriver driver;
    WebDriverWait wait;  

    public static String selectedPrice;

    @BeforeMethod
    public void setUp() throws InterruptedException{

        System.out.println("Set Up Web Driver");
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.agoda.com/");
        Thread.sleep(4000);

    }

    @Test
    public void flightsPage () throws InterruptedException{

        //user is on the Agoda Flights page
        System.out.println("1. User is on the Agoda Flights page");
        driver.findElement(By.xpath("//h6[contains(@class,'Typographystyled') and text()='Flights']")).click();
        Thread.sleep(4000);

        //user selects departure city as "Jakarta"

        System.out.println("2. User selects departure city as Jakarta");
        driver.findElement(By.id("flight-origin-search-input")).sendKeys("Jakarta");
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By optionLocator = By.xpath("//ul[contains(@aria-label,'Flying from')]/li");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        List<WebElement> listOptions = driver.findElements(optionLocator);
        System.out.println("Total Options: " + listOptions.size());

        for (WebElement option : listOptions) {
        System.out.println(option.getText());
        if (option.getText().contains("Soekarno-Hatta")) {
            option.click();
            break;

           }

        }

        //user selects destination city as "Singapore"
        System.out.println("2. User selects departure city as Singapore");
        driver.findElement(By.id("flight-destination-search-input")).sendKeys("Singapore");
        Thread.sleep(2000);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        By optionLocator2 = By.xpath("//ul[contains(@aria-label,'Flying to')]/li");
        wait2.until(ExpectedConditions.visibilityOfElementLocated(optionLocator2));

        List<WebElement> listOptions2 = driver.findElements(optionLocator2);
        System.out.println("Total Options: " + listOptions2.size());

        for (WebElement option : listOptions2) {
        System.out.println(option.getText());
        if (option.getText().contains("Singapore Changi Airport")) {
            option.click();
            break;
           }

        }

        //pilih tanggal

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String tomorrowDateStr = tomorrow.format(formatter);

        
        System.out.println("Mencari tanggal besok: " + tomorrowDateStr);
        String tomorrowXPath = "//span[@data-selenium-date='"+ tomorrowDateStr +"']";

        WebElement tomorrowDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tomorrowXPath)));
        tomorrowDateElement.click();
        System.out.println("Memilih tanggal besok.");

        //Search

        driver.findElement(By.xpath("//button[@data-selenium='searchButton']")).click();
        Thread.sleep(4000);

        //pilih penerbangan air asia

        By airAsiaFilterLocator = By.xpath("//p[text()='AirAsia']");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement filter = wait3.until(ExpectedConditions.elementToBeClickable(airAsiaFilterLocator));
        filter.click();
        Thread.sleep(4000);

        //Pilih harga termurah

        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//div[contains(@class, 'GridItem')][1]//div[@data-testid = 'web-refresh-flights-card']")).click();       
        WebElement priceElement = wait5.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//button[@aria-expanded = 'true']//span[@data-element-name = 'flight-price-breakdown']/div/div[3]/span[2]")));
        selectedPrice = priceElement.getText();
        System.out.println("Harga yang dipilih: " + selectedPrice);
        //priceElement.click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@data-element-name='flight-detail-select-button']")).click();
        Thread.sleep(4000);

        //Verif Harga

        By totalLocator = By.xpath("//dd[@data-component='mob-flight-price-total-desc']");
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement totalElement = wait7.until(ExpectedConditions.visibilityOfElementLocated(totalLocator));
        String checkoutPrice = totalElement.getText().trim();
        System.out.println("Harga di halaman checkout: " + checkoutPrice);
        System.out.println("Harga yang disimpan sebelumnya: " + selectedPrice);  String cleanSelected = selectedPrice.replaceAll("[^0-9]", "");
        String cleanCheckout = checkoutPrice.replaceAll("[^0-9]", "");

        System.out.println("Nilai cleanSelected: " + cleanSelected);
        System.out.println("Nilai cleanCheckout: " + cleanCheckout);

        Assert.assertEquals(cleanCheckout, cleanSelected, "Harga di halaman checkout tidak sama dengan harga yang dipilih!");
        System.out.println("Harga di halaman checkout sesuai dengan harga yang dipilih sebelumnya.");

         
        //Verif maskapai

        String expectedAirline = "Indonesia AirAsia";

        By airlineLocator = By.xpath("//span[contains(text(), 'AirAsia')]");
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement airlineElement = wait4.until(ExpectedConditions.visibilityOfElementLocated(airlineLocator));
        String actualAirline = airlineElement.getText();
        Assert.assertEquals(actualAirline, expectedAirline);
        System.out.println("Verifikasi Berhasil: Maskapai adalah " + actualAirline);
        Thread.sleep(4000);


        //Input Contact Detail

        By firstNameLocator = By.id("contact.contactFirstName");
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait6.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator));

        driver.findElement(By.id("contact.contactFirstName")).sendKeys("Nada");
        driver.findElement(By.id("contact.contactLastName")).sendKeys("Amanatullah");
        driver.findElement(By.id("contact.contactEmail")).sendKeys("nadamanatullah2@gmail.com");
        driver.findElement(By.id("contact.contactPhoneNumber")).sendKeys("08121324355");
    }

     @AfterMethod
    public void tearDown()throws InterruptedException{
        System.out.println("After Method");
        Thread.sleep(4000);
        if(driver != null){
            driver.quit();
        }

    }


}
