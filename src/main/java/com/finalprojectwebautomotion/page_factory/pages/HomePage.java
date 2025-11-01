package com.finalprojectwebautomotion.page_factory.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.finalprojectwebautomotion.base.BasePage;
import com.finalprojectwebautomotion.page_factory.object_repository.HomeObjectRepository;
import com.finalprojectwebautomotion.utils.Utility;

public class HomePage extends BasePage {
      HomeObjectRepository homeObjectRepository;

    public HomePage(WebDriver driver) {
        super(driver);
        homeObjectRepository = new HomeObjectRepository();
        PageFactory.initElements(driver, homeObjectRepository);
    }

    public void openFlightsPage() throws InterruptedException {
        homeObjectRepository.flightsTab.click();
        Thread.sleep(3000); // karena sudah ada wait di base page, jadi ini bisa dihapus kalau mau lebih optimal
    }

    /*
     * Function selectDepartureCity bisa dioptimasi lagi dengan dynamic parameter ya
     * supaya bisa dipakai untuk testing negative juga atau dengan data lain contoh implementasinya 
     * 
     */
    public void selectDepartureCity() throws InterruptedException {
        homeObjectRepository.originInput.sendKeys("Jakarta");
        Thread.sleep(2000);

        By optionLocator = By.xpath("//ul[contains(@aria-label,'Flying from')]/li"); // locator ini bisa dipindah ke object repository juga ya
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator)); // bisa pakai yang di abstract component juga untuk wait visibility

        List<WebElement> listOptions = driver.findElements(optionLocator);
        for (WebElement option : listOptions) {
            if (option.getText().contains("Soekarno-Hatta")) {
                option.click();
                break;
            }
        }
    }

    public void selectDepartureCityWithParam(String country, String airport ) throws InterruptedException {
        homeObjectRepository.originInput.sendKeys(country);
        Thread.sleep(2000);

        By optionLocator = By.xpath("//ul[contains(@aria-label,'Flying from')]/li");
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator)); 

        List<WebElement> listOptions = driver.findElements(optionLocator);
        for (WebElement option : listOptions) {
            if (option.getText().contains(airport)) {
                option.click();
                break;
            }
        }
    }

     /*
     * Function selectDestinationCity bisa dioptimasi lagi dengan dynamic parameter ya
     * supaya bisa dipakai untuk testing negative juga atau dengan data lain contoh implementasinya 
     * 
     */
    public void selectDestinationCity() throws InterruptedException {
        homeObjectRepository.destinationInput.sendKeys("Singapore");
        Thread.sleep(2000);

        By optionLocator = By.xpath("//ul[contains(@aria-label,'Flying to')]/li"); // locator ini bisa dipindah ke object repository juga ya
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        List<WebElement> listOptions = driver.findElements(optionLocator);
        for (WebElement option : listOptions) {
            if (option.getText().contains("Singapore Changi Airport")) {
                option.click();
                break;
            }
        }
    }

    public void selectDestinationCity(String country, String airport) throws InterruptedException {
        homeObjectRepository.destinationInput.sendKeys(country);
        Thread.sleep(2000);

        By optionLocator = By.xpath("//ul[contains(@aria-label,'Flying to')]/li"); // locator ini bisa dipindah ke object repository juga ya
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        List<WebElement> listOptions = driver.findElements(optionLocator);
        for (WebElement option : listOptions) {
            if (option.getText().contains(airport)) {
                option.click();
                break;
            }
        }
    }

    public void selectTomorrowDate() {
        /*
         * Untuk date bisa dibuat general function bisa dibuat di utility class atau di base page ya
         * supaya bisa dipakai untuk memilih tanggal lain juga dan bisa dipakai di function lain
         */
        // LocalDate tomorrow = LocalDate.now().plusDays(1);
        // String tomorrowDateStr = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // String tomorrowXPath = "//span[@data-selenium-date='" + tomorrowDateStr + "']";

        String tomorrowXPath = Utility.tomorrowDateXPath(); // panggil function dari utility class
        WebElement tomorrowDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tomorrowXPath)));
        tomorrowDateElement.click();
    }

    public void clickSearch() {
        homeObjectRepository.searchButton.click();
    }
}
