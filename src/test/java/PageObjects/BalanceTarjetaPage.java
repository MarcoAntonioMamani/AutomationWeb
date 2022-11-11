package PageObjects;


import Support.waitUntilElement;

import static Uix.BalanceTarjetaLct.anyTransaction;
import static Uix.BalanceTarjetaUix.txtAnyTransaction;
import static Uix.BalanceTarjetaUix.txtCreditBalance;

public class BalanceTarjetaPage {

    public void capturarMensajeBalance(String mensaje){
        txtCreditBalance.isEquals(mensaje);
    }
    public void capturarAnyTransaction(String mensaje) throws Exception {
        waitUntilElement.isPresent(anyTransaction);
        txtAnyTransaction.isEquals(mensaje);
    }
}
