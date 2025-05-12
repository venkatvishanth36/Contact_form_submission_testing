package Contact_form_submission_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Assertion_contact_form_submission {
	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            System.out.println("🔍 Navigating to contact form...");
            driver.get("https://www.globalsqa.com/contact-us/");

            // Fill out the form
            System.out.println("✏️ Filling in Name...");
            WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comment_name")));
            name.sendKeys("John");

            System.out.println("📧 Filling in Email...");
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("johndoe@example.com");

            System.out.println("📝 Filling in Subject...");
            WebElement subject = driver.findElement(By.id("subject"));
            subject.sendKeys("Test Subject");

            System.out.println("💬 Filling in Message...");
            WebElement message = driver.findElement(By.id("comment"));
            message.sendKeys("This is a Selenium automated test message.");

            System.out.println("🛑 Form filled. Please manually complete the CAPTCHA to proceed.");

            // Uncomment below if CAPTCHA is bypassed
            // WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
            // submit.click();

            // Optional Assertion Example: Look for the confirmation box (if CAPTCHA is bypassed)
            /*
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".wpcf7-response-output")));
            if (successMessage.getText().toLowerCase().contains("thank")) {
                System.out.println("✅ Form submitted successfully!");
            } else {
                System.out.println("❌ Unexpected confirmation text: " + successMessage.getText());
            }
            */

        } catch (Exception e) {
            System.out.println("❗ Error occurred during form submission: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("🔚 Test ended. Browser closed.");
        }
    }
}

