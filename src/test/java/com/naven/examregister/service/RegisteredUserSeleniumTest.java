package com.naven.examregister.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisteredUserSeleniumTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver (assuming ChromeDriver for Chrome browser)
        driver = new ChromeDriver();
    }

    @Test
    public void testUserRegistration() {
        // Open the registration page
        driver.get("http://localhost:8080/register");

        // Fill out the registration form
        WebElement firstNameInput = driver.findElement(By.name("firstName"));
        WebElement lastNameInput = driver.findElement(By.name("lastName"));
        WebElement collegeInput = driver.findElement(By.name("college"));
        WebElement departmentInput = driver.findElement(By.name("department"));
        WebElement yearOfStudyInput = driver.findElement(By.name("yearOfStudy"));
        WebElement submitButton = driver.findElement(By.name("registerButton"));
        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Doe");
        collegeInput.sendKeys("Example University");
        departmentInput.sendKeys("Computer Science");
        yearOfStudyInput.sendKeys("3rd");

        // Submit the registration form
        submitButton.click();

        // Wait for success message or redirect
        // (Assuming a success message appears or user is redirected to a success page)

        // Example verification (assertion)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("success"), "User registration failed");
    }

    @AfterClass
    public void tearDown() {
        // Close the WebDriver session
        if (driver != null) {
            driver.quit();
        }
    }
}
