// package automotion;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.NoSuchElementException;

// import org.openqa.selenium.By;
// import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.Test;

// import com.finalprojectwebautomotion.page_factory.pages.CustomerInformationPage;
// import com.finalprojectwebautomotion.page_factory.pages.FlightPage;
// import com.finalprojectwebautomotion.page_factory.pages.HomePage;

// import java.time.Duration;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.text.DecimalFormat; 
// //import io.cucumber.messages.types.Duration;

// public class BookingFlight {

//     WebDriver driver;
//     HomePage homePage;
//     FlightPage flightPage;
//     CustomerInformationPage customerPage;

//       public static String selectedPrice;

//     @BeforeMethod
//     public void setUp() throws InterruptedException {
//         System.out.println("Set Up Web Driver");
//         System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");

//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         driver.manage().deleteAllCookies();
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         driver.get("https://www.agoda.com/");
//         Thread.sleep(4000);

//         // Inisialisasi semua page object
//         homePage = new HomePage(driver);
//         flightPage = new FlightPage(driver);
//         customerPage = new CustomerInformationPage(driver);
//     }

//     @Test
//     public void flightsPage() throws InterruptedException {
//         System.out.println("=== TEST: Booking Flight from Jakarta to Singapore ===");

//         // STEP 1: User is on the Agoda Flights page
//         homePage.openFlightsPage();

//         // STEP 2: User selects departure city as "Jakarta"
//         homePage.selectDepartureCity();

//         // STEP 3: User selects destination city as "Singapore"
//         homePage.selectDestinationCity();

//         // STEP 4: Pilih tanggal besok
//         homePage.selectTomorrowDate();

//         // STEP 5: Klik tombol Search
//         homePage.clickSearch();
//         Thread.sleep(4000);

//         // STEP 6: Pilih penerbangan AirAsia
//         flightPage.filterAirAsia();

//         // STEP 7: Pilih harga termurah
//         flightPage.selectCheapestFlight();
//         selectedPrice = flightPage.getSelectedPrice();
//         Thread.sleep(4000);

//         // STEP 8: Verifikasi Harga di Checkout
//         String checkoutPrice = customerPage.getCheckoutPrice();
//         System.out.println("Harga di halaman checkout: " + checkoutPrice);
//         System.out.println("Harga yang disimpan sebelumnya: " + selectedPrice);

//         String cleanSelected = selectedPrice.replaceAll("[^0-9]", "");
//         String cleanCheckout = checkoutPrice.replaceAll("[^0-9]", "");

//         System.out.println("Nilai cleanSelected: " + cleanSelected);
//         System.out.println("Nilai cleanCheckout: " + cleanCheckout);

//         Assert.assertEquals(cleanCheckout, cleanSelected, 
//             "Harga di halaman checkout tidak sama dengan harga yang dipilih!");
//         System.out.println("Harga checkout sesuai dengan harga yang dipilih.");

//         // STEP 9: Verifikasi Maskapai
//         String expectedAirline = "Indonesia AirAsia";
//         String actualAirline = customerPage.getAirlineName();
//         Assert.assertEquals(actualAirline, expectedAirline, 
//             "Maskapai tidak sesuai!");
//         System.out.println("Maskapai sesuai: " + actualAirline);

//         // STEP 10: Isi Contact Detail
//         customerPage.fillContactDetails();
//         System.out.println("Berhasil mengisi contact detail.");
//     }

//      @AfterMethod
//     public void tearDown()throws InterruptedException{
//         System.out.println("After Method");
//         Thread.sleep(4000);
//         if(driver != null){
//             driver.quit();
//         }

//     }


// }
