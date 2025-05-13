package Contact_form_submission_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Addwait_contact_form_submission {
	public static void main (String[]args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://www.globalsqa.com/contact-us/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment_name")));
			name.sendKeys("John");

			Thread.sleep(1000); // Optional: simulate realistic typing delay

			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
			email.sendKeys("johndoe@example.com");

			WebElement subject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subject")));
			subject.sendKeys("Test Subject");

			WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment")));
			message.sendKeys("This is a Selenium automated test message.");

			System.out.println("🛑 Form filled. Please manually complete the CAPTCHA to proceed.");

			// If CAPTCHA is disabled or bypassed
			// WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit']")));
			// submit.click();

		} catch (Exception e) {
			System.out.println("❗ Error occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
