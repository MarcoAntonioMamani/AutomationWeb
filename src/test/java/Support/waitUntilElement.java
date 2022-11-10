package Support;

import Definitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Richard Lopez on 26/05/2022
 * Visit Linkedin https://www.linkedin.com/in/richard-lopez-/
 **/
public class waitUntilElement {
    public static boolean isPresent( By locator) throws Exception {

        try {
            WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
