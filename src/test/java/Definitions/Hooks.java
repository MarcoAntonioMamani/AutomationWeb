package Definitions;

import Support.UtilsBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class Hooks {

    public static WebDriver driver;  //Variable para conectar con los drivers "ChromeDriver"

    @Before
    public static void setUp( ) {  //Metodo antes de que inicie
        String browserType= UtilsBrowser.Browser;
     /*   Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

         options.addArguments("--disable-popup-blocking");
        //options.addArguments("--disable-extensions");
       // options.addArguments("--disable-notifications");*/
        switch (browserType) {
            case ("Chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions());
                break;
            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions());
                break;
            case ("Internet Explorer"):
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(new EdgeOptions());
                break;
        }
        driver.manage().window().maximize();




    }



    @After  //Despues de ejecutar todas las pruebas se ejecuta este metodo
    public static void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failed");
           // Allure.addAttachment("Failed", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        }
        driver.manage().deleteAllCookies();
        driver.close();
        //driver.quit();
    }

    public static  WebDriver getDriver(){
        return driver;
    }



}