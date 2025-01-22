package Org.stepdefinition;

import Basecls.Baseclass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooksclass extends Baseclass
{
	@Before
	//precondition
	private void precondition() 
	{
		launchBrowser();
		windowMaximize();
	}
	
	@After
	//Postcondition
	private void postcondition() 
	{
		closeBrowser();
	}
}
