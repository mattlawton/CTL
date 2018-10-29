package mattgroupid.mattartifactid;

import java.util.ArrayList;
import java.util.List;

public class Manager {

	// Values stored under a Manager object
	
	private int developers = 0;
	private List<String> managers = new ArrayList<String>();
	private int QAtesters = 0;
	
	private String name;
	
	public Manager(String name) {
		this.name = name;
	}
	
	public int getDevelopers() {
		return developers;
	}
	public void setDevelopers(int developers) {
		this.developers = developers;
	}
	public List<String> getManagers() {
		return managers;
	}
	public void setManagers(List<String> managers) {
		this.managers = managers;
	}
	public int getQAtesters() {
		return QAtesters;
	}
	public void setQAtesters(int qAtesters) {
		QAtesters = qAtesters;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addDeveloper() {
		this.developers++;
	}
	
	public void addQATester() {
		this.QAtesters++;
	}
	
	public void removeDeveloper() {
		this.developers--;
	}
	
	public void removeQATester() {
		this.QAtesters--;
	}
	
	// Do a check for a repeated manager addition
	public boolean addManager(String name) {
		boolean valid = true;
		
		if (this.name.equalsIgnoreCase(name)) return false;
		
		for (String m : this.getManagers()) {
			if (m.equalsIgnoreCase(name))
				valid = false;
		}
		
		if (valid) {
			this.managers.add(name);
			return true;
	}
		return false;
	}
	
	// Will be invalid if the name isn't found
	public boolean removeManager(String name) {
		boolean valid = true;
		for (String m : this.getManagers()) {
			if (m.equalsIgnoreCase(name))
				valid = true;
		}
		if (valid) {
			this.managers.remove(name);
			return true;
	}
		return false;
	}
}
