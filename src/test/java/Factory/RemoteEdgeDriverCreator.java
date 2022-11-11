package Factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
public class RemoteEdgeDriverCreator extends WebDriverCreator  {


    private String url;

    public RemoteEdgeDriverCreator(String url){
        this.url = url;
    }

    @Override
    public WebDriver createWebDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL(url),new EdgeOptions());
    }
}
