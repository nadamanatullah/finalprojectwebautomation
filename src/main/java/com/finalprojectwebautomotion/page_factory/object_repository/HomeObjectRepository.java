package com.finalprojectwebautomotion.page_factory.object_repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeObjectRepository {
     @FindBy(xpath = "//h6[contains(@class,'Typographystyled') and text()='Flights']")
    public WebElement flightsTab;

    @FindBy(id = "flight-origin-search-input")
    public WebElement originInput;

    @FindBy(id = "flight-destination-search-input")
    public WebElement destinationInput;

    @FindBy(xpath = "//button[@data-selenium='searchButton']")
    public WebElement searchButton;

}
