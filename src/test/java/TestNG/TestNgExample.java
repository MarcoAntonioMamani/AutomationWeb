package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNgExample {
    WebDriver driver;

    By searchBoxLocator=By.id("search_query_top");
    By resultLocator=By.cssSelector("span.heading-counter");
    @BeforeClass
    @Parameters({"URL","BrowserType"})
    public void beforeClass(String url,String browserType){

        switch (browserType){
            case("Chrome"):
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case("Internet Explorer"):
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("openning: "+browserType);
    }



    @Test
    public void searchBlouse(){
        WebElement searchBox=driver.findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys("blouse");
        searchBox.submit();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(resultLocator));
        System.out.println("this is the result number "+driver.findElement(resultLocator).getText());
        Assert.assertTrue(driver.findElement(resultLocator).isDisplayed(),"the result number is not present");

    }

    @AfterClass
    public void afterClass(){

        driver.close();
    }


}
