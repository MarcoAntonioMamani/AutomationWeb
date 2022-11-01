package Definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hooks {

    public static WebDriver driver;  //Variable para conectar con los drivers "ChromeDriver"

    @Before
    public static void setUp(){  //Metodo antes de que inicie

        Map<String, Object> prefs = new HashMap<String, Object>();

        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

         options.addArguments("--disable-popup-blocking");
        //options.addArguments("--disable-extensions");
       // options.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().config().setClearResolutionCache(false);
        WebDriverManager.chromedriver().config().setClearDriverCache(false);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();




    }



    @After  //Despues de ejecutar todas las pruebas se ejecuta este metodo
    public static void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failed");
        }

        driver.manage().deleteAllCookies();
        driver.close();

    }

    public static  WebDriver getDriver(){
        return driver;
    }



}
