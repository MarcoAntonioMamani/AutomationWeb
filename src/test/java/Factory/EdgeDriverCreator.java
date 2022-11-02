package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeDriverCreator extends WebDriverCreator{
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.edgedriver().setup();
       // System.setProperty("webdriver.gecko.driver","resource/geckodriver.exe");
        return new FirefoxDriver();
    }
}
