package com.finalprojectwebautomotion.page_factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.finalprojectwebautomotion.abstractcomponents.AbstractComponent;
import com.finalprojectwebautomotion.page_factory.object_repository.FlightObjectRepository;

public class FlightPage extends AbstractComponent {

    FlightObjectRepository flightObjectRepository;
    public static String selectedPrice;

    public FlightPage(WebDriver driver) {
        super(driver);
        flightObjectRepository = new FlightObjectRepository();
        PageFactory.initElements(driver, flightObjectRepository);
    }

    /*
     * Untuk filter flight bisa dibuat dynamic dengan parameter airline name supaya
     * bisa dipakai untuk airline lain juga ya karena sekarang masih hardcode AirAsia
     * contoh implementasinya 
     * public void filterByAirline(String airlineName) throws InterruptedException {
     *     By airlineFilterBy = By.xpath("//p[text()='" + airlineName + "']");
     *     clickAbleElement(airlineFilterBy);
     *     Thread.sleep(3000); // karena sudah ada wait di abstract component, jadi ini bisa dihapus kalau mau lebih optimal
     * }
     */
    public void filterAirAsia() throws InterruptedException {
        // wait.until(ExpectedConditions.elementToBeClickable(flightObjectRepository.airAsiaFilter)).click(); // Ini bisa implement seperti yang di abstract component
        clickAbleElement(flightObjectRepository.airAsiaFilterBy);
        Thread.sleep(3000); // karena sudah ada wait di abstract component, jadi ini bisa dihapus kalau mau lebih optimal
    }



    public void selectCheapestFlight() throws InterruptedException {
        flightObjectRepository.firstFlightCard.click();

        visibilityElement(flightObjectRepository.priceElementBy);;
        // WebElement priceEl = wait.until(ExpectedConditions.visibilityOf(flightObjectRepository.priceElement));
        selectedPrice = flightObjectRepository.priceElement.getText();
        System.out.println("Harga yang dipilih: " + selectedPrice);
        Thread.sleep(3000); //
        flightObjectRepository.selectFlightButton.click();
    }

    /*
     * Function ini dipakai dimana?  Kalau tidak dipakai bisa dihapus saja ya
     * kalau pengen buat dapat selected price, bisa pake static variable diatas
     * atau bisa juga return value dari function selectCheapestFlight
     * 
     *Kalau hanya return selectedPrice, bisa saja seperti ini:
     * public String selectCheapestFlight() throws InterruptedException {
     *     ...
     *     return selectedPrice;
     * }
     */
    public String getSelectedPrice() {
        return selectedPrice;
    }
}
