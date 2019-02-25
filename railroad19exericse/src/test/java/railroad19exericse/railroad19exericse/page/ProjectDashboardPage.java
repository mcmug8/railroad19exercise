package railroad19exericse.railroad19exericse.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectDashboardPage {
	
	WebDriver driver;
	
	
	public ProjectDashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public List<WebElement> getProjectStatusElement(){
		
		WebElement statusElement = driver.findElement(By.className("stats__status"));
		
		List<WebElement> projectStatusElements = statusElement.findElements(By.className("stats__statusRow"));
		return projectStatusElements;
	}
	
	public List<WebElement> getProjectOwnerElement(){
		
		WebElement statusElement = driver.findElement(By.className("stats__ownerTable"));
		
		List<WebElement> projectOwnerElements = statusElement.findElements(By.tagName("td"));
		return projectOwnerElements;
	}
	
	public List<WebElement> getDivisionBudgetElement(){
		
		WebElement statusElement = driver.findElement(By.className("stats__divisions"));
		
		List<WebElement> projectOwnerElements = statusElement.findElements(By.className("stats__statusRow"));
		return projectOwnerElements;
	}
	
	

}
