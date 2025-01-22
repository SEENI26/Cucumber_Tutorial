package FacebookRegistration;

import java.util.List;
import java.util.Map;

import Basecls.Baseclass;
import Pojo.FbsignPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.*;
public class FbReg extends Baseclass
{
	FbsignPojo s;	
	@Given("To launch the browser and maximise the window")
	public void to_launch_the_browser_and_maximise_the_window() 
	{
	    launchBrowser();
	    windowMaximize();
	}

	@When("To launch Url of FB application")
	public void to_launch_url_of_fb_application() 
	{
		launchUrl("https://www.facebook.com/");
	}

	@When("To click the create new account button")
	public void to_click_the_create_new_account_button() 
	{    
		s= new FbsignPojo();
		clickBtn(s.getCreateNewAc());
	}

	@When("To pass firstname in the firstname text field")
	public void to_pass_firstname_in_the_firstname_text_field(DataTable d) throws InterruptedException 
	{
		Thread.sleep(2000);
		Map<String, String> m = d.asMap(String.class, String.class);
		s = new FbsignPojo();
		passText(m.get("firstname2"), s.getFirstname());
	}

	@When("To pass secondname in the surname text field")
	public void to_pass_secondname_in_the_surname_text_field() 
	{
		s = new FbsignPojo();
	    passText("sri", s.getSurname());
	}

	@When("To pass mobile number or email in the email text box")
	public void to_pass_mobile_number_or_email_in_the_email_text_box(DataTable d) throws InterruptedException
	{
		Thread.sleep(1000);
		List<Map<String, String>> r = d.asMaps();
		s = new FbsignPojo();
		passText(r.get(1).get("email2"), s.getNewpass());
	}

	@When("Create a new password in the New Password text box")
	public void create_a_new_password_in_the_new_password_text_box() 
	{
		s = new FbsignPojo();
		passText("sgn667@", s.getNewpass());
	}

	@Then("To close the Chrome browser")
	public void to_close_the_chrome_browser() 
	{
	closeBrowser();    
	}

}
