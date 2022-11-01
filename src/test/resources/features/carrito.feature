Feature:  Comprar articulo con una tarjeta de Credito


  Background:
        Given  la pagina esta estable
        When doy click en generar tarjeta
        And capturamos datos de la tarjeta

  Scenario: Comprar solo un producto
    And doy clic en check Credit
    And ingreso el dato de la tarjeta y doy clic
    Then puedo capturar los mensajes de balance de tarjeta "Check Credit Balance"
    And capturo el mensaje de "This Card Not Any Transactions"


  Scenario Outline: Cuando Realizo una compra de productos

    And Seleccionamos la cantidad "<cant>" as comprar
    And hacemos click en comprar
    And  validamos datos de la tarjeta
    Then Valido el pago exitoso "Payment successfull!"
    Examples:
      | cant     |
      | 1        |
      | 9        |
      | 4        |
