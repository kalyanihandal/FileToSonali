package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver lDriver;
	public LoginPage(WebDriver rDriver ) {
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	/*@FindBy(how=How.XPATH,using="//a[@class='close-reveal-modal hide-mobile']")
	WebElement popUp;
	
	
	@FindBy(how=How.XPATH,using="//a[text()='Log In']")
	WebElement loginButton;
	*/
	@FindBy(how=How.XPATH,using="//a[text()='Log-in']")
	WebElement loginText;
	
	/*@FindBy(how=How.XPATH,using="//input[@placeholder='Email Address*']")
	WebElement email;*/
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Email Address']")
	WebElement email;
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@value='Log In']")
	WebElement loginButton;
	
	@FindBy(how=How.XPATH,using="//span[@class='header-icon-link user-profile-icon']")
	WebElement profileLogin;

	@FindBy(how=How.XPATH,using="//a[text()='Logout']")
	WebElement logout;
	
	@FindBy(how=How.XPATH,using="//a[text()='Log In']")
	WebElement againLogin;
	/*public void closePopUp() {
		popUp.click();

	}
	public void clickOnProfileLoginButton() {
		profileLogin.click();
	}
	
	public void clickOnLogin() {
		loginButton.click();

	}
*/
	public void clickLoginText() {
		loginText.click();
	}
	
	public void enterEmail(String emailID) {
		email.sendKeys(emailID);
	}
	
	public void enterPassword(String passwrd) {
		password.sendKeys(passwrd);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickProfileLogin() {
		profileLogin.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void againLogin() {
		againLogin.click();
	}
	
	private void m1() {
		// TODO Auto-generated method stub

	}
	}
