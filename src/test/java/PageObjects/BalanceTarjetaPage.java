package PageObjects;


import static Uix.BalanceTarjetaUix.txtAnyTransaction;
import static Uix.BalanceTarjetaUix.txtCreditBalance;

public class BalanceTarjetaPage {

    public void capturarMensajeBalance(String mensaje){
        txtCreditBalance.isEquals(mensaje);
    }
    public void capturarAnyTransaction(String mensaje){
        txtAnyTransaction.isEquals(mensaje);
    }
}
