package com.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddToCart {
	
	@FindBy(how=How.XPATH,using="//div[@id='cart-badge']")
	WebElement addToCartIcon;
	
	@FindBy(how=How.XPATH,using="//a[@class='button continue']")
	WebElement continueShopping;

	@FindBy(how=How.XPATH,using="(//img[@src='https://www.ulcdn.net/media/slideshow/Slideshow_Sofabeds_1_02082019.jpg?1564743090'])[1]")
	WebElement sofaIcon;

	@FindBy(how=How.XPATH,using="//img[@title='Fujiwara Bed (Teak Finish, King Bed Size)']")
	WebElement secondIcon;

	@FindBy(how=How.XPATH,using="//button[@id='add-to-cart-button']")
	WebElement addToCartText;
	 public void clickOnAddToCartIcon() {
		 addToCartIcon.click();

	}
	public void clickOnContinueShopping() {
		continueShopping.click();

	}
	public void clickOnSofaIcon() {
		sofaIcon.click();

	}
	public void clickOnSecondIcon() {
		secondIcon.click();

	}
	public void clickOnAddToCartText() {
		addToCartText.click();

	}
}
