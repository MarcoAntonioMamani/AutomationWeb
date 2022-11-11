package Support;

import Definitions.CurrentWebDriver;
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


public class Control {

    protected By locator;
    protected WebElement control;
    private WebDriverWait wait;
    public Control(By locator){
        this.locator=locator;
        wait=new WebDriverWait(Hooks.getDriver(), 30);
        PageFactory.initElements(Hooks.getDriver(),this);
    }

    public By getLocator(){
        return locator;
    }
    public void findControl()  {
        this.control= Hooks.getDriver().findElement(this.locator);
    }

    public void click()  {

        this.findControl();
        wait.until(ExpectedConditions.visibilityOf(control));
        this.control.click();
    }

    public void isEquals(String mensaje){
        this.findControl();
        wait.until(ExpectedConditions.visibilityOf(control));
        Assert.assertEquals(mensaje,control.getText());
    }
    public String getText()  {

        this.findControl();
        wait.until(ExpectedConditions.visibilityOf(control));
        try{
            Actions hover = new Actions(Hooks.getDriver());
            hover.moveToElement(control).build().perform();
        }catch (Exception e){
            ((JavascriptExecutor)Hooks.getDriver()).executeScript("arguments[0].scrollIntoView(true);", control);
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
