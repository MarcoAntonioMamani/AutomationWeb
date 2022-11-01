package PageObjects;

import Uix.ComprarUix;

import static Uix.ComprarUix.*;

public class CompraPage {

    public static Double cantidad;
    public static Double precio;
    public void obtenerPrecio(){
        String monto=txtPrecio.getText().replace("Price: $","");
        precio=Double.parseDouble(monto);
    }
    public void SeleccionarCantidad(String value){
        cbSeleccionarCantidad.selectValue(value);
        cantidad=Double.parseDouble(value);

    }
    public void clickComprar(){
        btnClickComprar.click();
    }
}
