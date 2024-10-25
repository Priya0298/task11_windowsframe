package windows_frame;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iframetest {

    public static void main(String[] args) {
        // Choose the browser you want to use (uncomment the desired browser)
        WebDriver driver = new FirefoxDriver();

        // Open browser and navigate to the URL
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();

        // Switch to the iframe using CSS Selector
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));

        // Locate the TinyMCE editor inside the iframe
        WebElement editorBody = driver.findElement(By.id("tinymce"));
        System.out.println("Is element enabled: " + editorBody.isEnabled());
        System.out.println("Is element displayed: " + editorBody.isDisplayed());

        // Use JavaScript to set the content of the TinyMCE editor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerHTML = '<p>Hello People</p>';", editorBody);

        // Switch back to the main content
        driver.switchTo().defaultContent();

        // Close the browser
        driver.close();
    }
}