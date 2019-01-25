

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class runOnChrome {
	
	WebDriver driver;
	
	@Before
	public void SetupApplication(){
		//Use the Google Chrome's driver to launch the Chrome browser
		
		String exePath = "//Users//mac//ToolsQA//chromedriver";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();		

		//Launch the Chrome browser and navigate to website
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestSearchInWiki(){
		
		driver.get("http://www.wikipedia.org");
		driver.manage().window().maximize();
	
		WebElement searchBox, myLanguage;
		
		//Click the English option in the home page
		//myLanguage = driver.findElement(By.partialLinkText("/web/"));
		myLanguage = driver.findElement(By.id("js-link-box-en"));
		myLanguage.click();
		
		//Click the search box in Wikipeida and type in Software Quality for search result
		searchBox = driver.findElement(By.id("searchInput"));
		searchBox.sendKeys("Software Quality");
		searchBox.submit();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Software quality - Wikipedia";
		
		if(actualTitle.contentEquals(expectedTitle)){
			System.out.println("test passed!");
			
		} else {
			System.out.println("fail" + actualTitle);
			Assert.assertEquals("Software quality - Wikipedia", "please check the string");
			
		}
	}
	
	@Test
	public void checkURL(){
		
		driver.get("https://login.yahoo.com");
		driver.manage().window().maximize();
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://login.yahoo.com/";
		
		if(actualURL.contentEquals(expectedURL)){
			System.out.println("test passed! expected URL is: " + expectedURL);
		} else {
			System.out.println("fail actual URL is: " + actualURL);	
		}
		
	}
	
	@Test
	public void checkPageSource(){
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		
		String PageSource = driver.getPageSource();
		
		System.out.println("test pass and here is the source code of the page: " + PageSource);
		
	}
	
	@Test
	public void TestFillWebForm(){
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
		
				
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test frist Name");
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("test last Name");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
		
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("test12345");
		
		driver.findElement(By.xpath("//*[@id=\"ppaFormSbtBtn\"]")).click();
		
	}
	
	@Test
	public void TestUserInput(){
		
		Scanner input = new Scanner(System.in);
		
		int number1, number2, result;
		
		System.out.println("Enter a number1");
		
		number1 = input.nextInt();
		
		System.out.println("The number input by the user is: " + number1);
		
		
		System.out.println("Enter a number2");
		
		number2 = input.nextInt();
		
		System.out.println("The number input by the user is: " + number2);
		
		result = number1+number2;
		
		System.out.println("number 1 + number 2 = " + result);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestCheckBox(){
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
		
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("test12345");
		
		System.out.println("test checkbox");
		
		driver.findElement(By.xpath("//*[@id=\"showPASSWORD\"]/ul/li/span[1]/input")).click();
		
		if(driver.findElement(By.xpath("//*[@id=\"showPASSWORD\"]/ul/li/span[1]/input")).isSelected()){
			System.out.println("The show password checkbox is clicked and enabled");
		} else{
			System.out.println("The show password checkbox is not clicked and disabled");
			Assert.assertEquals("Test fail due to the password checkbox was clicked but not selected");
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestRadioButton(){
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
		
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("test12345");
		
		System.out.println("test checkbox");
		
		driver.findElement(By.xpath("//*[@id=\"showPASSWORD\"]/ul/li/span[1]/input")).click();
		
		if(driver.findElement(By.xpath("//*[@id=\"showPASSWORD\"]/ul/li/span[1]/input")).isSelected()){
			System.out.println("The show password checkbox is clicked and enabled");
		} else{
			System.out.println("The show password checkbox is not clicked and disabled");
			Assert.assertEquals("Test fail due to the password checkbox was clicked but not selected");
		}
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestImplicitWait(){
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		//ImplicitWait for 10 secondes
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
		
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("test12345");
		
		System.out.println("test checkbox");
		
		driver.findElement(By.xpath("//*[@id=\"showPASSWORD\"]/ul/li/span[1]/input")).click();
		
		if(driver.findElement(By.xpath("//*[@id=\"showPASSWORD\"]/ul/li/span[1]/input")).isSelected()){
			System.out.println("The show password checkbox is clicked and enabled");
		} else{
			System.out.println("The show password checkbox is not clicked and disabled");
			Assert.assertEquals("Test fail due to the password checkbox was clicked but not selected");
		}
	}
	
	@Test
	public void TestExplicitWait(){
		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"gh-ug-flex\"]/a")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='PASSWORD']")));
		
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("test12345");
	}
	
	@Test
	public void TestPopUp(){
		
		driver.get("https://www.allegiantair.com/");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//button[@role='button']")).click();
		
		boolean checkButton = false;
		
		try{
			checkButton = driver.findElement(By.xpath("//button[@role='button']")).isDisplayed();
			
		} catch (Exception e){
			
		}
		 
		if(checkButton == true){
			driver.findElement(By.xpath("//button[@role='button']")).click();
		}
		
		driver.findElement(By.xpath("//*[@id=\"mini-panel-g4_account_menu\"]/ul/li[4]/a/span")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"edit-first-name\"]")));
		
		driver.findElement(By.xpath("//*[@id=\"edit-first-name\"]")).sendKeys("test12345");
	}
	
	@Test
	public void loops(){
		for(int i =0; i<1 ; i ++){
			SetupApplication();
			TestPopUp();
			endApplication();
			System.out.println("number :" + i);
		}
	}
	
	
	
	@After
	public void endApplication(){
		//Exit the Google Chrome
		//driver.close();
		driver.quit();
	}
	

}

