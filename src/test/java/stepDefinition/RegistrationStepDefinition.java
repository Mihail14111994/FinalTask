package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class RegistrationStepDefinition extends DriverFactory {
    private WebDriver driver = newDriver();
    public String workingEmail;
    public String workingPassword;

    @Given("Fest.md page is displayed")
    public void festMdPageIsDisplayed() {
        driver.get("https://www.fest.md/en");
        driver.manage().window().maximize();
    }

    @Given("Login page is displayed")
    public void loginPageIsDisplayed() {
//        driver.get("https://www.fest.md/en/login-register");
//        driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
        WebElement uacc = driver.findElement(By.xpath("//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded register hidden-on-tablet']"));
        uacc.click();
        driver.getPageSource();
//        driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-small btn-switch-register active']")).click();
    }


    @When("Submit (.*), (.*) and confirm password in registration form")
    public void submitEmailPasswordAndConfirmPasswordInRegistrationForm(String email, String password) {
//        WebDriverWait wait = new WebDriverWait(driver, 20);
        workingEmail=email;
        workingPassword=password;
        WebElement emailField = driver.findElement(By.xpath("//input[@id='formRegisterUser_email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='formRegisterUser_password']"));
        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='formRegisterUser_passwordConfirm']"));
        System.out.println(emailField.isDisplayed());
        System.out.println(passwordField.isDisplayed());
        System.out.println(confirmPasswordField.isDisplayed());
        driver.findElement(By.xpath("//form[@id='formRegisterUser']//div[@class='form-description']"));
//        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='formRegisterUser_email']"))).click();
//        Actions act = new Actions(driver);
//        int width = emailField.getSize().getWidth();
//        act.moveToElement(emailField).moveByOffset((width/2)-2, 0).click().perform();
        emailField.click();
        emailField.sendKeys(email);

        passwordField.click();
        passwordField.sendKeys(password);
        confirmPasswordField.click();
        confirmPasswordField.sendKeys(password);
        WebElement register = driver.findElement(By.xpath("//button[@id='formRegisterUser_btn-submit']"));
        register.click();
    }
    @Then("Home page is displayed")
    public void homePageIsDisplayed() {
        MatcherAssert.assertThat(driver.getPageSource().contains("Login"), is(true));
    }

    @And("Register is successful")
    public void registerIsSuccessful() {
        driver.get("https://www.fest.md/ro/user/account");
        MatcherAssert.assertThat(driver.getPageSource().contains(workingEmail), is(true));
        WebElement uacc = driver.findElement(By.xpath("//div[contains(@class, 'float-right')]//div[@class='bar-item inlined username']"));
        uacc.click();
        WebElement logout = driver.findElement(By.xpath("//*[@id='header']/div[2]/div[1]/ul/li[4]/a"));
        logout.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.fest.md/en/login-register");
        driver.get("https://www.fest.md/en/login-register");
        WebElement emailField = driver.findElement(By.xpath("//*[@id='formRegister_email']"));
        emailField.click();
        emailField.sendKeys(workingEmail);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='formRegister_password']"));
        WebElement confirmPasswordField = driver.findElement(By.xpath("//*[@id='formRegister_passwordConfirm']"));
        passwordField.click();
        passwordField.sendKeys("password");
        confirmPasswordField.click();
        confirmPasswordField.sendKeys("password");
        WebElement register = driver.findElement(By.xpath("//*[@id='formRegister_btn-submit']"));
        register.click();
        teardown();
    }

    @When("Account was deleted")
    public void accountWasDeleted() {
        driver.get("https://www.fest.md/en/login-register");
        WebElement email = driver.findElement(By.xpath("//*[@id='formLogin_email']"));
        email.click();
        email.sendKeys("test2@gma.ru");
        WebElement pass = driver.findElement(By.xpath("//*[@id='formLogin_password']"));
        pass.click();
        pass.sendKeys("123123");
        driver.findElement(By.xpath("//*[@id='formLogin_btn-submit']")).click();
        driver.getPageSource();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement uacc = driver.findElement(By.xpath("//div[contains(@class, 'float-right')]//div[@class='bar-item inlined username']"));
        uacc.click();
        driver.findElement(By.xpath("//*[@id='header']/div[2]/div[1]/ul/li[2]/a")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id='btn-delete-account']")).click();
        driver.getPageSource();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement passw = driver.findElement(By.xpath("//*[@id='formDeleteAccount_currentPassword']"));
        passw.click();
        passw.sendKeys("123123");
        WebElement delete11 = driver.findElement(By.xpath("//*[@id='formDeleteAccount_btn-submit']"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        delete11.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }

    @And("Checked that account was deleted")
    public void checkedThatAccountWasDeleted() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.fest.md/en/login-register");
        driver.get("https://www.fest.md/en/login-register");
        driver.get("https://www.fest.md/en/login-register");
        WebElement email1 = driver.findElement(By.xpath("//*[@id='formLogin_email']"));
        email1.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        email1.sendKeys("test2@gma.ru");
        WebElement pass1 = driver.findElement(By.xpath("//*[@id='formLogin_password']"));
        pass1.click();
        pass1.sendKeys("123123");
        driver.findElement(By.xpath("//*[@id='formLogin_btn-submit']")).click();
        teardown();
    }
}