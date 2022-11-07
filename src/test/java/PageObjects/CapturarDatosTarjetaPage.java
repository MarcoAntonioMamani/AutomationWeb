package PageObjects;

import Definitions.CurrentWebDriver;
import Definitions.Hooks;
import Support.CElement;
import Support.UtilsBrowser;

import java.util.Set;

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
    public void leerNumeroTarjeta(){
        cardNumber=obtenerValor(txtCardNumber,"Card Number:-");
    }

    public void leerCodigoCvv(){
        codigoCvv=obtenerValor(txtCodigoCvv,"CVV:-");
    }
    public void leerFechaExpiracion(){
        String value=obtenerValor(txtFechaExpiracion,"Exp:-");
        fechaExpiracionMes=value.substring(0,value.indexOf("/"));
        fechaExpiracionAnio=value.substring(value.indexOf("/")+1,value.length());
    }
    public void leerMontoLimite(){
        limiteCredito=obtenerValor(txtLimiteCredito,"$");
    }

    public String obtenerValor(CElement element, String texto){
       return  element.getText().replace(texto,"").trim();
    }
}
