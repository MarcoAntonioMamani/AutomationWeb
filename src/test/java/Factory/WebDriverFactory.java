package Factory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browser, String seleniumGridUrl) throws Exception {
        switch (browser){
            case "Chrome":
                ChromeDriverCreator chromeDriverCreator = new ChromeDriverCreator();
                return chromeDriverCreator.createWebDriver();
            case "firefox":
                FirefoxDriverCreator firefoxDriverCreator = new FirefoxDriverCreator();
                return firefoxDriverCreator.createWebDriver();
            case "Internet Explorer":
                EdgeDriverCreator edgeDriverCreator=new EdgeDriverCreator();
                return edgeDriverCreator.createWebDriver();
            case "chrome-remote":
                RemoteChromeDriverCreator remoteChromeDriverCreator = new RemoteChromeDriverCreator(seleniumGridUrl);
                return remoteChromeDriverCreator.createWebDriver();
            case "firefox-remote":
                RemoteFirefoxDriverCreator remoteFirefoxDriverCreator = new RemoteFirefoxDriverCreator(seleniumGridUrl);
                return remoteFirefoxDriverCreator.createWebDriver();
            case "edge-remote":
                RemoteEdgeDriverCreator remoteEdgeDriverCreator = new RemoteEdgeDriverCreator(seleniumGridUrl);
                return remoteEdgeDriverCreator.createWebDriver();
            default:
                throw new Exception("Navegador " + browser + " no soportado");
        }
    }
}
