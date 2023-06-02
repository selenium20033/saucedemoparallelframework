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

public class MakingAPurchase extends CommonMethods {

	
	Saucedemo demo;
	
	@When("I add an item to the chart")
	public void i_add_an_item_to_the_chart() throws InterruptedException {
		demo=new Saucedemo();
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.addToChartButton)); 
		click(demo.addToChartButton);
		minSync();
	}

	@When("I click on chart icon")
	public void i_click_on_chart_icon() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.shoppingChartButton)); 
		click(demo.shoppingChartButton);
		minSync();
	}

	@When("I click on checkout button")
	public void i_click_on_checkout_button() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.checkoutButton)); 
		click(demo.checkoutButton);
		minSync();
	}

	@When("I enter the info")
	public void i_enter_the_info() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(demo.firstnameTextbox));
		sendText(demo.firstnameTextbox, "John");
		sendText(demo.lastnameTextbox, "Doe");
		sendText(demo.postalcodeTextbox, "72600");
		minSync();
	}

	@When("I click on continue button")
	public void i_click_on_continue_button() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.checkoutContinueButton)); 
		click(demo.checkoutContinueButton);
		minSync();
	}

	@When("I click on finish button")
	public void i_click_on_finish_button() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.finishButton)); 
		click(demo.finishButton);
		minSync();
	}

	@Then("I verify that success message is displayed")
	public void i_verify_that_success_message_is_displayed() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(demo.successLogo));
		minSync();
	   Boolean display=demo.successLogo.isDisplayed();
	   Assert.assertTrue(display);
	}
}
