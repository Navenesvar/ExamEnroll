package com.naven.examregister.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExamSeleniumTest {

  private WebDriver driver;
  private String baseUrl;

  @BeforeClass
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "http://localhost:8080"; // Update URL to your login page (assuming login is required)
  }

  @Test
  public void testAddExam() throws Exception {
    // Simulate successful login (assuming login is required)
    // ... (code to login using username and password)

    driver.get(baseUrl + "/addexam"); // Navigate to add exam page

    // Find form elements using appropriate locators
    driver.findElement(By.id("title")).sendKeys("Sample Exam1");
    driver.findElement(By.id("description")).sendKeys("This is a sample exam description.1");
    driver.findElement(By.id("date")).sendKeys("2024-06-30"); // Update with a future date

    // Submit the form
    driver.findElement(By.id("submit")).click();

    // Assert successful exam addition (check for confirmation message, etc.)

  }

  @AfterClass
  public void tearDown() throws Exception {
    driver.quit();
  }
}
