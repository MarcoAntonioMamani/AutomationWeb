package Definitions;

import Factory.WebDriverFactory;
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

    //public static WebDriver driver;  //Variable para conectar con los drivers "ChromeDriver"

    @Before
    public static void setUp( ) throws Exception {  //Metodo antes de que inicie
        String browserType= UtilsBrowser.Browser;
        CurrentWebDriver.getInstance().setWebDriver(WebDriverFactory.getDriver(browserType,""));
        CurrentWebDriver.getInstance().getWebDriver().manage().window().maximize();
    }



    @After  //Despues de ejecutar todas las pruebas se ejecuta este metodo
    public static void tearDown(Scenario scenario){

        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot) CurrentWebDriver.getInstance().getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failed");
           // Allure.addAttachment("Failed", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

        }
        CurrentWebDriver.getInstance().getWebDriver().manage().deleteAllCookies();
        CurrentWebDriver.getInstance().getWebDriver().close();
        //driver.quit();
    }

    public static  WebDriver getDriver(){
        return CurrentWebDriver.getInstance().getWebDriver();
    }



}
