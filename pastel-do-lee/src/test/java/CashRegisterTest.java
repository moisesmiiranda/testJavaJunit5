import compra.Item;
import compra.Sale;
import models.CashRegisterModel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CashRegisterTest {
    @Test
    public void mustRegisterTheSaleOnDatabase() {
        // Arrange -> is the scenario that will be set
        var pastelDeCarne = Item.builder().name("Pastel de Carne").value(new BigDecimal("7.00")).build();
        var pastelDeFlango = Item.builder().name("Pastel de Flango").value(new BigDecimal("6.50")).build();

        List<Item> listOfItens = Arrays.asList(pastelDeCarne, pastelDeFlango);

        var sale = Sale.builder().itens(listOfItens).build();

        var cashRegister = CashRegisterModel.buildScenario()
                .sale(sale)
                .amountReceived(new BigDecimal("13.50"))
                .build();


        
        // Act -> Is the call to scenario

        // Assert -> check the result of this test
    }
}
