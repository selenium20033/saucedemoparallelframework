package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.BaseClass;
import com.saucedemo.utils.CommonMethods;

public class Saucedemo extends BaseClass {

	// locating WebElement using @FindBy annotation

	@FindBy(xpath = "//input[@id='user-name']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='app_logo']")
	public WebElement logo;
	
	@FindBy(xpath = "//*[@data-test='error']")
	public WebElement errorMessage;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	public WebElement addToChartButton;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	public WebElement shoppingChartButton;
	
	@FindBy(xpath = "//button[@id='checkout']")
	public WebElement checkoutButton;
	
	@FindBy(xpath = "//input[@id='first-name']")
	public WebElement firstnameTextbox;
	
	@FindBy(xpath = "//input[@id='last-name']")
	public WebElement lastnameTextbox;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	public WebElement postalcodeTextbox;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement checkoutContinueButton;
	
	@FindBy(xpath = "//button[@id='finish']")
	public WebElement finishButton;
	
	@FindBy(xpath = "//img[@class='pony_express']")
	public WebElement successLogo;
	
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	public WebElement removeItemButton;
	
	@FindBy(xpath = "//button[@id='continue-shopping']")
	public WebElement continueShoppingButton;
	
	@FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
	public WebElement inventoryItemPrice;
	
	// initialize all of our variables

	public Saucedemo() {
		PageFactory.initElements(driver, this);

	}

}
