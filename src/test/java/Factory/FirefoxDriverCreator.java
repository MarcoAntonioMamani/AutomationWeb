package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class FirefoxDriverCreator extends WebDriverCreator{
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        //System.setProperty("webdriver.gecko.driver","resource/geckodriver.exe");
        return new FirefoxDriver();
    }
}
