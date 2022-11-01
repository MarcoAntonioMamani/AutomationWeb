package Uix.ValidarTarjeta;

import Support.CElement;

import static Uix.ValidarTarjeta.ValidarTarjetaLct.*;

public class ValidarTarjetaUix {
    public static final CElement txtmonto=new CElement(monto);
    public static final CElement txtNumeroTarjeta=new CElement(numeroTarjeta);
    public static final CElement cbMesExpiracion=new CElement(mesExpiracion);
    public static final CElement cbAnioExpiracion=new CElement(anioExpiracion);
    public static final CElement txtCvvCode=new CElement(cvvCode);
    public static final CElement btnClickPay=new CElement(clickPay);
}
