package railroad19exericse.railroad19exericse.Base;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import railroad19exericse.railroad19exericse.page.ProjectDashboardPage;

public abstract class ProjectDashBoardBaseTest extends BaseTest{

	HashMap<String, String> map = new HashMap<String,String>();
	
	
	//base test class to test all Project status update
	public void projectStatusUpdateTest(String status) {
		
		
		// this map is for the button lookup so that we are clicking on the correct status 
	    // update option like new: working: etc,,,
		map.put("new:", "1");
		map.put("working:", "2");
		map.put("delivered:", "3");
		map.put("archived:", "4");	
			
		
		String buttonToClick = map.get(status);
		
		ProjectDashboardPage projectDashboard = new ProjectDashboardPage(driver);
		List<WebElement> projectCards = projectDashboard.findProjectCard();
		
		String projectCardStatus = driver.findElement(By.className("projectCard__statusChip")).getText();
		
		
		List<WebElement> preProjectStatus = projectDashboard.getProjectStatusElement();
		int preCount = projectDashboard.getProjectCount(preProjectStatus, status);
		driver.findElement(By.xpath("//*[@id=\"mat-chip-list-0\"]/div/mat-chip")).click();
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[" + buttonToClick +"]")).click();
		
		//*[@id="cdk-overlay-3"]/div/div/button[1]
		List<WebElement> postProjectStatus = projectDashboard.getProjectStatusElement();
		
		int postCount = projectDashboard.getProjectCount(postProjectStatus, status);
		
		if(projectCardStatus.toLowerCase().contains(status.replace(":", ""))) {
			assertTrue(postCount-preCount == 0);
		}
		else
		{
			assertTrue(postCount-preCount == 1);
		}
		
		driver.navigate().refresh();
	}

	
	
}
