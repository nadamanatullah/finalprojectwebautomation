package com.finalprojectwebautomotion.page_factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.finalprojectwebautomotion.base.BasePage;
import com.finalprojectwebautomotion.page_factory.object_repository.CustumerInformationObjectRepository;

public class CustomerInformationPage extends BasePage{
    CustumerInformationObjectRepository customerInformationPage;

    public CustomerInformationPage(WebDriver driver) {
        super(driver);
        customerInformationPage = new CustumerInformationObjectRepository();
        PageFactory.initElements(driver, customerInformationPage);
    }

    public String getCheckoutPrice() {
        return wait.until(ExpectedConditions.visibilityOf(customerInformationPage.totalPrice)).getText().trim();
    }

    public String getAirlineName() {
        return wait.until(ExpectedConditions.visibilityOf(customerInformationPage.airlineName)).getText();
    }

    public void fillContactDetails() {
        wait.until(ExpectedConditions.visibilityOf(customerInformationPage.contactFirstName));
        customerInformationPage.contactFirstName.sendKeys("Nada");
        customerInformationPage.contactLastName.sendKeys("Amanatullah");
        customerInformationPage.contactEmail.sendKeys("nadamanatullah2@gmail.com");
        customerInformationPage.contactPhone.sendKeys("08121324355");
    }
}
