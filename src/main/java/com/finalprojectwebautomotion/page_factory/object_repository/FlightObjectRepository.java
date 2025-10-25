package com.finalprojectwebautomotion.page_factory.object_repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightObjectRepository {
     @FindBy(xpath = "//p[text()='AirAsia']")
    public WebElement airAsiaFilter;

    @FindBy(xpath = "//div[contains(@class, 'GridItem')][1]//div[@data-testid = 'web-refresh-flights-card']")
    public WebElement firstFlightCard;

    @FindBy(xpath = "//button[@aria-expanded = 'true']//span[@data-element-name = 'flight-price-breakdown']/div/div[3]/span[2]")
    public WebElement priceElement;

    @FindBy(xpath = "//button[@data-element-name='flight-detail-select-button']")
    public WebElement selectFlightButton;

}
