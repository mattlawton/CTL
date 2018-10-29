package mattgroupid.mattartifactid;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AppTests {
	
//Needs more tests, Mockito implementation
	@Test
	public void addDeveloperSuccess() {
	
		App.Managers.add(new Manager("Mock"));
			for (Manager m : App.Managers) {
				if (m.getName().equalsIgnoreCase("Mock")) {
					m.addDeveloper();
				}
				Assert.assertTrue(m.getDevelopers() > 0);
			}
	}
	
	@Test
	public void addQATesterSuccess() {
	
		App.Managers.add(new Manager("Mock"));
			for (Manager m : App.Managers) {
				if (m.getName().equalsIgnoreCase("Mock")) {
					m.addQATester();
				}
				Assert.assertTrue(m.getQAtesters() > 0);
			}
	}
	
	@Test
	public void addManager() {
	
		boolean found = false;
				
		App.Managers.add(new Manager("Mock"));
			for (Manager m : App.Managers) {
				if (m.getName().equalsIgnoreCase("Mock")) {
					found = true;
				}
				Assert.assertTrue(found);
			}
	}
	
	@Test
	public void restartSuccessTest() {
		
		
		App.Managers.add(new Manager("Mock"));
		Util.assignEmployee("Mock", "Developer", "Add");
		Util.assignEmployee("Mock", "QATester", "Add");
		ConsoleMethods.doRestart();
		Assert.assertTrue(App.Managers.isEmpty());
	}
	
	//TODO: Deleting, each type
	//		Calculate
	//		Managers assigned to themselves
	//		Duplicate managers
	//		More
	
}
