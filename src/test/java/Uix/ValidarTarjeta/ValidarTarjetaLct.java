package Uix.ValidarTarjeta;

import org.openqa.selenium.By;

public class ValidarTarjetaLct {

    public static final By monto=By.xpath("//font[2]");
    public static final By numeroTarjeta=By.id("card_nmuber");
    public static final By mesExpiracion=By.id("month");
    public static final By anioExpiracion=By.id("year");
    public static final By cvvCode=By.id("cvv_code");
    public static final By clickPay=By.name("submit");

}
