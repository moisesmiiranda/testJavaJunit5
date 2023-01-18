package cashRegister;

import client.Client;
import compra.Sale;
import lombok.Builder;
import salesman.Salesman;

import java.math.BigDecimal;

@Builder(toBuilder = true)
public class CashRegister {
    private final Sale sale;
    private final BigDecimal amountReceived;
    private final Salesman salesman;
    private final Client client;
}
