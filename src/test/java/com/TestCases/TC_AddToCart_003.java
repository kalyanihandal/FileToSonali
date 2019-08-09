package com.TestCases;

import org.testng.annotations.Test;

import com.PageObject.AddToCart;

public class TC_AddToCart_003{
	@Test(dependsOnMethods={"TC_Login_001"})
	public static void Add() {
		AddToCart add=new AddToCart();
		add.clickOnAddToCartIcon();
		add.clickOnContinueShopping();
		add.clickOnSofaIcon();
		add.clickOnSecondIcon();
		add.clickOnAddToCartText();
	}
	
}
