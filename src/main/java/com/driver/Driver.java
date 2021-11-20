package com.driver;

import com.constants.FrameworkConstants;
import com.enums.ConfigProperties;
import com.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {

    /**
     * Private constructor to avoid external instantiation
     */
    private Driver(){}

    /**
     * Init Driver before test
     * @param browser value will be passed from BaseTest, Values can be chrome and firefox
     */
    public static void initDriver(String browser){
        if(Objects.isNull(DriverManager.getDriver())){
            if(browser.equalsIgnoreCase("chrome")){
//                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
//                WebDriver driver = new ChromeDriver();
//                DriverManager.setDriver(driver);

                /**
                 * Use WebDriverManager - can handle different kind OS and browser version
                 */
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());

            } else if(browser.equalsIgnoreCase("firefox")){
//                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckoDriverPath());
//                WebDriver driver = new FirefoxDriver();
//                DriverManager.setDriver(driver);

                /**
                 * Use WebDriverManager - can handle different kind OS and browser version
                 */
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }
        }
        DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        /*When use Json file for data*/
//        DriverManager.getDriver().get(JsonUtils.get(ConfigProperties.URL));
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
