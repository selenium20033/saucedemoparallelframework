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

public class DisplayingHomePageInventory extends CommonMethods {

	Saucedemo demo;
	
	@Then("I validate that home page inventory is displayed")
	public void i_validate_that_home_page_inventory_is_displayed() {
	    demo=new Saucedemo();
	    List<WebElement> inventory = driver.findElements(By.xpath("//img[@class='inventory_item_img']"));
		int size= inventory.size();
		System.out.println(size);
		Boolean verify=(size==6);
		Assert.assertTrue(verify);
	}
	
}
	
	