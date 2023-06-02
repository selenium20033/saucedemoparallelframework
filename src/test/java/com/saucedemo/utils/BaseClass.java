package com.saucedemo.utils;

import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	

	public static WebDriver driver;
	public static JavascriptExecutor jsDriver;
	public static NgWebDriver ngDriver;
	public static ChromeOptions options;
	
	public static WebDriver switchToChromeHeadless() {
		
		//"--startMaximized" ; "--window-size=1500,850" ; "--headless"
		
        options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--disable-gpu", "--startMaximized", "--ignore-certificate-errors");
        
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("--incognito");
		Map<String, Object> preferences = new HashMap<String, Object>();
		preferences.put("enable_do_not_track", true);
		options.setExperimentalOption("prefs", preferences);
	
        final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        desiredCapabilities.setCapability("newCommandTimeout", 1000);
        driver = new ChromeDriver(options);
        System.setProperty("java.awt.headless", "true");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        System.out.println("Headless mode:  " + ge.isHeadless()); 
        return driver;
        
        
    }
	
public static WebDriver switchToFirefoxHeadless() {
		
	     FirefoxOptions options = new FirefoxOptions();
         options.setHeadless(true);
         driver = new FirefoxDriver(options);
         System.setProperty("java.awt.headless", "true");
         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
         System.out.println("Headless mode:  " + ge.isHeadless()); 
         return driver;
        
    }

public static WebDriver switchToEdgeHeadless() {
	
	WebDriverManager.edgedriver().setup();
	EdgeOptions edgeOptions = new EdgeOptions().merge(options);
	DesiredCapabilities capabilities = DesiredCapabilities.edge();
	
	edgeOptions.merge(capabilities);
	edgeOptions.getCapability("headless");
	edgeOptions.getCapability("disable-gpu");
	edgeOptions.setCapability("UseChromium",true);
	edgeOptions.setCapability("-inprivate",true);
	edgeOptions.setCapability("headless",true);
	edgeOptions.setCapability("disable-gpu",true);
   
	
	System.setProperty("java.awt.headless", "true");
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    System.out.println("Headless mode:  " + ge.isHeadless());
    driver = new EdgeDriver(edgeOptions);
    return driver;
   
}

public static  WebDriver  incognitoRun() {
	
	ChromeOptions options = new ChromeOptions();
	//options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	options.setPageLoadStrategy(PageLoadStrategy.NONE);
	options.addArguments("--incognito");
	Map<String, Object> preferences = new HashMap<String, Object>();
	preferences.put("enable_do_not_track", true);
	options.setExperimentalOption("prefs", preferences);
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	driver=new ChromeDriver(capabilities);
	return driver;
	
        }

	public static void setUp() {
		
		ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
		String browserName = ConfigsReader.getProperty("browser");
			
		if (browserName.equalsIgnoreCase("chrome")) {
			
			if (Constants.OS_NAME.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver");
			} else if (Constants.OS_NAME.contains("Windows")) {
				//System.setProperty("java.awt.headless", "true");
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
			} else if (Constants.OS_NAME.contains("Linux")) {
				System.setProperty("java.awt.headless", "true");
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/linux/chromedriver");
			}
		
			
			//switchToChromeHeadless();
			//driver = new ChromeDriver();
			incognitoRun();
			
			jsDriver= (JavascriptExecutor) driver;
			ngDriver=new NgWebDriver (jsDriver);
		
					
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			if (Constants.OS_NAME.contains("Mac")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/mac/geckodriver");
			} else if (Constants.OS_NAME.contains("Windows")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/windows/geckodriver.exe");
			} else if (Constants.OS_NAME.contains("Linux")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/geckodriver");
			}
			
			//switchToFirefoxHeadless();
			driver = new FirefoxDriver();
					
		} else if (browserName.equalsIgnoreCase("safari")) {
				
			if (Constants.OS_NAME.contains("Mac")) {
				// System.setProperty("webdriver.safari.driver","src/test/resources/drivers/safaridriver");
			} else if (Constants.OS_NAME.contains("Windows")) {
				// System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
			} else if (Constants.OS_NAME.contains("Linux")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriverforlinux");
			}
			
			driver = new SafariDriver();
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			
			if (Constants.OS_NAME.contains("Mac")) {
				// System.setProperty("webdriver.safari.driver","src/test/resources/drivers/safaridriver");
			} else if (Constants.OS_NAME.contains("Windows")) {
				System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/windows/msedgedriver.exe");
				
			} else if (Constants.OS_NAME.contains("Linux")) {
				// System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriverforlinux");
			}
			
			switchToEdgeHeadless();
			//driver = new EdgeDriver();

		} else {
			System.out.println("browser given is wrong");
		}

		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
		
		
		driver.manage().deleteAllCookies();
		driver.get(ConfigsReader.getProperty("url"));
		driver.manage().window().setSize(new Dimension(1500, 850));
		//driver.manage().window().fullscreen();
		JSWaiter.setDriver(driver);
	}

	public static void tearDown() {
		driver.quit();
	}
	
}