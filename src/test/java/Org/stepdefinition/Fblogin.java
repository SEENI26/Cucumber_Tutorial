package Org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Basecls.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Fblogin extends Baseclass
{
@Given("To launch the chrome browser and maximise window")
public void to_launch_the_chrome_browser_and_maximise_window() {
 launchBrowser();
 windowMaximize();
}

@When("To launch thr url of the facebook application")
public void to_launch_thr_url_of_the_facebook_application() {
launchUrl("https://www.facebook.com/");
}

@When("To pass valid username in email field")
public void to_pass_valid_username_in_email_field() 
{
WebElement email = driver.findElement(By.id("email"));
email.sendKeys("srin87@gmail.com");
}

@When("To pass invalid password in password field")
public void to_pass_invalid_password_in_password_field() 
{
WebElement pass = driver.findElement(By.id("pass"));
pass.sendKeys("seeni78$");
}

@When("To click the login button")
public void to_click_the_login_button() 
{
WebElement login = driver.findElement(By.name("login"));
clickBtn(login);
}

@When("To check whether navigate to the home page or not")
public void to_check_whether_navigate_to_the_home_page_or_not() 
{
System.out.println("To check login");
}

@Then("To close the browser")
public void to_close_the_browser() 
{
closeBrowser();
}
}
