import dataBase.DataBase;
import org.junit.jupiter.api.Assertions;
import purchase.Item;
import purchase.Purchase;
import models.CashRegisterModel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CashRegisterTest {
    @Test
    public void mustRegisterTheSaleOnDatabase() {
        // Arrange -> is the scenario that will be set
        var pastelDeCarne = Item.builder().name("Pastel de Carne").value(new BigDecimal("7.00")).build();
        var pastelDeFlango = Item.builder().name("Pastel de Flango").value(new BigDecimal("6.50")).build();

        List<Item> listOfItens = Arrays.asList(pastelDeCarne, pastelDeFlango);

        var sale = Purchase.builder().itens(listOfItens).build();

        var cashRegister = CashRegisterModel.buildScenario()
                .purchase(sale)
                .amountReceived(new BigDecimal("13.50"))
                .build();

        // Act -> Is the call to scenario

        cashRegister.completSale();

        // Assert -> check the result of this test

        Assertions.assertEquals(1, DataBase.sales.size());
        Assertions.assertEquals(new BigDecimal("13.50"), DataBase.sales.get(0).getPurchaseValue());
        Assertions.assertEquals(new BigDecimal("00.00"), DataBase.sales.get(0).getCashback());
        Assertions.assertEquals("Jet Li", DataBase.sales.get(0).getSalesman().getName());
        Assertions.assertEquals("Bruce Lee", DataBase.sales.get(0).getClient().getName());
        Assertions.assertEquals(LocalDate.now(), DataBase.sales.get(0).getDateOfSale());

    }

    public void notMustSaveSaleWhenTheValueReceivedLessThenTotalValue() {

    }
}
