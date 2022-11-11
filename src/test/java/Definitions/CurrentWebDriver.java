package Definitions;

import io.cucumber.java.de.Wenn;
import org.openqa.selenium.WebDriver;

public class CurrentWebDriver {

    private static CurrentWebDriver instance;
    private static ThreadLocal<WebDriver> webDriverThreadLocal;

    public CurrentWebDriver(){
        webDriverThreadLocal=new ThreadLocal<>();
    }
    public static CurrentWebDriver getInstance(){
        if(instance==null){
            synchronized (CurrentWebDriver.class){
                if (instance==null){
                    instance=new CurrentWebDriver();
                }
            }
        }
        return instance;
    }
    public WebDriver getWebDriver(){
        return webDriverThreadLocal.get();
    }
    public void setWebDriver(WebDriver webDriver){
        webDriverThreadLocal.set(webDriver);
    }
    public void removeWebDriver(){
        webDriverThreadLocal.remove();
    }

}
