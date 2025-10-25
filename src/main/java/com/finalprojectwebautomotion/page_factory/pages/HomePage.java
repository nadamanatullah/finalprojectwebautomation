package com.finalprojectwebautomotion.page_factory.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.finalprojectwebautomotion.page_factory.base.BasePage;
import com.finalprojectwebautomotion.page_factory.object_repository.HomeObjectRepository;

public class HomePage extends BasePage {
      HomeObjectRepository homeObjectRepository;

    public HomePage(WebDriver driver) {
        super(driver);
        homeObjectRepository = new HomeObjectRepository();
        PageFactory.initElements(driver, homeObjectRepository);
    }

    public void openFlightsPage() throws InterruptedException {
        homeObjectRepository.flightsTab.click();
        Thread.sleep(3000);
    }

    public void selectDepartureCity() throws InterruptedException {
        homeObjectRepository.originInput.sendKeys("Jakarta");
        Thread.sleep(2000);

        By optionLocator = By.xpath("//ul[contains(@aria-label,'Flying from')]/li");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        List<WebElement> listOptions = driver.findElements(optionLocator);
        for (WebElement option : listOptions) {
            if (option.getText().contains("Soekarno-Hatta")) {
                option.click();
                break;
            }
        }
    }

    public void selectDestinationCity() throws InterruptedException {
        homeObjectRepository.destinationInput.sendKeys("Singapore");
        Thread.sleep(2000);

        By optionLocator = By.xpath("//ul[contains(@aria-label,'Flying to')]/li");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        List<WebElement> listOptions = driver.findElements(optionLocator);
        for (WebElement option : listOptions) {
            if (option.getText().contains("Singapore Changi Airport")) {
                option.click();
                break;
            }
        }
    }

    public void selectTomorrowDate() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        String tomorrowDateStr = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String tomorrowXPath = "//span[@data-selenium-date='" + tomorrowDateStr + "']";
        WebElement tomorrowDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tomorrowXPath)));
        tomorrowDateElement.click();
    }

    public void clickSearch() {
        homeObjectRepository.searchButton.click();
    }
   
}
