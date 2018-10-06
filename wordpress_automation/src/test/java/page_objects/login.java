package page_objects;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class login {

	@BeforeClass
	void setUp() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8000/");
		
	}
	@Test
	void login() {
		
	}
}
