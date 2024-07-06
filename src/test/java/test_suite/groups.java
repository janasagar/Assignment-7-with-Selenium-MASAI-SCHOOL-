package test_suite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class groups {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test(priority = 1, groups = "radio_functional")
	public void radio1() {
		WebElement r1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		r1.click();
	}
	@Test(priority = 2, groups = "checkbox_functional")
	public void checkbox1() {
		WebElement c_box1 = driver.findElement(By.id("checkBoxOption1"));
		c_box1.click();
		if(c_box1.isSelected()) {
			c_box1.click();
		}
	}
	
	@Test(priority = 1, groups = "radio_functional")
	public void radio_bt() {
		List<WebElement> r_bts = driver.findElements(By.className("radioButton"));
		for(WebElement r_bt : r_bts) {
			r_bt.click();
		}
	}
	
	@Test(priority = 2, groups = "checkbox_functional")
	public void Checkbox() {
		List<WebElement> boxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
		int j=0;
		while(j<=1) {
			for(WebElement box:boxes) {
				box.click();
			}
			j++;
		}
		
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
