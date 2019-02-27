package railroad19exericse.railroad19exericse;

import railroad19exericse.railroad19exericse.Base.ProjectDashBoardBaseTest;
import org.testng.annotations.Test;


public class ProjectDashboardTests extends ProjectDashBoardBaseTest{

	@Test 
	public void ProjectStatusNewTest() {
		String status = "new:";		
		projectStatusUpdateTest(status);
	}

	@Test 
	public void ProjectStatusWorkingTest() {
		String status = "working:";		
		projectStatusUpdateTest(status);
	}

	@Test 
	public void ProjectStatusDeliveredTest() {
		String status = "delivered:";		
		projectStatusUpdateTest(status);
	}
	
	@Test 
	public void ProjectStatusArchivedTest() {
		String status = "archived:";		
		projectStatusUpdateTest(status);
	}
	

}
