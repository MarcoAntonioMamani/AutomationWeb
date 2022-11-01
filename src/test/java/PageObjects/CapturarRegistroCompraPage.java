package PageObjects;

import static  Uix.ValidarTarjeta.CapturarRegistroCompraUix.*;

public class CapturarRegistroCompraPage {

    public String numeroOrden;
    public void leerPagoExitoso(String mensaje){
        txtTituloPagoExitoso.isEquals(mensaje);
    }
    public void leerNumeroOrden(){
        numeroOrden=txtNumeroOrden.getText();
    }
}
