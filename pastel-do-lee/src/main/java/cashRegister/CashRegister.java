package cashRegister;

import client.Client;
import dataBase.DataBase;
import purchase.Purchase;
import lombok.Builder;
import sale.Sale;
import salesman.Salesman;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public class CashRegister {
    private final Purchase purchase;
    private final BigDecimal amountReceived;
    private final Salesman salesman;
    private final Client client;

    public void completSale() {
        var purchaseValue = purchase.getTotal();

        var cashback = purchaseValue.subtract(purchaseValue);

        var sale = Sale.builder()
                .purchaseValue(purchaseValue)
                .cashback(cashback)
                .salesman(salesman)
                .client(client)
                .build();

        DataBase.addSale(sale);
    }
}
