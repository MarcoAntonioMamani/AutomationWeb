package Support;

import Definitions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Definitions.Hooks.driver;

public class Control {

    protected By locator;
    protected WebElement control;
    private WebDriverWait wait;
    public Control(By locator){
        this.locator=locator;
        wait=new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void findControl()  {
        this.control= driver.findElement(this.locator);
    }

    public void click()  {

        this.findControl();
        wait.until(ExpectedConditions.elementToBeClickable(control));
        this.control.click();
    }

    public void isEquals(String mensaje){
        this.findControl();
        wait.until(ExpectedConditions.elementToBeClickable(control));
        Assert.assertEquals(mensaje,control.getText());
    }
    public String getText()  {

        this.findControl();
        wait.until(ExpectedConditions.visibilityOf(control));
        try{
            Actions hover = new Actions(driver);
            hover.moveToElement(control).build().perform();
        }catch (Exception e){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", control);
        }
        return this.control.getText();
    }

    public void setText(String elemento)  {
        this.findControl();
        wait.until(ExpectedConditions.elementToBeClickable(control));
        this.control.click();
        this.control.clear();
        this.control.sendKeys(elemento);
    }
    public void selectValue(String value){
        this.findControl();
        wait.until(ExpectedConditions.elementToBeClickable(control));
        Select controlSelect=new Select(control);
        controlSelect.selectByValue(value);
    }
    public String getContentText()  {
        this.findControl();
        wait.until(ExpectedConditions.elementToBeClickable(control));
        return this.control.getAttribute("content-desc");
    }

    public String getTextAttribute(String attribute)  {
        this.findControl();
        wait.until(ExpectedConditions.elementToBeClickable(control));
        return this.control.getAttribute(attribute);
    }

    public boolean isDisplayedControl(){
        try {
            this.findControl();
            wait.until(ExpectedConditions.elementToBeClickable(control));
            return this.control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
