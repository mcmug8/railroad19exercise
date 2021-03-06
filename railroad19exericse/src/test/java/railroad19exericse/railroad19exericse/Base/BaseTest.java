package railroad19exericse.railroad19exericse.Base;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import railroad19exericse.railroad19exericse.core.SeleniumBase;

public  class BaseTest extends SeleniumBase{

	protected WebDriver driver;
	
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void init(String browser, String url) throws MalformedURLException {
		
		driver = instantiateBrowser(browser, url);
	}
	
	
	@AfterClass
	public void TearDown() {
		driver.close();
	}
	

}
