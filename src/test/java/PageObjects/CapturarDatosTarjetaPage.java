package PageObjects;

import Definitions.Hooks;
import Support.CElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;
import static Uix.CapturarTarjetaUix.*;
public class CapturarDatosTarjetaPage {


    public static String cardNumber;
    public static String codigoCvv;
    public static String fechaExpiracionMes;
    public static String fechaExpiracionAnio;
    public static String limiteCredito;


    public void CambiarVentana(){
        Set<String> indetificadores= Hooks.driver.getWindowHandles();
       // int ventana=0;
        for(String identificador: indetificadores){

            Hooks.driver.switchTo().window(identificador);
        //    ventana++;
             //  System.out.println(ventana+":"+identificador+"   ");
            //   System.out.println("Lenght = "+indetificadores.size());
        }
    }

    public void cerrarVentana(){
        Hooks.driver.close();
        Hooks.driver.switchTo().window("");
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
