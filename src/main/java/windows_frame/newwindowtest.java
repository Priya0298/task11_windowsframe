package windows_frame;
import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class newwindowtest {
	
	// Set the path to chromedriver.exe
    // System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win64.exe");
    public static void main(String[] args) {
      
        WebDriver driver = new FirefoxDriver();
        

        // Open browser and navigate to the URL
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        // Click the "Click Here" button to open a new window
        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();

        // Get the window handles (IDs)
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the newly opened window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Verify that the text "New Window" is present on the page
        String expectedText = "New Window";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement newTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        String actualText = newTextElement.getText();
        if (actualText.equals(expectedText)) {
            System.out.println("Text 'New Window' is present on the page.");
        } else {
            System.out.println("Text 'New Window' is NOT present on the page.");
        }

        // Close the new window
        driver.close();

        // Switch back to the original window
        driver.switchTo().window(originalWindowHandle);

        // Verify that the original window is active
        String title = driver.getTitle();
        if (title.equals("The Internet")) {
            System.out.println("Original window is active.");
        } else {
            System.out.println("Original window is NOT active.");
        }

        // Close the browser instance
        driver.close();
    }
}
	
	