package Support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class onClick {

    private WebDriver driver;
    private WebDriverWait wait;

    public onClick(WebDriver d){
        driver=d;
        wait=new WebDriverWait(driver, 20);
        PageFactory.initElements(driver,this);

    }

    public void action(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


}
