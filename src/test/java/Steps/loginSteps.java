package Steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	
	

	WebDriver driver = null;

	@Given("Browser is Open")
	public void browserIsOpen() {
		System.setProperty("Webdriver.chrome.driver", "C:/Users/hp/eclipse-workspace/fall2022Quiz/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@And("User is on a login page")
	public void userIsOnALoginPage() {
		driver.navigate().to("https://classic.freecrm.com/index.html?fbclid=IwAR1WS47bAeUE-sjdRmVZfw1lEilPdbUQrAYaodKfgw5mQj_pBMoZF");		
	}
	
	

	@When("User enters the username , and the password")
	public void userEntersTheUsernameAndThePassword() throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("sondoshijab");
		driver.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(2000);
	}



	@And("click on the login button")
	public void clickOnTheLoginButton() {
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
	}
	@Then("User is navigated to the home page")
	public void userIsNavigatedToTheHomePage() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
		boolean s1 = driver.getPageSource().contains("User: Sondos Hijab");
		assertTrue(s1);
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}






}
