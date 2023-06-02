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

public class LoginFailure extends CommonMethods {

	
	Saucedemo demo;
	
	@When("I enter an invalid username")
	public void i_enter_an_invalid_username() throws InterruptedException {
demo=new Saucedemo();
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(demo.username));
		sendText(demo.username, "locked_out_user");
		minSync();
	}

	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(demo.password));
		sendText(demo.password, "invalid pass");
		minSync();
	}

	@When("I submit the invalid credentials")
	public void i_submit_the_invalid_credentials() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(demo.loginButton)); 
		click(demo.loginButton);
		minSync();
	}

	@Then("I verify that the error message is displayed")
	public void i_verify_that_the_error_message_is_displayed() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(demo.errorMessage));
		minSync();
	   Boolean display=demo.errorMessage.isDisplayed();
	   Assert.assertTrue(display);
	}


	
}
	
	/*
	
	@When("I enter the valid username")
	public void i_enter_the_valid_username() throws InterruptedException {
		
		
		
	}

	@When("I enter the valid password")
	public void i_enter_the_valid_password() throws InterruptedException {
		
	}

	@When("I click on submit button")
	public void i_click_on_submit_button() throws InterruptedException {
		
	}

	@Then("I verify that the user home page is displayed")
	public void i_verify_that_the_user_home_page_is_displayed() throws InterruptedException {
		
	}

	
	
}

	*/