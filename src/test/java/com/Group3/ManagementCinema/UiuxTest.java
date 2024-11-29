package com.Group3.ManagementCinema;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UiuxTest extends Thread{
    private static final Logger log = LoggerFactory.getLogger(UiuxTest.class);
    private static WebDriver driver; // Dùng static để chia sẻ driver giữa các test

    private String _admin_username;
    private String _admin_password;
    private String _admin_email;

    private String _username;
    private String _password;

    private String _email;

    private String _url_local;
    private String _url_login;

    @BeforeAll
    public static void setUpAll() {
        log.info("Khởi tạo trình duyệt cho toàn bộ test");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void setUp() {
        // Khởi tạo các thông tin test
        _admin_username = "Admin";
        _admin_password = "12345678";
        _admin_email = "admin@gmail.com";

        _username = "test@test";
        _password = "test@test";
        _email = "test@test";

        _url_local = "http://localhost:8080/";
        _url_login = "http://localhost:8080/login";
    }

    @AfterAll
    public static void tearDownAll() {
        if (driver != null) {
            log.info("Đóng trình duyệt");
            driver.quit();
        }
    }

    private void fillInputField(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.sendKeys(value);
    }

    private void clickButton(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        button.click();
    }

    private void findText(String value) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]"));
    }

    @Test
    @Order(1)
    void UU1() {
        log.info("Start UU1:");
        try {
            driver.get(_url_local); // Truy cập URL chính
            clickButton(By.xpath("/html/body/div[2]/a[1]/div"));
            Thread.sleep(1500);
            findText("Danh sách tài khoản");
            log.info("✔ Success UU1");
        } catch (Exception e) {
            log.error("❌ Fail UU1: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(2)
    void UU2() {
        log.info("Start UU2:");
        log.info("-- Not empty:");
        try {
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "test");
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            findText(_username);
            log.info("✔ Success UU2 (Not empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU2 (Not empty): " + e.getMessage());
            Assertions.fail();
        }

        log.info("-- Empty:");
        try {
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "");
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            findText(_username);
            log.info("✔ Success UU2 (Empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU2 (Empty): " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    void UU3(){
        log.info("Start UU3:");
        try{
            clickButton(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[1]/td[5]/a[1]"));

            log.info("✔ Success UU3");
        }
        catch (Exception e){
            log.error("❌ Fail UU3: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(100)
    void UU(){
        log.info("Start UU:");
        try{

            log.info("✔ Success UU");
        }
        catch (Exception e){
            log.error("❌ Fail UU: " + e.getMessage());
            Assertions.fail();
        }
    }
}