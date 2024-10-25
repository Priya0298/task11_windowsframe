package windows_frame;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesTest {
	
	// Set the path to chromedriver.exe
    // System.setProperty("Webdriver.gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win64.exe");
    public static void main(String[] args) {
        
    	WebDriver driver = new FirefoxDriver();
       
        // Open browser and navigate to the URL
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.manage().window().maximize();

        // Switch to the top frame
        driver.switchTo().frame("frame-top");

        // Verify that there are three frames on the page
        int frameCount = driver.findElements(By.tagName("frame")).size();
        if (frameCount == 3) {
            System.out.println("There are three frames on the page.");
        } else {
            System.out.println("There are NOT three frames on the page.");
        }

        // Switch to the left frame
        driver.switchTo().frame("frame-left");

        // Verify that the left frame has a text "LEFT"
        WebElement leftFrameText = driver.findElement(By.tagName("body"));
        String leftText = leftFrameText.getText();
        if (leftText.contains("LEFT")) {
            System.out.println("Left frame has text 'LEFT'.");
        } else {
            System.out.println("Left frame does NOT have text 'LEFT'.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");

        // Switch to the middle frame
        driver.switchTo().frame("frame-middle");

        // Verify that the middle frame has text "MIDDLE"
        WebElement middleFrameText = driver.findElement(By.tagName("body"));
        String middleText = middleFrameText.getText();
        if (middleText.contains("MIDDLE")) {
            System.out.println("Middle frame has text 'MIDDLE'.");
        } else {
            System.out.println("Middle frame does NOT have text 'MIDDLE'.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");

        // Switch to the right frame
        driver.switchTo().frame("frame-right");

        // Verify that the right frame has a text "RIGHT"
        WebElement rightFrameText = driver.findElement(By.tagName("body"));
        String rightText = rightFrameText.getText();
        if (rightText.contains("RIGHT")) {
            System.out.println("Right frame has text 'RIGHT'.");
        } else {
            System.out.println("Right frame does NOT have text 'RIGHT'.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");

        // Switch to the bottom frame
        driver.switchTo().frame("frame-bottom");

        // Verify that the bottom frame has a text "BOTTOM"
        WebElement bottomFrameText = driver.findElement(By.tagName("body"));
        String bottomText = bottomFrameText.getText();
        if (bottomText.contains("BOTTOM")) {
            System.out.println("Bottom frame has text 'BOTTOM'.");
        } else {
            System.out.println("Bottom frame does NOT have text 'BOTTOM'.");
        }

        // Switch back to the top frame
        driver.switchTo().defaultContent();

        // Verify that the page title is "Frames"
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Frames")) {
            System.out.println("Page title is 'Frames'.");
        } else {
            System.out.println("Page title is NOT 'Frames'.");
        }

        // Close the browser
        driver.close();
    }
}