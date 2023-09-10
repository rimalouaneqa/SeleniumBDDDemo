package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class Hooks {
    private Logger LOG = LoggerFactory.getLogger(Hooks.class);
    public static WebDriver driver;
    @Before
    public void setup(Scenario scenario){

        LOG.info("Scenario:"+scenario.getName());
       String osName= System.getProperty("os.name");
       if(osName.toUpperCase().contains("WINDOWS")){
           // WebDriverManager.chromedriver().setup();
           System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--start-maximized");
           options.addArguments("--disable-popup-blocking");
           options.addArguments("--ignore-certificate-errors");
           options.addArguments("--disable-notifications");
           options.addArguments("--disable-extensions");
           options.addArguments("--disable-infobars");
           // options.addArguments("--headless");

         driver = new ChromeDriver(options);

       }else{
           System.exit(-1);
        }



    }
    @After
    public void teardown (Scenario scenario){
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()){
            scenario.attach(screenshot,"image/png","Scenario failed");

        }else{
            scenario.attach(screenshot,"image/png","Scenario passed");

        }
         driver.quit();


    }
}
