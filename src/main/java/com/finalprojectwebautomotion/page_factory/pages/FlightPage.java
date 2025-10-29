package com.finalprojectwebautomotion.page_factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.finalprojectwebautomotion.base.BasePage;
import com.finalprojectwebautomotion.page_factory.object_repository.FlightObjectRepository;

public class FlightPage extends BasePage {

     FlightObjectRepository flightObjectRepository;
    public static String selectedPrice;

    public FlightPage(WebDriver driver) {
        super(driver);
        flightObjectRepository = new FlightObjectRepository();
        PageFactory.initElements(driver, flightObjectRepository);
    }

    public void filterAirAsia() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(flightObjectRepository.airAsiaFilter)).click();
        Thread.sleep(3000);
    }

    public void selectCheapestFlight() throws InterruptedException {
        flightObjectRepository.firstFlightCard.click();
        WebElement priceEl = wait.until(ExpectedConditions.visibilityOf(flightObjectRepository.priceElement));
        selectedPrice = priceEl.getText();
        System.out.println("Harga yang dipilih: " + selectedPrice);
        Thread.sleep(3000);
        flightObjectRepository.selectFlightButton.click();
    }

    public String getSelectedPrice() {
        return selectedPrice;
    }
}
