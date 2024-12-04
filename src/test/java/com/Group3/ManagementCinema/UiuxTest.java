package com.Group3.ManagementCinema;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.List;
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


        try {
            driver.get("http://localhost:8080/regis");
            Thread.sleep(2000);
            WebElement email = driver.findElement(By.xpath("/html/body/form/div[1]/div[1]/input"));
            email.sendKeys("test@gmail.com");
            Thread.sleep(2000);
            WebElement username = driver.findElement(By.xpath("/html/body/form/div[1]/div[2]/input"));
            username.sendKeys("test");
            Thread.sleep(2000);
            WebElement password = driver.findElement(By.xpath("/html/body/form/div[1]/div[3]/input"));
            password.sendKeys("test@test");
            Thread.sleep(2000);
            WebElement passwordR = driver.findElement(By.xpath("/html/body/form/div[1]/div[4]/input"));
            passwordR.sendKeys("test@test");
            Thread.sleep(2000);
            WebElement submitRegister = driver.findElement(By.xpath("/html/body/form/div[1]/div[6]/input"));
            submitRegister.click();
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            alert.accept();

            Thread.sleep(2000);
            driver.get("http://localhost:8080/showNewEmployeeForm");
            Thread.sleep(2000);
            WebElement maNV = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
            maNV.sendKeys("0");
            Thread.sleep(2000);
            WebElement tenNV = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            tenNV.sendKeys("test");
            Thread.sleep(2000);
            WebElement dob = driver.findElement(By.xpath("/html/body/div/form/div[3]/input"));
            dob.sendKeys("12-09-2003");
            Thread.sleep(2000);
            WebElement dropdownChucvu = driver.findElement(By.xpath("/html/body/div/form/div[5]/select"));
            Select selectCV = new Select(dropdownChucvu);
            selectCV.selectByIndex(1);
            Thread.sleep(2000);
            WebElement dropdownCL = driver.findElement(By.xpath("/html/body/div/form/div[7]/select"));
            Select selectCL = new Select(dropdownCL);
            selectCL.selectByIndex(0);
            Thread.sleep(2000);
            WebElement dcNV = driver.findElement(By.xpath("/html/body/div/form/div[4]/input"));
            dcNV.sendKeys("testAddress");
            Thread.sleep(2000);
            WebElement sdtNV = driver.findElement(By.xpath("/html/body/div/form/div[8]/input"));
            sdtNV.sendKeys("0906272037");
            Thread.sleep(2000);
            WebElement submitRegisterNV = driver.findElement(By.xpath("/html/body/div/form/div[9]/button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submitRegisterNV);
            Thread.sleep(2000);
            submitRegisterNV.click();

            Thread.sleep(2000);
            driver.get("http://localhost:8080/showNewMovieScheduleForm");
            Thread.sleep(2000);
            WebElement dropdownPC = driver.findElement(By.xpath("/html/body/div/form/div[1]/select"));
            Select selectPC = new Select(dropdownPC);
            selectPC.selectByIndex(0);
            Thread.sleep(2000);
            WebElement dropdownP = driver.findElement(By.xpath("/html/body/div/form/div[2]/select"));
            Select selectP = new Select(dropdownP);
            selectP.selectByIndex(0);
            Thread.sleep(2000);
            WebElement timeS = driver.findElement(By.xpath("/html/body/div/form/div[3]/div[1]/input"));
            timeS.sendKeys("01:30PM");
            Thread.sleep(2000);
            WebElement timeF = driver.findElement(By.xpath("/html/body/div/form/div[3]/div[2]/input"));
            timeF.sendKeys("03:30PM");
            Thread.sleep(2000);
            WebElement dateFilm = driver.findElement(By.xpath("/html/body/div/form/div[5]/input"));
            dateFilm.sendKeys("12-05-2024");
            Thread.sleep(2000);
            WebElement submitSchedule = driver.findElement(By.xpath("/html/body/div/form/div[6]/button"));
            js.executeScript("arguments[0].scrollIntoView(true);", submitSchedule);
            Thread.sleep(2000);
            submitSchedule.click();

            Thread.sleep(2000);
            driver.get("http://localhost:8080/showNewCinemaRoomForm");
            Thread.sleep(2000);
            WebElement maPC = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
            maPC.sendKeys("pcTest");
            Thread.sleep(2000);
            WebElement ghePC = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            ghePC.sendKeys("100");
            Thread.sleep(2000);
            WebElement loaiPC = driver.findElement(By.xpath("/html/body/div/form/div[3]/div/input[1]"));
            loaiPC.click();
            Thread.sleep(2000);
            WebElement submitPC = driver.findElement(By.xpath("/html/body/div/form/div[4]/button"));
            js.executeScript("arguments[0].scrollIntoView(true);", submitPC);
            Thread.sleep(2000);
            submitPC.click();

            Thread.sleep(2000);
            driver.get("http://localhost:8080/showNewMovieForm");
            Thread.sleep(2000);
            WebElement tenFilm = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            tenFilm.sendKeys("tenfilmTest");
            Thread.sleep(2000);
            WebElement theloaiFilm = driver.findElement(By.xpath("/html/body/div/form/div[3]/input"));
            theloaiFilm.sendKeys("theloaiTest");
            Thread.sleep(2000);
            WebElement daodienFilm = driver.findElement(By.xpath("/html/body/div/form/div[4]/input"));
            daodienFilm.sendKeys("daodienTest");
            Thread.sleep(2000);
            WebElement dienvienFilm = driver.findElement(By.xpath("/html/body/div/form/div[5]/input"));
            dienvienFilm.sendKeys("dienvienTest");
            Thread.sleep(2000);
            WebElement thoiluongFilm = driver.findElement(By.xpath("/html/body/div/form/div[6]/input"));
            thoiluongFilm.sendKeys("12");
            Thread.sleep(2000);
            WebElement motaFilm = driver.findElement(By.xpath("/html/body/div/form/div[7]/textarea"));
            motaFilm.sendKeys("motaTest");
            Thread.sleep(2000);
            WebElement ngayraFilm = driver.findElement(By.xpath("/html/body/div/form/div[8]/input"));
            ngayraFilm.sendKeys("12-05-2024");
            Thread.sleep(2000);
            WebElement quocgiaFilm = driver.findElement(By.xpath("/html/body/div/form/div[9]/input"));
            quocgiaFilm.sendKeys("quocgiaTest");
            Thread.sleep(2000);
            WebElement linkposterFilm = driver.findElement(By.xpath("/html/body/div/form/div[10]/input"));
            linkposterFilm.sendKeys("https://www.google.com/url?sa=i&url=https%3A%2F%2Ftu-test-app.myharavan.com%2Fproducts%2Ftest&psig=AOvVaw3Un_TusnXbQlCuVBzyakZM&ust=1733262317892000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMihxbeHiooDFQAAAAAdAAAAABAE");
            Thread.sleep(2000);
            WebElement trangthaiFilm = driver.findElement(By.xpath("/html/body/div/form/div[11]/input"));
            trangthaiFilm.clear();
            trangthaiFilm.sendKeys("true");
            Thread.sleep(2000);
            WebElement submitFilm = driver.findElement(By.xpath("/html/body/div/form/div[12]/button"));
            js.executeScript("arguments[0].scrollIntoView(true);", submitFilm);
            Thread.sleep(2000);
            submitFilm.click();
        }
        catch (Exception e){
            log.error("init error{}", e.getMessage());
        }
    }

    @BeforeEach
    public void setUp() {
        // Khởi tạo các thông tin test
        _admin_username = "Admin";
        _admin_password = "12345678";
        _admin_email = "admin@gmail.com";

        _username = "test";
        _password = "test@test";
        _email = "test@gmail.com";

        _url_local = "http://localhost:8080/";
        _url_login = "http://localhost:8080/login";
    }

    @AfterAll
    public static void tearDownAll() {
        try {
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonNV = driver.findElement(By.xpath("/html/body/div[2]/a[2]/div"));
            buttonNV.click();
            Thread.sleep(2000);
            WebElement tableNV = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'test')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tableNV);
            Thread.sleep(2000);
            WebElement deleteButtonNV = tableNV.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonNV.click();

            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[3]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            WebElement tableLC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pc1')]]"));
            js.executeScript("arguments[0].scrollIntoView(true);", tableLC);
            Thread.sleep(2000);
            WebElement deleteButtonLC = tableLC.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonLC.click();

            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonPC = driver.findElement(By.xpath("/html/body/div[2]/a[4]/div"));
            buttonPC.click();
            Thread.sleep(2000);
            WebElement tablePC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pcTest')]]"));
            js.executeScript("arguments[0].scrollIntoView(true);", tablePC);
            Thread.sleep(2000);
            WebElement deleteButtonPC = tablePC.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonPC.click();

            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            WebElement buttonP = driver.findElement(By.xpath("/html/body/div[2]/a[5]/div"));
            buttonP.click();
            Thread.sleep(2000);
            WebElement tableP = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'quocgiaTest')]]"));
            js.executeScript("arguments[0].scrollIntoView(true);", tableP);
            Thread.sleep(2000);
            WebElement deleteButtonP = tableP.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonP.click();
        } catch (Exception e) {
            log.error("finish error {}", e.getMessage());
        }
        if (driver != null) {
            log.info("Đóng trình duyệt");
            driver.quit();
        }
    }

    private void fillInputField(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(value);
    }

    private void clickButton(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
    }

    private void findText(String value) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]"));
    }

    private void sleep() throws InterruptedException {
        Thread.sleep(3000);
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
        driver.get(_url_local);
        clickButton(By.xpath("/html/body/div[2]/a[1]/div"));
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
            findText(_admin_username);
            findText(_admin_email);
            log.info("✔ Success UU3");
        }
        catch (Exception e){
            log.error("❌ Fail UU3: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(4)
    void UU4(){
        log.info("Start UU4:");
        try{

            log.info("✔ Success UU4");
        }
        catch (Exception e){
            log.error("❌ Fail UU4: " + e.getMessage());
            Assertions.fail();
        }
        Assertions.fail(); // (3 dang loi)
    }

    @Test
    @Order(5)
    void UU5(){
        log.info("Start UU5:");
        try{

            log.info("✔ Success UU5");
        }
        catch (Exception e){
            log.error("❌ Fail UU5: " + e.getMessage());
            Assertions.fail();
        }
        Assertions.fail(); // (3 dang loi)
    }

    @Test
    @Order(6)
    void UU6(){
        log.info("Start UU6:");
        try{

            log.info("✔ Success UU6");
        }
        catch (Exception e){
            log.error("❌ Fail UU6: " + e.getMessage());
            Assertions.fail();
        }
        Assertions.fail(); // (3 dang loi)
    }

    @Test
    @Order(7)
    void UU7(){
        log.info("Start UU7:");
        try{
            WebElement row = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table" + "//tr[td[contains(text(),'" + _username + "')]]"));
            WebElement button = row.findElement(By.xpath(".//button[last()]"));
            button.click();
            try{
                driver.get(_url_local);
                clickButton(By.xpath("/html/body/div[2]/a[1]/div"));
                findText(_username);
                Assertions.fail();
            }
            catch (Exception e){
                log.info("✔ Success UU7");
            }
        }
        catch (Exception e){
            log.error("❌ Fail UU7: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(8)
    void UU8(){
        log.info("Start UU8:");
        try{
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            findText("Danh sách nhân viên");
            log.info("✔ Success UU8");
        }
        catch (Exception e){
            log.error("❌ Fail UU8: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(9)
    void UU9(){
        log.info("Start UU9:");
        log.info("-- Not empty:");
        try {
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "test");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText(_username);
            log.info("✔ Success UU9 (Not empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU9 (Not empty): " + e.getMessage());
            Assertions.fail();
        }

        log.info("-- Empty:");
        try {
            Thread.sleep(2000);
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText("test");
            log.info("✔ Success UU9 (Empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU9 (Empty): " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(10)
    void UU10(){
        log.info("Start UU10:");
        try{
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/table"));
            if (!rows.isEmpty()) {
                log.info("✔ Table has data: {} rows.", rows.size());
                Thread.sleep(2000);
                WebElement rowWithText = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'test')]]"));
                WebElement editButton = rowWithText.findElement(By.xpath("./td[last()]//a[1]"));
                Thread.sleep(2000);
                editButton.click();
                findText("Cập nhật nhân viên");
                log.info("✔ Success UU10");
            } else {
                log.warn("⚠ Table is empty.");
            }
        }
        catch (Exception e){
            log.error("❌ Fail UU10: {}", e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(11)
    void UU11(){
        log.info("Start UU11:");
        try{
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[2]/input"), "test1");
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[4]/input"), "testAddress1");
            Thread.sleep(2000);
            WebElement dropdown = driver.findElement(By.xpath("/html/body/div/form/div[5]/select"));
            Select select = new Select(dropdown);
            select.selectByIndex(1);
            Thread.sleep(2000);
            WebElement dropdown7 = driver.findElement(By.xpath("/html/body/div/form/div[7]/select"));
            Select select7 = new Select(dropdown7);
            select7.selectByIndex(1);
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[8]/input"), "0907161111");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div/form/div[9]/button"));
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            Thread.sleep(2000);
            findText("test1");
            log.info("✔ Success UU11");
        }
        catch (Exception e){
            log.error("❌ Fail UU11: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(12)
    void UU12(){
        log.info("Start UU12:");
        try{
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[2]/input"), "");
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[4]/input"), "test@Address1");
            Thread.sleep(2000);
            WebElement dropdown = driver.findElement(By.xpath("/html/body/div/form/div[5]/select"));
            Select select = new Select(dropdown);
            select.selectByIndex(0);
            Thread.sleep(2000);
            WebElement dropdown7 = driver.findElement(By.xpath("/html/body/div/form/div[7]/select"));
            Select select7 = new Select(dropdown7);
            select7.selectByIndex(0);
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[8]/input"), "0907161111");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div/form/div[9]/button"));
            log.error("❌ Fail UU12 ");
            Assertions.fail();
        }
        catch (Exception e){
            log.info("✔ Success UU12");
        }
    }

    @Test
    @Order(13)
    void UU13(){
        log.info("Start UU13:");
        try{
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div/div/a"));
            Thread.sleep(2000);
            WebElement luu = driver.findElement(By.xpath("/html/body/div/form/div[9]/a"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", luu);
            Thread.sleep(2000);
            luu.click();
            if (_url_local.equals(driver.getCurrentUrl())){
                log.info("✔ Success UU13");
            }
            findText("Dashboard");
        }
        catch (Exception e){
            log.error("❌ Fail UU13: " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(14)
    void UU14(){
        log.info("Start UU14:");
        try{
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonNV = driver.findElement(By.xpath("/html/body/div[2]/a[2]/div"));
            buttonNV.click();
            Thread.sleep(2000);
            WebElement tableNV = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'test1')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tableNV);
            Thread.sleep(2000);
            WebElement deleteButtonNV = tableNV.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonNV.click();
            log.info("✔ Success UU14");
        }
        catch (Exception e){
            log.error("❌ Fail UU14: " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(15)
    void UU15(){
        log.info("Start UU15:");
        try{
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonNV = driver.findElement(By.xpath("/html/body/div[2]/a[2]/div"));
            buttonNV.click();
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div/div/a"));
            log.info("✔ Success UU14");
        }
        catch (Exception e){
            log.error("❌ Fail UU14: " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(16)
    void UU16(){
        log.info("Start UU16:");
        try{
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div/div/a"));
            Thread.sleep(2000);
            WebElement maNV = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
            maNV.sendKeys("0");
            Thread.sleep(2000);
            WebElement tenNV = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            tenNV.sendKeys("test");
            Thread.sleep(2000);
            WebElement dob = driver.findElement(By.xpath("/html/body/div/form/div[3]/input"));
            dob.sendKeys("12-09-2003");
            Thread.sleep(2000);
            WebElement dropdownChucvu = driver.findElement(By.xpath("/html/body/div/form/div[5]/select"));
            Select selectCV = new Select(dropdownChucvu);
            selectCV.selectByIndex(1);
            Thread.sleep(2000);
            WebElement dropdownCL = driver.findElement(By.xpath("/html/body/div/form/div[7]/select"));
            Select selectCL = new Select(dropdownCL);
            selectCL.selectByIndex(0);
            Thread.sleep(2000);
            WebElement dcNV = driver.findElement(By.xpath("/html/body/div/form/div[4]/input"));
            dcNV.sendKeys("testAddress");
            Thread.sleep(2000);
            WebElement sdtNV = driver.findElement(By.xpath("/html/body/div/form/div[8]/input"));
            sdtNV.sendKeys("0906272037");
            Thread.sleep(2000);
            WebElement submitRegisterNV = driver.findElement(By.xpath("/html/body/div/form/div[9]/button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submitRegisterNV);
            Thread.sleep(2000);
            submitRegisterNV.click();
            Thread.sleep(2000);
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[2]/div"));
            Thread.sleep(2000);
            findText("test");
            log.info("✔ Success UU16");
        }
        catch (Exception e){
            log.error("❌ Fail UU16: " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(17)
    void UU17(){
        log.info("Start UU17:");
        try{
            log.info("✔ Success UU17");
        }
        catch (Exception e){
            log.error("❌ Fail UU17: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(18)
    void UU18(){
        log.info("Start UU18:");
        log.info("-- Not empty:");
        try {
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[3]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "pc1");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText("pc1");
            log.info("✔ Success UU18 (Not empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU18 (Not empty): " + e.getMessage());
            Assertions.fail();
        }

        log.info("-- Empty:");
        try {
            Thread.sleep(2000);
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[3]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText("pc1");
            log.info("✔ Success UU18 (Empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU18 (Empty): " + e.getMessage());
            Assertions.fail();
        }
    }


    @Test
    @Order(19)
    void UU19(){
        log.info("Start UU19:");
        try{
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[3]/div"));
            List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/table"));
            if (!rows.isEmpty()) {
                log.info("✔ Table has data: {} rows.", rows.size());
                Thread.sleep(2000);
                WebElement rowWithText = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pc1')]]"));
                WebElement editButton = rowWithText.findElement(By.xpath("./td[last()]//a[1]"));
                Thread.sleep(2000);
                editButton.click();
                findText("Cập nhật lịch chiếu");
                log.info("✔ Success UU19");
            } else {
                log.warn("⚠ Table is empty.");
            }
        }
        catch (Exception e){
            log.error("❌ Fail UU19: {}", e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(20)
    void UU20(){
        log.info("Start UU20:");
        try{
            Thread.sleep(2000);
            WebElement dropdownPC = driver.findElement(By.xpath("/html/body/div/form/div[2]/select"));
            Select selectPC = new Select(dropdownPC);
            selectPC.selectByValue("pcTest");
            Thread.sleep(2000);
            WebElement dropdownP = driver.findElement(By.xpath("/html/body/div/form/div[3]/select"));
            Select selectP = new Select(dropdownP);
            selectP.selectByIndex(1);
            Thread.sleep(2000);
            WebElement timeS = driver.findElement(By.xpath("/html/body/div/form/div[4]/div[1]/input"));
            timeS.sendKeys("08:30PM");
            Thread.sleep(2000);
            WebElement timeF = driver.findElement(By.xpath("/html/body/div/form/div[4]/div[2]/input"));
            timeF.sendKeys("10:30PM");
            Thread.sleep(2000);
            WebElement dateFilm = driver.findElement(By.xpath("/html/body/div/form/div[6]/input"));
            dateFilm.sendKeys("14-05-2024");
            Thread.sleep(2000);
            WebElement submitSchedule = driver.findElement(By.xpath("/html/body/div/form/div[7]/button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submitSchedule);
            Thread.sleep(2000);
            submitSchedule.click();
            Thread.sleep(2000);
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[3]/div"));
            Thread.sleep(2000);
            findText("pcTest");
            log.info("✔ Success UU20");
        }
        catch (Exception e){
            log.error("❌ Fail UU20: " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(21)
    void UU21(){
        log.info("Start UU21:");
        try{
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[3]/div"));
            WebElement rowWithText = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pc1')]]"));
            WebElement editButton = rowWithText.findElement(By.xpath("./td[last()]//a[1]"));
            Thread.sleep(2000);
            editButton.click();
            Thread.sleep(2000);
            WebElement dropdownPC = driver.findElement(By.xpath("/html/body/div/form/div[2]/select"));
            Select selectPC = new Select(dropdownPC);
            selectPC.selectByIndex(1);
            Thread.sleep(2000);
            WebElement dropdownP = driver.findElement(By.xpath("/html/body/div/form/div[3]/select"));
            Select selectP = new Select(dropdownP);
            selectP.selectByIndex(1);
            Thread.sleep(2000);
            WebElement timeS = driver.findElement(By.xpath("/html/body/div/form/div[4]/div[1]/input"));
            timeS.sendKeys("08:30PM");
            Thread.sleep(2000);
            WebElement timeF = driver.findElement(By.xpath("/html/body/div/form/div[4]/div[2]/input"));
            timeF.sendKeys("10:30PM");
            Thread.sleep(2000);
            WebElement dateFilm = driver.findElement(By.xpath("/html/body/div/form/div[6]/input"));
            dateFilm.clear();
            Thread.sleep(2000);
            WebElement submitSchedule = driver.findElement(By.xpath("/html/body/div/form/div[7]/button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submitSchedule);
            Thread.sleep(2000);
            submitSchedule.click();
            Thread.sleep(2000);
            if(_url_local.equals(driver.getCurrentUrl())){
                log.error("❌ Fail UU21: ");
                Assertions.fail();
            }
        }
        catch (Exception e){
            log.info("✔ Success UU21");
        }
    }

    @Test
    @Order(22)
    void UU22(){
        log.info("Start UU22:");
        try{
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[3]/div"));
            WebElement rowWithText = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pc1')]]"));
            WebElement editButton = rowWithText.findElement(By.xpath("./td[last()]//a[1]"));
            Thread.sleep(2000);
            editButton.click();
            clickButton(By.xpath("/html/body/div/form/div[6]/a"));
            log.info("✔ Success UU22");
        }
        catch (Exception e){
            log.error("❌ Fail UU22: " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(23)
    void UU23(){
        log.info("Start UU23:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[3]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            WebElement tableLC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pcTest')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tableLC);
            Thread.sleep(2000);
            WebElement deleteButtonLC = tableLC.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonLC.click();
            log.info("✔ Success UU23");
        }
        catch (Exception e){
            log.error("❌ Fail UU23: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(24)
    void UU24(){
        log.info("Start UU24:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[3]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            findText("Thêm lịch chiếu");
            log.info("✔ Success UU24");
        }
        catch (Exception e){
            log.error("❌ Fail UU24: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(25)
    void UU25(){
        log.info("Start UU25:");
        log.info("-- Not empty:");
        try {
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[4]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "pcTest");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText("pcTest");
            log.info("✔ Success UU25 (Not empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU25 (Not empty): " + e.getMessage());
            Assertions.fail();
        }

        log.info("-- Empty:");
        try {
            Thread.sleep(2000);
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[4]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText("pcTest");
            log.info("✔ Success UU25 (Empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU25 (Empty): " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(26)
    void UU26(){
        log.info("Start UU26:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[4]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            WebElement tableLC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pcTest')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tableLC);
            Thread.sleep(2000);
            WebElement deleteButtonLC = tableLC.findElement(By.xpath("./td[last()]//a[1]"));
            deleteButtonLC.click();
            Thread.sleep(2000);
            findText("Cập nhật phòng chiếu");
            log.info("✔ Success UU26");
        }
        catch (Exception e){
            log.error("❌ Fail UU26: " + e.getMessage());
            Assertions.fail();
        }

    }

    @Test
    @Order(27)
    void UU27(){
        log.info("Start UU27:");
        try{
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[2]/input"), "120");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div/form/div[3]/div/input[2]"));
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div/form/div[4]/button"));
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[4]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            findText("120");
            log.info("✔ Success UU27");
        }
        catch (Exception e){
            log.error("❌ Fail UU27: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(28)
    void UU28(){
        log.info("Start UU28:");
        try{
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div/form/div[2]/input"), "0");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div/form/div[3]/div/input[2]"));
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div/form/div[4]/button"));
            Thread.sleep(2000);
            log.error("❌ Fail UU28: ");
            Assertions.fail();
        }
        catch (Exception e){
            log.info("✔ Success UU28");

        }
    }

    @Test
    @Order(29)
    void UU29(){
        log.info("Start UU29:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[4]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            WebElement tableLC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pcTest')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tableLC);
            Thread.sleep(2000);
            WebElement deleteButtonLC = tableLC.findElement(By.xpath("./td[last()]//a[1]"));
            deleteButtonLC.click();
            Thread.sleep(1500);
            clickButton(By.xpath("/html/body/div/form/div[4]/a"));
            if (_url_local.equals(driver.getCurrentUrl())){
                log.info("✔ Success UU29");
            }else {
                log.error("❌ Fail UU29: ");
                Assertions.fail();
            }
        }
        catch (Exception e){
            log.error("❌ Fail UU29: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(30)
    void UU30(){
        log.info("Start UU30:");
        try{
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[4]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            WebElement tableLC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'pcTest')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tableLC);
            Thread.sleep(2000);
            WebElement deleteButtonLC = tableLC.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonLC.click();
            Thread.sleep(2000);
            try {
                findText("pcTest");
                log.error("❌ Fail UU30");
                Assertions.fail();
            } catch (Exception e){
                log.info("✔ Success UU30");
            }
        }
        catch (Exception e){
            log.error("❌ Fail UU30: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(32)
    void UU32(){
        log.info("Start UU32:");
        try{
            Thread.sleep(2000);
            WebElement maPC = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
            maPC.sendKeys("pcTest");
            Thread.sleep(2000);
            WebElement ghePC = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            ghePC.sendKeys("100");
            Thread.sleep(2000);
            WebElement loaiPC = driver.findElement(By.xpath("/html/body/div/form/div[3]/div/input[1]"));
            loaiPC.click();
            Thread.sleep(2000);
            WebElement submitPC = driver.findElement(By.xpath("/html/body/div/form/div[4]/button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submitPC);
            Thread.sleep(2000);
            submitPC.click();
            log.info("✔ Success UU32");
        }
        catch (Exception e){
            log.error("❌ Fail UU32: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(31)
    void UU31(){
        log.info("Start UU31:");
        try{
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonLC = driver.findElement(By.xpath("/html/body/div[2]/a[4]/div"));
            buttonLC.click();
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div/div/a"));
            findText("Thêm phòng chiếu");
            log.info("✔ Success UU31");
        }
        catch (Exception e){
            log.error("❌ Fail UU31: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(33)
    void UU33(){
        try{
            Thread.sleep(2000);
            WebElement maPC = driver.findElement(By.xpath("/html/body/div/form/div[1]/input"));
            maPC.sendKeys("");
            Thread.sleep(2000);
            WebElement ghePC = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            ghePC.sendKeys("100");
            Thread.sleep(2000);
            WebElement loaiPC = driver.findElement(By.xpath("/html/body/div/form/div[3]/div/input[1]"));
            loaiPC.click();
            Thread.sleep(2000);
            WebElement submitPC = driver.findElement(By.xpath("/html/body/div/form/div[4]/button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submitPC);
            Thread.sleep(2000);
            submitPC.click();
            log.error("❌ Fail UU33: ");
            Assertions.fail();
        }
        catch (Exception e){
            log.info("✔ Success UU33");
        }
    }

    @Test
    @Order(34)
    void UU34(){
        log.info("Start UU34:");
        log.info("-- Not empty:");
        try {
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[4]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "pcTest");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText("pcTest");
            log.info("✔ Success UU34 (Not empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU34 (Not empty): " + e.getMessage());
            Assertions.fail();
        }

        log.info("-- Empty:");
        try {
            Thread.sleep(2000);
            driver.get(_url_local);
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[2]/a[4]/div"));
            Thread.sleep(2000);
            fillInputField(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/input"), "");
            Thread.sleep(2000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/form/div/button"));
            Thread.sleep(2000);
            findText("pcTest");
            log.info("✔ Success UU34 (Empty)");
        } catch (Exception e) {
            log.error("❌ Fail UU34 (Empty): " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(35)
    void UU35(){
        log.info("Start UU35:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonPC = driver.findElement(By.xpath("/html/body/div[2]/a[5]/div"));
            buttonPC.click();
            Thread.sleep(2000);
            WebElement tablePC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'quocgiaTest')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tablePC);
            Thread.sleep(2000);
            WebElement deleteButtonPC = tablePC.findElement(By.xpath("./td[last()]//a[1]"));
            deleteButtonPC.click();
            Thread.sleep(2000);
            findText("Cập nhật phim");
            log.info("✔ Success UU35");
        }
        catch (Exception e){
            log.error("❌ Fail UU35: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(36)
    void UU36(){
        log.info("Start UU36:");
        try{
            WebElement tenFilm = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            tenFilm.sendKeys("tenfilmTest");
            Thread.sleep(2000);
            WebElement theloaiFilm = driver.findElement(By.xpath("/html/body/div/form/div[3]/input"));
            theloaiFilm.sendKeys("theloaiTest");
            Thread.sleep(2000);
            WebElement daodienFilm = driver.findElement(By.xpath("/html/body/div/form/div[4]/input"));
            daodienFilm.sendKeys("daodienTest");
            Thread.sleep(2000);
            WebElement dienvienFilm = driver.findElement(By.xpath("/html/body/div/form/div[5]/input"));
            dienvienFilm.sendKeys("dienvienTest");
            Thread.sleep(2000);
            WebElement thoiluongFilm = driver.findElement(By.xpath("/html/body/div/form/div[6]/input"));
            thoiluongFilm.sendKeys("12");
            Thread.sleep(2000);
            WebElement motaFilm = driver.findElement(By.xpath("/html/body/div/form/div[7]/textarea"));
            motaFilm.sendKeys("motaCapNhatTest");
            Thread.sleep(2000);
            WebElement ngayraFilm = driver.findElement(By.xpath("/html/body/div/form/div[8]/input"));
            ngayraFilm.sendKeys("12-05-2024");
            Thread.sleep(2000);
            WebElement quocgiaFilm = driver.findElement(By.xpath("/html/body/div/form/div[9]/input"));
            quocgiaFilm.sendKeys("quocgiaTest");
            Thread.sleep(2000);
            WebElement linkposterFilm = driver.findElement(By.xpath("/html/body/div/form/div[10]/input"));
            linkposterFilm.sendKeys("https://www.google.com/url?sa=i&url=https%3A%2F%2Ftu-test-app.myharavan.com%2Fproducts%2Ftest&psig=AOvVaw3Un_TusnXbQlCuVBzyakZM&ust=1733262317892000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMihxbeHiooDFQAAAAAdAAAAABAE");
            Thread.sleep(2000);
            WebElement submitFilm = driver.findElement(By.xpath("/html/body/div/form/div[11]/button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", submitFilm);
            Thread.sleep(2000);
            submitFilm.click();
            log.info("✔ Success UU36");
        }
        catch (Exception e){
            log.error("❌ Fail UU36: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(37)
    void UU37(){
        log.info("Start UU37:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement buttonPC = driver.findElement(By.xpath("/html/body/div[2]/a[5]/div"));
            buttonPC.click();
            Thread.sleep(2000);
            WebElement tablePC = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'quocgiaTest')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tablePC);
            Thread.sleep(2000);
            WebElement deleteButtonPC = tablePC.findElement(By.xpath("./td[last()]//a[1]"));
            deleteButtonPC.click();
            Thread.sleep(2000);
            findText("Cập nhật phim");
            WebElement tenFilm = driver.findElement(By.xpath("/html/body/div/form/div[2]/input"));
            tenFilm.sendKeys("tenfilmTest");
            Thread.sleep(2000);
            WebElement theloaiFilm = driver.findElement(By.xpath("/html/body/div/form/div[3]/input"));
            theloaiFilm.sendKeys("theloaiTest");
            Thread.sleep(2000);
            WebElement daodienFilm = driver.findElement(By.xpath("/html/body/div/form/div[4]/input"));
            daodienFilm.sendKeys("daodienTest");
            Thread.sleep(2000);
            WebElement dienvienFilm = driver.findElement(By.xpath("/html/body/div/form/div[5]/input"));
            dienvienFilm.sendKeys("dienvienTest");
            Thread.sleep(2000);
            WebElement thoiluongFilm = driver.findElement(By.xpath("/html/body/div/form/div[6]/input"));
            thoiluongFilm.sendKeys("0");
            Thread.sleep(2000);
            WebElement motaFilm = driver.findElement(By.xpath("/html/body/div/form/div[7]/textarea"));
            motaFilm.sendKeys("motaCapNhatTest");
            Thread.sleep(2000);
            WebElement ngayraFilm = driver.findElement(By.xpath("/html/body/div/form/div[8]/input"));
            ngayraFilm.sendKeys("12-05-2024");
            Thread.sleep(2000);
            WebElement quocgiaFilm = driver.findElement(By.xpath("/html/body/div/form/div[9]/input"));
            quocgiaFilm.sendKeys("quocgiaTest");
            Thread.sleep(2000);
            WebElement linkposterFilm = driver.findElement(By.xpath("/html/body/div/form/div[10]/input"));
            linkposterFilm.sendKeys("https://www.google.com/url?sa=i&url=https%3A%2F%2Ftu-test-app.myharavan.com%2Fproducts%2Ftest&psig=AOvVaw3Un_TusnXbQlCuVBzyakZM&ust=1733262317892000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMihxbeHiooDFQAAAAAdAAAAABAE");
            Thread.sleep(2000);
            WebElement submitFilm = driver.findElement(By.xpath("/html/body/div/form/div[11]/button"));
            js.executeScript("arguments[0].scrollIntoView(true);", submitFilm);
            Thread.sleep(2000);
            submitFilm.click();
            log.info("✔ Success UU37");
        }
        catch (Exception e){
            log.error("❌ Fail UU37: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(38)
    void UU38(){
        log.info("Start UU38:");
        try{
            clickButton(By.xpath("/html/body/div/form/div[11]/a"));
            if (_url_local.equals(driver.getCurrentUrl())){
                log.info("✔ Success UU38");
            }else {
                log.error("❌ Fail UU38: ");
                Assertions.fail();
            }
        }
        catch (Exception e){
            log.error("❌ Fail UU38: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(39)
    void UU39(){
        log.info("Start UU39:");
        try{
            driver.get(_url_local);
            clickButton(By.xpath("/html/body/div[2]/a[5]/div"));
            Thread.sleep(1000);
            clickButton(By.xpath("/html/body/div[3]/div/div/div[1]/div[2]/div/div/a"));
            Thread.sleep(1500);
            findText("Thêm phim");
            log.info("✔ Success UU39");
        }
        catch (Exception e){
            log.error("❌ Fail UU39: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(40)
    void UU40(){
        log.info("Start UU40:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            WebElement buttonP = driver.findElement(By.xpath("/html/body/div[2]/a[5]/div"));
            buttonP.click();
            Thread.sleep(2000);
            WebElement tableP = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/table/tbody/tr[td[contains(text(), 'quocgiaTest')]]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", tableP);
            Thread.sleep(2000);
            WebElement deleteButtonP = tableP.findElement(By.xpath("./td[last()]//a[2]"));
            deleteButtonP.click();
            log.info("✔ Success UU40");
        }
        catch (Exception e){
            log.error("❌ Fail UU40: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Test
    @Order(41)
    void UU41(){
        log.info("Start UU41:");
        try{
            Thread.sleep(2000);
            driver.get("http://localhost:8080/");
            Thread.sleep(2000);
            WebElement elementToHover = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(elementToHover).perform();
            Thread.sleep(1500);
            WebElement logout = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/a"));
            logout.click();
            Thread.sleep(1500);
            findText("Đăng nhập");
            log.info("✔ Success UU41");
        }
        catch (Exception e){
            log.error("❌ Fail UU41: " + e.getMessage());
            Assertions.fail();
        }
    }

}