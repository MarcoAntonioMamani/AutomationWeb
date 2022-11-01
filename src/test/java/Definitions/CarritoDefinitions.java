package Definitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarritoDefinitions {


     MenuPage menuPage;
     CapturarDatosTarjetaPage capturarDatosTarjetaPage;
     ViewBalanceTarjetaPage viewBalanceTarjetaPage;
     BalanceTarjetaPage balanceTarjetaPage;
     CompraPage compraPage=new CompraPage();
     ValidarTarjetaPage validarTarjetaPage=new ValidarTarjetaPage();
     CapturarRegistroCompraPage capturarRegistroCompraPage=new CapturarRegistroCompraPage();
    public CarritoDefinitions(){
         menuPage=new MenuPage();
         capturarDatosTarjetaPage=new CapturarDatosTarjetaPage();
         viewBalanceTarjetaPage=new ViewBalanceTarjetaPage();
         balanceTarjetaPage=new BalanceTarjetaPage();
     }

    @Given("la pagina esta estable")
    public void laPaginaEstaEstable() {
        Hooks.getDriver().get("https://demo.guru99.com/payment-gateway/index.php");

    }

    @When("doy click en generar tarjeta")
    public void douClickEnGenerarTarjeta() {
         menuPage.clickGenerarTarjeta();
    }

    @And("capturamos datos de la tarjeta")
    public void capturamosDatosDeLaTarjeta() {
         capturarDatosTarjetaPage.CambiarVentana();
         capturarDatosTarjetaPage.leerCodigoCvv();
         capturarDatosTarjetaPage.leerNumeroTarjeta();
         capturarDatosTarjetaPage.leerFechaExpiracion();
         capturarDatosTarjetaPage.leerMontoLimite();
         capturarDatosTarjetaPage.cerrarVentana();
    }

    @When("doy clic en check Credit")
    public void doyClicEnCheckCredit() {
         menuPage.clickCheckCreditCar();
         Hooks.getDriver().get("https://demo.guru99.com/payment-gateway/check_credit_balance.php");
    }

    @And("ingreso el dato de la tarjeta y doy clic")
    public void ingresoElDatoDeLaTarjetaYDoyClic() {
        viewBalanceTarjetaPage.ingresarNumeroTarjeta(capturarDatosTarjetaPage.cardNumber);
        viewBalanceTarjetaPage.ClickBusqueda();
    }

    @Then("puedo capturar los mensajes de balance de tarjeta {string}")
    public void puedoCapturarLosMensajesDeBalanceDeTarjeta(String mensaje) {
        balanceTarjetaPage.capturarMensajeBalance(mensaje);
    }

    @And("capturo el mensaje de {string}")
    public void capturoElMensajeDe(String mensaje) {
        balanceTarjetaPage.capturarAnyTransaction(mensaje);
    }

    @And("Seleccionamos la cantidad {string} as comprar")
    public void seleccionamosLaCantidadAsComprar(String cantidad) {
        compraPage.obtenerPrecio();
        compraPage.SeleccionarCantidad(cantidad);
    }

    @And("hacemos click en comprar")
    public void hacemosClickEnComprar()  {
        compraPage.clickComprar();

    }

    @Then("validamos datos de la tarjeta")
    public void validamosDatosDeLaTarjeta() {
        validarTarjetaPage.obtenerTotalAComprar();
        validarTarjetaPage.ingresamosDatosTarjeta();
    }

    @Then("Valido el pago exitoso {string}")
    public void validoElPagoExitoso(String mensaje) {
        capturarRegistroCompraPage.leerPagoExitoso(mensaje);
        capturarRegistroCompraPage.leerNumeroOrden();
    }
}
