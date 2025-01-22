package Org.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Basecls.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositiveandNegative extends Baseclass
{
    
@Given("User has to launch the browser and maximise the window")
public void user_has_to_launch_the_browser_and_maximise_the_window() 
{
    launchBrowser();
    windowMaximize();
 // Explicit wait with a timeout of 60 seconds
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

}
@When("User has to hit the Facebook url")
public void user_has_to_hit_the_facebook_url() {
	launchUrl("https://www.facebook.com/");
}

@When("User has to pass the data {string} in email field")
public void user_has_to_pass_the_data_in_email_field(String str) 
{
	WebElement email = driver.findElement(By.id("email"));
	passText(str, email);
}

@When("User has to pass the data {string} in password field")
public void user_has_to_pass_the_data_in_password_field(String string) 
{
	WebElement pass = driver.findElement(By.id("pass"));
	passText(string, pass);
}

@When("User has to click login button")
public void user_has_to_click_login_button() 
{
	WebElement login = driver.findElement(By.name("login"));
	clickBtn(login);   
}
@When("To check the Valid user or not")
public void to_check_the_valid_user_or_not() throws InterruptedException {
	Thread.sleep(5000);
    try {
        // Check if an error message is displayed (indicates unsuccessful login)
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Login unsuccessful: Invalid user.");
        }
    } catch (Exception e) {
        // If no error message is found, assume login is successful
        try {
            WebElement profile = driver.findElement(By.xpath("//div[@aria-label='Account']")); // Example: Profile icon
            if (profile.isDisplayed()) {
                System.out.println("Login successful: Valid user.");
            }
        } catch (Exception ex) {
            System.out.println("Login status could not be verified.");
        }
    }
}
@Then("User has to close the browser")
public void user_has_to_close_the_browser() 
{
 
	closeBrowser();
}
}
