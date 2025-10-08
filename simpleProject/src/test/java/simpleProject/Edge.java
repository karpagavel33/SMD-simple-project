package simpleProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("http://192.168.5.62:7001/configurator/feeding/feedingpoints");
	}
}
