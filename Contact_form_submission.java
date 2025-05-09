package Contact_form_submission_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Contact_form_submission {
	public static void main (String[]args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("https://www.globalsqa.com/contact-us/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WebElement name =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment_name")));
			name.sendKeys("John");
			
			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("johndoe@example.com");
			
			WebElement subject = driver.findElement(By.id("subject"));
			subject.sendKeys("Test Subject");
			
			WebElement message = driver.findElement(By.id("comment"));
			message.sendKeys("This is a Selenium automated test message.");
			
			System.out.println("🛑 Form filled. Please manually complete the CAPTCHA to proceed.");
			
			 // Uncomment below only if CAPTCHA is disabled or bypassed in a test environment
            //WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
            //submit.click();
			
		}catch(Exception e){
			System.out.println("❗ Error occurred: " + e.getMessage());	
		}finally {
			driver.quit();
		}
	}

}
