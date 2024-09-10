package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class WebDriverManager {

    private static WebDriver driver;
    private static Properties properties = new Properties();

    static {
        try (InputStream input = WebDriverManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
               // return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static WebDriver getDriver() throws Exception {
        if (driver == null) {
            String baseUrl = properties.getProperty("base.url");
            boolean runOnGrid = Boolean.parseBoolean(properties.getProperty("run.on.grid"));
            String gridUrl = properties.getProperty("grid.url");
            String browser = properties.getProperty("browser");

            if (runOnGrid) {
//                driver = new RemoteWebDriver(new URL(gridUrl), DesiredCapabilities.chrome());
            } else {
                switch (browser.toLowerCase()) {
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver.path"));
                        driver = new ChromeDriver();
                        break;
                    case "edge":
                        System.setProperty("webdriver.edge.driver", properties.getProperty("edge.driver.path"));
                        driver = new EdgeDriver();
                        break;
                    case "firefox":
                        System.setProperty("webdriver.gecko.driver", properties.getProperty("firefox.driver.path"));
                        driver = new FirefoxDriver();
                        break;
                    default:
                        throw new IllegalArgumentException("Browser not supported: " + browser);
                }
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
