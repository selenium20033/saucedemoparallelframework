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

public class RemovingAnItemFromTheChart extends CommonMethods {

	
	Saucedemo demo;
	
	@When("I click on remove button")
	public void i_click_on_remove_button() throws InterruptedException {
		demo=new Saucedemo();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.removeItemButton)); 
		click(demo.removeItemButton);
		minSync();
	}

	@When("I click on continue shopping button")
	public void i_click_on_continue_shopping_button() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.continueShoppingButton)); 
		click(demo.continueShoppingButton);
		minSync();
	}

	@When("I verify that home page is displayed")
	public void i_verify_that_home_page_is_displayed() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(demo.logo));
		minSync();
	   Boolean display=demo.logo.isDisplayed();
	   Assert.assertTrue(display);
	}	
}
	
	