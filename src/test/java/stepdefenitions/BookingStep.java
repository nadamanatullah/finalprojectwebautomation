package stepdefenitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.finalprojectwebautomotion.page_factory.pages.CustomerInformationPage;
import com.finalprojectwebautomotion.page_factory.pages.FlightPage;
import com.finalprojectwebautomotion.page_factory.pages.HomePage;

import hook.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingStep {
    WebDriver driver;
    HomePage homePage;
    FlightPage flightPage;
    CustomerInformationPage customerPage;
    String selectedPrice, checkoutPrice;

    @Given("user is on the Agoda Flights page")
    public void user_is_on_agoda_flights_page() throws InterruptedException {
        driver = Hooks.getDriver(); 
        driver.get("https://www.agoda.com/");
        Thread.sleep(4000);

        homePage = new HomePage(driver);
        flightPage = new FlightPage(driver);
        customerPage = new CustomerInformationPage(driver);

        homePage.openFlightsPage();
    }
    @When("user selects departure city as {string}")
    public void user_selects_departure_city(String city) throws InterruptedException {
        homePage.selectDepartureCity();
    }

    @And("user selects destination city as {string}")
    public void user_selects_destination_city(String city) throws InterruptedException {
        homePage.selectDestinationCity();
    }

    @And("user selects tomorrow date")
    public void user_selects_tomorrow_date() {
        homePage.selectTomorrowDate();
    }

    @And("user clicks Search")
    public void user_clicks_search() {
        homePage.clickSearch();
    }

    @Then("user filters AirAsia flight")
    public void user_filters_airasia_flight() throws InterruptedException {
        flightPage.filterAirAsia();
    }

    @And("user selects the cheapest flight")
    public void user_selects_cheapest_flight() throws InterruptedException {
        flightPage.selectCheapestFlight();
        selectedPrice = flightPage.getSelectedPrice();
    }

    @Then("verify selected price matches checkout price")
    public void verify_selected_price_matches_checkout_price() {
        checkoutPrice = customerPage.getCheckoutPrice();
        String cleanSelected = selectedPrice.replaceAll("[^0-9]", "");
        String cleanCheckout = checkoutPrice.replaceAll("[^0-9]", "");

        Assert.assertEquals(cleanCheckout, cleanSelected, 
            "Harga di halaman checkout tidak sama dengan harga yang dipilih!");
        System.out.println("Harga sesuai antara hasil dan checkout.");
    }

    @And("verify airline is {string}")
    public void verify_airline_is(String expectedAirline) {
        String actualAirline = customerPage.getAirlineName();
        System.out.println("Maskapai sesuai: " + actualAirline);
        Assert.assertEquals(actualAirline, expectedAirline);
        System.out.println("Maskapai sesuai: " + actualAirline);
    }

    @Then("user fills contact details")
    public void user_fills_contact_details() {
        customerPage.fillContactDetails();
        System.out.println("Berhasil mengisi contact detail.");
        
    }
}
