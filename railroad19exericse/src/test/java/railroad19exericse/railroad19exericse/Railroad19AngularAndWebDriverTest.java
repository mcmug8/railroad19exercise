package railroad19exericse.railroad19exericse;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class Railroad19AngularAndWebDriverTest {
	
	 private ChromeDriver driver;
	 private NgWebDriver ngWebDriver;
	
	@BeforeSuite
	public void before_suite() throws Exception{
		driver = new ChromeDriver();
		ngWebDriver = new NgWebDriver(driver);
	}

	
	@AfterSuite
	public void after_suite() throws Exception {
		driver.quit();
	}
		
	
	@BeforeMethod
    public void resetBrowser() {
        driver.get("about:blank");
    }

}
