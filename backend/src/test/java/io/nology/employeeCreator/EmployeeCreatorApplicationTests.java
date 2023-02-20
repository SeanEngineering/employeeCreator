package io.nology.employeeCreator;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
//import org.testng.annotations.AfterMethod;

@SpringBootTest
class EmployeeCreatorApplicationTests {
	ChromeDriver driver;
	
	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/sean/Desktop/chromedriver_mac_arm64/chromedriver");
		 driver = new ChromeDriver();
		 driver.get("http://localhost:5173/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
	}
	
	@Test
	public void verifyFieldIsEmpty() {
		WebElement addEmployee = driver.findElement(By.xpath("//button[normalize-space()='Add employee']"));
		addEmployee.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		assertTrue(firstName.getText() == "");
	}
	
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@AfterEach
	public void tearDown(){
		driver.quit();
		
	}



}
