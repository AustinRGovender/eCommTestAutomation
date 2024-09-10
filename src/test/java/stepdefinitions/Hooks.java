package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import utils.ExtentReportManager;
import utils.WebDriverManager;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
    protected static WebDriver driver;
//    private static ExtentReports extentReports = ExtentReportManager.getReporter();

    @Before
    public void setUp() throws Exception {
        driver = WebDriverManager.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot on failure
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
            String screenshotPath = "target/screenshots/" + scenario.getName() + ".png";

            try {
                // Save screenshot to file
                Files.createDirectories(Paths.get("target/screenshots"));
                Files.write(Paths.get(screenshotPath), screenshotBytes);

                // Add screenshot to Extent Report
//                ExtentCucumberAdapter.addTestStepLog("Screenshot on failure:");
//                ExtentCucumberAdapter.addScreenCaptureFromPath(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverManager.quitDriver();
    }
}
