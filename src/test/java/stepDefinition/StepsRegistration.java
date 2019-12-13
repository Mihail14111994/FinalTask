package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class StepsRegistration extends DriverFactory {
    private WebDriver driver = newDriver();

//    @Given("Fest.md page is displayed")
//    public void festMdPageIsDisplayed() {
//        driver.get("https://www.fest.md/en/login-register");
//        driver.manage().window().maximize();
//    }

    @When("Click on {string} header")
    public void clickOnHeader(String arg0) {
        WebElement registration = driver.findElement(By.xpath("//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded login']"));
        registration.click();
    }

    @When("Fill in {} at email field")
    public void fillInEmail(String s) {
        driver.getPageSource();
        WebElement email = driver.findElement(By.xpath("//*[@id='formRegister_email']"));
        email.click();
        email.sendKeys(s);
    }

    @And("Fill in {} and confirm {}")
    public void fillInPasswordAndConfirmPassword(String pass, String confpass) {
        WebElement password = driver.findElement(By.xpath("//*[@id='formRegister_password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id='formRegister_passwordConfirm']"));
        password.click();
        password.sendKeys(pass);
        confirmPassword.click();
        confirmPassword.sendKeys(confpass);
    }

    @And("Click on Register button")
    public void clickOnButton() {
        WebElement register = driver.findElement(By.xpath("//*[@id='formRegister_btn-submit']"));
        register.click();
    }

    @And("Click on user account header")
    public void clickOnUserAccountHeader() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement uacc = driver.findElement(By.xpath("//div[contains(@class, 'float-right')]//div[@class='bar-item inlined username']"));
//        System.out.println(uacc.isDisplayed());
        uacc.click();
//        System.out.println("2");
    }

    @And("Click on Logout button")
    public void clickOnLogoutButton() {

        WebElement logout = driver.findElement(By.xpath("//*[@id='header']/div[2]/div[1]/ul/li[4]/a"));

        logout.click();
    }

//    @Then("Home page is displayed")
//    public void homePageIsDisplayed() {
//        MatcherAssert.assertThat(driver.getPageSource().contains("Login"), is(true));
//    }

    @Then("See error")
    public void seeError() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean b =driver.findElement(By.xpath("//*[@id='formRegister_email_field']/div/span")).isDisplayed();
        MatcherAssert.assertThat(driver.getPageSource().contains("Adresa de email introdusă nu este validă."), is(true));
    }

    @Then("the following elements are visible")
    public void theFollowingElementsAreVisible(DataTable element) {
        List<String> list = element.asList();
        for(int i=0; i< list.size()-1;i++) {
            switch (list.get(i)) {
                case ("Register title"):
                    driver.findElement(By.xpath("//*[@id='formRegisterUser']/div[1]/h2")).isDisplayed();
                    break;
                case ("Email field"):
                    driver.findElement(By.xpath("//*[@id='formRegisterUser_email']")).isDisplayed();
                    break;
                case ("Password field"):
                    driver.findElement(By.xpath("//*[@id='formRegisterUser_password']")).isDisplayed();
                    break;
                case ("Confirm password field"):
                    driver.findElement(By.xpath("//*[@id='formRegisterUser_passwordConfirm']")).isDisplayed();
                    break;
                case ("Register button"):
                    driver.findElement(By.xpath("//*[@id='formRegisterUser_btn-submit']")).isDisplayed();
                    break;
                case ("Login button"):
                    driver.findElement(By.xpath("//*[@id='formLoginOrRegister']/div[2]/div[1]/button[1]")).isDisplayed();
                    break;
                case ("Login with facebook button"):
                    driver.findElement(By.xpath("//*[@id='formLoginOrRegister']/div[2]/button")).isDisplayed();
                    break;
                case ("Recieve newletter checkbox"):
                    driver.findElement(By.xpath("//*[@id='formRegisterUser_subscribeNewsletter']")).isDisplayed();
                    driver.findElement(By.xpath("//*[@id='formRegisterUser_subscribeNewsletter_field']/label")).isDisplayed();
                    break;
            }
            System.out.println(i);
        }
    }

    @When("Click on {string} header{int}")
    public void clickOnHeader(String arg0, int arg1) {
        WebElement uacc = driver.findElement(By.xpath("//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded register hidden-on-tablet']"));
        uacc.click();
        System.out.println("2");
    }

    @Then("the following elements are visible1")
    public void theFollowingElementsAreVisible1(DataTable elements) {
        List<String> list = elements.asList();
        for(int i=0; i< list.size()-1;i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    driver.findElement(By.xpath("//*[@id='formLoginUser']/div[1]/h2")).isDisplayed();
                    break;
                case ("Email field"):
                    driver.findElement(By.xpath("//*[@id='formLoginUser_email']")).isDisplayed();
                    break;
                case ("Password field"):
                    driver.findElement(By.xpath("//*[@id='formRegisterUser_password']")).isDisplayed();
                    break;
                case ("Register button"):
                    driver.findElement(By.xpath("//*[@id='formLoginOrRegister']/div[2]/div[1]/button[2]")).isDisplayed();
                    break;
                case ("Login button"):
                    driver.findElement(By.xpath("//*[@id='formLoginUser_btn-submit']")).isDisplayed();
                    break;
                case ("Login with facebook button"):
                    driver.findElement(By.xpath("//*[@id='formLoginOrRegister']/div[2]/button")).isDisplayed();
                    break;
                case ("Forgot password link"):
                    driver.findElement(By.xpath("//*[@id='formLoginUser_forgot-password']/a")).isDisplayed();
                    break;
            }
            System.out.println(i);
        }

    }



    @And("Fill password in Current Password field")
    public void fillPasswordInCurrentPasswordField() {
        String s="123123";
        WebElement pass = driver.findElement(By.xpath("//*[@id='formLogin_password']"));
        pass.click();
        pass.sendKeys(s);
    }

    @And("Click on Login button")
    public void clickOnLoginButton() {
        driver.findElement(By.xpath("//*[@id='formLogin_btn-submit']")).click();
    }

    @And("Click on My Account button")
    public void clickOnMyAccountButton() {
        driver.findElement(By.xpath("//*[@id='header']/div[2]/div[1]/ul/li[2]/a")).click();
    }

    @And("Click on Delete account link")
    public void clickOnDeleteAccountLink() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id='btn-delete-account']")).click();
    }

    @And("Fill in current password in the window")
    public void fillInCurrentPasswordInTheWindow() {
        driver.getPageSource();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement passw = driver.findElement(By.xpath("//*[@id='formDeleteAccount_currentPassword']"));
        passw.click();
        passw.sendKeys("123123");
    }

    @And("Click on Delete account button")
    public void clickOnDeleteAccountButton() {
        WebElement delete11 = driver.findElement(By.xpath("//*[@id='formDeleteAccount_btn-submit']"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println(delete11.isDisplayed());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        delete11.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("SUCCESS");
    }

    @When("And Fill in email at email field1")
    public void andFillInEmailAtEmailField() {
        String s="test2@gma.ru";
        WebElement email = driver.findElement(By.xpath("//*[@id='formLogin_email']"));
        email.click();
        email.sendKeys(s);
    }

    @When("Language changed to English")
    public void languageChangedToEnglish() {
        driver.findElement(By.xpath("//*[@id='languages']/a[1]")).click();
    }
}
