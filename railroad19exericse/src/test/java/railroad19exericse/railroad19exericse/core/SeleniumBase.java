package railroad19exericse.railroad19exericse.core;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class SeleniumBase {

	protected String pageTitle;
	WebDriver driver;
	public WebDriverWait wait;
	
	public String baseUrl;
	
		
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}


	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	public WebDriver instantiateBrowser(String browser, String url) throws MalformedURLException{

		driver = getBrowserDriver(browser);
		wait = new WebDriverWait(driver, 45);
		setBaseUrl(url);
		driver.get(getBaseUrl());

		driver.manage().window().maximize();
		return driver;

	}

	
	public WebDriver getBrowserDriver(String browser ) throws MalformedURLException{
		DesiredCapabilities capability;
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.SEVERE);
		System.setProperty("webdriver.gecko.driver","C:\\Dev\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		if(browser.equalsIgnoreCase("FIREFOX")){		
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("IE8")){
			driver = new InternetExplorerDriver();
		}
	
		else{		
			driver = new ChromeDriver();
		}
	
		return driver;
	}

	public void waitForPjax(WebDriver driver) {
		//
		final JavascriptExecutor executor= (JavascriptExecutor)driver;
		ExpectedCondition<Boolean> pageLoadCondition = new
		ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (executor.executeScript("NProgress.status").equals("null"));
			}};
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(pageLoadCondition);
	}
	
	public void waitForDocumentReadyState(WebDriver driver) {
		//
		final JavascriptExecutor executor= (JavascriptExecutor)driver;
		ExpectedCondition<Boolean> pageLoadCondition = new
		ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (executor.executeScript("return document.readyState").equals("complete"));
			}};
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(pageLoadCondition);
	}

}
