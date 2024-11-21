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
public class UiuxTest {
    private static final Logger log = LoggerFactory.getLogger(UiuxTest.class);
    private WebDriver driver;
    private String _username;
    private String _password;
    private String _email;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        _username = "test@test";
        _password = "test@test";
        _email =  "test@test";
    }

    @Test
    @Order(1)
    public void testRegister() {
        String link_check = null;
        String alertText = null;
        String linkLogin = null;
        String linkRegister = null;

        //1 forward to target
        driver.get("http://localhost:8080/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        linkRegister = "http://localhost:8080/regis";
        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[3]/p/a")));
        registerButton.click();
        link_check = driver.getCurrentUrl();
        if (linkRegister.equals(link_check)){
            log.info("ID: 1 - OK - Button \"Tạo tài khoản\" Active - Chuyển hướng đến trang đăng ký "+ link_check);
        } else {
            log.info("ID: 1 - False - Button \"Tạo tài khoản\" Non-active - Không chuyển hướng đến trang đăng ký \"http://localhost:8080/regis\" | Trang hiện tại: "+ link_check);
            fail("testRegister - Id: 1");
        }

        // 2 account is not exists
        try {
            WebElement inputEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[1]/input")));
            inputEmail.sendKeys(_email);
            WebElement inputUsername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[2]/input")));
            inputUsername.sendKeys(_username);
            WebElement inputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[3]/input")));
            inputPassword.sendKeys(_password);
            WebElement inputPasswordValid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[4]/input")));
            inputPasswordValid.sendKeys(_password);
            WebElement registerButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[6]/input")));
            registerButton2.click();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            if (alertText.equals("Đăng ký thành công!")){
                alert.accept();
                log.info("ID: 2 - OK - Button \"Đăng ký\" Active - "+ alertText);
            }
        } catch (Exception e){
            log.info("ID: 2 - False - Button \"Đăng ký\" Non-active - Đăng ký không thành công - "+ link_check);
            fail("testRegister - Id: 2");
        }

        //3 account is exists
        try {
            linkRegister = "http://localhost:8080/regis";
            driver.get(linkRegister);
            WebElement inputEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[1]/input")));
            inputEmail.sendKeys(_email);
            WebElement inputUsername = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[2]/input")));
            inputUsername.sendKeys(_username);
            WebElement inputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[3]/input")));
            inputPassword.sendKeys(_password);
            WebElement inputPasswordValid = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[4]/input")));
            inputPasswordValid.sendKeys(_password);
            WebElement registerButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[6]/input")));
            registerButton2.click();
            link_check = driver.getCurrentUrl();
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            if (alertText.equals("Đăng ký thành công!")){
                alert.accept();
                log.info("ID: 3 - False - Button \"Đăng ký\" Non-active - Đăng ký  thành công "+ alertText);
                fail("testRegister - Id: 3");
            }
        } catch (Exception e){
        } finally {
            log.info("ID: 3 - OK - Button \"Đăng ký\" Active - Đăng ký không thành công - "+ link_check);
        }

        //4
        try {
            linkRegister = "http://localhost:8080/regis";
            driver.get(linkRegister);
            linkLogin = "http://localhost:8080/login";
            WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[1]/div[5]/a")));
            backButton.click();
            link_check = driver.getCurrentUrl();
            if (linkLogin.equals(link_check)){
                log.info("ID: 4 - OK - Button \"Quay lại\" Active - Chuyển hướng đến trang đăng nhập "+ link_check);
            }
        } catch (Exception e){
            log.info("ID: 4 - False - Button \"Quay lại\" Non-active - Không chuyển hướng đến trang đăng nhập\"http://localhost:8080/login\" | Trang hiện tại: "+ link_check);
            fail("testRegister - Id: 4");
        }
        driver.quit();
    }

    @Test
    @Order(2)
    void testLogin() {
        String link_check = null;
        String linkLogin = null;

        driver.get("http://localhost:8080/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 5
        try {
            linkLogin = "http://localhost:8080/checkLogin";
            WebElement inputEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input")));
            inputEmail.sendKeys(_email);
            WebElement inputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input")));
            inputPassword.sendKeys(_password);
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[3]/button")));
            loginButton.click();
            link_check = driver.getCurrentUrl();

            if (link_check.equals(linkLogin)) {
                log.info("ID: 5 - OK - Button \"Đăng nhập\" Active - Chuyển hướng đến giao diện chính " + link_check);
            }
        } catch (Exception e) {
            log.info("ID: 5 - False - Button \"Đăng nhập\" Non-active - Không chuyển hướng đến giao diện chính " + link_check);
            fail("testLogin - Id: 5");
        }

        // 6
        driver.get("http://localhost:8080/login");
        try {
            linkLogin = "http://localhost:8080/checkLogin";
            WebElement inputEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input")));
            inputEmail.sendKeys(_email + "!");
            WebElement inputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input")));
            inputPassword.sendKeys(_password + "!");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[3]/button")));
            loginButton.click();
            link_check = driver.getCurrentUrl();

            if (!link_check.equals(linkLogin)) {
                log.info("ID: 6 - OK - Button \"Đăng nhập\" Active - Không chuyển hướng đến giao diện chính " + link_check);
            }
        } catch (Exception e) {
            log.info("ID: 6 - False - Button \"Đăng nhập\" Non-active - Chuyển hướng đến giao diện chính " + link_check);
            fail("testLogin - Id: 6");
        }
        driver.quit();
    }
    @Test
    @Order(3)
    void testAction(){
        String link_check = null;
        String linkLogin = null;

        driver.get("http://localhost:8080/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        linkLogin = "http://localhost:8080/checkLogin";
        WebElement inputEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[1]/div/input")));
        inputEmail.sendKeys(_email);
        WebElement inputPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[2]/div/input")));
        inputPassword.sendKeys(_password);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/form/div[3]/button")));
        loginButton.click();

        //7 menu lich chieu
        try {
            WebElement elementToHover = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul/li[1]"));

            Actions actions = new Actions(driver);
            actions.moveToElement(elementToHover).perform();

            WebElement movieShowing = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul/li[1]/div/a[1]"));
            WebElement movieUpcoming = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul/li[1]/div/a[2]"));
            String buttonMS = "Phim đang chiếu";
            String buttonMU = "Phim sắp chiếu";
            if (movieShowing.getText().equals(buttonMS) && movieUpcoming.getText().equals(buttonMU)){
                log.info("ID: 7 - OK - Select Hover \"Lịch chiếu\" Active - Hiển thị 2 nút bấm \"" + movieShowing.getText() +"\" \"" + movieUpcoming.getText());
            }

        } catch (Exception e) {
            log.info("ID: 7 - False - Select Hover \"Lịch chiếu\" Non-active - Không hiển thị 2 nút bấm ");
            fail("testLogin - Id: 7");
        }

        //8 button phim dang chieu
        try {
            WebElement movieShowing = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/ul/li[1]/div/a[1]"))));
            movieShowing.click();

            WebElement listMovies = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div"))));
            listMovies.getText();
            log.info("ID: 8 - OK - Button \"Phim đang chiếu\" Active - Hiển thị banner phim");

        } catch (Exception e) {
            log.info("ID: 8 - OK - Button \"Phim đang chiếu\" Non-active - Không hiển thị banner phim");
            fail("testLogin - Id: 8");
        }

        //9 menu tai khoan
        try {
            WebElement elementToHover = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div"));

            Actions actions = new Actions(driver);
            actions.moveToElement(elementToHover).perform();

            WebElement accountInfo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/a[1]"));
            WebElement logOut = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/a[2]"));
            String buttonAC = "Thông tin";
            String buttonLO = "Đăng xuất";
            if (accountInfo.getText().equals(buttonAC) && logOut.getText().equals(buttonLO)){
                log.info("ID: 9 - OK - Select Hover Account \"<name>\" Active - Hiển thị 2 nút bấm \"" + accountInfo.getText() +"\" \"" + logOut.getText());
            }

        } catch (Exception e) {
            log.info("ID: 9 - False - elect Hover Account \"<name>\" Non-active - Không hiển thị 2 nút bấm ");
            fail("testLogin - Id: 9");
        }

        //10
    }

//    @Test
//    @Order(4)
}
