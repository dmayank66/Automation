package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginDemo {
// We are using cucumber
	WebDriver driver = null;

	@SuppressWarnings("deprecation")
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("inside step-browser is open");

		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is-:" + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		driver.findElement(By.id("name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		
	}

	@And("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
        driver.findElement(By.id("logout")).isDisplayed();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        //cucumber is used
	}
}
