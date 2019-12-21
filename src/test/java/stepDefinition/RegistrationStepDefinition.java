package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepImplementation.RegisterSteps;

import java.io.IOException;

public class RegistrationStepDefinition {

    public String workingEmail;
    public String workingPassword;
    RegisterSteps registerSteps = new RegisterSteps();

    @When("Register page is displayed")
    public void registerPageIsDisplayed() throws InterruptedException, IOException {
        registerSteps.openRegisterWindow();
    }

    @When("Submit (.*), (.*) and confirm password in registration form")
    public void submitEmailPasswordAndConfirmPasswordInRegistrationForm(String email, String password) throws InterruptedException, IOException {
        workingEmail = email;
        workingPassword = password;
        Thread.sleep(1000);
        registerSteps.fillDataInEmailPasswordFieldsRegister(email, password);
        registerSteps.clickRegisterButton();
    }

    @Then("Home page is displayed")
    public void homePageIsDisplayed() throws IOException {
        registerSteps.checkThatHomePageIsDisplayed();
    }

    @And("User unable to register with the same credentials")
    public void registerIsSuccessful() throws IOException {
        registerSteps.makeLogout();
        registerSteps.openRegisterWindow();
        registerSteps.fillDataInEmailPasswordFieldsRegister(workingEmail, workingPassword);
        registerSteps.clickRegisterButton();
        registerSteps.checkFailingRegisterWithTheSameCredentials();
    }

    @When("Account with (.*) and (.*) was deleted")
    public void accountWasDeleted(String email, String password) throws IOException {
        workingEmail = email;
        workingPassword = password;
        registerSteps.openLoginWindow();
        registerSteps.fillDataInEmailPasswordFieldsLogin(email, password);
        registerSteps.clickLoginButton();
        registerSteps.getMyAccountPage();
        registerSteps.deleteAccount();

    }

    @And("Checked that account was deleted")
    public void checkedThatAccountWasDeleted() throws IOException {
        registerSteps.openLoginWindow();
        registerSteps.fillDataInEmailPasswordFieldsLogin(workingEmail, workingPassword);
        registerSteps.clickLoginButton();
        registerSteps.checkThatAccWasDeleted();
    }

    @Then("Registration fails with (.*) message")
    public void registrationFailsWithErrorMessage(String errorMessage) throws IOException {
        registerSteps.checkingErrorMessages(errorMessage);
    }

    @Then("the following elements are visible on Register page")
    public void theFollowingElementsAreVisible(DataTable element) throws IOException {
        registerSteps.checkingUIRegister(element);
    }

    @When("Login page is displayed")
    public void loginPageIsDisplayed() throws IOException {
        registerSteps.openLoginWindow();
    }

    @Then("the following elements are visible on Login page")
    public void theFollowingElementsAreVisibleOnLoginPage(DataTable elements) throws IOException {
        registerSteps.checkinUILogin(elements);

    }

    @When("Register_Login page is displayed")
    public void registerLoginPageIsDisplayed() {
        registerSteps.getLoginRegisterPage();
    }

    @Then("the following elements are visible on Register_Login page")
    public void theFollowingElementsAreVisibleOnRegisterLoginPage(DataTable elements) throws IOException {
        registerSteps.checkingUILoginRegisterPage(elements);
    }
}