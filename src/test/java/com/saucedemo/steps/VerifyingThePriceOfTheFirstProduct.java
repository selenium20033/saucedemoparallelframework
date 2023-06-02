package com.saucedemo.steps;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.pages.Saucedemo;
import com.saucedemo.utils.CommonMethods;
import com.saucedemo.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class VerifyingThePriceOfTheFirstProduct extends CommonMethods {

	Saucedemo demo;
	
	@Then("I verify that the the price of the first product is higher that twenty dollars")
	public void i_verify_that_the_the_price_of_the_first_product_is_higher_that_twenty_dollars() {
		demo=new Saucedemo();
		String price=demo.inventoryItemPrice.getText().replaceAll("[^0-9]", ""); 
		//Converting String into int using Integer.parseInt()  
		int newPrice=Math.round(Integer.parseInt(price)); 
		System.out.println();
		Boolean verify=newPrice>20;
		Assert.assertTrue(verify);
		
	}
}

	