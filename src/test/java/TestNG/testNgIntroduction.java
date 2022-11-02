package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testNgIntroduction {

    private String url="https://demoqa.com/";
    WebDriver driver;


    @BeforeTest
    public void setBaseUrl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }


    @Test
    public void titleTest(){

        String expectedTitle="ToolsQA";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void urlTest(){

        String actionUrl=driver.getCurrentUrl();
        Assert.assertEquals(actionUrl,url);
    }

    @AfterTest
    public void closeSession(){
        driver.quit();
    }

}
