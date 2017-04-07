package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {
    WebDriver driver = new ChromeDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();          
    } 

    @Given("^new user is selected$")
    public void new_user_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();          
    } 

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^incorrect username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_incorrect_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @When("^correct username \"([^\"]*)\" and correct password \"([^\"]*)\" and correct password confirmation \"([^\"]*)\" are given$")
    public void username_correct_and_correct_password_and_correct_password_confirmation_are_given(String username, String password, String password_confirmation) throws Throwable {
        enterUserData(username, password, password_confirmation);
    }

    @When("^correct username \"([^\"]*)\" and correct password \"([^\"]*)\" and different password confirmation \"([^\"]*)\" are given$")
    public void username_correct_and_correct_password_and_different_password_confirmation_are_given(String username, String password, String password_confirmation) throws Throwable {
        enterUserData(username, password, password_confirmation);
    }

    @When("^incorrect username \"([^\"]*)\" and correct password \"([^\"]*)\" and correct password confirmation \"([^\"]*)\" are given$")
    public void username_incorrect_and_correct_password_and_correct_password_confirmation_are_given(String username, String password, String password_confirmation) throws Throwable {
        enterUserData(username, password, password_confirmation);
    }

    @When("^taken username \"([^\"]*)\" and correct password \"([^\"]*)\" and correct password confirmation \"([^\"]*)\" are given$")
    public void username_taken_and_correct_password_and_correct_password_confirmation_are_given(String username, String password, String password_confirmation) throws Throwable {
        enterUserData(username, password, password_confirmation);
    }

    @When("^correct username \"([^\"]*)\" and too short password \"([^\"]*)\" and too short password confirmation \"([^\"]*)\" are given$")
    public void username_correct_and_short_password_and_short_password_confirmation_are_given(String username, String password, String password_confirmation) throws Throwable {
        enterUserData(username, password, password_confirmation);
    }

    @When("^correct username \"([^\"]*)\" and password containing only letters \"([^\"]*)\" and the same password confirmation are given$")
    public void username_correct_and_letters_only_password_and_same_password_confirmation_are_given(String username, String password) throws Throwable {
        enterUserData(username, password, password);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }
    
    @Then("^user is created$")
    public void user_is_created() throws Throwable {
        pageHasContent("Welcome to Ohtu Application");
    }
    
    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }     

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String error_message) throws Throwable {
        pageHasContent(error_message);
        pageHasContent("Create username and give password");
    }     
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 

    private void enterUserData(String username, String password, String password_confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password_confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();  
    } 

}
