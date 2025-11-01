package com.finalprojectwebautomotion.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
/**
 * Utility class for common functions used across the project.
 * This class contains methods for date handling and hard assertions.
 */

public class Utility {

    private static final Logger log = LogManager.getLogger(Utility.class);

    public static String tomorrowDateXPath() {
        /*
         * Untuk date bisa dibuat general function bisa dibuat di utility class atau di base page ya
         * supaya bisa dipakai untuk memilih tanggal lain juga dan bisa dipakai di function lain
         */
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        String tomorrowDateStr = tomorrow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return "//span[@data-selenium-date='" + tomorrowDateStr + "']";
    }


    // -------------------------
    // HARD ASSERTIONS
    // -------------------------
    public static void assertEquals(String actual, String expected, String fieldName) {
        try {
            Assert.assertEquals(actual.trim(), expected.trim());
            log.info("✅ [{}] verified successfully — Expected: [{}], Actual: [{}]", fieldName, expected, actual);
        } catch (AssertionError e) {
            handleFailure(e, fieldName, expected, actual);
            throw e;
        }
    }

    private static void handleFailure(AssertionError e, String fieldName, String expected, String actual) {
        log.error("❌ Assertion failed for [{}] — Expected: [{}], Actual: [{}]", fieldName, expected, actual);
    }

}
