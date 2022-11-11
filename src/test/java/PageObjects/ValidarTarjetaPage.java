package PageObjects;


import org.junit.Assert;

import static  Uix.ValidarTarjeta.ValidarTarjetaUix.*;

public class ValidarTarjetaPage {

    public void obtenerTotalAComprar(){
        String Strmonto= txtmonto.getText();
        Strmonto=Strmonto.replace("$","");
        double total=Double.parseDouble(Strmonto);
        Double totalSeleccionado=CompraPage.precio*CompraPage.cantidad;
        System.out.println("totalCalculado= "+totalSeleccionado+"  totalDesplegado= "+total);
        Assert.assertEquals(total+"",totalSeleccionado+"");

    }
    public void ingresamosDatosTarjeta(){
    txtNumeroTarjeta.setText(CapturarDatosTarjetaPage.cardNumber);
    cbMesExpiracion.selectValue(Integer.parseInt(CapturarDatosTarjetaPage.fechaExpiracionMes)+"");
    cbAnioExpiracion.selectValue(Integer.parseInt(CapturarDatosTarjetaPage.fechaExpiracionAnio)+"");
    txtCvvCode.setText(CapturarDatosTarjetaPage.codigoCvv);
    btnClickPay.click();

    }
}
