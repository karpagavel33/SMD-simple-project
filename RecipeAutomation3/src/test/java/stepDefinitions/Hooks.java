package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
               
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//                scenario.attach(screenshot, "image/png", "Failure Screenshot");

                
                String featureName = scenario.getUri().getPath()
                        .replaceAll(".*/", "")    
                        .replace(".feature", ""); 

                String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");

               
                String screenshotDir = "target/ExtentReport/screenshots/"
                        + featureName + "/" + scenarioName + "/";
                Files.createDirectories(Paths.get(screenshotDir));

               
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String screenshotPath = screenshotDir + featureName + "_" + timestamp + "_FAILED.png";

                
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(file.toPath(), Paths.get(screenshotPath));

                System.out.println("Failure screenshot saved at: " + screenshotPath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void teardown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
