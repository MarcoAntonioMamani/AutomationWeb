package PageObjects;


import Support.waitUntilElement;

import static Uix.ViewBalanceTarjetaUix.*;

public class ViewBalanceTarjetaPage {

    public void ingresarNumeroTarjeta(String numeroTarjeta) throws Exception {
        waitUntilElement.isPresent(txtNumeroTarjeta.getLocator());
        txtNumeroTarjeta.setText(numeroTarjeta);
    }
    public void ClickBusqueda(){
        btnAccionConfirmar.click();
    }
    public void CerrarVentanaEmergente(){
        btnventanaEmergente.click();
    }
}
