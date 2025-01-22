package Pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basecls.Baseclass;	

public class FbsignPojo extends Baseclass
{
public FbsignPojo() 
 {
PageFactory.initElements(driver, this);
}

@FindBy(xpath ="//a[text()='Create new account']")
private WebElement createNewAc;

@FindBy(xpath = "(//input[@type='text'])[1]")
private WebElement Firstname;

@FindBy(name = "lastname")
private WebElement surname;

@FindBy(name = "reg_email__")
private WebElement email;

@FindBy(name = "reg_passwd__")
private WebElement Newpass;

public WebElement getCreateNewAc() {
	return createNewAc;
}

public void setCreateNewAc(WebElement createNewAc) {
	this.createNewAc = createNewAc;
}

public WebElement getFirstname() {
	return Firstname;
}

public void setFirstname(WebElement firstname) {
	Firstname = firstname;
}

public WebElement getSurname() {
	return surname;
}

public void setSurname(WebElement surname) {
	this.surname = surname;
}

public WebElement getEmail() {
	return email;
}

public void setEmail(WebElement email) {
	this.email = email;
}

public WebElement getNewpass() {
	return Newpass;
}

public void setNewpass(WebElement newpass) {
	Newpass = newpass;
}
}
