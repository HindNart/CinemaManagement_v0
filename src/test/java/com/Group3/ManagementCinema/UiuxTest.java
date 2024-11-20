package com.Group3.ManagementCinema;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UiuxTest {
    private WebDriver driver;
    private String username;
    private String password;
    private String email;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        username = "test@test";
        password = "test@test";
        email =  "test@test";
    }
    @Test
    public void testLoginPage() {
        driver.get("http://localhost:8080/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("inputEmail")));
        usernameField.sendKeys("");


        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_button_id")));
        loginButton.click();

        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome_message_id")));
        assert(welcomeMessage.getText().equals("Welcome User!"));
    }
}
