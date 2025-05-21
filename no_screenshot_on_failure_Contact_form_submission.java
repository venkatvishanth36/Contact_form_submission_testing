package Contact_form_submission_testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.text.SimpleDateFormat;
import java.util.Date;

public class no_screenshot_on_failure_Contact_form_submission {
	public static void main(String[]args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	try {
		driver.get("https://www.globalsqa.com/contact-us/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment-name"))); //this line has error
		name.sendKeys("John");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("johndoe@example.com");
		
		WebElement subject = driver.findElement(By.id("subject"));
		subject.sendKeys("Test Subject");
		
		WebElement message = driver.findElement(By.id("comment"));
		message.sendKeys("This is a Selenium automated test message.");
		
        System.out.println("🛑 Form filled. Please manually complete the CAPTCHA to proceed.");
        
        // Uncomment below only if CAPTCHA is disabled or bypassed
         //WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
        //submit.click();

	}catch (Exception e){
		System.out.println("! Error occured: " + e.getMessage());
		takeScreenshot(driver, "ContactFormError");	
	}finally {
		driver.quit();
	}
	}
	
	public static void takeScreenshot(WebDriver driver, String fileName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File dest = new File("screenshots/" + fileName + "_" + timestamp + ".png");
            dest.getParentFile().mkdirs(); // Ensure the directory exists
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("📸 Screenshot saved to: " + dest.getAbsolutePath());
        } catch (IOException ioException) {
            System.out.println("⚠️ Failed to save screenshot: " + ioException.getMessage());
		}
	}

}
