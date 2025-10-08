package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Capture screenshot as Base64
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Create folder if not exists
            String dest = "target/ExtentReport/screenshots/" + screenshotName + ".png";
            Files.createDirectories(Paths.get("target/ExtentReport/screenshots/"));

            // Copy file
            File destination = new File(dest);
            Files.copy(source.toPath(), destination.toPath());

            return dest; // return path to be used in report
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
