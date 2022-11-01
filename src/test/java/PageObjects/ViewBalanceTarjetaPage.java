package PageObjects;


import static Uix.ViewBalanceTarjetaUix.*;

public class ViewBalanceTarjetaPage {

    public void ingresarNumeroTarjeta(String numeroTarjeta){
        txtNumeroTarjeta.setText(numeroTarjeta);
    }
    public void ClickBusqueda(){
        btnAccionConfirmar.click();
    }
    public void CerrarVentanaEmergente(){
        btnventanaEmergente.click();
    }
}
