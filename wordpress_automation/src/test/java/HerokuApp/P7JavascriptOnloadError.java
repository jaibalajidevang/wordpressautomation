package HerokuApp;
import java.util.Date;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P7JavascriptOnloadError {

	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
        driver = new ChromeDriver();	
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void mytest() {
		driver.get("https://www.google.co.in");
		analyzeLog();
	}
	
	public void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            
        }
    }

}
