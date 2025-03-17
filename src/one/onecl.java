package one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class onecl {

    public static void main(String... args) {
       System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        // Step 2: Wait for the username field to be visible and enter username
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='username']")));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // Enter demo username and password
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");

        // Click the login button
        loginButton.click();

        // Step 3: Verify navigation to the homepage
        try {
            Thread.sleep(3000); // Wait for a few seconds for the page to load
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("dashboard")) {
                System.out.println("Login successful. Navigated to home page.");
            } else {
                System.out.println("Login failed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
           // driver.quit();
        }


    }


}
