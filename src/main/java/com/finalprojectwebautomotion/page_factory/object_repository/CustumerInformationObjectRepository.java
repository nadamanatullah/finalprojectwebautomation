package com.finalprojectwebautomotion.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustumerInformationObjectRepository {
    @FindBy(xpath = "//dd[@data-component='mob-flight-price-total-desc']")
    public WebElement totalPrice;

    public By totalPriceBy = By.xpath("//dd[@data-component='mob-flight-price-total-desc']");

    @FindBy(xpath = "//span[contains(text(), 'AirAsia')]")
    public WebElement airlineName;

    public By airlineNameBy(String airline) {
        return By.xpath("//span[contains(text(), '" + airline + "')]");
    }


    @FindBy(id = "contact.contactFirstName")
    public WebElement contactFirstName;

    public By contactFirstNameBy = By.id("contact.contactFirstName");
    
    @FindBy(id = "contact.contactLastName")
    public WebElement contactLastName;

    @FindBy(id = "contact.contactEmail")
    public WebElement contactEmail;

    @FindBy(id = "contact.contactPhoneNumber")
    public WebElement contactPhone;
}
