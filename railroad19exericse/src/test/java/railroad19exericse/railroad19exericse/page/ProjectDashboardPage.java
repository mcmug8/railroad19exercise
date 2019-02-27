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
	
	
	public List<WebElement> findProjectCard(){
		WebElement projectCardElement = driver.findElement(By.className("dashboard__projects"));
		List<WebElement> projectElements = projectCardElement.findElements(By.className("ng-star-inserted"));
		return projectElements;
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
	
	public int getProjectCount(List<WebElement> el, String projectStatus) {
		
		int num = 0;
		
		for(WebElement e:el) {
			String status = e.findElement(By.className("stats__statusName")).getText();
			if(status.equalsIgnoreCase(projectStatus)) {
				num =Integer.parseInt( e.findElement(By.className("stats__statusCount")).getText());
			}
		}
		
		return num;
		
	}

}
