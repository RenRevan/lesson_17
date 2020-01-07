package POM_proj;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class CreateDriver {
    private WebDriver driver;

    private Properties properties;
    private final String propertyFilePath= "C:\\Users\\Ирен\\IdeaProjects\\lesson17\\src\\main\\resources\\Configuration.properties";


    private void ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getChromeDriverPath() {
        String path = properties.getProperty("chromeDriverPath");
        if(path != null) return path;
        else throw new RuntimeException("path not specified in the Configuration.properties file.");
    }

@BeforeClass
public WebDriver runDriver(DriverType browser)  {
        ConfigFileReader();
       switch (browser.ordinal()){
           //Chrome
           case (0):
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;
               //Firefox
           case (1):
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
               break;
               //IE
           case (2):
               WebDriverManager.iedriver().setup();
               driver = new InternetExplorerDriver();
               break;
       }

        driver.get(getApplicationUrl()+"/");
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;

    }
}