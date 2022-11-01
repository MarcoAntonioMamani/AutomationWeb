package Uix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CapturarTarjetaLct {


    public static final By cardNumber=By.xpath("//h4[1]");
    public static final By codigoCvv=By.xpath("//h4[2]");
    public static final By fechaExpiracion=By.xpath("//h4[3]");
    public static final By LimiteCredito=By.xpath("//h4[4]/span");
}
