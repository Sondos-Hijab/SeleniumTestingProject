package Steps;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class massegesSteps {

	WebDriver driver = null;

	@Given("you are in the homepage")
	public void youAreInTheHomepage() throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver", "C:/Users/hp/eclipse-workspace/fall2022Quiz/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://classic.freecrm.com/index.html?fbclid=IwAR1WS47bAeUE-sjdRmVZfw1lEilPdbUQrAYaodKfgw5mQj_pBMoZF");		
		driver.findElement(By.name("username")).sendKeys("sondoshijab");
		driver.findElement(By.name("password")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/input")).click();
	}
	@When("user click in the messages button")
	public void userClickInTheMessagesButton() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
		driver.findElement(By.xpath("//*[@id=\"navMenu\"]/ul/li[8]/a")).click();
		
	}
	@When("clicks in a new message")
	public void clicksInANewMessage() {
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/input")).click();
	}
	@When("User enters message subject and description")
	public void userEntersMessageSubjectAndDescription() throws InterruptedException {
		
		driver.findElement(By.name("subject")).sendKeys("message subject");
		driver.findElement(By.name("msg")).sendKeys("Hello raghad and sondos");
		Thread.sleep(2000);
	}
	@When("click on the post button")
	public void clickOnThePostButton() {
		driver.findElement(By.xpath("//*[@id=\"CFForm_1\"]/input[6]")).click();
	}
	@Then("User is navigated to the board of messages page")
	public void userIsNavigatedToTheBoardOfMessagesPage() throws InterruptedException {
		boolean s1 = driver.getPageSource().contains("message subject");/*.contains("message subject");*/
		assertTrue(s1);
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}




}
