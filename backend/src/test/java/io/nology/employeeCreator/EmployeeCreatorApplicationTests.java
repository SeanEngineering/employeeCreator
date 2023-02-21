package io.nology.employeeCreator;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest
class EmployeeCreatorApplicationTests {
	ChromeDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/sean/Desktop/chromedriver_mac_arm64/chromedriver");
		 driver = new ChromeDriver();
		 driver.get("http://localhost:5173/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 
	}
	
	@Test
	//READ
	public void verifyUserCanBeCreated() {
		WebElement addEmployee = driver.findElement(By.xpath("//button[normalize-space()='Add employee']"));
		addEmployee.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		System.out.println(firstName.getSize());
		WebElement middleName = driver.findElement(By.xpath("//input[@id='middleName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement phone = driver.findElement(By.xpath("//input[@id='phone']"));
		WebElement address = driver.findElement(By.xpath("//input[@id='address']"));
		WebElement employeeStatus = driver.findElement(By.xpath("//input[@id='permanent']"));
		WebElement startDay = driver.findElement(By.xpath("//input[@id='startDay']"));
		Select startMonth = new Select(driver.findElement(By.xpath("//select[@id='startMonth']")));
		WebElement startYear = driver.findElement(By.xpath("//input[@id='startYear']"));
		WebElement finishDay = driver.findElement(By.xpath("//input[@id='finishDay']"));
		Select finishMonth = new Select(driver.findElement(By.xpath("//select[@id='finishMonth']")));
		WebElement finishYear = driver.findElement(By.xpath("//input[@id='finishYear']"));
		WebElement fullTime = driver.findElement(By.xpath("//input[@id='fullTime']"));
		WebElement hoursPerWeek = driver.findElement(By.xpath("//input[@id='hoursPerWeek']"));
		
		
		firstName.sendKeys("John");
		middleName.sendKeys("Major");
		lastName.sendKeys("Doe");
		email.sendKeys("johndoe@email.com");
		phone.sendKeys("041234856");
		address.sendKeys("29 Washington Street");
		employeeStatus.click();
		startDay.clear();
		startDay.sendKeys("21");
		startMonth.selectByVisibleText("February");
		startYear.clear();
		startYear.sendKeys("2023");
		finishDay.clear();
		finishDay.sendKeys("18");
		finishMonth.selectByVisibleText("March");
		finishYear.clear();
		finishYear.sendKeys("2025");
		fullTime.click();
		hoursPerWeek.clear();
		hoursPerWeek.sendKeys("37.5");
		
		WebElement saveButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		saveButton.click();
		
		WebDriverWait waitDriver = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		

		//p[normalize-space()='Submitted']
		
//		WebElement addEmployeeCheck = driver.findElement(By.xpath("//button[normalize-space()='Add employee']"));
//		addEmployeeCheck.click();
		
		

//		assertTrue(thisList.size() == 2);

		
	}
	
	@Test
	public void verifyInputsAreNull() {
		WebElement addEmployee = driver.findElement(By.xpath("//button[normalize-space()='Add employee']"));
		addEmployee.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.click();
		assertTrue(firstName.getText() == "");
	}
//	
//	@Test
//	void contextLoads() {
//		assertTrue(true);
//	}
//	
	@AfterMethod
	public void tearDown(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		
	}
	
	



}
