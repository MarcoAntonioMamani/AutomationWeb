package PageObjects;

import Definitions.CurrentWebDriver;
import Definitions.Hooks;
import Support.CElement;
import Support.UtilsBrowser;
import Support.waitUntilElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static Uix.CapturarTarjetaLct.fechaExpiracion;
import static Uix.CapturarTarjetaUix.*;
public class CapturarDatosTarjetaPage {


    public static String cardNumber;
    public static String codigoCvv;
    public static String fechaExpiracionMes;
    public static String fechaExpiracionAnio;
    public static String limiteCredito;


    public void CambiarVentana(){
        Set<String> indetificadores= Hooks.getDriver().getWindowHandles();
        for(String identificador: indetificadores){
            Hooks.getDriver().switchTo().window(identificador);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void cerrarVentana(){
       Hooks.getDriver().close();
        if (UtilsBrowser.Browser.equals("firefox")){
            CambiarVentana();
        }else{
            Hooks.getDriver().switchTo().window("");
        }

    }
    public void leerNumeroTarjeta() throws Exception {
        cardNumber=obtenerValor(txtCardNumber,"Card Number:-");
    }

    public void leerCodigoCvv() throws Exception {
        codigoCvv=obtenerValor(txtCodigoCvv,"CVV:-");
    }
    public void leerFechaExpiracion() throws Exception {
       /* private WebDriverWait wait;
        wait=new WebDriverWait(Hooks.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(txtFechaExpiracion.));
*/
        waitUntilElement.isPresent(fechaExpiracion);
        String value=obtenerValor(txtFechaExpiracion,"Exp:-");
        fechaExpiracionMes=value.substring(0,value.indexOf("/"));
        fechaExpiracionAnio=value.substring(value.indexOf("/")+1,value.length());
    }
    public void leerMontoLimite() throws Exception {
        limiteCredito=obtenerValor(txtLimiteCredito,"$");
    }

    public String obtenerValor(CElement element, String texto) throws Exception {

       return  element.getText().replace(texto,"").trim();
    }
}
