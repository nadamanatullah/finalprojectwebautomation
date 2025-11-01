package com.finalprojectwebautomotion.page_factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.finalprojectwebautomotion.abstractcomponents.AbstractComponent;
import com.finalprojectwebautomotion.page_factory.object_repository.CustumerInformationObjectRepository;

public class CustomerInformationPage extends AbstractComponent{
    CustumerInformationObjectRepository customerInformationPage;
    private WebDriver driver;

    public CustomerInformationPage(WebDriver driver) {
        super(driver);
        customerInformationPage = new CustumerInformationObjectRepository();
        PageFactory.initElements(driver, customerInformationPage);
    }

    public String getCheckoutPrice() {
        /*
         * Untuk wait element visibility bisa pakai yang dari AbstractComponent ya
         * 
         */
        visibilityElement(customerInformationPage.totalPriceBy);
        return customerInformationPage.totalPrice.getText();
    }

    /*
     * Untuk get airline name juga sama, pakai visibilityElement dari AbstractComponent
     * Bisa juga function nya diubah supaya bisa terima parameter nama airline yang diinginkan supaya lebih fleksibel
     */
    // public String getAirlineName() {
    //     visibilityElement(null);
    //     return wait.until(ExpectedConditions.visibilityOf(customerInformationPage.airlineName)).getText();
    // }

    public String getAirlineName(String airline) {
        visibilityElement(customerInformationPage.airlineNameBy(airline)); // wait untuk visibility element berdasarkan airline yang diinginkan
        return driver.findElement(customerInformationPage.airlineNameBy(airline)).getText();
    }



    /*
     * Ini better function nya diisi dynamic data dari parameter ya, biar bisa
     * dipake buat testing negative juga, dan data yang lainnya juga
     */

    public void fillContactDetailsWithParams(String firstName, String lastName, String email, String phone) {
        // wait.until(ExpectedConditions.visibilityOf(customerInformationPage.contactFirstName));
        visibilityElement(customerInformationPage.contactFirstNameBy); // wait untuk visibility element contact first name dan import dari abstract component
        customerInformationPage.contactFirstName.sendKeys(firstName);
        customerInformationPage.contactLastName.sendKeys(lastName);
        customerInformationPage.contactEmail.sendKeys(email);
        customerInformationPage.contactPhone.sendKeys(phone);
    }

    public void fillContactDetails() {
        visibilityElement(customerInformationPage.contactFirstNameBy);
        customerInformationPage.contactFirstName.sendKeys("Nada");
        customerInformationPage.contactLastName.sendKeys("Amanatullah");
        customerInformationPage.contactEmail.sendKeys("nadamanatullah2@gmail.com");
        customerInformationPage.contactPhone.sendKeys("08121324355");
    }
}
